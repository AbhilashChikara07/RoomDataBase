package in.oku.workmanagerexample;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import java.util.ArrayList;

import androidx.work.Data;
import androidx.work.Worker;

public class DemoClass extends Worker {

    ArrayList<String> mArray = new ArrayList<>();


    @NonNull
    @Override
    public WorkerResult doWork() {

        ArrayMap<String, Object> resultMap = new ArrayMap<>();

        Data output = new Data.Builder()
                .putAll(resultMap)
                .build();
        setOutputData(output);

        if (getWorkResultStatus().size() > 0)
            return WorkerResult.SUCCESS;
        else
            return WorkerResult.FAILURE;
    }

    ArrayList<String> getWorkResultStatus() {
        return mArray;
    }

}
