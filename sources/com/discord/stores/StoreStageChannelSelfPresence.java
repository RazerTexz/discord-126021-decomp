package com.discord.stores;

import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityType;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.widgets.stage.StageRoles;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$1 */
    /* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
    public static final class C64081 extends AbstractC12240o implements Function0<Integer> {
        public C64081() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$3 */
    /* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
    public static final class C64103 extends AbstractC12240o implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Boolean $showCurrentActivity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(0);
                this.$showCurrentActivity = bool;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserPresence userPresence = StoreStageChannelSelfPresence.this.getUserPresence();
                ActivityType activityType = ActivityType.LISTENING;
                Activity stageChannelActivity = StoreStageChannelSelfPresence.this.getStageChannelActivity();
                Boolean bool = this.$showCurrentActivity;
                C12238m.checkNotNullExpressionValue(bool, "showCurrentActivity");
                if (!bool.booleanValue()) {
                    stageChannelActivity = null;
                }
                userPresence.updateActivity(activityType, stageChannelActivity, true);
            }
        }

        public C64103() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            StoreStageChannelSelfPresence.this.getDispatcher().schedule(new AnonymousClass1(bool));
        }
    }

    public StoreStageChannelSelfPresence(ObservationDeck observationDeck, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreStageChannels storeStageChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserSettings storeUserSettings, Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(storeUser, "userStore");
        C12238m.checkNotNullParameter(storeUserPresence, "userPresence");
        C12238m.checkNotNullParameter(storeStageChannels, "stageChannels");
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelected");
        C12238m.checkNotNullParameter(storeUserSettings, "userSettings");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.userStore = storeUser;
        this.userPresence = storeUserPresence;
        this.stageChannels = storeStageChannels;
        this.voiceChannelSelected = storeVoiceChannelSelected;
        this.userSettings = storeUserSettings;
        this.dispatcher = dispatcher;
        BehaviorSubject<Unit> behaviorSubjectM11129k0 = BehaviorSubject.m11129k0();
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11129k0, "BehaviorSubject.create()");
        this.publishStateTrigger = behaviorSubjectM11129k0;
    }

    @StoreThread
    private final void updateActivity() {
        ActivityParty party;
        ActivityParty party2;
        Activity activityCreateStageChannelListeningActivity = ActivityUtilsKt.createStageChannelListeningActivity();
        String id2 = (activityCreateStageChannelListeningActivity == null || (party2 = activityCreateStageChannelListeningActivity.getParty()) == null) ? null : party2.getId();
        Activity activity = this.stageChannelActivity;
        if (!(!C12238m.areEqual(id2, (activity == null || (party = activity.getParty()) == null) ? null : party.getId()))) {
            String name = activityCreateStageChannelListeningActivity != null ? activityCreateStageChannelListeningActivity.getName() : null;
            Activity activity2 = this.stageChannelActivity;
            if (!(!C12238m.areEqual(name, activity2 != null ? activity2.getName() : null))) {
                return;
            }
        }
        this.stageChannelActivity = activityCreateStageChannelListeningActivity;
        this.publishStateTrigger.onNext(Unit.f27425a);
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

    @StoreThread
    public final void handleStageInstanceCreate() {
        updateActivity();
    }

    @StoreThread
    public final void handleStageInstanceDelete() {
        updateActivity();
    }

    @StoreThread
    public final void handleStageInstanceUpdate() {
        updateActivity();
    }

    @StoreThread
    public final void handleVoiceChannelSelected() {
        updateActivity();
    }

    @StoreThread
    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        C12238m.checkNotNullParameter(voiceState, "voiceState");
        if (voiceState.getUserId() == this.userStore.getMeSnapshot().getId()) {
            updateActivity();
        }
    }

    public final void init() {
        Observable observableM11099Y = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stageChannels, this.voiceChannelSelected}, false, null, null, new C64081(), 14, null).m11112r().m11099Y(new InterfaceC12589b<Integer, Observable<? extends Boolean>>() { // from class: com.discord.stores.StoreStageChannelSelfPresence.init.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Boolean> call(Integer num) {
                return Observable.m11076j(ObservableExtensionsKt.leadingEdgeThrottle(StoreStageChannelSelfPresence.this.getPublishStateTrigger(), num.intValue(), TimeUnit.SECONDS), StoreStageChannelSelfPresence.this.getUserSettings().observeIsShowCurrentGameEnabled(), new Func2<Unit, Boolean, Boolean>() { // from class: com.discord.stores.StoreStageChannelSelfPresence.init.2.1
                    @Override // p658rx.functions.Func2
                    public final Boolean call(Unit unit, Boolean bool) {
                        return bool;
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "observationDeck.connectR…bled -> isEnabled }\n    }");
        ObservableExtensionsKt.appSubscribe(observableM11099Y, (Class<?>) StoreStageChannelSelfPresence.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C64103());
    }

    public final void setStageChannelActivity(Activity activity) {
        this.stageChannelActivity = activity;
    }
}
