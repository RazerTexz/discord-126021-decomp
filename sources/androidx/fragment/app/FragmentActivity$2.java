package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity$2 implements OnContextAvailableListener {
    public final /* synthetic */ FragmentActivity this$0;

    public FragmentActivity$2(FragmentActivity fragmentActivity) {
        this.this$0 = fragmentActivity;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(@NonNull Context context) {
        this.this$0.mFragments.attachHost(null);
        Bundle bundleConsumeRestoredStateForKey = this.this$0.getSavedStateRegistry().consumeRestoredStateForKey(FragmentActivity.FRAGMENTS_TAG);
        if (bundleConsumeRestoredStateForKey != null) {
            this.this$0.mFragments.restoreSaveState(bundleConsumeRestoredStateForKey.getParcelable(FragmentActivity.FRAGMENTS_TAG));
        }
    }
}
