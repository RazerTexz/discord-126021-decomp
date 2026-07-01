package com.discord.widgets.forums;

import com.discord.api.channel.ForumTag;
import com.discord.api.message.reaction.MessageReactionEmoji;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PostData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PostTagData$Companion {
    private PostTagData$Companion() {
    }

    public static /* synthetic */ PostTagData fromTag$default(PostTagData$Companion postTagData$Companion, ForumTag forumTag, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return postTagData$Companion.fromTag(forumTag, z2);
    }

    public final PostTagData fromTag(ForumTag tag, boolean animated) {
        m.checkNotNullParameter(tag, "tag");
        return new PostTagData(new MessageReactionEmoji(tag.getCustomEmojiId(), tag.getEmojiName(), animated), tag.getName());
    }

    public /* synthetic */ PostTagData$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
