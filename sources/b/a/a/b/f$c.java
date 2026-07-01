package b.a.a.b;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PremiumActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f$c implements View$OnClickListener {
    public final /* synthetic */ f j;

    public f$c(f fVar) {
        this.j = fVar;
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
