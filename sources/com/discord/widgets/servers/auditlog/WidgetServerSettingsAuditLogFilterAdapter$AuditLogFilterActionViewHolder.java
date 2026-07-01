package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetServerSettingsAuditLogFilterActionListitemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogFilterAdapter, MGRecyclerDataPayload> {
    private final WidgetServerSettingsAuditLogFilterActionListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder(WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter) {
        super(R$layout.widget_server_settings_audit_log_filter_action_listitem, widgetServerSettingsAuditLogFilterAdapter);
        m.checkNotNullParameter(widgetServerSettingsAuditLogFilterAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.audit_log_filter_cs;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.audit_log_filter_cs);
        if (checkedSetting != null) {
            i = R$id.audit_log_filter_image_action;
            ImageView imageView = (ImageView) view.findViewById(R$id.audit_log_filter_image_action);
            if (imageView != null) {
                i = R$id.audit_log_filter_image_container;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.audit_log_filter_image_container);
                if (frameLayout != null) {
                    i = R$id.audit_log_filter_image_target;
                    ImageView imageView2 = (ImageView) view.findViewById(R$id.audit_log_filter_image_target);
                    if (imageView2 != null) {
                        WidgetServerSettingsAuditLogFilterActionListitemBinding widgetServerSettingsAuditLogFilterActionListitemBinding = new WidgetServerSettingsAuditLogFilterActionListitemBinding((LinearLayout) view, checkedSetting, imageView, frameLayout, imageView2);
                        m.checkNotNullExpressionValue(widgetServerSettingsAuditLogFilterActionListitemBinding, "WidgetServerSettingsAudi…temBinding.bind(itemView)");
                        this.binding = widgetServerSettingsAuditLogFilterActionListitemBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter access$getAdapter$p(WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder widgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder) {
        return (WidgetServerSettingsAuditLogFilterAdapter) widgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem widgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem = (WidgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem) data;
        ImageView imageView = this.binding.d;
        AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        imageView.setImageResource(auditLogUtils.getTargetTypeImage(view, widgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem.getActionId()));
        this.binding.c.setImageResource(auditLogUtils.getActionTypeImage(widgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem.getActionId()));
        this.binding.f2540b.setText(widgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem.getText());
        CheckedSetting checkedSetting = this.binding.f2540b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.auditLogFilterCs");
        checkedSetting.setChecked(widgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem.getIsChecked());
        this.binding.f2540b.setOnCheckedListener(new WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder$onConfigure$1(this, widgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem));
    }
}
