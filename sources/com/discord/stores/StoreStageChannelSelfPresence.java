package com.discord.stores;

import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityType;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannelSelfPresence extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final BehaviorSubject<Unit> publishStateTrigger;
    private Activity stageChannelActivity;
    private final StoreStageChannels stageChannels;
    private final StoreUserPresence userPresence;
    private final StoreUserSettings userSettings;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelected;

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Integer> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            Map<Long, StageRoles> channelRolesInternal = StoreStageChannelSelfPresence.this.getStageChannels().getChannelRolesInternal(StoreStageChannelSelfPresence.this.getVoiceChannelSelected().getSelectedVoiceChannelId());
            return ((channelRolesInternal != null ? channelRolesInternal.size() : 0) / 100) + 1;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Boolean $showCurrentActivity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(0);
                this.$showCurrentActivity = bool;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserPresence userPresence = StoreStageChannelSelfPresence.this.getUserPresence();
                ActivityType activityType = ActivityType.LISTENING;
                Activity stageChannelActivity = StoreStageChannelSelfPresence.this.getStageChannelActivity();
                Boolean bool = this.$showCurrentActivity;
                Intrinsics3.checkNotNullExpressionValue(bool, "showCurrentActivity");
                if (!bool.booleanValue()) {
                    stageChannelActivity = null;
                }
                userPresence.updateActivity(activityType, stageChannelActivity, true);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            StoreStageChannelSelfPresence.this.getDispatcher().schedule(new AnonymousClass1(bool));
        }
    }

    public StoreStageChannelSelfPresence(ObservationDeck observationDeck, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreStageChannels storeStageChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserSettings storeUserSettings, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "userPresence");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "stageChannels");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelected");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettings");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.userStore = storeUser;
        this.userPresence = storeUserPresence;
        this.stageChannels = storeStageChannels;
        this.voiceChannelSelected = storeVoiceChannelSelected;
        this.userSettings = storeUserSettings;
        this.dispatcher = dispatcher;
        BehaviorSubject<Unit> behaviorSubjectK0 = BehaviorSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.publishStateTrigger = behaviorSubjectK0;
    }

    @Store3
    private final void updateActivity() {
        ActivityParty party;
        ActivityParty party2;
        Activity activityCreateStageChannelListeningActivity = ActivityUtils.createStageChannelListeningActivity();
        String id2 = (activityCreateStageChannelListeningActivity == null || (party2 = activityCreateStageChannelListeningActivity.getParty()) == null) ? null : party2.getId();
        Activity activity = this.stageChannelActivity;
        if (!(!Intrinsics3.areEqual(id2, (activity == null || (party = activity.getParty()) == null) ? null : party.getId()))) {
            String name = activityCreateStageChannelListeningActivity != null ? activityCreateStageChannelListeningActivity.getName() : null;
            Activity activity2 = this.stageChannelActivity;
            if (!(!Intrinsics3.areEqual(name, activity2 != null ? activity2.getName() : null))) {
                return;
            }
        }
        this.stageChannelActivity = activityCreateStageChannelListeningActivity;
        this.publishStateTrigger.onNext(Unit.a);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final BehaviorSubject<Unit> getPublishStateTrigger() {
        return this.publishStateTrigger;
    }

    public final Activity getStageChannelActivity() {
        return this.stageChannelActivity;
    }

    public final StoreStageChannels getStageChannels() {
        return this.stageChannels;
    }

    public final StoreUserPresence getUserPresence() {
        return this.userPresence;
    }

    public final StoreUserSettings getUserSettings() {
        return this.userSettings;
    }

    public final StoreUser getUserStore() {
        return this.userStore;
    }

    public final StoreVoiceChannelSelected getVoiceChannelSelected() {
        return this.voiceChannelSelected;
    }

    @Store3
    public final void handleStageInstanceCreate() {
        updateActivity();
    }

    @Store3
    public final void handleStageInstanceDelete() {
        updateActivity();
    }

    @Store3
    public final void handleStageInstanceUpdate() {
        updateActivity();
    }

    @Store3
    public final void handleVoiceChannelSelected() {
        updateActivity();
    }

    @Store3
    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        if (voiceState.getUserId() == this.userStore.getMeSnapshot().getId()) {
            updateActivity();
        }
    }

    public final void init() {
        Observable observableY = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stageChannels, this.voiceChannelSelected}, false, null, null, new AnonymousClass1(), 14, null).r().Y(new Func1<Integer, Observable<? extends Boolean>>() { // from class: com.discord.stores.StoreStageChannelSelfPresence.init.2
            @Override // j0.k.Func1
            public final Observable<? extends Boolean> call(Integer num) {
                return Observable.j(ObservableExtensionsKt.leadingEdgeThrottle(StoreStageChannelSelfPresence.this.getPublishStateTrigger(), num.intValue(), TimeUnit.SECONDS), StoreStageChannelSelfPresence.this.getUserSettings().observeIsShowCurrentGameEnabled(), new Func2<Unit, Boolean, Boolean>() { // from class: com.discord.stores.StoreStageChannelSelfPresence.init.2.1
                    @Override // rx.functions.Func2
                    public final Boolean call(Unit unit, Boolean bool) {
                        return bool;
                    }
                });
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "observationDeck.connectR…bled -> isEnabled }\n    }");
        ObservableExtensionsKt.appSubscribe(observableY, (Class<?>) StoreStageChannelSelfPresence.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }

    public final void setStageChannelActivity(Activity activity) {
        this.stageChannelActivity = activity;
    }
}
