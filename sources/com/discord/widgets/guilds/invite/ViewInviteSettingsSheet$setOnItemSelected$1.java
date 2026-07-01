package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewInviteSettingsSheet$setOnItemSelected$1 implements AdapterView$OnItemSelectedListener {
    public final /* synthetic */ ViewInviteSettingsSheet this$0;

    public ViewInviteSettingsSheet$setOnItemSelected$1(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        this.this$0 = viewInviteSettingsSheet;
    }

    @Override // android.widget.AdapterView$OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(view, "view");
        this.this$0.getViewModel().selectChannel(ViewInviteSettingsSheet.access$getChannelsSpinnerAdapter$p(this.this$0).getItem(position).getId());
    }

    @Override // android.widget.AdapterView$OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
        m.checkNotNullParameter(parent, "parent");
    }
}
