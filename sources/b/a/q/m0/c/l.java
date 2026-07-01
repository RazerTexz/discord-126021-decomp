package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngine$c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l extends d0.z.d.o implements Function1<MediaEngine$c, Unit> {
    public static final l j = new l();

    public l() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngine$c mediaEngine$c) {
        MediaEngine$c mediaEngine$c2 = mediaEngine$c;
        d0.z.d.m.checkNotNullParameter(mediaEngine$c2, "it");
        mediaEngine$c2.onConnected();
        return Unit.a;
    }
}
