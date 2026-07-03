package com.discord.widgets.guilds.create;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.GuildTemplateChannelsItemViewBinding;
import com.discord.databinding.GuildTemplateChannelsViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildTemplateChannelsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateChannelsView extends LinearLayout {
    private final GuildTemplateChannelsViewBinding binding;
    private final ChannelsAdapter channelsAdapter;

    /* JADX INFO: compiled from: GuildTemplateChannelsView.kt */
    public static final /* data */ class ChannelDataPayload implements MGRecyclerDataPayload {
        private final Channel channel;
        private final String key;
        private final int type;

        public ChannelDataPayload(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.key = String.valueOf(hashCode());
        }

        public static /* synthetic */ ChannelDataPayload copy$default(ChannelDataPayload channelDataPayload, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelDataPayload.channel;
            }
            return channelDataPayload.copy(channel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final ChannelDataPayload copy(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            return new ChannelDataPayload(channel);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ChannelDataPayload) && C12238m.areEqual(this.channel, ((ChannelDataPayload) other).channel);
            }
            return true;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            Channel channel = this.channel;
            if (channel != null) {
                return channel.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ChannelDataPayload(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildTemplateChannelsView.kt */
    public static final class ChannelViewHolder extends MGRecyclerViewHolder<ChannelsAdapter, ChannelDataPayload> {
        private final GuildTemplateChannelsItemViewBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelViewHolder(@LayoutRes int i, ChannelsAdapter channelsAdapter) {
            super(i, channelsAdapter);
            C12238m.checkNotNullParameter(channelsAdapter, "adapter");
            View view = this.itemView;
            int i2 = C5419R.id.guild_template_channels_item_image;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.guild_template_channels_item_image);
            if (imageView != null) {
                i2 = C5419R.id.guild_template_channels_item_name;
                TextView textView = (TextView) view.findViewById(C5419R.id.guild_template_channels_item_name);
                if (textView != null) {
                    GuildTemplateChannelsItemViewBinding guildTemplateChannelsItemViewBinding = new GuildTemplateChannelsItemViewBinding((LinearLayout) view, imageView, textView);
                    C12238m.checkNotNullExpressionValue(guildTemplateChannelsItemViewBinding, "GuildTemplateChannelsIte…iewBinding.bind(itemView)");
                    this.binding = guildTemplateChannelsItemViewBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, ChannelDataPayload data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.f15158c;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildTemplateChannelsItemName");
            textView.setText(ChannelUtils.m7679c(data.getChannel()));
            if (ChannelUtils.m7687k(data.getChannel())) {
                this.binding.f15157b.setImageResource(C5419R.drawable.ic_chevron_down_grey_12dp);
            } else if (ChannelUtils.m7675J(data.getChannel())) {
                this.binding.f15157b.setImageResource(C5419R.drawable.ic_channel_voice_16dp);
            } else {
                this.binding.f15157b.setImageResource(C5419R.drawable.ic_channel_text_16dp);
            }
            if (data.getChannel().getParentId() > 0) {
                ImageView imageView = this.binding.f15157b;
                C12238m.checkNotNullExpressionValue(imageView, "binding.guildTemplateChannelsItemImage");
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                Resources resources = ((ChannelsAdapter) this.adapter).getContext().getResources();
                C12238m.checkNotNullExpressionValue(resources, "adapter.context.resources");
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics());
            }
        }
    }

    /* JADX INFO: compiled from: GuildTemplateChannelsView.kt */
    public static final class ChannelsAdapter extends MGRecyclerAdapterSimple<ChannelDataPayload> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelsAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<ChannelsAdapter, ChannelDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
            C12238m.checkNotNullParameter(parent, "parent");
            return new ChannelViewHolder(C5419R.layout.guild_template_channels_item_view, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateChannelsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.guild_template_channels_view, (ViewGroup) this, false);
        addView(viewInflate);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C5419R.id.guild_template_channels_recycler_view);
        if (recyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(C5419R.id.guild_template_channels_recycler_view)));
        }
        GuildTemplateChannelsViewBinding guildTemplateChannelsViewBinding = new GuildTemplateChannelsViewBinding((LinearLayout) viewInflate, recyclerView);
        C12238m.checkNotNullExpressionValue(guildTemplateChannelsViewBinding, "GuildTemplateChannelsVie…rom(context), this, true)");
        this.binding = guildTemplateChannelsViewBinding;
        LinearLayout.inflate(context, C5419R.layout.guild_template_channels_view, this);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.guildTemplateChannelsRecyclerView");
        this.channelsAdapter = (ChannelsAdapter) companion.configure(new ChannelsAdapter(recyclerView));
        recyclerView.setHasFixedSize(false);
    }

    public final void updateView(List<Channel> channels) {
        C12238m.checkNotNullParameter(channels, "channels");
        ChannelsAdapter channelsAdapter = this.channelsAdapter;
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(channels, 10));
        Iterator<T> it = channels.iterator();
        while (it.hasNext()) {
            arrayList.add(new ChannelDataPayload((Channel) it.next()));
        }
        channelsAdapter.setData(arrayList);
    }
}
