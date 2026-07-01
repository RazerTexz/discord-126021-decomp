package androidx.fragment.app;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.arch.core.util.Function;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class Fragment$8 extends Fragment$OnPreAttachedListener {
    public final /* synthetic */ Fragment this$0;
    public final /* synthetic */ ActivityResultCallback val$callback;
    public final /* synthetic */ ActivityResultContract val$contract;
    public final /* synthetic */ AtomicReference val$ref;
    public final /* synthetic */ Function val$registryProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fragment$8(Fragment fragment, Function function, AtomicReference atomicReference, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        super(null);
        this.this$0 = fragment;
        this.val$registryProvider = function;
        this.val$ref = atomicReference;
        this.val$contract = activityResultContract;
        this.val$callback = activityResultCallback;
    }

    @Override // androidx.fragment.app.Fragment$OnPreAttachedListener
    public void onPreAttached() {
        String strGenerateActivityResultKey = this.this$0.generateActivityResultKey();
        this.val$ref.set(((ActivityResultRegistry) this.val$registryProvider.apply(null)).register(strGenerateActivityResultKey, this.this$0, this.val$contract, this.val$callback));
    }
}
