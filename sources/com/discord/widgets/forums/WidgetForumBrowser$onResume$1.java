package com.discord.widgets.forums;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowser$onResume$1 extends o implements Function1<WidgetForumBrowserViewModel$Event, Unit> {
    public final /* synthetic */ WidgetForumBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowser$onResume$1(WidgetForumBrowser widgetForumBrowser) {
        super(1);
        this.this$0 = widgetForumBrowser;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetForumBrowserViewModel$Event widgetForumBrowserViewModel$Event) {
        invoke2(widgetForumBrowserViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetForumBrowserViewModel$Event widgetForumBrowserViewModel$Event) {
        m.checkNotNullParameter(widgetForumBrowserViewModel$Event, "event");
        WidgetForumBrowser.access$handleEvent(this.this$0, widgetForumBrowserViewModel$Event);
    }
}
