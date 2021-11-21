package bm.app.lunamistudium.student.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class Student {

    private Long id;
    private String userName;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Rank rank;
    private double score;

    public Student(String userName, String name, String surname, String email, String phoneNumber, Rank rank, double score) {
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.rank = rank;
        this.score = score;
    }
}
