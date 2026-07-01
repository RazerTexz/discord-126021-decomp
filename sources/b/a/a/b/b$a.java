package b.a.a.b;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class b$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public b$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            Function0<Unit> function0 = ((b) this.k).onMonthlyClickListener;
            if (function0 != null) {
                function0.invoke();
            }
            ((b) this.k).dismiss();
            return;
        }
        if (i != 1) {
            throw null;
        }
        Function0<Unit> function1 = ((b) this.k).onYearlyClickListener;
        if (function1 != null) {
            function1.invoke();
        }
        ((b) this.k).dismiss();
    }
}
