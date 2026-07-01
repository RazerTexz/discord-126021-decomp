package b.a.q.m0.c;

import co.discord.media_engine.AudioDecoder;
import co.discord.media_engine.AudioEncoder;
import co.discord.media_engine.Connection;
import co.discord.media_engine.VideoDecoder;
import co.discord.media_engine.VideoEncoder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$h extends d0.z.d.o implements Function1<Connection, Unit> {
    public final /* synthetic */ AudioDecoder $audioDecoder;
    public final /* synthetic */ AudioEncoder $audioEncoder;
    public final /* synthetic */ VideoDecoder $videoDecoder;
    public final /* synthetic */ VideoEncoder $videoEncoder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$h(AudioEncoder audioEncoder, VideoEncoder videoEncoder, AudioDecoder audioDecoder, VideoDecoder videoDecoder) {
        super(1);
        this.$audioEncoder = audioEncoder;
        this.$videoEncoder = videoEncoder;
        this.$audioDecoder = audioDecoder;
        this.$videoDecoder = videoDecoder;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Connection connection) {
        Connection connection2 = connection;
        d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
        connection2.setCodecs(this.$audioEncoder, this.$videoEncoder, new AudioDecoder[]{this.$audioDecoder}, new VideoDecoder[]{this.$videoDecoder});
        return Unit.a;
    }
}
