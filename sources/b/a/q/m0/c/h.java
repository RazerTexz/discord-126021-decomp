package b.a.q.m0.c;

import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$d;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h extends d0.z.d.o implements Function1<MediaEngineConnection$d, Unit> {
    public final /* synthetic */ String $streamId;
    public final /* synthetic */ StreamParameters[] $streams;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ int $videoSsrc;
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e eVar, long j, String str, int i, StreamParameters[] streamParametersArr) {
        super(1);
        this.this$0 = eVar;
        this.$userId = j;
        this.$streamId = str;
        this.$videoSsrc = i;
        this.$streams = streamParametersArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngineConnection$d mediaEngineConnection$d) {
        MediaEngineConnection$d mediaEngineConnection$d2 = mediaEngineConnection$d;
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$d2, "it");
        long j = this.$userId;
        String str = this.$streamId;
        Integer intOrNull = str != null ? d0.g0.s.toIntOrNull(str) : null;
        Integer num = this.this$0.d.get(Long.valueOf(this.$userId));
        int iIntValue = num != null ? num.intValue() : 0;
        int i = this.$videoSsrc;
        Objects.requireNonNull(this.this$0);
        mediaEngineConnection$d2.onVideo(j, intOrNull, iIntValue, i, i > 0 ? i + 1 : 0, this.$streams);
        return Unit.a;
    }
}
