package com.discord.widgets.user;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel$pruneClicked$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetPruneUsersViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel$pruneClicked$1(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        super(1);
        this.this$0 = widgetPruneUsersViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        WidgetPruneUsersViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) WidgetPruneUsersViewModel$Event$Dismiss.INSTANCE);
    }
}
