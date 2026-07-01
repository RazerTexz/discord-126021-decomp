package com.discord.stores;

import android.content.Context;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.PowerManager;
import b.a.q.i0;
import b.c.a.a0.d;
import com.discord.rtcconnection.LowMemoryDetector;
import com.discord.rtcconnection.mediaengine.MediaEngine$c;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.systemlog.SystemLogUtils;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$EngineListener implements MediaEngine$c {
    public final /* synthetic */ StoreMediaEngine this$0;
    private final LowMemoryDetector lowMemoryDetector = new LowMemoryDetector();
    private long debugPrintableId = -1;

    public StoreMediaEngine$EngineListener(StoreMediaEngine storeMediaEngine) {
        this.this$0 = storeMediaEngine;
    }

    private final Context getContext() {
        return ApplicationProvider.INSTANCE.get();
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine$c
    public void onConnected() {
        StoreMediaEngine.access$getListenerSubject$p(this.this$0).notify(StoreMediaEngine$EngineListener$onConnected$1.INSTANCE);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine$c
    public void onConnecting() {
        StoreMediaEngine.access$getListenerSubject$p(this.this$0).notify(StoreMediaEngine$EngineListener$onConnecting$1.INSTANCE);
    }

    public void onDestroy() {
        getContext().unregisterComponentCallbacks(this.lowMemoryDetector);
        if (Build$VERSION.SDK_INT >= 29) {
            i0 i0Var = i0.n;
            synchronized (i0Var) {
                if (i0.k) {
                    d.b1("ThermalDetector", "unregister");
                    Object systemService = ApplicationProvider.INSTANCE.get().getSystemService("power");
                    Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                    ((PowerManager) systemService).removeThermalStatusListener(i0Var);
                    i0.k = false;
                    i0.l = false;
                    if (i0.m) {
                        ((Handler) i0.j.getValue()).removeCallbacks(i0Var);
                        i0.m = false;
                    }
                }
            }
            SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease().remove(this.debugPrintableId);
            this.debugPrintableId = -1L;
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine$c
    public void onNativeEngineInitialized() {
        getContext().registerComponentCallbacks(this.lowMemoryDetector);
        if (Build$VERSION.SDK_INT >= 29) {
            i0 i0Var = i0.n;
            synchronized (i0Var) {
                if (!i0.k) {
                    d.b1("ThermalDetector", "register");
                    Object systemService = ApplicationProvider.INSTANCE.get().getSystemService("power");
                    Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                    ((PowerManager) systemService).addThermalStatusListener(i0Var);
                    i0.k = true;
                }
            }
            this.debugPrintableId = SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease().add(i0Var, "ThermalDetector");
        }
        StoreMediaEngine.access$handleNativeEngineInitialized(this.this$0);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine$c
    public void onNewConnection(MediaEngineConnection connection) {
        m.checkNotNullParameter(connection, "connection");
        StoreMediaEngine.access$handleNewConnection(this.this$0, connection);
    }
}
