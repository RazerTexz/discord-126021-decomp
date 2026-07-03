package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsModel$Companion$asDirectMessageItems$2 extends AbstractC12240o implements Function1<Channel, WidgetGlobalSearchGuildsModel.Item> {
    public final /* synthetic */ Map $mentionCounts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsModel$Companion$asDirectMessageItems$2(Map map) {
        super(1);
        this.$mentionCounts = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGlobalSearchGuildsModel.Item invoke(Channel channel) {
        C12238m.checkNotNullParameter(channel, "it");
        WidgetGlobalSearchGuildsModel.Item.Companion companion = WidgetGlobalSearchGuildsModel.Item.INSTANCE;
        Integer num = (Integer) C1643a.m845d(channel, this.$mentionCounts);
        return companion.createDirectMessage$app_productionGoogleRelease(channel, num != null ? num.intValue() : 0);
    }
}
