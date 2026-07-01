package com.discord.widgets.user;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel$pruneClicked$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetPruneUsersViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel$pruneClicked$2(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        super(0);
        this.this$0 = widgetPruneUsersViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetPruneUsersViewModel.access$pruneInProgress(this.this$0, false);
    }
}
