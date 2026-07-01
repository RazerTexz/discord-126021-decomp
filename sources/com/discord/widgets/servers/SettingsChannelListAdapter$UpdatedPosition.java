package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsChannelListAdapter$UpdatedPosition {
    private final Long parentId;
    private final int position;

    public SettingsChannelListAdapter$UpdatedPosition(int i, Long l) {
        this.position = i;
        this.parentId = l;
    }

    public static /* synthetic */ SettingsChannelListAdapter$UpdatedPosition copy$default(SettingsChannelListAdapter$UpdatedPosition settingsChannelListAdapter$UpdatedPosition, int i, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = settingsChannelListAdapter$UpdatedPosition.position;
        }
        if ((i2 & 2) != 0) {
            l = settingsChannelListAdapter$UpdatedPosition.parentId;
        }
        return settingsChannelListAdapter$UpdatedPosition.copy(i, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getParentId() {
        return this.parentId;
    }

    public final SettingsChannelListAdapter$UpdatedPosition copy(int position, Long parentId) {
        return new SettingsChannelListAdapter$UpdatedPosition(position, parentId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsChannelListAdapter$UpdatedPosition)) {
            return false;
        }
        SettingsChannelListAdapter$UpdatedPosition settingsChannelListAdapter$UpdatedPosition = (SettingsChannelListAdapter$UpdatedPosition) other;
        return this.position == settingsChannelListAdapter$UpdatedPosition.position && m.areEqual(this.parentId, settingsChannelListAdapter$UpdatedPosition.parentId);
    }

    public final Long getParentId() {
        return this.parentId;
    }

    public final int getPosition() {
        return this.position;
    }

    public int hashCode() {
        int i = this.position * 31;
        Long l = this.parentId;
        return i + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UpdatedPosition(position=");
        sbU.append(this.position);
        sbU.append(", parentId=");
        return a.G(sbU, this.parentId, ")");
    }
}
