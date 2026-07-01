package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetMemberVerificationRuleItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTerm;
import d0.z.d.m;

/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter$TermItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
    private final WidgetMemberVerificationRuleItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationRulesAdapter$TermItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
        super(R$layout.widget_member_verification_rule_item, memberVerificationRulesAdapter);
        m.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.member_verification_rule_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.member_verification_rule_container);
        if (linearLayout != null) {
            i = R$id.member_verification_rule_description;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R$id.member_verification_rule_description);
            if (simpleDraweeSpanTextView != null) {
                i = R$id.member_verification_rule_divider;
                View viewFindViewById = view.findViewById(R$id.member_verification_rule_divider);
                if (viewFindViewById != null) {
                    i = R$id.member_verification_rule_index;
                    TextView textView = (TextView) view.findViewById(R$id.member_verification_rule_index);
                    if (textView != null) {
                        RoundedRelativeLayout roundedRelativeLayout = (RoundedRelativeLayout) view;
                        WidgetMemberVerificationRuleItemBinding widgetMemberVerificationRuleItemBinding = new WidgetMemberVerificationRuleItemBinding(roundedRelativeLayout, linearLayout, simpleDraweeSpanTextView, viewFindViewById, textView, roundedRelativeLayout);
                        m.checkNotNullExpressionValue(widgetMemberVerificationRuleItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
                        this.binding = widgetMemberVerificationRuleItemBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MemberVerificationItemTerm memberVerificationItemTerm = (MemberVerificationItemTerm) data;
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.memberVerificationRuleIndex");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        m.checkNotNullExpressionValue(resources, "itemView.resources");
        int index = memberVerificationItemTerm.getIndex();
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        Context context = view2.getContext();
        m.checkNotNullExpressionValue(context, "itemView.context");
        textView.setText(b.i(resources, 2131892908, new Object[]{StringUtilsKt.format(index, context)}, null, 4));
        this.binding.f2493b.setDraweeSpanStringBuilder(AstRenderer.render(memberVerificationItemTerm.getAst(), new MessageRenderContext(a.x(this.itemView, "itemView", "itemView.context"), 0L, memberVerificationItemTerm.getAllowAnimatedEmojis(), null, memberVerificationItemTerm.getChannelNames(), memberVerificationItemTerm.getRoles(), 0, null, null, 0, 0, null, null, null, 16328, null)));
        View view3 = this.binding.c;
        m.checkNotNullExpressionValue(view3, "binding.memberVerificationRuleDivider");
        view3.setVisibility(memberVerificationItemTerm.isLastItem() ^ true ? 0 : 8);
        float fDpToPixels = DimenUtils.dpToPixels(4);
        if (memberVerificationItemTerm.isFirstItem()) {
            this.binding.e.updateTopLeftRadius(fDpToPixels);
            this.binding.e.updateTopRightRadius(fDpToPixels);
        }
        if (memberVerificationItemTerm.isLastItem()) {
            this.binding.e.updateBottomLeftRadius(fDpToPixels);
            this.binding.e.updateBottomRightRadius(fDpToPixels);
        }
    }
}
