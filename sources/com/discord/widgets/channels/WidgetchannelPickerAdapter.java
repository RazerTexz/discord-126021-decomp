package com.discord.widgets.channels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.databinding.ViewGuildRoleSubscriptionChannelItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetchannelPickerAdapter extends RecyclerView.Adapter<ChannelPickerViewHolder> {
    private static final int VIEW_TYPE_CHANNEL_ITEM = 1;
    private static final int VIEW_TYPE_CREATE_CHANNEL = 0;
    private final DiffCreator<List<ChannelPickerAdapterItem>, ChannelPickerViewHolder> diffCreator;
    private List<? extends ChannelPickerAdapterItem> items;
    private final OnItemClickListener listener;

    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public interface OnItemClickListener {
        void onChannelItemClick(ChannelPickerAdapterItem.ChannelItem channelItem);

        void onCreateChannelClick();
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$onCreateViewHolder$1 */
    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final /* synthetic */ class C74021 extends C12236k implements Function0<Unit> {
        public C74021(OnItemClickListener onItemClickListener) {
            super(0, onItemClickListener, OnItemClickListener.class, "onCreateChannelClick", "onCreateChannelClick()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((OnItemClickListener) this.receiver).onCreateChannelClick();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$onCreateViewHolder$2 */
    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final /* synthetic */ class C74032 extends C12236k implements Function1<ChannelPickerAdapterItem.ChannelItem, Unit> {
        public C74032(OnItemClickListener onItemClickListener) {
            super(1, onItemClickListener, OnItemClickListener.class, "onChannelItemClick", "onChannelItemClick(Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelPickerAdapterItem.ChannelItem channelItem) {
            invoke2(channelItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelPickerAdapterItem.ChannelItem channelItem) {
            C12238m.checkNotNullParameter(channelItem, "p1");
            ((OnItemClickListener) this.receiver).onChannelItemClick(channelItem);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$setItems$1 */
    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final class C74041 extends AbstractC12240o implements Function1<List<? extends ChannelPickerAdapterItem>, Unit> {
        public C74041() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChannelPickerAdapterItem> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ChannelPickerAdapterItem> list) {
            C12238m.checkNotNullParameter(list, "items");
            WidgetchannelPickerAdapter.this.items = list;
        }
    }

    public /* synthetic */ WidgetchannelPickerAdapter(OnItemClickListener onItemClickListener, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(onItemClickListener, appComponent, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ChannelPickerAdapterItem channelPickerAdapterItem = this.items.get(position);
        if (channelPickerAdapterItem instanceof ChannelPickerAdapterItem.CreateChannelItem) {
            return 0;
        }
        if (channelPickerAdapterItem instanceof ChannelPickerAdapterItem.ChannelItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setItems(List<? extends ChannelPickerAdapterItem> newItems) {
        C12238m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new C74041(), this.items, newItems);
    }

    public WidgetchannelPickerAdapter(OnItemClickListener onItemClickListener, AppComponent appComponent, DiffCreator<List<ChannelPickerAdapterItem>, ChannelPickerViewHolder> diffCreator) {
        C12238m.checkNotNullParameter(onItemClickListener, "listener");
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(diffCreator, "diffCreator");
        this.listener = onItemClickListener;
        this.diffCreator = diffCreator;
        this.items = C12147n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ChannelPickerViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        if (holder instanceof ChannelPickerViewHolder.ChannelItemViewHolder) {
            ((ChannelPickerViewHolder.ChannelItemViewHolder) holder).configure(this.items.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ChannelPickerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.view_guild_role_subscription_channel_item, parent, false);
        int i = C5419R.id.channel_item_name;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.channel_item_name);
        if (textView != null) {
            i = C5419R.id.channel_item_selected;
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.channel_item_selected);
            if (imageView != null) {
                i = C5419R.id.channel_item_type_icon;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(C5419R.id.channel_item_type_icon);
                if (imageView2 != null) {
                    ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding = new ViewGuildRoleSubscriptionChannelItemBinding((LinearLayout) viewInflate, textView, imageView, imageView2);
                    C12238m.checkNotNullExpressionValue(viewGuildRoleSubscriptionChannelItemBinding, "ViewGuildRoleSubscriptio…rent,\n        false\n    )");
                    if (viewType == 0) {
                        return new ChannelPickerViewHolder.CreateChannelViewHolder(viewGuildRoleSubscriptionChannelItemBinding, new C74021(this.listener));
                    }
                    if (viewType == 1) {
                        return new ChannelPickerViewHolder.ChannelItemViewHolder(viewGuildRoleSubscriptionChannelItemBinding, new C74032(this.listener));
                    }
                    Context context = parent.getContext();
                    C12238m.checkNotNullExpressionValue(context, "parent.context");
                    throw new IllegalArgumentException(C1107b.m216h(context, C5419R.string.android_unknown_view_holder, new Object[]{Integer.valueOf(viewType)}, null, 4).toString());
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
