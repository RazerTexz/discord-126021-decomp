package com.discord.widgets.channels.list;

import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$7 extends o implements Function2<User, Channel, Unit> {
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$7(WidgetChannelsList widgetChannelsList) {
        super(2);
        this.this$0 = widgetChannelsList;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(User user, Channel channel) {
        invoke2(user, channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user, Channel channel) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(channel, "channel");
        WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
        long id2 = user.getId();
        Long lValueOf = Long.valueOf(channel.getId());
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, id2, lValueOf, parentFragmentManager, Long.valueOf(channel.getGuildId()), Boolean.valueOf(ChannelUtils.J(channel)), null, null, 96, null);
    }
}
