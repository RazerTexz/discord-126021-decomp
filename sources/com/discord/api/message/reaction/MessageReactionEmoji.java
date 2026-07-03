package com.discord.api.message.reaction;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MessageReactionEmoji.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MessageReactionEmoji {
    private final boolean animated;
    private final String id;
    private final String name;

    public MessageReactionEmoji(String str, String str2, boolean z2) {
        this.id = str;
        this.name = str2;
        this.animated = z2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c */
    public final String m8116c() {
        String str = this.id;
        if (str != null) {
            return str;
        }
        String str2 = this.name;
        C12238m.checkNotNull(str2);
        return str2;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m8118e() {
        return this.id != null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageReactionEmoji)) {
            return false;
        }
        MessageReactionEmoji messageReactionEmoji = (MessageReactionEmoji) other;
        return C12238m.areEqual(this.id, messageReactionEmoji.id) && C12238m.areEqual(this.name, messageReactionEmoji.name) && this.animated == messageReactionEmoji.animated;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.animated;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("MessageReactionEmoji(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", animated=");
        return C1643a.m827O(sbM833U, this.animated, ")");
    }
}
