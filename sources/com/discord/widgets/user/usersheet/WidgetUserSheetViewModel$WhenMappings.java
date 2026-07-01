package com.discord.widgets.user.usersheet;

import com.discord.stores.StoreMediaSettings$SelfMuteFailure;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSheetViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        StoreMediaSettings$SelfMuteFailure.values();
        int[] iArr = new int[1];
        $EnumSwitchMapping$0 = iArr;
        iArr[StoreMediaSettings$SelfMuteFailure.CANNOT_USE_VAD.ordinal()] = 1;
        WidgetUserSheet$StreamPreviewClickBehavior.values();
        int[] iArr2 = new int[2];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[WidgetUserSheet$StreamPreviewClickBehavior.TARGET_AND_LAUNCH_SPECTATE.ordinal()] = 1;
        iArr2[WidgetUserSheet$StreamPreviewClickBehavior.TARGET_AND_DISMISS.ordinal()] = 2;
    }
}
