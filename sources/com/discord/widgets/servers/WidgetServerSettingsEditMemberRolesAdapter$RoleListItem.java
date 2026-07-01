package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import com.discord.R$layout;
import com.discord.api.role.GuildRole;
import com.discord.databinding.ViewCheckableRoleListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMemberRolesAdapter$RoleListItem extends MGRecyclerViewHolder<WidgetServerSettingsEditMemberRolesAdapter, WidgetServerSettingsEditMemberRolesAdapter$RoleItem> {
    private final ViewCheckableRoleListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditMemberRolesAdapter$RoleListItem(WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter) {
        super(R$layout.view_checkable_role_list_item, widgetServerSettingsEditMemberRolesAdapter);
        m.checkNotNullParameter(widgetServerSettingsEditMemberRolesAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        CheckedSetting checkedSetting = (CheckedSetting) view;
        ViewCheckableRoleListItemBinding viewCheckableRoleListItemBinding = new ViewCheckableRoleListItemBinding(checkedSetting, checkedSetting);
        m.checkNotNullExpressionValue(viewCheckableRoleListItemBinding, "ViewCheckableRoleListItemBinding.bind(itemView)");
        this.binding = viewCheckableRoleListItemBinding;
    }

    public static final /* synthetic */ WidgetServerSettingsEditMemberRolesAdapter access$getAdapter$p(WidgetServerSettingsEditMemberRolesAdapter$RoleListItem widgetServerSettingsEditMemberRolesAdapter$RoleListItem) {
        return (WidgetServerSettingsEditMemberRolesAdapter) widgetServerSettingsEditMemberRolesAdapter$RoleListItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetServerSettingsEditMemberRolesAdapter$RoleItem widgetServerSettingsEditMemberRolesAdapter$RoleItem) {
        onConfigure2(i, widgetServerSettingsEditMemberRolesAdapter$RoleItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetServerSettingsEditMemberRolesAdapter$RoleItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.binding.f2179b.setText(data.getRole().getName());
        CheckedSetting checkedSetting = this.binding.f2179b;
        GuildRole role = data.getRole();
        CheckedSetting checkedSetting2 = this.binding.f2179b;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.roleItemCheckedSetting");
        Context context = checkedSetting2.getContext();
        m.checkNotNullExpressionValue(context, "binding.roleItemCheckedSetting.context");
        checkedSetting.setTextColor(RoleUtils.getRoleColor$default(role, context, null, 2, null));
        CheckedSetting checkedSetting3 = this.binding.f2179b;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.roleItemCheckedSetting");
        checkedSetting3.setChecked(data.isUserHasRole());
        if (data.isManageable()) {
            this.binding.f2179b.e(new WidgetServerSettingsEditMemberRolesAdapter$RoleListItem$onConfigure$1(this, data));
        } else if (data.isRoleManaged()) {
            this.binding.f2179b.b(2131892701);
        } else {
            CheckedSetting.d(this.binding.f2179b, null, 1);
        }
    }
}
