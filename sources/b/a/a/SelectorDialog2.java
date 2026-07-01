package b.a.a;

import android.view.View;
import b.a.a.SelectorDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.a.o, reason: use source file name */
/* JADX INFO: compiled from: SelectorDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectorDialog2 implements View.OnClickListener {
    public final /* synthetic */ SelectorDialog.b j;

    public SelectorDialog2(SelectorDialog.b bVar) {
        this.j = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SelectorDialog.b bVar = this.j;
        Function1<? super Integer, Unit> function1 = bVar.f49b.onSelectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(bVar.getAdapterPosition()));
        }
        this.j.f49b.dismiss();
    }
}
