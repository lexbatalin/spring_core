package kz.spring.database.dao.intereface;

import kz.spring.database.objects.MP3;

import java.util.List;
import java.util.Map;

public interface MP3Dao {

    int insert(MP3 mp3);

    int insertList(List<MP3> mp3List);

    void delete(MP3 mp3);

    void delete(int id);

    MP3 getMP3ById(int id);

    List<MP3> getMP3ListByName(String name);

    List<MP3> getMP3ListByAuthor(String author);

    int getMp3Count();

    Map<String, Integer> getStat();

}
