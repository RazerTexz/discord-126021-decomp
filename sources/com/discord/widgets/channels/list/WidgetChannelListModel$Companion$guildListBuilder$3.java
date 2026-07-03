package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$3 extends AbstractC12240o implements Function1<Channel, Boolean> {
    public final /* synthetic */ Set $unreadChannelIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$guildListBuilder$3(Set set) {
        super(1);
        this.$unreadChannelIds = set;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        C12238m.checkNotNullParameter(channel, "thread");
        return this.$unreadChannelIds.contains(Long.valueOf(channel.getId()));
    }
}
