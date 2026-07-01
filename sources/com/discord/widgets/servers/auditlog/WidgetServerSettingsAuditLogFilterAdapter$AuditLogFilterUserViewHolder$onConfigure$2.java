package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.view.View$OnClickListener;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder this$0;

    public WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder$onConfigure$2(WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder widgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder) {
        this.this$0 = widgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MaterialRadioButton materialRadioButton = WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder.access$getBinding$p(this.this$0).f2541b;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.auditLogFilterRadioButton");
        materialRadioButton.setChecked(true);
    }
}
