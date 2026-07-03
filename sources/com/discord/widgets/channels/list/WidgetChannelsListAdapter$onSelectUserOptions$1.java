package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$onSelectUserOptions$1 extends AbstractC12240o implements Function2<User, Channel, Unit> {
    public static final WidgetChannelsListAdapter$onSelectUserOptions$1 INSTANCE = new WidgetChannelsListAdapter$onSelectUserOptions$1();

    public WidgetChannelsListAdapter$onSelectUserOptions$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(User user, Channel channel) {
        invoke2(user, channel);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user, Channel channel) {
        C12238m.checkNotNullParameter(user, "<anonymous parameter 0>");
        C12238m.checkNotNullParameter(channel, "<anonymous parameter 1>");
    }
}
