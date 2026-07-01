package com.discord.stores;

import com.discord.stores.StoreRtcConnection;
import com.discord.stores.updates.ObservationDeck;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: StoreVoiceSpeaking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceSpeaking extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final HashSet<Long> speakingUsers;
    private Set<Long> speakingUsersSnapshot;

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceSpeaking$observeSpeakingUsers$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreVoiceSpeaking.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            return StoreVoiceSpeaking.this.getSpeakingUsers();
        }
    }

    public StoreVoiceSpeaking(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.speakingUsers = new HashSet<>();
        this.speakingUsersSnapshot = new HashSet();
    }

    public final Set<Long> getSpeakingUsers() {
        return this.speakingUsersSnapshot;
    }

    @Store3
    public final void handleSpeakingUpdates(List<StoreRtcConnection.SpeakingUserUpdate> speakingList) {
        Intrinsics3.checkNotNullParameter(speakingList, "speakingList");
        boolean z2 = false;
        for (StoreRtcConnection.SpeakingUserUpdate speakingUserUpdate : speakingList) {
            long userId = speakingUserUpdate.getUserId();
            boolean zAdd = speakingUserUpdate.getIsSpeaking() ? this.speakingUsers.add(Long.valueOf(userId)) : this.speakingUsers.remove(Long.valueOf(userId));
            if (!z2 && zAdd) {
                z2 = true;
            }
        }
        if (z2) {
            markChanged();
        }
    }

    @Store3
    public final void handleVoiceChannelSelected(long voiceChannelId) {
        if (voiceChannelId > 0) {
            return;
        }
        this.speakingUsers.clear();
        markChanged();
    }

    public final Observable<Set<Long>> observeSpeakingUsers() {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.speakingUsersSnapshot = new HashSet(this.speakingUsers);
    }
}
