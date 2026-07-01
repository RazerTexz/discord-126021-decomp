package b.a.q.m0.c;

import co.discord.media_engine.Connection;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$a extends d0.z.d.o implements Function1<Connection, Unit> {
    public final /* synthetic */ int $audioSsrc;
    public final /* synthetic */ boolean $isMuted;
    public final /* synthetic */ long $resolvedVideoSsrc;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ float $volume;
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$a(e eVar, long j, int i, long j2, boolean z2, float f) {
        super(1);
        this.this$0 = eVar;
        this.$userId = j;
        this.$audioSsrc = i;
        this.$resolvedVideoSsrc = j2;
        this.$isMuted = z2;
        this.$volume = f;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Connection connection) {
        Connection connection2 = connection;
        d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
        long j = this.$userId;
        int i = this.$audioSsrc;
        int i2 = (int) this.$resolvedVideoSsrc;
        Objects.requireNonNull(this.this$0);
        connection2.connectUser(j, i, i2, i2 > 0 ? i2 + 1 : 0, this.$isMuted, this.$volume);
        return Unit.a;
    }
}
