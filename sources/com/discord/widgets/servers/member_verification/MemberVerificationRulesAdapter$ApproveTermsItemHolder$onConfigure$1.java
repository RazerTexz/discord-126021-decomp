package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemApproveTerms;

/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter$ApproveTermsItemHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ MemberVerificationItemApproveTerms $approveTerms;
    public final /* synthetic */ MemberVerificationRulesAdapter$ApproveTermsItemHolder this$0;

    public MemberVerificationRulesAdapter$ApproveTermsItemHolder$onConfigure$1(MemberVerificationRulesAdapter$ApproveTermsItemHolder memberVerificationRulesAdapter$ApproveTermsItemHolder, MemberVerificationItemApproveTerms memberVerificationItemApproveTerms) {
        this.this$0 = memberVerificationRulesAdapter$ApproveTermsItemHolder;
        this.$approveTerms = memberVerificationItemApproveTerms;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MemberVerificationRulesAdapter$ApproveTermsItemHolder.access$getAdapter$p(this.this$0).getOnUpdateRulesApproval().invoke(Boolean.valueOf(!this.$approveTerms.isApproved()));
    }
}
