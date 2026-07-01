package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection$d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g extends d0.z.d.o implements Function1<MediaEngineConnection$d, Unit> {
    public final /* synthetic */ int $audioSsrc;
    public final /* synthetic */ boolean $isSpeaking;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(long j, int i, boolean z2) {
        super(1);
        this.$userId = j;
        this.$audioSsrc = i;
        this.$isSpeaking = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngineConnection$d mediaEngineConnection$d) {
        MediaEngineConnection$d mediaEngineConnection$d2 = mediaEngineConnection$d;
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$d2, "it");
        mediaEngineConnection$d2.onSpeaking(this.$userId, this.$audioSsrc, this.$isSpeaking);
        return Unit.a;
    }
}
