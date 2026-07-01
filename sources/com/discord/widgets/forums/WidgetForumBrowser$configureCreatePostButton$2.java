package com.discord.widgets.forums;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowser$configureCreatePostButton$2 extends o implements Function2<Long, Long, Unit> {
    public final /* synthetic */ WidgetForumBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowser$configureCreatePostButton$2(WidgetForumBrowser widgetForumBrowser) {
        super(2);
        this.this$0 = widgetForumBrowser;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
        invoke(l.longValue(), l2.longValue());
        return Unit.a;
    }

    public final void invoke(long j, long j2) {
        WidgetForumBrowser.access$openCreatePostScreen(this.this$0, j, j2);
    }
}
