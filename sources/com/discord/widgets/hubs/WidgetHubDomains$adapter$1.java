package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains$adapter$1 extends AbstractC12240o implements Function2<LayoutInflater, ViewGroup, HubDomainViewHolder> {
    public final /* synthetic */ WidgetHubDomains this$0;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomains$adapter$1$1 */
    /* JADX INFO: compiled from: WidgetHubDomains.kt */
    public static final /* synthetic */ class C90261 extends C12236k implements Function1<DomainGuildInfo, Unit> {
        public C90261(WidgetHubDomains widgetHubDomains) {
            super(1, widgetHubDomains, WidgetHubDomains.class, "onServerClickListener", "onServerClickListener(Lcom/discord/widgets/hubs/DomainGuildInfo;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DomainGuildInfo domainGuildInfo) {
            invoke2(domainGuildInfo);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DomainGuildInfo domainGuildInfo) {
            C12238m.checkNotNullParameter(domainGuildInfo, "p1");
            ((WidgetHubDomains) this.receiver).onServerClickListener(domainGuildInfo);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomains$adapter$1(WidgetHubDomains widgetHubDomains) {
        super(2);
        this.this$0 = widgetHubDomains;
    }

    @Override // kotlin.jvm.functions.Function2
    public final HubDomainViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C12238m.checkNotNullParameter(layoutInflater, "inflater");
        C12238m.checkNotNullParameter(viewGroup, "parent");
        DiscordHubAddServerListItemBinding discordHubAddServerListItemBindingM8382a = DiscordHubAddServerListItemBinding.m8382a(layoutInflater, viewGroup, false);
        C12238m.checkNotNullExpressionValue(discordHubAddServerListItemBindingM8382a, "DiscordHubAddServerListI…(inflater, parent, false)");
        return new HubDomainViewHolder(discordHubAddServerListItemBindingM8382a, new C90261(this.this$0));
    }
}
