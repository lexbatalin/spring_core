//package kz.spring.database.dao.impl;
//
//import kz.spring.database.dao.intereface.MP3Dao;
//import kz.spring.database.objects.MP3;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Component("sqliteMp3NamedDao")
//public class SqliteMp3NamedDao implements MP3Dao {
//
//    private NamedParameterJdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//    }
//
//    @Override
//    public void insert(MP3 mp3) {
//        String sqlQuery = "insert into track (name, author_id) values (:name, :author_id)";
//
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("name", mp3.getName());
//        params.addValue("author_id", mp3.getAuthor());
//
//        jdbcTemplate.update(sqlQuery, params);
//    }
//
//    @Override
//    public void delete(MP3 mp3) {
//        String sqlQuery = "delete from track where id = :id";
//
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("id", mp3.getId());
//
//        jdbcTemplate.update(sqlQuery, params);
//    }
//
//    @Override
//    public MP3 getMP3ById(int id) {
//        String sqlQuery = "select * from track where id = :id";
//
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("id", id);
//
//        return jdbcTemplate.queryForObject(sqlQuery, params, new Mp3RowMapperParams());
//    }
//
//    @Override
//    public List<MP3> getMP3ListByName(String name) {
//        String sqlQuery = "select * from track where name like :name";
//
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("name", "%" + name + "%");
//
//        return jdbcTemplate.query(sqlQuery, params, new Mp3RowMapperParams());
//    }
//
//
//    @Override
//    public List<MP3> getMP3ListByAuthor(String author_id) {
//        String sqlQuery = "select * from track where author_id like :author_id";
//        return jdbcTemplate.query(
//                sqlQuery,
//                new MapSqlParameterSource().addValue("author_id", "%" + author_id + "%"),
//                (rs, rowNum) -> new MP3(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getInt("author_id")
//                )
//        );
//    }
//
//    public int getMp3Count() {
//        String sqlQuery = "select count(*) from track";
//        return jdbcTemplate.getJdbcOperations().queryForObject(sqlQuery, Integer.class);
//    }
//
//    private static final class Mp3RowMapperParams implements RowMapper<MP3> {
//
//        @Override
//        public MP3 mapRow(ResultSet rs, int i) throws SQLException {
//            MP3 mp3 = new MP3();
//            mp3.setId(rs.getInt("id"));
//            mp3.setName(rs.getString("name"));
//            mp3.setAuthor(rs.getInt("author_id"));
//            return mp3;
//        }
//    }
//
//    @Override
//    public int insertList(List<MP3> mp3List) {
//        return 0;
//    }
//}
