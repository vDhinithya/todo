package com.app.todo.Controller;

import com.app.todo.Service.TaskService;
import com.app.todo.models.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller// it contains all the endpoints
//@RestController("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks(); // this method getAllTasks is there in service
        model.addAttribute("tasks",tasks);
        return "tasks"; // this will look for tasks.html, since here thymeleaf is used we have to return the name template that we have to render
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        taskService.createTask(title); // create a task with the title given

        return "redirect:/"; // to refresh the page
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable String id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable String id){
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
