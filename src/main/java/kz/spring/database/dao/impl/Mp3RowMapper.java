//package kz.spring.database.dao.impl;
//
//import kz.spring.database.objects.MP3;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class Mp3RowMapper implements RowMapper<MP3> {
//
//    @Override
//    public MP3 mapRow(ResultSet rs, int i) throws SQLException {
//
//        MP3 song = new MP3();
//        song.setId(rs.getInt("id"));
//        song.setName(rs.getString("name"));
//        song.setAuthor(rs.getInt("author_id"));
//        return song;
//    }
//}
