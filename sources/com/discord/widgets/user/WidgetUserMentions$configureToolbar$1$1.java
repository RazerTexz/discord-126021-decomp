package com.discord.widgets.user;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$configureToolbar$1$1 extends o implements Function1<WidgetUserMentions$Model$MessageLoader$Filters, Unit> {
    public final /* synthetic */ WidgetUserMentions$configureToolbar$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$configureToolbar$1$1(WidgetUserMentions$configureToolbar$1 widgetUserMentions$configureToolbar$1) {
        super(1);
        this.this$0 = widgetUserMentions$configureToolbar$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$Filters) {
        invoke2(widgetUserMentions$Model$MessageLoader$Filters);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$Filters) {
        m.checkNotNullParameter(widgetUserMentions$Model$MessageLoader$Filters, "filters");
        WidgetUserMentions.access$getMentionsLoader$p(this.this$0.this$0).setFilters(widgetUserMentions$Model$MessageLoader$Filters);
    }
}
