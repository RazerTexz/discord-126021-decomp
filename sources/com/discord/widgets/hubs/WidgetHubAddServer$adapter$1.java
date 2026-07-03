package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12215a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer$adapter$1 extends AbstractC12240o implements Function2<LayoutInflater, ViewGroup, DiscordHubAddServerViewHolder> {
    public final /* synthetic */ WidgetHubAddServer this$0;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddServer$adapter$1$1 */
    /* JADX INFO: compiled from: WidgetHubAddServer.kt */
    public static final /* synthetic */ class C89911 extends C12215a implements Function1<Long, Unit> {
        public C89911(WidgetHubAddServer widgetHubAddServer) {
            super(1, widgetHubAddServer, WidgetHubAddServer.class, "onServerClickListener", "onServerClickListener(JZ)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetHubAddServer.onServerClickListener$default((WidgetHubAddServer) this.receiver, j, false, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServer$adapter$1(WidgetHubAddServer widgetHubAddServer) {
        super(2);
        this.this$0 = widgetHubAddServer;
    }

    @Override // kotlin.jvm.functions.Function2
    public final DiscordHubAddServerViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C12238m.checkNotNullParameter(layoutInflater, "layoutInflater");
        C12238m.checkNotNullParameter(viewGroup, "parent");
        DiscordHubAddServerListItemBinding discordHubAddServerListItemBindingM8382a = DiscordHubAddServerListItemBinding.m8382a(layoutInflater, viewGroup, false);
        C12238m.checkNotNullExpressionValue(discordHubAddServerListItemBindingM8382a, "DiscordHubAddServerListI…tInflater, parent, false)");
        return new DiscordHubAddServerViewHolder(discordHubAddServerListItemBindingM8382a, new C89911(this.this$0));
    }
}
