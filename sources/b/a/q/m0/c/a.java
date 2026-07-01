package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection$ConnectionState;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends d0.z.d.o implements Function1<MediaEngineConnection$d, Unit> {
    public final /* synthetic */ MediaEngineConnection$ConnectionState $value;
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar, MediaEngineConnection$ConnectionState mediaEngineConnection$ConnectionState) {
        super(1);
        this.this$0 = eVar;
        this.$value = mediaEngineConnection$ConnectionState;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngineConnection$d mediaEngineConnection$d) {
        MediaEngineConnection$d mediaEngineConnection$d2 = mediaEngineConnection$d;
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$d2, "it");
        mediaEngineConnection$d2.onConnectionStateChange(this.this$0, this.$value);
        return Unit.a;
    }
}
