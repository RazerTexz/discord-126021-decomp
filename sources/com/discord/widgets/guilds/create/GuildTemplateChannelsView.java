package com.discord.widgets.guilds.create;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.databinding.GuildTemplateChannelsViewBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: GuildTemplateChannelsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateChannelsView extends LinearLayout {
    private final GuildTemplateChannelsViewBinding binding;
    private final GuildTemplateChannelsView$ChannelsAdapter channelsAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateChannelsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.guild_template_channels_view, (ViewGroup) this, false);
        addView(viewInflate);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.guild_template_channels_recycler_view);
        if (recyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R$id.guild_template_channels_recycler_view)));
        }
        GuildTemplateChannelsViewBinding guildTemplateChannelsViewBinding = new GuildTemplateChannelsViewBinding((LinearLayout) viewInflate, recyclerView);
        m.checkNotNullExpressionValue(guildTemplateChannelsViewBinding, "GuildTemplateChannelsVie…rom(context), this, true)");
        this.binding = guildTemplateChannelsViewBinding;
        LinearLayout.inflate(context, R$layout.guild_template_channels_view, this);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildTemplateChannelsRecyclerView");
        this.channelsAdapter = (GuildTemplateChannelsView$ChannelsAdapter) mGRecyclerAdapter$Companion.configure(new GuildTemplateChannelsView$ChannelsAdapter(recyclerView));
        recyclerView.setHasFixedSize(false);
    }

    public final void updateView(List<Channel> channels) {
        m.checkNotNullParameter(channels, "channels");
        GuildTemplateChannelsView$ChannelsAdapter guildTemplateChannelsView$ChannelsAdapter = this.channelsAdapter;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(channels, 10));
        Iterator<T> it = channels.iterator();
        while (it.hasNext()) {
            arrayList.add(new GuildTemplateChannelsView$ChannelDataPayload((Channel) it.next()));
        }
        guildTemplateChannelsView$ChannelsAdapter.setData(arrayList);
    }
}
