package com.discord.widgets.forums;

import b.d.b.a.outline;
import com.discord.api.channel.ForumTag;
import com.discord.api.message.reaction.MessageReactionEmoji;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.forums.PostTagData, reason: use source file name */
/* JADX INFO: compiled from: PostData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PostData2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MessageReactionEmoji messageReactionEmoji;
    private final String tagName;

    /* JADX INFO: renamed from: com.discord.widgets.forums.PostTagData$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: PostData.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ PostData2 fromTag$default(Companion companion, ForumTag forumTag, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return companion.fromTag(forumTag, z2);
        }

        public final PostData2 fromTag(ForumTag tag, boolean animated) {
            Intrinsics3.checkNotNullParameter(tag, "tag");
            return new PostData2(new MessageReactionEmoji(tag.getCustomEmojiId(), tag.getEmojiName(), animated), tag.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PostData2(MessageReactionEmoji messageReactionEmoji, String str) {
        Intrinsics3.checkNotNullParameter(messageReactionEmoji, "messageReactionEmoji");
        Intrinsics3.checkNotNullParameter(str, "tagName");
        this.messageReactionEmoji = messageReactionEmoji;
        this.tagName = str;
    }

    public static /* synthetic */ PostData2 copy$default(PostData2 postData2, MessageReactionEmoji messageReactionEmoji, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            messageReactionEmoji = postData2.messageReactionEmoji;
        }
        if ((i & 2) != 0) {
            str = postData2.tagName;
        }
        return postData2.copy(messageReactionEmoji, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MessageReactionEmoji getMessageReactionEmoji() {
        return this.messageReactionEmoji;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    public final PostData2 copy(MessageReactionEmoji messageReactionEmoji, String tagName) {
        Intrinsics3.checkNotNullParameter(messageReactionEmoji, "messageReactionEmoji");
        Intrinsics3.checkNotNullParameter(tagName, "tagName");
        return new PostData2(messageReactionEmoji, tagName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostData2)) {
            return false;
        }
        PostData2 postData2 = (PostData2) other;
        return Intrinsics3.areEqual(this.messageReactionEmoji, postData2.messageReactionEmoji) && Intrinsics3.areEqual(this.tagName, postData2.tagName);
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
        StringBuilder sbU = outline.U("PostTagData(messageReactionEmoji=");
        sbU.append(this.messageReactionEmoji);
        sbU.append(", tagName=");
        return outline.J(sbU, this.tagName, ")");
    }
}
