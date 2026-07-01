package com.discord.widgets.user.search;

import com.discord.api.presence.ClientStatus;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearchScoreStrategy$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        ClientStatus.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[ClientStatus.ONLINE.ordinal()] = 1;
        iArr[ClientStatus.IDLE.ordinal()] = 2;
        iArr[ClientStatus.DND.ordinal()] = 3;
    }
}
