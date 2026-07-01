package com.discord.stores;

import com.discord.app.AppLog;
import com.discord.rtcconnection.KrispOveruseDetector$Status;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$a;
import d0.t.u;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$handleNewConnection$1 extends MediaEngineConnection$a {
    public final /* synthetic */ StoreMediaEngine this$0;

    public StoreMediaEngine$handleNewConnection$1(StoreMediaEngine storeMediaEngine) {
        this.this$0 = storeMediaEngine;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$a, com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onDestroy(MediaEngineConnection connection) {
        m.checkNotNullParameter(connection, "connection");
        if (u.minus(this.this$0.getMediaEngine().getConnections(), connection).isEmpty()) {
            StoreMediaEngine.access$getMediaSettingsStore$p(this.this$0).revertTemporaryDisableKrisp();
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$a, com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onKrispStatus(MediaEngineConnection connection, KrispOveruseDetector$Status status) {
        m.checkNotNullParameter(connection, "connection");
        m.checkNotNullParameter(status, "status");
        AppLog.i("onKrispStatus(" + status + ')');
        StoreMediaEngine.access$getOnKrispStatusSubject$p(this.this$0).k.onNext((T) status);
        int iOrdinal = status.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            StoreMediaEngine.access$getMediaSettingsStore$p(this.this$0).setNoiseProcessing(StoreMediaSettings$NoiseProcessing.CancellationTemporarilyDisabled);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            StoreMediaEngine.access$getMediaSettingsStore$p(this.this$0).setVADUseKrisp(StoreMediaSettings$VadUseKrisp.TemporarilyDisabled);
        }
    }
}
