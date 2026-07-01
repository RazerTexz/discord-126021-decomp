package androidx.activity.result;

import android.content.Intent;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.activity.result.ActivityResultKt, reason: use source file name */
/* JADX INFO: compiled from: ActivityResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResult2 {
    public static final int component1(ActivityResult activityResult) {
        Intrinsics3.checkNotNullParameter(activityResult, "$this$component1");
        return activityResult.getResultCode();
    }

    public static final Intent component2(ActivityResult activityResult) {
        Intrinsics3.checkNotNullParameter(activityResult, "$this$component2");
        return activityResult.getData();
    }
}
