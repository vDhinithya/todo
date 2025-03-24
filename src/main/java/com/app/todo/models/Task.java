package com.app.todo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//here the structure will be defined

@Document(collection = "tasks") // this will create a collection named "tasks" in MongoDb
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private  String id;
    private String title;
    private boolean completed;
}
