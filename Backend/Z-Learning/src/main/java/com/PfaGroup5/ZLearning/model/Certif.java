package com.PfaGroup5.ZLearning.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
@Data
@Document
public class Certif {
    @Id
    String id;
    @Indexed(unique = true)
    String name;
    String description;
    @Field( name ="image")
    String mainImagePath;
    Double price;
    String categoryName;

}
