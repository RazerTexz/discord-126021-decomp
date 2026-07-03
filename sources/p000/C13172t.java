package p000;

import com.discord.views.calls.VideoCallParticipantView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: t */
/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class C13172t extends AbstractC12240o implements Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> {

    /* JADX INFO: renamed from: j */
    public static final C13172t f27924j = new C13172t(0);

    /* JADX INFO: renamed from: k */
    public static final C13172t f27925k = new C13172t(1);

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ int f27926l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13172t(int i) {
        super(2);
        this.f27926l = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(VideoCallParticipantView.StreamResolution streamResolution, VideoCallParticipantView.StreamFps streamFps) {
        int i = this.f27926l;
        if (i == 0) {
            C12238m.checkNotNullParameter(streamResolution, "<anonymous parameter 0>");
            return Unit.f27425a;
        }
        if (i != 1) {
            throw null;
        }
        C12238m.checkNotNullParameter(streamResolution, "<anonymous parameter 0>");
        return Unit.f27425a;
    }
}
