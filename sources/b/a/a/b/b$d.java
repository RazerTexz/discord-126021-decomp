package b.a.a.b;

import android.content.DialogInterface;
import android.content.DialogInterface$OnCancelListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UpgradePremiumYearlyDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$d implements DialogInterface$OnCancelListener {
    public final /* synthetic */ b j;

    public b$d(b bVar) {
        this.j = bVar;
    }

    @Override // android.content.DialogInterface$OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Function0<Unit> function0 = this.j.onDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
