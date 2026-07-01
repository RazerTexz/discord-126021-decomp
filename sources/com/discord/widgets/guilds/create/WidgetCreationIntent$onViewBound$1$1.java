package com.discord.widgets.guilds.create;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreationIntent$onViewBound$1$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetCreationIntent$onViewBound$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreationIntent$onViewBound$1$1(WidgetCreationIntent$onViewBound$1 widgetCreationIntent$onViewBound$1) {
        super(1);
        this.this$0 = widgetCreationIntent$onViewBound$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetCreationIntent.access$onSelectionPressed(this.this$0.this$0, null);
    }
}
