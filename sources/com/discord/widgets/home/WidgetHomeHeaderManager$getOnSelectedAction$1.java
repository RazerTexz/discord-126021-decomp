package com.discord.widgets.home;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.R$id;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.widgets.friends.WidgetFriendsAdd;
import com.discord.widgets.friends.WidgetFriendsAdd$Companion;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeHeaderManager$getOnSelectedAction$1 implements Action2<MenuItem, Context> {
    public final /* synthetic */ AppFragment $appFragment;
    public final /* synthetic */ PanelLayout $panelLayout;
    public final /* synthetic */ WidgetHomeModel $this_getOnSelectedAction;

    public WidgetHomeHeaderManager$getOnSelectedAction$1(WidgetHomeModel widgetHomeModel, AppFragment appFragment, PanelLayout panelLayout) {
        this.$this_getOnSelectedAction = widgetHomeModel;
        this.$appFragment = appFragment;
        this.$panelLayout = panelLayout;
    }

    private final void launchForSearch(Context context) {
        Channel channel = this.$this_getOnSelectedAction.getChannel();
        if (channel != null && ChannelUtils.B(channel)) {
            WidgetSearch.Companion.launchForChannel(this.$this_getOnSelectedAction.getChannelId(), context);
            return;
        }
        Channel channel2 = this.$this_getOnSelectedAction.getChannel();
        if (channel2 == null || !ChannelUtils.v(channel2)) {
            return;
        }
        WidgetSearch.Companion.launchForGuild(this.$this_getOnSelectedAction.getChannel().getGuildId(), context);
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(MenuItem menuItem, Context context) {
        m.checkNotNullParameter(menuItem, "menuItem");
        m.checkNotNullParameter(context, "context");
        AppFragment appFragment = this.$appFragment;
        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
        PrivateCallLauncher privateCallLauncher = new PrivateCallLauncher(appFragment, appFragment, context, parentFragmentManager);
        switch (menuItem.getItemId()) {
            case R$id.menu_chat_add_friend /* 2131364371 */:
                WidgetFriendsAdd$Companion.show$default(WidgetFriendsAdd.Companion, context, null, "Toolbar", 2, null);
                break;
            case R$id.menu_chat_search /* 2131364372 */:
                launchForSearch(context);
                break;
            case R$id.menu_chat_side_panel /* 2131364373 */:
                this.$panelLayout.openEndPanel();
                break;
            case R$id.menu_chat_start_call /* 2131364374 */:
                privateCallLauncher.launchVoiceCall(this.$this_getOnSelectedAction.getChannelId());
                break;
            case R$id.menu_chat_start_group /* 2131364375 */:
                ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, this.$appFragment, this.$this_getOnSelectedAction.getChannel(), "Toolbar", null, null, 24, null);
                break;
            case R$id.menu_chat_start_video_call /* 2131364376 */:
                privateCallLauncher.launchVideoCall(this.$this_getOnSelectedAction.getChannelId());
                break;
            case R$id.menu_chat_stop_call /* 2131364377 */:
                StoreStream.Companion.getVoiceChannelSelected().clear();
                break;
        }
        AppFragment.hideKeyboard$default(this.$appFragment, null, 1, null);
    }
}
