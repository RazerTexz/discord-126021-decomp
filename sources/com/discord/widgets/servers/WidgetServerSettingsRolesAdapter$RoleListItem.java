package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.role.GuildRole;
import com.discord.databinding.WidgetServerSettingsRoleItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload;
import com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.roles.RoleIconView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter$RoleListItem extends MGRecyclerViewHolder<MGRecyclerAdapter<DragAndDropAdapter$Payload>, DragAndDropAdapter$Payload> implements DragAndDropHelper$DraggableViewHolder {
    private final WidgetServerSettingsRoleItemBinding binding;
    private boolean canDrag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRolesAdapter$RoleListItem(WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter) {
        super(R$layout.widget_server_settings_role_item, widgetServerSettingsRolesAdapter);
        m.checkNotNullParameter(widgetServerSettingsRolesAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.server_settings_role_item_bottom_divider;
        View viewFindViewById = view.findViewById(R$id.server_settings_role_item_bottom_divider);
        if (viewFindViewById != null) {
            i = R$id.server_settings_role_item_divider_targeted;
            View viewFindViewById2 = view.findViewById(R$id.server_settings_role_item_divider_targeted);
            if (viewFindViewById2 != null) {
                i = R$id.server_settings_role_item_drag_overlay;
                View viewFindViewById3 = view.findViewById(R$id.server_settings_role_item_drag_overlay);
                if (viewFindViewById3 != null) {
                    i = R$id.server_settings_role_item_lock_indicator;
                    ImageView imageView = (ImageView) view.findViewById(R$id.server_settings_role_item_lock_indicator);
                    if (imageView != null) {
                        i = R$id.server_settings_role_item_name;
                        TextView textView = (TextView) view.findViewById(R$id.server_settings_role_item_name);
                        if (textView != null) {
                            i = R$id.server_settings_role_item_role_icon;
                            RoleIconView roleIconView = (RoleIconView) view.findViewById(R$id.server_settings_role_item_role_icon);
                            if (roleIconView != null) {
                                WidgetServerSettingsRoleItemBinding widgetServerSettingsRoleItemBinding = new WidgetServerSettingsRoleItemBinding((RelativeLayout) view, viewFindViewById, viewFindViewById2, viewFindViewById3, imageView, textView, roleIconView);
                                m.checkNotNullExpressionValue(widgetServerSettingsRoleItemBinding, "WidgetServerSettingsRoleItemBinding.bind(itemView)");
                                this.binding = widgetServerSettingsRoleItemBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ MGRecyclerAdapter access$getAdapter$p(WidgetServerSettingsRolesAdapter$RoleListItem widgetServerSettingsRolesAdapter$RoleListItem) {
        return widgetServerSettingsRolesAdapter$RoleListItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder
    /* JADX INFO: renamed from: canDrag, reason: from getter */
    public boolean getCanDrag() {
        return this.canDrag;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, DragAndDropAdapter$Payload dragAndDropAdapter$Payload) {
        onConfigure2(i, dragAndDropAdapter$Payload);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder
    public void onDragStateChanged(boolean dragging) {
        View view = this.binding.f2583b;
        m.checkNotNullExpressionValue(view, "binding.serverSettingsRoleItemDragOverlay");
        view.setVisibility(dragging ? 0 : 8);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, DragAndDropAdapter$Payload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetServerSettingsRolesAdapter$RoleItem widgetServerSettingsRolesAdapter$RoleItem = (WidgetServerSettingsRolesAdapter$RoleItem) data;
        this.canDrag = widgetServerSettingsRolesAdapter$RoleItem.canReorder();
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsRoleItemName");
        textView.setText(widgetServerSettingsRolesAdapter$RoleItem.getRole().getName());
        TextView textView2 = this.binding.d;
        GuildRole role = widgetServerSettingsRolesAdapter$RoleItem.getRole();
        RelativeLayout relativeLayout = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout, "binding.root");
        Context context = relativeLayout.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        textView2.setTextColor(RoleUtils.getRoleColor$default(role, context, null, 2, null));
        this.binding.a.setOnClickListener(new WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$1(this, widgetServerSettingsRolesAdapter$RoleItem));
        if (widgetServerSettingsRolesAdapter$RoleItem.getEveryoneRole()) {
            RelativeLayout relativeLayout2 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout2, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout2, WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$2.INSTANCE);
        } else if (!widgetServerSettingsRolesAdapter$RoleItem.getUserAbleToManageRoles()) {
            RelativeLayout relativeLayout3 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout3, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout3, WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$3.INSTANCE);
        } else if (widgetServerSettingsRolesAdapter$RoleItem.getElevated()) {
            this.binding.a.setOnLongClickListener(null);
        } else {
            RelativeLayout relativeLayout4 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout4, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout4, WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$4.INSTANCE);
        }
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.serverSettingsRoleItemLockIndicator");
        imageView.setVisibility(widgetServerSettingsRolesAdapter$RoleItem.getLocked() ? 0 : 8);
        this.binding.e.setRole(widgetServerSettingsRolesAdapter$RoleItem.getRole(), Long.valueOf(widgetServerSettingsRolesAdapter$RoleItem.getGuildId()));
    }
}
