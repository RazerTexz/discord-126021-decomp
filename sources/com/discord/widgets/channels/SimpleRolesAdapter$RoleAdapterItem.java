package com.discord.widgets.channels;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.discord.R$layout;
import com.discord.api.role.GuildRole;
import com.discord.databinding.SimpleRoleListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: SimpleRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleRolesAdapter$RoleAdapterItem extends MGRecyclerViewHolder<SimpleRolesAdapter, SimpleRolesAdapter$RoleItem> {
    private final SimpleRoleListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleRolesAdapter$RoleAdapterItem(SimpleRolesAdapter simpleRolesAdapter) {
        super(R$layout.simple_role_list_item, simpleRolesAdapter);
        m.checkNotNullParameter(simpleRolesAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        SimpleRoleListItemBinding simpleRoleListItemBinding = new SimpleRoleListItemBinding(textView, textView);
        m.checkNotNullExpressionValue(simpleRoleListItemBinding, "SimpleRoleListItemBinding.bind(itemView)");
        this.binding = simpleRoleListItemBinding;
    }

    public static final /* synthetic */ SimpleRolesAdapter access$getAdapter$p(SimpleRolesAdapter$RoleAdapterItem simpleRolesAdapter$RoleAdapterItem) {
        return (SimpleRolesAdapter) simpleRolesAdapter$RoleAdapterItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, SimpleRolesAdapter$RoleItem simpleRolesAdapter$RoleItem) {
        onConfigure2(i, simpleRolesAdapter$RoleItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, SimpleRolesAdapter$RoleItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f2143b;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsRoleItemName");
        textView.setText(data.getRole().getName());
        this.binding.a.setOnClickListener(new SimpleRolesAdapter$RoleAdapterItem$onConfigure$1(this, data));
        TextView textView2 = this.binding.f2143b;
        GuildRole role = data.getRole();
        TextView textView3 = this.binding.f2143b;
        m.checkNotNullExpressionValue(textView3, "binding.serverSettingsRoleItemName");
        Context context = textView3.getContext();
        m.checkNotNullExpressionValue(context, "binding.serverSettingsRoleItemName.context");
        textView2.setTextColor(RoleUtils.getRoleColor$default(role, context, null, 2, null));
    }
}
