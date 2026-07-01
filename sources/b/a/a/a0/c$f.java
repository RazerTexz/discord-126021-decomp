package b.a.a.a0;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$f extends o implements Function1<Error, Unit> {
    public final /* synthetic */ c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$f(c cVar) {
        super(1);
        this.this$0 = cVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        m.checkNotNullParameter(error, "it");
        this.this$0.dismiss();
        return Unit.a;
    }
}
