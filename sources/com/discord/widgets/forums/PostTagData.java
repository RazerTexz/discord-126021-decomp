package com.discord.widgets.forums;

import com.discord.api.channel.ForumTag;
import com.discord.api.message.reaction.MessageReactionEmoji;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PostData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PostTagData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MessageReactionEmoji messageReactionEmoji;
    private final String tagName;

    /* JADX INFO: compiled from: PostData.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ PostTagData fromTag$default(Companion companion, ForumTag forumTag, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return companion.fromTag(forumTag, z2);
        }

        public final PostTagData fromTag(ForumTag tag, boolean animated) {
            C12238m.checkNotNullParameter(tag, "tag");
            return new PostTagData(new MessageReactionEmoji(tag.getCustomEmojiId(), tag.getEmojiName(), animated), tag.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PostTagData(MessageReactionEmoji messageReactionEmoji, String str) {
        C12238m.checkNotNullParameter(messageReactionEmoji, "messageReactionEmoji");
        C12238m.checkNotNullParameter(str, "tagName");
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
        C12238m.checkNotNullParameter(messageReactionEmoji, "messageReactionEmoji");
        C12238m.checkNotNullParameter(tagName, "tagName");
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
        return C12238m.areEqual(this.messageReactionEmoji, postTagData.messageReactionEmoji) && C12238m.areEqual(this.tagName, postTagData.tagName);
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
        StringBuilder sbM833U = C1643a.m833U("PostTagData(messageReactionEmoji=");
        sbM833U.append(this.messageReactionEmoji);
        sbM833U.append(", tagName=");
        return C1643a.m822J(sbM833U, this.tagName, ")");
    }
}
