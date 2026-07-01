package com.discord.widgets.chat.input.emoji;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiPickerViewModel$Event$ScrollToEmojiListPosition extends EmojiPickerViewModel$Event {
    private final int position;

    public EmojiPickerViewModel$Event$ScrollToEmojiListPosition(int i) {
        super(null);
        this.position = i;
    }

    public static /* synthetic */ EmojiPickerViewModel$Event$ScrollToEmojiListPosition copy$default(EmojiPickerViewModel$Event$ScrollToEmojiListPosition emojiPickerViewModel$Event$ScrollToEmojiListPosition, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = emojiPickerViewModel$Event$ScrollToEmojiListPosition.position;
        }
        return emojiPickerViewModel$Event$ScrollToEmojiListPosition.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    public final EmojiPickerViewModel$Event$ScrollToEmojiListPosition copy(int position) {
        return new EmojiPickerViewModel$Event$ScrollToEmojiListPosition(position);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof EmojiPickerViewModel$Event$ScrollToEmojiListPosition) && this.position == ((EmojiPickerViewModel$Event$ScrollToEmojiListPosition) other).position;
        }
        return true;
    }

    public final int getPosition() {
        return this.position;
    }

    public int hashCode() {
        return this.position;
    }

    public String toString() {
        return a.B(a.U("ScrollToEmojiListPosition(position="), this.position, ")");
    }
}
