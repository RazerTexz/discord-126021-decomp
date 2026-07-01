package com.discord.utilities.voice;

import android.os.Binder;
import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineForegroundService$LocalBinder extends Binder {
    private final VoiceEngineForegroundService service;

    public VoiceEngineForegroundService$LocalBinder(VoiceEngineForegroundService voiceEngineForegroundService) {
        this.service = voiceEngineForegroundService;
    }

    public final VoiceEngineForegroundService getService() {
        return this.service;
    }
}
