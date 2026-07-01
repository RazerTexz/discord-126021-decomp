package com.discord.widgets.chat.list.actions;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.mobile_reports.ReportsFeatureFlag;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.tos.WidgetTosReportViolation;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$configureUI$9 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListActions$Model $data;
    public final /* synthetic */ WidgetChatListActions this$0;

    public WidgetChatListActions$configureUI$9(WidgetChatListActions widgetChatListActions, WidgetChatListActions$Model widgetChatListActions$Model) {
        this.this$0 = widgetChatListActions;
        this.$data = widgetChatListActions$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (ReportsFeatureFlag.Companion.isEnabled()) {
            WidgetMobileReports.Companion.launchMessageReport(a.x(view, "view", "view.context"), this.$data.getMessage().getId(), WidgetChatListActions.access$getChannelId$p(this.this$0));
        } else {
            WidgetTosReportViolation.Companion.show(a.x(view, "view", "view.context"), this.$data.getMessageAuthorName(), Long.valueOf(this.$data.getMessage().getChannelId()), Long.valueOf(this.$data.getMessage().getId()));
        }
        this.this$0.dismiss();
    }
}
