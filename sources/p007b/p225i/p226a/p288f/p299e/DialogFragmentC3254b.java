package p007b.p225i.p226a.p288f.p299e;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.f.e.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class DialogFragmentC3254b extends DialogFragment {

    /* JADX INFO: renamed from: j */
    public Dialog f9299j;

    /* JADX INFO: renamed from: k */
    public DialogInterface.OnCancelListener f9300k;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f9300k;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (this.f9299j == null) {
            setShowsDialog(false);
        }
        return this.f9299j;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, @Nullable String str) {
        super.show(fragmentManager, str);
    }
}
