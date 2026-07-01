package com.discord.widgets.home;

import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.device.DeviceUtils;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeHeaderManager$getOnConfigureAction$1<T> implements Action1<Menu> {
    public final /* synthetic */ Resources $resources;
    public final /* synthetic */ WidgetHomeModel $this_getOnConfigureAction;

    public WidgetHomeHeaderManager$getOnConfigureAction$1(WidgetHomeModel widgetHomeModel, Resources resources) {
        this.$this_getOnConfigureAction = widgetHomeModel;
        this.$resources = resources;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Menu menu) {
        call2(menu);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Menu menu) {
        boolean z2 = false;
        boolean z3 = this.$this_getOnConfigureAction.getChannel() != null && ChannelUtils.E(this.$this_getOnConfigureAction.getChannel());
        boolean zIsSmallScreen = DeviceUtils.INSTANCE.isSmallScreen(this.$resources);
        boolean z4 = this.$this_getOnConfigureAction.getThreadExperimentEnabled() && this.$this_getOnConfigureAction.getThreadCount() > 0 && !WidgetHomeHeaderManager.access$isChannelNSFWGated(WidgetHomeHeaderManager.INSTANCE, this.$this_getOnConfigureAction.isChannelNsfw(), this.$this_getOnConfigureAction.isNsfwUnConsented(), this.$this_getOnConfigureAction.getNsfwAllowed());
        Channel channel = this.$this_getOnConfigureAction.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if ((numValueOf != null && numValueOf.intValue() == 3) || (numValueOf != null && numValueOf.intValue() == 1)) {
            MenuItem menuItemFindItem = menu.findItem(R$id.menu_chat_search);
            m.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_chat_search)");
            menuItemFindItem.setVisible(false);
            MenuItem menuItemFindItem2 = menu.findItem(R$id.menu_chat_side_panel);
            m.checkNotNullExpressionValue(menuItemFindItem2, "menu.findItem(R.id.menu_chat_side_panel)");
            menuItemFindItem2.setVisible(true);
            MenuItem menuItemFindItem3 = menu.findItem(R$id.menu_chat_thread_browser);
            m.checkNotNullExpressionValue(menuItemFindItem3, "menu.findItem(R.id.menu_chat_thread_browser)");
            menuItemFindItem3.setVisible(false);
        } else if ((numValueOf != null && numValueOf.intValue() == 5) || ((numValueOf != null && numValueOf.intValue() == 15) || (numValueOf != null && numValueOf.intValue() == 0))) {
            MenuItem menuItemFindItem4 = menu.findItem(R$id.menu_chat_side_panel);
            m.checkNotNullExpressionValue(menuItemFindItem4, "menu.findItem(R.id.menu_chat_side_panel)");
            menuItemFindItem4.setVisible(true);
            if (zIsSmallScreen) {
                MenuItem menuItemFindItem5 = menu.findItem(R$id.menu_chat_search);
                m.checkNotNullExpressionValue(menuItemFindItem5, "menu.findItem(R.id.menu_chat_search)");
                menuItemFindItem5.setVisible(!this.$this_getOnConfigureAction.getThreadExperimentEnabled());
                MenuItem menuItemFindItem6 = menu.findItem(R$id.menu_chat_thread_browser);
                m.checkNotNullExpressionValue(menuItemFindItem6, "menu.findItem(R.id.menu_chat_thread_browser)");
                menuItemFindItem6.setVisible(z4);
            } else {
                MenuItem menuItemFindItem7 = menu.findItem(R$id.menu_chat_search);
                m.checkNotNullExpressionValue(menuItemFindItem7, "menu.findItem(R.id.menu_chat_search)");
                menuItemFindItem7.setVisible(true);
                MenuItem menuItemFindItem8 = menu.findItem(R$id.menu_chat_thread_browser);
                m.checkNotNullExpressionValue(menuItemFindItem8, "menu.findItem(R.id.menu_chat_thread_browser)");
                menuItemFindItem8.setVisible(z4);
            }
        } else if ((numValueOf != null && numValueOf.intValue() == 10) || ((numValueOf != null && numValueOf.intValue() == 12) || (numValueOf != null && numValueOf.intValue() == 11))) {
            MenuItem menuItemFindItem9 = menu.findItem(R$id.menu_chat_side_panel);
            m.checkNotNullExpressionValue(menuItemFindItem9, "menu.findItem(R.id.menu_chat_side_panel)");
            menuItemFindItem9.setVisible(!ChannelUtils.j(this.$this_getOnConfigureAction.getChannel()));
            MenuItem menuItemFindItem10 = menu.findItem(R$id.menu_chat_search);
            m.checkNotNullExpressionValue(menuItemFindItem10, "menu.findItem(R.id.menu_chat_search)");
            menuItemFindItem10.setVisible(!zIsSmallScreen);
            MenuItem menuItemFindItem11 = menu.findItem(R$id.menu_chat_thread_browser);
            m.checkNotNullExpressionValue(menuItemFindItem11, "menu.findItem(R.id.menu_chat_thread_browser)");
            menuItemFindItem11.setVisible(false);
        } else if (numValueOf != null && numValueOf.intValue() == 14) {
            MenuItem menuItemFindItem12 = menu.findItem(R$id.menu_chat_search);
            m.checkNotNullExpressionValue(menuItemFindItem12, "menu.findItem(R.id.menu_chat_search)");
            menuItemFindItem12.setVisible(false);
            MenuItem menuItemFindItem13 = menu.findItem(R$id.menu_chat_side_panel);
            m.checkNotNullExpressionValue(menuItemFindItem13, "menu.findItem(R.id.menu_chat_side_panel)");
            menuItemFindItem13.setVisible(true);
            MenuItem menuItemFindItem14 = menu.findItem(R$id.menu_chat_thread_browser);
            m.checkNotNullExpressionValue(menuItemFindItem14, "menu.findItem(R.id.menu_chat_thread_browser)");
            menuItemFindItem14.setVisible(false);
        }
        boolean z5 = this.$this_getOnConfigureAction.getChannel() != null && ChannelUtils.B(this.$this_getOnConfigureAction.getChannel());
        MenuItem menuItemFindItem15 = menu.findItem(R$id.menu_chat_start_call);
        m.checkNotNullExpressionValue(menuItemFindItem15, "menu.findItem(R.id.menu_chat_start_call)");
        menuItemFindItem15.setVisible((this.$this_getOnConfigureAction.isCallConnected() || !z5 || z3) ? false : true);
        MenuItem menuItemFindItem16 = menu.findItem(R$id.menu_chat_start_video_call);
        m.checkNotNullExpressionValue(menuItemFindItem16, "menu.findItem(R.id.menu_chat_start_video_call)");
        menuItemFindItem16.setVisible((this.$this_getOnConfigureAction.isCallConnected() || !z5 || z3) ? false : true);
        MenuItem menuItemFindItem17 = menu.findItem(R$id.menu_chat_stop_call);
        m.checkNotNullExpressionValue(menuItemFindItem17, "menu.findItem(R.id.menu_chat_stop_call)");
        if (this.$this_getOnConfigureAction.isCallConnected() && !z3) {
            z2 = true;
        }
        menuItemFindItem17.setVisible(z2);
    }
}
