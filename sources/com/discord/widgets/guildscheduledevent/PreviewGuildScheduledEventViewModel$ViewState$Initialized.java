package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PreviewGuildScheduledEventViewModel$ViewState$Initialized extends PreviewGuildScheduledEventViewModel$ViewState {
    private final boolean canNotifyEveryone;
    private final GuildScheduledEventModel eventModel;
    private final WidgetPreviewGuildScheduledEvent$Companion$Action existingEventAction;
    private final boolean isStartingEvent;
    private final GuildScheduledEventLocationInfo locationInfo;
    private final boolean requestProcessing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewGuildScheduledEventViewModel$ViewState$Initialized(boolean z2, WidgetPreviewGuildScheduledEvent$Companion$Action widgetPreviewGuildScheduledEvent$Companion$Action, boolean z3, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, GuildScheduledEventModel guildScheduledEventModel) {
        super(null);
        m.checkNotNullParameter(guildScheduledEventLocationInfo, "locationInfo");
        m.checkNotNullParameter(guildScheduledEventModel, "eventModel");
        this.requestProcessing = z2;
        this.existingEventAction = widgetPreviewGuildScheduledEvent$Companion$Action;
        this.canNotifyEveryone = z3;
        this.locationInfo = guildScheduledEventLocationInfo;
        this.eventModel = guildScheduledEventModel;
        this.isStartingEvent = widgetPreviewGuildScheduledEvent$Companion$Action == WidgetPreviewGuildScheduledEvent$Companion$Action.START_EVENT;
    }

    public static /* synthetic */ PreviewGuildScheduledEventViewModel$ViewState$Initialized copy$default(PreviewGuildScheduledEventViewModel$ViewState$Initialized previewGuildScheduledEventViewModel$ViewState$Initialized, boolean z2, WidgetPreviewGuildScheduledEvent$Companion$Action widgetPreviewGuildScheduledEvent$Companion$Action, boolean z3, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, GuildScheduledEventModel guildScheduledEventModel, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = previewGuildScheduledEventViewModel$ViewState$Initialized.requestProcessing;
        }
        if ((i & 2) != 0) {
            widgetPreviewGuildScheduledEvent$Companion$Action = previewGuildScheduledEventViewModel$ViewState$Initialized.existingEventAction;
        }
        WidgetPreviewGuildScheduledEvent$Companion$Action widgetPreviewGuildScheduledEvent$Companion$Action2 = widgetPreviewGuildScheduledEvent$Companion$Action;
        if ((i & 4) != 0) {
            z3 = previewGuildScheduledEventViewModel$ViewState$Initialized.canNotifyEveryone;
        }
        boolean z4 = z3;
        if ((i & 8) != 0) {
            guildScheduledEventLocationInfo = previewGuildScheduledEventViewModel$ViewState$Initialized.locationInfo;
        }
        GuildScheduledEventLocationInfo guildScheduledEventLocationInfo2 = guildScheduledEventLocationInfo;
        if ((i & 16) != 0) {
            guildScheduledEventModel = previewGuildScheduledEventViewModel$ViewState$Initialized.eventModel;
        }
        return previewGuildScheduledEventViewModel$ViewState$Initialized.copy(z2, widgetPreviewGuildScheduledEvent$Companion$Action2, z4, guildScheduledEventLocationInfo2, guildScheduledEventModel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getRequestProcessing() {
        return this.requestProcessing;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WidgetPreviewGuildScheduledEvent$Companion$Action getExistingEventAction() {
        return this.existingEventAction;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanNotifyEveryone() {
        return this.canNotifyEveryone;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildScheduledEventLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GuildScheduledEventModel getEventModel() {
        return this.eventModel;
    }

    public final PreviewGuildScheduledEventViewModel$ViewState$Initialized copy(boolean requestProcessing, WidgetPreviewGuildScheduledEvent$Companion$Action existingEventAction, boolean canNotifyEveryone, GuildScheduledEventLocationInfo locationInfo, GuildScheduledEventModel eventModel) {
        m.checkNotNullParameter(locationInfo, "locationInfo");
        m.checkNotNullParameter(eventModel, "eventModel");
        return new PreviewGuildScheduledEventViewModel$ViewState$Initialized(requestProcessing, existingEventAction, canNotifyEveryone, locationInfo, eventModel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewGuildScheduledEventViewModel$ViewState$Initialized)) {
            return false;
        }
        PreviewGuildScheduledEventViewModel$ViewState$Initialized previewGuildScheduledEventViewModel$ViewState$Initialized = (PreviewGuildScheduledEventViewModel$ViewState$Initialized) other;
        return this.requestProcessing == previewGuildScheduledEventViewModel$ViewState$Initialized.requestProcessing && m.areEqual(this.existingEventAction, previewGuildScheduledEventViewModel$ViewState$Initialized.existingEventAction) && this.canNotifyEveryone == previewGuildScheduledEventViewModel$ViewState$Initialized.canNotifyEveryone && m.areEqual(this.locationInfo, previewGuildScheduledEventViewModel$ViewState$Initialized.locationInfo) && m.areEqual(this.eventModel, previewGuildScheduledEventViewModel$ViewState$Initialized.eventModel);
    }

    public final boolean getCanNotifyEveryone() {
        return this.canNotifyEveryone;
    }

    public final GuildScheduledEventModel getEventModel() {
        return this.eventModel;
    }

    public final WidgetPreviewGuildScheduledEvent$Companion$Action getExistingEventAction() {
        return this.existingEventAction;
    }

    public final GuildScheduledEventLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    public final boolean getRequestProcessing() {
        return this.requestProcessing;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        boolean z2 = this.requestProcessing;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        WidgetPreviewGuildScheduledEvent$Companion$Action widgetPreviewGuildScheduledEvent$Companion$Action = this.existingEventAction;
        int iHashCode = (i + (widgetPreviewGuildScheduledEvent$Companion$Action != null ? widgetPreviewGuildScheduledEvent$Companion$Action.hashCode() : 0)) * 31;
        boolean z3 = this.canNotifyEveryone;
        int i2 = (iHashCode + (z3 ? 1 : z3)) * 31;
        GuildScheduledEventLocationInfo guildScheduledEventLocationInfo = this.locationInfo;
        int iHashCode2 = (i2 + (guildScheduledEventLocationInfo != null ? guildScheduledEventLocationInfo.hashCode() : 0)) * 31;
        GuildScheduledEventModel guildScheduledEventModel = this.eventModel;
        return iHashCode2 + (guildScheduledEventModel != null ? guildScheduledEventModel.hashCode() : 0);
    }

    /* JADX INFO: renamed from: isStartingEvent, reason: from getter */
    public final boolean getIsStartingEvent() {
        return this.isStartingEvent;
    }

    public String toString() {
        StringBuilder sbU = a.U("Initialized(requestProcessing=");
        sbU.append(this.requestProcessing);
        sbU.append(", existingEventAction=");
        sbU.append(this.existingEventAction);
        sbU.append(", canNotifyEveryone=");
        sbU.append(this.canNotifyEveryone);
        sbU.append(", locationInfo=");
        sbU.append(this.locationInfo);
        sbU.append(", eventModel=");
        sbU.append(this.eventModel);
        sbU.append(")");
        return sbU.toString();
    }
}
