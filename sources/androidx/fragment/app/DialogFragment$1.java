package androidx.fragment.app;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes.dex */
public class DialogFragment$1 implements Runnable {
    public final /* synthetic */ DialogFragment this$0;

    public DialogFragment$1(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"SyntheticAccessor"})
    public void run() {
        DialogFragment.access$100(this.this$0).onDismiss(DialogFragment.access$000(this.this$0));
    }
}
