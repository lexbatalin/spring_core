//package kz.spring.database.dao.impl;
//
//import kz.spring.database.dao.intereface.MP3Dao;
//import kz.spring.database.objects.MP3;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//@Component("sqliteMp3Dao")
//public class SqliteMp3Dao implements MP3Dao {
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public void insert(MP3 mp3) {
//        String sqlQuery = "insert into track (name, author_id) values (?, ?)";
//        jdbcTemplate.update(sqlQuery, mp3.getName(), mp3.getAuthor());
//    }
//
//    @Override
//    public void delete(MP3 mp3) {
//        String sqlQuery = "delete from track where id = ?";
//        jdbcTemplate.update(sqlQuery, mp3.getId());
//    }
//
//    @Override
//    public MP3 getMP3ById(int id) {
//        String sqlQuery = "select * from track where id = ?";
//        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new Mp3RowMapper());
//    }
//
//    @Override
//    public List<MP3> getMP3ListByName(String name) {
//        String sqlQuery = "select * from track where name = '" + name +"'";
//        return jdbcTemplate.query(sqlQuery, new Mp3RowMapper());
//    }
//
//    @Override
//    public List<MP3> getMP3ListByAuthor(String author_id) {
//        String sqlQuery = "select * from track where author_id = '" + author_id + "'";
//        return jdbcTemplate.query(
//                sqlQuery,
//                (rs, rowNum) -> new MP3(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getInt("author_id")
//                )
//        );
//    }
//
//    @Override
//    public int insertList(List<MP3> mp3List) {
//        return 0;
//    }
//
//    @Override
//    public int getMp3Count() {
//        return 0;
//    }
//}
