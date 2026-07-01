package b.a.q.m0.c;

import co.discord.media_engine.Connection$OnVideoCallback;
import co.discord.media_engine.StreamParameters;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Connection$OnVideoCallback {
    public final /* synthetic */ e a;

    public b(e eVar) {
        this.a = eVar;
    }

    @Override // co.discord.media_engine.Connection$OnVideoCallback
    public void onVideo(long j, int i, String str, StreamParameters[] streamParametersArr) {
        d0.z.d.m.checkNotNullParameter(str, "streamIdentifier");
        d0.z.d.m.checkNotNullParameter(streamParametersArr, "streams");
        e.x(this.a, new b$a(this, j, i, str, streamParametersArr));
    }
}
