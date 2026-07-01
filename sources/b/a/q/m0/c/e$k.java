package b.a.q.m0.c;

import co.discord.media_engine.Connection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$k extends d0.z.d.o implements Function1<Connection, Unit> {
    public final /* synthetic */ boolean $mute;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$k(long j, boolean z2) {
        super(1);
        this.$userId = j;
        this.$mute = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Connection connection) {
        Connection connection2 = connection;
        d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
        connection2.muteUser(this.$userId, this.$mute);
        return Unit.a;
    }
}
