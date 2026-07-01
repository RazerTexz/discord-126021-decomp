package com.discord.workers;

import android.content.Context;
import com.discord.utilities.fcm.NotificationRenderer;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageSendWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MessageSendWorker$b extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ String $channelName;
    public final /* synthetic */ MessageSendWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSendWorker$b(MessageSendWorker messageSendWorker, long j, String str) {
        super(1);
        this.this$0 = messageSendWorker;
        this.$channelId = j;
        this.$channelName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        int iIntValue = num.intValue();
        NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
        Context applicationContext = this.this$0.getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        notificationRenderer.displaySent(applicationContext, this.$channelId, this.$channelName, false, iIntValue);
        return Unit.a;
    }
}
