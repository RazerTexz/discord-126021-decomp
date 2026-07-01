package b.a.a.a0;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GiftPurchasedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$d extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$d(a aVar) {
        super(1);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(RenderContext renderContext) {
        RenderContext renderContext2 = renderContext;
        m.checkNotNullParameter(renderContext2, "$receiver");
        renderContext2.b("onInventoryClick", new b(this));
        return Unit.a;
    }
}
