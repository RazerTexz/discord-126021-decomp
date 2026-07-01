package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$adapter$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainSearch2 extends Lambda implements Function2<LayoutInflater, ViewGroup, WidgetHubDomains4> {
    public final /* synthetic */ WidgetHubDomainSearch this$0;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$adapter$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetHubDomains2, Unit> {
        public AnonymousClass1(WidgetHubDomainSearch widgetHubDomainSearch) {
            super(1, widgetHubDomainSearch, WidgetHubDomainSearch.class, "onServerClickListener", "onServerClickListener(Lcom/discord/widgets/hubs/DomainGuildInfo;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubDomains2 widgetHubDomains2) {
            invoke2(widgetHubDomains2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubDomains2 widgetHubDomains2) {
            Intrinsics3.checkNotNullParameter(widgetHubDomains2, "p1");
            ((WidgetHubDomainSearch) this.receiver).onServerClickListener(widgetHubDomains2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomainSearch2(WidgetHubDomainSearch widgetHubDomainSearch) {
        super(2);
        this.this$0 = widgetHubDomainSearch;
    }

    @Override // kotlin.jvm.functions.Function2
    public final WidgetHubDomains4 invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        DiscordHubAddServerListItemBinding discordHubAddServerListItemBindingA = DiscordHubAddServerListItemBinding.a(layoutInflater, viewGroup, false);
        Intrinsics3.checkNotNullExpressionValue(discordHubAddServerListItemBindingA, "DiscordHubAddServerListI…(inflater, parent, false)");
        return new WidgetHubDomains4(discordHubAddServerListItemBindingA, new AnonymousClass1(this.this$0));
    }
}
