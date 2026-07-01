package com.discord.widgets.voice.sheet;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$onStartEventClicked$1 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
    public static final CallParticipantsAdapter$onStartEventClicked$1 INSTANCE = new CallParticipantsAdapter$onStartEventClicked$1();

    public CallParticipantsAdapter$onStartEventClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
        invoke2(guildScheduledEvent);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "it");
    }
}
