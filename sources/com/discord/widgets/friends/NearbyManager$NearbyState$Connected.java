package com.discord.widgets.friends;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: NearbyManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class NearbyManager$NearbyState$Connected extends NearbyManager$NearbyState {
    private final Set<Long> nearbyUserIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyManager$NearbyState$Connected(Set<Long> set) {
        super(null);
        m.checkNotNullParameter(set, "nearbyUserIds");
        this.nearbyUserIds = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NearbyManager$NearbyState$Connected copy$default(NearbyManager$NearbyState$Connected nearbyManager$NearbyState$Connected, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = nearbyManager$NearbyState$Connected.nearbyUserIds;
        }
        return nearbyManager$NearbyState$Connected.copy(set);
    }

    public final Set<Long> component1() {
        return this.nearbyUserIds;
    }

    public final NearbyManager$NearbyState$Connected copy(Set<Long> nearbyUserIds) {
        m.checkNotNullParameter(nearbyUserIds, "nearbyUserIds");
        return new NearbyManager$NearbyState$Connected(nearbyUserIds);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof NearbyManager$NearbyState$Connected) && m.areEqual(this.nearbyUserIds, ((NearbyManager$NearbyState$Connected) other).nearbyUserIds);
        }
        return true;
    }

    public final Set<Long> getNearbyUserIds() {
        return this.nearbyUserIds;
    }

    public int hashCode() {
        Set<Long> set = this.nearbyUserIds;
        if (set != null) {
            return set.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.N(a.U("Connected(nearbyUserIds="), this.nearbyUserIds, ")");
    }
}
