package dev.iratherfear.jdbctest.model;

public class Course {
    private int courseId;
    private String title;
    private String description;
    private String link;
    
    public Course() {
    }

    public Course(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course{");
        sb.append("courseId=").append(courseId);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", link=").append(link);
        sb.append('}');
        return sb.toString();
    }  
}
