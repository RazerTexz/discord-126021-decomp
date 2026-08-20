package com.discord.widgets.voice.sheet;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreMediaSettings mediaSettingsStore;
    private final StoreStageChannels stageChannelsStore;
    private final Observable<StoreState> storeObservable;

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheetViewModel$1 */
    /* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
    public static final class C106151 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C106151() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            WidgetVoiceSettingsBottomSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final long channelId, final StoreStageChannels stageChannelsStore) {
            Observable<StoreState> observableM11099Y = ObservableExtensionsKt.computationLatest(CallModel.INSTANCE.get(channelId)).m11112r().m11099Y(new InterfaceC12589b<CallModel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheetViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetVoiceSettingsBottomSheetViewModel.StoreState> call(final CallModel callModel) {
                    return callModel == null ? new C12721k(WidgetVoiceSettingsBottomSheetViewModel.StoreState.Invalid.INSTANCE) : stageChannelsStore.observeMyRoles(channelId).m11083G(new InterfaceC12589b<StageRoles, WidgetVoiceSettingsBottomSheetViewModel.StoreState.Valid>() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheetViewModel$Companion$observeStoreState$1.1
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final WidgetVoiceSettingsBottomSheetViewModel.StoreState.Valid call(StageRoles stageRoles) {
                            return new WidgetVoiceSettingsBottomSheetViewModel.StoreState.Valid(callModel, stageRoles, null);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "CallModel.get(channelId)…          }\n            }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final CallModel callModel;
            private final StageRoles myStageRoles;

            public /* synthetic */ Valid(CallModel callModel, StageRoles stageRoles, DefaultConstructorMarker defaultConstructorMarker) {
                this(callModel, stageRoles);
            }

            /* JADX INFO: renamed from: copy-FZvHQiQ$default, reason: not valid java name */
            public static /* synthetic */ Valid m11450copyFZvHQiQ$default(Valid valid, CallModel callModel, StageRoles stageRoles, int i, Object obj) {
                if ((i & 1) != 0) {
                    callModel = valid.callModel;
                }
                if ((i & 2) != 0) {
                    stageRoles = valid.myStageRoles;
                }
                return valid.m11452copyFZvHQiQ(callModel, stageRoles);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CallModel getCallModel() {
                return this.callModel;
            }

            /* JADX INFO: renamed from: component2-twRsX-0, reason: not valid java name and from getter */
            public final StageRoles getMyStageRoles() {
                return this.myStageRoles;
            }

            /* JADX INFO: renamed from: copy-FZvHQiQ, reason: not valid java name */
            public final Valid m11452copyFZvHQiQ(CallModel callModel, StageRoles myStageRoles) {
                C12238m.checkNotNullParameter(callModel, "callModel");
                return new Valid(callModel, myStageRoles);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.callModel, valid.callModel) && C12238m.areEqual(this.myStageRoles, valid.myStageRoles);
            }

            public final CallModel getCallModel() {
                return this.callModel;
            }

            /* JADX INFO: renamed from: getMyStageRoles-twRsX-0, reason: not valid java name */
            public final StageRoles m11453getMyStageRolestwRsX0() {
                return this.myStageRoles;
            }

            public int hashCode() {
                CallModel callModel = this.callModel;
                int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
                StageRoles stageRoles = this.myStageRoles;
                return iHashCode + (stageRoles != null ? stageRoles.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(callModel=");
                sbM833U.append(this.callModel);
                sbM833U.append(", myStageRoles=");
                sbM833U.append(this.myStageRoles);
                sbM833U.append(")");
                return sbM833U.toString();
            }

            private Valid(CallModel callModel, StageRoles stageRoles) {
                super(null);
                this.callModel = callModel;
                this.myStageRoles = stageRoles;
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
    public static final /* data */ class ViewState implements WidgetVoiceSettingsBottomSheet.ViewState {
        private final Channel channel;
        private final Guild guild;
        private final boolean noiseCancellationEnabled;
        private final boolean showInviteItem;
        private final boolean showReportItem;
        private final boolean showStageSettings;
        private final boolean showVoiceParticipants;
        private final boolean showVoiceParticipantsToggle;

        public ViewState(Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Guild guild) {
            C12238m.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.showVoiceParticipants = z2;
            this.showVoiceParticipantsToggle = z3;
            this.showInviteItem = z4;
            this.noiseCancellationEnabled = z5;
            this.showStageSettings = z6;
            this.showReportItem = z7;
            this.guild = guild;
        }

        public final Channel component1() {
            return getChannel();
        }

        public final boolean component2() {
            return getShowVoiceParticipants();
        }

        public final boolean component3() {
            return getShowVoiceParticipantsToggle();
        }

        public final boolean component4() {
            return getShowInviteItem();
        }

        public final boolean component5() {
            return getNoiseCancellationEnabled();
        }

        public final boolean component6() {
            return getShowStageSettings();
        }

        public final boolean component7() {
            return getShowReportItem();
        }

        public final Guild component8() {
            return getGuild();
        }

        public final ViewState copy(Channel channel, boolean showVoiceParticipants, boolean showVoiceParticipantsToggle, boolean showInviteItem, boolean noiseCancellationEnabled, boolean showStageSettings, boolean showReportItem, Guild guild) {
            C12238m.checkNotNullParameter(channel, "channel");
            return new ViewState(channel, showVoiceParticipants, showVoiceParticipantsToggle, showInviteItem, noiseCancellationEnabled, showStageSettings, showReportItem, guild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return C12238m.areEqual(getChannel(), viewState.getChannel()) && getShowVoiceParticipants() == viewState.getShowVoiceParticipants() && getShowVoiceParticipantsToggle() == viewState.getShowVoiceParticipantsToggle() && getShowInviteItem() == viewState.getShowInviteItem() && getNoiseCancellationEnabled() == viewState.getNoiseCancellationEnabled() && getShowStageSettings() == viewState.getShowStageSettings() && getShowReportItem() == viewState.getShowReportItem() && C12238m.areEqual(getGuild(), viewState.getGuild());
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getNoiseCancellationEnabled() {
            return this.noiseCancellationEnabled;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getShowInviteItem() {
            return this.showInviteItem;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getShowReportItem() {
            return this.showReportItem;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getShowStageSettings() {
            return this.showStageSettings;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getShowVoiceParticipants() {
            return this.showVoiceParticipants;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.ViewState
        public boolean getShowVoiceParticipantsToggle() {
            return this.showVoiceParticipantsToggle;
        }

        public int hashCode() {
            Channel channel = getChannel();
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean showVoiceParticipants = getShowVoiceParticipants();
            int i = showVoiceParticipants;
            if (showVoiceParticipants) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean showVoiceParticipantsToggle = getShowVoiceParticipantsToggle();
            int i3 = showVoiceParticipantsToggle;
            if (showVoiceParticipantsToggle) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean showInviteItem = getShowInviteItem();
            int i5 = showInviteItem;
            if (showInviteItem) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean noiseCancellationEnabled = getNoiseCancellationEnabled();
            int i7 = noiseCancellationEnabled;
            if (noiseCancellationEnabled) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            boolean showStageSettings = getShowStageSettings();
            int i9 = showStageSettings;
            if (showStageSettings) {
                i9 = 1;
            }
            int i10 = (i8 + i9) * 31;
            boolean showReportItem = getShowReportItem();
            int i11 = (i10 + (showReportItem ? 1 : showReportItem)) * 31;
            Guild guild = getGuild();
            return i11 + (guild != null ? guild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(channel=");
            sbM833U.append(getChannel());
            sbM833U.append(", showVoiceParticipants=");
            sbM833U.append(getShowVoiceParticipants());
            sbM833U.append(", showVoiceParticipantsToggle=");
            sbM833U.append(getShowVoiceParticipantsToggle());
            sbM833U.append(", showInviteItem=");
            sbM833U.append(getShowInviteItem());
            sbM833U.append(", noiseCancellationEnabled=");
            sbM833U.append(getNoiseCancellationEnabled());
            sbM833U.append(", showStageSettings=");
            sbM833U.append(getShowStageSettings());
            sbM833U.append(", showReportItem=");
            sbM833U.append(getShowReportItem());
            sbM833U.append(", guild=");
            sbM833U.append(getGuild());
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel(long j, StoreStageChannels storeStageChannels, Observable observable, StoreMediaSettings storeMediaSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreStageChannels stageChannels = (i & 2) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels;
        this(j, stageChannels, (i & 4) != 0 ? INSTANCE.observeStoreState(j, stageChannels) : observable, (i & 8) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings);
    }

    private final void handleStoreState(StoreState storeState) {
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            boolean z2 = valid.getCallModel().getIsVideoCall() || valid.getCallModel().getActiveStream() != null;
            boolean zM7669D = ChannelUtils.m7669D(valid.getCallModel().getChannel());
            boolean z3 = valid.getCallModel().canInvite() && !zM7669D;
            boolean zM7669D2 = ChannelUtils.m7669D(valid.getCallModel().getChannel());
            boolean z4 = valid.getCallModel().getVoiceSettings().getNoiseProcessing() == StoreMediaSettings.NoiseProcessing.Cancellation;
            StageRoles stageRolesM11453getMyStageRolestwRsX0 = valid.m11453getMyStageRolestwRsX0();
            updateViewState(new ViewState(valid.getCallModel().getChannel(), !valid.getCallModel().getVoiceSettings().getVoiceParticipantsHidden(), z2, z3, z4, zM7669D && (stageRolesM11453getMyStageRolestwRsX0 != null && StageRoles.m11409isModeratorimpl(stageRolesM11453getMyStageRolestwRsX0.m11412unboximpl())), zM7669D2, valid.getCallModel().getGuild()));
        }
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Observable<StoreState> getStoreObservable() {
        return this.storeObservable;
    }

    public final void onToggleNoiseCancellation() {
        this.mediaSettingsStore.toggleNoiseCancellation();
    }

    public final void onToggleVoiceParticipantsHidden() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            this.mediaSettingsStore.updateVoiceParticipantsHidden(viewState.getShowVoiceParticipants());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceSettingsBottomSheetViewModel(long j, StoreStageChannels storeStageChannels, Observable<StoreState> observable, StoreMediaSettings storeMediaSettings) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        C12238m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        this.channelId = j;
        this.stageChannelsStore = storeStageChannels;
        this.storeObservable = observable;
        this.mediaSettingsStore = storeMediaSettings;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetVoiceSettingsBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C106151());
    }
}
