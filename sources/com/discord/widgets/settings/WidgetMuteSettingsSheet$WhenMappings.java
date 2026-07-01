package com.discord.widgets.settings;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMuteSettingsSheet$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        MuteSettingsSheetViewModel$SettingsType.values();
        int[] iArr = new int[7];
        $EnumSwitchMapping$0 = iArr;
        MuteSettingsSheetViewModel$SettingsType muteSettingsSheetViewModel$SettingsType = MuteSettingsSheetViewModel$SettingsType.GUILD;
        iArr[muteSettingsSheetViewModel$SettingsType.ordinal()] = 1;
        MuteSettingsSheetViewModel$SettingsType muteSettingsSheetViewModel$SettingsType2 = MuteSettingsSheetViewModel$SettingsType.DM;
        iArr[muteSettingsSheetViewModel$SettingsType2.ordinal()] = 2;
        MuteSettingsSheetViewModel$SettingsType muteSettingsSheetViewModel$SettingsType3 = MuteSettingsSheetViewModel$SettingsType.GROUP_DM;
        iArr[muteSettingsSheetViewModel$SettingsType3.ordinal()] = 3;
        iArr[MuteSettingsSheetViewModel$SettingsType.GUILD_CHANNEL.ordinal()] = 4;
        iArr[MuteSettingsSheetViewModel$SettingsType.THREAD.ordinal()] = 5;
        MuteSettingsSheetViewModel$SettingsType muteSettingsSheetViewModel$SettingsType4 = MuteSettingsSheetViewModel$SettingsType.CATEGORY;
        iArr[muteSettingsSheetViewModel$SettingsType4.ordinal()] = 6;
        MuteSettingsSheetViewModel$SettingsType.values();
        int[] iArr2 = new int[7];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[muteSettingsSheetViewModel$SettingsType3.ordinal()] = 1;
        iArr2[muteSettingsSheetViewModel$SettingsType2.ordinal()] = 2;
        MuteSettingsSheetViewModel$SettingsType.values();
        int[] iArr3 = new int[7];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[muteSettingsSheetViewModel$SettingsType2.ordinal()] = 1;
        iArr3[muteSettingsSheetViewModel$SettingsType3.ordinal()] = 2;
        iArr3[muteSettingsSheetViewModel$SettingsType.ordinal()] = 3;
        iArr3[muteSettingsSheetViewModel$SettingsType4.ordinal()] = 4;
    }
}
