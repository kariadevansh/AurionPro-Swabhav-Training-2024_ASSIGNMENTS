package com.apro.assignment.test;

import java.util.ArrayList;
import java.util.List;

import com.apro.assignment.model.Task;

public class PriorityQueueTaskExample {

	public static void main(String[] args) {
		List<Task> queue = new ArrayList<>();
		
		insertTask(queue, new Task("Task A", 3));
		insertTask(queue, new Task("Task B", 1));
		insertTask(queue, new Task("Task C", 2));
		insertTask(queue, new Task("Task D", 5));
		insertTask(queue, new Task("Task E", 4));

		System.out.println("PriorityQueue elements:");
		while (!queue.isEmpty()) {
			Task task = removeHighestPriorityTask(queue);
			System.out.println("Task: " + task.getDescription() + ", Priority: " + task.getPriority());
		}
	}

	static void insertTask(List<Task> queue, Task task) {
		int i = 0;
		while (i < queue.size() && queue.get(i).getPriority() >= task.getPriority()) {
			i++;	
		}
		queue.add(i, task);
	}

	static Task removeHighestPriorityTask(List<Task> queue) {
		if (!queue.isEmpty()) {
			return queue.remove(0);
		}
		return null;
	}
}
