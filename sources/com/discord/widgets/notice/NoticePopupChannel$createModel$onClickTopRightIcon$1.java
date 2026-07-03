package com.discord.widgets.notice;

import android.content.Context;
import android.view.View;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NoticePopupChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopupChannel$createModel$onClickTopRightIcon$1 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticePopupChannel$createModel$onClickTopRightIcon$1(Channel channel, Context context) {
        super(1);
        this.$channel = channel;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        if (ChannelUtils.m7667B(this.$channel)) {
            return;
        }
        WidgetChannelNotificationSettings.INSTANCE.launch(this.$context, this.$channel.getId(), true);
    }
}
