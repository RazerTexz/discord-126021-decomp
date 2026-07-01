package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.databinding.WidgetChannelSettingsAddMemberItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.permissions.ChannelPermissionOwnerView;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AddMemberAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddMemberAdapter$AddMemberAdapterItemItem extends MGRecyclerViewHolder<AddMemberAdapter, AddMemberAdapter$Item> {
    private final WidgetChannelSettingsAddMemberItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddMemberAdapter$AddMemberAdapterItemItem(AddMemberAdapter addMemberAdapter) {
        super(R$layout.widget_channel_settings_add_member_item, addMemberAdapter);
        m.checkNotNullParameter(addMemberAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.channel_permission_owner_view;
        ChannelPermissionOwnerView channelPermissionOwnerView = (ChannelPermissionOwnerView) view.findViewById(R$id.channel_permission_owner_view);
        if (channelPermissionOwnerView != null) {
            i = 2131362724;
            MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(2131362724);
            if (materialCheckBox != null) {
                i = 2131362883;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(2131362883);
                if (constraintLayout != null) {
                    WidgetChannelSettingsAddMemberItemBinding widgetChannelSettingsAddMemberItemBinding = new WidgetChannelSettingsAddMemberItemBinding((FrameLayout) view, channelPermissionOwnerView, materialCheckBox, constraintLayout);
                    m.checkNotNullExpressionValue(widgetChannelSettingsAddMemberItemBinding, "WidgetChannelSettingsAdd…temBinding.bind(itemView)");
                    this.binding = widgetChannelSettingsAddMemberItemBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$handleClick(AddMemberAdapter$AddMemberAdapterItemItem addMemberAdapter$AddMemberAdapterItemItem, AddMemberAdapter$Item$PermissionOwnerItem addMemberAdapter$Item$PermissionOwnerItem) {
        addMemberAdapter$AddMemberAdapterItemItem.handleClick(addMemberAdapter$Item$PermissionOwnerItem);
    }

    private final void handleClick(AddMemberAdapter$Item$PermissionOwnerItem item) {
        PermissionOwner permissionOwner = item.getPermissionOwner();
        AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus addStatus = item.getAddStatus();
        if (m.areEqual(addStatus, AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CanAdd.INSTANCE)) {
            handleOnClickForPermissionOwner(permissionOwner);
        } else if ((addStatus instanceof AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd) && ((AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CannotAdd) item.getAddStatus()).getReason().ordinal() == 0) {
            FrameLayout frameLayout = this.binding.a;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            Toast.makeText(frameLayout.getContext(), 2131887565, 0).show();
        }
    }

    private final void handleOnClickForPermissionOwner(PermissionOwner permissionOwner) {
        Function2 function2Access$getOnClickListener$p = AddMemberAdapter.access$getOnClickListener$p((AddMemberAdapter) this.adapter);
        if (function2Access$getOnClickListener$p != null) {
            if (permissionOwner instanceof PermissionOwner$Member) {
                function2Access$getOnClickListener$p.invoke(Long.valueOf(((PermissionOwner$Member) permissionOwner).getUser().getId()), PermissionOverwrite$Type.MEMBER);
            } else if (permissionOwner instanceof PermissionOwner$Role) {
                function2Access$getOnClickListener$p.invoke(Long.valueOf(((PermissionOwner$Role) permissionOwner).getRole().getId()), PermissionOverwrite$Type.ROLE);
            }
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, AddMemberAdapter$Item addMemberAdapter$Item) {
        onConfigure2(i, addMemberAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, AddMemberAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        AddMemberAdapter$Item$PermissionOwnerItem addMemberAdapter$Item$PermissionOwnerItem = (AddMemberAdapter$Item$PermissionOwnerItem) data;
        this.binding.f2271b.a(addMemberAdapter$Item$PermissionOwnerItem.getPermissionOwner());
        MaterialCheckBox materialCheckBox = this.binding.c;
        m.checkNotNullExpressionValue(materialCheckBox, "binding.checkbox");
        materialCheckBox.setChecked(addMemberAdapter$Item$PermissionOwnerItem.getChecked());
        this.binding.c.setOnClickListener(new AddMemberAdapter$AddMemberAdapterItemItem$onConfigure$1(this, addMemberAdapter$Item$PermissionOwnerItem));
        this.binding.d.setOnClickListener(new AddMemberAdapter$AddMemberAdapterItemItem$onConfigure$2(this, addMemberAdapter$Item$PermissionOwnerItem));
        ConstraintLayout constraintLayout = this.binding.d;
        m.checkNotNullExpressionValue(constraintLayout, "binding.container");
        ViewExtensions.setEnabledAlpha$default(constraintLayout, m.areEqual(addMemberAdapter$Item$PermissionOwnerItem.getAddStatus(), AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus$CanAdd.INSTANCE), 0.0f, 2, null);
    }
}
