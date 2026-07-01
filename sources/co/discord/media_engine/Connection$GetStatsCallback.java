package co.discord.media_engine;


/* JADX INFO: compiled from: Connection.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Connection$GetStatsCallback {
    void onStats(Stats stats);

    void onStatsError(Throwable t);
}
