package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel$Companion$observeStores$1$rsvpUsers$1 extends o implements Function1<GuildScheduledEventUser, GuildScheduledEventRsvpUserListItem$RsvpUser> {
    public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel$Companion$observeStores$1$rsvpUsers$1(GuildScheduledEvent guildScheduledEvent) {
        super(1);
        this.$guildScheduledEvent = guildScheduledEvent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GuildScheduledEventRsvpUserListItem$RsvpUser invoke(GuildScheduledEventUser guildScheduledEventUser) {
        return invoke2(guildScheduledEventUser);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildScheduledEventRsvpUserListItem$RsvpUser invoke2(GuildScheduledEventUser guildScheduledEventUser) {
        m.checkNotNullParameter(guildScheduledEventUser, "guildScheduledEventUser");
        return GuildScheduledEventRsvpUserListItem$RsvpUser.Companion.from(guildScheduledEventUser, this.$guildScheduledEvent.getGuildId());
    }
}
