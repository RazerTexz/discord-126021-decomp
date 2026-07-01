package com.discord.widgets.chat.list;

import b.d.b.a.a;
import com.discord.models.domain.ModelChannelFollowerStats;
import d0.z.d.m;

/* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PublishActionDialogViewModel$ViewState$LoadedHasFollowers extends PublishActionDialogViewModel$ViewState {
    private final ModelChannelFollowerStats followerStats;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishActionDialogViewModel$ViewState$LoadedHasFollowers(ModelChannelFollowerStats modelChannelFollowerStats) {
        super(null);
        m.checkNotNullParameter(modelChannelFollowerStats, "followerStats");
        this.followerStats = modelChannelFollowerStats;
    }

    public static /* synthetic */ PublishActionDialogViewModel$ViewState$LoadedHasFollowers copy$default(PublishActionDialogViewModel$ViewState$LoadedHasFollowers publishActionDialogViewModel$ViewState$LoadedHasFollowers, ModelChannelFollowerStats modelChannelFollowerStats, int i, Object obj) {
        if ((i & 1) != 0) {
            modelChannelFollowerStats = publishActionDialogViewModel$ViewState$LoadedHasFollowers.followerStats;
        }
        return publishActionDialogViewModel$ViewState$LoadedHasFollowers.copy(modelChannelFollowerStats);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelChannelFollowerStats getFollowerStats() {
        return this.followerStats;
    }

    public final PublishActionDialogViewModel$ViewState$LoadedHasFollowers copy(ModelChannelFollowerStats followerStats) {
        m.checkNotNullParameter(followerStats, "followerStats");
        return new PublishActionDialogViewModel$ViewState$LoadedHasFollowers(followerStats);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PublishActionDialogViewModel$ViewState$LoadedHasFollowers) && m.areEqual(this.followerStats, ((PublishActionDialogViewModel$ViewState$LoadedHasFollowers) other).followerStats);
        }
        return true;
    }

    public final ModelChannelFollowerStats getFollowerStats() {
        return this.followerStats;
    }

    public int hashCode() {
        ModelChannelFollowerStats modelChannelFollowerStats = this.followerStats;
        if (modelChannelFollowerStats != null) {
            return modelChannelFollowerStats.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("LoadedHasFollowers(followerStats=");
        sbU.append(this.followerStats);
        sbU.append(")");
        return sbU.toString();
    }
}
