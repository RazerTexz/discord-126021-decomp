package b.a.k;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FormatUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$a extends o implements Function1<RenderContext, Unit> {
    public static final b$a j = new b$a();

    public b$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        return Unit.a;
    }
}
