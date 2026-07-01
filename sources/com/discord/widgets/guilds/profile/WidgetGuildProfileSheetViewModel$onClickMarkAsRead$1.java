package com.discord.widgets.guilds.profile;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel$onClickMarkAsRead$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetGuildProfileSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheetViewModel$onClickMarkAsRead$1(WidgetGuildProfileSheetViewModel widgetGuildProfileSheetViewModel) {
        super(1);
        this.this$0 = widgetGuildProfileSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r3) {
        WidgetGuildProfileSheetViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) new WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast(2131892707));
    }
}
