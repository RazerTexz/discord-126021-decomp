package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.stage.StageChannelAPI;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PreviewGuildScheduledEventViewModel extends AbstractC0859d0<ViewState> {
    private final StoreChannels channelsStore;
    private ViewState currentViewState;
    private final GuildScheduledEventModel eventModel;
    private final WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StorePermissions permissionsStore;

    /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
        public static final class Initial extends ViewState {
            public static final Initial INSTANCE = new Initial();

            private Initial() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
        public static final /* data */ class Initialized extends ViewState {
            private final boolean canNotifyEveryone;
            private final GuildScheduledEventModel eventModel;
            private final WidgetPreviewGuildScheduledEvent.Companion.Action existingEventAction;
            private final boolean isStartingEvent;
            private final GuildScheduledEventLocationInfo locationInfo;
            private final boolean requestProcessing;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialized(boolean z2, WidgetPreviewGuildScheduledEvent.Companion.Action action, boolean z3, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, GuildScheduledEventModel guildScheduledEventModel) {
                super(null);
                C12238m.checkNotNullParameter(guildScheduledEventLocationInfo, "locationInfo");
                C12238m.checkNotNullParameter(guildScheduledEventModel, "eventModel");
                this.requestProcessing = z2;
                this.existingEventAction = action;
                this.canNotifyEveryone = z3;
                this.locationInfo = guildScheduledEventLocationInfo;
                this.eventModel = guildScheduledEventModel;
                this.isStartingEvent = action == WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT;
            }

            public static /* synthetic */ Initialized copy$default(Initialized initialized, boolean z2, WidgetPreviewGuildScheduledEvent.Companion.Action action, boolean z3, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, GuildScheduledEventModel guildScheduledEventModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = initialized.requestProcessing;
                }
                if ((i & 2) != 0) {
                    action = initialized.existingEventAction;
                }
                WidgetPreviewGuildScheduledEvent.Companion.Action action2 = action;
                if ((i & 4) != 0) {
                    z3 = initialized.canNotifyEveryone;
                }
                boolean z4 = z3;
                if ((i & 8) != 0) {
                    guildScheduledEventLocationInfo = initialized.locationInfo;
                }
                GuildScheduledEventLocationInfo guildScheduledEventLocationInfo2 = guildScheduledEventLocationInfo;
                if ((i & 16) != 0) {
                    guildScheduledEventModel = initialized.eventModel;
                }
                return initialized.copy(z2, action2, z4, guildScheduledEventLocationInfo2, guildScheduledEventModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getRequestProcessing() {
                return this.requestProcessing;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final WidgetPreviewGuildScheduledEvent.Companion.Action getExistingEventAction() {
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

            public final Initialized copy(boolean requestProcessing, WidgetPreviewGuildScheduledEvent.Companion.Action existingEventAction, boolean canNotifyEveryone, GuildScheduledEventLocationInfo locationInfo, GuildScheduledEventModel eventModel) {
                C12238m.checkNotNullParameter(locationInfo, "locationInfo");
                C12238m.checkNotNullParameter(eventModel, "eventModel");
                return new Initialized(requestProcessing, existingEventAction, canNotifyEveryone, locationInfo, eventModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialized)) {
                    return false;
                }
                Initialized initialized = (Initialized) other;
                return this.requestProcessing == initialized.requestProcessing && C12238m.areEqual(this.existingEventAction, initialized.existingEventAction) && this.canNotifyEveryone == initialized.canNotifyEveryone && C12238m.areEqual(this.locationInfo, initialized.locationInfo) && C12238m.areEqual(this.eventModel, initialized.eventModel);
            }

            public final boolean getCanNotifyEveryone() {
                return this.canNotifyEveryone;
            }

            public final GuildScheduledEventModel getEventModel() {
                return this.eventModel;
            }

            public final WidgetPreviewGuildScheduledEvent.Companion.Action getExistingEventAction() {
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
                WidgetPreviewGuildScheduledEvent.Companion.Action action = this.existingEventAction;
                int iHashCode = (i + (action != null ? action.hashCode() : 0)) * 31;
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
                StringBuilder sbM833U = C1643a.m833U("Initialized(requestProcessing=");
                sbM833U.append(this.requestProcessing);
                sbM833U.append(", existingEventAction=");
                sbM833U.append(this.existingEventAction);
                sbM833U.append(", canNotifyEveryone=");
                sbM833U.append(this.canNotifyEveryone);
                sbM833U.append(", locationInfo=");
                sbM833U.append(this.locationInfo);
                sbM833U.append(", eventModel=");
                sbM833U.append(this.eventModel);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
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

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildScheduledEventEntityType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildScheduledEventEntityType.STAGE_INSTANCE.ordinal()] = 1;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$createEvent$1 */
    /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
    public static final class C88321 extends AbstractC12240o implements Function1<Error, Unit> {
        public C88321() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            PreviewGuildScheduledEventViewModel.this.setRequestFinished();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$createEvent$2 */
    /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
    public static final class C88332 extends AbstractC12240o implements Function1<GuildScheduledEvent, Unit> {
        public final /* synthetic */ Function1 $onRequestSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88332(Function1 function1) {
            super(1);
            this.$onRequestSuccess = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            PreviewGuildScheduledEventViewModel.this.setRequestFinished();
            this.$onRequestSuccess.invoke(guildScheduledEvent != null ? Long.valueOf(guildScheduledEvent.getId()) : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$editEvent$1 */
    /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
    public static final class C88341 extends AbstractC12240o implements Function1<Error, Unit> {
        public C88341() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            PreviewGuildScheduledEventViewModel.this.setRequestFinished();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$editEvent$2 */
    /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
    public static final class C88352 extends AbstractC12240o implements Function1<Unit, Unit> {
        public final /* synthetic */ long $eventId;
        public final /* synthetic */ Function1 $onRequestSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88352(Function1 function1, long j) {
            super(1);
            this.$onRequestSuccess = function1;
            this.$eventId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            C12238m.checkNotNullParameter(unit, "it");
            PreviewGuildScheduledEventViewModel.this.setRequestFinished();
            this.$onRequestSuccess.invoke(Long.valueOf(this.$eventId));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$startEvent$1 */
    /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
    public static final class C88361 extends AbstractC12240o implements Function1<Error, Unit> {
        public C88361() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            PreviewGuildScheduledEventViewModel.this.setRequestFinished();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$startEvent$2 */
    /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
    public static final class C88372 extends AbstractC12240o implements Function1<Unit, Unit> {
        public final /* synthetic */ long $eventId;
        public final /* synthetic */ Function1 $onRequestSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88372(Function1 function1, long j) {
            super(1);
            this.$onRequestSuccess = function1;
            this.$eventId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            C12238m.checkNotNullParameter(unit, "it");
            PreviewGuildScheduledEventViewModel.this.setRequestFinished();
            this.$onRequestSuccess.invoke(Long.valueOf(this.$eventId));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$startStageEvent$1 */
    /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
    public static final class C88381 extends AbstractC12240o implements Function1<Error, Unit> {
        public C88381() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            PreviewGuildScheduledEventViewModel.this.setRequestFinished();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$startStageEvent$2 */
    /* JADX INFO: compiled from: PreviewGuildScheduledEventViewModel.kt */
    public static final class C88392 extends AbstractC12240o implements Function1<StageInstance, Unit> {
        public final /* synthetic */ Long $eventId;
        public final /* synthetic */ Function1 $onRequestSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88392(Function1 function1, Long l) {
            super(1);
            this.$onRequestSuccess = function1;
            this.$eventId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            C12238m.checkNotNullParameter(stageInstance, "it");
            PreviewGuildScheduledEventViewModel.this.setRequestFinished();
            this.$onRequestSuccess.invoke(this.$eventId);
        }
    }

    public /* synthetic */ PreviewGuildScheduledEventViewModel(GuildScheduledEventModel guildScheduledEventModel, WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildScheduledEventModel, existingEventData, (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 8) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 16) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents);
    }

    private final boolean canNotifyEveryone(Channel channel) {
        Long l;
        if (channel == null || !ChannelUtils.m7669D(channel) || (l = (Long) C1643a.m845d(channel, this.permissionsStore.getPermissionsByChannel())) == null) {
            return false;
        }
        return PermissionUtils.can(Permission.MENTION_EVERYONE, Long.valueOf(l.longValue()));
    }

    private final void createEvent(Context context, Function1<? super Long, Unit> onRequestSuccess) {
        RestAPIParams.CreateGuildScheduledEventBody createRequestBody = this.eventModel.toCreateRequestBody();
        if (createRequestBody != null) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createGuildScheduledEvent(this.eventModel.getGuildId(), createRequestBody), false, 1, null), this, null, 2, null), (Class<?>) PreviewGuildScheduledEventViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C88321()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88332(onRequestSuccess));
        }
    }

    private final void editEvent(Context context, Function1<? super Long, Unit> onRequestSuccess) {
        long guildScheduledEventId;
        GuildScheduledEvent guildScheduledEventFindEventFromStore;
        RestAPIParams.UpdateGuildScheduledEventBody updateRequestBody;
        WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData = this.existingEventData;
        if (existingEventData == null || (guildScheduledEventFindEventFromStore = this.guildScheduledEventsStore.findEventFromStore((guildScheduledEventId = existingEventData.getGuildScheduledEventId()), Long.valueOf(this.eventModel.getGuildId()))) == null || (updateRequestBody = this.eventModel.toUpdateRequestBody(guildScheduledEventFindEventFromStore)) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuildScheduledEvent(guildScheduledEventFindEventFromStore.getGuildId(), guildScheduledEventId, updateRequestBody), false, 1, null), this, null, 2, null), (Class<?>) PreviewGuildScheduledEventViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C88341()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88352(onRequestSuccess, guildScheduledEventId));
    }

    public static /* synthetic */ void onBottomButtonClicked$default(PreviewGuildScheduledEventViewModel previewGuildScheduledEventViewModel, Context context, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        previewGuildScheduledEventViewModel.onBottomButtonClicked(context, z2, function1);
    }

    private final void setRequestFinished() {
        ViewState viewStateRequireViewState = requireViewState();
        Objects.requireNonNull(viewStateRequireViewState, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel.ViewState.Initialized");
        updateViewState(ViewState.Initialized.copy$default((ViewState.Initialized) viewStateRequireViewState, false, null, false, null, null, 30, null));
    }

    private final void startEvent(Context context, Function1<? super Long, Unit> onRequestSuccess) {
        WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData = this.existingEventData;
        if (existingEventData != null) {
            long guildScheduledEventId = existingEventData.getGuildScheduledEventId();
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(GuildScheduledEventAPI.INSTANCE.startEvent(this.eventModel.getGuildId(), guildScheduledEventId), false, 1, null), this, null, 2, null), (Class<?>) PreviewGuildScheduledEventViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C88361()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88372(onRequestSuccess, guildScheduledEventId));
        }
    }

    private final void startStageEvent(Context context, boolean sendNotification, Function1<? super Long, Unit> onRequestSuccess) {
        if (this.eventModel.getName() == null || this.eventModel.getChannelId() == null) {
            return;
        }
        WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData = this.existingEventData;
        Long lValueOf = existingEventData != null ? Long.valueOf(existingEventData.getGuildScheduledEventId()) : null;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.INSTANCE.startStageInstance(this.eventModel.getChannelId().longValue(), this.eventModel.getName(), StageInstancePrivacyLevel.GUILD_ONLY, sendNotification, String.valueOf(lValueOf)), false, 1, null), this, null, 2, null), (Class<?>) PreviewGuildScheduledEventViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C88381()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88392(onRequestSuccess, lValueOf));
    }

    public final ViewState getCurrentViewState() {
        return this.currentViewState;
    }

    public final boolean isCreate() {
        return this.existingEventData == null;
    }

    public final void onBottomButtonClicked(Context context, boolean sendNotification, Function1<? super Long, Unit> onRequestSuccess) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(onRequestSuccess, "onRequestSuccess");
        ViewState viewState = this.currentViewState;
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel.ViewState.Initialized");
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized.getRequestProcessing()) {
            return;
        }
        updateViewState(ViewState.Initialized.copy$default(initialized, true, null, false, null, null, 30, null));
        WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData = this.existingEventData;
        if (existingEventData == null) {
            createEvent(context, onRequestSuccess);
            return;
        }
        if (existingEventData.getAction() == WidgetPreviewGuildScheduledEvent.Companion.Action.EDIT_EVENT) {
            editEvent(context, onRequestSuccess);
        } else if (this.eventModel.getEntityType().ordinal() != 1) {
            startEvent(context, onRequestSuccess);
        } else {
            startStageEvent(context, sendNotification, onRequestSuccess);
        }
    }

    public final void setCurrentViewState(ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "<set-?>");
        this.currentViewState = viewState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewGuildScheduledEventViewModel(GuildScheduledEventModel guildScheduledEventModel, WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents) {
        super(ViewState.Initial.INSTANCE);
        C12238m.checkNotNullParameter(guildScheduledEventModel, "eventModel");
        C12238m.checkNotNullParameter(storeChannels, "channelsStore");
        C12238m.checkNotNullParameter(storePermissions, "permissionsStore");
        C12238m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        this.eventModel = guildScheduledEventModel;
        this.existingEventData = existingEventData;
        this.channelsStore = storeChannels;
        this.permissionsStore = storePermissions;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        boolean z2 = (existingEventData != null ? existingEventData.getAction() : null) == WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT;
        Long channelId = guildScheduledEventModel.getChannelId();
        Channel channel = channelId != null ? storeChannels.getChannel(channelId.longValue()) : null;
        ViewState.Initialized initialized = new ViewState.Initialized(false, existingEventData != null ? existingEventData.getAction() : null, z2 && canNotifyEveryone(channel), GuildScheduledEventLocationInfo.INSTANCE.buildLocationInfo(guildScheduledEventModel, channel), guildScheduledEventModel);
        this.currentViewState = initialized;
        updateViewState(initialized);
    }
}
