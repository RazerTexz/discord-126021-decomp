package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureUI$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview$configureUI$5(WidgetServerSettingsOverview widgetServerSettingsOverview) {
        this.this$0 = widgetServerSettingsOverview;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CheckedSetting checkedSetting = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.c;
        m.checkNotNullExpressionValue(checkedSetting, "binding.systemChannel.systemChannelBoost");
        CheckedSetting checkedSetting2 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.c;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.systemChannel.systemChannelBoost");
        checkedSetting.setChecked(!checkedSetting2.isChecked());
        StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        CheckedSetting checkedSetting3 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.c;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelBoost");
        int id2 = checkedSetting3.getId();
        CheckedSetting checkedSetting4 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.c;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.systemChannel.systemChannelBoost");
        statefulViewsAccess$getState$p.put(id2, Boolean.valueOf(checkedSetting4.isChecked()));
        WidgetServerSettingsOverview.access$getState$p(this.this$0).configureSaveActionView(WidgetServerSettingsOverview.access$getBinding$p(this.this$0).e);
    }
}
