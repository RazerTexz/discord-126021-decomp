package com.discord.stores;


/* JADX INFO: compiled from: ConnectionTimeStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionTimeStats$addListener$2 extends StoreRtcConnection$DefaultListener {
    public final /* synthetic */ ConnectionTimeStats this$0;

    public ConnectionTimeStats$addListener$2(ConnectionTimeStats connectionTimeStats) {
        this.this$0 = connectionTimeStats;
    }

    @Override // com.discord.stores.StoreRtcConnection$DefaultListener, com.discord.stores.StoreRtcConnection$Listener
    public void onConnected() {
        ConnectionTimeStats$Stat.end$default(ConnectionTimeStats.access$getVoiceConnection$p(this.this$0), false, 1, null);
    }

    @Override // com.discord.stores.StoreRtcConnection$DefaultListener, com.discord.stores.StoreRtcConnection$Listener
    public void onConnecting() {
        ConnectionTimeStats$Stat.start$default(ConnectionTimeStats.access$getVoiceConnection$p(this.this$0), false, 1, null);
        ConnectionTimeStats$Stat.start$default(ConnectionTimeStats.access$getConnectionVideoFirstFrame$p(this.this$0), false, 1, null);
        ConnectionTimeStats$Stat.start$default(ConnectionTimeStats.access$getConnectionStreamFirstFrame$p(this.this$0), false, 1, null);
    }

    @Override // com.discord.stores.StoreRtcConnection$DefaultListener, com.discord.stores.StoreRtcConnection$Listener
    public void onFirstFrameReceived(long ssrc) {
        ConnectionTimeStats$Stat.end$default(ConnectionTimeStats.access$getVideoFirstFrame$p(this.this$0), false, 1, null);
        ConnectionTimeStats$Stat.end$default(ConnectionTimeStats.access$getConnectionVideoFirstFrame$p(this.this$0), false, 1, null);
    }
}
