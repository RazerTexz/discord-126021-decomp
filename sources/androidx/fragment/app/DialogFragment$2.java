package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface$OnCancelListener;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class DialogFragment$2 implements DialogInterface$OnCancelListener {
    public final /* synthetic */ DialogFragment this$0;

    public DialogFragment$2(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    @Override // android.content.DialogInterface$OnCancelListener
    @SuppressLint({"SyntheticAccessor"})
    public void onCancel(@Nullable DialogInterface dialogInterface) {
        if (DialogFragment.access$000(this.this$0) != null) {
            DialogFragment dialogFragment = this.this$0;
            dialogFragment.onCancel(DialogFragment.access$000(dialogFragment));
        }
    }
}
