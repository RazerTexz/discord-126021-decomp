package com.discord.utilities.voice;

import android.content.Context;
import android.content.ServiceConnection;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineForegroundService$Connection {
    private final ServiceConnection connection;
    private final Context context;
    private boolean isUnbinding;
    private VoiceEngineForegroundService service;

    public VoiceEngineForegroundService$Connection(Context context) {
        m.checkNotNullParameter(context, "context");
        this.context = context;
        this.connection = new VoiceEngineForegroundService$Connection$connection$1(this);
    }

    public static final /* synthetic */ VoiceEngineForegroundService access$getService$p(VoiceEngineForegroundService$Connection voiceEngineForegroundService$Connection) {
        return voiceEngineForegroundService$Connection.service;
    }

    public static final /* synthetic */ void access$setService$p(VoiceEngineForegroundService$Connection voiceEngineForegroundService$Connection, VoiceEngineForegroundService voiceEngineForegroundService) {
        voiceEngineForegroundService$Connection.service = voiceEngineForegroundService;
    }

    public final ServiceConnection getConnection() {
        return this.connection;
    }

    public final Context getContext() {
        return this.context;
    }

    public final VoiceEngineForegroundService getService() {
        return this.service;
    }

    public final synchronized boolean isUnbinding() {
        return this.isUnbinding;
    }

    public final synchronized void setUnbinding(boolean z2) {
        this.isUnbinding = z2;
    }
}
