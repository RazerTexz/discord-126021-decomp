package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.widget.TextView;
import com.discord.R$layout;
import com.discord.databinding.WidgetMemberVerificationHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemHeader;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter$ItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
    private final WidgetMemberVerificationHeaderItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationRulesAdapter$ItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
        super(R$layout.widget_member_verification_header_item, memberVerificationRulesAdapter);
        m.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        WidgetMemberVerificationHeaderItemBinding widgetMemberVerificationHeaderItemBinding = new WidgetMemberVerificationHeaderItemBinding(textView, textView);
        m.checkNotNullExpressionValue(widgetMemberVerificationHeaderItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
        this.binding = widgetMemberVerificationHeaderItemBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f2489b;
        m.checkNotNullExpressionValue(textView, "binding.memberVerificationRulesHeader");
        textView.setText(((MemberVerificationItemHeader) data).getTitle());
    }
}
