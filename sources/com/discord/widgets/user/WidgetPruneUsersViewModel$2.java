package com.discord.widgets.user;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel$2 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetPruneUsersViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel$2(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        super(1);
        this.this$0 = widgetPruneUsersViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "canKick");
        if (bool.booleanValue()) {
            WidgetPruneUsersViewModel.access$getUpdatedPruneCount(this.this$0);
        } else {
            WidgetPruneUsersViewModel.access$updateViewState(this.this$0, new WidgetPruneUsersViewModel$ViewState$LoadFailed(true));
        }
    }
}
