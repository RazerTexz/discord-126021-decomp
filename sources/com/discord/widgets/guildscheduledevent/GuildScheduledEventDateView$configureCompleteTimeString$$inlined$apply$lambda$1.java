package com.discord.widgets.guildscheduledevent;

import com.discord.i18n.RenderContext;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventDateView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ CharSequence $eventEndingTimeString$inlined;
    public final /* synthetic */ CharSequence $eventStartingTimeString$inlined;
    public final /* synthetic */ GuildScheduledEventTiming $timing$inlined;
    public final /* synthetic */ GuildScheduledEventDateView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1(GuildScheduledEventDateView guildScheduledEventDateView, CharSequence charSequence, CharSequence charSequence2, GuildScheduledEventTiming guildScheduledEventTiming) {
        super(1);
        this.this$0 = guildScheduledEventDateView;
        this.$eventStartingTimeString$inlined = charSequence;
        this.$eventEndingTimeString$inlined = charSequence2;
        this.$timing$inlined = guildScheduledEventTiming;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("startHook", new GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1$1(this));
    }
}
