package com.discord.widgets.servers;

import android.view.View;
import b.a.k.b;
import com.discord.R$layout;
import com.discord.databinding.WidgetServerSettingsHelpItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload;
import com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter$RoleListHelpItem extends MGRecyclerViewHolder<MGRecyclerAdapter<DragAndDropAdapter$Payload>, DragAndDropAdapter$Payload> implements DragAndDropHelper$DraggableViewHolder {
    private final WidgetServerSettingsHelpItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRolesAdapter$RoleListHelpItem(WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter) {
        super(R$layout.widget_server_settings_help_item, widgetServerSettingsRolesAdapter);
        m.checkNotNullParameter(widgetServerSettingsRolesAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view;
        WidgetServerSettingsHelpItemBinding widgetServerSettingsHelpItemBinding = new WidgetServerSettingsHelpItemBinding(linkifiedTextView, linkifiedTextView);
        m.checkNotNullExpressionValue(widgetServerSettingsHelpItemBinding, "WidgetServerSettingsHelpItemBinding.bind(itemView)");
        this.binding = widgetServerSettingsHelpItemBinding;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder
    /* JADX INFO: renamed from: canDrag */
    public boolean getCanDrag() {
        return false;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, DragAndDropAdapter$Payload dragAndDropAdapter$Payload) {
        onConfigure2(i, dragAndDropAdapter$Payload);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder
    public void onDragStateChanged(boolean dragging) {
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, DragAndDropAdapter$Payload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        LinkifiedTextView linkifiedTextView = this.binding.f2572b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.serverSettingsHelpItem");
        b.m(linkifiedTextView, 2131891709, new Object[0], new WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1(data));
    }
}
