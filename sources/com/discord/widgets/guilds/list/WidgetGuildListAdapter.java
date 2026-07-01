package com.discord.widgets.guilds.list;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: WidgetGuildListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildListAdapter extends RecyclerView$Adapter<GuildListViewHolder> implements GuildsDragAndDropCallback$Controller {
    public static final WidgetGuildListAdapter$Companion Companion = new WidgetGuildListAdapter$Companion(null);
    private static final float NEAR_CENTER_PERCENTAGE = 0.2f;
    private int bottomNavHeight;
    private final Rect boundingBoxRect;
    private GuildListViewHolder draggingItem;
    private final WidgetGuildListAdapter$InteractionListener interactionListener;
    private List<? extends GuildListItem> items;
    private final LinearLayoutManager layoutManager;
    private int selectedCenterY;
    private int targetCenterY;

    public WidgetGuildListAdapter(LinearLayoutManager linearLayoutManager, WidgetGuildListAdapter$InteractionListener widgetGuildListAdapter$InteractionListener) {
        m.checkNotNullParameter(linearLayoutManager, "layoutManager");
        m.checkNotNullParameter(widgetGuildListAdapter$InteractionListener, "interactionListener");
        this.layoutManager = linearLayoutManager;
        this.interactionListener = widgetGuildListAdapter$InteractionListener;
        this.items = n.emptyList();
        this.boundingBoxRect = new Rect();
    }

    public static final /* synthetic */ WidgetGuildListAdapter$InteractionListener access$getInteractionListener$p(WidgetGuildListAdapter widgetGuildListAdapter) {
        return widgetGuildListAdapter.interactionListener;
    }

    private final WidgetGuildListAdapter$createDiffUtilCallback$1 createDiffUtilCallback(List<? extends GuildListItem> oldItems, List<? extends GuildListItem> newItems) {
        return new WidgetGuildListAdapter$createDiffUtilCallback$1(oldItems, newItems);
    }

    private final boolean isPendingGuildOperation(GuildListItem sourceItem, GuildListItem targetItem) {
        return ((sourceItem instanceof GuildListItem$GuildItem) && ((GuildListItem$GuildItem) sourceItem).isPendingGuild()) || ((sourceItem instanceof GuildListItem$FolderItem) && ((GuildListItem$FolderItem) sourceItem).getIsPendingGuildsFolder()) || (((targetItem instanceof GuildListItem$GuildItem) && ((GuildListItem$GuildItem) targetItem).isPendingGuild()) || ((targetItem instanceof GuildListItem$FolderItem) && ((GuildListItem$FolderItem) targetItem).getIsPendingGuildsFolder()));
    }

    @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback$Controller
    public RecyclerView$ViewHolder chooseDropTarget(RecyclerView$ViewHolder selected, List<RecyclerView$ViewHolder> dropTargets, int curX, int curY) {
        m.checkNotNullParameter(selected, "selected");
        m.checkNotNullParameter(dropTargets, "dropTargets");
        this.layoutManager.getTransformedBoundingBox(selected.itemView, false, this.boundingBoxRect);
        this.selectedCenterY = this.boundingBoxRect.centerY();
        int i = Integer.MAX_VALUE;
        RecyclerView$ViewHolder recyclerView$ViewHolder = null;
        for (RecyclerView$ViewHolder recyclerView$ViewHolder2 : dropTargets) {
            this.layoutManager.getTransformedBoundingBox(recyclerView$ViewHolder2.itemView, false, this.boundingBoxRect);
            int iCenterY = this.boundingBoxRect.centerY();
            int iAbs = Math.abs(this.selectedCenterY - iCenterY);
            if (iAbs < i) {
                this.targetCenterY = iCenterY;
                recyclerView$ViewHolder = recyclerView$ViewHolder2;
                i = iAbs;
            }
        }
        return recyclerView$ViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public long getItemId(int position) {
        return this.items.get(position).getItemId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        GuildListItem guildListItem = this.items.get(position);
        if (guildListItem instanceof GuildListItem$GuildItem) {
            return 3;
        }
        if (guildListItem instanceof GuildListItem$PrivateChannelItem) {
            return 2;
        }
        if (guildListItem instanceof GuildListItem$UnavailableItem) {
            return 4;
        }
        if (guildListItem instanceof GuildListItem$FriendsItem) {
            return 0;
        }
        if (m.areEqual(guildListItem, GuildListItem$DividerItem.INSTANCE)) {
            return 1;
        }
        if (m.areEqual(guildListItem, GuildListItem$CreateItem.INSTANCE)) {
            return 5;
        }
        if (guildListItem instanceof GuildListItem$HubItem) {
            return 9;
        }
        if (m.areEqual(guildListItem, GuildListItem$HelpItem.INSTANCE)) {
            return 7;
        }
        if (guildListItem instanceof GuildListItem$FolderItem) {
            return 6;
        }
        if (m.areEqual(guildListItem, GuildListItem$SpaceItem.INSTANCE)) {
            return 8;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void handleBottomNavHeight(int height) {
        this.bottomNavHeight = height;
        notifyItemChanged(this.items.lastIndexOf(GuildListItem$SpaceItem.INSTANCE));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((GuildListViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback$Controller
    public void onDragStarted(RecyclerView$ViewHolder viewHolder) {
        m.checkNotNullParameter(viewHolder, "viewHolder");
        GuildListViewHolder guildListViewHolder = (GuildListViewHolder) viewHolder;
        guildListViewHolder.onDragStarted();
        this.draggingItem = guildListViewHolder;
    }

    @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback$Controller
    public void onDrop() {
        boolean zOnDrop = this.interactionListener.onDrop();
        GuildListViewHolder guildListViewHolder = this.draggingItem;
        if (guildListViewHolder != null) {
            guildListViewHolder.onDragEnded(zOnDrop);
        }
        this.draggingItem = null;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:71:0x010f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0132  */
    /* JADX WARN: Code duplicated, block: B:87:0x0134  */
    @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback$Controller
    public boolean onMove(RecyclerView recyclerView, RecyclerView$ViewHolder source, RecyclerView$ViewHolder target) {
        boolean z2;
        boolean z3;
        WidgetGuildListAdapter$Operation widgetGuildListAdapter$Operation$MoveAbove;
        boolean z4;
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(source, "source");
        m.checkNotNullParameter(target, "target");
        this.interactionListener.onItemMoved();
        long itemId = ((GuildListViewHolder) source).getItemId();
        long itemId2 = ((GuildListViewHolder) target).getItemId();
        int i = -1;
        int i2 = 0;
        int i3 = -1;
        for (Object obj : this.items) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                n.throwIndexOverflow();
            }
            GuildListItem guildListItem = (GuildListItem) obj;
            if (guildListItem.getItemId() == itemId) {
                i = i2;
            } else if (guildListItem.getItemId() == itemId2) {
                i3 = i2;
            }
            i2 = i4;
        }
        if (i == -1 || i3 == -1) {
            return false;
        }
        View view = source.itemView;
        m.checkNotNullExpressionValue(view, "source.itemView");
        WidgetGuildListAdapter$TargetPosition widgetGuildListAdapter$TargetPosition = ((float) Math.abs(this.selectedCenterY - this.targetCenterY)) < ((float) view.getHeight()) * 0.2f ? WidgetGuildListAdapter$TargetPosition.CENTER : this.selectedCenterY < this.targetCenterY ? WidgetGuildListAdapter$TargetPosition.TOP : WidgetGuildListAdapter$TargetPosition.BOTTOM;
        GuildListItem guildListItem2 = this.items.get(i);
        GuildListItem guildListItem3 = this.items.get(i3);
        if (guildListItem2 instanceof GuildListItem$GuildItem) {
            boolean z5 = (guildListItem3 instanceof GuildListItem$FolderItem) && !(((GuildListItem$FolderItem) guildListItem3).isOpen() && widgetGuildListAdapter$TargetPosition == WidgetGuildListAdapter$TargetPosition.CENTER);
            if (guildListItem3 instanceof GuildListItem$GuildItem) {
                GuildListItem$GuildItem guildListItem$GuildItem = (GuildListItem$GuildItem) guildListItem3;
                if (guildListItem$GuildItem.isLurkingGuild() || (guildListItem$GuildItem.getFolderId() != null && widgetGuildListAdapter$TargetPosition == WidgetGuildListAdapter$TargetPosition.CENTER)) {
                    z4 = false;
                } else {
                    z4 = true;
                }
            } else {
                z4 = false;
            }
            boolean z6 = (guildListItem3 instanceof GuildListItem$CreateItem) && widgetGuildListAdapter$TargetPosition == WidgetGuildListAdapter$TargetPosition.TOP;
            if (isPendingGuildOperation(guildListItem2, guildListItem3) || !(z5 || z4 || z6)) {
                z3 = false;
            } else {
                z3 = true;
            }
        } else {
            if (!(guildListItem2 instanceof GuildListItem$FolderItem)) {
                throw new IllegalStateException("trying to drag invalid source");
            }
            if (guildListItem3 instanceof GuildListItem$GuildItem) {
                GuildListItem$GuildItem guildListItem$GuildItem2 = (GuildListItem$GuildItem) guildListItem3;
                if (guildListItem$GuildItem2.isLurkingGuild() || guildListItem$GuildItem2.getFolderId() != null || widgetGuildListAdapter$TargetPosition == WidgetGuildListAdapter$TargetPosition.CENTER) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            boolean z7 = (guildListItem3 instanceof GuildListItem$FolderItem) && (widgetGuildListAdapter$TargetPosition == WidgetGuildListAdapter$TargetPosition.TOP || (!((GuildListItem$FolderItem) guildListItem3).isOpen() && widgetGuildListAdapter$TargetPosition == WidgetGuildListAdapter$TargetPosition.BOTTOM));
            if (isPendingGuildOperation(guildListItem2, guildListItem3) || !(z2 || z7)) {
                z3 = false;
            } else {
                z3 = true;
            }
        }
        if (!z3) {
            return false;
        }
        int iOrdinal = widgetGuildListAdapter$TargetPosition.ordinal();
        if (iOrdinal == 0) {
            widgetGuildListAdapter$Operation$MoveAbove = new WidgetGuildListAdapter$Operation$MoveAbove(i, i3);
        } else if (iOrdinal == 1) {
            widgetGuildListAdapter$Operation$MoveAbove = new WidgetGuildListAdapter$Operation$TargetOperation(i, i3);
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            widgetGuildListAdapter$Operation$MoveAbove = new WidgetGuildListAdapter$Operation$MoveBelow(i, i3);
        }
        this.interactionListener.onOperation(widgetGuildListAdapter$Operation$MoveAbove);
        return true;
    }

    public final void setItems(List<? extends GuildListItem> newItems, boolean calculateDiff) {
        m.checkNotNullParameter(newItems, "newItems");
        if (!calculateDiff) {
            this.items = newItems;
            notifyDataSetChanged();
        } else {
            DiffUtil$DiffResult diffUtil$DiffResultCalculateDiff = DiffUtil.calculateDiff(createDiffUtilCallback(this.items, newItems), true);
            m.checkNotNullExpressionValue(diffUtil$DiffResultCalculateDiff, "DiffUtil.calculateDiff(callback, true)");
            this.items = newItems;
            diffUtil$DiffResultCalculateDiff.dispatchUpdatesTo(this);
        }
    }

    public void onBindViewHolder(GuildListViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        GuildListItem guildListItem = this.items.get(position);
        if (guildListItem instanceof GuildListItem$GuildItem) {
            ((GuildListViewHolder$GuildViewHolder) holder).configure((GuildListItem$GuildItem) guildListItem);
            return;
        }
        if (guildListItem instanceof GuildListItem$FriendsItem) {
            ((GuildListViewHolder$FriendsViewHolder) holder).configure((GuildListItem$FriendsItem) guildListItem);
            return;
        }
        if (guildListItem instanceof GuildListItem$PrivateChannelItem) {
            ((GuildListViewHolder$PrivateChannelViewHolder) holder).configure((GuildListItem$PrivateChannelItem) guildListItem);
            return;
        }
        if (guildListItem instanceof GuildListItem$FolderItem) {
            ((GuildListViewHolder$FolderViewHolder) holder).configure((GuildListItem$FolderItem) guildListItem);
            return;
        }
        if ((guildListItem instanceof GuildListItem$UnavailableItem) || (guildListItem instanceof GuildListItem$CreateItem) || (guildListItem instanceof GuildListItem$HelpItem)) {
            holder.itemView.setOnClickListener(new WidgetGuildListAdapter$onBindViewHolder$1(this, holder, guildListItem));
            return;
        }
        if (guildListItem instanceof GuildListItem$HubItem) {
            holder.itemView.setOnClickListener(new WidgetGuildListAdapter$onBindViewHolder$2(this, holder, guildListItem));
            ((GuildListViewHolder$DiscordHubViewHolder) holder).configure((GuildListItem$HubItem) guildListItem);
        } else if (guildListItem instanceof GuildListItem$SpaceItem) {
            ((GuildListViewHolder$SpaceViewHolder) holder).configure(this.bottomNavHeight);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public GuildListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        WidgetGuildListAdapter$onCreateViewHolder$1 widgetGuildListAdapter$onCreateViewHolder$1 = new WidgetGuildListAdapter$onCreateViewHolder$1(parent);
        switch (viewType) {
            case 0:
                View viewInvoke = widgetGuildListAdapter$onCreateViewHolder$1.invoke(R$layout.widget_guilds_list_item_profile);
                m.checkNotNullExpressionValue(viewInvoke, "itemView");
                return new GuildListViewHolder$FriendsViewHolder(viewInvoke, new WidgetGuildListAdapter$onCreateViewHolder$8(this, viewInvoke));
            case 1:
                View viewInvoke2 = widgetGuildListAdapter$onCreateViewHolder$1.invoke(R$layout.widget_guilds_list_item_divider);
                m.checkNotNullExpressionValue(viewInvoke2, "itemView");
                return new GuildListViewHolder$SimpleViewHolder(viewInvoke2);
            case 2:
                View viewInvoke3 = widgetGuildListAdapter$onCreateViewHolder$1.invoke(R$layout.widget_guilds_list_item_dm_vertical);
                m.checkNotNullExpressionValue(viewInvoke3, "itemView");
                return new GuildListViewHolder$PrivateChannelViewHolder(viewInvoke3, new WidgetGuildListAdapter$onCreateViewHolder$6(this, viewInvoke3), new WidgetGuildListAdapter$onCreateViewHolder$7(this, viewInvoke3));
            case 3:
                View viewInvoke4 = widgetGuildListAdapter$onCreateViewHolder$1.invoke(R$layout.widget_guilds_list_item_guild_vertical);
                int themedColor = ColorCompat.getThemedColor(parent.getContext(), 2130968914);
                int themedColor2 = ColorCompat.getThemedColor(parent.getContext(), 2130969989);
                m.checkNotNullExpressionValue(viewInvoke4, "itemView");
                return new GuildListViewHolder$GuildViewHolder(viewInvoke4, themedColor, themedColor2, new WidgetGuildListAdapter$onCreateViewHolder$2(this, viewInvoke4), new WidgetGuildListAdapter$onCreateViewHolder$3(this, viewInvoke4));
            case 4:
                View viewInvoke5 = widgetGuildListAdapter$onCreateViewHolder$1.invoke(R$layout.widget_guilds_list_item_guild_unavailable);
                m.checkNotNullExpressionValue(viewInvoke5, "itemView");
                return new GuildListViewHolder$SimpleViewHolder(viewInvoke5);
            case 5:
                View viewInvoke6 = widgetGuildListAdapter$onCreateViewHolder$1.invoke(R$layout.widget_guilds_list_item_guild_new);
                m.checkNotNullExpressionValue(viewInvoke6, "itemView");
                return new GuildListViewHolder$SimpleViewHolder(viewInvoke6);
            case 6:
                View viewInvoke7 = widgetGuildListAdapter$onCreateViewHolder$1.invoke(R$layout.widget_guilds_list_item_folder);
                m.checkNotNullExpressionValue(viewInvoke7, "itemView");
                return new GuildListViewHolder$FolderViewHolder(viewInvoke7, new WidgetGuildListAdapter$onCreateViewHolder$4(this, viewInvoke7), new WidgetGuildListAdapter$onCreateViewHolder$5(this, viewInvoke7));
            case 7:
                View viewInvoke8 = widgetGuildListAdapter$onCreateViewHolder$1.invoke(R$layout.widget_guilds_list_item_guild_nux);
                m.checkNotNullExpressionValue(viewInvoke8, "itemView");
                return new GuildListViewHolder$SimpleViewHolder(viewInvoke8);
            case 8:
                View viewInvoke9 = widgetGuildListAdapter$onCreateViewHolder$1.invoke(R$layout.recycler_item_bottom_nav_space);
                m.checkNotNullExpressionValue(viewInvoke9, "itemView");
                return new GuildListViewHolder$SpaceViewHolder(viewInvoke9);
            case 9:
                View viewInvoke10 = widgetGuildListAdapter$onCreateViewHolder$1.invoke(R$layout.widget_guilds_list_item_hub_verification);
                m.checkNotNullExpressionValue(viewInvoke10, "itemView");
                return new GuildListViewHolder$DiscordHubViewHolder(viewInvoke10);
            default:
                throw new IllegalStateException(a.q("invalid view type: ", viewType));
        }
    }
}
