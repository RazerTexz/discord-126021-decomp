package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.restapi.RestAPIParams$CreateGuildScheduledEventBody;
import com.discord.restapi.RestAPIParams$UpdateGuildScheduledEventBody;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageChannelAPI;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PreviewGuildScheduledEventViewModel extends d0<PreviewGuildScheduledEventViewModel$ViewState> {
    private final StoreChannels channelsStore;
    private PreviewGuildScheduledEventViewModel$ViewState currentViewState;
    private final GuildScheduledEventModel eventModel;
    private final WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData existingEventData;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StorePermissions permissionsStore;

    public /* synthetic */ PreviewGuildScheduledEventViewModel(GuildScheduledEventModel guildScheduledEventModel, WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData widgetPreviewGuildScheduledEvent$Companion$ExistingEventData, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildScheduledEventModel, widgetPreviewGuildScheduledEvent$Companion$ExistingEventData, (i & 4) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 8) != 0 ? StoreStream.Companion.getPermissions() : storePermissions, (i & 16) != 0 ? StoreStream.Companion.getGuildScheduledEvents() : storeGuildScheduledEvents);
    }

    public static final /* synthetic */ void access$setRequestFinished(PreviewGuildScheduledEventViewModel previewGuildScheduledEventViewModel) {
        previewGuildScheduledEventViewModel.setRequestFinished();
    }

    private final boolean canNotifyEveryone(Channel channel) {
        Long l;
        if (channel == null || !ChannelUtils.D(channel) || (l = (Long) a.d(channel, this.permissionsStore.getPermissionsByChannel())) == null) {
            return false;
        }
        return PermissionUtils.can(Permission.MENTION_EVERYONE, Long.valueOf(l.longValue()));
    }

    private final void createEvent(Context context, Function1<? super Long, Unit> onRequestSuccess) {
        RestAPIParams$CreateGuildScheduledEventBody createRequestBody = this.eventModel.toCreateRequestBody();
        if (createRequestBody != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().createGuildScheduledEvent(this.eventModel.getGuildId(), createRequestBody), false, 1, null), this, null, 2, null), PreviewGuildScheduledEventViewModel.class, context, (Function1) null, new PreviewGuildScheduledEventViewModel$createEvent$1(this), (Function0) null, (Function0) null, new PreviewGuildScheduledEventViewModel$createEvent$2(this, onRequestSuccess), 52, (Object) null);
        }
    }

    private final void editEvent(Context context, Function1<? super Long, Unit> onRequestSuccess) {
        long guildScheduledEventId;
        GuildScheduledEvent guildScheduledEventFindEventFromStore;
        RestAPIParams$UpdateGuildScheduledEventBody updateRequestBody;
        WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData widgetPreviewGuildScheduledEvent$Companion$ExistingEventData = this.existingEventData;
        if (widgetPreviewGuildScheduledEvent$Companion$ExistingEventData == null || (guildScheduledEventFindEventFromStore = this.guildScheduledEventsStore.findEventFromStore((guildScheduledEventId = widgetPreviewGuildScheduledEvent$Companion$ExistingEventData.getGuildScheduledEventId()), Long.valueOf(this.eventModel.getGuildId()))) == null || (updateRequestBody = this.eventModel.toUpdateRequestBody(guildScheduledEventFindEventFromStore)) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateGuildScheduledEvent(guildScheduledEventFindEventFromStore.getGuildId(), guildScheduledEventId, updateRequestBody), false, 1, null), this, null, 2, null), PreviewGuildScheduledEventViewModel.class, context, (Function1) null, new PreviewGuildScheduledEventViewModel$editEvent$1(this), (Function0) null, (Function0) null, new PreviewGuildScheduledEventViewModel$editEvent$2(this, onRequestSuccess, guildScheduledEventId), 52, (Object) null);
    }

    public static /* synthetic */ void onBottomButtonClicked$default(PreviewGuildScheduledEventViewModel previewGuildScheduledEventViewModel, Context context, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        previewGuildScheduledEventViewModel.onBottomButtonClicked(context, z2, function1);
    }

    private final void setRequestFinished() {
        PreviewGuildScheduledEventViewModel$ViewState previewGuildScheduledEventViewModel$ViewStateRequireViewState = requireViewState();
        Objects.requireNonNull(previewGuildScheduledEventViewModel$ViewStateRequireViewState, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel.ViewState.Initialized");
        updateViewState(PreviewGuildScheduledEventViewModel$ViewState$Initialized.copy$default((PreviewGuildScheduledEventViewModel$ViewState$Initialized) previewGuildScheduledEventViewModel$ViewStateRequireViewState, false, null, false, null, null, 30, null));
    }

    private final void startEvent(Context context, Function1<? super Long, Unit> onRequestSuccess) {
        WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData widgetPreviewGuildScheduledEvent$Companion$ExistingEventData = this.existingEventData;
        if (widgetPreviewGuildScheduledEvent$Companion$ExistingEventData != null) {
            long guildScheduledEventId = widgetPreviewGuildScheduledEvent$Companion$ExistingEventData.getGuildScheduledEventId();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(GuildScheduledEventAPI.INSTANCE.startEvent(this.eventModel.getGuildId(), guildScheduledEventId), false, 1, null), this, null, 2, null), PreviewGuildScheduledEventViewModel.class, context, (Function1) null, new PreviewGuildScheduledEventViewModel$startEvent$1(this), (Function0) null, (Function0) null, new PreviewGuildScheduledEventViewModel$startEvent$2(this, onRequestSuccess, guildScheduledEventId), 52, (Object) null);
        }
    }

    private final void startStageEvent(Context context, boolean sendNotification, Function1<? super Long, Unit> onRequestSuccess) {
        if (this.eventModel.getName() == null || this.eventModel.getChannelId() == null) {
            return;
        }
        WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData widgetPreviewGuildScheduledEvent$Companion$ExistingEventData = this.existingEventData;
        Long lValueOf = widgetPreviewGuildScheduledEvent$Companion$ExistingEventData != null ? Long.valueOf(widgetPreviewGuildScheduledEvent$Companion$ExistingEventData.getGuildScheduledEventId()) : null;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.INSTANCE.startStageInstance(this.eventModel.getChannelId().longValue(), this.eventModel.getName(), StageInstancePrivacyLevel.GUILD_ONLY, sendNotification, String.valueOf(lValueOf)), false, 1, null), this, null, 2, null), PreviewGuildScheduledEventViewModel.class, context, (Function1) null, new PreviewGuildScheduledEventViewModel$startStageEvent$1(this), (Function0) null, (Function0) null, new PreviewGuildScheduledEventViewModel$startStageEvent$2(this, onRequestSuccess, lValueOf), 52, (Object) null);
    }

    public final PreviewGuildScheduledEventViewModel$ViewState getCurrentViewState() {
        return this.currentViewState;
    }

    public final boolean isCreate() {
        return this.existingEventData == null;
    }

    public final void onBottomButtonClicked(Context context, boolean sendNotification, Function1<? super Long, Unit> onRequestSuccess) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(onRequestSuccess, "onRequestSuccess");
        PreviewGuildScheduledEventViewModel$ViewState previewGuildScheduledEventViewModel$ViewState = this.currentViewState;
        Objects.requireNonNull(previewGuildScheduledEventViewModel$ViewState, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel.ViewState.Initialized");
        PreviewGuildScheduledEventViewModel$ViewState$Initialized previewGuildScheduledEventViewModel$ViewState$Initialized = (PreviewGuildScheduledEventViewModel$ViewState$Initialized) previewGuildScheduledEventViewModel$ViewState;
        if (previewGuildScheduledEventViewModel$ViewState$Initialized.getRequestProcessing()) {
            return;
        }
        updateViewState(PreviewGuildScheduledEventViewModel$ViewState$Initialized.copy$default(previewGuildScheduledEventViewModel$ViewState$Initialized, true, null, false, null, null, 30, null));
        WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData widgetPreviewGuildScheduledEvent$Companion$ExistingEventData = this.existingEventData;
        if (widgetPreviewGuildScheduledEvent$Companion$ExistingEventData == null) {
            createEvent(context, onRequestSuccess);
            return;
        }
        if (widgetPreviewGuildScheduledEvent$Companion$ExistingEventData.getAction() == WidgetPreviewGuildScheduledEvent$Companion$Action.EDIT_EVENT) {
            editEvent(context, onRequestSuccess);
        } else if (this.eventModel.getEntityType().ordinal() != 1) {
            startEvent(context, onRequestSuccess);
        } else {
            startStageEvent(context, sendNotification, onRequestSuccess);
        }
    }

    public final void setCurrentViewState(PreviewGuildScheduledEventViewModel$ViewState previewGuildScheduledEventViewModel$ViewState) {
        m.checkNotNullParameter(previewGuildScheduledEventViewModel$ViewState, "<set-?>");
        this.currentViewState = previewGuildScheduledEventViewModel$ViewState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewGuildScheduledEventViewModel(GuildScheduledEventModel guildScheduledEventModel, WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData widgetPreviewGuildScheduledEvent$Companion$ExistingEventData, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents) {
        super(PreviewGuildScheduledEventViewModel$ViewState$Initial.INSTANCE);
        m.checkNotNullParameter(guildScheduledEventModel, "eventModel");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        this.eventModel = guildScheduledEventModel;
        this.existingEventData = widgetPreviewGuildScheduledEvent$Companion$ExistingEventData;
        this.channelsStore = storeChannels;
        this.permissionsStore = storePermissions;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        boolean z2 = (widgetPreviewGuildScheduledEvent$Companion$ExistingEventData != null ? widgetPreviewGuildScheduledEvent$Companion$ExistingEventData.getAction() : null) == WidgetPreviewGuildScheduledEvent$Companion$Action.START_EVENT;
        Long channelId = guildScheduledEventModel.getChannelId();
        Channel channel = channelId != null ? storeChannels.getChannel(channelId.longValue()) : null;
        PreviewGuildScheduledEventViewModel$ViewState$Initialized previewGuildScheduledEventViewModel$ViewState$Initialized = new PreviewGuildScheduledEventViewModel$ViewState$Initialized(false, widgetPreviewGuildScheduledEvent$Companion$ExistingEventData != null ? widgetPreviewGuildScheduledEvent$Companion$ExistingEventData.getAction() : null, z2 && canNotifyEveryone(channel), GuildScheduledEventLocationInfo.Companion.buildLocationInfo(guildScheduledEventModel, channel), guildScheduledEventModel);
        this.currentViewState = previewGuildScheduledEventViewModel$ViewState$Initialized;
        updateViewState(previewGuildScheduledEventViewModel$ViewState$Initialized);
    }
}
