package com.discord.stores;

import com.discord.utilities.error.Error$Type;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreInstantInvites$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        Error$Type.values();
        int[] iArr = new int[18];
        $EnumSwitchMapping$0 = iArr;
        iArr[Error$Type.DISCORD_REQUEST_ERROR.ordinal()] = 1;
        iArr[Error$Type.NETWORK.ordinal()] = 2;
    }
}
