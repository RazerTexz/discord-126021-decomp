package com.discord.utilities.guildhash;

import com.discord.api.guildhash.GuildHashes;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.guildhash.GuildHashUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: GuildHashUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildHashUtils {
    public static final boolean isSupported(GuildHashes guildHashes) {
        Intrinsics3.checkNotNullParameter(guildHashes, "$this$isSupported");
        return guildHashes.getVersion() == 1;
    }
}
