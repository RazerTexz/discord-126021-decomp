package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains$adapter$1 extends o implements Function2<LayoutInflater, ViewGroup, HubDomainViewHolder> {
    public final /* synthetic */ WidgetHubDomains this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomains$adapter$1(WidgetHubDomains widgetHubDomains) {
        super(2);
        this.this$0 = widgetHubDomains;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ HubDomainViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final HubDomainViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        m.checkNotNullParameter(layoutInflater, "inflater");
        m.checkNotNullParameter(viewGroup, "parent");
        DiscordHubAddServerListItemBinding discordHubAddServerListItemBindingA = DiscordHubAddServerListItemBinding.a(layoutInflater, viewGroup, false);
        m.checkNotNullExpressionValue(discordHubAddServerListItemBindingA, "DiscordHubAddServerListI…(inflater, parent, false)");
        return new HubDomainViewHolder(discordHubAddServerListItemBindingA, new WidgetHubDomains$adapter$1$1(this.this$0));
    }
}
