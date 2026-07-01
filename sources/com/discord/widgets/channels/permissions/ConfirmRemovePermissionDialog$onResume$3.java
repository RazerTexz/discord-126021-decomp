package com.discord.widgets.channels.permissions;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialog$onResume$3 implements View$OnClickListener {
    public final /* synthetic */ ConfirmRemovePermissionDialog this$0;

    public ConfirmRemovePermissionDialog$onResume$3(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        this.this$0 = confirmRemovePermissionDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
