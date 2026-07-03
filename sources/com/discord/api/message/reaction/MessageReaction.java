package com.discord.api.message.reaction;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MessageReaction.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MessageReaction {
    private final int count;
    private final MessageReactionEmoji emoji;
    private final boolean me;

    public MessageReaction(int i, MessageReactionEmoji messageReactionEmoji, boolean z2) {
        C12238m.checkNotNullParameter(messageReactionEmoji, "emoji");
        this.count = i;
        this.emoji = messageReactionEmoji;
        this.me = z2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final MessageReactionEmoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getMe() {
        return this.me;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageReaction)) {
            return false;
        }
        MessageReaction messageReaction = (MessageReaction) other;
        return this.count == messageReaction.count && C12238m.areEqual(this.emoji, messageReaction.emoji) && this.me == messageReaction.me;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int i = this.count * 31;
        MessageReactionEmoji messageReactionEmoji = this.emoji;
        int iHashCode = (i + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0)) * 31;
        boolean z2 = this.me;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("MessageReaction(count=");
        sbM833U.append(this.count);
        sbM833U.append(", emoji=");
        sbM833U.append(this.emoji);
        sbM833U.append(", me=");
        return C1643a.m827O(sbM833U, this.me, ")");
    }
}
