package com.discord.widgets.hubs.events;

import b.d.b.a.a;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetHubEventsPageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubEventsPage$Footer extends HubEventsPage {
    private final RestCallState<List<DirectoryEntryEvent>> eventsAsync;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HubEventsPage$Footer(RestCallState<? extends List<DirectoryEntryEvent>> restCallState) {
        super(1, null);
        m.checkNotNullParameter(restCallState, "eventsAsync");
        this.eventsAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HubEventsPage$Footer copy$default(HubEventsPage$Footer hubEventsPage$Footer, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            restCallState = hubEventsPage$Footer.eventsAsync;
        }
        return hubEventsPage$Footer.copy(restCallState);
    }

    public final RestCallState<List<DirectoryEntryEvent>> component1() {
        return this.eventsAsync;
    }

    public final HubEventsPage$Footer copy(RestCallState<? extends List<DirectoryEntryEvent>> eventsAsync) {
        m.checkNotNullParameter(eventsAsync, "eventsAsync");
        return new HubEventsPage$Footer(eventsAsync);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HubEventsPage$Footer) && m.areEqual(this.eventsAsync, ((HubEventsPage$Footer) other).eventsAsync);
        }
        return true;
    }

    public final RestCallState<List<DirectoryEntryEvent>> getEventsAsync() {
        return this.eventsAsync;
    }

    public int hashCode() {
        RestCallState<List<DirectoryEntryEvent>> restCallState = this.eventsAsync;
        if (restCallState != null) {
            return restCallState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Footer(eventsAsync=");
        sbU.append(this.eventsAsync);
        sbU.append(")");
        return sbU.toString();
    }
}
