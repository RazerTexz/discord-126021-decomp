package b.a.a.b;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class a$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public a$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            Function0<Unit> function0 = ((a) this.k).onContinueClickListener;
            if (function0 != null) {
                function0.invoke();
            }
            ((a) this.k).dismiss();
            return;
        }
        if (i != 1) {
            if (i != 2) {
                throw null;
            }
            ((a) this.k).dismiss();
        } else {
            Function0<Unit> function1 = ((a) this.k).onUpgradeClickListener;
            if (function1 != null) {
                function1.invoke();
            }
            ((a) this.k).dismiss();
        }
    }
}
