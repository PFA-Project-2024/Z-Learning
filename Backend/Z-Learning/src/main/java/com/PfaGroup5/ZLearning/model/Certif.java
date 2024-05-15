package com.PfaGroup5.ZLearning.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.w3c.dom.ranges.Range;

import java.util.Date;

@Data
@Document
public class Certif {
    @Id
    String id;
    @Indexed(unique = true)
    String title;
    String description;
    @Field( name ="image")
    String mainImagePath;
    Double price;
    Date startDate;
    String instructorName;
    Date endDate;
    String categoryName;
    Double rating;
    String URL;

}
