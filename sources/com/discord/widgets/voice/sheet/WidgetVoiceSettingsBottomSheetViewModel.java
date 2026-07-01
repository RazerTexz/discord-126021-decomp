package com.discord.widgets.voice.sheet;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreMediaSettings$NoiseProcessing;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheetViewModel extends d0<WidgetVoiceSettingsBottomSheetViewModel$ViewState> {
    public static final WidgetVoiceSettingsBottomSheetViewModel$Companion Companion = new WidgetVoiceSettingsBottomSheetViewModel$Companion(null);
    private final long channelId;
    private final StoreMediaSettings mediaSettingsStore;
    private final StoreStageChannels stageChannelsStore;
    private final Observable<WidgetVoiceSettingsBottomSheetViewModel$StoreState> storeObservable;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel(long j, StoreStageChannels storeStageChannels, Observable observable, StoreMediaSettings storeMediaSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreStageChannels stageChannels = (i & 2) != 0 ? StoreStream.Companion.getStageChannels() : storeStageChannels;
        this(j, stageChannels, (i & 4) != 0 ? WidgetVoiceSettingsBottomSheetViewModel$Companion.access$observeStoreState(Companion, j, stageChannels) : observable, (i & 8) != 0 ? StoreStream.Companion.getMediaSettings() : storeMediaSettings);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetVoiceSettingsBottomSheetViewModel widgetVoiceSettingsBottomSheetViewModel, WidgetVoiceSettingsBottomSheetViewModel$StoreState widgetVoiceSettingsBottomSheetViewModel$StoreState) {
        widgetVoiceSettingsBottomSheetViewModel.handleStoreState(widgetVoiceSettingsBottomSheetViewModel$StoreState);
    }

    private final void handleStoreState(WidgetVoiceSettingsBottomSheetViewModel$StoreState storeState) {
        if (storeState instanceof WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid) {
            WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid = (WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid) storeState;
            boolean z2 = widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.getCallModel().getIsVideoCall() || widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.getCallModel().getActiveStream() != null;
            boolean zD = ChannelUtils.D(widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.getCallModel().getChannel());
            boolean z3 = widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.getCallModel().canInvite() && !zD;
            boolean zD2 = ChannelUtils.D(widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.getCallModel().getChannel());
            boolean z4 = widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.getCallModel().getVoiceSettings().getNoiseProcessing() == StoreMediaSettings$NoiseProcessing.Cancellation;
            StageRoles stageRolesM76getMyStageRolestwRsX0 = widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.m76getMyStageRolestwRsX0();
            updateViewState(new WidgetVoiceSettingsBottomSheetViewModel$ViewState(widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.getCallModel().getChannel(), !widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.getCallModel().getVoiceSettings().getVoiceParticipantsHidden(), z2, z3, z4, zD && (stageRolesM76getMyStageRolestwRsX0 != null && StageRoles.m32isModeratorimpl(stageRolesM76getMyStageRolestwRsX0.m35unboximpl())), zD2, widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.getCallModel().getGuild()));
        }
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Observable<WidgetVoiceSettingsBottomSheetViewModel$StoreState> getStoreObservable() {
        return this.storeObservable;
    }

    public final void onToggleNoiseCancellation() {
        this.mediaSettingsStore.toggleNoiseCancellation();
    }

    public final void onToggleVoiceParticipantsHidden() {
        WidgetVoiceSettingsBottomSheetViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            this.mediaSettingsStore.updateVoiceParticipantsHidden(viewState.getShowVoiceParticipants());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceSettingsBottomSheetViewModel(long j, StoreStageChannels storeStageChannels, Observable<WidgetVoiceSettingsBottomSheetViewModel$StoreState> observable, StoreMediaSettings storeMediaSettings) {
        super(null, 1, null);
        m.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        m.checkNotNullParameter(observable, "storeObservable");
        m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        this.channelId = j;
        this.stageChannelsStore = storeStageChannels;
        this.storeObservable = observable;
        this.mediaSettingsStore = storeMediaSettings;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetVoiceSettingsBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceSettingsBottomSheetViewModel$1(this), 62, (Object) null);
    }
}
