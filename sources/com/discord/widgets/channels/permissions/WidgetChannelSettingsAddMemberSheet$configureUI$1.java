package com.discord.widgets.channels.permissions;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberSheet$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelSettingsAddMemberSheet this$0;

    public WidgetChannelSettingsAddMemberSheet$configureUI$1(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet) {
        this.this$0 = widgetChannelSettingsAddMemberSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelSettingsAddMemberSheet.access$addPermissionOverwrites(this.this$0);
    }
}
