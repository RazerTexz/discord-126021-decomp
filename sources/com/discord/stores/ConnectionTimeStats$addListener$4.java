package com.discord.stores;


/* JADX INFO: compiled from: ConnectionTimeStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionTimeStats$addListener$4 extends StoreMediaEngine$DefaultListener {
    public final /* synthetic */ ConnectionTimeStats this$0;

    public ConnectionTimeStats$addListener$4(ConnectionTimeStats connectionTimeStats) {
        this.this$0 = connectionTimeStats;
    }

    @Override // com.discord.stores.StoreMediaEngine$DefaultListener, com.discord.stores.StoreMediaEngine$Listener
    public void onConnected() {
        ConnectionTimeStats.access$getMediaEngineConnection$p(this.this$0).end(true);
    }

    @Override // com.discord.stores.StoreMediaEngine$DefaultListener, com.discord.stores.StoreMediaEngine$Listener
    public void onConnecting() {
        ConnectionTimeStats$Stat.start$default(ConnectionTimeStats.access$getMediaEngineConnection$p(this.this$0), false, 1, null);
    }
}
