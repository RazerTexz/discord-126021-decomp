package com.discord.widgets.channels.list;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import b.a.k.b;
import com.discord.R$id;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetChannelsListItemCategoryBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelCategory extends WidgetChannelsListAdapter$Item {
    private static final long ANIMATION_DURATION = 300;
    private static final RotateAnimation ARROW_ANIM_COLLAPSE;
    private static final RotateAnimation ARROW_ANIM_EXPAND;
    public static final WidgetChannelsListAdapter$ItemChannelCategory$Companion Companion;
    private final WidgetChannelsListItemCategoryBinding binding;
    private boolean isCollapsed;

    static {
        WidgetChannelsListAdapter$ItemChannelCategory$Companion widgetChannelsListAdapter$ItemChannelCategory$Companion = new WidgetChannelsListAdapter$ItemChannelCategory$Companion(null);
        Companion = widgetChannelsListAdapter$ItemChannelCategory$Companion;
        ARROW_ANIM_EXPAND = WidgetChannelsListAdapter$ItemChannelCategory$Companion.access$getAnimation(widgetChannelsListAdapter$ItemChannelCategory$Companion, true);
        ARROW_ANIM_COLLAPSE = WidgetChannelsListAdapter$ItemChannelCategory$Companion.access$getAnimation(widgetChannelsListAdapter$ItemChannelCategory$Companion, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelCategory(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.channels_item_category_add;
        ImageView imageView = (ImageView) view.findViewById(R$id.channels_item_category_add);
        if (imageView != null) {
            i2 = R$id.channels_item_category_arrow;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.channels_item_category_arrow);
            if (imageView2 != null) {
                i2 = R$id.channels_item_category_name;
                TextView textView = (TextView) view.findViewById(R$id.channels_item_category_name);
                if (textView != null) {
                    WidgetChannelsListItemCategoryBinding widgetChannelsListItemCategoryBinding = new WidgetChannelsListItemCategoryBinding((LinearLayout) view, imageView, imageView2, textView);
                    m.checkNotNullExpressionValue(widgetChannelsListItemCategoryBinding, "WidgetChannelsListItemCa…oryBinding.bind(itemView)");
                    this.binding = widgetChannelsListItemCategoryBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemChannelCategory widgetChannelsListAdapter$ItemChannelCategory) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemChannelCategory.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelListItemCategory channelListItemCategory = (ChannelListItemCategory) data;
        LinearLayout linearLayout = this.binding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(linearLayout, new WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$1(this, data));
        this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$2(this, data));
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.channelsItemCategoryName");
        textView.setText(ChannelUtils.c(channelListItemCategory.getChannel()));
        TextView textView2 = this.binding.d;
        m.checkNotNullExpressionValue(textView2, "binding.channelsItemCategoryName");
        TextView textView3 = this.binding.d;
        m.checkNotNullExpressionValue(textView3, "binding.channelsItemCategoryName");
        Object[] objArr = new Object[2];
        objArr[0] = ChannelUtils.c(channelListItemCategory.getChannel());
        TextView textView4 = this.binding.d;
        m.checkNotNullExpressionValue(textView4, "binding.channelsItemCategoryName");
        objArr[1] = b.j(textView4, channelListItemCategory.isCollapsed() ? 2131887705 : 2131888963, new Object[0], null, 4);
        textView2.setContentDescription(b.j(textView3, 2131887465, objArr, null, 4));
        WidgetChannelsListAdapter$ItemChannelCategory$Companion widgetChannelsListAdapter$ItemChannelCategory$Companion = Companion;
        TextView textView5 = this.binding.d;
        m.checkNotNullExpressionValue(textView5, "binding.channelsItemCategoryName");
        Context context = textView5.getContext();
        m.checkNotNullExpressionValue(context, "binding.channelsItemCategoryName.context");
        int iAccess$getChannelColor = WidgetChannelsListAdapter$ItemChannelCategory$Companion.access$getChannelColor(widgetChannelsListAdapter$ItemChannelCategory$Companion, channelListItemCategory, context);
        this.binding.d.setTextColor(iAccess$getChannelColor);
        ViewCompat.setAccessibilityDelegate(this.binding.d, new WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$3());
        this.binding.c.setImageResource(WidgetChannelsListAdapter$ItemChannelCategory$Companion.access$getArrowDrawable(widgetChannelsListAdapter$ItemChannelCategory$Companion, channelListItemCategory));
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.channelsItemCategoryArrow");
        imageView.setImageTintList(ColorStateList.valueOf(iAccess$getChannelColor));
        if (this.isCollapsed != channelListItemCategory.isCollapsed()) {
            this.isCollapsed = channelListItemCategory.isCollapsed();
            this.binding.c.startAnimation(channelListItemCategory.isCollapsed() ? ARROW_ANIM_COLLAPSE : ARROW_ANIM_EXPAND);
        }
        ImageView imageView2 = this.binding.f2286b;
        m.checkNotNullExpressionValue(imageView2, "binding.channelsItemCategoryAdd");
        imageView2.setVisibility(channelListItemCategory.getCanManageChannels() ? 0 : 8);
        ImageView imageView3 = this.binding.f2286b;
        m.checkNotNullExpressionValue(imageView3, "binding.channelsItemCategoryAdd");
        imageView3.setImageTintList(ColorStateList.valueOf(iAccess$getChannelColor));
        this.binding.f2286b.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$4(this, channelListItemCategory));
    }
}
