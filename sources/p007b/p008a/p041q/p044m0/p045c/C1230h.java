package p007b.p008a.p041q.p044m0.p045c;

import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p579g0.C12102s;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.m0.c.h */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1230h extends AbstractC12240o implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
    public final /* synthetic */ String $streamId;
    public final /* synthetic */ StreamParameters[] $streams;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ int $videoSsrc;
    public final /* synthetic */ C1227e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1230h(C1227e c1227e, long j, String str, int i, StreamParameters[] streamParametersArr) {
        super(1);
        this.this$0 = c1227e;
        this.$userId = j;
        this.$streamId = str;
        this.$videoSsrc = i;
        this.$streams = streamParametersArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
        MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
        C12238m.checkNotNullParameter(interfaceC5648d2, "it");
        long j = this.$userId;
        String str = this.$streamId;
        Integer intOrNull = str != null ? C12102s.toIntOrNull(str) : null;
        Integer num = this.this$0.f1701d.get(Long.valueOf(this.$userId));
        int iIntValue = num != null ? num.intValue() : 0;
        int i = this.$videoSsrc;
        Objects.requireNonNull(this.this$0);
        interfaceC5648d2.onVideo(j, intOrNull, iIntValue, i, i > 0 ? i + 1 : 0, this.$streams);
        return Unit.f27425a;
    }
}
