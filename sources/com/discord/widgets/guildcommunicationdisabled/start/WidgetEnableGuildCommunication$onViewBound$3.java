package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableGuildCommunication$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ WidgetEnableGuildCommunication this$0;

    public WidgetEnableGuildCommunication$onViewBound$3(WidgetEnableGuildCommunication widgetEnableGuildCommunication, long j, long j2) {
        this.this$0 = widgetEnableGuildCommunication;
        this.$guildId = j;
        this.$userId = j2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEnableGuildCommunication.access$handleEnableGuildCommunication(this.this$0, this.$guildId, this.$userId);
    }
}
