package b.a.q.m0.c;

import co.discord.media_engine.Connection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e$b extends d0.z.d.k implements Function1<Connection, Unit> {
    public static final e$b j = new e$b();

    public e$b() {
        super(1, Connection.class, "dispose", "dispose()V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Connection connection) {
        Connection connection2 = connection;
        d0.z.d.m.checkNotNullParameter(connection2, "p1");
        connection2.dispose();
        return Unit.a;
    }
}
