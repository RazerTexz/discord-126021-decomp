package com.discord.utilities.presence;

import com.discord.api.activity.ActivityType;
import com.discord.api.presence.ClientStatus;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class PresenceUtils$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        ActivityType.values();
        int[] iArr = new int[7];
        $EnumSwitchMapping$0 = iArr;
        ActivityType activityType = ActivityType.STREAMING;
        iArr[activityType.ordinal()] = 1;
        ActivityType activityType2 = ActivityType.LISTENING;
        iArr[activityType2.ordinal()] = 2;
        ActivityType activityType3 = ActivityType.WATCHING;
        iArr[activityType3.ordinal()] = 3;
        ActivityType activityType4 = ActivityType.PLAYING;
        iArr[activityType4.ordinal()] = 4;
        ActivityType activityType5 = ActivityType.COMPETING;
        iArr[activityType5.ordinal()] = 5;
        ActivityType.values();
        int[] iArr2 = new int[7];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[activityType4.ordinal()] = 1;
        iArr2[activityType2.ordinal()] = 2;
        iArr2[activityType.ordinal()] = 3;
        iArr2[activityType3.ordinal()] = 4;
        iArr2[activityType5.ordinal()] = 5;
        ClientStatus.values();
        int[] iArr3 = new int[5];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[ClientStatus.ONLINE.ordinal()] = 1;
        iArr3[ClientStatus.IDLE.ordinal()] = 2;
        iArr3[ClientStatus.DND.ordinal()] = 3;
    }
}
