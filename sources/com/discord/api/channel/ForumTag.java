package com.discord.api.channel;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ForumTag.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ForumTag {
    private final String customEmojiId;
    private final Long emojiId;
    private final String emojiName;
    private final long id;
    private final String name;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCustomEmojiId() {
        return this.customEmojiId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForumTag)) {
            return false;
        }
        ForumTag forumTag = (ForumTag) other;
        return this.id == forumTag.id && C12238m.areEqual(this.name, forumTag.name) && C12238m.areEqual(this.emojiId, forumTag.emojiId) && C12238m.areEqual(this.emojiName, forumTag.emojiName);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.emojiId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.emojiName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ForumTag(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", emojiId=");
        sbM833U.append(this.emojiId);
        sbM833U.append(", emojiName=");
        return C1643a.m822J(sbM833U, this.emojiName, ")");
    }
}
