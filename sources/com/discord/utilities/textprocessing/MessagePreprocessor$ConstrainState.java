package com.discord.utilities.textprocessing;

import b.d.b.a.a;

/* JADX INFO: compiled from: MessagePreprocessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessagePreprocessor$ConstrainState {
    private int limit;

    public MessagePreprocessor$ConstrainState(int i) {
        this.limit = i;
    }

    public static /* synthetic */ MessagePreprocessor$ConstrainState copy$default(MessagePreprocessor$ConstrainState messagePreprocessor$ConstrainState, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = messagePreprocessor$ConstrainState.limit;
        }
        return messagePreprocessor$ConstrainState.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    public final MessagePreprocessor$ConstrainState copy(int limit) {
        return new MessagePreprocessor$ConstrainState(limit);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MessagePreprocessor$ConstrainState) && this.limit == ((MessagePreprocessor$ConstrainState) other).limit;
        }
        return true;
    }

    public final int getLimit() {
        return this.limit;
    }

    public int hashCode() {
        return this.limit;
    }

    public final void setLimit(int i) {
        this.limit = i;
    }

    public String toString() {
        return a.B(a.U("ConstrainState(limit="), this.limit, ")");
    }
}
