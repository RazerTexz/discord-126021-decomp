package com.discord.widgets.channels.permissions;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialog$viewModel$2 extends AbstractC12240o implements Function0<ConfirmRemovePermissionDialogViewModel> {
    public final /* synthetic */ ConfirmRemovePermissionDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmRemovePermissionDialog$viewModel$2(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        super(0);
        this.this$0 = confirmRemovePermissionDialog;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ConfirmRemovePermissionDialogViewModel invoke() {
        return new ConfirmRemovePermissionDialogViewModel(this.this$0.getPermissionOwnerFromArgs(), this.this$0.getChannelIdFromArgs(), null, 4, null);
    }
}
