package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.q.m0.c.g, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnectionLegacy7 extends Lambda implements Function1<MediaEngineConnection.d, Unit> {
    public final /* synthetic */ int $audioSsrc;
    public final /* synthetic */ boolean $isSpeaking;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEngineConnectionLegacy7(long j, int i, boolean z2) {
        super(1);
        this.$userId = j;
        this.$audioSsrc = i;
        this.$isSpeaking = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngineConnection.d dVar) {
        MediaEngineConnection.d dVar2 = dVar;
        Intrinsics3.checkNotNullParameter(dVar2, "it");
        dVar2.onSpeaking(this.$userId, this.$audioSsrc, this.$isSpeaking);
        return Unit.a;
    }
}
