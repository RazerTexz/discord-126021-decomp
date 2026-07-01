package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings$setOnItemSelected$1 implements AdapterView$OnItemSelectedListener {
    public final /* synthetic */ WidgetGuildInviteSettings this$0;

    public WidgetGuildInviteSettings$setOnItemSelected$1(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        this.this$0 = widgetGuildInviteSettings;
    }

    @Override // android.widget.AdapterView$OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(view, "view");
        WidgetGuildInviteSettings.access$getViewModel$p(this.this$0).selectChannel(WidgetGuildInviteSettings.access$getChannelsSpinnerAdapter$p(this.this$0).getItem(position));
    }

    @Override // android.widget.AdapterView$OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
        m.checkNotNullParameter(parent, "parent");
    }
}
