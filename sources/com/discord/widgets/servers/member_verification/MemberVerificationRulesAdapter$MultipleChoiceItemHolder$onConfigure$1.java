package com.discord.widgets.servers.member_verification;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemMultipleChoice;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter$MultipleChoiceItemHolder$onConfigure$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ MGRecyclerDataPayload $data;
    public final /* synthetic */ MemberVerificationRulesAdapter$MultipleChoiceItemHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationRulesAdapter$MultipleChoiceItemHolder$onConfigure$1(MemberVerificationRulesAdapter$MultipleChoiceItemHolder memberVerificationRulesAdapter$MultipleChoiceItemHolder, MGRecyclerDataPayload mGRecyclerDataPayload) {
        super(1);
        this.this$0 = memberVerificationRulesAdapter$MultipleChoiceItemHolder;
        this.$data = mGRecyclerDataPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        MemberVerificationRulesAdapter$MultipleChoiceItemHolder.access$getAdapter$p(this.this$0).getOnUserInputDataEntered().invoke(Integer.valueOf(((MemberVerificationItemMultipleChoice) this.$data).getFieldIndex()), Integer.valueOf(i));
    }
}
