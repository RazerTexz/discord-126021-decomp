package com.discord.widgets.home;

import com.discord.stores.StoreNavigation$PanelAction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHomeViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        StoreNavigation$PanelAction.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        iArr[StoreNavigation$PanelAction.OPEN.ordinal()] = 1;
        iArr[StoreNavigation$PanelAction.CLOSE.ordinal()] = 2;
        iArr[StoreNavigation$PanelAction.UNLOCK_LEFT.ordinal()] = 3;
        iArr[StoreNavigation$PanelAction.NOOP.ordinal()] = 4;
    }
}
