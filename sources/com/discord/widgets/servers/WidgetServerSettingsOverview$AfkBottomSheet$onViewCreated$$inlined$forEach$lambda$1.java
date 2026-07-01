package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.utilities.stateful.StatefulViews;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$AfkBottomSheet$onViewCreated$$inlined$forEach$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ CharSequence $afkTimeoutString;
    public final /* synthetic */ int $afkTimeoutValue;
    public final /* synthetic */ WidgetServerSettingsOverview $settingsFrag$inlined;
    public final /* synthetic */ WidgetServerSettingsOverview$AfkBottomSheet this$0;

    public WidgetServerSettingsOverview$AfkBottomSheet$onViewCreated$$inlined$forEach$lambda$1(CharSequence charSequence, int i, WidgetServerSettingsOverview$AfkBottomSheet widgetServerSettingsOverview$AfkBottomSheet, WidgetServerSettingsOverview widgetServerSettingsOverview) {
        this.$afkTimeoutString = charSequence;
        this.$afkTimeoutValue = i;
        this.this$0 = widgetServerSettingsOverview$AfkBottomSheet;
        this.$settingsFrag$inlined = widgetServerSettingsOverview;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsOverview widgetServerSettingsOverview = this.$settingsFrag$inlined;
        StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsOverview.access$getState$p(widgetServerSettingsOverview);
        TextView textView = WidgetServerSettingsOverview.access$getBinding$p(widgetServerSettingsOverview).f2582b.d;
        m.checkNotNullExpressionValue(textView, "binding.afk.afkTimeout");
        statefulViewsAccess$getState$p.put(textView.getId(), this.$afkTimeoutString);
        StatefulViews statefulViewsAccess$getState$p2 = WidgetServerSettingsOverview.access$getState$p(widgetServerSettingsOverview);
        LinearLayout linearLayout = WidgetServerSettingsOverview.access$getBinding$p(widgetServerSettingsOverview).f2582b.e;
        m.checkNotNullExpressionValue(linearLayout, "binding.afk.afkTimeoutWrap");
        statefulViewsAccess$getState$p2.put(linearLayout.getId(), Integer.valueOf(this.$afkTimeoutValue));
        TextView textView2 = WidgetServerSettingsOverview.access$getBinding$p(widgetServerSettingsOverview).f2582b.d;
        m.checkNotNullExpressionValue(textView2, "binding.afk.afkTimeout");
        textView2.setText(this.$afkTimeoutString);
        LinearLayout linearLayout2 = WidgetServerSettingsOverview.access$getBinding$p(widgetServerSettingsOverview).f2582b.e;
        m.checkNotNullExpressionValue(linearLayout2, "binding.afk.afkTimeoutWrap");
        linearLayout2.setTag(this.$afkTimeoutString);
        this.this$0.dismiss();
    }
}
