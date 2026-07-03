package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventSettingsViewModel extends AbstractC0859d0<ViewState> {
    public static final int SAMPLE_USER_COUNT = 1;

    /* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
    public enum DateError {
        INVALID_VIEW_STATE,
        START_DATE_IN_PAST,
        END_DATE_IN_PAST,
        END_DATE_BEFORE_START_DATE
    }

    /* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
        public static final /* data */ class Initialized extends ViewState {
            private final GuildScheduledEventModel eventModel;
            private final GuildScheduledEvent existingEvent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialized(GuildScheduledEventModel guildScheduledEventModel, GuildScheduledEvent guildScheduledEvent) {
                super(null);
                C12238m.checkNotNullParameter(guildScheduledEventModel, "eventModel");
                this.eventModel = guildScheduledEventModel;
                this.existingEvent = guildScheduledEvent;
            }

            public static /* synthetic */ Initialized copy$default(Initialized initialized, GuildScheduledEventModel guildScheduledEventModel, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildScheduledEventModel = initialized.eventModel;
                }
                if ((i & 2) != 0) {
                    guildScheduledEvent = initialized.existingEvent;
                }
                return initialized.copy(guildScheduledEventModel, guildScheduledEvent);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildScheduledEventModel getEventModel() {
                return this.eventModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final GuildScheduledEvent getExistingEvent() {
                return this.existingEvent;
            }

            public final Initialized copy(GuildScheduledEventModel eventModel, GuildScheduledEvent existingEvent) {
                C12238m.checkNotNullParameter(eventModel, "eventModel");
                return new Initialized(eventModel, existingEvent);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialized)) {
                    return false;
                }
                Initialized initialized = (Initialized) other;
                return C12238m.areEqual(this.eventModel, initialized.eventModel) && C12238m.areEqual(this.existingEvent, initialized.existingEvent);
            }

            public final GuildScheduledEventModel getEventModel() {
                return this.eventModel;
            }

            public final GuildScheduledEvent getExistingEvent() {
                return this.existingEvent;
            }

            public int hashCode() {
                GuildScheduledEventModel guildScheduledEventModel = this.eventModel;
                int iHashCode = (guildScheduledEventModel != null ? guildScheduledEventModel.hashCode() : 0) * 31;
                GuildScheduledEvent guildScheduledEvent = this.existingEvent;
                return iHashCode + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Initialized(eventModel=");
                sbM833U.append(this.eventModel);
                sbM833U.append(", existingEvent=");
                sbM833U.append(this.existingEvent);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setDescription$1 */
    /* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
    public static final class C88251 extends AbstractC12240o implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ String $description;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88251(String str) {
            super(1);
            this.$description = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            C12238m.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return guildScheduledEventModel.copy((7935 & 1) != 0 ? guildScheduledEventModel.guildId : 0L, (7935 & 2) != 0 ? guildScheduledEventModel.name : null, (7935 & 4) != 0 ? guildScheduledEventModel.channelId : null, (7935 & 8) != 0 ? guildScheduledEventModel.creatorId : null, (7935 & 16) != 0 ? guildScheduledEventModel.startDate : null, (7935 & 32) != 0 ? guildScheduledEventModel.startTime : null, (7935 & 64) != 0 ? guildScheduledEventModel.endDate : null, (7935 & 128) != 0 ? guildScheduledEventModel.endTime : null, (7935 & 256) != 0 ? guildScheduledEventModel.description : this.$description, (7935 & 512) != 0 ? guildScheduledEventModel.entityType : null, (7935 & 1024) != 0 ? guildScheduledEventModel.entityMetadata : null, (7935 & 2048) != 0 ? guildScheduledEventModel.userCount : null, (7935 & 4096) != 0 ? guildScheduledEventModel.broadcastToDirectoryChannels : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setEndDate$1 */
    /* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
    public static final class C88261 extends AbstractC12240o implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerDate $newEndDate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88261(GuildScheduledEventPickerDate guildScheduledEventPickerDate) {
            super(1);
            this.$newEndDate = guildScheduledEventPickerDate;
        }

        @Override // kotlin.jvm.functions.Function1
        public final GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            C12238m.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return guildScheduledEventModel.copy((7935 & 1) != 0 ? guildScheduledEventModel.guildId : 0L, (7935 & 2) != 0 ? guildScheduledEventModel.name : null, (7935 & 4) != 0 ? guildScheduledEventModel.channelId : null, (7935 & 8) != 0 ? guildScheduledEventModel.creatorId : null, (7935 & 16) != 0 ? guildScheduledEventModel.startDate : null, (7935 & 32) != 0 ? guildScheduledEventModel.startTime : null, (7935 & 64) != 0 ? guildScheduledEventModel.endDate : this.$newEndDate, (7935 & 128) != 0 ? guildScheduledEventModel.endTime : null, (7935 & 256) != 0 ? guildScheduledEventModel.description : null, (7935 & 512) != 0 ? guildScheduledEventModel.entityType : null, (7935 & 1024) != 0 ? guildScheduledEventModel.entityMetadata : null, (7935 & 2048) != 0 ? guildScheduledEventModel.userCount : null, (7935 & 4096) != 0 ? guildScheduledEventModel.broadcastToDirectoryChannels : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setEndTime$1 */
    /* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
    public static final class C88271 extends AbstractC12240o implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerTime $newEndTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88271(GuildScheduledEventPickerTime guildScheduledEventPickerTime) {
            super(1);
            this.$newEndTime = guildScheduledEventPickerTime;
        }

        @Override // kotlin.jvm.functions.Function1
        public final GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            C12238m.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return guildScheduledEventModel.copy((7935 & 1) != 0 ? guildScheduledEventModel.guildId : 0L, (7935 & 2) != 0 ? guildScheduledEventModel.name : null, (7935 & 4) != 0 ? guildScheduledEventModel.channelId : null, (7935 & 8) != 0 ? guildScheduledEventModel.creatorId : null, (7935 & 16) != 0 ? guildScheduledEventModel.startDate : null, (7935 & 32) != 0 ? guildScheduledEventModel.startTime : null, (7935 & 64) != 0 ? guildScheduledEventModel.endDate : null, (7935 & 128) != 0 ? guildScheduledEventModel.endTime : this.$newEndTime, (7935 & 256) != 0 ? guildScheduledEventModel.description : null, (7935 & 512) != 0 ? guildScheduledEventModel.entityType : null, (7935 & 1024) != 0 ? guildScheduledEventModel.entityMetadata : null, (7935 & 2048) != 0 ? guildScheduledEventModel.userCount : null, (7935 & 4096) != 0 ? guildScheduledEventModel.broadcastToDirectoryChannels : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setStartDate$1 */
    /* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
    public static final class C88281 extends AbstractC12240o implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerDate $newStartDate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88281(GuildScheduledEventPickerDate guildScheduledEventPickerDate) {
            super(1);
            this.$newStartDate = guildScheduledEventPickerDate;
        }

        @Override // kotlin.jvm.functions.Function1
        public final GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            C12238m.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return guildScheduledEventModel.copy((7935 & 1) != 0 ? guildScheduledEventModel.guildId : 0L, (7935 & 2) != 0 ? guildScheduledEventModel.name : null, (7935 & 4) != 0 ? guildScheduledEventModel.channelId : null, (7935 & 8) != 0 ? guildScheduledEventModel.creatorId : null, (7935 & 16) != 0 ? guildScheduledEventModel.startDate : this.$newStartDate, (7935 & 32) != 0 ? guildScheduledEventModel.startTime : null, (7935 & 64) != 0 ? guildScheduledEventModel.endDate : null, (7935 & 128) != 0 ? guildScheduledEventModel.endTime : null, (7935 & 256) != 0 ? guildScheduledEventModel.description : null, (7935 & 512) != 0 ? guildScheduledEventModel.entityType : null, (7935 & 1024) != 0 ? guildScheduledEventModel.entityMetadata : null, (7935 & 2048) != 0 ? guildScheduledEventModel.userCount : null, (7935 & 4096) != 0 ? guildScheduledEventModel.broadcastToDirectoryChannels : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setStartTime$1 */
    /* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
    public static final class C88291 extends AbstractC12240o implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerTime $newStartTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88291(GuildScheduledEventPickerTime guildScheduledEventPickerTime) {
            super(1);
            this.$newStartTime = guildScheduledEventPickerTime;
        }

        @Override // kotlin.jvm.functions.Function1
        public final GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            C12238m.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return guildScheduledEventModel.copy((7935 & 1) != 0 ? guildScheduledEventModel.guildId : 0L, (7935 & 2) != 0 ? guildScheduledEventModel.name : null, (7935 & 4) != 0 ? guildScheduledEventModel.channelId : null, (7935 & 8) != 0 ? guildScheduledEventModel.creatorId : null, (7935 & 16) != 0 ? guildScheduledEventModel.startDate : null, (7935 & 32) != 0 ? guildScheduledEventModel.startTime : this.$newStartTime, (7935 & 64) != 0 ? guildScheduledEventModel.endDate : null, (7935 & 128) != 0 ? guildScheduledEventModel.endTime : null, (7935 & 256) != 0 ? guildScheduledEventModel.description : null, (7935 & 512) != 0 ? guildScheduledEventModel.entityType : null, (7935 & 1024) != 0 ? guildScheduledEventModel.entityMetadata : null, (7935 & 2048) != 0 ? guildScheduledEventModel.userCount : null, (7935 & 4096) != 0 ? guildScheduledEventModel.broadcastToDirectoryChannels : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setTopic$1 */
    /* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
    public static final class C88301 extends AbstractC12240o implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ String $topic;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88301(String str) {
            super(1);
            this.$topic = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            C12238m.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return guildScheduledEventModel.copy((7935 & 1) != 0 ? guildScheduledEventModel.guildId : 0L, (7935 & 2) != 0 ? guildScheduledEventModel.name : this.$topic, (7935 & 4) != 0 ? guildScheduledEventModel.channelId : null, (7935 & 8) != 0 ? guildScheduledEventModel.creatorId : null, (7935 & 16) != 0 ? guildScheduledEventModel.startDate : null, (7935 & 32) != 0 ? guildScheduledEventModel.startTime : null, (7935 & 64) != 0 ? guildScheduledEventModel.endDate : null, (7935 & 128) != 0 ? guildScheduledEventModel.endTime : null, (7935 & 256) != 0 ? guildScheduledEventModel.description : null, (7935 & 512) != 0 ? guildScheduledEventModel.entityType : null, (7935 & 1024) != 0 ? guildScheduledEventModel.entityMetadata : null, (7935 & 2048) != 0 ? guildScheduledEventModel.userCount : null, (7935 & 4096) != 0 ? guildScheduledEventModel.broadcastToDirectoryChannels : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$toggleBroadcastToDirectoryChannel$1 */
    /* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
    public static final class C88311 extends AbstractC12240o implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ boolean $associateToHubs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88311(boolean z2) {
            super(1);
            this.$associateToHubs = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            C12238m.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return guildScheduledEventModel.copy((7935 & 1) != 0 ? guildScheduledEventModel.guildId : 0L, (7935 & 2) != 0 ? guildScheduledEventModel.name : null, (7935 & 4) != 0 ? guildScheduledEventModel.channelId : null, (7935 & 8) != 0 ? guildScheduledEventModel.creatorId : null, (7935 & 16) != 0 ? guildScheduledEventModel.startDate : null, (7935 & 32) != 0 ? guildScheduledEventModel.startTime : null, (7935 & 64) != 0 ? guildScheduledEventModel.endDate : null, (7935 & 128) != 0 ? guildScheduledEventModel.endTime : null, (7935 & 256) != 0 ? guildScheduledEventModel.description : null, (7935 & 512) != 0 ? guildScheduledEventModel.entityType : null, (7935 & 1024) != 0 ? guildScheduledEventModel.entityMetadata : null, (7935 & 2048) != 0 ? guildScheduledEventModel.userCount : null, (7935 & 4096) != 0 ? guildScheduledEventModel.broadcastToDirectoryChannels : Boolean.valueOf(this.$associateToHubs));
        }
    }

    public /* synthetic */ GuildScheduledEventSettingsViewModel(long j, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, Long l2, String str, StoreGuildScheduledEvents storeGuildScheduledEvents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, l, guildScheduledEventEntityType, l2, str, (i & 32) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents);
    }

    private final Unit updateEventModel(Function1<? super GuildScheduledEventModel, GuildScheduledEventModel> updateEventModel) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized == null) {
            return null;
        }
        updateViewState(ViewState.Initialized.copy$default(initialized, updateEventModel.invoke(initialized.getEventModel()), null, 2, null));
        return Unit.f27425a;
    }

    public final boolean hasEndTimeChanged(ViewState.Initialized viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        if (viewState.getExistingEvent() == null) {
            return true;
        }
        if (viewState.getEventModel().getEndDate() == null || viewState.getEventModel().getEndTime() == null) {
            return viewState.getExistingEvent().getScheduledEndTime() == null;
        }
        long millis = GuildScheduledEventPickerDateTime.INSTANCE.toMillis(viewState.getEventModel().getEndDate(), viewState.getEventModel().getEndTime());
        UtcDateTime scheduledEndTime = viewState.getExistingEvent().getScheduledEndTime();
        Long lValueOf = scheduledEndTime != null ? Long.valueOf(scheduledEndTime.getDateTimeMillis()) : null;
        return lValueOf == null || millis != lValueOf.longValue();
    }

    public final boolean hasStartTimeChanged(ViewState.Initialized viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        return viewState.getExistingEvent() == null || GuildScheduledEventPickerDateTime.INSTANCE.toMillis(viewState.getEventModel().getStartDate(), viewState.getEventModel().getStartTime()) != viewState.getExistingEvent().getScheduledStartTime().getDateTimeMillis();
    }

    public final boolean isDateInFuture(GuildScheduledEventPickerDate date, GuildScheduledEventPickerTime time) {
        return date == null || time == null || GuildScheduledEventPickerDateTime.INSTANCE.toMillis(date, time) >= ClockFactory.get().currentTimeMillis();
    }

    public final boolean isNextButtonEnabled() {
        GuildScheduledEventModel eventModel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized == null || (eventModel = initialized.getEventModel()) == null) {
            return false;
        }
        String name = eventModel.getName();
        if (name == null || name.length() == 0) {
            return false;
        }
        return (eventModel.getEntityType() == GuildScheduledEventEntityType.EXTERNAL && (eventModel.getEndDate() == null || eventModel.getEndTime() == null)) ? false : true;
    }

    public final boolean isStartDateBeforeEndDate(GuildScheduledEventPickerDate startDate, GuildScheduledEventPickerTime startTime, GuildScheduledEventPickerDate endDate, GuildScheduledEventPickerTime endTime) {
        C12238m.checkNotNullParameter(startDate, "startDate");
        C12238m.checkNotNullParameter(startTime, "startTime");
        if (endDate == null || endTime == null) {
            return endDate == null || endDate.toMillis() >= startDate.toMillis();
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        return guildScheduledEventPickerDateTime.toMillis(endDate, endTime) > guildScheduledEventPickerDateTime.toMillis(startDate, startTime);
    }

    public final Unit setDescription(String description) {
        C12238m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        return updateEventModel(new C88251(description));
    }

    public final DateError setEndDate(int year, int month, int dayOfMonth) {
        if (updateEventModel(new C88261(new GuildScheduledEventPickerDate(year, month, dayOfMonth))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final DateError setEndTime(int hourOfDay, int minute) {
        if (updateEventModel(new C88271(new GuildScheduledEventPickerTime(hourOfDay, minute, 0))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final DateError setStartDate(int year, int month, int dayOfMonth) {
        if (updateEventModel(new C88281(new GuildScheduledEventPickerDate(year, month, dayOfMonth))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final DateError setStartTime(int hourOfDay, int minute) {
        if (updateEventModel(new C88291(new GuildScheduledEventPickerTime(hourOfDay, minute, 0))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final Unit setTopic(String topic) {
        C12238m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        return updateEventModel(new C88301(topic));
    }

    public final Unit toggleBroadcastToDirectoryChannel(boolean associateToHubs) {
        return updateEventModel(new C88311(associateToHubs));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventSettingsViewModel(long j, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, Long l2, String str, StoreGuildScheduledEvents storeGuildScheduledEvents) {
        int i;
        GuildScheduledEventModel model;
        super(null, 1, null);
        C12238m.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
        C12238m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        GuildScheduledEventModel guildScheduledEventModel = null;
        GuildScheduledEvent guildScheduledEventFindEventFromStore = l != null ? storeGuildScheduledEvents.findEventFromStore(l.longValue(), Long.valueOf(j)) : null;
        if (guildScheduledEventFindEventFromStore == null || (model = GuildScheduledEventModelKt.toModel(guildScheduledEventFindEventFromStore)) == null) {
            i = 1;
        } else {
            i = 1;
            guildScheduledEventModel = model.copy((7935 & 1) != 0 ? model.guildId : 0L, (7935 & 2) != 0 ? model.name : null, (7935 & 4) != 0 ? model.channelId : l2, (7935 & 8) != 0 ? model.creatorId : null, (7935 & 16) != 0 ? model.startDate : null, (7935 & 32) != 0 ? model.startTime : null, (7935 & 64) != 0 ? model.endDate : null, (7935 & 128) != 0 ? model.endTime : null, (7935 & 256) != 0 ? model.description : null, (7935 & 512) != 0 ? model.entityType : guildScheduledEventEntityType, (7935 & 1024) != 0 ? model.entityMetadata : GuildScheduledEventEntityMetadata.INSTANCE.m7992a(guildScheduledEventEntityType, str), (7935 & 2048) != 0 ? model.userCount : null, (7935 & 4096) != 0 ? model.broadcastToDirectoryChannels : null);
        }
        Pair<GuildScheduledEventPickerDate, GuildScheduledEventPickerTime> pairGenerateAppropriateStartDateTime = GuildScheduledEventPickerDateTime.INSTANCE.generateAppropriateStartDateTime();
        if (guildScheduledEventModel == null) {
            guildScheduledEventModel = new GuildScheduledEventModel(j, null, l2, null, pairGenerateAppropriateStartDateTime.getFirst(), pairGenerateAppropriateStartDateTime.getSecond(), null, null, null, guildScheduledEventEntityType, GuildScheduledEventEntityMetadata.INSTANCE.m7992a(guildScheduledEventEntityType, str), Integer.valueOf(i), null, 4096, null);
        }
        new ViewState.Initialized(guildScheduledEventModel, guildScheduledEventFindEventFromStore);
        updateViewState(r12);
    }

    public final boolean isStartDateBeforeEndDate(ViewState.Initialized viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        return isStartDateBeforeEndDate(viewState.getEventModel().getStartDate(), viewState.getEventModel().getStartTime(), viewState.getEventModel().getEndDate(), viewState.getEventModel().getEndTime());
    }
}
