package b.a.a.b;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g$c implements View$OnClickListener {
    public final /* synthetic */ g j;

    public g$c(g gVar) {
        this.j = gVar;
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
