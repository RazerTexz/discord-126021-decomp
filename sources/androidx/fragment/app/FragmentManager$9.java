package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$9 implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$9(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public void onActivityResult2(ActivityResult activityResult) {
        FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfoPollFirst = this.this$0.mLaunchedFragments.pollFirst();
        if (fragmentManager$LaunchedFragmentInfoPollFirst == null) {
            Log.w(FragmentManager.TAG, "No Activities were started for result for " + this);
            return;
        }
        String str = fragmentManager$LaunchedFragmentInfoPollFirst.mWho;
        int i = fragmentManager$LaunchedFragmentInfoPollFirst.mRequestCode;
        Fragment fragmentFindFragmentByWho = FragmentManager.access$200(this.this$0).findFragmentByWho(str);
        if (fragmentFindFragmentByWho != null) {
            fragmentFindFragmentByWho.onActivityResult(i, activityResult.getResultCode(), activityResult.getData());
            return;
        }
        Log.w(FragmentManager.TAG, "Activity result delivered for unknown Fragment " + str);
    }
}
