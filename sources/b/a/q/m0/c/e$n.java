package b.a.q.m0.c;

import co.discord.media_engine.Connection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$n extends d0.z.d.o implements Function1<Connection, Unit> {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ float $volume;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$n(long j, float f) {
        super(1);
        this.$userId = j;
        this.$volume = f;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Connection connection) {
        Connection connection2 = connection;
        d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
        connection2.setUserPlayoutVolume(this.$userId, this.$volume / 100.0f);
        return Unit.a;
    }
}
