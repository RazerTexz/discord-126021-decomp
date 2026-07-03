package com.discord.utilities.guildhash;

import com.discord.api.guildhash.GuildHashes;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildHashUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildHashUtilsKt {
    public static final boolean isSupported(GuildHashes guildHashes) {
        C12238m.checkNotNullParameter(guildHashes, "$this$isSupported");
        return guildHashes.getVersion() == 1;
    }
}
