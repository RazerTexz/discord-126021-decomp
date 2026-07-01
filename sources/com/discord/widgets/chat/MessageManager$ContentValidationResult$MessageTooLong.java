package com.discord.widgets.chat;

import b.d.b.a.a;

/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageManager$ContentValidationResult$MessageTooLong extends MessageManager$ContentValidationResult {
    private final int maxMessageLength;

    public MessageManager$ContentValidationResult$MessageTooLong(int i) {
        super(null);
        this.maxMessageLength = i;
    }

    public static /* synthetic */ MessageManager$ContentValidationResult$MessageTooLong copy$default(MessageManager$ContentValidationResult$MessageTooLong messageManager$ContentValidationResult$MessageTooLong, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = messageManager$ContentValidationResult$MessageTooLong.maxMessageLength;
        }
        return messageManager$ContentValidationResult$MessageTooLong.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMaxMessageLength() {
        return this.maxMessageLength;
    }

    public final MessageManager$ContentValidationResult$MessageTooLong copy(int maxMessageLength) {
        return new MessageManager$ContentValidationResult$MessageTooLong(maxMessageLength);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MessageManager$ContentValidationResult$MessageTooLong) && this.maxMessageLength == ((MessageManager$ContentValidationResult$MessageTooLong) other).maxMessageLength;
        }
        return true;
    }

    public final int getMaxMessageLength() {
        return this.maxMessageLength;
    }

    public int hashCode() {
        return this.maxMessageLength;
    }

    public String toString() {
        return a.B(a.U("MessageTooLong(maxMessageLength="), this.maxMessageLength, ")");
    }
}
