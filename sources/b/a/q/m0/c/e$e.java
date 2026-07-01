package b.a.q.m0.c;

import com.discord.rtcconnection.KrispOveruseDetector$Status;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$e extends d0.z.d.o implements Function1<MediaEngineConnection$d, Unit> {
    public final /* synthetic */ KrispOveruseDetector$Status $status;
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$e(e eVar, KrispOveruseDetector$Status krispOveruseDetector$Status) {
        super(1);
        this.this$0 = eVar;
        this.$status = krispOveruseDetector$Status;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngineConnection$d mediaEngineConnection$d) {
        MediaEngineConnection$d mediaEngineConnection$d2 = mediaEngineConnection$d;
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$d2, "it");
        mediaEngineConnection$d2.onKrispStatus(this.this$0, this.$status);
        return Unit.a;
    }
}
