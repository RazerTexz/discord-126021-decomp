package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.view.Lifecycle$Event;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class ActivityResultRegistry$1 implements LifecycleEventObserver {
    public final /* synthetic */ ActivityResultRegistry this$0;
    public final /* synthetic */ ActivityResultCallback val$callback;
    public final /* synthetic */ ActivityResultContract val$contract;
    public final /* synthetic */ String val$key;

    public ActivityResultRegistry$1(ActivityResultRegistry activityResultRegistry, String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
        this.this$0 = activityResultRegistry;
        this.val$key = str;
        this.val$callback = activityResultCallback;
        this.val$contract = activityResultContract;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        if (!Lifecycle$Event.ON_START.equals(lifecycle$Event)) {
            if (Lifecycle$Event.ON_STOP.equals(lifecycle$Event)) {
                this.this$0.mKeyToCallback.remove(this.val$key);
                return;
            } else {
                if (Lifecycle$Event.ON_DESTROY.equals(lifecycle$Event)) {
                    this.this$0.unregister(this.val$key);
                    return;
                }
                return;
            }
        }
        this.this$0.mKeyToCallback.put(this.val$key, new ActivityResultRegistry$CallbackAndContract<>(this.val$callback, this.val$contract));
        if (this.this$0.mParsedPendingResults.containsKey(this.val$key)) {
            Object obj = this.this$0.mParsedPendingResults.get(this.val$key);
            this.this$0.mParsedPendingResults.remove(this.val$key);
            this.val$callback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.this$0.mPendingResults.getParcelable(this.val$key);
        if (activityResult != null) {
            this.this$0.mPendingResults.remove(this.val$key);
            this.val$callback.onActivityResult(this.val$contract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
    }
}
