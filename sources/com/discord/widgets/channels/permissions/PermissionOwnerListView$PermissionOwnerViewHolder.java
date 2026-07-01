package com.discord.widgets.channels.permissions;

import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PermissionOwnerListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOwnerListView$PermissionOwnerViewHolder extends RecyclerView$ViewHolder {
    private final RemovablePermissionOwnerViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView$PermissionOwnerViewHolder(RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBinding) {
        super(removablePermissionOwnerViewBinding.a);
        m.checkNotNullParameter(removablePermissionOwnerViewBinding, "binding");
        this.binding = removablePermissionOwnerViewBinding;
    }

    public static final /* synthetic */ RemovablePermissionOwnerViewBinding access$getBinding$p(PermissionOwnerListView$PermissionOwnerViewHolder permissionOwnerListView$PermissionOwnerViewHolder) {
        return permissionOwnerListView$PermissionOwnerViewHolder.binding;
    }

    public final void configure(PermissionOwnerListView$Item item, Function0<Unit> onRemoveClicked) {
        m.checkNotNullParameter(item, "item");
        m.checkNotNullParameter(onRemoveClicked, "onRemoveClicked");
        this.binding.f2138b.a(item.getPermissionOwner());
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.remove");
        ViewExtensions.setEnabledAlpha$default(imageView, item.getRemoveStatus() instanceof PermissionOwnerListView$RemoveStatus$CanRemove, 0.0f, 2, null);
        this.binding.c.setOnClickListener(new PermissionOwnerListView$PermissionOwnerViewHolder$configure$1(this, item, onRemoveClicked));
    }
}
