package kz.spring.database.main;

import kz.spring.database.dao.intereface.MP3Dao;
import kz.spring.database.objects.Author;
import kz.spring.database.objects.MP3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartDB {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("database/applicationContext.xml");
        MP3Dao dao = (MP3Dao) context.getBean("sqliteMp3SimpleWithViewDao");

//        List<MP3> mp3List = new ArrayList<>();

//        MP3 mp3 = new MP3();
//        mp3.setName("batch1");
//        mp3.setAuthor("insertBatch");
//        mp3List.add(mp3);
//
//        MP3 mp31 = new MP3();
//        mp31.setName("batch2");
//        mp31.setAuthor("insertBatch");
//        mp3List.add(mp31);
//
//        dao.insertList(mp3List);


        Author author = new Author();
        author.setName("Kringe");

        MP3 song = new MP3();
        song.setName("kringe song");
        song.setAuthor(author);
        dao.insert(song);


//        dao.insert(mp3);

//        System.out.println(dao.getMP3ById(1));
//        System.out.println(dao.getMP3ListByName("aaaa"));
//        System.out.println(dao.getMP3ListByAuthor("Klava Koka"));
//
//        MP3 mp3 = dao.getMP3ById(7);
//        dao.delete(mp3);

    }
}
