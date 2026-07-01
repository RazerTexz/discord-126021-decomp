package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;

/* JADX INFO: loaded from: classes.dex */
public class ActivityResultRegistry$CallbackAndContract<O> {
    public final ActivityResultCallback<O> mCallback;
    public final ActivityResultContract<?, O> mContract;

    public ActivityResultRegistry$CallbackAndContract(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
        this.mCallback = activityResultCallback;
        this.mContract = activityResultContract;
    }
}
