package co.discord.media_engine;

import co.discord.media_engine.internal.TransformStats;
import d0.z.d.m;

/* JADX INFO: compiled from: Connection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Connection$GetStatsCallbackNative {
    private final Connection$GetStatsCallback callback;

    public Connection$GetStatsCallbackNative(Connection$GetStatsCallback connection$GetStatsCallback) {
        m.checkNotNullParameter(connection$GetStatsCallback, "callback");
        this.callback = connection$GetStatsCallback;
    }

    public final Connection$GetStatsCallback getCallback() {
        return this.callback;
    }

    public final void onStats(String stats) {
        m.checkNotNullParameter(stats, "stats");
        try {
            this.callback.onStats(TransformStats.transform(stats));
        } catch (Exception e) {
            this.callback.onStatsError(e);
        }
    }
}
