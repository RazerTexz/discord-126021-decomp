package com.discord.widgets.guildscheduledevent;

import com.discord.api.stageinstance.StageInstance;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PreviewGuildScheduledEventViewModel$startStageEvent$2 extends o implements Function1<StageInstance, Unit> {
    public final /* synthetic */ Long $eventId;
    public final /* synthetic */ Function1 $onRequestSuccess;
    public final /* synthetic */ PreviewGuildScheduledEventViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewGuildScheduledEventViewModel$startStageEvent$2(PreviewGuildScheduledEventViewModel previewGuildScheduledEventViewModel, Function1 function1, Long l) {
        super(1);
        this.this$0 = previewGuildScheduledEventViewModel;
        this.$onRequestSuccess = function1;
        this.$eventId = l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
        invoke2(stageInstance);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StageInstance stageInstance) {
        m.checkNotNullParameter(stageInstance, "it");
        PreviewGuildScheduledEventViewModel.access$setRequestFinished(this.this$0);
        this.$onRequestSuccess.invoke(this.$eventId);
    }
}
