package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildIdsWithActiveEventsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIdsWithActiveEventsModel$observe$1$1 extends o implements Function1<Map$Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>>, Boolean> {
    public static final GuildIdsWithActiveEventsModel$observe$1$1 INSTANCE = new GuildIdsWithActiveEventsModel$observe$1$1();

    public GuildIdsWithActiveEventsModel$observe$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Map$Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>> map$Entry) {
        return Boolean.valueOf(invoke2((Map$Entry<Long, ? extends List<GuildScheduledEvent>>) map$Entry));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Map$Entry<Long, ? extends List<GuildScheduledEvent>> map$Entry) {
        m.checkNotNullParameter(map$Entry, "<name for destructuring parameter 0>");
        List<GuildScheduledEvent> value = map$Entry.getValue();
        if (!(value instanceof Collection) || !value.isEmpty()) {
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                if (((GuildScheduledEvent) it.next()).getStatus() == GuildScheduledEventStatus.ACTIVE) {
                    return true;
                }
            }
        }
        return false;
    }
}
