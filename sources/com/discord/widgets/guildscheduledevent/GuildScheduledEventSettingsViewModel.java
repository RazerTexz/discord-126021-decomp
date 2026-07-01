package com.discord.widgets.guildscheduledevent;

import b.a.d.d0;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventSettingsViewModel extends d0<GuildScheduledEventSettingsViewModel$ViewState> {
    public static final GuildScheduledEventSettingsViewModel$Companion Companion = new GuildScheduledEventSettingsViewModel$Companion(null);
    public static final int SAMPLE_USER_COUNT = 1;

    public /* synthetic */ GuildScheduledEventSettingsViewModel(long j, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, Long l2, String str, StoreGuildScheduledEvents storeGuildScheduledEvents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, l, guildScheduledEventEntityType, l2, str, (i & 32) != 0 ? StoreStream.Companion.getGuildScheduledEvents() : storeGuildScheduledEvents);
    }

    private final Unit updateEventModel(Function1<? super GuildScheduledEventModel, GuildScheduledEventModel> updateEventModel) {
        GuildScheduledEventSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof GuildScheduledEventSettingsViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$Initialized = (GuildScheduledEventSettingsViewModel$ViewState$Initialized) viewState;
        if (guildScheduledEventSettingsViewModel$ViewState$Initialized == null) {
            return null;
        }
        updateViewState(GuildScheduledEventSettingsViewModel$ViewState$Initialized.copy$default(guildScheduledEventSettingsViewModel$ViewState$Initialized, updateEventModel.invoke(guildScheduledEventSettingsViewModel$ViewState$Initialized.getEventModel()), null, 2, null));
        return Unit.a;
    }

    public final boolean hasEndTimeChanged(GuildScheduledEventSettingsViewModel$ViewState$Initialized viewState) {
        m.checkNotNullParameter(viewState, "viewState");
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

    public final boolean hasStartTimeChanged(GuildScheduledEventSettingsViewModel$ViewState$Initialized viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        return viewState.getExistingEvent() == null || GuildScheduledEventPickerDateTime.INSTANCE.toMillis(viewState.getEventModel().getStartDate(), viewState.getEventModel().getStartTime()) != viewState.getExistingEvent().getScheduledStartTime().getDateTimeMillis();
    }

    public final boolean isDateInFuture(GuildScheduledEventPickerDate date, GuildScheduledEventPickerTime time) {
        return date == null || time == null || GuildScheduledEventPickerDateTime.INSTANCE.toMillis(date, time) >= ClockFactory.get().currentTimeMillis();
    }

    public final boolean isNextButtonEnabled() {
        GuildScheduledEventModel eventModel;
        GuildScheduledEventSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof GuildScheduledEventSettingsViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$Initialized = (GuildScheduledEventSettingsViewModel$ViewState$Initialized) viewState;
        if (guildScheduledEventSettingsViewModel$ViewState$Initialized == null || (eventModel = guildScheduledEventSettingsViewModel$ViewState$Initialized.getEventModel()) == null) {
            return false;
        }
        String name = eventModel.getName();
        if (name == null || name.length() == 0) {
            return false;
        }
        return (eventModel.getEntityType() == GuildScheduledEventEntityType.EXTERNAL && (eventModel.getEndDate() == null || eventModel.getEndTime() == null)) ? false : true;
    }

    public final boolean isStartDateBeforeEndDate(GuildScheduledEventPickerDate startDate, GuildScheduledEventPickerTime startTime, GuildScheduledEventPickerDate endDate, GuildScheduledEventPickerTime endTime) {
        m.checkNotNullParameter(startDate, "startDate");
        m.checkNotNullParameter(startTime, "startTime");
        if (endDate == null || endTime == null) {
            return endDate == null || endDate.toMillis() >= startDate.toMillis();
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        return guildScheduledEventPickerDateTime.toMillis(endDate, endTime) > guildScheduledEventPickerDateTime.toMillis(startDate, startTime);
    }

    public final Unit setDescription(String description) {
        m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        return updateEventModel(new GuildScheduledEventSettingsViewModel$setDescription$1(description));
    }

    public final GuildScheduledEventSettingsViewModel$DateError setEndDate(int year, int month, int dayOfMonth) {
        if (updateEventModel(new GuildScheduledEventSettingsViewModel$setEndDate$1(new GuildScheduledEventPickerDate(year, month, dayOfMonth))) != null) {
            return null;
        }
        return GuildScheduledEventSettingsViewModel$DateError.INVALID_VIEW_STATE;
    }

    public final GuildScheduledEventSettingsViewModel$DateError setEndTime(int hourOfDay, int minute) {
        if (updateEventModel(new GuildScheduledEventSettingsViewModel$setEndTime$1(new GuildScheduledEventPickerTime(hourOfDay, minute, 0))) != null) {
            return null;
        }
        return GuildScheduledEventSettingsViewModel$DateError.INVALID_VIEW_STATE;
    }

    public final GuildScheduledEventSettingsViewModel$DateError setStartDate(int year, int month, int dayOfMonth) {
        if (updateEventModel(new GuildScheduledEventSettingsViewModel$setStartDate$1(new GuildScheduledEventPickerDate(year, month, dayOfMonth))) != null) {
            return null;
        }
        return GuildScheduledEventSettingsViewModel$DateError.INVALID_VIEW_STATE;
    }

    public final GuildScheduledEventSettingsViewModel$DateError setStartTime(int hourOfDay, int minute) {
        if (updateEventModel(new GuildScheduledEventSettingsViewModel$setStartTime$1(new GuildScheduledEventPickerTime(hourOfDay, minute, 0))) != null) {
            return null;
        }
        return GuildScheduledEventSettingsViewModel$DateError.INVALID_VIEW_STATE;
    }

    public final Unit setTopic(String topic) {
        m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        return updateEventModel(new GuildScheduledEventSettingsViewModel$setTopic$1(topic));
    }

    public final Unit toggleBroadcastToDirectoryChannel(boolean associateToHubs) {
        return updateEventModel(new GuildScheduledEventSettingsViewModel$toggleBroadcastToDirectoryChannel$1(associateToHubs));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventSettingsViewModel(long j, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, Long l2, String str, StoreGuildScheduledEvents storeGuildScheduledEvents) {
        int i;
        GuildScheduledEventModel model;
        super(null, 1, null);
        m.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
        m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        GuildScheduledEventModel guildScheduledEventModel = null;
        GuildScheduledEvent guildScheduledEventFindEventFromStore = l != null ? storeGuildScheduledEvents.findEventFromStore(l.longValue(), Long.valueOf(j)) : null;
        if (guildScheduledEventFindEventFromStore == null || (model = GuildScheduledEventModelKt.toModel(guildScheduledEventFindEventFromStore)) == null) {
            i = 1;
        } else {
            i = 1;
            guildScheduledEventModel = GuildScheduledEventModel.copy$default(model, 0L, null, l2, null, null, null, null, null, null, guildScheduledEventEntityType, GuildScheduledEventEntityMetadata.Companion.a(guildScheduledEventEntityType, str), null, null, 6651, null);
        }
        Pair<GuildScheduledEventPickerDate, GuildScheduledEventPickerTime> pairGenerateAppropriateStartDateTime = GuildScheduledEventPickerDateTime.INSTANCE.generateAppropriateStartDateTime();
        if (guildScheduledEventModel == null) {
            guildScheduledEventModel = new GuildScheduledEventModel(j, null, l2, null, pairGenerateAppropriateStartDateTime.getFirst(), pairGenerateAppropriateStartDateTime.getSecond(), null, null, null, guildScheduledEventEntityType, GuildScheduledEventEntityMetadata.Companion.a(guildScheduledEventEntityType, str), Integer.valueOf(i), null, 4096, null);
        }
        new GuildScheduledEventSettingsViewModel$ViewState$Initialized(guildScheduledEventModel, guildScheduledEventFindEventFromStore);
        updateViewState(r12);
    }

    public final boolean isStartDateBeforeEndDate(GuildScheduledEventSettingsViewModel$ViewState$Initialized viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        return isStartDateBeforeEndDate(viewState.getEventModel().getStartDate(), viewState.getEventModel().getStartTime(), viewState.getEventModel().getEndDate(), viewState.getEventModel().getEndTime());
    }
}
