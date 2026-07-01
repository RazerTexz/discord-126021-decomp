package com.discord.widgets.servers.member_verification;

import android.view.View;
import com.discord.R$layout;
import com.discord.databinding.WidgetMemberVerificationApproveTermsItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemApproveTerms;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter$ApproveTermsItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
    private final WidgetMemberVerificationApproveTermsItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationRulesAdapter$ApproveTermsItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
        super(R$layout.widget_member_verification_approve_terms_item, memberVerificationRulesAdapter);
        m.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        CheckedSetting checkedSetting = (CheckedSetting) view;
        WidgetMemberVerificationApproveTermsItemBinding widgetMemberVerificationApproveTermsItemBinding = new WidgetMemberVerificationApproveTermsItemBinding(checkedSetting, checkedSetting);
        m.checkNotNullExpressionValue(widgetMemberVerificationApproveTermsItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
        this.binding = widgetMemberVerificationApproveTermsItemBinding;
    }

    public static final /* synthetic */ MemberVerificationRulesAdapter access$getAdapter$p(MemberVerificationRulesAdapter$ApproveTermsItemHolder memberVerificationRulesAdapter$ApproveTermsItemHolder) {
        return (MemberVerificationRulesAdapter) memberVerificationRulesAdapter$ApproveTermsItemHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MemberVerificationItemApproveTerms memberVerificationItemApproveTerms = (MemberVerificationItemApproveTerms) data;
        CheckedSetting checkedSetting = this.binding.f2487b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.memberVerificationRulesCheck");
        checkedSetting.setChecked(memberVerificationItemApproveTerms.isApproved());
        this.binding.f2487b.e(new MemberVerificationRulesAdapter$ApproveTermsItemHolder$onConfigure$1(this, memberVerificationItemApproveTerms));
    }
}
