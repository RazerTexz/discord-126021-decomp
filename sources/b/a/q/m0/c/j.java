package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j extends Lambda implements Function1<MediaEngine.c, Unit> {
    public static final j j = new j();

    public j() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngine.c cVar) {
        MediaEngine.c cVar2 = cVar;
        Intrinsics3.checkNotNullParameter(cVar2, "it");
        cVar2.onConnecting();
        return Unit.a;
    }
}
