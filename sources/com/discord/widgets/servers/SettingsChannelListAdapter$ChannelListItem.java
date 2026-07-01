package com.discord.widgets.servers;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.SettingsChannelListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload;
import com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsChannelListAdapter$ChannelListItem extends MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter$Payload> implements DragAndDropHelper$DraggableViewHolder {
    private final SettingsChannelListItemBinding binding;
    private SettingsChannelListAdapter$ChannelItem channelItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsChannelListAdapter$ChannelListItem(SettingsChannelListAdapter settingsChannelListAdapter) {
        super(R$layout.settings_channel_list_item, settingsChannelListAdapter);
        m.checkNotNullParameter(settingsChannelListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.settings_channel_list_item_drag;
        ImageView imageView = (ImageView) view.findViewById(R$id.settings_channel_list_item_drag);
        if (imageView != null) {
            i = R$id.settings_channel_list_item_hash;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.settings_channel_list_item_hash);
            if (imageView2 != null) {
                i = R$id.settings_channel_list_item_name;
                TextView textView = (TextView) view.findViewById(R$id.settings_channel_list_item_name);
                if (textView != null) {
                    i = R$id.settings_channel_list_item_selected_overlay;
                    View viewFindViewById = view.findViewById(R$id.settings_channel_list_item_selected_overlay);
                    if (viewFindViewById != null) {
                        SettingsChannelListItemBinding settingsChannelListItemBinding = new SettingsChannelListItemBinding((RelativeLayout) view, imageView, imageView2, textView, viewFindViewById);
                        m.checkNotNullExpressionValue(settingsChannelListItemBinding, "SettingsChannelListItemBinding.bind(itemView)");
                        this.binding = settingsChannelListItemBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder
    public boolean canDrag() {
        SettingsChannelListAdapter$ChannelItem settingsChannelListAdapter$ChannelItem = this.channelItem;
        return settingsChannelListAdapter$ChannelItem != null && settingsChannelListAdapter$ChannelItem.isDraggable() && settingsChannelListAdapter$ChannelItem.getCanManageCategoryOfChannel();
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, CategoricalDragAndDropAdapter$Payload categoricalDragAndDropAdapter$Payload) {
        onConfigure2(i, categoricalDragAndDropAdapter$Payload);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper$DraggableViewHolder
    public void onDragStateChanged(boolean dragging) {
        View view = this.binding.e;
        m.checkNotNullExpressionValue(view, "binding.settingsChannelListItemSelectedOverlay");
        view.setVisibility(dragging ? 0 : 8);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, CategoricalDragAndDropAdapter$Payload data) {
        int i;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        SettingsChannelListAdapter$ChannelItem settingsChannelListAdapter$ChannelItem = (SettingsChannelListAdapter$ChannelItem) data;
        this.channelItem = settingsChannelListAdapter$ChannelItem;
        if (settingsChannelListAdapter$ChannelItem != null) {
            this.itemView.setOnClickListener(null);
            Function1<Long, Unit> onClickListener = ((SettingsChannelListAdapter) this.adapter).getOnClickListener();
            if (onClickListener != null) {
                this.itemView.setOnClickListener(new SettingsChannelListAdapter$ChannelListItem$onConfigure$$inlined$let$lambda$1(onClickListener, settingsChannelListAdapter$ChannelItem, this));
            }
            ImageView imageView = this.binding.c;
            int type = settingsChannelListAdapter$ChannelItem.getChannel().getType();
            if (type == 2) {
                i = 2131231639;
            } else if (type != 5) {
                i = type != 13 ? 2131231630 : 2131231625;
            } else {
                i = 2131231611;
            }
            imageView.setImageResource(i);
            TextView textView = this.binding.d;
            m.checkNotNullExpressionValue(textView, "binding.settingsChannelListItemName");
            textView.setText(ChannelUtils.c(settingsChannelListAdapter$ChannelItem.getChannel()));
            ImageView imageView2 = this.binding.f2141b;
            m.checkNotNullExpressionValue(imageView2, "binding.settingsChannelListItemDrag");
            imageView2.setVisibility(canDrag() ? 0 : 8);
        }
    }
}
