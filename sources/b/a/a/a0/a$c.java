package b.a.a.a0;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GiftPurchasedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$c implements View$OnClickListener {
    public final /* synthetic */ a j;

    public a$c(a aVar) {
        this.j = aVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function0<Unit> function0 = this.j.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
        this.j.dismiss();
    }
}
