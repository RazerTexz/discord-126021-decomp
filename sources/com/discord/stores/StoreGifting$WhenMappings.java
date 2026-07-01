package com.discord.stores;

import com.discord.utilities.error.Error$Type;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGifting$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        Error$Type.values();
        int[] iArr = new int[18];
        $EnumSwitchMapping$0 = iArr;
        Error$Type error$Type = Error$Type.DISCORD_REQUEST_ERROR;
        iArr[error$Type.ordinal()] = 1;
        Error$Type error$Type2 = Error$Type.NETWORK;
        iArr[error$Type2.ordinal()] = 2;
        Error$Type.values();
        int[] iArr2 = new int[18];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[error$Type.ordinal()] = 1;
        iArr2[error$Type2.ordinal()] = 2;
        Error$Type.values();
        int[] iArr3 = new int[18];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[error$Type.ordinal()] = 1;
        iArr3[error$Type2.ordinal()] = 2;
    }
}
