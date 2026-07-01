package com.discord.widgets.servers.member_verification;

import com.discord.api.guildjoinrequest.ApplicationStatus;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class MemberVerificationPendingViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        ApplicationStatus.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[ApplicationStatus.PENDING.ordinal()] = 1;
        iArr[ApplicationStatus.REJECTED.ordinal()] = 2;
    }
}
