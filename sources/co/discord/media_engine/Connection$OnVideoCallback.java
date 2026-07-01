package co.discord.media_engine;


/* JADX INFO: compiled from: Connection.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Connection$OnVideoCallback {
    void onVideo(long userId, int ssrc, String streamIdentifier, StreamParameters[] streams);
}
