package com.discord.stores;

import b.d.b.a.a;
import d0.t.h0;
import d0.t.n0;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreMessageState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMessageState$State {
    private final Map<Integer, Set<String>> visibleSpoilerEmbedMap;
    private final Set<Integer> visibleSpoilerNodeIndices;

    public StoreMessageState$State() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreMessageState$State(Set<Integer> set, Map<Integer, ? extends Set<String>> map) {
        m.checkNotNullParameter(set, "visibleSpoilerNodeIndices");
        m.checkNotNullParameter(map, "visibleSpoilerEmbedMap");
        this.visibleSpoilerNodeIndices = set;
        this.visibleSpoilerEmbedMap = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreMessageState$State copy$default(StoreMessageState$State storeMessageState$State, Set set, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            set = storeMessageState$State.visibleSpoilerNodeIndices;
        }
        if ((i & 2) != 0) {
            map = storeMessageState$State.visibleSpoilerEmbedMap;
        }
        return storeMessageState$State.copy(set, map);
    }

    public final Set<Integer> component1() {
        return this.visibleSpoilerNodeIndices;
    }

    public final Map<Integer, Set<String>> component2() {
        return this.visibleSpoilerEmbedMap;
    }

    public final StoreMessageState$State copy(Set<Integer> visibleSpoilerNodeIndices, Map<Integer, ? extends Set<String>> visibleSpoilerEmbedMap) {
        m.checkNotNullParameter(visibleSpoilerNodeIndices, "visibleSpoilerNodeIndices");
        m.checkNotNullParameter(visibleSpoilerEmbedMap, "visibleSpoilerEmbedMap");
        return new StoreMessageState$State(visibleSpoilerNodeIndices, visibleSpoilerEmbedMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreMessageState$State)) {
            return false;
        }
        StoreMessageState$State storeMessageState$State = (StoreMessageState$State) other;
        return m.areEqual(this.visibleSpoilerNodeIndices, storeMessageState$State.visibleSpoilerNodeIndices) && m.areEqual(this.visibleSpoilerEmbedMap, storeMessageState$State.visibleSpoilerEmbedMap);
    }

    public final Map<Integer, Set<String>> getVisibleSpoilerEmbedMap() {
        return this.visibleSpoilerEmbedMap;
    }

    public final Set<Integer> getVisibleSpoilerNodeIndices() {
        return this.visibleSpoilerNodeIndices;
    }

    public int hashCode() {
        Set<Integer> set = this.visibleSpoilerNodeIndices;
        int iHashCode = (set != null ? set.hashCode() : 0) * 31;
        Map<Integer, Set<String>> map = this.visibleSpoilerEmbedMap;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("State(visibleSpoilerNodeIndices=");
        sbU.append(this.visibleSpoilerNodeIndices);
        sbU.append(", visibleSpoilerEmbedMap=");
        return a.M(sbU, this.visibleSpoilerEmbedMap, ")");
    }

    public /* synthetic */ StoreMessageState$State(Set set, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? n0.emptySet() : set, (i & 2) != 0 ? h0.emptyMap() : map);
    }
}
