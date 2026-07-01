package com.discord.widgets.nux;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildTemplates$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildTemplates this$0;

    public WidgetGuildTemplates$onViewBound$3(WidgetGuildTemplates widgetGuildTemplates) {
        this.this$0 = widgetGuildTemplates;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildTemplates.access$trackPostRegistrationTransition(this.this$0, GuildTemplateAnalytics.STEP_GUILD_TEMPLATE, GuildTemplateAnalytics.STEP_GUILD_JOIN);
        WidgetNuxPostRegistrationJoin.Companion.show(this.this$0.requireContext());
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
