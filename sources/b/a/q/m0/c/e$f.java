package b.a.q.m0.c;

import co.discord.media_engine.Connection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$f extends d0.z.d.o implements Function1<Connection, Unit> {
    public final /* synthetic */ Function1 $onStats;
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$f(e eVar, Function1 function1) {
        super(1);
        this.this$0 = eVar;
        this.$onStats = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Connection connection) {
        Connection connection2 = connection;
        d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
        connection2.getStats(new f(this));
        return Unit.a;
    }
}
