package com.discord.widgets.servers.member_verification;

import android.view.View;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetMemberVerificationTextInputItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTextInput;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter$TextInputItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
    private final WidgetMemberVerificationTextInputItemBinding binding;
    private int fieldIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationRulesAdapter$TextInputItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
        super(R$layout.widget_member_verification_text_input_item, memberVerificationRulesAdapter);
        m.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
        View view = this.itemView;
        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R$id.member_verification_text_input_field);
        if (textInputEditText == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.member_verification_text_input_field)));
        }
        WidgetMemberVerificationTextInputItemBinding widgetMemberVerificationTextInputItemBinding = new WidgetMemberVerificationTextInputItemBinding((TextInputLayout) view, textInputEditText);
        m.checkNotNullExpressionValue(widgetMemberVerificationTextInputItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
        this.binding = widgetMemberVerificationTextInputItemBinding;
        m.checkNotNullExpressionValue(textInputEditText, "binding.memberVerificationTextInputField");
        TextWatcherKt.addBindedTextWatcher(textInputEditText, memberVerificationRulesAdapter.getFragment(), new MemberVerificationRulesAdapter$TextInputItemHolder$1(this, memberVerificationRulesAdapter));
    }

    public static final /* synthetic */ int access$getFieldIndex$p(MemberVerificationRulesAdapter$TextInputItemHolder memberVerificationRulesAdapter$TextInputItemHolder) {
        return memberVerificationRulesAdapter$TextInputItemHolder.fieldIndex;
    }

    public static final /* synthetic */ void access$setFieldIndex$p(MemberVerificationRulesAdapter$TextInputItemHolder memberVerificationRulesAdapter$TextInputItemHolder, int i) {
        memberVerificationRulesAdapter$TextInputItemHolder.fieldIndex = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MemberVerificationItemTextInput memberVerificationItemTextInput = (MemberVerificationItemTextInput) data;
        this.fieldIndex = memberVerificationItemTextInput.getFieldIndex();
        this.binding.f2495b.setText(memberVerificationItemTextInput.getResponse());
        TextInputEditText textInputEditText = this.binding.f2495b;
        String response = memberVerificationItemTextInput.getResponse();
        textInputEditText.setSelection(response != null ? response.length() : 0);
    }
}
