import java.util.*;
class Project {
    String name;
    String status;
    int timeTaken;
    public Project(String name, String status, int timeTaken) {
        this.name = name;
        this.status = status;
        this.timeTaken = timeTaken;
    }
    public String getStatus()
    {
        return status;
    }

    public int getTimeTaken()
    {
        return timeTaken;
    }
}

class Student {
    String name;
    List<Project> projects;
    public Student(String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }
    public List<Project> getProjects() {
        return projects;
    }
}
public class ProjectList {
    public static void main(String[] args) {
        Project project1 = new Project("Project 1", "On time", 10);
        Project project2 = new Project("Project 2", "Late", 15);
        Project project3 = new Project("Project 3", "Early", 7);

        List<Project> student1Projects = new ArrayList<>();
        student1Projects.add(project1);
        student1Projects.add(project2);
        student1Projects.add(project3);

        Student student1 = new Student("Alice", student1Projects);
        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;
        double totalTimeTaken = 0;
        List<Project> projects = student1.getProjects();
        for (Project project : projects)
        {
            if (project.getStatus().equals("On time"))
            {
                onTimeCount++;
            } 
            else if (project.getStatus().equals("Late"))
            {
                lateCount++;
            } 
            else if (project.getStatus().equals("Early"))
            {
                earlyCount++;
            }
            totalTimeTaken += project.getTimeTaken();
        }
        double averageTimeTaken = totalTimeTaken / projects.size();
        System.out.println("Number of projects completed on time: " + onTimeCount);
        System.out.println("Number of projects completed late: " + lateCount);
        System.out.println("Number of projects completed early: " + earlyCount);
        System.out.println("Average time taken per project: " + averageTimeTaken);
    }
}
