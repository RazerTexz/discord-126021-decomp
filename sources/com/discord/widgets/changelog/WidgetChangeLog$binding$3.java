package com.discord.widgets.changelog;

import com.discord.databinding.WidgetChangeLogBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChangeLog$binding$3 extends k implements Function1<WidgetChangeLogBinding, Unit> {
    public WidgetChangeLog$binding$3(WidgetChangeLog widgetChangeLog) {
        super(1, widgetChangeLog, WidgetChangeLog.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetChangeLogBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeLogBinding widgetChangeLogBinding) {
        invoke2(widgetChangeLogBinding);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChangeLogBinding widgetChangeLogBinding) {
        m.checkNotNullParameter(widgetChangeLogBinding, "p1");
        WidgetChangeLog.access$onViewBindingDestroy((WidgetChangeLog) this.receiver, widgetChangeLogBinding);
    }
}
