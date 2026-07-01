package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.models.guild.Guild;
import j0.k.b;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$observeVerificationLevel$1<T, R> implements b<Guild, GuildVerificationLevel> {
    public static final StoreGuilds$observeVerificationLevel$1 INSTANCE = new StoreGuilds$observeVerificationLevel$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ GuildVerificationLevel call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildVerificationLevel call2(Guild guild) {
        GuildVerificationLevel verificationLevel;
        return (guild == null || (verificationLevel = guild.getVerificationLevel()) == null) ? GuildVerificationLevel.NONE : verificationLevel;
    }
}
