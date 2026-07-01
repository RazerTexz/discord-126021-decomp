package b.a.d;

import com.discord.app.AppFragment;
import com.discord.app.AppFragment$d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e extends d0.z.d.o implements Function1<Exception, Unit> {
    public final /* synthetic */ AppFragment$d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AppFragment$d appFragment$d) {
        super(1);
        this.this$0 = appFragment$d;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Exception exc) {
        Exception exc2 = exc;
        d0.z.d.m.checkNotNullParameter(exc2, "e");
        AppFragment appFragment = this.this$0.this$0;
        m.j(appFragment, b.a.k.b.k(appFragment, 2131896561, new Object[]{exc2.getMessage()}, null, 4), 0, 4);
        return Unit.a;
    }
}
