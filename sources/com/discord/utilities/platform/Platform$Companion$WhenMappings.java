package com.discord.utilities.platform;

import com.discord.api.activity.ActivityPlatform;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Platform$Companion$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        ActivityPlatform.values();
        int[] iArr = new int[9];
        $EnumSwitchMapping$0 = iArr;
        iArr[ActivityPlatform.SAMSUNG.ordinal()] = 1;
        iArr[ActivityPlatform.SPOTIFY.ordinal()] = 2;
        iArr[ActivityPlatform.XBOX.ordinal()] = 3;
        iArr[ActivityPlatform.PS4.ordinal()] = 4;
        iArr[ActivityPlatform.PS5.ordinal()] = 5;
    }
}
