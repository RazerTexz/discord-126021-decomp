package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildIdsWithActiveEventsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIdsWithActiveEventsModel$observe$1$2 extends o implements Function1<Map$Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>>, Long> {
    public static final GuildIdsWithActiveEventsModel$observe$1$2 INSTANCE = new GuildIdsWithActiveEventsModel$observe$1$2();

    public GuildIdsWithActiveEventsModel$observe$1$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Map$Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>> map$Entry) {
        return Long.valueOf(invoke2((Map$Entry<Long, ? extends List<GuildScheduledEvent>>) map$Entry));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(Map$Entry<Long, ? extends List<GuildScheduledEvent>> map$Entry) {
        m.checkNotNullParameter(map$Entry, "entry");
        return map$Entry.getKey().longValue();
    }
}
