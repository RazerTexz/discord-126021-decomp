package com.discord.widgets.user.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.WidgetGlobalSearchItemGuildBinding;
import com.discord.databinding.WidgetGuildsListItemDmBinding;
import com.discord.databinding.WidgetGuildsListItemGuildBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter extends MGRecyclerAdapterSimple<WidgetGlobalSearchGuildsModel.Item> {
    private Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> onClickListener;
    private Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> onLongClickListener;
    private final int overlayColor;

    /* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    public static abstract class Item extends MGRecyclerViewHolder<WidgetGlobalSearchGuildsAdapter, WidgetGlobalSearchGuildsModel.Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(@LayoutRes int i, WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter) {
            super(i, widgetGlobalSearchGuildsAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
        }

        public static final /* synthetic */ WidgetGlobalSearchGuildsAdapter access$getAdapter$p(Item item) {
            return (WidgetGlobalSearchGuildsAdapter) item.adapter;
        }

        public final void configureMentionsCount(TextView textView, int count) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            if (count < 1) {
                ViewExtensions.setTextAndVisibilityBy(textView, null);
                textView.setContentDescription(null);
                return;
            }
            textView.setVisibility(0);
            textView.setText(String.valueOf(count));
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            textView.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context, R.attr.overlay_guild_mentions_primary_630, 0, 2, (Object) null));
            textView.setContentDescription(FormatUtils.b(context, R.string.mentions_count, new Object[]{String.valueOf(count)}, (4 & 4) != 0 ? FormatUtils.b.j : null));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(final int position, final WidgetGlobalSearchGuildsModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter$Item$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGlobalSearchGuildsAdapter.Item.access$getAdapter$p(this.this$0).getOnClickListener().invoke(Integer.valueOf(this.this$0.getItemViewType()), Integer.valueOf(position), data);
                }
            });
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetGlobalSearchGuildsAdapter3(this, position, data));
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    public static final class ItemDirectMessage extends Item {
        private final WidgetGuildsListItemDmBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemDirectMessage(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i) {
            super(i, widgetGlobalSearchGuildsAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
            WidgetGuildsListItemDmBinding widgetGuildsListItemDmBindingA = WidgetGuildsListItemDmBinding.a(this.itemView);
            Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemDmBindingA, "WidgetGuildsListItemDmBinding.bind(itemView)");
            this.binding = widgetGuildsListItemDmBindingA;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, WidgetGlobalSearchGuildsModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildsItemDmCount");
            configureMentionsCount(textView, data.getMentionCount());
            SimpleDraweeView simpleDraweeView = this.binding.f2459b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildsItemDmAvatar");
            IconUtils.setIcon$default(simpleDraweeView, data.getChannel(), R.dimen.avatar_size_large, (MGImages.ChangeDetector) null, 8, (Object) null);
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    public static final class ItemDivider extends Item {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemDivider(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i) {
            super(i, widgetGlobalSearchGuildsAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    public static final class ItemGuild extends Item {
        private final WidgetGlobalSearchItemGuildBinding binding;
        private final WidgetGuildsListItemGuildBinding bindingGuild;
        private final int overlayColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemGuild(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i, @ColorInt int i2) {
            super(i, widgetGlobalSearchGuildsAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
            this.overlayColor = i2;
            View view = this.itemView;
            int i3 = R.id.guilds_item_selected;
            ImageView imageView = (ImageView) view.findViewById(R.id.guilds_item_selected);
            if (imageView != null) {
                i3 = R.id.guilds_item_unread;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.guilds_item_unread);
                if (imageView2 != null) {
                    WidgetGlobalSearchItemGuildBinding widgetGlobalSearchItemGuildBinding = new WidgetGlobalSearchItemGuildBinding((RelativeLayout) view, imageView, imageView2);
                    Intrinsics3.checkNotNullExpressionValue(widgetGlobalSearchItemGuildBinding, "WidgetGlobalSearchItemGuildBinding.bind(itemView)");
                    this.binding = widgetGlobalSearchItemGuildBinding;
                    WidgetGuildsListItemGuildBinding widgetGuildsListItemGuildBindingA = WidgetGuildsListItemGuildBinding.a(this.itemView);
                    Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemGuildBindingA, "WidgetGuildsListItemGuildBinding.bind(itemView)");
                    this.bindingGuild = widgetGuildsListItemGuildBindingA;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, WidgetGlobalSearchGuildsModel.Item data) {
            Guild guild;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            Guild guild2 = data.getGuild();
            boolean z2 = guild2 != null && guild2.hasIcon();
            SimpleDraweeView simpleDraweeView = this.bindingGuild.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
            boolean zIsSelected = data.isSelected();
            Guild guild3 = data.getGuild();
            Integer numValueOf = Integer.valueOf(this.overlayColor);
            SimpleDraweeView simpleDraweeView2 = this.bindingGuild.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "bindingGuild.guildsItemAvatar");
            SimpleDraweeViewExtensions.setGuildIcon(simpleDraweeView, zIsSelected, (496 & 2) != 0 ? null : guild3, simpleDraweeView2.getResources().getDimensionPixelSize(R.dimen.guild_icon_radius), (496 & 8) != 0 ? null : null, (496 & 16) != 0 ? null : numValueOf, (496 & 32) != 0 ? null : null, (496 & 64) != 0 ? null : null, (496 & 128) != 0 ? false : false, (496 & 256) != 0 ? null : null);
            TextView textView = this.bindingGuild.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "bindingGuild.guildsItemAvatarText");
            String shortName = null;
            if (!z2 && (guild = data.getGuild()) != null) {
                shortName = guild.getShortName();
            }
            textView.setText(shortName);
            TextView textView2 = this.bindingGuild.h;
            Intrinsics3.checkNotNullExpressionValue(textView2, "bindingGuild.guildsItemMentions");
            configureMentionsCount(textView2, data.getMentionCount());
            ImageView imageView = this.bindingGuild.i;
            Intrinsics3.checkNotNullExpressionValue(imageView, "bindingGuild.guildsItemVoice");
            imageView.setVisibility(data.getConnectedToVoice() ? 0 : 8);
            ImageView imageView2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guildsItemUnread");
            imageView2.setVisibility(data.isUnread() ? 0 : 8);
            ImageView imageView3 = this.binding.f2404b;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.guildsItemSelected");
            imageView3.setVisibility(data.isSelected() ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsAdapter(RecyclerView recyclerView, @ColorInt int i) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.overlayColor = i;
        this.onClickListener = WidgetGlobalSearchGuildsAdapter4.INSTANCE;
        this.onLongClickListener = WidgetGlobalSearchGuildsAdapter5.INSTANCE;
    }

    public final Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    public final Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> getOnLongClickListener() {
        return this.onLongClickListener;
    }

    public final void setOnClickListener(Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> function3) {
        Intrinsics3.checkNotNullParameter(function3, "<set-?>");
        this.onClickListener = function3;
    }

    public final void setOnLongClickListener(Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> function3) {
        Intrinsics3.checkNotNullParameter(function3, "<set-?>");
        this.onLongClickListener = function3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, WidgetGlobalSearchGuildsModel.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new ItemDivider(this, R.layout.widget_global_search_item_divider);
        }
        if (viewType == 2) {
            return new ItemDirectMessage(this, R.layout.widget_global_search_item_dm);
        }
        if (viewType == 3) {
            return new ItemGuild(this, R.layout.widget_global_search_item_guild, this.overlayColor);
        }
        throw invalidViewTypeException(viewType);
    }
}
