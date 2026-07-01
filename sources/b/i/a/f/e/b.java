package b.i.a.f.e;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface$OnCancelListener;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class b extends DialogFragment {
    public Dialog j;
    public DialogInterface$OnCancelListener k;

    @Override // android.app.DialogFragment, android.content.DialogInterface$OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface$OnCancelListener dialogInterface$OnCancelListener = this.k;
        if (dialogInterface$OnCancelListener != null) {
            dialogInterface$OnCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (this.j == null) {
            setShowsDialog(false);
        }
        return this.j;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, @Nullable String str) {
        super.show(fragmentManager, str);
    }
}
