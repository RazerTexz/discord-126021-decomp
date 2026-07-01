package com.discord.utilities.guilds;

import com.discord.api.guildjoinrequest.ApplicationStatus;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class MemberVerificationUtils$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        ApplicationStatus.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[ApplicationStatus.APPROVED.ordinal()] = 1;
        iArr[ApplicationStatus.PENDING.ordinal()] = 2;
        iArr[ApplicationStatus.REJECTED.ordinal()] = 3;
        iArr[ApplicationStatus.STARTED.ordinal()] = 4;
        iArr[ApplicationStatus.UNKNOWN.ordinal()] = 5;
    }
}
