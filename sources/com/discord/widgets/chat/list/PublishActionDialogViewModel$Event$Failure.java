package com.discord.widgets.chat.list;

import b.d.b.a.a;

/* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PublishActionDialogViewModel$Event$Failure extends PublishActionDialogViewModel$Event {
    private final int failureMessageStringRes;

    public PublishActionDialogViewModel$Event$Failure(int i) {
        super(null);
        this.failureMessageStringRes = i;
    }

    public static /* synthetic */ PublishActionDialogViewModel$Event$Failure copy$default(PublishActionDialogViewModel$Event$Failure publishActionDialogViewModel$Event$Failure, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = publishActionDialogViewModel$Event$Failure.failureMessageStringRes;
        }
        return publishActionDialogViewModel$Event$Failure.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFailureMessageStringRes() {
        return this.failureMessageStringRes;
    }

    public final PublishActionDialogViewModel$Event$Failure copy(int failureMessageStringRes) {
        return new PublishActionDialogViewModel$Event$Failure(failureMessageStringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PublishActionDialogViewModel$Event$Failure) && this.failureMessageStringRes == ((PublishActionDialogViewModel$Event$Failure) other).failureMessageStringRes;
        }
        return true;
    }

    public final int getFailureMessageStringRes() {
        return this.failureMessageStringRes;
    }

    public int hashCode() {
        return this.failureMessageStringRes;
    }

    public String toString() {
        return a.B(a.U("Failure(failureMessageStringRes="), this.failureMessageStringRes, ")");
    }
}
