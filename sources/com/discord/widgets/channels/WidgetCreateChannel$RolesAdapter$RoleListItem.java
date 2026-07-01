package com.discord.widgets.channels;

import android.content.Context;
import android.view.View;
import com.discord.R$layout;
import com.discord.api.role.GuildRole;
import com.discord.databinding.ViewCheckableRoleListItemThemedBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$RolesAdapter$RoleListItem extends MGRecyclerViewHolder<WidgetCreateChannel$RolesAdapter, SingleTypePayload<GuildRole>> {
    private final ViewCheckableRoleListItemThemedBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateChannel$RolesAdapter$RoleListItem(WidgetCreateChannel$RolesAdapter widgetCreateChannel$RolesAdapter) {
        super(R$layout.view_checkable_role_list_item_themed, widgetCreateChannel$RolesAdapter);
        m.checkNotNullParameter(widgetCreateChannel$RolesAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        CheckedSetting checkedSetting = (CheckedSetting) view;
        ViewCheckableRoleListItemThemedBinding viewCheckableRoleListItemThemedBinding = new ViewCheckableRoleListItemThemedBinding(checkedSetting, checkedSetting);
        m.checkNotNullExpressionValue(viewCheckableRoleListItemThemedBinding, "ViewCheckableRoleListIte…medBinding.bind(itemView)");
        this.binding = viewCheckableRoleListItemThemedBinding;
    }

    public static final /* synthetic */ WidgetCreateChannel$RolesAdapter access$getAdapter$p(WidgetCreateChannel$RolesAdapter$RoleListItem widgetCreateChannel$RolesAdapter$RoleListItem) {
        return (WidgetCreateChannel$RolesAdapter) widgetCreateChannel$RolesAdapter$RoleListItem.adapter;
    }

    public static final /* synthetic */ ViewCheckableRoleListItemThemedBinding access$getBinding$p(WidgetCreateChannel$RolesAdapter$RoleListItem widgetCreateChannel$RolesAdapter$RoleListItem) {
        return widgetCreateChannel$RolesAdapter$RoleListItem.binding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, SingleTypePayload<GuildRole> singleTypePayload) {
        onConfigure2(i, singleTypePayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, SingleTypePayload<GuildRole> data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GuildRole data2 = data.getData();
        boolean zContainsKey = ((WidgetCreateChannel$RolesAdapter) this.adapter).getCheckedRoles().containsKey(Long.valueOf(data2.getId()));
        CheckedSetting checkedSetting = this.binding.f2180b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.roleItemCheckedSetting");
        checkedSetting.setChecked(zContainsKey);
        this.binding.f2180b.e(new WidgetCreateChannel$RolesAdapter$RoleListItem$onConfigure$1(this, data2));
        this.binding.f2180b.setText(data2.getName());
        CheckedSetting checkedSetting2 = this.binding.f2180b;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.roleItemCheckedSetting");
        Context context = checkedSetting2.getContext();
        m.checkNotNullExpressionValue(context, "binding.roleItemCheckedSetting.context");
        checkedSetting2.setTextColor(RoleUtils.getRoleColor$default(data2, context, null, 2, null));
    }
}
