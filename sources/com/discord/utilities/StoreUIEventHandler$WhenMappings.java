package com.discord.utilities;

import com.discord.rtcconnection.KrispOveruseDetector$Status;
import com.discord.stores.StoreUserGuildSettings$SettingsUpdateType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreUIEventHandler$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        KrispOveruseDetector$Status.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[KrispOveruseDetector$Status.CPU_OVERUSE.ordinal()] = 1;
        iArr[KrispOveruseDetector$Status.VAD_CPU_OVERUSE.ordinal()] = 2;
        iArr[KrispOveruseDetector$Status.FAILED.ordinal()] = 3;
        StoreUserGuildSettings$SettingsUpdateType.values();
        int[] iArr2 = new int[4];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[StoreUserGuildSettings$SettingsUpdateType.GUILD.ordinal()] = 1;
        iArr2[StoreUserGuildSettings$SettingsUpdateType.CHANNEL.ordinal()] = 2;
        iArr2[StoreUserGuildSettings$SettingsUpdateType.THREAD.ordinal()] = 3;
        iArr2[StoreUserGuildSettings$SettingsUpdateType.CATEGORY.ordinal()] = 4;
    }
}
