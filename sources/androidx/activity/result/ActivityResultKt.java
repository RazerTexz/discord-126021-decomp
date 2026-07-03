package androidx.activity.result;

import android.content.Intent;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivityResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultKt {
    public static final int component1(ActivityResult activityResult) {
        C12238m.checkNotNullParameter(activityResult, "$this$component1");
        return activityResult.getResultCode();
    }

    public static final Intent component2(ActivityResult activityResult) {
        C12238m.checkNotNullParameter(activityResult, "$this$component2");
        return activityResult.getData();
    }
}
