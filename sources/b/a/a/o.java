package b.a.a;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SelectorDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o implements View$OnClickListener {
    public final /* synthetic */ n$b j;

    public o(n$b n_b) {
        this.j = n_b;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        n$b n_b = this.j;
        Function1<? super Integer, Unit> function1 = n_b.f49b.onSelectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(n_b.getAdapterPosition()));
        }
        this.j.f49b.dismiss();
    }
}
