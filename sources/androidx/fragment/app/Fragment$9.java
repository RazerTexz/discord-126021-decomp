package androidx.fragment.app;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Add missing generic type declarations: [I] */
/* JADX INFO: loaded from: classes.dex */
public class Fragment$9<I> extends ActivityResultLauncher<I> {
    public final /* synthetic */ Fragment this$0;
    public final /* synthetic */ ActivityResultContract val$contract;
    public final /* synthetic */ AtomicReference val$ref;

    public Fragment$9(Fragment fragment, AtomicReference atomicReference, ActivityResultContract activityResultContract) {
        this.this$0 = fragment;
        this.val$ref = atomicReference;
        this.val$contract = activityResultContract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    @NonNull
    public ActivityResultContract<I, ?> getContract() {
        return this.val$contract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(I i, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) this.val$ref.get();
        if (activityResultLauncher == null) {
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }
        activityResultLauncher.launch(i, activityOptionsCompat);
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) this.val$ref.getAndSet(null);
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
    }
}
