package b.a.a.a0;

import android.view.View;
import b.a.a.a0.GiftPurchasedDialog;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.a.a0.b, reason: use source file name */
/* JADX INFO: compiled from: GiftPurchasedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GiftPurchasedDialog2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ GiftPurchasedDialog.d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftPurchasedDialog2(GiftPurchasedDialog.d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        GiftPurchasedDialog giftPurchasedDialog = GiftPurchasedDialog.this;
        KProperty[] kPropertyArr = GiftPurchasedDialog.j;
        giftPurchasedDialog.g().f.callOnClick();
        return Unit.a;
    }
}
