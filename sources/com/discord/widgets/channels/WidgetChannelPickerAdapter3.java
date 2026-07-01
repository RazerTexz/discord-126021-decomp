package com.discord.widgets.channels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.ViewGuildRoleSubscriptionChannelItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.channels.WidgetChannelPickerAdapter;
import com.discord.widgets.channels.WidgetChannelPickerAdapter2;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerAdapter3 extends RecyclerView.Adapter<WidgetChannelPickerAdapter2> {
    private static final int VIEW_TYPE_CHANNEL_ITEM = 1;
    private static final int VIEW_TYPE_CREATE_CHANNEL = 0;
    private final DiffCreator<List<WidgetChannelPickerAdapter>, WidgetChannelPickerAdapter2> diffCreator;
    private List<? extends WidgetChannelPickerAdapter> items;
    private final OnItemClickListener listener;

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$OnItemClickListener */
    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public interface OnItemClickListener {
        void onChannelItemClick(WidgetChannelPickerAdapter.ChannelItem channelItem);

        void onCreateChannelClick();
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$onCreateViewHolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(OnItemClickListener onItemClickListener) {
            super(0, onItemClickListener, OnItemClickListener.class, "onCreateChannelClick", "onCreateChannelClick()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((OnItemClickListener) this.receiver).onCreateChannelClick();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$onCreateViewHolder$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetChannelPickerAdapter.ChannelItem, Unit> {
        public AnonymousClass2(OnItemClickListener onItemClickListener) {
            super(1, onItemClickListener, OnItemClickListener.class, "onChannelItemClick", "onChannelItemClick(Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelPickerAdapter.ChannelItem channelItem) {
            invoke2(channelItem);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelPickerAdapter.ChannelItem channelItem) {
            Intrinsics3.checkNotNullParameter(channelItem, "p1");
            ((OnItemClickListener) this.receiver).onChannelItemClick(channelItem);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$setItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends WidgetChannelPickerAdapter>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetChannelPickerAdapter> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends WidgetChannelPickerAdapter> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            WidgetChannelPickerAdapter3.this.items = list;
        }
    }

    public /* synthetic */ WidgetChannelPickerAdapter3(OnItemClickListener onItemClickListener, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(onItemClickListener, appComponent, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        WidgetChannelPickerAdapter widgetChannelPickerAdapter = this.items.get(position);
        if (widgetChannelPickerAdapter instanceof WidgetChannelPickerAdapter.CreateChannelItem) {
            return 0;
        }
        if (widgetChannelPickerAdapter instanceof WidgetChannelPickerAdapter.ChannelItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setItems(List<? extends WidgetChannelPickerAdapter> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    public WidgetChannelPickerAdapter3(OnItemClickListener onItemClickListener, AppComponent appComponent, DiffCreator<List<WidgetChannelPickerAdapter>, WidgetChannelPickerAdapter2> diffCreator) {
        Intrinsics3.checkNotNullParameter(onItemClickListener, "listener");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.listener = onItemClickListener;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(WidgetChannelPickerAdapter2 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (holder instanceof WidgetChannelPickerAdapter2.ChannelItemViewHolder) {
            ((WidgetChannelPickerAdapter2.ChannelItemViewHolder) holder).configure(this.items.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetChannelPickerAdapter2 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_guild_role_subscription_channel_item, parent, false);
        int i = R.id.channel_item_name;
        TextView textView = (TextView) viewInflate.findViewById(R.id.channel_item_name);
        if (textView != null) {
            i = R.id.channel_item_selected;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.channel_item_selected);
            if (imageView != null) {
                i = R.id.channel_item_type_icon;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.channel_item_type_icon);
                if (imageView2 != null) {
                    ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding = new ViewGuildRoleSubscriptionChannelItemBinding((LinearLayout) viewInflate, textView, imageView, imageView2);
                    Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionChannelItemBinding, "ViewGuildRoleSubscriptio…rent,\n        false\n    )");
                    if (viewType == 0) {
                        return new WidgetChannelPickerAdapter2.CreateChannelViewHolder(viewGuildRoleSubscriptionChannelItemBinding, new AnonymousClass1(this.listener));
                    }
                    if (viewType == 1) {
                        return new WidgetChannelPickerAdapter2.ChannelItemViewHolder(viewGuildRoleSubscriptionChannelItemBinding, new AnonymousClass2(this.listener));
                    }
                    Context context = parent.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "parent.context");
                    throw new IllegalArgumentException(FormatUtils.b(context, R.string.android_unknown_view_holder, new Object[]{Integer.valueOf(viewType)}, (4 & 4) != 0 ? FormatUtils.b.j : null).toString());
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
