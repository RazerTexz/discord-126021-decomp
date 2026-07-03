package com.discord.widgets.servers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppLog;
import com.discord.databinding.SettingsChannelListCategoryItemBinding;
import com.discord.databinding.SettingsChannelListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter;
import com.discord.utilities.mg_recycler.DragAndDropHelper;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsChannelListAdapter extends CategoricalDragAndDropAdapter<CategoricalDragAndDropAdapter.Payload> {
    public static final int TYPE_CATEGORY = 1;
    public static final int TYPE_CHANNEL = 0;
    private Function1<? super Long, Unit> onClickListener;
    private Function1<? super Map<Long, UpdatedPosition>, Unit> onPositionUpdateListener;

    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final /* data */ class CategoryItem implements CategoricalDragAndDropAdapter.Payload {
        private final boolean canManageCategory;
        private final boolean canManageChannelsOfCategory;
        private final long id;
        private final boolean isDraggable;
        private final String key;
        private final String name;
        private final int pos;
        private final int type = 1;

        public CategoryItem(String str, long j, int i, boolean z2, boolean z3, boolean z4) {
            this.name = str;
            this.id = j;
            this.pos = i;
            this.isDraggable = z2;
            this.canManageCategory = z3;
            this.canManageChannelsOfCategory = z4;
            this.key = String.valueOf(j);
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        private final int getPos() {
            return this.pos;
        }

        public static /* synthetic */ CategoryItem copy$default(CategoryItem categoryItem, String str, long j, int i, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = categoryItem.name;
            }
            if ((i2 & 2) != 0) {
                j = categoryItem.id;
            }
            long j2 = j;
            if ((i2 & 4) != 0) {
                i = categoryItem.pos;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                z2 = categoryItem.isDraggable;
            }
            boolean z5 = z2;
            if ((i2 & 16) != 0) {
                z3 = categoryItem.canManageCategory;
            }
            boolean z6 = z3;
            if ((i2 & 32) != 0) {
                z4 = categoryItem.canManageChannelsOfCategory;
            }
            return categoryItem.copy(str, j2, i3, z5, z6, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsDraggable() {
            return this.isDraggable;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getCanManageCategory() {
            return this.canManageCategory;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getCanManageChannelsOfCategory() {
            return this.canManageChannelsOfCategory;
        }

        public final CategoryItem copy(String name, long id2, int pos, boolean isDraggable, boolean canManageCategory, boolean canManageChannelsOfCategory) {
            return new CategoryItem(name, id2, pos, isDraggable, canManageCategory, canManageChannelsOfCategory);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CategoryItem)) {
                return false;
            }
            CategoryItem categoryItem = (CategoryItem) other;
            return C12238m.areEqual(this.name, categoryItem.name) && this.id == categoryItem.id && this.pos == categoryItem.pos && this.isDraggable == categoryItem.isDraggable && this.canManageCategory == categoryItem.canManageCategory && this.canManageChannelsOfCategory == categoryItem.canManageChannelsOfCategory;
        }

        public final boolean getCanManageCategory() {
            return this.canManageCategory;
        }

        public final boolean getCanManageChannelsOfCategory() {
            return this.canManageChannelsOfCategory;
        }

        @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter.Payload
        public String getCategory() {
            return String.valueOf(getType());
        }

        public final long getId() {
            return this.id;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getName() {
            return this.name;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter.Payload
        public int getPosition() {
            return this.pos;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            String str = this.name;
            int iM3a = (((C0002b.m3a(this.id) + ((str != null ? str.hashCode() : 0) * 31)) * 31) + this.pos) * 31;
            boolean z2 = this.isDraggable;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = (iM3a + r0) * 31;
            boolean z3 = this.canManageCategory;
            ?? r1 = z3;
            if (z3) {
                r1 = 1;
            }
            int i2 = (i + r1) * 31;
            boolean z4 = this.canManageChannelsOfCategory;
            return i2 + (z4 ? 1 : z4);
        }

        public final boolean isDraggable() {
            return this.isDraggable;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("CategoryItem(name=");
            sbM833U.append(this.name);
            sbM833U.append(", id=");
            sbM833U.append(this.id);
            sbM833U.append(", pos=");
            sbM833U.append(this.pos);
            sbM833U.append(", isDraggable=");
            sbM833U.append(this.isDraggable);
            sbM833U.append(", canManageCategory=");
            sbM833U.append(this.canManageCategory);
            sbM833U.append(", canManageChannelsOfCategory=");
            return C1643a.m827O(sbM833U, this.canManageChannelsOfCategory, ")");
        }
    }

    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class CategoryListItem extends MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter.Payload> implements DragAndDropHelper.DraggableViewHolder {
        private final SettingsChannelListCategoryItemBinding binding;
        private CategoryItem categoryItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CategoryListItem(SettingsChannelListAdapter settingsChannelListAdapter) {
            super(C5419R.layout.settings_channel_list_category_item, settingsChannelListAdapter);
            C12238m.checkNotNullParameter(settingsChannelListAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.settings_channel_list_category_item_drag;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.settings_channel_list_category_item_drag);
            if (imageView != null) {
                i = C5419R.id.settings_channel_list_category_item_text;
                TextView textView = (TextView) view.findViewById(C5419R.id.settings_channel_list_category_item_text);
                if (textView != null) {
                    SettingsChannelListCategoryItemBinding settingsChannelListCategoryItemBinding = new SettingsChannelListCategoryItemBinding((RelativeLayout) view, imageView, textView);
                    C12238m.checkNotNullExpressionValue(settingsChannelListCategoryItemBinding, "SettingsChannelListCateg…temBinding.bind(itemView)");
                    this.binding = settingsChannelListCategoryItemBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        /* JADX INFO: renamed from: canDrag */
        public boolean getCanDrag() {
            CategoryItem categoryItem = this.categoryItem;
            return categoryItem != null && categoryItem.isDraggable() && categoryItem.getCanManageCategory();
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        public void onDragStateChanged(boolean dragging) {
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, CategoricalDragAndDropAdapter.Payload data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final CategoryItem categoryItem = (CategoryItem) data;
            this.categoryItem = categoryItem;
            if (categoryItem != null) {
                final Function1<Long, Unit> onClickListener = ((SettingsChannelListAdapter) this.adapter).getOnClickListener();
                if (onClickListener != null) {
                    this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.SettingsChannelListAdapter$CategoryListItem$onConfigure$$inlined$let$lambda$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            onClickListener.invoke(Long.valueOf(categoryItem.getId()));
                        }
                    });
                }
                TextView textView = this.binding.f15232c;
                C12238m.checkNotNullExpressionValue(textView, "binding.settingsChannelListCategoryItemText");
                String name = categoryItem.getName();
                if (name == null) {
                    View view = this.itemView;
                    C12238m.checkNotNullExpressionValue(view, "itemView");
                    name = view.getContext().getString(C5419R.string.uncategorized);
                }
                textView.setText(name);
                ImageView imageView = this.binding.f15231b;
                C12238m.checkNotNullExpressionValue(imageView, "binding.settingsChannelListCategoryItemDrag");
                imageView.setVisibility(getCanDrag() ? 0 : 8);
            }
        }
    }

    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final /* data */ class ChannelItem implements CategoricalDragAndDropAdapter.Payload {
        private final boolean canManageCategoryOfChannel;
        private final Channel channel;
        private final boolean isDraggable;
        private final String key;
        private final long parentId;
        private final int type;

        public ChannelItem(Channel channel, boolean z2, long j, boolean z3) {
            C12238m.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.isDraggable = z2;
            this.parentId = j;
            this.canManageCategoryOfChannel = z3;
            this.key = String.valueOf(channel.getId());
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, boolean z2, long j, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            if ((i & 2) != 0) {
                z2 = channelItem.isDraggable;
            }
            boolean z4 = z2;
            if ((i & 4) != 0) {
                j = channelItem.parentId;
            }
            long j2 = j;
            if ((i & 8) != 0) {
                z3 = channelItem.canManageCategoryOfChannel;
            }
            return channelItem.copy(channel, z4, j2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsDraggable() {
            return this.isDraggable;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getParentId() {
            return this.parentId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getCanManageCategoryOfChannel() {
            return this.canManageCategoryOfChannel;
        }

        public final ChannelItem copy(Channel channel, boolean isDraggable, long parentId, boolean canManageCategoryOfChannel) {
            C12238m.checkNotNullParameter(channel, "channel");
            return new ChannelItem(channel, isDraggable, parentId, canManageCategoryOfChannel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelItem)) {
                return false;
            }
            ChannelItem channelItem = (ChannelItem) other;
            return C12238m.areEqual(this.channel, channelItem.channel) && this.isDraggable == channelItem.isDraggable && this.parentId == channelItem.parentId && this.canManageCategoryOfChannel == channelItem.canManageCategoryOfChannel;
        }

        public final boolean getCanManageCategoryOfChannel() {
            return this.canManageCategoryOfChannel;
        }

        @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter.Payload
        public String getCategory() {
            return String.valueOf(getType());
        }

        public final Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final long getParentId() {
            return this.parentId;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter.Payload
        public int getPosition() {
            return this.channel.getPosition();
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.isDraggable;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int iM3a = (C0002b.m3a(this.parentId) + ((iHashCode + r1) * 31)) * 31;
            boolean z3 = this.canManageCategoryOfChannel;
            return iM3a + (z3 ? 1 : z3);
        }

        public final boolean isDraggable() {
            return this.isDraggable;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ChannelItem(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", isDraggable=");
            sbM833U.append(this.isDraggable);
            sbM833U.append(", parentId=");
            sbM833U.append(this.parentId);
            sbM833U.append(", canManageCategoryOfChannel=");
            return C1643a.m827O(sbM833U, this.canManageCategoryOfChannel, ")");
        }
    }

    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class ChannelListItem extends MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter.Payload> implements DragAndDropHelper.DraggableViewHolder {
        private final SettingsChannelListItemBinding binding;
        private ChannelItem channelItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelListItem(SettingsChannelListAdapter settingsChannelListAdapter) {
            super(C5419R.layout.settings_channel_list_item, settingsChannelListAdapter);
            C12238m.checkNotNullParameter(settingsChannelListAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.settings_channel_list_item_drag;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.settings_channel_list_item_drag);
            if (imageView != null) {
                i = C5419R.id.settings_channel_list_item_hash;
                ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.settings_channel_list_item_hash);
                if (imageView2 != null) {
                    i = C5419R.id.settings_channel_list_item_name;
                    TextView textView = (TextView) view.findViewById(C5419R.id.settings_channel_list_item_name);
                    if (textView != null) {
                        i = C5419R.id.settings_channel_list_item_selected_overlay;
                        View viewFindViewById = view.findViewById(C5419R.id.settings_channel_list_item_selected_overlay);
                        if (viewFindViewById != null) {
                            SettingsChannelListItemBinding settingsChannelListItemBinding = new SettingsChannelListItemBinding((RelativeLayout) view, imageView, imageView2, textView, viewFindViewById);
                            C12238m.checkNotNullExpressionValue(settingsChannelListItemBinding, "SettingsChannelListItemBinding.bind(itemView)");
                            this.binding = settingsChannelListItemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        /* JADX INFO: renamed from: canDrag */
        public boolean getCanDrag() {
            ChannelItem channelItem = this.channelItem;
            return channelItem != null && channelItem.isDraggable() && channelItem.getCanManageCategoryOfChannel();
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        public void onDragStateChanged(boolean dragging) {
            View view = this.binding.f15237e;
            C12238m.checkNotNullExpressionValue(view, "binding.settingsChannelListItemSelectedOverlay");
            view.setVisibility(dragging ? 0 : 8);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, CategoricalDragAndDropAdapter.Payload data) {
            int i;
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final ChannelItem channelItem = (ChannelItem) data;
            this.channelItem = channelItem;
            if (channelItem != null) {
                this.itemView.setOnClickListener(null);
                final Function1<Long, Unit> onClickListener = ((SettingsChannelListAdapter) this.adapter).getOnClickListener();
                if (onClickListener != null) {
                    this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.SettingsChannelListAdapter$ChannelListItem$onConfigure$$inlined$let$lambda$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            onClickListener.invoke(Long.valueOf(channelItem.getChannel().getId()));
                        }
                    });
                }
                ImageView imageView = this.binding.f15235c;
                int type = channelItem.getChannel().getType();
                if (type == 2) {
                    i = C5419R.drawable.ic_channel_voice;
                } else if (type != 5) {
                    i = type != 13 ? C5419R.drawable.ic_channel_text : C5419R.drawable.ic_channel_stage_24dp;
                } else {
                    i = C5419R.drawable.ic_channel_announcements;
                }
                imageView.setImageResource(i);
                TextView textView = this.binding.f15236d;
                C12238m.checkNotNullExpressionValue(textView, "binding.settingsChannelListItemName");
                textView.setText(ChannelUtils.m7679c(channelItem.getChannel()));
                ImageView imageView2 = this.binding.f15234b;
                C12238m.checkNotNullExpressionValue(imageView2, "binding.settingsChannelListItemDrag");
                imageView2.setVisibility(getCanDrag() ? 0 : 8);
            }
        }
    }

    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final /* data */ class UpdatedPosition {
        private final Long parentId;
        private final int position;

        public UpdatedPosition(int i, Long l) {
            this.position = i;
            this.parentId = l;
        }

        public static /* synthetic */ UpdatedPosition copy$default(UpdatedPosition updatedPosition, int i, Long l, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = updatedPosition.position;
            }
            if ((i2 & 2) != 0) {
                l = updatedPosition.parentId;
            }
            return updatedPosition.copy(i, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getParentId() {
            return this.parentId;
        }

        public final UpdatedPosition copy(int position, Long parentId) {
            return new UpdatedPosition(position, parentId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatedPosition)) {
                return false;
            }
            UpdatedPosition updatedPosition = (UpdatedPosition) other;
            return this.position == updatedPosition.position && C12238m.areEqual(this.parentId, updatedPosition.parentId);
        }

        public final Long getParentId() {
            return this.parentId;
        }

        public final int getPosition() {
            return this.position;
        }

        public int hashCode() {
            int i = this.position * 31;
            Long l = this.parentId;
            return i + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UpdatedPosition(position=");
            sbM833U.append(this.position);
            sbM833U.append(", parentId=");
            return C1643a.m819G(sbM833U, this.parentId, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$computeChangedPositions$1 */
    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class C91501 extends AbstractC12240o implements Function1<CategoricalDragAndDropAdapter.Payload, Long> {
        public static final C91501 INSTANCE = new C91501();

        public C91501() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Long invoke(CategoricalDragAndDropAdapter.Payload payload) {
            C12238m.checkNotNullParameter(payload, "item");
            int type = payload.getType();
            if (type == 0) {
                return Long.valueOf(((ChannelItem) payload).getChannel().getId());
            }
            if (type == 1) {
                return Long.valueOf(((CategoryItem) payload).getId());
            }
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = C1643a.m833U("Invalid type: ");
            sbM833U.append(payload.getType());
            Logger.e$default(appLog, sbM833U.toString(), null, null, 6, null);
            return null;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$computeChangedPositions$2 */
    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class C91512 extends AbstractC12240o implements Function1<Long, Long> {
        public static final C91512 INSTANCE = new C91512();

        public C91512() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Long l) {
            return invoke(l.longValue());
        }

        public final Long invoke(long j) {
            if (j > 0) {
                return Long.valueOf(j);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$computeChangedPositions$3 */
    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class C91523 extends AbstractC12240o implements Function1<CategoricalDragAndDropAdapter.Payload, Boolean> {
        public static final C91523 INSTANCE = new C91523();

        public C91523() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CategoricalDragAndDropAdapter.Payload payload) {
            return Boolean.valueOf(invoke2(payload));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CategoricalDragAndDropAdapter.Payload payload) {
            C12238m.checkNotNullParameter(payload, "item");
            int type = payload.getType();
            if (type == 0) {
                return ((ChannelItem) payload).getCanManageCategoryOfChannel();
            }
            if (type != 1) {
                return false;
            }
            return ((CategoryItem) payload).getCanManageCategory();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$setPositionUpdateListener$1 */
    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class C91531 extends AbstractC12240o implements Function1<Map<Long, ? extends UpdatedPosition>, Unit> {
        public final /* synthetic */ Action1 $onPositionUpdateListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91531(Action1 action1) {
            super(1);
            this.$onPositionUpdateListener = action1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends UpdatedPosition> map) {
            invoke2((Map<Long, UpdatedPosition>) map);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, UpdatedPosition> map) {
            C12238m.checkNotNullParameter(map, "map");
            this.$onPositionUpdateListener.call(map);
        }
    }

    public /* synthetic */ SettingsChannelListAdapter(RecyclerView recyclerView, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? true : z2);
    }

    private final void handleChangedPositions(Map<Long, Integer> changedPositions, Map<Long, Long> changedParentIds) {
        HashMap map = new HashMap();
        for (Map.Entry<Long, Integer> entry : changedPositions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            map.put(Long.valueOf(jLongValue), new UpdatedPosition(entry.getValue().intValue(), changedParentIds.get(Long.valueOf(jLongValue))));
        }
        Function1<? super Map<Long, UpdatedPosition>, Unit> function1 = this.onPositionUpdateListener;
        if (function1 != null) {
            function1.invoke(map);
        }
    }

    @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter, com.discord.utilities.mg_recycler.DragAndDropAdapter
    public Map<String, Integer> computeChangedPositions() {
        C91501 c91501 = C91501.INSTANCE;
        C91512 c91512 = C91512.INSTANCE;
        C91523 c91523 = C91523.INSTANCE;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int i = 0;
        Long lInvoke = null;
        for (Object obj : getDataCopy()) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            CategoricalDragAndDropAdapter.Payload payload = (CategoricalDragAndDropAdapter.Payload) obj;
            Long lInvoke2 = C91501.INSTANCE.invoke(payload);
            long jLongValue = lInvoke2 != null ? lInvoke2.longValue() : 0L;
            if (payload.getType() == 1) {
                lInvoke = C91512.INSTANCE.invoke(jLongValue);
            }
            Long lInvoke3 = payload.getType() != 0 ? null : C91512.INSTANCE.invoke(((ChannelItem) payload).getParentId());
            Integer num = getOrigPositions().get(payload.getKey());
            if ((num == null || num.intValue() != i) && C91523.INSTANCE.invoke2(payload)) {
                map.put(Long.valueOf(jLongValue), Integer.valueOf(i));
                if ((!C12238m.areEqual(lInvoke3, lInvoke)) && payload.getType() == 0) {
                    map2.put(Long.valueOf(jLongValue), Long.valueOf(lInvoke != null ? lInvoke.longValue() : -1L));
                }
            }
            i = i2;
        }
        handleChangedPositions(map, map2);
        return C12136h0.emptyMap();
    }

    public final Function1<Long, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter, com.discord.utilities.mg_recycler.DragAndDropHelper.Adapter
    public boolean isValidMove(int fromPosition, int toPosition) {
        if (toPosition <= 0) {
            return false;
        }
        CategoricalDragAndDropAdapter.Payload payload = (CategoricalDragAndDropAdapter.Payload) getItem(toPosition - 1);
        int type = payload.getType();
        if (type == 0) {
            return ((ChannelItem) payload).getCanManageCategoryOfChannel();
        }
        if (type != 1) {
            return false;
        }
        return ((CategoryItem) payload).getCanManageChannelsOfCategory();
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter
    public void onNewPositions(Map<String, Integer> newPositions) {
        C12238m.checkNotNullParameter(newPositions, "newPositions");
    }

    public final void setOnClickListener(Function1<? super Long, Unit> function1) {
        this.onClickListener = function1;
    }

    public final void setPositionUpdateListener(Action1<Map<Long, UpdatedPosition>> onPositionUpdateListener) {
        C12238m.checkNotNullParameter(onPositionUpdateListener, "onPositionUpdateListener");
        this.onPositionUpdateListener = new C91531(onPositionUpdateListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsChannelListAdapter(RecyclerView recyclerView, boolean z2) {
        super(recyclerView);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
        if (z2) {
            new ItemTouchHelper(new DragAndDropHelper(this, 0, 2, null)).attachToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter.Payload> onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new ChannelListItem(this);
        }
        if (viewType == 1) {
            return new CategoryListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
