package com.discord.widgets.guilds.join;

import android.view.View;
import android.view.Window;
import com.discord.app.AppActivity;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoin$ToolbarButton extends WidgetGuildJoin {
    public WidgetGuildJoin$ToolbarButton() {
        super(0, 1, null);
    }

    @Override // com.discord.widgets.guilds.join.WidgetGuildJoin, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Window window;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AnalyticsTracker.INSTANCE.joinGuildViewed();
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || (window = appActivity.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(36);
    }
}
