package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: StoreMediaSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaSettings$isSelfMuted$1<T, R> implements b<StoreMediaSettings$VoiceConfiguration, Boolean> {
    public static final StoreMediaSettings$isSelfMuted$1 INSTANCE = new StoreMediaSettings$isSelfMuted$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        return call2(storeMediaSettings$VoiceConfiguration);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        return Boolean.valueOf(storeMediaSettings$VoiceConfiguration.isSelfMuted());
    }
}
