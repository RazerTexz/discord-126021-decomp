package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PreviewGuildScheduledEventViewModel$createEvent$2 extends o implements Function1<GuildScheduledEvent, Unit> {
    public final /* synthetic */ Function1 $onRequestSuccess;
    public final /* synthetic */ PreviewGuildScheduledEventViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewGuildScheduledEventViewModel$createEvent$2(PreviewGuildScheduledEventViewModel previewGuildScheduledEventViewModel, Function1 function1) {
        super(1);
        this.this$0 = previewGuildScheduledEventViewModel;
        this.$onRequestSuccess = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
        invoke2(guildScheduledEvent);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
        PreviewGuildScheduledEventViewModel.access$setRequestFinished(this.this$0);
        this.$onRequestSuccess.invoke(guildScheduledEvent != null ? Long.valueOf(guildScheduledEvent.getId()) : null);
    }
}
