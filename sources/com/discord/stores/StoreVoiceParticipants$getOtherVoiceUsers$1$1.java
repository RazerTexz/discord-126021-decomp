package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import j0.k.b;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$getOtherVoiceUsers$1$1<T, R> implements b<Map<Long, ? extends GuildMember>, Set<? extends Long>> {
    public static final StoreVoiceParticipants$getOtherVoiceUsers$1$1 INSTANCE = new StoreVoiceParticipants$getOtherVoiceUsers$1$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends GuildMember> map) {
        return call2((Map<Long, GuildMember>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Set<Long> call2(Map<Long, GuildMember> map) {
        return map.keySet();
    }
}
