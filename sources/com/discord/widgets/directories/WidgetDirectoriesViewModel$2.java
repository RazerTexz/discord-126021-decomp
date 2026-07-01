package com.discord.widgets.directories;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoriesViewModel$2 extends k implements Function1<WidgetDirectoriesViewModel$ViewState, Unit> {
    public WidgetDirectoriesViewModel$2(WidgetDirectoriesViewModel widgetDirectoriesViewModel) {
        super(1, widgetDirectoriesViewModel, WidgetDirectoriesViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        invoke2(widgetDirectoriesViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        m.checkNotNullParameter(widgetDirectoriesViewModel$ViewState, "p1");
        WidgetDirectoriesViewModel.access$updateViewState((WidgetDirectoriesViewModel) this.receiver, widgetDirectoriesViewModel$ViewState);
    }
}
