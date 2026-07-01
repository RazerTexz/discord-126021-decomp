package com.discord.api.botuikit;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.io.Serializable;

/* JADX INFO: compiled from: ComponentEmoji.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ComponentEmoji implements Serializable {
    private final Boolean animated;
    private final String id;
    private final String name;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Boolean getAnimated() {
        return this.animated;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComponentEmoji)) {
            return false;
        }
        ComponentEmoji componentEmoji = (ComponentEmoji) other;
        return m.areEqual(this.id, componentEmoji.id) && m.areEqual(this.name, componentEmoji.name) && m.areEqual(this.animated, componentEmoji.animated);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.animated;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ComponentEmoji(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", animated=");
        return a.D(sbU, this.animated, ")");
    }
}
