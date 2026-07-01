package com.discord.widgets.hubs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.GuildView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DiscordHubAddServerViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordHubAddServerViewHolder extends SimpleRecyclerAdapter.ViewHolder<Guild> {
    private final DiscordHubAddServerListItemBinding binding;
    private final Function1<Long, Unit> onClickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public DiscordHubAddServerViewHolder(DiscordHubAddServerListItemBinding discordHubAddServerListItemBinding, Function1<? super Long, Unit> function1) {
        Intrinsics3.checkNotNullParameter(discordHubAddServerListItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        FrameLayout frameLayout = discordHubAddServerListItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout);
        this.binding = discordHubAddServerListItemBinding;
        this.onClickListener = function1;
    }

    public final DiscordHubAddServerListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<Long, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public void bind(final Guild data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordUAddServerListItemText");
        textView.setText(data.getName());
        GuildView guildView = this.binding.f2098b;
        guildView.b();
        guildView.a(IconUtils.getForGuild$default(data, null, false, null, 14, null), data.getShortName());
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.DiscordHubAddServerViewHolder.bind.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiscordHubAddServerViewHolder.this.getOnClickListener().invoke(Long.valueOf(data.getId()));
            }
        });
    }
}
