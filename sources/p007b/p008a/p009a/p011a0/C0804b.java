package p007b.p008a.p009a.p011a0;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.a0.b */
/* JADX INFO: compiled from: GiftPurchasedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0804b extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ C0803a.d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0804b(C0803a.d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        C12238m.checkNotNullParameter(view, "it");
        C0803a c0803a = C0803a.this;
        KProperty[] kPropertyArr = C0803a.f224j;
        c0803a.m103g().f1170f.callOnClick();
        return Unit.f27425a;
    }
}
