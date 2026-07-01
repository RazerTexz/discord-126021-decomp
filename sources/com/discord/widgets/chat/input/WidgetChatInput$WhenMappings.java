package com.discord.widgets.chat.input;

import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.ApplicationStatus;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatInput$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        ApplicationStatus.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[ApplicationStatus.REJECTED.ordinal()] = 1;
        iArr[ApplicationStatus.PENDING.ordinal()] = 2;
        GuildVerificationLevel.values();
        int[] iArr2 = new int[5];
        $EnumSwitchMapping$1 = iArr2;
        GuildVerificationLevel guildVerificationLevel = GuildVerificationLevel.LOW;
        iArr2[guildVerificationLevel.ordinal()] = 1;
        iArr2[GuildVerificationLevel.MEDIUM.ordinal()] = 2;
        iArr2[GuildVerificationLevel.HIGH.ordinal()] = 3;
        GuildVerificationLevel guildVerificationLevel2 = GuildVerificationLevel.HIGHEST;
        iArr2[guildVerificationLevel2.ordinal()] = 4;
        GuildVerificationLevel.values();
        int[] iArr3 = new int[5];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[guildVerificationLevel.ordinal()] = 1;
        iArr3[guildVerificationLevel2.ordinal()] = 2;
    }
}
