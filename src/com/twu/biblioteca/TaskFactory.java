package com.twu.biblioteca;

public class TaskFactory {
    public Task getRequestedTask(String option) throws Exception {

        switch (option){
            case "a":
                return new ViewMovieLister();
            default:
                throw new Exception("invalid option");
        }

    }
}
