package com.discord.widgets.channels.permissions;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialogViewModel$submit$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ ConfirmRemovePermissionDialogViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmRemovePermissionDialogViewModel$submit$1(ConfirmRemovePermissionDialogViewModel confirmRemovePermissionDialogViewModel) {
        super(1);
        this.this$0 = confirmRemovePermissionDialogViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r1) {
        ConfirmRemovePermissionDialogViewModel.access$handleSubmissionComplete(this.this$0);
    }
}
