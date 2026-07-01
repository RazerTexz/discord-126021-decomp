package com.discord.widgets.share;

import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemGuild;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onSendClicked$filter$3 extends o implements Function1<Channel, Boolean> {
    public final /* synthetic */ WidgetGlobalSearchModel$ItemDataPayload $receiver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$onSendClicked$filter$3(WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        super(1);
        this.$receiver = widgetGlobalSearchModel$ItemDataPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        return channel != null && channel.getGuildId() == ((WidgetGlobalSearchModel$ItemGuild) this.$receiver).getGuild().getId();
    }
}
