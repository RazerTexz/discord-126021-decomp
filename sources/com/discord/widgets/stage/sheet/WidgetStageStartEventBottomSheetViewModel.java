package com.discord.widgets.stage.sheet;

import androidx.annotation.MainThread;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<Event> eventSubject;
    private final StoreStageInstances stageInstanceStore;
    private StoreState storeState;

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$1 */
    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static final class C100591 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C100591() {
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
            WidgetStageStartEventBottomSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreChannels channelsStore, StoreStageInstances stageInstanceStore) {
            Observable<R> observableM11083G = channelsStore.observeChannel(channelId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableM11076j = Observable.m11076j(observableM11083G, stageInstanceStore.observeStageInstanceForChannel(channelId).m11119z(), new Func2<Channel, StageInstance, StoreState>() { // from class: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$Companion$observeStoreState$1
                @Override // p658rx.functions.Func2
                public final WidgetStageStartEventBottomSheetViewModel.StoreState call(Channel channel, StageInstance stageInstance) {
                    C12238m.checkNotNullExpressionValue(channel, "channel");
                    return new WidgetStageStartEventBottomSheetViewModel.StoreState(channel, stageInstance);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest… stageInstance)\n        }");
            return observableM11076j;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        public static final /* data */ class InvalidTopic extends Event {
            private final int failureMessageStringRes;

            public InvalidTopic(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ InvalidTopic copy$default(InvalidTopic invalidTopic, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = invalidTopic.failureMessageStringRes;
                }
                return invalidTopic.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final InvalidTopic copy(int failureMessageStringRes) {
                return new InvalidTopic(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof InvalidTopic) && this.failureMessageStringRes == ((InvalidTopic) other).failureMessageStringRes;
                }
                return true;
            }

            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public int hashCode() {
                return this.failureMessageStringRes;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("InvalidTopic(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        public static final /* data */ class SetTopicFailure extends Event {
            private final int failureMessageStringRes;

            public SetTopicFailure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ SetTopicFailure copy$default(SetTopicFailure setTopicFailure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = setTopicFailure.failureMessageStringRes;
                }
                return setTopicFailure.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final SetTopicFailure copy(int failureMessageStringRes) {
                return new SetTopicFailure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetTopicFailure) && this.failureMessageStringRes == ((SetTopicFailure) other).failureMessageStringRes;
                }
                return true;
            }

            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public int hashCode() {
                return this.failureMessageStringRes;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("SetTopicFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        public static final /* data */ class SetTopicSuccess extends Event {
            private final Channel channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetTopicSuccess(Channel channel) {
                super(null);
                C12238m.checkNotNullParameter(channel, "channel");
                this.channel = channel;
            }

            public static /* synthetic */ SetTopicSuccess copy$default(SetTopicSuccess setTopicSuccess, Channel channel, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = setTopicSuccess.channel;
                }
                return setTopicSuccess.copy(channel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final SetTopicSuccess copy(Channel channel) {
                C12238m.checkNotNullParameter(channel, "channel");
                return new SetTopicSuccess(channel);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetTopicSuccess) && C12238m.areEqual(this.channel, ((SetTopicSuccess) other).channel);
                }
                return true;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public int hashCode() {
                Channel channel = this.channel;
                if (channel != null) {
                    return channel.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("SetTopicSuccess(channel=");
                sbM833U.append(this.channel);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final StageInstance stageInstance;

        public StoreState(Channel channel, StageInstance stageInstance) {
            C12238m.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.stageInstance = stageInstance;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Channel channel, StageInstance stageInstance, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = storeState.channel;
            }
            if ((i & 2) != 0) {
                stageInstance = storeState.stageInstance;
            }
            return storeState.copy(channel, stageInstance);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final StoreState copy(Channel channel, StageInstance stageInstance) {
            C12238m.checkNotNullParameter(channel, "channel");
            return new StoreState(channel, stageInstance);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.channel, storeState.channel) && C12238m.areEqual(this.stageInstance, storeState.stageInstance);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            StageInstance stageInstance = this.stageInstance;
            return iHashCode + (stageInstance != null ? stageInstance.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", stageInstance=");
            sbM833U.append(this.stageInstance);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Channel channel;
            private final StageInstance stageInstance;
            private final String topic;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Channel channel, String str, StageInstance stageInstance) {
                super(null);
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
                this.channel = channel;
                this.topic = str;
                this.stageInstance = stageInstance;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, String str, StageInstance stageInstance, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = loaded.channel;
                }
                if ((i & 2) != 0) {
                    str = loaded.topic;
                }
                if ((i & 4) != 0) {
                    stageInstance = loaded.stageInstance;
                }
                return loaded.copy(channel, str, stageInstance);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getTopic() {
                return this.topic;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final Loaded copy(Channel channel, String topic, StageInstance stageInstance) {
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
                return new Loaded(channel, topic, stageInstance);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.channel, loaded.channel) && C12238m.areEqual(this.topic, loaded.topic) && C12238m.areEqual(this.stageInstance, loaded.stageInstance);
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final String getTopic() {
                return this.topic;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                String str = this.topic;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                StageInstance stageInstance = this.stageInstance;
                return iHashCode2 + (stageInstance != null ? stageInstance.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", topic=");
                sbM833U.append(this.topic);
                sbM833U.append(", stageInstance=");
                sbM833U.append(this.stageInstance);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$1 */
    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static final class C100611 extends AbstractC12240o implements Function1<Error, Unit> {
        public C100611() {
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
            WidgetStageStartEventBottomSheetViewModel.this.emitSetStatusFailureEvent();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$2 */
    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static final class C100622 extends AbstractC12240o implements Function1<StageInstance, Unit> {
        public final /* synthetic */ boolean $microphonePermissionGranted;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100622(boolean z2, ViewState.Loaded loaded) {
            super(1);
            this.$microphonePermissionGranted = z2;
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            C12238m.checkNotNullParameter(stageInstance, "it");
            if (this.$microphonePermissionGranted) {
                WidgetStageStartEventBottomSheetViewModel.this.setSelfSpeaker();
            }
            WidgetStageStartEventBottomSheetViewModel.this.emitSetStatusSuccessEvent(this.$viewState.getChannel());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$3 */
    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static final class C100633 extends AbstractC12240o implements Function1<Error, Unit> {
        public C100633() {
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
            WidgetStageStartEventBottomSheetViewModel.this.emitSetStatusFailureEvent();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$4 */
    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static final class C100644 extends AbstractC12240o implements Function1<StageInstance, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100644(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            C12238m.checkNotNullParameter(stageInstance, "it");
            WidgetStageStartEventBottomSheetViewModel.this.emitSetStatusSuccessEvent(this.$viewState.getChannel());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$setSelfSpeaker$1 */
    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static final class C100651 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C100651 INSTANCE = new C100651();

        public C100651() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$setSelfSpeaker$2 */
    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    public static final class C100662 extends AbstractC12240o implements Function1<Error, Unit> {
        public static final C100662 INSTANCE = new C100662();

        public C100662() {
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
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetStageStartEventBottomSheetViewModel(long j, StoreChannels storeChannels, StoreStageInstances storeStageInstances, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreStageInstances stageInstances = (i & 4) != 0 ? StoreStream.INSTANCE.getStageInstances() : storeStageInstances;
        this(j, channels, stageInstances, (i & 8) != 0 ? INSTANCE.observeStoreState(j, channels, stageInstances) : observable);
    }

    private final void emitSetStatusFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.SetTopicFailure(C5419R.string.default_failure_to_perform_action_message));
    }

    private final void emitSetStatusSuccessEvent(Channel channel) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.SetTopicSuccess(channel));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        String topic;
        this.storeState = storeState;
        Channel channel = storeState.getChannel();
        StageInstance stageInstance = storeState.getStageInstance();
        if (stageInstance == null || (topic = stageInstance.getTopic()) == null) {
            topic = "";
        }
        updateViewState(new ViewState.Loaded(channel, topic, storeState.getStageInstance()));
    }

    private final void setSelfSpeaker() {
        Channel channel;
        StoreState storeState = this.storeState;
        if (storeState == null || (channel = storeState.getChannel()) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().setMeSuppressed(channel, false), false, 1, null), (Class<?>) WidgetStageStartEventBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : C100662.INSTANCE), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C100651.INSTANCE);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void openStage(boolean microphonePermissionGranted) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            String topic = loaded.getTopic();
            Objects.requireNonNull(topic, "null cannot be cast to non-null type kotlin.CharSequence");
            String string = C12106w.trim(topic).toString();
            String str = string.length() > 0 ? string : null;
            if (str == null) {
                this.eventSubject.f27650k.onNext(new Event.InvalidTopic(C5419R.string.start_stage_channel_event_modal_topic_required));
            } else if (loaded.getStageInstance() == null) {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.startStageInstance$default(StageChannelAPI.INSTANCE, this.channelId, str, StageInstancePrivacyLevel.GUILD_ONLY, false, null, 16, null), false, 1, null), this, null, 2, null), (Class<?>) WidgetStageStartEventBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C100611()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C100622(microphonePermissionGranted, loaded));
            } else {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.updateStageInstance$default(StageChannelAPI.INSTANCE, this.channelId, str, null, 4, null), false, 1, null), this, null, 2, null), (Class<?>) WidgetStageStartEventBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C100633()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C100644(loaded));
            }
        }
    }

    public final void setTopic(String topic) {
        C12238m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, topic, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheetViewModel(long j, StoreChannels storeChannels, StoreStageInstances storeStageInstances, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeChannels, "channelsStore");
        C12238m.checkNotNullParameter(storeStageInstances, "stageInstanceStore");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.channelsStore = storeChannels;
        this.stageInstanceStore = storeStageInstances;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetStageStartEventBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C100591());
        this.eventSubject = PublishSubject.m11133k0();
    }
}
