package com.discord.widgets.guilds.list;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList$onViewBound$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetGuildsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsList$onViewBound$2(WidgetGuildsList widgetGuildsList) {
        super(1);
        this.this$0 = widgetGuildsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetGuildsList.access$setGuildListAddHint$p(this.this$0, view);
        View viewAccess$getGuildListAddHint$p = WidgetGuildsList.access$getGuildListAddHint$p(this.this$0);
        if (viewAccess$getGuildListAddHint$p != null) {
            viewAccess$getGuildListAddHint$p.setOnClickListener(new WidgetGuildsList$onViewBound$2$1(this));
        }
    }
}
