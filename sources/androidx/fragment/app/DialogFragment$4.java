package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;

/* JADX INFO: loaded from: classes.dex */
public class DialogFragment$4 implements Observer<LifecycleOwner> {
    public final /* synthetic */ DialogFragment this$0;

    public DialogFragment$4(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    @Override // androidx.view.Observer
    @SuppressLint({"SyntheticAccessor"})
    public /* bridge */ /* synthetic */ void onChanged(LifecycleOwner lifecycleOwner) {
        onChanged2(lifecycleOwner);
    }

    @SuppressLint({"SyntheticAccessor"})
    /* JADX INFO: renamed from: onChanged, reason: avoid collision after fix types in other method */
    public void onChanged2(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null || !DialogFragment.access$200(this.this$0)) {
            return;
        }
        View viewRequireView = this.this$0.requireView();
        if (viewRequireView.getParent() != null) {
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
        }
        if (DialogFragment.access$000(this.this$0) != null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(FragmentManager.TAG, "DialogFragment " + this + " setting the content view on " + DialogFragment.access$000(this.this$0));
            }
            DialogFragment.access$000(this.this$0).setContentView(viewRequireView);
        }
    }
}
