package com.discord.widgets.servers.member_verification;

import com.discord.models.domain.ModelMemberVerificationForm$MemberVerificationFieldType;
import com.discord.stores.StoreGuildMemberVerificationForm$FetchStates;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMemberVerificationViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        StoreGuildMemberVerificationForm$FetchStates.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[StoreGuildMemberVerificationForm$FetchStates.FETCHING.ordinal()] = 1;
        iArr[StoreGuildMemberVerificationForm$FetchStates.SUCCEEDED.ordinal()] = 2;
        iArr[StoreGuildMemberVerificationForm$FetchStates.FAILED.ordinal()] = 3;
        ModelMemberVerificationForm$MemberVerificationFieldType.values();
        int[] iArr2 = new int[5];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[ModelMemberVerificationForm$MemberVerificationFieldType.TERMS.ordinal()] = 1;
        iArr2[ModelMemberVerificationForm$MemberVerificationFieldType.TEXT_INPUT.ordinal()] = 2;
        iArr2[ModelMemberVerificationForm$MemberVerificationFieldType.PARAGRAPH.ordinal()] = 3;
        iArr2[ModelMemberVerificationForm$MemberVerificationFieldType.MULTIPLE_CHOICE.ordinal()] = 4;
    }
}
