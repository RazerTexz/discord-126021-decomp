package com.discord.widgets.servers.guildboost;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildBoostConfirmation$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        GuildBoostInProgressViewModel$GuildBoostState.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        iArr[GuildBoostInProgressViewModel$GuildBoostState.NOT_IN_PROGRESS.ordinal()] = 1;
        iArr[GuildBoostInProgressViewModel$GuildBoostState.CALL_IN_PROGRESS.ordinal()] = 2;
        iArr[GuildBoostInProgressViewModel$GuildBoostState.ERROR.ordinal()] = 3;
        iArr[GuildBoostInProgressViewModel$GuildBoostState.COMPLETED.ordinal()] = 4;
    }
}
