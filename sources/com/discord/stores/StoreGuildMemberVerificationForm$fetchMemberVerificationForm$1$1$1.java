package com.discord.stores;

import com.discord.models.domain.ModelMemberVerificationForm;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelMemberVerificationForm $memberVerificationForm;
    public final /* synthetic */ StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1$1(StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1 storeGuildMemberVerificationForm$fetchMemberVerificationForm$1$1, ModelMemberVerificationForm modelMemberVerificationForm) {
        super(0);
        this.this$0 = storeGuildMemberVerificationForm$fetchMemberVerificationForm$1$1;
        this.$memberVerificationForm = modelMemberVerificationForm;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1 storeGuildMemberVerificationForm$fetchMemberVerificationForm$1 = this.this$0.this$0;
        StoreGuildMemberVerificationForm.access$handleMemberVerificationFormFetchSuccess(storeGuildMemberVerificationForm$fetchMemberVerificationForm$1.this$0, storeGuildMemberVerificationForm$fetchMemberVerificationForm$1.$guildId, this.$memberVerificationForm);
    }
}
