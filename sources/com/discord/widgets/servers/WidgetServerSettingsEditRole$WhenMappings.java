package com.discord.widgets.servers;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEditRole$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        WidgetServerSettingsEditRole$Model$ManageStatus.values();
        int[] iArr = new int[6];
        $EnumSwitchMapping$0 = iArr;
        iArr[WidgetServerSettingsEditRole$Model$ManageStatus.CAN_MANAGE_CONDITIONAL.ordinal()] = 1;
        iArr[WidgetServerSettingsEditRole$Model$ManageStatus.CAN_MANAGE_ADMIN.ordinal()] = 2;
        WidgetServerSettingsEditRole$Model$ManageStatus.values();
        int[] iArr2 = new int[6];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[WidgetServerSettingsEditRole$Model$ManageStatus.NO_MANAGE_ROLES_PERMISSION.ordinal()] = 1;
        iArr2[WidgetServerSettingsEditRole$Model$ManageStatus.LOCKED_HIGHER.ordinal()] = 2;
        iArr2[WidgetServerSettingsEditRole$Model$ManageStatus.LOCKED_HIGHEST.ordinal()] = 3;
        iArr2[WidgetServerSettingsEditRole$Model$ManageStatus.USER_NOT_ELEVATED.ordinal()] = 4;
    }
}
