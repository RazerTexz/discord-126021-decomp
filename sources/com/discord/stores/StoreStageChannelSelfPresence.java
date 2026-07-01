package com.discord.stores;

import android.content.Context;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
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

    public StoreStageChannelSelfPresence(ObservationDeck observationDeck, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreStageChannels storeStageChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserSettings storeUserSettings, Dispatcher dispatcher) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeUserPresence, "userPresence");
        m.checkNotNullParameter(storeStageChannels, "stageChannels");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelected");
        m.checkNotNullParameter(storeUserSettings, "userSettings");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.userStore = storeUser;
        this.userPresence = storeUserPresence;
        this.stageChannels = storeStageChannels;
        this.voiceChannelSelected = storeVoiceChannelSelected;
        this.userSettings = storeUserSettings;
        this.dispatcher = dispatcher;
        BehaviorSubject<Unit> behaviorSubjectK0 = BehaviorSubject.k0();
        m.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.publishStateTrigger = behaviorSubjectK0;
    }

    @StoreThread
    private final void updateActivity() {
        ActivityParty party;
        ActivityParty party2;
        Activity activityCreateStageChannelListeningActivity = ActivityUtilsKt.createStageChannelListeningActivity();
        String id2 = (activityCreateStageChannelListeningActivity == null || (party2 = activityCreateStageChannelListeningActivity.getParty()) == null) ? null : party2.getId();
        Activity activity = this.stageChannelActivity;
        if (!(!m.areEqual(id2, (activity == null || (party = activity.getParty()) == null) ? null : party.getId()))) {
            String name = activityCreateStageChannelListeningActivity != null ? activityCreateStageChannelListeningActivity.getName() : null;
            Activity activity2 = this.stageChannelActivity;
            if (!(!m.areEqual(name, activity2 != null ? activity2.getName() : null))) {
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
        m.checkNotNullParameter(voiceState, "voiceState");
        if (voiceState.getUserId() == this.userStore.getMeSnapshot().getId()) {
            updateActivity();
        }
    }

    public final void init() {
        Observable observableY = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.stageChannels, this.voiceChannelSelected}, false, null, null, new StoreStageChannelSelfPresence$init$1(this), 14, null).r().Y(new StoreStageChannelSelfPresence$init$2(this));
        m.checkNotNullExpressionValue(observableY, "observationDeck.connectR…bled -> isEnabled }\n    }");
        ObservableExtensionsKt.appSubscribe$default(observableY, StoreStageChannelSelfPresence.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreStageChannelSelfPresence$init$3(this), 62, (Object) null);
    }

    public final void setStageChannelActivity(Activity activity) {
        this.stageChannelActivity = activity;
    }
}
