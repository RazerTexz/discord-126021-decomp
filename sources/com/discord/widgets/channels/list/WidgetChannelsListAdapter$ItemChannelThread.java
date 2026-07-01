package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$plurals;
import com.discord.databinding.WidgetChannelsListItemThreadBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemThread;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelThread extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemThreadBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelThread(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.channels_item_thread_content;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.channels_item_thread_content);
        if (constraintLayout != null) {
            i2 = R$id.channels_item_thread_mentions;
            TextView textView = (TextView) view.findViewById(R$id.channels_item_thread_mentions);
            if (textView != null) {
                i2 = R$id.channels_item_thread_name;
                TextView textView2 = (TextView) view.findViewById(R$id.channels_item_thread_name);
                if (textView2 != null) {
                    i2 = R$id.channels_item_thread_spine;
                    ImageView imageView = (ImageView) view.findViewById(R$id.channels_item_thread_spine);
                    if (imageView != null) {
                        i2 = R$id.channels_item_thread_unread;
                        ImageView imageView2 = (ImageView) view.findViewById(R$id.channels_item_thread_unread);
                        if (imageView2 != null) {
                            WidgetChannelsListItemThreadBinding widgetChannelsListItemThreadBinding = new WidgetChannelsListItemThreadBinding((ConstraintLayout) view, constraintLayout, textView, textView2, imageView, imageView2);
                            m.checkNotNullExpressionValue(widgetChannelsListItemThreadBinding, "WidgetChannelsListItemThreadBinding.bind(itemView)");
                            this.binding = widgetChannelsListItemThreadBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemChannelThread widgetChannelsListAdapter$ItemChannelThread) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemChannelThread.adapter;
    }

    private final CharSequence getContentDescription(ChannelListItemThread channelListItemThread) {
        if (channelListItemThread.getMentionCount() > 0) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            return b.j(view, 2131891472, new Object[]{StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R$plurals.guild_sidebar_default_channel_a11y_label_with_mentions_mentionCount, channelListItemThread.getMentionCount(), Integer.valueOf(channelListItemThread.getMentionCount())), channelListItemThread.getChannel().getName()}, null, 4);
        }
        if (channelListItemThread.getIsUnread()) {
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            return b.j(view2, 2131891473, new Object[]{channelListItemThread.getChannel().getName()}, null, 4);
        }
        View view3 = this.itemView;
        m.checkNotNullExpressionValue(view3, "itemView");
        return b.j(view3, 2131891471, new Object[]{channelListItemThread.getChannel().getName()}, null, 4);
    }

    private final int getSpineResourceId(WidgetChannelListModel$ThreadSpineType spineType) {
        if (m.areEqual(spineType, WidgetChannelListModel$ThreadSpineType$Single.INSTANCE)) {
            return 2131232142;
        }
        if (m.areEqual(spineType, WidgetChannelListModel$ThreadSpineType$Start.INSTANCE)) {
            return 2131232140;
        }
        return m.areEqual(spineType, WidgetChannelListModel$ThreadSpineType$End.INSTANCE) ? 2131232143 : 2131232141;
    }

    @ColorInt
    private final int getTextColor(ChannelListItemThread channelListItemThread, boolean z2) {
        if (z2) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            return ColorCompat.getThemedColor(view, 2130969005);
        }
        if (channelListItemThread.getMuted()) {
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            return ColorCompat.getThemedColor(view2, 2130969007);
        }
        if (channelListItemThread.getIsUnread()) {
            View view3 = this.itemView;
            m.checkNotNullExpressionValue(view3, "itemView");
            return ColorCompat.getThemedColor(view3, 2130969005);
        }
        View view4 = this.itemView;
        m.checkNotNullExpressionValue(view4, "itemView");
        return ColorCompat.getThemedColor(view4, 2130968965);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelListItemThread channelListItemThread = (ChannelListItemThread) data;
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(constraintLayout, new WidgetChannelsListAdapter$ItemChannelThread$onConfigure$1(this, data));
        this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelThread$onConfigure$2(this, data));
        ConstraintLayout constraintLayout2 = this.binding.f2298b;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.channelsItemThreadContent");
        setBackground(constraintLayout2, channelListItemThread.getSelected(), channelListItemThread.getChannel());
        ConstraintLayout constraintLayout3 = this.binding.f2298b;
        m.checkNotNullExpressionValue(constraintLayout3, "binding.channelsItemThreadContent");
        constraintLayout3.setContentDescription(getContentDescription(channelListItemThread));
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.channelsItemThreadName");
        textView.setText(channelListItemThread.getChannel().getName());
        this.binding.d.setTextColor(getTextColor(channelListItemThread, channelListItemThread.getSelected()));
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.channelsItemThreadMentions");
        textView2.setVisibility(channelListItemThread.getMentionCount() > 0 ? 0 : 8);
        TextView textView3 = this.binding.c;
        m.checkNotNullExpressionValue(textView3, "binding.channelsItemThreadMentions");
        textView3.setText(String.valueOf(Math.min(99, channelListItemThread.getMentionCount())));
        ImageView imageView = this.binding.f;
        m.checkNotNullExpressionValue(imageView, "binding.channelsItemThreadUnread");
        imageView.setVisibility((!channelListItemThread.getIsUnread() || channelListItemThread.getSelected() || channelListItemThread.getMuted()) ? false : true ? 0 : 8);
        TextView textView4 = this.binding.d;
        m.checkNotNullExpressionValue(textView4, "binding.channelsItemThreadName");
        FontUtils fontUtils = FontUtils.INSTANCE;
        ConstraintLayout constraintLayout4 = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout4, "binding.root");
        Context context = constraintLayout4.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        textView4.setTypeface(fontUtils.getThemedFont(context, (channelListItemThread.getIsUnread() || channelListItemThread.getSelected()) ? 2130969396 : 2130969395));
        this.binding.e.setImageResource(getSpineResourceId(channelListItemThread.getSpineType()));
    }
}
