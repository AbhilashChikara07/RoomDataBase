package in.oku.workmanagerexample;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;

public class ActivityClass extends AppCompatActivity {

    OneTimeWorkRequest request = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request = new OneTimeWorkRequest.Builder(DemoClass.class).build();
        WorkManager.getInstance().enqueue(request);
        WorkManager.getInstance().getStatusById(request.getId())
                .observe(this, new Observer<WorkStatus>() {
                    @Override
                    public void onChanged(@Nullable WorkStatus workStatus) {
                        workStatus.getOutputData();
                    }
                });
    }

}
