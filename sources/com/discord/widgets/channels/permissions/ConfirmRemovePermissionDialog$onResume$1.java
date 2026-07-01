package com.discord.widgets.channels.permissions;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialog$onResume$1 extends o implements Function1<ConfirmRemovePermissionDialogViewModel$ViewState, Unit> {
    public final /* synthetic */ ConfirmRemovePermissionDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmRemovePermissionDialog$onResume$1(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        super(1);
        this.this$0 = confirmRemovePermissionDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConfirmRemovePermissionDialogViewModel$ViewState confirmRemovePermissionDialogViewModel$ViewState) {
        invoke2(confirmRemovePermissionDialogViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConfirmRemovePermissionDialogViewModel$ViewState confirmRemovePermissionDialogViewModel$ViewState) {
        m.checkNotNullParameter(confirmRemovePermissionDialogViewModel$ViewState, "viewState");
        ConfirmRemovePermissionDialog.access$configureUI(this.this$0, confirmRemovePermissionDialogViewModel$ViewState);
    }
}
