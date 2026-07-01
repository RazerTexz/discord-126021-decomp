package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildMemberVerificationForm$observeMemberVerificationFormData$1 extends o implements Function0<StoreGuildMemberVerificationForm$MemberVerificationFormData> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildMemberVerificationForm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildMemberVerificationForm$observeMemberVerificationFormData$1(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, long j) {
        super(0);
        this.this$0 = storeGuildMemberVerificationForm;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreGuildMemberVerificationForm$MemberVerificationFormData invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreGuildMemberVerificationForm$MemberVerificationFormData invoke() {
        return this.this$0.getMemberVerificationFormData(this.$guildId);
    }
}
