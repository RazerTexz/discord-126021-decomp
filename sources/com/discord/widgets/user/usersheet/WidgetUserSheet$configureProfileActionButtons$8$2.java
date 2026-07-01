package com.discord.widgets.user.usersheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureProfileActionButtons$8$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetUserSheet$configureProfileActionButtons$8 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$configureProfileActionButtons$8$2(WidgetUserSheet$configureProfileActionButtons$8 widgetUserSheet$configureProfileActionButtons$8) {
        super(0);
        this.this$0 = widgetUserSheet$configureProfileActionButtons$8;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetUserSheet$configureProfileActionButtons$8 widgetUserSheet$configureProfileActionButtons$8 = this.this$0;
        WidgetUserSheet.access$acceptFriendRequest(widgetUserSheet$configureProfileActionButtons$8.this$0, widgetUserSheet$configureProfileActionButtons$8.$viewState.getUser().getUsername());
    }
}
