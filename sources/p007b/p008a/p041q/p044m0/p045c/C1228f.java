package p007b.p008a.p041q.p044m0.p045c;

import co.discord.media_engine.Connection;
import co.discord.media_engine.Stats;
import com.discord.utilities.logging.Logger;
import p007b.p008a.p041q.p044m0.p045c.C1227e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.m0.c.f */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1228f implements Connection.GetStatsCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1227e.f f1718a;

    public C1228f(C1227e.f fVar) {
        this.f1718a = fVar;
    }

    @Override // co.discord.media_engine.Connection.GetStatsCallback
    public void onStats(Stats stats) {
        C12238m.checkNotNullParameter(stats, "stats");
        this.f1718a.$onStats.invoke(stats);
    }

    @Override // co.discord.media_engine.Connection.GetStatsCallback
    public void onStatsError(Throwable th) {
        Logger.e$default(C1227e.this.f1709l, "MediaEngineConnectionLegacy", "error collecting stats", th, null, 8, null);
    }
}
