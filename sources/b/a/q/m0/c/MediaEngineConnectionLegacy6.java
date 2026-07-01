package b.a.q.m0.c;

import b.a.q.m0.c.MediaEngineConnectionLegacy5;
import co.discord.media_engine.Connection;
import co.discord.media_engine.Stats;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.m0.c.f, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnectionLegacy6 implements Connection.GetStatsCallback {
    public final /* synthetic */ MediaEngineConnectionLegacy5.f a;

    public MediaEngineConnectionLegacy6(MediaEngineConnectionLegacy5.f fVar) {
        this.a = fVar;
    }

    @Override // co.discord.media_engine.Connection.GetStatsCallback
    public void onStats(Stats stats) {
        Intrinsics3.checkNotNullParameter(stats, "stats");
        this.a.$onStats.invoke(stats);
    }

    @Override // co.discord.media_engine.Connection.GetStatsCallback
    public void onStatsError(Throwable th) {
        Logger.e$default(MediaEngineConnectionLegacy5.this.l, "MediaEngineConnectionLegacy", "error collecting stats", th, null, 8, null);
    }
}
