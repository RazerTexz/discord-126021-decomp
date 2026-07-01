package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;

/* JADX INFO: Add missing generic type declarations: [I] */
/* JADX INFO: loaded from: classes.dex */
public class ActivityResultRegistry$3<I> extends ActivityResultLauncher<I> {
    public final /* synthetic */ ActivityResultRegistry this$0;
    public final /* synthetic */ ActivityResultContract val$contract;
    public final /* synthetic */ String val$key;
    public final /* synthetic */ int val$requestCode;

    public ActivityResultRegistry$3(ActivityResultRegistry activityResultRegistry, int i, ActivityResultContract activityResultContract, String str) {
        this.this$0 = activityResultRegistry;
        this.val$requestCode = i;
        this.val$contract = activityResultContract;
        this.val$key = str;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    @NonNull
    public ActivityResultContract<I, ?> getContract() {
        return this.val$contract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(I i, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        this.this$0.onLaunch(this.val$requestCode, this.val$contract, i, activityOptionsCompat);
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.this$0.unregister(this.val$key);
    }
}
