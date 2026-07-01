package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureUI$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview$configureUI$6(WidgetServerSettingsOverview widgetServerSettingsOverview) {
        this.this$0 = widgetServerSettingsOverview;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CheckedSetting checkedSetting = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.systemChannel.systemChannelJoinReplies");
        CheckedSetting checkedSetting2 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.e;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.systemChannel.systemChannelJoinReplies");
        checkedSetting.setChecked(!checkedSetting2.isChecked());
        StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        CheckedSetting checkedSetting3 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.e;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelJoinReplies");
        int id2 = checkedSetting3.getId();
        CheckedSetting checkedSetting4 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.e;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.systemChannel.systemChannelJoinReplies");
        statefulViewsAccess$getState$p.put(id2, Boolean.valueOf(checkedSetting4.isChecked()));
        WidgetServerSettingsOverview.access$getState$p(this.this$0).configureSaveActionView(WidgetServerSettingsOverview.access$getBinding$p(this.this$0).e);
    }
}
