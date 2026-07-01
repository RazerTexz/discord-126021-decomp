package com.discord.utilities.streams;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import j0.k.b;

/* JADX INFO: compiled from: StreamContextService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamContextService$getForUser$1$2<T, R> implements b<GuildMember, String> {
    public static final StreamContextService$getForUser$1$2 INSTANCE = new StreamContextService$getForUser$1$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ String call(GuildMember guildMember) {
        return call2(guildMember);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(GuildMember guildMember) {
        if (guildMember != null) {
            return guildMember.getNick();
        }
        return null;
    }
}
