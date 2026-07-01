package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiAutocompletable extends Autocompletable {
    private final boolean animationsEnabled;
    private final Emoji emoji;
    private final List<String> textMatchers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiAutocompletable(Emoji emoji, boolean z2) {
        super(null);
        m.checkNotNullParameter(emoji, "emoji");
        this.emoji = emoji;
        this.animationsEnabled = z2;
        List<String> names = emoji.getNames();
        m.checkNotNullExpressionValue(names, "emoji.names");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(names, 10));
        Iterator<T> it = names.iterator();
        while (it.hasNext()) {
            arrayList.add(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + ((String) it.next()) + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        }
        this.textMatchers = arrayList;
    }

    public static /* synthetic */ EmojiAutocompletable copy$default(EmojiAutocompletable emojiAutocompletable, Emoji emoji, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            emoji = emojiAutocompletable.emoji;
        }
        if ((i & 2) != 0) {
            z2 = emojiAutocompletable.animationsEnabled;
        }
        return emojiAutocompletable.copy(emoji, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Emoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAnimationsEnabled() {
        return this.animationsEnabled;
    }

    public final EmojiAutocompletable copy(Emoji emoji, boolean animationsEnabled) {
        m.checkNotNullParameter(emoji, "emoji");
        return new EmojiAutocompletable(emoji, animationsEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiAutocompletable)) {
            return false;
        }
        EmojiAutocompletable emojiAutocompletable = (EmojiAutocompletable) other;
        return m.areEqual(this.emoji, emojiAutocompletable.emoji) && this.animationsEnabled == emojiAutocompletable.animationsEnabled;
    }

    public final boolean getAnimationsEnabled() {
        return this.animationsEnabled;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getAutocompleteTextMatchers() {
        return null;
    }

    public final Emoji getEmoji() {
        return this.emoji;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getHiddenInputTextMatchers() {
        if (this.emoji.requiresColons()) {
            return null;
        }
        return this.emoji.getNames();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        String messageContentReplacement = this.emoji.getMessageContentReplacement();
        m.checkNotNullExpressionValue(messageContentReplacement, "emoji.messageContentReplacement");
        return messageContentReplacement;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        Emoji emoji = this.emoji;
        int iHashCode = (emoji != null ? emoji.hashCode() : 0) * 31;
        boolean z2 = this.animationsEnabled;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        boolean zRequiresColons = this.emoji.requiresColons();
        if (zRequiresColons) {
            return LeadingIdentifier.EMOJI_AND_STICKERS;
        }
        if (zRequiresColons) {
            throw new NoWhenBranchMatchedException();
        }
        return LeadingIdentifier.NONE;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmojiAutocompletable(emoji=");
        sbU.append(this.emoji);
        sbU.append(", animationsEnabled=");
        return a.O(sbU, this.animationsEnabled, ")");
    }
}
