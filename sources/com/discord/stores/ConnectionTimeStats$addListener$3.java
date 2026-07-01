package com.discord.stores;


/* JADX INFO: compiled from: ConnectionTimeStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionTimeStats$addListener$3 extends StoreStreamRtcConnection$DefaultListener {
    public final /* synthetic */ ConnectionTimeStats this$0;

    public ConnectionTimeStats$addListener$3(ConnectionTimeStats connectionTimeStats) {
        this.this$0 = connectionTimeStats;
    }

    @Override // com.discord.stores.StoreStreamRtcConnection$DefaultListener, com.discord.stores.StoreStreamRtcConnection$Listener
    public void onConnected() {
        ConnectionTimeStats$Stat.end$default(ConnectionTimeStats.access$getStreamConnection$p(this.this$0), false, 1, null);
        ConnectionTimeStats.access$getStreamFirstFrame$p(this.this$0).start(true);
    }

    @Override // com.discord.stores.StoreStreamRtcConnection$DefaultListener, com.discord.stores.StoreStreamRtcConnection$Listener
    public void onConnecting() {
        ConnectionTimeStats$Stat.end$default(ConnectionTimeStats.access$getStreamRequested$p(this.this$0), false, 1, null);
        ConnectionTimeStats$Stat.start$default(ConnectionTimeStats.access$getStreamConnection$p(this.this$0), false, 1, null);
    }

    @Override // com.discord.stores.StoreStreamRtcConnection$DefaultListener, com.discord.stores.StoreStreamRtcConnection$Listener
    public void onFirstFrameReceived(long ssrc) {
        ConnectionTimeStats$Stat.end$default(ConnectionTimeStats.access$getStreamFirstFrame$p(this.this$0), false, 1, null);
        ConnectionTimeStats$Stat.end$default(ConnectionTimeStats.access$getConnectionStreamFirstFrame$p(this.this$0), false, 1, null);
    }
}
