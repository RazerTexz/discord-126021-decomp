package com.discord.widgets.servers.member_verification;

import com.discord.api.guildjoinrequest.ApplicationStatus;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMemberVerification$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        ApplicationStatus.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[ApplicationStatus.PENDING.ordinal()] = 1;
        iArr[ApplicationStatus.APPROVED.ordinal()] = 2;
        WidgetMemberVerificationViewModel$VerificationType.values();
        int[] iArr2 = new int[2];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[WidgetMemberVerificationViewModel$VerificationType.EMAIL.ordinal()] = 1;
        iArr2[WidgetMemberVerificationViewModel$VerificationType.PHONE.ordinal()] = 2;
    }
}
