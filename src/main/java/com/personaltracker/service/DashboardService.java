package com.personaltracker.Service;

import com.personaltracker.Model.Expense;
import com.personaltracker.Model.Goal;
import com.personaltracker.Model.Habit;
import com.personaltracker.Model.TaskItem;
import com.personaltracker.Repository.ExpenseRepository;
import com.personaltracker.Repository.GoalRepository;
import com.personaltracker.Repository.HabitRepository;
import com.personaltracker.Repository.TaskItemRepository;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

        
        private final ExpenseRepository expenseReposit
        private final HabitRepository habitRepositor
        private final GoalRepository goalRepository;

        
                        ExpenseRepository expenseReposit
                        HabitRepository habitRepositor
                        GoalRepository goalRepository,
                                    TaskItemRepository task
                this.expenseRepository = expenseReposit
                this.habitRepository = habitRepositor
                this.goalRepository = goalRepository;
         

        
                ic Map<String, Object> getMetrics() {
                List<Expense> expenses = expenseRepository.find
                List<Habit> habits = habitRepository.findAll
                List<Goal> goals = goalRepository.findAll();

                
                                otalIncome = expenses.stream()
                                .filter(e -> "INCOME".equalsIgnoreCase(e.getType()))
                                .mapToD

                
                                otalExpense = expenses.stream()
                                .filter(e -> "EXPENSE".equalsIgnoreCase(e.getType()))
                                .mapToD

                
                                treak = habits.stream()
                                .mapTo
                                .max()

                
                                itsDoneToday = habits.stream()
                                .filter(H

                
                                 oalProgress = goals.isEmpty() ? 0 :

                
                                pletedTasks = tasks.stream()
                                .filter(T

                
                Map<String, Object> metrics = new HashMa
                metrics.put("totalIncome", totalIncome);
                metrics.put("totalExpense", totalExpense);
                metrics.put("netSavings", totalIncome - totalExpense);
                metrics.put("savingsRate", totalInco
                metrics.put("maxStreak", maxStreak);
                metrics.put("habitsDoneToday", habitsDoneT
                metrics.put("totalHabits", habits.size());
                metrics.put("avgGoalProgress", avgGoalPr
                metrics.put("totalGoals", goals.size());
                metrics.put("completedTasks", completedT

                
            return metrics;
    }
}
