package b.a.a.a0;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GiftPurchasedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends o implements Function1<View, Unit> {
    public final /* synthetic */ a$d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a$d a_d) {
        super(1);
        this.this$0 = a_d;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        m.checkNotNullParameter(view, "it");
        a aVar = this.this$0.this$0;
        KProperty[] kPropertyArr = a.j;
        aVar.g().f.callOnClick();
        return Unit.a;
    }
}
