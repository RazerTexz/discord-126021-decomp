package com.discord.widgets.servers.member_verification;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class MemberVerificationPendingDialog$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        MemberVerificationPendingViewModel$DialogState.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState = MemberVerificationPendingViewModel$DialogState.CANCEL;
        iArr[memberVerificationPendingViewModel$DialogState.ordinal()] = 1;
        MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState2 = MemberVerificationPendingViewModel$DialogState.LEAVE;
        iArr[memberVerificationPendingViewModel$DialogState2.ordinal()] = 2;
        MemberVerificationPendingViewModel$DialogState.values();
        int[] iArr2 = new int[5];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[MemberVerificationPendingViewModel$DialogState.PENDING.ordinal()] = 1;
        iArr2[memberVerificationPendingViewModel$DialogState.ordinal()] = 2;
        iArr2[MemberVerificationPendingViewModel$DialogState.REJECTED.ordinal()] = 3;
        iArr2[memberVerificationPendingViewModel$DialogState2.ordinal()] = 4;
        iArr2[MemberVerificationPendingViewModel$DialogState.UPGRADE.ordinal()] = 5;
    }
}
