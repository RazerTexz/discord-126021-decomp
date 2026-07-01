package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection$b;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$q extends d0.z.d.o implements Function1<MediaEngineConnection$d, Unit> {
    public final /* synthetic */ MediaEngineConnection$b $quality;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$q(MediaEngineConnection$b mediaEngineConnection$b) {
        super(1);
        this.$quality = mediaEngineConnection$b;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngineConnection$d mediaEngineConnection$d) {
        MediaEngineConnection$d mediaEngineConnection$d2 = mediaEngineConnection$d;
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$d2, "it");
        mediaEngineConnection$d2.onTargetBitrate(this.$quality.f2799b);
        return Unit.a;
    }
}
