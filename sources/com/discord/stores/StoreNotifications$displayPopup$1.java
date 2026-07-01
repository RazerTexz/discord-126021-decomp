package com.discord.stores;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.intent.IntentUtils$RouteBuilders;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotifications$displayPopup$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Message $message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotifications$displayPopup$1(Channel channel, Message message) {
        super(1);
        this.$channel = channel;
        this.$message = message;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "view");
        Intent intentSelectChannel = IntentUtils$RouteBuilders.selectChannel(this.$channel.getId(), this.$channel.getGuildId(), Long.valueOf(this.$message.getId()));
        intentSelectChannel.putExtra("com.discord.intent.ORIGIN_SOURCE", "com.discord.intent.ORIGIN_NOTIF_INAPP");
        IntentUtils intentUtils = IntentUtils.INSTANCE;
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        intentUtils.consumeExternalRoutingIntent(intentSelectChannel, context);
    }
}
