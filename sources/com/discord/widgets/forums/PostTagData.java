package com.discord.widgets.forums;

import b.d.b.a.a;
import com.discord.api.message.reaction.MessageReactionEmoji;
import d0.z.d.m;

/* JADX INFO: compiled from: PostData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PostTagData {
    public static final PostTagData$Companion Companion = new PostTagData$Companion(null);
    private final MessageReactionEmoji messageReactionEmoji;
    private final String tagName;

    public PostTagData(MessageReactionEmoji messageReactionEmoji, String str) {
        m.checkNotNullParameter(messageReactionEmoji, "messageReactionEmoji");
        m.checkNotNullParameter(str, "tagName");
        this.messageReactionEmoji = messageReactionEmoji;
        this.tagName = str;
    }

    public static /* synthetic */ PostTagData copy$default(PostTagData postTagData, MessageReactionEmoji messageReactionEmoji, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            messageReactionEmoji = postTagData.messageReactionEmoji;
        }
        if ((i & 2) != 0) {
            str = postTagData.tagName;
        }
        return postTagData.copy(messageReactionEmoji, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MessageReactionEmoji getMessageReactionEmoji() {
        return this.messageReactionEmoji;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    public final PostTagData copy(MessageReactionEmoji messageReactionEmoji, String tagName) {
        m.checkNotNullParameter(messageReactionEmoji, "messageReactionEmoji");
        m.checkNotNullParameter(tagName, "tagName");
        return new PostTagData(messageReactionEmoji, tagName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostTagData)) {
            return false;
        }
        PostTagData postTagData = (PostTagData) other;
        return m.areEqual(this.messageReactionEmoji, postTagData.messageReactionEmoji) && m.areEqual(this.tagName, postTagData.tagName);
    }

    public final MessageReactionEmoji getMessageReactionEmoji() {
        return this.messageReactionEmoji;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public int hashCode() {
        MessageReactionEmoji messageReactionEmoji = this.messageReactionEmoji;
        int iHashCode = (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0) * 31;
        String str = this.tagName;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PostTagData(messageReactionEmoji=");
        sbU.append(this.messageReactionEmoji);
        sbU.append(", tagName=");
        return a.J(sbU, this.tagName, ")");
    }
}
