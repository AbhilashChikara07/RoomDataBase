package in.oku.roomproject.Room.DaoInterface;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import in.oku.roomproject.Room.Entity.UserEntity;

@Dao
public interface UserDaoInterface {

    @Insert
    void inserUserData(UserEntity mUserEntity);

    @Query("SELECT * FROM user_table ")
    List<UserEntity> getUserData();

    @Delete
    void deleteUserData(UserEntity mUserEntity);

    @Update
    void updateUserData(UserEntity mUserEntity);


}
