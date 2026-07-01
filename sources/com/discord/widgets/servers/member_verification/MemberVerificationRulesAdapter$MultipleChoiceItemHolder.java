package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import b.a.i.r5;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.databinding.WidgetMemberVerificationMultipleChoiceItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemMultipleChoice;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter$MultipleChoiceItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
    private final WidgetMemberVerificationMultipleChoiceItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationRulesAdapter$MultipleChoiceItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
        super(R$layout.widget_member_verification_multiple_choice_item, memberVerificationRulesAdapter);
        m.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        RadioGroup radioGroup = (RadioGroup) view;
        WidgetMemberVerificationMultipleChoiceItemBinding widgetMemberVerificationMultipleChoiceItemBinding = new WidgetMemberVerificationMultipleChoiceItemBinding(radioGroup, radioGroup);
        m.checkNotNullExpressionValue(widgetMemberVerificationMultipleChoiceItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
        this.binding = widgetMemberVerificationMultipleChoiceItemBinding;
    }

    public static final /* synthetic */ MemberVerificationRulesAdapter access$getAdapter$p(MemberVerificationRulesAdapter$MultipleChoiceItemHolder memberVerificationRulesAdapter$MultipleChoiceItemHolder) {
        return (MemberVerificationRulesAdapter) memberVerificationRulesAdapter$MultipleChoiceItemHolder.adapter;
    }

    private final void createMultipleChoiceButtons(Context context, RadioGroup radioGroup, List<String> valueList, Function1<? super Integer, Unit> onItemSelected) {
        RadioButton radioButton;
        for (String str : valueList) {
            int iIndexOf = valueList.indexOf(str);
            if (iIndexOf >= radioGroup.getChildCount()) {
                View viewInflate = LayoutInflater.from(context).inflate(R$layout.widget_member_verification_multiple_choice_radio_item, (ViewGroup) radioGroup, false);
                Objects.requireNonNull(viewInflate, "rootView");
                radioButton = (RadioButton) viewInflate;
                m.checkNotNullExpressionValue(new r5(radioButton), "WidgetMemberVerification…        false\n          )");
                m.checkNotNullExpressionValue(radioButton, "WidgetMemberVerification…   false\n          ).root");
                radioGroup.addView(radioButton);
            } else {
                View childAt = this.binding.f2490b.getChildAt(iIndexOf);
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
                radioButton = (RadioButton) childAt;
            }
            RadioButton radioButton2 = radioButton;
            radioButton2.setText(str);
            radioButton2.setOnCheckedChangeListener(new MemberVerificationRulesAdapter$MultipleChoiceItemHolder$createMultipleChoiceButtons$$inlined$forEach$lambda$1(iIndexOf, this, valueList, radioGroup, context, onItemSelected));
        }
        int childCount = radioGroup.getChildCount();
        for (int size = valueList.size(); size < childCount; size++) {
            View childAt2 = this.binding.f2490b.getChildAt(size);
            m.checkNotNullExpressionValue(childAt2, "radioButton");
            childAt2.setVisibility(8);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MemberVerificationItemMultipleChoice memberVerificationItemMultipleChoice = (MemberVerificationItemMultipleChoice) data;
        Integer response = memberVerificationItemMultipleChoice.getResponse();
        Context contextX = a.x(this.itemView, "itemView", "itemView.context");
        RadioGroup radioGroup = this.binding.f2490b;
        m.checkNotNullExpressionValue(radioGroup, "binding.memberVerificationMultipleChoiceRadioGroup");
        createMultipleChoiceButtons(contextX, radioGroup, memberVerificationItemMultipleChoice.getChoices(), new MemberVerificationRulesAdapter$MultipleChoiceItemHolder$onConfigure$1(this, data));
        if (response != null) {
            View childAt = this.binding.f2490b.getChildAt(response.intValue());
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
            ((RadioButton) childAt).setChecked(true);
        }
    }
}
