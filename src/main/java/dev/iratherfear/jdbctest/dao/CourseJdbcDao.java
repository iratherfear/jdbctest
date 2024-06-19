package dev.iratherfear.jdbctest.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import dev.iratherfear.jdbctest.model.Course;

@Component
public class CourseJdbcDao implements DAO<Course>{

    private static final Logger logger = LoggerFactory.getLogger(CourseJdbcDao.class);
    private JdbcTemplate jdbcTemplate;

    public CourseJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Course> rowMapper = (rs, rowNum) -> {
        Course course = new Course();

        course.setCourseId(rs.getInt("course_id"));
        course.setTitle(rs.getString("title"));
        course.setDescription(rs.getString("description"));
        course.setLink(rs.getString("link"));

        return course;
    };

    @Override
    public List<Course> list() {
        String sql = "SELECT course_id, title, description, link FROM Course";
        // return jdbcTemplate.query(sql, rowMapper);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(Course course) {
        String sql = "INSERT INTO Course(title, description, link) VALUES(?, ?, ?)";
        int inserted = jdbcTemplate.update(sql, course.getTitle(), course.getDescription(), course.getLink());   
        if(inserted == 1) {
            System.out.println("New course was created: " + course.getTitle());
        }
    }

    @Override
    public Optional<Course> get(int id) {
        String sql = "SELECT course_id, title, description, link from Course WHERE  course_id = ?";
        Course course = null;

        try {
            course = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper); 
        } catch(DataAccessException e) {
            logger.info("Course not found for id: " + id);
        }
        
        return Optional.ofNullable(course);
    }

    @Override
    public void update(Course course, int id) {
        String sql = "UPDATE Course SEt title = ?, description = ?, link = ? WHERE course_id = ?";
        int update = jdbcTemplate.update(sql, course.getTitle(), course.getDescription(), course.getLink(), course.getCourseId());
        if(update == 1) {
            logger.info("Course updated: " + course.getTitle());
        }   
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Course WHERE course_id = ?";
        jdbcTemplate.update(sql, id);
    }

}
