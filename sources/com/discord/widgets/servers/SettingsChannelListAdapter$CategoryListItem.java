package com.discord.widgets.servers;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.SettingsChannelListCategoryItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload;
import com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsChannelListAdapter$CategoryListItem extends MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter$Payload> implements DragAndDropHelper$DraggableViewHolder {
    private final SettingsChannelListCategoryItemBinding binding;
    private SettingsChannelListAdapter$CategoryItem categoryItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsChannelListAdapter$CategoryListItem(SettingsChannelListAdapter settingsChannelListAdapter) {
        super(R$layout.settings_channel_list_category_item, settingsChannelListAdapter);
        m.checkNotNullParameter(settingsChannelListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.settings_channel_list_category_item_drag;
        ImageView imageView = (ImageView) view.findViewById(R$id.settings_channel_list_category_item_drag);
        if (imageView != null) {
            i = R$id.settings_channel_list_category_item_text;
            TextView textView = (TextView) view.findViewById(R$id.settings_channel_list_category_item_text);
            if (textView != null) {
                SettingsChannelListCategoryItemBinding settingsChannelListCategoryItemBinding = new SettingsChannelListCategoryItemBinding((RelativeLayout) view, imageView, textView);
                m.checkNotNullExpressionValue(settingsChannelListCategoryItemBinding, "SettingsChannelListCateg…temBinding.bind(itemView)");
                this.binding = settingsChannelListCategoryItemBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder
    public boolean canDrag() {
        SettingsChannelListAdapter$CategoryItem settingsChannelListAdapter$CategoryItem = this.categoryItem;
        return settingsChannelListAdapter$CategoryItem != null && settingsChannelListAdapter$CategoryItem.isDraggable() && settingsChannelListAdapter$CategoryItem.getCanManageCategory();
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, CategoricalDragAndDropAdapter$Payload categoricalDragAndDropAdapter$Payload) {
        onConfigure2(i, categoricalDragAndDropAdapter$Payload);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder
    public void onDragStateChanged(boolean dragging) {
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, CategoricalDragAndDropAdapter$Payload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        SettingsChannelListAdapter$CategoryItem settingsChannelListAdapter$CategoryItem = (SettingsChannelListAdapter$CategoryItem) data;
        this.categoryItem = settingsChannelListAdapter$CategoryItem;
        if (settingsChannelListAdapter$CategoryItem != null) {
            Function1<Long, Unit> onClickListener = ((SettingsChannelListAdapter) this.adapter).getOnClickListener();
            if (onClickListener != null) {
                this.itemView.setOnClickListener(new SettingsChannelListAdapter$CategoryListItem$onConfigure$$inlined$let$lambda$1(onClickListener, settingsChannelListAdapter$CategoryItem, this));
            }
            TextView textView = this.binding.c;
            m.checkNotNullExpressionValue(textView, "binding.settingsChannelListCategoryItemText");
            String name = settingsChannelListAdapter$CategoryItem.getName();
            if (name == null) {
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                name = view.getContext().getString(2131896571);
            }
            textView.setText(name);
            ImageView imageView = this.binding.f2140b;
            m.checkNotNullExpressionValue(imageView, "binding.settingsChannelListCategoryItemDrag");
            imageView.setVisibility(canDrag() ? 0 : 8);
        }
    }
}
