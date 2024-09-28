export type UserProfileToken = {
  userName: string;
  token: string;
  profile: {
    firstName: string;
    lastName: string;
    profileImage: string;
  };
};

export type UserProfile = {
  userName: string;
  profile: {
    fullName: string;
    profileImage: string;
  };
};

export interface RegisterUser {
  firstName: string;
  lastName: string;
  email: string;
  biografy: string;
  profileImage: string;
  followersCount: number;
  recipesCount: number; //todo: add this field to the model
}
