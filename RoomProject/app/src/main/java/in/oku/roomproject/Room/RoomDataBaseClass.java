package in.oku.roomproject.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import in.oku.roomproject.Room.DaoInterface.UserDaoInterface;
import in.oku.roomproject.Room.Entity.UserEntity;

@Database(entities =
        {UserEntity.class}, version = 1)
public abstract class RoomDataBaseClass extends RoomDatabase {

    private static RoomDataBaseClass INSTANCE;

    public abstract UserDaoInterface userDaoInterfaceAccessObj();

    public static RoomDataBaseClass getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDataBaseClass.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            RoomDataBaseClass.class,
                            "broex_database").build();
                }
            }
        }
        return INSTANCE;
    }


}
