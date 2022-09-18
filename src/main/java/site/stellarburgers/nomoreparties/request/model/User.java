package site.stellarburgers.nomoreparties.request.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {

    private String email;
    private String password;
    private String name;
}