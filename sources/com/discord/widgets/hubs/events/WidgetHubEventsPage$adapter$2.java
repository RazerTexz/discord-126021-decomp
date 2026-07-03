package com.discord.widgets.hubs.events;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage$adapter$2 extends AbstractC12240o implements Function0<WidgetHubEventsPageAdapter> {
    public final /* synthetic */ WidgetHubEventsPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsPage$adapter$2(WidgetHubEventsPage widgetHubEventsPage) {
        super(0);
        this.this$0 = widgetHubEventsPage;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubEventsPageAdapter invoke() {
        Context contextRequireContext = this.this$0.requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return new WidgetHubEventsPageAdapter(contextRequireContext, this.this$0.getListener());
    }
}
