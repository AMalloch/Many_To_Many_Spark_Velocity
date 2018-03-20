package controllers;

import db.DBCourse;
import db.Seeds;
import models.Course;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class CoursesController {
    public static void main(String[] args) {
        Seeds.seedData();

        get("/courses", (req, res) -> {
            List<Course> courses = DBCourse.getCourses(Course.class);
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/courses/index.vtl");
            model.put("courses", courses);
            return new ModelAndView(model, "templates/layout.vtl");
        },  new VelocityTemplateEngine());
    }
}
