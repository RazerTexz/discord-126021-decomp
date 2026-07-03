package com.discord.widgets.hubs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HubDomainViewHolder extends SimpleRecyclerAdapter.ViewHolder<DomainGuildInfo> {
    private final DiscordHubAddServerListItemBinding binding;
    private final Function1<DomainGuildInfo, Unit> onClickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public HubDomainViewHolder(DiscordHubAddServerListItemBinding discordHubAddServerListItemBinding, Function1<? super DomainGuildInfo, Unit> function1) {
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

    public final Function1<DomainGuildInfo, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public void bind(final DomainGuildInfo data) {
        C12238m.checkNotNullParameter(data, "data");
        this.binding.f15047b.m8546b();
        TextView textView = this.binding.f15049d;
        C12238m.checkNotNullExpressionValue(textView, "binding.discordUAddServerListItemText");
        textView.setText(data.getName());
        this.binding.f15047b.m8545a(data.getIcon(), GuildUtilsKt.computeShortName(data.getName()));
        this.binding.f15048c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.HubDomainViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HubDomainViewHolder.this.getOnClickListener().invoke(data);
            }
        });
    }
}
