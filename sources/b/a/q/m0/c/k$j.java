package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngine$c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k$j extends d0.z.d.k implements Function1<MediaEngine$c, Unit> {
    public static final k$j j = new k$j();

    public k$j() {
        super(1, MediaEngine$c.class, "onNativeEngineInitialized", "onNativeEngineInitialized()V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngine$c mediaEngine$c) {
        MediaEngine$c mediaEngine$c2 = mediaEngine$c;
        d0.z.d.m.checkNotNullParameter(mediaEngine$c2, "p1");
        mediaEngine$c2.onNativeEngineInitialized();
        return Unit.a;
    }
}
