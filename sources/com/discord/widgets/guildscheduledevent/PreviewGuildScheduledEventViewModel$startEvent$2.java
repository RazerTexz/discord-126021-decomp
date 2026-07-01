package com.discord.widgets.guildscheduledevent;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PreviewGuildScheduledEventViewModel$startEvent$2 extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ long $eventId;
    public final /* synthetic */ Function1 $onRequestSuccess;
    public final /* synthetic */ PreviewGuildScheduledEventViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewGuildScheduledEventViewModel$startEvent$2(PreviewGuildScheduledEventViewModel previewGuildScheduledEventViewModel, Function1 function1, long j) {
        super(1);
        this.this$0 = previewGuildScheduledEventViewModel;
        this.$onRequestSuccess = function1;
        this.$eventId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        m.checkNotNullParameter(unit, "it");
        PreviewGuildScheduledEventViewModel.access$setRequestFinished(this.this$0);
        this.$onRequestSuccess.invoke(Long.valueOf(this.$eventId));
    }
}
