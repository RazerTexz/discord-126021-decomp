package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: StoreUserRelationships.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreUserRelationships$UserRelationshipsState$Loaded extends StoreUserRelationships$UserRelationshipsState {
    private final Map<Long, Integer> relationships;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserRelationships$UserRelationshipsState$Loaded(Map<Long, Integer> map) {
        super(null);
        m.checkNotNullParameter(map, "relationships");
        this.relationships = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreUserRelationships$UserRelationshipsState$Loaded copy$default(StoreUserRelationships$UserRelationshipsState$Loaded storeUserRelationships$UserRelationshipsState$Loaded, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = storeUserRelationships$UserRelationshipsState$Loaded.relationships;
        }
        return storeUserRelationships$UserRelationshipsState$Loaded.copy(map);
    }

    public final Map<Long, Integer> component1() {
        return this.relationships;
    }

    public final StoreUserRelationships$UserRelationshipsState$Loaded copy(Map<Long, Integer> relationships) {
        m.checkNotNullParameter(relationships, "relationships");
        return new StoreUserRelationships$UserRelationshipsState$Loaded(relationships);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreUserRelationships$UserRelationshipsState$Loaded) && m.areEqual(this.relationships, ((StoreUserRelationships$UserRelationshipsState$Loaded) other).relationships);
        }
        return true;
    }

    public final Map<Long, Integer> getRelationships() {
        return this.relationships;
    }

    public int hashCode() {
        Map<Long, Integer> map = this.relationships;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.M(a.U("Loaded(relationships="), this.relationships, ")");
    }
}
