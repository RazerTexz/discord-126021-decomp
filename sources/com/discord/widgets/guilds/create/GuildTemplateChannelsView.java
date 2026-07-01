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
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.GuildTemplateChannelsItemViewBinding;
import com.discord.databinding.GuildTemplateChannelsViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ChannelDataPayload(channel);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ChannelDataPayload) && Intrinsics3.areEqual(this.channel, ((ChannelDataPayload) other).channel);
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
            StringBuilder sbU = outline.U("ChannelDataPayload(channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: GuildTemplateChannelsView.kt */
    public static final class ChannelViewHolder extends MGRecyclerViewHolder<ChannelsAdapter, ChannelDataPayload> {
        private final GuildTemplateChannelsItemViewBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelViewHolder(@LayoutRes int i, ChannelsAdapter channelsAdapter) {
            super(i, channelsAdapter);
            Intrinsics3.checkNotNullParameter(channelsAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.guild_template_channels_item_image;
            ImageView imageView = (ImageView) view.findViewById(R.id.guild_template_channels_item_image);
            if (imageView != null) {
                i2 = R.id.guild_template_channels_item_name;
                TextView textView = (TextView) view.findViewById(R.id.guild_template_channels_item_name);
                if (textView != null) {
                    GuildTemplateChannelsItemViewBinding guildTemplateChannelsItemViewBinding = new GuildTemplateChannelsItemViewBinding((LinearLayout) view, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(guildTemplateChannelsItemViewBinding, "GuildTemplateChannelsIte…iewBinding.bind(itemView)");
                    this.binding = guildTemplateChannelsItemViewBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, ChannelDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildTemplateChannelsItemName");
            textView.setText(ChannelUtils.c(data.getChannel()));
            if (ChannelUtils.k(data.getChannel())) {
                this.binding.f2123b.setImageResource(R.drawable.ic_chevron_down_grey_12dp);
            } else if (ChannelUtils.J(data.getChannel())) {
                this.binding.f2123b.setImageResource(R.drawable.ic_channel_voice_16dp);
            } else {
                this.binding.f2123b.setImageResource(R.drawable.ic_channel_text_16dp);
            }
            if (data.getChannel().getParentId() > 0) {
                ImageView imageView = this.binding.f2123b;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildTemplateChannelsItemImage");
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                Resources resources = ((ChannelsAdapter) this.adapter).getContext().getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "adapter.context.resources");
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics());
            }
        }
    }

    /* JADX INFO: compiled from: GuildTemplateChannelsView.kt */
    public static final class ChannelsAdapter extends MGRecyclerAdapterSimple<ChannelDataPayload> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelsAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<ChannelsAdapter, ChannelDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new ChannelViewHolder(R.layout.guild_template_channels_item_view, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateChannelsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.guild_template_channels_view, (ViewGroup) this, false);
        addView(viewInflate);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.guild_template_channels_recycler_view);
        if (recyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.guild_template_channels_recycler_view)));
        }
        GuildTemplateChannelsViewBinding guildTemplateChannelsViewBinding = new GuildTemplateChannelsViewBinding((LinearLayout) viewInflate, recyclerView);
        Intrinsics3.checkNotNullExpressionValue(guildTemplateChannelsViewBinding, "GuildTemplateChannelsVie…rom(context), this, true)");
        this.binding = guildTemplateChannelsViewBinding;
        LinearLayout.inflate(context, R.layout.guild_template_channels_view, this);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildTemplateChannelsRecyclerView");
        this.channelsAdapter = (ChannelsAdapter) companion.configure(new ChannelsAdapter(recyclerView));
        recyclerView.setHasFixedSize(false);
    }

    public final void updateView(List<Channel> channels) {
        Intrinsics3.checkNotNullParameter(channels, "channels");
        ChannelsAdapter channelsAdapter = this.channelsAdapter;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(channels, 10));
        Iterator<T> it = channels.iterator();
        while (it.hasNext()) {
            arrayList.add(new ChannelDataPayload((Channel) it.next()));
        }
        channelsAdapter.setData(arrayList);
    }
}
