package in.oku.roomproject.Room;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class Room extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

}
