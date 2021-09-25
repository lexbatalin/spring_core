package kz.spring.database.dao.impl;

import kz.spring.database.dao.intereface.MP3Dao;
import kz.spring.database.objects.Author;
import kz.spring.database.objects.MP3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component("sqliteMp3SimpleWithViewDao")
public class SqliteMp3SimpleWithViewDao implements MP3Dao {

    private static final String VIEW_TABLE = "mp3_view";


    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public int insert(MP3 mp3) {

        String sqlInsertAuthor = "insert into author (name) values (:author_name)";

        Author author = mp3.getAuthor();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("author_name", author.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(sqlInsertAuthor, params, keyHolder);

        int author_id = keyHolder.getKey().intValue();

        // неверное имя поля чтобы отменилась транзакция
        String sqlInsertMp3 = "insert into track (author_id, name) values (:author_id, :songName)";

        params = new MapSqlParameterSource();
        params.addValue("author_id", author_id);
        params.addValue("songName", mp3.getName());

        return jdbcTemplate.update(sqlInsertMp3, params);
    }

    @Override
    public int insertList(List<MP3> mp3List) {
//        String sqlQuery = "insert into track (name, author_id) values (:name, :author_id)";
//        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(mp3List.toArray());
//        int[] updateCounts = jdbcTemplate.batchUpdate(sqlQuery, batch);
//        return updateCounts.length;

        int i = 0;

        for (MP3 mp3 : mp3List) {
            insert(mp3);
            i++;
        }

        return i;
    }

    @Override
    public Map<String, Integer> getStat() {

        String sqlQuery = "select author_name, count(*) as count from " + VIEW_TABLE + " group by author_name";

        return jdbcTemplate.query(sqlQuery, new ResultSetExtractor<Map<String, Integer>>() {
            @Override
            public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
                Map<String, Integer> map = new TreeMap<>();
                while (rs.next()) {
                    String author = rs.getString("author_name");
                    int count = rs.getInt("count");
                    map.put(author, count);
                }
                return map;
            }
        });
    }

    @Override
    public void delete(MP3 mp3) {
        delete(mp3.getId());
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "delete from track where id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        jdbcTemplate.update(sqlQuery, params);
    }

    @Override
    public MP3 getMP3ById(int id) {
        String sqlQuery = "select * from " + VIEW_TABLE + " where mp3_id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("mp3_id", id);

        return jdbcTemplate.queryForObject(sqlQuery, params, new Mp3RowMapperParams());
    }

    @Override
    public List<MP3> getMP3ListByName(String name) {
        String sqlQuery = "select * from track where name like :name";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", "%" + name + "%");

        return jdbcTemplate.query(sqlQuery, params, new Mp3RowMapperParams());
    }


    @Override
    public List<MP3> getMP3ListByAuthor(String author) {
        String sqlQuery = "select * from " + VIEW_TABLE + " where author_id like :author_id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("author_name", "%" + author + "%");

        return jdbcTemplate.query(sqlQuery, params, new Mp3RowMapperParams());
    }

    public int getMp3Count() {
        String sqlQuery = "select count(*) from track";
        return jdbcTemplate.getJdbcOperations().queryForObject(sqlQuery, Integer.class);
    }

    private static final class Mp3RowMapperParams implements RowMapper<MP3> {

        @Override
        public MP3 mapRow(ResultSet rs, int i) throws SQLException {

            Author author = new Author();
            author.setId(rs.getInt("author_id"));
            author.setName(rs.getString("name"));

            MP3 mp3 = new MP3();
            mp3.setId(rs.getInt("id"));
            mp3.setName(rs.getString("name"));
            mp3.setAuthor(author);
            return mp3;
        }
    }

}
