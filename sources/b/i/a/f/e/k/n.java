package b.i.a.f.e.k;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n implements DialogInterface$OnClickListener {
    public abstract void a();

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            a();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
