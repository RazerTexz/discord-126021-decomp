package com.discord.widgets.chat.list.actions;

import b.d.b.a.outline;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.EmojiItem, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChatListActionsEmojisAdapter2 implements MGRecyclerDataPayload {
    public static final int TYPE_EMOJI = 0;
    public static final int TYPE_MORE_EMOJIS = 1;
    private final int type;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.EmojiItem$EmojiData */
    /* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
    public static final /* data */ class EmojiData extends WidgetChatListActionsEmojisAdapter2 {
        private final Emoji emoji;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmojiData(Emoji emoji) {
            super(0, null);
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            this.emoji = emoji;
            this.key = getType() + '_' + emoji.getUniqueId();
        }

        public static /* synthetic */ EmojiData copy$default(EmojiData emojiData, Emoji emoji, int i, Object obj) {
            if ((i & 1) != 0) {
                emoji = emojiData.emoji;
            }
            return emojiData.copy(emoji);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final EmojiData copy(Emoji emoji) {
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            return new EmojiData(emoji);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof EmojiData) && Intrinsics3.areEqual(this.emoji, ((EmojiData) other).emoji);
            }
            return true;
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public int hashCode() {
            Emoji emoji = this.emoji;
            if (emoji != null) {
                return emoji.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("EmojiData(emoji=");
            sbU.append(this.emoji);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.EmojiItem$MoreEmoji */
    /* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
    public static final class MoreEmoji extends WidgetChatListActionsEmojisAdapter2 {
        public static final MoreEmoji INSTANCE;
        private static final String key;

        static {
            MoreEmoji moreEmoji = new MoreEmoji();
            INSTANCE = moreEmoji;
            key = String.valueOf(moreEmoji.getType());
        }

        private MoreEmoji() {
            super(1, null);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }
    }

    private WidgetChatListActionsEmojisAdapter2(int i) {
        this.type = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ WidgetChatListActionsEmojisAdapter2(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
