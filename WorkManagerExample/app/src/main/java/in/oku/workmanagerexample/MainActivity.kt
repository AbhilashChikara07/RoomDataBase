package `in`.oku.workmanagerexample

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    var mOneTimeWorkRequest: OneTimeWorkRequest? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mOneTimeWorkRequest = OneTimeWorkRequest.Builder(DemoClass::class.java).build()
//        WorkManager.getInstance().enqueue(mOneTimeWorkRequest)
//        WorkManager.getInstance().getStatusById(mOneTimeWorkRequest!!.id)
//                .observe(this, Observer { workStatus ->
//                    if (workStatus != null && workStatus.state.isFinished) {
//                        val data = workStatus.outputData
//                        var Map: android.support.v4.util.ArrayMap<String, Object> = data.keyValueMap
//                                as android.support.v4.util.ArrayMap<String, Object>
//                    }
//                })
//
    }
}
