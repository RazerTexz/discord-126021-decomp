package p007b.p008a.p009a;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.C0837n;

/* JADX INFO: renamed from: b.a.a.o */
/* JADX INFO: compiled from: SelectorDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0838o implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C0837n.b f418j;

    public ViewOnClickListenerC0838o(C0837n.b bVar) {
        this.f418j = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0837n.b bVar = this.f418j;
        Function1<? super Integer, Unit> function1 = bVar.f415b.onSelectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(bVar.getAdapterPosition()));
        }
        this.f418j.f415b.dismiss();
    }
}
