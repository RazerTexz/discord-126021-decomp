package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.stageinstance.RecommendedStageInstance;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreRequestedStageChannels$StageInstanceState {
    private final RecommendedStageInstance stageInstance;
    private final StoreRequestedStageChannels$FetchStatus status;

    public StoreRequestedStageChannels$StageInstanceState(RecommendedStageInstance recommendedStageInstance, StoreRequestedStageChannels$FetchStatus storeRequestedStageChannels$FetchStatus) {
        m.checkNotNullParameter(storeRequestedStageChannels$FetchStatus, "status");
        this.stageInstance = recommendedStageInstance;
        this.status = storeRequestedStageChannels$FetchStatus;
    }

    public static /* synthetic */ StoreRequestedStageChannels$StageInstanceState copy$default(StoreRequestedStageChannels$StageInstanceState storeRequestedStageChannels$StageInstanceState, RecommendedStageInstance recommendedStageInstance, StoreRequestedStageChannels$FetchStatus storeRequestedStageChannels$FetchStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            recommendedStageInstance = storeRequestedStageChannels$StageInstanceState.stageInstance;
        }
        if ((i & 2) != 0) {
            storeRequestedStageChannels$FetchStatus = storeRequestedStageChannels$StageInstanceState.status;
        }
        return storeRequestedStageChannels$StageInstanceState.copy(recommendedStageInstance, storeRequestedStageChannels$FetchStatus);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RecommendedStageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreRequestedStageChannels$FetchStatus getStatus() {
        return this.status;
    }

    public final StoreRequestedStageChannels$StageInstanceState copy(RecommendedStageInstance stageInstance, StoreRequestedStageChannels$FetchStatus status) {
        m.checkNotNullParameter(status, "status");
        return new StoreRequestedStageChannels$StageInstanceState(stageInstance, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreRequestedStageChannels$StageInstanceState)) {
            return false;
        }
        StoreRequestedStageChannels$StageInstanceState storeRequestedStageChannels$StageInstanceState = (StoreRequestedStageChannels$StageInstanceState) other;
        return m.areEqual(this.stageInstance, storeRequestedStageChannels$StageInstanceState.stageInstance) && m.areEqual(this.status, storeRequestedStageChannels$StageInstanceState.status);
    }

    public final RecommendedStageInstance getStageInstance() {
        return this.stageInstance;
    }

    public final StoreRequestedStageChannels$FetchStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        RecommendedStageInstance recommendedStageInstance = this.stageInstance;
        int iHashCode = (recommendedStageInstance != null ? recommendedStageInstance.hashCode() : 0) * 31;
        StoreRequestedStageChannels$FetchStatus storeRequestedStageChannels$FetchStatus = this.status;
        return iHashCode + (storeRequestedStageChannels$FetchStatus != null ? storeRequestedStageChannels$FetchStatus.hashCode() : 0);
    }

    public final boolean isError() {
        return this.status == StoreRequestedStageChannels$FetchStatus.ERROR;
    }

    public final boolean isLoaded() {
        return this.status == StoreRequestedStageChannels$FetchStatus.LOADED;
    }

    public final boolean isLoading() {
        return this.status == StoreRequestedStageChannels$FetchStatus.LOADING;
    }

    public String toString() {
        StringBuilder sbU = a.U("StageInstanceState(stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", status=");
        sbU.append(this.status);
        sbU.append(")");
        return sbU.toString();
    }
}
