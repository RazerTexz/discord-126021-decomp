package com.discord.widgets.status;

import com.discord.stores.StoreConnectivity$State;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGlobalStatusIndicatorViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        StoreConnectivity$State.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        iArr[StoreConnectivity$State.ONLINE.ordinal()] = 1;
        iArr[StoreConnectivity$State.CONNECTING.ordinal()] = 2;
        iArr[StoreConnectivity$State.OFFLINE.ordinal()] = 3;
        iArr[StoreConnectivity$State.OFFLINE_AIRPLANE_MODE.ordinal()] = 4;
    }
}
