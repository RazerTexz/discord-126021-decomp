package com.discord.views.guildboost;

import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostSubscriptionUpsellView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostSubscriptionUpsellView$a extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ GuildBoostSubscriptionUpsellView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostSubscriptionUpsellView$a(GuildBoostSubscriptionUpsellView guildBoostSubscriptionUpsellView) {
        super(1);
        this.this$0 = guildBoostSubscriptionUpsellView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(RenderContext renderContext) {
        RenderContext renderContext2 = renderContext;
        m.checkNotNullParameter(renderContext2, "$receiver");
        renderContext2.strikethroughColor = Integer.valueOf(ColorCompat.getThemedColor(this.this$0.getContext(), 2130969056));
        return Unit.a;
    }
}
