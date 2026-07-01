package com.discord.widgets.channels;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.models.user.User;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.channel.ChannelSelector;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$setupFAB$2$3 extends o implements Function1<Pair<? extends Channel, ? extends Long>, Unit> {
    public final /* synthetic */ WidgetGroupInviteFriends$setupFAB$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGroupInviteFriends$setupFAB$2$3(WidgetGroupInviteFriends$setupFAB$2 widgetGroupInviteFriends$setupFAB$2) {
        super(1);
        this.this$0 = widgetGroupInviteFriends$setupFAB$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Channel, ? extends Long> pair) throws Exception {
        invoke2((Pair<Channel, Long>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<Channel, Long> pair) throws Exception {
        Channel channelComponent1 = pair.component1();
        Long lComponent2 = pair.component2();
        ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), 0L, channelComponent1.getId(), null, null, 12, null);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreTabsNavigation.selectHomeTab$default(storeStream$Companion.getTabsNavigation(), StoreNavigation$PanelAction.CLOSE, false, 2, null);
        Channel channel = this.this$0.$data.getChannel();
        if (m.areEqual(lComponent2, channel != null ? Long.valueOf(channel.getId()) : null)) {
            Channel channel2 = this.this$0.$data.getChannel();
            if (channel2 == null || !ChannelUtils.z(channel2)) {
                storeStream$Companion.getVoiceChannelSelected().clear();
                StoreCalls calls = storeStream$Companion.getCalls();
                WidgetGroupInviteFriends widgetGroupInviteFriends = this.this$0.this$0;
                Context contextRequireContext = widgetGroupInviteFriends.requireContext();
                FragmentManager parentFragmentManager = this.this$0.this$0.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                calls.call(widgetGroupInviteFriends, contextRequireContext, parentFragmentManager, channelComponent1.getId(), WidgetGroupInviteFriends$setupFAB$2$3$2.INSTANCE);
            } else {
                StoreCalls calls2 = storeStream$Companion.getCalls();
                long id2 = channelComponent1.getId();
                Collection<User> selectedUsers = this.this$0.$data.getSelectedUsers();
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(selectedUsers, 10));
                Iterator<T> it = selectedUsers.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((User) it.next()).getId()));
                }
                calls2.ring(id2, arrayList);
            }
        }
        AppActivity appActivity = this.this$0.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.onBackPressed();
        }
    }
}
