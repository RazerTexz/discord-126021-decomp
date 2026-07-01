package com.discord.api.channel;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

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
        return this.id == forumTag.id && Intrinsics3.areEqual(this.name, forumTag.name) && Intrinsics3.areEqual(this.emojiId, forumTag.emojiId) && Intrinsics3.areEqual(this.emojiName, forumTag.emojiName);
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
        StringBuilder sbU = outline.U("ForumTag(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", emojiId=");
        sbU.append(this.emojiId);
        sbU.append(", emojiName=");
        return outline.J(sbU, this.emojiName, ")");
    }
}
