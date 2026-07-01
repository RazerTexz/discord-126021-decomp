package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreMediaSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaSettings$getUsersVolume$1<T, R> implements b<StoreMediaSettings$VoiceConfiguration, Map<Long, ? extends Float>> {
    public static final StoreMediaSettings$getUsersVolume$1 INSTANCE = new StoreMediaSettings$getUsersVolume$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends Float> call(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        return call2(storeMediaSettings$VoiceConfiguration);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, Float> call2(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        return storeMediaSettings$VoiceConfiguration.getUserOutputVolumes();
    }
}
