package com.discord.utilities.guildhash;

import com.discord.api.guildhash.GuildHashes;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildHashUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildHashUtilsKt {
    public static final boolean isSupported(GuildHashes guildHashes) {
        m.checkNotNullParameter(guildHashes, "$this$isSupported");
        return guildHashes.getVersion() == 1;
    }
}
