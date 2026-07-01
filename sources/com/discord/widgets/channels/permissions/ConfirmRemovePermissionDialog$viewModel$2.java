package com.discord.widgets.channels.permissions;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialog$viewModel$2 extends o implements Function0<ConfirmRemovePermissionDialogViewModel> {
    public final /* synthetic */ ConfirmRemovePermissionDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmRemovePermissionDialog$viewModel$2(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        super(0);
        this.this$0 = confirmRemovePermissionDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ConfirmRemovePermissionDialogViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ConfirmRemovePermissionDialogViewModel invoke() {
        return new ConfirmRemovePermissionDialogViewModel(ConfirmRemovePermissionDialog.access$getPermissionOwnerFromArgs(this.this$0), ConfirmRemovePermissionDialog.access$getChannelIdFromArgs(this.this$0), null, 4, null);
    }
}
