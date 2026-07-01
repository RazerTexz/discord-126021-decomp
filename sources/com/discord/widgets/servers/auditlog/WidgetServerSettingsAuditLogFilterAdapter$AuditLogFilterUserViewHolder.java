package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetServerSettingsAuditLogFilterUserListitemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.user.SettingsMemberView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogFilterAdapter, MGRecyclerDataPayload> {
    private final WidgetServerSettingsAuditLogFilterUserListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder(WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter) {
        super(R$layout.widget_server_settings_audit_log_filter_user_listitem, widgetServerSettingsAuditLogFilterAdapter);
        m.checkNotNullParameter(widgetServerSettingsAuditLogFilterAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.audit_log_filter_radio_button;
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) view.findViewById(R$id.audit_log_filter_radio_button);
        if (materialRadioButton != null) {
            i = R$id.item_icon;
            ImageView imageView = (ImageView) view.findViewById(R$id.item_icon);
            if (imageView != null) {
                i = R$id.non_member_text;
                TextView textView = (TextView) view.findViewById(R$id.non_member_text);
                if (textView != null) {
                    i = R$id.settings_member_view;
                    SettingsMemberView settingsMemberView = (SettingsMemberView) view.findViewById(R$id.settings_member_view);
                    if (settingsMemberView != null) {
                        WidgetServerSettingsAuditLogFilterUserListitemBinding widgetServerSettingsAuditLogFilterUserListitemBinding = new WidgetServerSettingsAuditLogFilterUserListitemBinding((FrameLayout) view, materialRadioButton, imageView, textView, settingsMemberView);
                        m.checkNotNullExpressionValue(widgetServerSettingsAuditLogFilterUserListitemBinding, "WidgetServerSettingsAudi…temBinding.bind(itemView)");
                        this.binding = widgetServerSettingsAuditLogFilterUserListitemBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter access$getAdapter$p(WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder widgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder) {
        return (WidgetServerSettingsAuditLogFilterAdapter) widgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder.adapter;
    }

    public static final /* synthetic */ WidgetServerSettingsAuditLogFilterUserListitemBinding access$getBinding$p(WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder widgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder) {
        return widgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder.binding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem widgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem = (WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem) data;
        User user = widgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem.getUser();
        boolean z2 = (widgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem.getId() == 0 || user == null) ? false : true;
        SettingsMemberView settingsMemberView = this.binding.e;
        m.checkNotNullExpressionValue(settingsMemberView, "binding.settingsMemberView");
        settingsMemberView.setVisibility(z2 ? 0 : 8);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.nonMemberText");
        textView.setVisibility(z2 ^ true ? 0 : 8);
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.itemIcon");
        imageView.setVisibility(z2 ^ true ? 0 : 8);
        if (z2) {
            SettingsMemberView settingsMemberView2 = this.binding.e;
            m.checkNotNull(user);
            settingsMemberView2.a(user, widgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem.getGuildMember());
        } else {
            TextView textView2 = this.binding.d;
            m.checkNotNullExpressionValue(textView2, "binding.nonMemberText");
            CharSequence text = widgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem.getText();
            if (text == null) {
                text = "";
            }
            textView2.setText(text);
        }
        MaterialRadioButton materialRadioButton = this.binding.f2541b;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.auditLogFilterRadioButton");
        materialRadioButton.setChecked(widgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem.getIsChecked());
        this.binding.f2541b.setOnCheckedChangeListener(new WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$1(this, widgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem));
        this.itemView.setOnClickListener(new WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$2(this));
    }
}
