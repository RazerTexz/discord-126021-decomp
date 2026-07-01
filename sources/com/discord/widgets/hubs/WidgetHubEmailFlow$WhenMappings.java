package com.discord.widgets.hubs;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubEmailFlow$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        HubEmailEntryPoint.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        HubEmailEntryPoint hubEmailEntryPoint = HubEmailEntryPoint.Invite;
        iArr[hubEmailEntryPoint.ordinal()] = 1;
        HubEmailEntryPoint hubEmailEntryPoint2 = HubEmailEntryPoint.Onboarding;
        iArr[hubEmailEntryPoint2.ordinal()] = 2;
        HubEmailEntryPoint.values();
        int[] iArr2 = new int[3];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[hubEmailEntryPoint.ordinal()] = 1;
        iArr2[hubEmailEntryPoint2.ordinal()] = 2;
    }
}
