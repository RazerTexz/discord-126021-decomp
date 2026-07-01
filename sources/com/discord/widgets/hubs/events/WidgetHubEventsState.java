package com.discord.widgets.hubs.events;

import b.d.b.a.a;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubEventsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubEventsState {
    private final RestCallState<List<DirectoryEntryEvent>> eventsAsync;
    private final List<HubGuildScheduledEventData> eventsData;
    private final boolean showHeader;

    public WidgetHubEventsState() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHubEventsState(boolean z2, List<HubGuildScheduledEventData> list, RestCallState<? extends List<DirectoryEntryEvent>> restCallState) {
        m.checkNotNullParameter(list, "eventsData");
        m.checkNotNullParameter(restCallState, "eventsAsync");
        this.showHeader = z2;
        this.eventsData = list;
        this.eventsAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubEventsState copy$default(WidgetHubEventsState widgetHubEventsState, boolean z2, List list, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetHubEventsState.showHeader;
        }
        if ((i & 2) != 0) {
            list = widgetHubEventsState.eventsData;
        }
        if ((i & 4) != 0) {
            restCallState = widgetHubEventsState.eventsAsync;
        }
        return widgetHubEventsState.copy(z2, list, restCallState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowHeader() {
        return this.showHeader;
    }

    public final List<HubGuildScheduledEventData> component2() {
        return this.eventsData;
    }

    public final RestCallState<List<DirectoryEntryEvent>> component3() {
        return this.eventsAsync;
    }

    public final WidgetHubEventsState copy(boolean showHeader, List<HubGuildScheduledEventData> eventsData, RestCallState<? extends List<DirectoryEntryEvent>> eventsAsync) {
        m.checkNotNullParameter(eventsData, "eventsData");
        m.checkNotNullParameter(eventsAsync, "eventsAsync");
        return new WidgetHubEventsState(showHeader, eventsData, eventsAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEventsState)) {
            return false;
        }
        WidgetHubEventsState widgetHubEventsState = (WidgetHubEventsState) other;
        return this.showHeader == widgetHubEventsState.showHeader && m.areEqual(this.eventsData, widgetHubEventsState.eventsData) && m.areEqual(this.eventsAsync, widgetHubEventsState.eventsAsync);
    }

    public final RestCallState<List<DirectoryEntryEvent>> getEventsAsync() {
        return this.eventsAsync;
    }

    public final List<HubGuildScheduledEventData> getEventsData() {
        return this.eventsData;
    }

    public final boolean getShowHeader() {
        return this.showHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z2 = this.showHeader;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        List<HubGuildScheduledEventData> list = this.eventsData;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        RestCallState<List<DirectoryEntryEvent>> restCallState = this.eventsAsync;
        return iHashCode + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetHubEventsState(showHeader=");
        sbU.append(this.showHeader);
        sbU.append(", eventsData=");
        sbU.append(this.eventsData);
        sbU.append(", eventsAsync=");
        sbU.append(this.eventsAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubEventsState(boolean z2, List list, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z2, (i & 2) != 0 ? n.emptyList() : list, (i & 4) != 0 ? Default.INSTANCE : restCallState);
    }
}
