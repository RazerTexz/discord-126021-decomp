package com.discord.widgets.hubs.events;

import b.d.b.a.outline;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.analytics.Traits;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.events.HubEventsPage, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEventsPageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetHubEventsPageAdapter2 {
    public static final int ENTRY = 2;
    public static final int FOOTER = 1;
    public static final int HEADER = 0;
    private final int viewType;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.HubEventsPage$Event */
    /* JADX INFO: compiled from: WidgetHubEventsPageAdapter.kt */
    public static final /* data */ class Event extends WidgetHubEventsPageAdapter2 {
        private final WidgetHubEventsViewModel2 guildScheduledEventData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            super(2, null);
            Intrinsics3.checkNotNullParameter(widgetHubEventsViewModel2, "guildScheduledEventData");
            this.guildScheduledEventData = widgetHubEventsViewModel2;
        }

        public static /* synthetic */ Event copy$default(Event event, WidgetHubEventsViewModel2 widgetHubEventsViewModel2, int i, Object obj) {
            if ((i & 1) != 0) {
                widgetHubEventsViewModel2 = event.guildScheduledEventData;
            }
            return event.copy(widgetHubEventsViewModel2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final WidgetHubEventsViewModel2 getGuildScheduledEventData() {
            return this.guildScheduledEventData;
        }

        public final Event copy(WidgetHubEventsViewModel2 guildScheduledEventData) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventData, "guildScheduledEventData");
            return new Event(guildScheduledEventData);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Event) && Intrinsics3.areEqual(this.guildScheduledEventData, ((Event) other).guildScheduledEventData);
            }
            return true;
        }

        public final WidgetHubEventsViewModel2 getGuildScheduledEventData() {
            return this.guildScheduledEventData;
        }

        public int hashCode() {
            WidgetHubEventsViewModel2 widgetHubEventsViewModel2 = this.guildScheduledEventData;
            if (widgetHubEventsViewModel2 != null) {
                return widgetHubEventsViewModel2.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Event(guildScheduledEventData=");
            sbU.append(this.guildScheduledEventData);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.HubEventsPage$Footer */
    /* JADX INFO: compiled from: WidgetHubEventsPageAdapter.kt */
    public static final /* data */ class Footer extends WidgetHubEventsPageAdapter2 {
        private final RestCallState<List<DirectoryEntryGuild2>> eventsAsync;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Footer(RestCallState<? extends List<DirectoryEntryGuild2>> restCallState) {
            super(1, null);
            Intrinsics3.checkNotNullParameter(restCallState, "eventsAsync");
            this.eventsAsync = restCallState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Footer copy$default(Footer footer, RestCallState restCallState, int i, Object obj) {
            if ((i & 1) != 0) {
                restCallState = footer.eventsAsync;
            }
            return footer.copy(restCallState);
        }

        public final RestCallState<List<DirectoryEntryGuild2>> component1() {
            return this.eventsAsync;
        }

        public final Footer copy(RestCallState<? extends List<DirectoryEntryGuild2>> eventsAsync) {
            Intrinsics3.checkNotNullParameter(eventsAsync, "eventsAsync");
            return new Footer(eventsAsync);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Footer) && Intrinsics3.areEqual(this.eventsAsync, ((Footer) other).eventsAsync);
            }
            return true;
        }

        public final RestCallState<List<DirectoryEntryGuild2>> getEventsAsync() {
            return this.eventsAsync;
        }

        public int hashCode() {
            RestCallState<List<DirectoryEntryGuild2>> restCallState = this.eventsAsync;
            if (restCallState != null) {
                return restCallState.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Footer(eventsAsync=");
            sbU.append(this.eventsAsync);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.HubEventsPage$Header */
    /* JADX INFO: compiled from: WidgetHubEventsPageAdapter.kt */
    public static final class Header extends WidgetHubEventsPageAdapter2 {
        public static final Header INSTANCE = new Header();

        private Header() {
            super(0, null);
        }
    }

    private WidgetHubEventsPageAdapter2(int i) {
        this.viewType = i;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public /* synthetic */ WidgetHubEventsPageAdapter2(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
