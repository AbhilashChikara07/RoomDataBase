package in.oku.roomproject.Room.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import in.oku.roomproject.Room.Entity.UserEntity;
import in.oku.roomproject.Room.RoomDataBaseClass;

public class RoomRepository {

    RoomDataBaseClass mRoomDataBaseObj;
    public MutableLiveData<List<UserEntity>> mUserList = new MutableLiveData();

    public void initializeDB(Context mContext) {
        mRoomDataBaseObj =
                RoomDataBaseClass.getDatabase(mContext);
    }

    public void insertUserData(UserEntity mUserEntity) {
        new InsertAsyncTask()
                .execute(mUserEntity);
    }

    public void getList() {
        new GetUserListAsyncTask().execute();
    }

    class InsertAsyncTask extends AsyncTask<UserEntity, Void, Void> {

        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            mRoomDataBaseObj.userDaoInterfaceAccessObj().inserUserData(userEntities[0]);
            return null;
        }

    }


    class GetUserListAsyncTask extends AsyncTask<List<UserEntity>, List<UserEntity>, List<UserEntity>> {

        @Override
        protected List<UserEntity> doInBackground(List<UserEntity>... lists) {
            return mRoomDataBaseObj.userDaoInterfaceAccessObj().getUserData();
        }

        @Override
        protected void onPostExecute(List<UserEntity> userEntities) {
            super.onPostExecute(userEntities);
            mUserList.setValue(userEntities);
        }

    }
}
