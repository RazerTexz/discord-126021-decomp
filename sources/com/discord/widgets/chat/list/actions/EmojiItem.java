package com.discord.widgets.chat.list.actions;

import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class EmojiItem implements MGRecyclerDataPayload {
    public static final int TYPE_EMOJI = 0;
    public static final int TYPE_MORE_EMOJIS = 1;
    private final int type;

    /* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
    public static final /* data */ class EmojiData extends EmojiItem {
        private final Emoji emoji;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmojiData(Emoji emoji) {
            super(0, null);
            C12238m.checkNotNullParameter(emoji, "emoji");
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
            C12238m.checkNotNullParameter(emoji, "emoji");
            return new EmojiData(emoji);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof EmojiData) && C12238m.areEqual(this.emoji, ((EmojiData) other).emoji);
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
            StringBuilder sbM833U = C1643a.m833U("EmojiData(emoji=");
            sbM833U.append(this.emoji);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
    public static final class MoreEmoji extends EmojiItem {
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

    private EmojiItem(int i) {
        this.type = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ EmojiItem(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
