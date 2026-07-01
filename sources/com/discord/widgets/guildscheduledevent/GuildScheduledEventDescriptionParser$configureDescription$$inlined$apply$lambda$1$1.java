package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1$1 extends o implements Function1<SpoilerNode<?>, Unit> {
    public final /* synthetic */ GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1$1(GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1 guildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1) {
        super(1);
        this.this$0 = guildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
        invoke2(spoilerNode);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SpoilerNode<?> spoilerNode) {
        m.checkNotNullParameter(spoilerNode, "spoilerNode");
        GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1 guildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1 = this.this$0;
        GuildScheduledEventDescriptionParser.access$handleSpoilerClicked(guildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1.this$0, spoilerNode, guildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1.$guildId$inlined);
    }
}
