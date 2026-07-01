package com.discord.widgets.chat.input;

import b.d.b.a.a;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChatInputViewModel$Event$MessageTooLong extends ChatInputViewModel$Event {
    private final int currentCharacterCount;
    private final int maxCharacterCount;

    public ChatInputViewModel$Event$MessageTooLong(int i, int i2) {
        super(null);
        this.currentCharacterCount = i;
        this.maxCharacterCount = i2;
    }

    public static /* synthetic */ ChatInputViewModel$Event$MessageTooLong copy$default(ChatInputViewModel$Event$MessageTooLong chatInputViewModel$Event$MessageTooLong, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = chatInputViewModel$Event$MessageTooLong.currentCharacterCount;
        }
        if ((i3 & 2) != 0) {
            i2 = chatInputViewModel$Event$MessageTooLong.maxCharacterCount;
        }
        return chatInputViewModel$Event$MessageTooLong.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCurrentCharacterCount() {
        return this.currentCharacterCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMaxCharacterCount() {
        return this.maxCharacterCount;
    }

    public final ChatInputViewModel$Event$MessageTooLong copy(int currentCharacterCount, int maxCharacterCount) {
        return new ChatInputViewModel$Event$MessageTooLong(currentCharacterCount, maxCharacterCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatInputViewModel$Event$MessageTooLong)) {
            return false;
        }
        ChatInputViewModel$Event$MessageTooLong chatInputViewModel$Event$MessageTooLong = (ChatInputViewModel$Event$MessageTooLong) other;
        return this.currentCharacterCount == chatInputViewModel$Event$MessageTooLong.currentCharacterCount && this.maxCharacterCount == chatInputViewModel$Event$MessageTooLong.maxCharacterCount;
    }

    public final int getCurrentCharacterCount() {
        return this.currentCharacterCount;
    }

    public final int getMaxCharacterCount() {
        return this.maxCharacterCount;
    }

    public int hashCode() {
        return (this.currentCharacterCount * 31) + this.maxCharacterCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("MessageTooLong(currentCharacterCount=");
        sbU.append(this.currentCharacterCount);
        sbU.append(", maxCharacterCount=");
        return a.B(sbU, this.maxCharacterCount, ")");
    }
}
