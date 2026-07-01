package com.discord.widgets.chat.list;

import b.d.b.a.a;

/* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PublishActionDialogViewModel$Event$Success extends PublishActionDialogViewModel$Event {
    private final int successMessageStringRes;

    public PublishActionDialogViewModel$Event$Success(int i) {
        super(null);
        this.successMessageStringRes = i;
    }

    public static /* synthetic */ PublishActionDialogViewModel$Event$Success copy$default(PublishActionDialogViewModel$Event$Success publishActionDialogViewModel$Event$Success, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = publishActionDialogViewModel$Event$Success.successMessageStringRes;
        }
        return publishActionDialogViewModel$Event$Success.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSuccessMessageStringRes() {
        return this.successMessageStringRes;
    }

    public final PublishActionDialogViewModel$Event$Success copy(int successMessageStringRes) {
        return new PublishActionDialogViewModel$Event$Success(successMessageStringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PublishActionDialogViewModel$Event$Success) && this.successMessageStringRes == ((PublishActionDialogViewModel$Event$Success) other).successMessageStringRes;
        }
        return true;
    }

    public final int getSuccessMessageStringRes() {
        return this.successMessageStringRes;
    }

    public int hashCode() {
        return this.successMessageStringRes;
    }

    public String toString() {
        return a.B(a.U("Success(successMessageStringRes="), this.successMessageStringRes, ")");
    }
}
