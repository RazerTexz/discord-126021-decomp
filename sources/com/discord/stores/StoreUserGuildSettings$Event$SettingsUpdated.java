package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreUserGuildSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreUserGuildSettings$Event$SettingsUpdated extends StoreUserGuildSettings$Event {
    private final StoreUserGuildSettings$SettingsUpdateType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserGuildSettings$Event$SettingsUpdated(StoreUserGuildSettings$SettingsUpdateType storeUserGuildSettings$SettingsUpdateType) {
        super(null);
        m.checkNotNullParameter(storeUserGuildSettings$SettingsUpdateType, "type");
        this.type = storeUserGuildSettings$SettingsUpdateType;
    }

    public static /* synthetic */ StoreUserGuildSettings$Event$SettingsUpdated copy$default(StoreUserGuildSettings$Event$SettingsUpdated storeUserGuildSettings$Event$SettingsUpdated, StoreUserGuildSettings$SettingsUpdateType storeUserGuildSettings$SettingsUpdateType, int i, Object obj) {
        if ((i & 1) != 0) {
            storeUserGuildSettings$SettingsUpdateType = storeUserGuildSettings$Event$SettingsUpdated.type;
        }
        return storeUserGuildSettings$Event$SettingsUpdated.copy(storeUserGuildSettings$SettingsUpdateType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreUserGuildSettings$SettingsUpdateType getType() {
        return this.type;
    }

    public final StoreUserGuildSettings$Event$SettingsUpdated copy(StoreUserGuildSettings$SettingsUpdateType type) {
        m.checkNotNullParameter(type, "type");
        return new StoreUserGuildSettings$Event$SettingsUpdated(type);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreUserGuildSettings$Event$SettingsUpdated) && m.areEqual(this.type, ((StoreUserGuildSettings$Event$SettingsUpdated) other).type);
        }
        return true;
    }

    public final StoreUserGuildSettings$SettingsUpdateType getType() {
        return this.type;
    }

    public int hashCode() {
        StoreUserGuildSettings$SettingsUpdateType storeUserGuildSettings$SettingsUpdateType = this.type;
        if (storeUserGuildSettings$SettingsUpdateType != null) {
            return storeUserGuildSettings$SettingsUpdateType.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("SettingsUpdated(type=");
        sbU.append(this.type);
        sbU.append(")");
        return sbU.toString();
    }
}
