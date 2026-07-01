package com.discord.widgets.hubs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubDomainViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains4 extends SimpleRecyclerAdapter.ViewHolder<WidgetHubDomains2> {
    private final DiscordHubAddServerListItemBinding binding;
    private final Function1<WidgetHubDomains2, Unit> onClickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHubDomains4(DiscordHubAddServerListItemBinding discordHubAddServerListItemBinding, Function1<? super WidgetHubDomains2, Unit> function1) {
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

    public final Function1<WidgetHubDomains2, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public void bind(final WidgetHubDomains2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.binding.f2098b.b();
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordUAddServerListItemText");
        textView.setText(data.getName());
        this.binding.f2098b.a(data.getIcon(), GuildUtils.computeShortName(data.getName()));
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.HubDomainViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubDomains4.this.getOnClickListener().invoke(data);
            }
        });
    }
}
