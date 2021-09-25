package kz.spring.database.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MP3 {

    private Integer id;
    private String name;
    private Author author;

    public MP3() {
    }

}
