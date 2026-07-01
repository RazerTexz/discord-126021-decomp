package com.discord.widgets.donut;

import android.content.Context;
import b.a.d.j;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetDonutBetaPopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDonutBetaPopup$Companion {
    private WidgetDonutBetaPopup$Companion() {
    }

    public final void show(Context context, String source) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(source, "source");
        AnalyticsTracker.openModal$default("Project Donut Android Beta Required", source, null, 4, null);
        j.e(context, WidgetDonutBetaPopup.class, null, 4);
    }

    public /* synthetic */ WidgetDonutBetaPopup$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
