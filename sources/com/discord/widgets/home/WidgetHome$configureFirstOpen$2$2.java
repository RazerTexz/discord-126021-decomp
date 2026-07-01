package com.discord.widgets.home;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$configureFirstOpen$2$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetHome$configureFirstOpen$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHome$configureFirstOpen$2$2(WidgetHome$configureFirstOpen$2 widgetHome$configureFirstOpen$2) {
        super(0);
        this.this$0 = widgetHome$configureFirstOpen$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetHome.access$getBinding$p(this.this$0.this$0).c.openStartPanel();
    }
}
