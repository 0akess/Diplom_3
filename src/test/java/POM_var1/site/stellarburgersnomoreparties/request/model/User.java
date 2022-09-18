package POM_var1.site.stellarburgersnomoreparties.request.model;

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