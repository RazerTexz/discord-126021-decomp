package b.a.q.m0.c;

import co.discord.media_engine.Connection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$r extends d0.z.d.o implements Function1<Connection, Unit> {
    public final /* synthetic */ int $frameRate;
    public final /* synthetic */ MediaEngineConnection$b $quality;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$r(MediaEngineConnection$b mediaEngineConnection$b, int i) {
        super(1);
        this.$quality = mediaEngineConnection$b;
        this.$frameRate = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Connection connection) {
        Connection connection2 = connection;
        d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
        MediaEngineConnection$b mediaEngineConnection$b = this.$quality;
        connection2.setEncodingQuality(mediaEngineConnection$b.a, mediaEngineConnection$b.f2799b, mediaEngineConnection$b.c, mediaEngineConnection$b.d, this.$frameRate);
        return Unit.a;
    }
}
