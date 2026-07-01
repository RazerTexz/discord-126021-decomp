package com.discord.widgets.user;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel$getUpdatedPruneCount$5 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ WidgetPruneUsersViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel$getUpdatedPruneCount$5(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        super(1);
        this.this$0 = widgetPruneUsersViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, "request");
        Subscription subscriptionAccess$getPruneCountRequest$p = WidgetPruneUsersViewModel.access$getPruneCountRequest$p(this.this$0);
        if (subscriptionAccess$getPruneCountRequest$p != null) {
            subscriptionAccess$getPruneCountRequest$p.unsubscribe();
        }
        WidgetPruneUsersViewModel.access$setPruneCountRequest$p(this.this$0, subscription);
    }
}
