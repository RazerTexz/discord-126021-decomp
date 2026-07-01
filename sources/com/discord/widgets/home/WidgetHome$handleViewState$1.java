package com.discord.widgets.home;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHome$handleViewState$1 extends k implements Function1<Boolean, Unit> {
    public WidgetHome$handleViewState$1(WidgetHome widgetHome) {
        super(1, widgetHome, WidgetHome.class, "onNsfwToggle", "onNsfwToggle(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetHome.access$onNsfwToggle((WidgetHome) this.receiver, z2);
    }
}
