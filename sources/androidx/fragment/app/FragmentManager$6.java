package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.view.Lifecycle;
import androidx.view.Lifecycle$Event;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$6 implements LifecycleEventObserver {
    public final /* synthetic */ FragmentManager this$0;
    public final /* synthetic */ Lifecycle val$lifecycle;
    public final /* synthetic */ FragmentResultListener val$listener;
    public final /* synthetic */ String val$requestKey;

    public FragmentManager$6(FragmentManager fragmentManager, String str, FragmentResultListener fragmentResultListener, Lifecycle lifecycle) {
        this.this$0 = fragmentManager;
        this.val$requestKey = str;
        this.val$listener = fragmentResultListener;
        this.val$lifecycle = lifecycle;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        Bundle bundle;
        if (lifecycle$Event == Lifecycle$Event.ON_START && (bundle = (Bundle) FragmentManager.access$000(this.this$0).get(this.val$requestKey)) != null) {
            this.val$listener.onFragmentResult(this.val$requestKey, bundle);
            this.this$0.clearFragmentResult(this.val$requestKey);
        }
        if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
            this.val$lifecycle.removeObserver(this);
            FragmentManager.access$100(this.this$0).remove(this.val$requestKey);
        }
    }
}
