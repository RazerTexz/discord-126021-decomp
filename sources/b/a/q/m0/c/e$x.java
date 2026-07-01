package b.a.q.m0.c;

import co.discord.media_engine.Connection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$x extends d0.z.d.o implements Function1<Connection, Unit> {
    public static final e$x j = new e$x();

    public e$x() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Connection connection) {
        Connection connection2 = connection;
        d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
        connection2.stopScreenshareBroadcast();
        return Unit.a;
    }
}
