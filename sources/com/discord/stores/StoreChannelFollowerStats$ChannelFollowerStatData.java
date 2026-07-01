package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelChannelFollowerStats;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreChannelFollowerStats$ChannelFollowerStatData {
    private final ModelChannelFollowerStats data;
    private final StoreChannelFollowerStats$FetchState fetchState;

    public StoreChannelFollowerStats$ChannelFollowerStatData(StoreChannelFollowerStats$FetchState storeChannelFollowerStats$FetchState, ModelChannelFollowerStats modelChannelFollowerStats) {
        m.checkNotNullParameter(storeChannelFollowerStats$FetchState, "fetchState");
        m.checkNotNullParameter(modelChannelFollowerStats, "data");
        this.fetchState = storeChannelFollowerStats$FetchState;
        this.data = modelChannelFollowerStats;
    }

    public static /* synthetic */ StoreChannelFollowerStats$ChannelFollowerStatData copy$default(StoreChannelFollowerStats$ChannelFollowerStatData storeChannelFollowerStats$ChannelFollowerStatData, StoreChannelFollowerStats$FetchState storeChannelFollowerStats$FetchState, ModelChannelFollowerStats modelChannelFollowerStats, int i, Object obj) {
        if ((i & 1) != 0) {
            storeChannelFollowerStats$FetchState = storeChannelFollowerStats$ChannelFollowerStatData.fetchState;
        }
        if ((i & 2) != 0) {
            modelChannelFollowerStats = storeChannelFollowerStats$ChannelFollowerStatData.data;
        }
        return storeChannelFollowerStats$ChannelFollowerStatData.copy(storeChannelFollowerStats$FetchState, modelChannelFollowerStats);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreChannelFollowerStats$FetchState getFetchState() {
        return this.fetchState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelChannelFollowerStats getData() {
        return this.data;
    }

    public final StoreChannelFollowerStats$ChannelFollowerStatData copy(StoreChannelFollowerStats$FetchState fetchState, ModelChannelFollowerStats data) {
        m.checkNotNullParameter(fetchState, "fetchState");
        m.checkNotNullParameter(data, "data");
        return new StoreChannelFollowerStats$ChannelFollowerStatData(fetchState, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreChannelFollowerStats$ChannelFollowerStatData)) {
            return false;
        }
        StoreChannelFollowerStats$ChannelFollowerStatData storeChannelFollowerStats$ChannelFollowerStatData = (StoreChannelFollowerStats$ChannelFollowerStatData) other;
        return m.areEqual(this.fetchState, storeChannelFollowerStats$ChannelFollowerStatData.fetchState) && m.areEqual(this.data, storeChannelFollowerStats$ChannelFollowerStatData.data);
    }

    public final ModelChannelFollowerStats getData() {
        return this.data;
    }

    public final StoreChannelFollowerStats$FetchState getFetchState() {
        return this.fetchState;
    }

    public int hashCode() {
        StoreChannelFollowerStats$FetchState storeChannelFollowerStats$FetchState = this.fetchState;
        int iHashCode = (storeChannelFollowerStats$FetchState != null ? storeChannelFollowerStats$FetchState.hashCode() : 0) * 31;
        ModelChannelFollowerStats modelChannelFollowerStats = this.data;
        return iHashCode + (modelChannelFollowerStats != null ? modelChannelFollowerStats.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelFollowerStatData(fetchState=");
        sbU.append(this.fetchState);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ StoreChannelFollowerStats$ChannelFollowerStatData(StoreChannelFollowerStats$FetchState storeChannelFollowerStats$FetchState, ModelChannelFollowerStats modelChannelFollowerStats, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeChannelFollowerStats$FetchState, (i & 2) != 0 ? new ModelChannelFollowerStats(0L, null, null, null, null, null, null, Opcodes.LAND, null) : modelChannelFollowerStats);
    }
}
