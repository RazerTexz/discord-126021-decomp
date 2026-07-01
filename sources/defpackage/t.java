package defpackage;

import com.discord.views.calls.VideoCallParticipantView$StreamFps;
import com.discord.views.calls.VideoCallParticipantView$StreamResolution;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class t extends o implements Function2<VideoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps, Unit> {
    public static final t j = new t(0);
    public static final t k = new t(1);
    public final /* synthetic */ int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(int i) {
        super(2);
        this.l = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(VideoCallParticipantView$StreamResolution videoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps videoCallParticipantView$StreamFps) {
        int i = this.l;
        if (i == 0) {
            m.checkNotNullParameter(videoCallParticipantView$StreamResolution, "<anonymous parameter 0>");
            return Unit.a;
        }
        if (i != 1) {
            throw null;
        }
        m.checkNotNullParameter(videoCallParticipantView$StreamResolution, "<anonymous parameter 0>");
        return Unit.a;
    }
}
