package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListItem;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$Companion$observeStores$1$rsvpUsers$1 */
/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8815x2986877 extends AbstractC12240o implements Function1<GuildScheduledEventUser, GuildScheduledEventRsvpUserListItem.RsvpUser> {
    public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8815x2986877(GuildScheduledEvent guildScheduledEvent) {
        super(1);
        this.$guildScheduledEvent = guildScheduledEvent;
    }

    @Override // kotlin.jvm.functions.Function1
    public final GuildScheduledEventRsvpUserListItem.RsvpUser invoke(GuildScheduledEventUser guildScheduledEventUser) {
        C12238m.checkNotNullParameter(guildScheduledEventUser, "guildScheduledEventUser");
        return GuildScheduledEventRsvpUserListItem.RsvpUser.INSTANCE.from(guildScheduledEventUser, this.$guildScheduledEvent.getGuildId());
    }
}
