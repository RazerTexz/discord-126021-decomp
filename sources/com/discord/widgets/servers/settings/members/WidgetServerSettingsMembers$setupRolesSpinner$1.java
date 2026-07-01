package com.discord.widgets.servers.settings.members;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers$setupRolesSpinner$1 implements AdapterView$OnItemSelectedListener {
    public final /* synthetic */ WidgetServerSettingsMembers$RolesSpinnerAdapter $rolesSpinnerAdapter;
    public final /* synthetic */ WidgetServerSettingsMembers this$0;

    public WidgetServerSettingsMembers$setupRolesSpinner$1(WidgetServerSettingsMembers widgetServerSettingsMembers, WidgetServerSettingsMembers$RolesSpinnerAdapter widgetServerSettingsMembers$RolesSpinnerAdapter) {
        this.this$0 = widgetServerSettingsMembers;
        this.$rolesSpinnerAdapter = widgetServerSettingsMembers$RolesSpinnerAdapter;
    }

    @Override // android.widget.AdapterView$OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
        m.checkNotNullParameter(view, "view");
        WidgetServerSettingsMembers.access$getRoleFilterPublisher$p(this.this$0).onNext(Long.valueOf(this.$rolesSpinnerAdapter.getItem(position).getId()));
    }

    @Override // android.widget.AdapterView$OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
