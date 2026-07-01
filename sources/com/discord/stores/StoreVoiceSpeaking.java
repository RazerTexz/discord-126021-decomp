package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: StoreVoiceSpeaking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceSpeaking extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final HashSet<Long> speakingUsers;
    private Set<Long> speakingUsersSnapshot;

    public StoreVoiceSpeaking(ObservationDeck observationDeck) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.speakingUsers = new HashSet<>();
        this.speakingUsersSnapshot = new HashSet();
    }

    public final Set<Long> getSpeakingUsers() {
        return this.speakingUsersSnapshot;
    }

    @StoreThread
    public final void handleSpeakingUpdates(List<StoreRtcConnection$SpeakingUserUpdate> speakingList) {
        m.checkNotNullParameter(speakingList, "speakingList");
        boolean z2 = false;
        for (StoreRtcConnection$SpeakingUserUpdate storeRtcConnection$SpeakingUserUpdate : speakingList) {
            long userId = storeRtcConnection$SpeakingUserUpdate.getUserId();
            boolean zAdd = storeRtcConnection$SpeakingUserUpdate.getIsSpeaking() ? this.speakingUsers.add(Long.valueOf(userId)) : this.speakingUsers.remove(Long.valueOf(userId));
            if (!z2 && zAdd) {
                z2 = true;
            }
        }
        if (z2) {
            markChanged();
        }
    }

    @StoreThread
    public final void handleVoiceChannelSelected(long voiceChannelId) {
        if (voiceChannelId > 0) {
            return;
        }
        this.speakingUsers.clear();
        markChanged();
    }

    public final Observable<Set<Long>> observeSpeakingUsers() {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreVoiceSpeaking$observeSpeakingUsers$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.speakingUsersSnapshot = new HashSet(this.speakingUsers);
    }
}
