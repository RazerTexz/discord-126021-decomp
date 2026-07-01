package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.guildhash.GuildHash;
import com.discord.api.guildhash.GuildHashes;
import com.discord.gateway.io.OutgoingPayload$IdentifyClientState;
import d0.t.g0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreClientDataState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreClientDataState$ClientDataState {
    private final Map<Long, GuildHashes> guildHashes;
    private final long highestLastMessageId;
    private final int readStateVersion;
    private final int userGuildSettingsVersion;

    public StoreClientDataState$ClientDataState() {
        this(null, 0L, 0, 0, 15, null);
    }

    public StoreClientDataState$ClientDataState(Map<Long, GuildHashes> map, long j, int i, int i2) {
        m.checkNotNullParameter(map, "guildHashes");
        this.guildHashes = map;
        this.highestLastMessageId = j;
        this.readStateVersion = i;
        this.userGuildSettingsVersion = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreClientDataState$ClientDataState copy$default(StoreClientDataState$ClientDataState storeClientDataState$ClientDataState, Map map, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = storeClientDataState$ClientDataState.guildHashes;
        }
        if ((i3 & 2) != 0) {
            j = storeClientDataState$ClientDataState.highestLastMessageId;
        }
        long j2 = j;
        if ((i3 & 4) != 0) {
            i = storeClientDataState$ClientDataState.readStateVersion;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = storeClientDataState$ClientDataState.userGuildSettingsVersion;
        }
        return storeClientDataState$ClientDataState.copy(map, j2, i4, i2);
    }

    private final String[] toArray(GuildHashes guildHashes) {
        GuildHash metadata = guildHashes.getMetadata();
        String hash = metadata != null ? metadata.getHash() : null;
        GuildHash channels = guildHashes.getChannels();
        String hash2 = channels != null ? channels.getHash() : null;
        GuildHash roles = guildHashes.getRoles();
        String hash3 = roles != null ? roles.getHash() : null;
        if (hash == null || hash2 == null || hash3 == null) {
            return null;
        }
        return new String[]{hash, hash2, hash3};
    }

    public final Map<Long, GuildHashes> component1() {
        return this.guildHashes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getHighestLastMessageId() {
        return this.highestLastMessageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getReadStateVersion() {
        return this.readStateVersion;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getUserGuildSettingsVersion() {
        return this.userGuildSettingsVersion;
    }

    public final StoreClientDataState$ClientDataState copy(Map<Long, GuildHashes> guildHashes, long highestLastMessageId, int readStateVersion, int userGuildSettingsVersion) {
        m.checkNotNullParameter(guildHashes, "guildHashes");
        return new StoreClientDataState$ClientDataState(guildHashes, highestLastMessageId, readStateVersion, userGuildSettingsVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreClientDataState$ClientDataState)) {
            return false;
        }
        StoreClientDataState$ClientDataState storeClientDataState$ClientDataState = (StoreClientDataState$ClientDataState) other;
        return m.areEqual(this.guildHashes, storeClientDataState$ClientDataState.guildHashes) && this.highestLastMessageId == storeClientDataState$ClientDataState.highestLastMessageId && this.readStateVersion == storeClientDataState$ClientDataState.readStateVersion && this.userGuildSettingsVersion == storeClientDataState$ClientDataState.userGuildSettingsVersion;
    }

    public final Map<Long, GuildHashes> getGuildHashes() {
        return this.guildHashes;
    }

    public final long getHighestLastMessageId() {
        return this.highestLastMessageId;
    }

    public final int getReadStateVersion() {
        return this.readStateVersion;
    }

    public final int getUserGuildSettingsVersion() {
        return this.userGuildSettingsVersion;
    }

    public int hashCode() {
        Map<Long, GuildHashes> map = this.guildHashes;
        return ((((b.a(this.highestLastMessageId) + ((map != null ? map.hashCode() : 0) * 31)) * 31) + this.readStateVersion) * 31) + this.userGuildSettingsVersion;
    }

    public final OutgoingPayload$IdentifyClientState toIdentifyData() {
        Map<Long, GuildHashes> map = this.guildHashes;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            linkedHashMap.put(map$Entry.getKey(), toArray((GuildHashes) map$Entry.getValue()));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map$Entry map$Entry2 : linkedHashMap.entrySet()) {
            if (map$Entry2.getValue() != null) {
                linkedHashMap2.put(map$Entry2.getKey(), map$Entry2.getValue());
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(g0.mapCapacity(linkedHashMap2.size()));
        for (Map$Entry map$Entry3 : linkedHashMap2.entrySet()) {
            Object key = map$Entry3.getKey();
            Object value = map$Entry3.getValue();
            m.checkNotNull(value);
            linkedHashMap3.put(key, (String[]) value);
        }
        return new OutgoingPayload$IdentifyClientState(linkedHashMap3, this.highestLastMessageId, this.readStateVersion, this.userGuildSettingsVersion);
    }

    public String toString() {
        StringBuilder sbU = a.U("ClientDataState(guildHashes=");
        sbU.append(this.guildHashes);
        sbU.append(", highestLastMessageId=");
        sbU.append(this.highestLastMessageId);
        sbU.append(", readStateVersion=");
        sbU.append(this.readStateVersion);
        sbU.append(", userGuildSettingsVersion=");
        return a.B(sbU, this.userGuildSettingsVersion, ")");
    }

    public /* synthetic */ StoreClientDataState$ClientDataState(Map map, long j, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new HashMap() : map, (i3 & 2) != 0 ? 0L : j, (i3 & 4) != 0 ? -1 : i, (i3 & 8) != 0 ? -1 : i2);
    }
}
