package com.discord.widgets.stage.sheet;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageChannelAPI;
import d0.g0.w;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheetViewModel extends d0<WidgetStageStartEventBottomSheetViewModel$ViewState> {
    public static final WidgetStageStartEventBottomSheetViewModel$Companion Companion = new WidgetStageStartEventBottomSheetViewModel$Companion(null);
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<WidgetStageStartEventBottomSheetViewModel$Event> eventSubject;
    private final StoreStageInstances stageInstanceStore;
    private WidgetStageStartEventBottomSheetViewModel$StoreState storeState;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetStageStartEventBottomSheetViewModel(long j, StoreChannels storeChannels, StoreStageInstances storeStageInstances, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreStageInstances stageInstances = (i & 4) != 0 ? StoreStream.Companion.getStageInstances() : storeStageInstances;
        this(j, channels, stageInstances, (i & 8) != 0 ? WidgetStageStartEventBottomSheetViewModel$Companion.access$observeStoreState(Companion, j, channels, stageInstances) : observable);
    }

    public static final /* synthetic */ void access$emitSetStatusFailureEvent(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel) {
        widgetStageStartEventBottomSheetViewModel.emitSetStatusFailureEvent();
    }

    public static final /* synthetic */ void access$emitSetStatusSuccessEvent(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel, Channel channel) {
        widgetStageStartEventBottomSheetViewModel.emitSetStatusSuccessEvent(channel);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel, WidgetStageStartEventBottomSheetViewModel$StoreState widgetStageStartEventBottomSheetViewModel$StoreState) {
        widgetStageStartEventBottomSheetViewModel.handleStoreState(widgetStageStartEventBottomSheetViewModel$StoreState);
    }

    public static final /* synthetic */ void access$setSelfSpeaker(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel) {
        widgetStageStartEventBottomSheetViewModel.setSelfSpeaker();
    }

    private final void emitSetStatusFailureEvent() {
        PublishSubject<WidgetStageStartEventBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure(2131888366));
    }

    private final void emitSetStatusSuccessEvent(Channel channel) {
        PublishSubject<WidgetStageStartEventBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess(channel));
    }

    @MainThread
    private final void handleStoreState(WidgetStageStartEventBottomSheetViewModel$StoreState storeState) {
        String topic;
        this.storeState = storeState;
        Channel channel = storeState.getChannel();
        StageInstance stageInstance = storeState.getStageInstance();
        if (stageInstance == null || (topic = stageInstance.getTopic()) == null) {
            topic = "";
        }
        updateViewState(new WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded(channel, topic, storeState.getStageInstance()));
    }

    private final void setSelfSpeaker() {
        Channel channel;
        WidgetStageStartEventBottomSheetViewModel$StoreState widgetStageStartEventBottomSheetViewModel$StoreState = this.storeState;
        if (widgetStageStartEventBottomSheetViewModel$StoreState == null || (channel = widgetStageStartEventBottomSheetViewModel$StoreState.getChannel()) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApiSerializeNulls().setMeSuppressed(channel, false), false, 1, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, WidgetStageStartEventBottomSheetViewModel$setSelfSpeaker$2.INSTANCE, (Function0) null, (Function0) null, WidgetStageStartEventBottomSheetViewModel$setSelfSpeaker$1.INSTANCE, 54, (Object) null);
    }

    public final Observable<WidgetStageStartEventBottomSheetViewModel$Event> observeEvents() {
        PublishSubject<WidgetStageStartEventBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void openStage(boolean microphonePermissionGranted) {
        WidgetStageStartEventBottomSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded widgetStageStartEventBottomSheetViewModel$ViewState$Loaded = (WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded) viewState;
        if (widgetStageStartEventBottomSheetViewModel$ViewState$Loaded != null) {
            String topic = widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.getTopic();
            Objects.requireNonNull(topic, "null cannot be cast to non-null type kotlin.CharSequence");
            String string = w.trim(topic).toString();
            String str = string.length() > 0 ? string : null;
            if (str == null) {
                this.eventSubject.k.onNext(new WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic(2131895876));
            } else if (widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.getStageInstance() == null) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.startStageInstance$default(StageChannelAPI.INSTANCE, this.channelId, str, StageInstancePrivacyLevel.GUILD_ONLY, false, null, 16, null), false, 1, null), this, null, 2, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, new WidgetStageStartEventBottomSheetViewModel$openStage$1(this), (Function0) null, (Function0) null, new WidgetStageStartEventBottomSheetViewModel$openStage$2(this, microphonePermissionGranted, widgetStageStartEventBottomSheetViewModel$ViewState$Loaded), 54, (Object) null);
            } else {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.updateStageInstance$default(StageChannelAPI.INSTANCE, this.channelId, str, null, 4, null), false, 1, null), this, null, 2, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, new WidgetStageStartEventBottomSheetViewModel$openStage$3(this), (Function0) null, (Function0) null, new WidgetStageStartEventBottomSheetViewModel$openStage$4(this, widgetStageStartEventBottomSheetViewModel$ViewState$Loaded), 54, (Object) null);
            }
        }
    }

    public final void setTopic(String topic) {
        m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        WidgetStageStartEventBottomSheetViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded widgetStageStartEventBottomSheetViewModel$ViewState$Loaded = (WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded) viewState;
        if (widgetStageStartEventBottomSheetViewModel$ViewState$Loaded != null) {
            updateViewState(WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded.copy$default(widgetStageStartEventBottomSheetViewModel$ViewState$Loaded, null, topic, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheetViewModel(long j, StoreChannels storeChannels, StoreStageInstances storeStageInstances, Observable<WidgetStageStartEventBottomSheetViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeStageInstances, "stageInstanceStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.channelsStore = storeChannels;
        this.stageInstanceStore = storeStageInstances;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStageStartEventBottomSheetViewModel$1(this), 62, (Object) null);
        this.eventSubject = PublishSubject.k0();
    }
}
