package com.discord.widgets.directories;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoriesSearchViewModel$1 extends k implements Function1<WidgetDirectoriesSearchViewModel$ViewState, Unit> {
    public WidgetDirectoriesSearchViewModel$1(WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel) {
        super(1, widgetDirectoriesSearchViewModel, WidgetDirectoriesSearchViewModel.class, "handleNewState", "handleNewState(Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesSearchViewModel$ViewState widgetDirectoriesSearchViewModel$ViewState) {
        invoke2(widgetDirectoriesSearchViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetDirectoriesSearchViewModel$ViewState widgetDirectoriesSearchViewModel$ViewState) {
        m.checkNotNullParameter(widgetDirectoriesSearchViewModel$ViewState, "p1");
        WidgetDirectoriesSearchViewModel.access$handleNewState((WidgetDirectoriesSearchViewModel) this.receiver, widgetDirectoriesSearchViewModel$ViewState);
    }
}
