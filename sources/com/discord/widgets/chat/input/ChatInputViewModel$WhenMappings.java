package com.discord.widgets.chat.input;

import com.discord.api.guild.GuildVerificationLevel;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ChatInputViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        GuildVerificationLevel.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[GuildVerificationLevel.LOW.ordinal()] = 1;
        iArr[GuildVerificationLevel.HIGHEST.ordinal()] = 2;
        iArr[GuildVerificationLevel.NONE.ordinal()] = 3;
        iArr[GuildVerificationLevel.MEDIUM.ordinal()] = 4;
        iArr[GuildVerificationLevel.HIGH.ordinal()] = 5;
    }
}
