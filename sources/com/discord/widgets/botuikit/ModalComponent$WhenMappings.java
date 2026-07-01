package com.discord.widgets.botuikit;

import com.discord.stores.StoreApplicationInteractions$SentInteractionState;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ModalComponent$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        StoreApplicationInteractions$SentInteractionState.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[StoreApplicationInteractions$SentInteractionState.SUCCESS.ordinal()] = 1;
        iArr[StoreApplicationInteractions$SentInteractionState.FAILURE.ordinal()] = 2;
    }
}
