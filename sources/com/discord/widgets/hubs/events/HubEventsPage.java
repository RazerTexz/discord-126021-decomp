package com.discord.widgets.hubs.events;

import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.analytics.Traits;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubEventsPageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class HubEventsPage {
    public static final int ENTRY = 2;
    public static final int FOOTER = 1;
    public static final int HEADER = 0;
    private final int viewType;

    /* JADX INFO: compiled from: WidgetHubEventsPageAdapter.kt */
    public static final /* data */ class Event extends HubEventsPage {
        private final HubGuildScheduledEventData guildScheduledEventData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(HubGuildScheduledEventData hubGuildScheduledEventData) {
            super(2, null);
            C12238m.checkNotNullParameter(hubGuildScheduledEventData, "guildScheduledEventData");
            this.guildScheduledEventData = hubGuildScheduledEventData;
        }

        public static /* synthetic */ Event copy$default(Event event, HubGuildScheduledEventData hubGuildScheduledEventData, int i, Object obj) {
            if ((i & 1) != 0) {
                hubGuildScheduledEventData = event.guildScheduledEventData;
            }
            return event.copy(hubGuildScheduledEventData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final HubGuildScheduledEventData getGuildScheduledEventData() {
            return this.guildScheduledEventData;
        }

        public final Event copy(HubGuildScheduledEventData guildScheduledEventData) {
            C12238m.checkNotNullParameter(guildScheduledEventData, "guildScheduledEventData");
            return new Event(guildScheduledEventData);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Event) && C12238m.areEqual(this.guildScheduledEventData, ((Event) other).guildScheduledEventData);
            }
            return true;
        }

        public final HubGuildScheduledEventData getGuildScheduledEventData() {
            return this.guildScheduledEventData;
        }

        public int hashCode() {
            HubGuildScheduledEventData hubGuildScheduledEventData = this.guildScheduledEventData;
            if (hubGuildScheduledEventData != null) {
                return hubGuildScheduledEventData.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Event(guildScheduledEventData=");
            sbM833U.append(this.guildScheduledEventData);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetHubEventsPageAdapter.kt */
    public static final /* data */ class Footer extends HubEventsPage {
        private final RestCallState<List<DirectoryEntryEvent>> eventsAsync;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Footer(RestCallState<? extends List<DirectoryEntryEvent>> restCallState) {
            super(1, null);
            C12238m.checkNotNullParameter(restCallState, "eventsAsync");
            this.eventsAsync = restCallState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Footer copy$default(Footer footer, RestCallState restCallState, int i, Object obj) {
            if ((i & 1) != 0) {
                restCallState = footer.eventsAsync;
            }
            return footer.copy(restCallState);
        }

        public final RestCallState<List<DirectoryEntryEvent>> component1() {
            return this.eventsAsync;
        }

        public final Footer copy(RestCallState<? extends List<DirectoryEntryEvent>> eventsAsync) {
            C12238m.checkNotNullParameter(eventsAsync, "eventsAsync");
            return new Footer(eventsAsync);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Footer) && C12238m.areEqual(this.eventsAsync, ((Footer) other).eventsAsync);
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
            StringBuilder sbM833U = C1643a.m833U("Footer(eventsAsync=");
            sbM833U.append(this.eventsAsync);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetHubEventsPageAdapter.kt */
    public static final class Header extends HubEventsPage {
        public static final Header INSTANCE = new Header();

        private Header() {
            super(0, null);
        }
    }

    private HubEventsPage(int i) {
        this.viewType = i;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public /* synthetic */ HubEventsPage(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
