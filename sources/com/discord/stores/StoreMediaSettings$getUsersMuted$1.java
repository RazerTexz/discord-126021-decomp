package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreMediaSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaSettings$getUsersMuted$1<T, R> implements b<StoreMediaSettings$VoiceConfiguration, Map<Long, ? extends Boolean>> {
    public static final StoreMediaSettings$getUsersMuted$1 INSTANCE = new StoreMediaSettings$getUsersMuted$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends Boolean> call(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        return call2(storeMediaSettings$VoiceConfiguration);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, Boolean> call2(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        return storeMediaSettings$VoiceConfiguration.getMutedUsers();
    }
}
