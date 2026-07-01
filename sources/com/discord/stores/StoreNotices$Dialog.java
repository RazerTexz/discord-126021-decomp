package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreNotices$Dialog {
    private final Map<String, Object> metadata;
    private final StoreNotices$Dialog$Type type;

    public StoreNotices$Dialog(StoreNotices$Dialog$Type storeNotices$Dialog$Type, Map<String, ? extends Object> map) {
        m.checkNotNullParameter(storeNotices$Dialog$Type, "type");
        this.type = storeNotices$Dialog$Type;
        this.metadata = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreNotices$Dialog copy$default(StoreNotices$Dialog storeNotices$Dialog, StoreNotices$Dialog$Type storeNotices$Dialog$Type, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            storeNotices$Dialog$Type = storeNotices$Dialog.type;
        }
        if ((i & 2) != 0) {
            map = storeNotices$Dialog.metadata;
        }
        return storeNotices$Dialog.copy(storeNotices$Dialog$Type, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreNotices$Dialog$Type getType() {
        return this.type;
    }

    public final Map<String, Object> component2() {
        return this.metadata;
    }

    public final StoreNotices$Dialog copy(StoreNotices$Dialog$Type type, Map<String, ? extends Object> metadata) {
        m.checkNotNullParameter(type, "type");
        return new StoreNotices$Dialog(type, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreNotices$Dialog)) {
            return false;
        }
        StoreNotices$Dialog storeNotices$Dialog = (StoreNotices$Dialog) other;
        return m.areEqual(this.type, storeNotices$Dialog.type) && m.areEqual(this.metadata, storeNotices$Dialog.metadata);
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final StoreNotices$Dialog$Type getType() {
        return this.type;
    }

    public int hashCode() {
        StoreNotices$Dialog$Type storeNotices$Dialog$Type = this.type;
        int iHashCode = (storeNotices$Dialog$Type != null ? storeNotices$Dialog$Type.hashCode() : 0) * 31;
        Map<String, Object> map = this.metadata;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Dialog(type=");
        sbU.append(this.type);
        sbU.append(", metadata=");
        return a.M(sbU, this.metadata, ")");
    }

    public /* synthetic */ StoreNotices$Dialog(StoreNotices$Dialog$Type storeNotices$Dialog$Type, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeNotices$Dialog$Type, (i & 2) != 0 ? null : map);
    }
}
