package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.Set;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$isLurkingObs$1<T1, T2, R> implements Func2<Set<? extends Long>, Guild, Boolean> {
    public static final StoreLurking$isLurkingObs$1 INSTANCE = new StoreLurking$isLurkingObs$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set, Guild guild) {
        return call2((Set<Long>) set, guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Set<Long> set, Guild guild) {
        boolean zAccess$isLurking = false;
        if (guild != null) {
            StoreLurking$Companion storeLurking$Companion = StoreLurking.Companion;
            zAccess$isLurking = guild.getJoinedAt() != null;
            long id2 = guild.getId();
            m.checkNotNullExpressionValue(set, "lurkingGuildIds");
            zAccess$isLurking = StoreLurking$Companion.access$isLurking(storeLurking$Companion, zAccess$isLurking, id2, set);
        }
        return Boolean.valueOf(zAccess$isLurking);
    }
}
