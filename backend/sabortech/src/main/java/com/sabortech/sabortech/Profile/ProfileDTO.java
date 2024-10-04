package com.sabortech.sabortech.Profile;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer recipesCount;
    private Integer followersCount;
    private String biografy;
    private UUID fileId;
    private String profileImage;

}
