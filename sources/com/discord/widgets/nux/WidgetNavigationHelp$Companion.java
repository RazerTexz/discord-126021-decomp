package com.discord.widgets.nux;

import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetNavigationHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNavigationHelp$Companion {
    private WidgetNavigationHelp$Companion() {
    }

    public final void show(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        AnalyticsTracker.openModal$default("Help Nav", "Guild List", null, 4, null);
        new WidgetNavigationHelp().show(fragmentManager, "javaClass");
    }

    public /* synthetic */ WidgetNavigationHelp$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
