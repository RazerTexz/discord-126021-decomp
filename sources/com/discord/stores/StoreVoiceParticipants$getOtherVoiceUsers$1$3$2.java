package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import j0.k.b;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$getOtherVoiceUsers$1$3$2<T, R> implements b<Map<Long, ? extends User>, Collection<? extends User>> {
    public static final StoreVoiceParticipants$getOtherVoiceUsers$1$3$2 INSTANCE = new StoreVoiceParticipants$getOtherVoiceUsers$1$3$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Collection<? extends User> call(Map<Long, ? extends User> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Collection<User> call2(Map<Long, ? extends User> map) {
        return map.values();
    }
}
