package com.discord.widgets.servers;

import a0.a.a.b;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
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
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Action1;

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
            return Intrinsics3.areEqual(this.name, categoryItem.name) && this.id == categoryItem.id && this.pos == categoryItem.pos && this.isDraggable == categoryItem.isDraggable && this.canManageCategory == categoryItem.canManageCategory && this.canManageChannelsOfCategory == categoryItem.canManageChannelsOfCategory;
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
            int iA = (((b.a(this.id) + ((str != null ? str.hashCode() : 0) * 31)) * 31) + this.pos) * 31;
            boolean z2 = this.isDraggable;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = (iA + r0) * 31;
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
            StringBuilder sbU = outline.U("CategoryItem(name=");
            sbU.append(this.name);
            sbU.append(", id=");
            sbU.append(this.id);
            sbU.append(", pos=");
            sbU.append(this.pos);
            sbU.append(", isDraggable=");
            sbU.append(this.isDraggable);
            sbU.append(", canManageCategory=");
            sbU.append(this.canManageCategory);
            sbU.append(", canManageChannelsOfCategory=");
            return outline.O(sbU, this.canManageChannelsOfCategory, ")");
        }
    }

    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class CategoryListItem extends MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter.Payload> implements DragAndDropHelper.DraggableViewHolder {
        private final SettingsChannelListCategoryItemBinding binding;
        private CategoryItem categoryItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CategoryListItem(SettingsChannelListAdapter settingsChannelListAdapter) {
            super(R.layout.settings_channel_list_category_item, settingsChannelListAdapter);
            Intrinsics3.checkNotNullParameter(settingsChannelListAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.settings_channel_list_category_item_drag;
            ImageView imageView = (ImageView) view.findViewById(R.id.settings_channel_list_category_item_drag);
            if (imageView != null) {
                i = R.id.settings_channel_list_category_item_text;
                TextView textView = (TextView) view.findViewById(R.id.settings_channel_list_category_item_text);
                if (textView != null) {
                    SettingsChannelListCategoryItemBinding settingsChannelListCategoryItemBinding = new SettingsChannelListCategoryItemBinding((RelativeLayout) view, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(settingsChannelListCategoryItemBinding, "SettingsChannelListCateg…temBinding.bind(itemView)");
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
            Intrinsics3.checkNotNullParameter(data, "data");
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
                TextView textView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsChannelListCategoryItemText");
                String name = categoryItem.getName();
                if (name == null) {
                    View view = this.itemView;
                    Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                    name = view.getContext().getString(R.string.uncategorized);
                }
                textView.setText(name);
                ImageView imageView = this.binding.f2140b;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.settingsChannelListCategoryItemDrag");
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
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            return Intrinsics3.areEqual(this.channel, channelItem.channel) && this.isDraggable == channelItem.isDraggable && this.parentId == channelItem.parentId && this.canManageCategoryOfChannel == channelItem.canManageCategoryOfChannel;
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
            int iA = (b.a(this.parentId) + ((iHashCode + r1) * 31)) * 31;
            boolean z3 = this.canManageCategoryOfChannel;
            return iA + (z3 ? 1 : z3);
        }

        public final boolean isDraggable() {
            return this.isDraggable;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(", isDraggable=");
            sbU.append(this.isDraggable);
            sbU.append(", parentId=");
            sbU.append(this.parentId);
            sbU.append(", canManageCategoryOfChannel=");
            return outline.O(sbU, this.canManageCategoryOfChannel, ")");
        }
    }

    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class ChannelListItem extends MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter.Payload> implements DragAndDropHelper.DraggableViewHolder {
        private final SettingsChannelListItemBinding binding;
        private ChannelItem channelItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelListItem(SettingsChannelListAdapter settingsChannelListAdapter) {
            super(R.layout.settings_channel_list_item, settingsChannelListAdapter);
            Intrinsics3.checkNotNullParameter(settingsChannelListAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.settings_channel_list_item_drag;
            ImageView imageView = (ImageView) view.findViewById(R.id.settings_channel_list_item_drag);
            if (imageView != null) {
                i = R.id.settings_channel_list_item_hash;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.settings_channel_list_item_hash);
                if (imageView2 != null) {
                    i = R.id.settings_channel_list_item_name;
                    TextView textView = (TextView) view.findViewById(R.id.settings_channel_list_item_name);
                    if (textView != null) {
                        i = R.id.settings_channel_list_item_selected_overlay;
                        View viewFindViewById = view.findViewById(R.id.settings_channel_list_item_selected_overlay);
                        if (viewFindViewById != null) {
                            SettingsChannelListItemBinding settingsChannelListItemBinding = new SettingsChannelListItemBinding((RelativeLayout) view, imageView, imageView2, textView, viewFindViewById);
                            Intrinsics3.checkNotNullExpressionValue(settingsChannelListItemBinding, "SettingsChannelListItemBinding.bind(itemView)");
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
            View view = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.settingsChannelListItemSelectedOverlay");
            view.setVisibility(dragging ? 0 : 8);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, CategoricalDragAndDropAdapter.Payload data) {
            int i;
            Intrinsics3.checkNotNullParameter(data, "data");
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
                ImageView imageView = this.binding.c;
                int type = channelItem.getChannel().getType();
                if (type == 2) {
                    i = R.drawable.ic_channel_voice;
                } else if (type != 5) {
                    i = type != 13 ? R.drawable.ic_channel_text : R.drawable.ic_channel_stage_24dp;
                } else {
                    i = R.drawable.ic_channel_announcements;
                }
                imageView.setImageResource(i);
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsChannelListItemName");
                textView.setText(ChannelUtils.c(channelItem.getChannel()));
                ImageView imageView2 = this.binding.f2141b;
                Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.settingsChannelListItemDrag");
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
            return this.position == updatedPosition.position && Intrinsics3.areEqual(this.parentId, updatedPosition.parentId);
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
            StringBuilder sbU = outline.U("UpdatedPosition(position=");
            sbU.append(this.position);
            sbU.append(", parentId=");
            return outline.G(sbU, this.parentId, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$computeChangedPositions$1, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<CategoricalDragAndDropAdapter.Payload, Long> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Long invoke(CategoricalDragAndDropAdapter.Payload payload) {
            Intrinsics3.checkNotNullParameter(payload, "item");
            int type = payload.getType();
            if (type == 0) {
                return Long.valueOf(((ChannelItem) payload).getChannel().getId());
            }
            if (type == 1) {
                return Long.valueOf(((CategoryItem) payload).getId());
            }
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("Invalid type: ");
            sbU.append(payload.getType());
            Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
            return null;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$computeChangedPositions$2, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Long> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
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

    /* JADX INFO: renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$computeChangedPositions$3, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<CategoricalDragAndDropAdapter.Payload, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CategoricalDragAndDropAdapter.Payload payload) {
            return Boolean.valueOf(invoke2(payload));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CategoricalDragAndDropAdapter.Payload payload) {
            Intrinsics3.checkNotNullParameter(payload, "item");
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

    /* JADX INFO: renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$setPositionUpdateListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Map<Long, ? extends UpdatedPosition>, Unit> {
        public final /* synthetic */ Action1 $onPositionUpdateListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Action1 action1) {
            super(1);
            this.$onPositionUpdateListener = action1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends UpdatedPosition> map) {
            invoke2((Map<Long, UpdatedPosition>) map);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, UpdatedPosition> map) {
            Intrinsics3.checkNotNullParameter(map, "map");
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
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        AnonymousClass3 anonymousClass3 = AnonymousClass3.INSTANCE;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int i = 0;
        Long lInvoke = null;
        for (Object obj : getDataCopy()) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            CategoricalDragAndDropAdapter.Payload payload = (CategoricalDragAndDropAdapter.Payload) obj;
            Long lInvoke2 = AnonymousClass1.INSTANCE.invoke(payload);
            long jLongValue = lInvoke2 != null ? lInvoke2.longValue() : 0L;
            if (payload.getType() == 1) {
                lInvoke = AnonymousClass2.INSTANCE.invoke(jLongValue);
            }
            Long lInvoke3 = payload.getType() != 0 ? null : AnonymousClass2.INSTANCE.invoke(((ChannelItem) payload).getParentId());
            Integer num = getOrigPositions().get(payload.getKey());
            if ((num == null || num.intValue() != i) && AnonymousClass3.INSTANCE.invoke2(payload)) {
                map.put(Long.valueOf(jLongValue), Integer.valueOf(i));
                if ((!Intrinsics3.areEqual(lInvoke3, lInvoke)) && payload.getType() == 0) {
                    map2.put(Long.valueOf(jLongValue), Long.valueOf(lInvoke != null ? lInvoke.longValue() : -1L));
                }
            }
            i = i2;
        }
        handleChangedPositions(map, map2);
        return Maps6.emptyMap();
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
        Intrinsics3.checkNotNullParameter(newPositions, "newPositions");
    }

    public final void setOnClickListener(Function1<? super Long, Unit> function1) {
        this.onClickListener = function1;
    }

    public final void setPositionUpdateListener(Action1<Map<Long, UpdatedPosition>> onPositionUpdateListener) {
        Intrinsics3.checkNotNullParameter(onPositionUpdateListener, "onPositionUpdateListener");
        this.onPositionUpdateListener = new AnonymousClass1(onPositionUpdateListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsChannelListAdapter(RecyclerView recyclerView, boolean z2) {
        super(recyclerView);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        if (z2) {
            new ItemTouchHelper(new DragAndDropHelper(this, 0, 2, null)).attachToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter.Payload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new ChannelListItem(this);
        }
        if (viewType == 1) {
            return new CategoryListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
