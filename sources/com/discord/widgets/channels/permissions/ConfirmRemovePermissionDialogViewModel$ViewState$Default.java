package com.discord.widgets.channels.permissions;

import b.d.b.a.a;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ConfirmRemovePermissionDialogViewModel$ViewState$Default extends ConfirmRemovePermissionDialogViewModel$ViewState {
    private final boolean isSubmitting;

    public ConfirmRemovePermissionDialogViewModel$ViewState$Default(boolean z2) {
        super(null);
        this.isSubmitting = z2;
    }

    public static /* synthetic */ ConfirmRemovePermissionDialogViewModel$ViewState$Default copy$default(ConfirmRemovePermissionDialogViewModel$ViewState$Default confirmRemovePermissionDialogViewModel$ViewState$Default, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = confirmRemovePermissionDialogViewModel$ViewState$Default.isSubmitting;
        }
        return confirmRemovePermissionDialogViewModel$ViewState$Default.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsSubmitting() {
        return this.isSubmitting;
    }

    public final ConfirmRemovePermissionDialogViewModel$ViewState$Default copy(boolean isSubmitting) {
        return new ConfirmRemovePermissionDialogViewModel$ViewState$Default(isSubmitting);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ConfirmRemovePermissionDialogViewModel$ViewState$Default) && this.isSubmitting == ((ConfirmRemovePermissionDialogViewModel$ViewState$Default) other).isSubmitting;
        }
        return true;
    }

    public int hashCode() {
        boolean z2 = this.isSubmitting;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public final boolean isSubmitting() {
        return this.isSubmitting;
    }

    public String toString() {
        return a.O(a.U("Default(isSubmitting="), this.isSubmitting, ")");
    }
}
