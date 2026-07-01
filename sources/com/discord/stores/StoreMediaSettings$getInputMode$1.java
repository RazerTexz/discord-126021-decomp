package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import j0.k.b;

/* JADX INFO: compiled from: StoreMediaSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaSettings$getInputMode$1<T, R> implements b<StoreMediaSettings$VoiceConfiguration, MediaEngineConnection$InputMode> {
    public static final StoreMediaSettings$getInputMode$1 INSTANCE = new StoreMediaSettings$getInputMode$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ MediaEngineConnection$InputMode call(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        return call2(storeMediaSettings$VoiceConfiguration);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final MediaEngineConnection$InputMode call2(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        return storeMediaSettings$VoiceConfiguration.getInputMode();
    }
}
