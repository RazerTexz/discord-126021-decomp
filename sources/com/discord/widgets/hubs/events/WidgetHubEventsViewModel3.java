package com.discord.widgets.hubs.events;

import b.d.b.a.outline;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsState, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEventsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubEventsViewModel3 {
    private final RestCallState<List<DirectoryEntryGuild2>> eventsAsync;
    private final List<WidgetHubEventsViewModel2> eventsData;
    private final boolean showHeader;

    public WidgetHubEventsViewModel3() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHubEventsViewModel3(boolean z2, List<WidgetHubEventsViewModel2> list, RestCallState<? extends List<DirectoryEntryGuild2>> restCallState) {
        Intrinsics3.checkNotNullParameter(list, "eventsData");
        Intrinsics3.checkNotNullParameter(restCallState, "eventsAsync");
        this.showHeader = z2;
        this.eventsData = list;
        this.eventsAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubEventsViewModel3 copy$default(WidgetHubEventsViewModel3 widgetHubEventsViewModel3, boolean z2, List list, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetHubEventsViewModel3.showHeader;
        }
        if ((i & 2) != 0) {
            list = widgetHubEventsViewModel3.eventsData;
        }
        if ((i & 4) != 0) {
            restCallState = widgetHubEventsViewModel3.eventsAsync;
        }
        return widgetHubEventsViewModel3.copy(z2, list, restCallState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowHeader() {
        return this.showHeader;
    }

    public final List<WidgetHubEventsViewModel2> component2() {
        return this.eventsData;
    }

    public final RestCallState<List<DirectoryEntryGuild2>> component3() {
        return this.eventsAsync;
    }

    public final WidgetHubEventsViewModel3 copy(boolean showHeader, List<WidgetHubEventsViewModel2> eventsData, RestCallState<? extends List<DirectoryEntryGuild2>> eventsAsync) {
        Intrinsics3.checkNotNullParameter(eventsData, "eventsData");
        Intrinsics3.checkNotNullParameter(eventsAsync, "eventsAsync");
        return new WidgetHubEventsViewModel3(showHeader, eventsData, eventsAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEventsViewModel3)) {
            return false;
        }
        WidgetHubEventsViewModel3 widgetHubEventsViewModel3 = (WidgetHubEventsViewModel3) other;
        return this.showHeader == widgetHubEventsViewModel3.showHeader && Intrinsics3.areEqual(this.eventsData, widgetHubEventsViewModel3.eventsData) && Intrinsics3.areEqual(this.eventsAsync, widgetHubEventsViewModel3.eventsAsync);
    }

    public final RestCallState<List<DirectoryEntryGuild2>> getEventsAsync() {
        return this.eventsAsync;
    }

    public final List<WidgetHubEventsViewModel2> getEventsData() {
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
        List<WidgetHubEventsViewModel2> list = this.eventsData;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        RestCallState<List<DirectoryEntryGuild2>> restCallState = this.eventsAsync;
        return iHashCode + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetHubEventsState(showHeader=");
        sbU.append(this.showHeader);
        sbU.append(", eventsData=");
        sbU.append(this.eventsData);
        sbU.append(", eventsAsync=");
        sbU.append(this.eventsAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubEventsViewModel3(boolean z2, List list, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z2, (i & 2) != 0 ? Collections2.emptyList() : list, (i & 4) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
