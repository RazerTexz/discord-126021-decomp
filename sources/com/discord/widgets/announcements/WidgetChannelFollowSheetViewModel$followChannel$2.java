package com.discord.widgets.announcements;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheetViewModel$followChannel$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetChannelFollowSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelFollowSheetViewModel$followChannel$2(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel) {
        super(1);
        this.this$0 = widgetChannelFollowSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        WidgetChannelFollowSheetViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) WidgetChannelFollowSheetViewModel$Event$FollowSuccess.INSTANCE);
    }
}
