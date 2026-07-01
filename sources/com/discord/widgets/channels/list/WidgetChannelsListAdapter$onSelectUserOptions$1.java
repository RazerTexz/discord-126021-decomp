package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$onSelectUserOptions$1 extends o implements Function2<User, Channel, Unit> {
    public static final WidgetChannelsListAdapter$onSelectUserOptions$1 INSTANCE = new WidgetChannelsListAdapter$onSelectUserOptions$1();

    public WidgetChannelsListAdapter$onSelectUserOptions$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(User user, Channel channel) {
        invoke2(user, channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user, Channel channel) {
        m.checkNotNullParameter(user, "<anonymous parameter 0>");
        m.checkNotNullParameter(channel, "<anonymous parameter 1>");
    }
}
