package com.discord.stores;

import b.d.b.a.a;
import d0.t.n0;
import d0.z.d.m;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreStageChannels$StageEventActivationState {
    private final Set<Long> moderators;

    public StoreStageChannels$StageEventActivationState() {
        this(null, 1, null);
    }

    public StoreStageChannels$StageEventActivationState(Set<Long> set) {
        m.checkNotNullParameter(set, "moderators");
        this.moderators = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreStageChannels$StageEventActivationState copy$default(StoreStageChannels$StageEventActivationState storeStageChannels$StageEventActivationState, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = storeStageChannels$StageEventActivationState.moderators;
        }
        return storeStageChannels$StageEventActivationState.copy(set);
    }

    public final Set<Long> component1() {
        return this.moderators;
    }

    public final StoreStageChannels$StageEventActivationState copy(Set<Long> moderators) {
        m.checkNotNullParameter(moderators, "moderators");
        return new StoreStageChannels$StageEventActivationState(moderators);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreStageChannels$StageEventActivationState) && m.areEqual(this.moderators, ((StoreStageChannels$StageEventActivationState) other).moderators);
        }
        return true;
    }

    public final Set<Long> getModerators() {
        return this.moderators;
    }

    public int hashCode() {
        Set<Long> set = this.moderators;
        if (set != null) {
            return set.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.N(a.U("StageEventActivationState(moderators="), this.moderators, ")");
    }

    public /* synthetic */ StoreStageChannels$StageEventActivationState(Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? n0.emptySet() : set);
    }
}
