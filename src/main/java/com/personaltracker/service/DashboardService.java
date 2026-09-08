package com.personaltracker.service;

import com.personaltracker.model.Expense;
import com.personaltracker.model.Habit;
import com.personaltracker.model.Goal;
import com.personaltracker.model.TaskItem;
import com.personaltracker.repository.ExpenseRepository;
import com.personaltracker.repository.HabitRepository;
import com.personaltracker.repository.GoalRepository;
import com.personaltracker.repository.TaskItemRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    private final ExpenseRepository expenseRepository;
    private final HabitRepository habitRepository;
    private final GoalRepository goalRepository;
    private final TaskItemRepository taskRepository;

    public DashboardService(ExpenseRepository expenseRepository,
                            HabitRepository habitRepository,
                            GoalRepository goalRepository,
                            TaskItemRepository taskRepository) {
        this.expenseRepository = expenseRepository;
        this.habitRepository = habitRepository;
        this.goalRepository = goalRepository;
        this.taskRepository = taskRepository;
    }

    public Map<String, Object> getMetrics() {
        List<Expense> expenses = expenseRepository.findAll();
        List<Habit> habits = habitRepository.findAll();
        List<Goal> goals = goalRepository.findAll();
        List<TaskItem> tasks = taskRepository.findAll();

        double totalIncome = expenses.stream()
                .filter(e -> "INCOME".equalsIgnoreCase(e.getType()))
                .mapToDouble(e -> e.getAmount() != null ? e.getAmount() : 0.0)
                .sum();

        double totalExpense = expenses.stream()
                .filter(e -> "EXPENSE".equalsIgnoreCase(e.getType()))
                .mapToDouble(e -> e.getAmount() != null ? e.getAmount() : 0.0)
                .sum();

        int maxStreak = habits.stream()
                .mapToInt(Habit::getStreak)
                .max()
                .orElse(0);

        long habitsDoneToday = habits.stream()
                .filter(Habit::isCompletedToday)
                .count();

        int avgGoalProgress = goals.isEmpty() ? 0 :
                (int) goals.stream().mapToInt(Goal::getProgress).average().orElse(0.0);

        long completedTasks = tasks.stream()
                .filter(TaskItem::isCompleted)
                .count();

        Map<String, Object> metrics = new HashMap<>();
        metrics.put("totalIncome", totalIncome);
        metrics.put("totalExpense", totalExpense);
        metrics.put("netSavings", totalIncome - totalExpense);
        metrics.put("savingsRate", totalIncome > 0 ? ((totalIncome - totalExpense) / totalIncome) * 100 : 0);
        metrics.put("maxStreak", maxStreak);
        metrics.put("habitsDoneToday", habitsDoneToday);
        metrics.put("totalHabits", habits.size());
        metrics.put("avgGoalProgress", avgGoalProgress);
        metrics.put("totalGoals", goals.size());
        metrics.put("completedTasks", completedTasks);
        metrics.put("totalTasks", tasks.size());

        return metrics;
    }
}
