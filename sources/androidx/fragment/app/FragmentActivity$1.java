package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.view.Lifecycle$Event;
import androidx.view.SavedStateRegistry$SavedStateProvider;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity$1 implements SavedStateRegistry$SavedStateProvider {
    public final /* synthetic */ FragmentActivity this$0;

    public FragmentActivity$1(FragmentActivity fragmentActivity) {
        this.this$0 = fragmentActivity;
    }

    @Override // androidx.view.SavedStateRegistry$SavedStateProvider
    @NonNull
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        this.this$0.markFragmentsCreated();
        this.this$0.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_STOP);
        Parcelable parcelableSaveAllState = this.this$0.mFragments.saveAllState();
        if (parcelableSaveAllState != null) {
            bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, parcelableSaveAllState);
        }
        return bundle;
    }
}
