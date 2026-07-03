package com.discord.widgets.hubs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.GuildView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DiscordHubAddServerViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordHubAddServerViewHolder extends SimpleRecyclerAdapter.ViewHolder<Guild> {
    private final DiscordHubAddServerListItemBinding binding;
    private final Function1<Long, Unit> onClickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public DiscordHubAddServerViewHolder(DiscordHubAddServerListItemBinding discordHubAddServerListItemBinding, Function1<? super Long, Unit> function1) {
        C12238m.checkNotNullParameter(discordHubAddServerListItemBinding, "binding");
        C12238m.checkNotNullParameter(function1, "onClickListener");
        FrameLayout frameLayout = discordHubAddServerListItemBinding.f15046a;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
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
        C12238m.checkNotNullParameter(data, "data");
        TextView textView = this.binding.f15049d;
        C12238m.checkNotNullExpressionValue(textView, "binding.discordUAddServerListItemText");
        textView.setText(data.getName());
        GuildView guildView = this.binding.f15047b;
        guildView.m8546b();
        guildView.m8545a(IconUtils.getForGuild$default(data, null, false, null, 14, null), data.getShortName());
        this.binding.f15048c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.DiscordHubAddServerViewHolder.bind.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiscordHubAddServerViewHolder.this.getOnClickListener().invoke(Long.valueOf(data.getId()));
            }
        });
    }
}
