package com.discord.widgets.channels.permissions;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialog$Companion {
    private ConfirmRemovePermissionDialog$Companion() {
    }

    public final void show(PermissionOwner permissionOwner, long channelId, FragmentManager fragmentManager) {
        m.checkNotNullParameter(permissionOwner, "permissionOwner");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        ConfirmRemovePermissionDialog confirmRemovePermissionDialog = new ConfirmRemovePermissionDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ARG_PERMISSION_OWNER", permissionOwner);
        bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        confirmRemovePermissionDialog.setArguments(bundle);
        confirmRemovePermissionDialog.show(fragmentManager, ConfirmRemovePermissionDialog.class.getSimpleName());
    }

    public /* synthetic */ ConfirmRemovePermissionDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
