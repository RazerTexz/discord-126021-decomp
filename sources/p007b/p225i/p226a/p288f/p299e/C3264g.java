package p007b.p225i.p226a.p288f.p299e;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: renamed from: b.i.a.f.e.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3264g extends DialogFragment {

    /* JADX INFO: renamed from: j */
    public Dialog f9317j;

    /* JADX INFO: renamed from: k */
    public DialogInterface.OnCancelListener f9318k;

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f9318k;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (this.f9317j == null) {
            setShowsDialog(false);
        }
        return this.f9317j;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, @Nullable String str) {
        super.show(fragmentManager, str);
    }
}
