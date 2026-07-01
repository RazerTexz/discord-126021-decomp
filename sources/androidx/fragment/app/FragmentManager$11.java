package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.activity.result.ActivityResultCallback;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$11 implements ActivityResultCallback<Map<String, Boolean>> {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$11(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    @SuppressLint({"SyntheticAccessor"})
    public /* bridge */ /* synthetic */ void onActivityResult(Map<String, Boolean> map) {
        onActivityResult2(map);
    }

    @SuppressLint({"SyntheticAccessor"})
    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public void onActivityResult2(Map<String, Boolean> map) {
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        ArrayList arrayList = new ArrayList(map.values());
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
        }
        FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfoPollFirst = this.this$0.mLaunchedFragments.pollFirst();
        if (fragmentManager$LaunchedFragmentInfoPollFirst == null) {
            Log.w(FragmentManager.TAG, "No permissions were requested for " + this);
            return;
        }
        String str = fragmentManager$LaunchedFragmentInfoPollFirst.mWho;
        int i2 = fragmentManager$LaunchedFragmentInfoPollFirst.mRequestCode;
        Fragment fragmentFindFragmentByWho = FragmentManager.access$200(this.this$0).findFragmentByWho(str);
        if (fragmentFindFragmentByWho != null) {
            fragmentFindFragmentByWho.onRequestPermissionsResult(i2, strArr, iArr);
            return;
        }
        Log.w(FragmentManager.TAG, "Permission request result delivered for unknown Fragment " + str);
    }
}
