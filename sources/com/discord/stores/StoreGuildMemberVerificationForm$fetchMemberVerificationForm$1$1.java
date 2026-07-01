package com.discord.stores;

import com.discord.models.domain.ModelMemberVerificationForm;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1 extends o implements Function1<ModelMemberVerificationForm, Unit> {
    public final /* synthetic */ StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1(StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1 storeGuildMemberVerificationForm$fetchMemberVerificationForm$1) {
        super(1);
        this.this$0 = storeGuildMemberVerificationForm$fetchMemberVerificationForm$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationForm modelMemberVerificationForm) {
        invoke2(modelMemberVerificationForm);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelMemberVerificationForm modelMemberVerificationForm) {
        m.checkNotNullParameter(modelMemberVerificationForm, "memberVerificationForm");
        StoreGuildMemberVerificationForm.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1$1(this, modelMemberVerificationForm));
    }
}
