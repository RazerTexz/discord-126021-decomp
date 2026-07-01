package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface$OnDismissListener;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class DialogFragment$3 implements DialogInterface$OnDismissListener {
    public final /* synthetic */ DialogFragment this$0;

    public DialogFragment$3(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    @SuppressLint({"SyntheticAccessor"})
    public void onDismiss(@Nullable DialogInterface dialogInterface) {
        if (DialogFragment.access$000(this.this$0) != null) {
            DialogFragment dialogFragment = this.this$0;
            dialogFragment.onDismiss(DialogFragment.access$000(dialogFragment));
        }
    }
}
