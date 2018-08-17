package in.oku.roomproject;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import in.oku.roomproject.Room.Entity.UserEntity;
import in.oku.roomproject.Room.ViewModel.RoomRepository;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserEntity mUserEntity = new UserEntity();
        mUserEntity.setUserEmail("abhilash.chikara07@gmail.com");
        mUserEntity.setUserName("ABHILASH CHIKARA");
        mUserEntity.setUserPhone("9953040685");

        RoomRepository mRoomRepository = new RoomRepository();
        mRoomRepository.initializeDB(this);
        mRoomRepository.insertUserData(mUserEntity);

        mRoomRepository.getList();
        mRoomRepository.mUserList.observe(this, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(@Nullable List<UserEntity> userEntities) {
                Log.e("userEmail", "" + userEntities.get(0).getUserEmail());
            }
        });

    }

}
