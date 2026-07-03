package p007b.p225i.p226a.p288f.p299e.p304k;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.util.Log;

/* JADX INFO: renamed from: b.i.a.f.e.k.n */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDialogInterfaceOnClickListenerC3369n implements DialogInterface.OnClickListener {
    /* JADX INFO: renamed from: a */
    public abstract void mo4173a();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo4173a();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
