package com.discord.widgets.channels.permissions;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PermissionOwnerListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOwnerListView$PermissionOwnerViewHolder$configure$1 implements View$OnClickListener {
    public final /* synthetic */ PermissionOwnerListView$Item $item;
    public final /* synthetic */ Function0 $onRemoveClicked;
    public final /* synthetic */ PermissionOwnerListView$PermissionOwnerViewHolder this$0;

    public PermissionOwnerListView$PermissionOwnerViewHolder$configure$1(PermissionOwnerListView$PermissionOwnerViewHolder permissionOwnerListView$PermissionOwnerViewHolder, PermissionOwnerListView$Item permissionOwnerListView$Item, Function0 function0) {
        this.this$0 = permissionOwnerListView$PermissionOwnerViewHolder;
        this.$item = permissionOwnerListView$Item;
        this.$onRemoveClicked = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        PermissionOwnerListView$RemoveStatus removeStatus = this.$item.getRemoveStatus();
        if (m.areEqual(removeStatus, PermissionOwnerListView$RemoveStatus$CanRemove.INSTANCE)) {
            this.$onRemoveClicked.invoke();
            return;
        }
        if (!m.areEqual(removeStatus, PermissionOwnerListView$RemoveStatus$IsRemoving.INSTANCE) && (removeStatus instanceof PermissionOwnerListView$RemoveStatus$CannotRemove)) {
            int iOrdinal = ((PermissionOwnerListView$RemoveStatus$CannotRemove) this.$item.getRemoveStatus()).getReason().ordinal();
            if (iOrdinal == 2) {
                ConstraintLayout constraintLayout = PermissionOwnerListView$PermissionOwnerViewHolder.access$getBinding$p(this.this$0).a;
                m.checkNotNullExpressionValue(constraintLayout, "binding.root");
                Toast.makeText(constraintLayout.getContext(), 2131887597, 0).show();
            } else {
                if (iOrdinal != 3) {
                    return;
                }
                ConstraintLayout constraintLayout2 = PermissionOwnerListView$PermissionOwnerViewHolder.access$getBinding$p(this.this$0).a;
                m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
                Toast.makeText(constraintLayout2.getContext(), 2131887575, 0).show();
            }
        }
    }
}
