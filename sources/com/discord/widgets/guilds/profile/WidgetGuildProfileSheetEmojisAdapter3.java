package com.discord.widgets.guilds.profile;

import b.d.b.a.outline;
import com.discord.models.domain.emoji.Emoji;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.EmojiItem, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetGuildProfileSheetEmojisAdapter3 {
    public static final int TYPE_EMOJI = 0;
    public static final int TYPE_MORE_EMOJI = 1;
    private final int type;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.EmojiItem$EmojiData */
    /* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
    public static final /* data */ class EmojiData extends WidgetGuildProfileSheetEmojisAdapter3 {
        private final Emoji emoji;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmojiData(Emoji emoji) {
            super(0, null);
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            this.emoji = emoji;
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.EmojiItem$MoreEmoji */
    /* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
    public static final /* data */ class MoreEmoji extends WidgetGuildProfileSheetEmojisAdapter3 {
        private final int extraEmojiCount;

        public MoreEmoji(int i) {
            super(1, null);
            this.extraEmojiCount = i;
        }

        public static /* synthetic */ MoreEmoji copy$default(MoreEmoji moreEmoji, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = moreEmoji.extraEmojiCount;
            }
            return moreEmoji.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getExtraEmojiCount() {
            return this.extraEmojiCount;
        }

        public final MoreEmoji copy(int extraEmojiCount) {
            return new MoreEmoji(extraEmojiCount);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof MoreEmoji) && this.extraEmojiCount == ((MoreEmoji) other).extraEmojiCount;
            }
            return true;
        }

        public final int getExtraEmojiCount() {
            return this.extraEmojiCount;
        }

        public int hashCode() {
            return this.extraEmojiCount;
        }

        public String toString() {
            return outline.B(outline.U("MoreEmoji(extraEmojiCount="), this.extraEmojiCount, ")");
        }
    }

    private WidgetGuildProfileSheetEmojisAdapter3(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    public /* synthetic */ WidgetGuildProfileSheetEmojisAdapter3(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
