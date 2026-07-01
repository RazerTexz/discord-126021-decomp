package com.discord.widgets.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewKt;
import b.a.i.j5;
import com.discord.R$id;
import com.discord.R$menu;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$Channel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.toolbar.ToolbarUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.StatusView;
import com.discord.views.ToolbarTitleLayout;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeHeaderManager {
    private static final String ANALYTICS_SOURCE = "Toolbar";
    public static final WidgetHomeHeaderManager INSTANCE = new WidgetHomeHeaderManager();

    private WidgetHomeHeaderManager() {
    }

    public static final /* synthetic */ boolean access$isChannelNSFWGated(WidgetHomeHeaderManager widgetHomeHeaderManager, boolean z2, boolean z3, NsfwAllowance nsfwAllowance) {
        return widgetHomeHeaderManager.isChannelNSFWGated(z2, z3, nsfwAllowance);
    }

    private final void configureThreadBrowserIconBehavior(Toolbar toolbar, WidgetHomeModel model, Channel channel, Context context) {
        View actionView;
        View actionView2;
        Menu menu;
        if (channel != null) {
            boolean z2 = !ChannelUtils.q(channel);
            int threadCount = model.getThreadCount();
            View viewFindViewById = null;
            MenuItem menuItemFindItem = (toolbar == null || (menu = toolbar.getMenu()) == null) ? null : menu.findItem(R$id.menu_chat_thread_browser);
            TextView textView = (menuItemFindItem == null || (actionView2 = menuItemFindItem.getActionView()) == null) ? null : (TextView) actionView2.findViewById(R$id.thread_browser_count);
            if (textView != null) {
                textView.setText(String.valueOf(Math.min(99, threadCount)));
            }
            if (textView != null) {
                ViewKt.setVisible(textView, threadCount != 0 && z2);
            }
            if (menuItemFindItem != null && (actionView = menuItemFindItem.getActionView()) != null) {
                viewFindViewById = actionView.findViewById(R$id.thread_browser_root);
            }
            if (viewFindViewById != null) {
                ViewKt.setVisible(viewFindViewById, z2);
            }
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new WidgetHomeHeaderManager$configureThreadBrowserIconBehavior$1(context, channel));
            }
        }
    }

    private final WidgetHomeHeaderManager$HeaderData getHeaderData(WidgetHomeModel widgetHomeModel, Context context) {
        StoreChannelsSelected$ResolvedSelectedChannel selectedChannel = widgetHomeModel.getSelectedChannel();
        if (!(selectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel)) {
            return selectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft ? new WidgetHomeHeaderManager$HeaderData(context.getString(2131888265), ChannelUtils.d(((StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) widgetHomeModel.getSelectedChannel()).getParentChannel(), context, false), null, true, null, 16, null) : new WidgetHomeHeaderManager$HeaderData(null, null, null, false, null, 30, null);
        }
        Channel channel = widgetHomeModel.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if (numValueOf == null) {
            return new WidgetHomeHeaderManager$HeaderData(context.getString(2131887637), null, null, false, null, 26, null);
        }
        if (numValueOf.intValue() == 3) {
            return new WidgetHomeHeaderManager$HeaderData(ChannelUtils.d(widgetHomeModel.getChannel(), context, false), null, 2131231827, false, null, 26, null);
        }
        if (numValueOf.intValue() == 1) {
            return new WidgetHomeHeaderManager$HeaderData(ChannelUtils.d(widgetHomeModel.getChannel(), context, false), null, 2131231716, false, null, 26, null);
        }
        if (numValueOf.intValue() == 14) {
            return new WidgetHomeHeaderManager$HeaderData(ChannelUtils.d(widgetHomeModel.getChannel(), context, false), null, 2131231874, false, null, 26, null);
        }
        if (widgetHomeModel.getChannel().getId() <= 0) {
            return new WidgetHomeHeaderManager$HeaderData(null, null, null, false, null, 26, null);
        }
        String strD = ChannelUtils.d(widgetHomeModel.getChannel(), context, false);
        Channel parentChannel = widgetHomeModel.getParentChannel();
        return new WidgetHomeHeaderManager$HeaderData(strD, parentChannel != null ? ChannelUtils.d(parentChannel, context, false) : null, Integer.valueOf(GuildChannelIconUtilsKt.guildChannelIcon(widgetHomeModel.getChannel())), ((StoreChannelsSelected$ResolvedSelectedChannel$Channel) widgetHomeModel.getSelectedChannel()).getPeekParent() != null || ChannelUtils.J(widgetHomeModel.getChannel()), null, 16, null);
    }

    private final Action1<Menu> getOnConfigureAction(WidgetHomeModel widgetHomeModel, Resources resources) {
        return new WidgetHomeHeaderManager$getOnConfigureAction$1(widgetHomeModel, resources);
    }

    private final WidgetHomeHeaderManager$getOnSelectedAction$1 getOnSelectedAction(WidgetHomeModel widgetHomeModel, AppFragment appFragment, PanelLayout panelLayout) {
        return new WidgetHomeHeaderManager$getOnSelectedAction$1(widgetHomeModel, appFragment, panelLayout);
    }

    private final boolean isChannelNSFWGated(boolean isChannelNsfw, boolean isNsfwUnConsented, NsfwAllowance nsfwAllowed) {
        return isChannelNsfw && (isNsfwUnConsented || (nsfwAllowed == NsfwAllowance.DISALLOWED));
    }

    public final void configure(WidgetHome widgetHome, WidgetHomeModel model, WidgetHomeBinding binding) {
        int themedDrawableRes$default;
        int i;
        m.checkNotNullParameter(widgetHome, "widgetHome");
        m.checkNotNullParameter(model, "model");
        m.checkNotNullParameter(binding, "binding");
        widgetHome.lockCloseRightPanel(model.getChannel() == null || !(ChannelUtils.B(model.getChannel()) || ChannelUtils.v(model.getChannel())) || ChannelUtils.j(model.getChannel()));
        Channel channel = model.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 14) {
            widgetHome.bindToolbar(binding.d.d);
        } else if (numValueOf != null && numValueOf.intValue() == 15) {
            widgetHome.bindToolbar(binding.d.f136b);
        } else {
            j5 j5Var = binding.d.c;
            m.checkNotNullExpressionValue(j5Var, "binding.panelCenter.widgetHomePanelCenterChat");
            widgetHome.bindToolbar(j5Var.a);
        }
        widgetHome.setActionBarTitleLayoutExpandedTappableArea();
        Context context = widgetHome.getContext();
        if (context != null) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = INSTANCE;
            m.checkNotNullExpressionValue(context, "context");
            WidgetHomeHeaderManager$HeaderData headerData = widgetHomeHeaderManager.getHeaderData(model, context);
            CharSequence title = headerData.getTitle();
            CharSequence subtitle = headerData.getSubtitle();
            Integer drawableRes = headerData.getDrawableRes();
            boolean leftButtonIsBack = headerData.getLeftButtonIsBack();
            Integer trailingDrawable = headerData.getTrailingDrawable();
            if (leftButtonIsBack) {
                themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, 2130969454, 0, 2, (Object) null);
            } else {
                if (leftButtonIsBack) {
                    throw new NoWhenBranchMatchedException();
                }
                themedDrawableRes$default = 2131231915;
            }
            Integer numValueOf2 = Integer.valueOf(themedDrawableRes$default);
            if (leftButtonIsBack) {
                i = 2131886994;
            } else {
                if (leftButtonIsBack) {
                    throw new NoWhenBranchMatchedException();
                }
                i = 2131896442;
            }
            widgetHome.setActionBarDisplayHomeAsUpEnabled(true, numValueOf2, Integer.valueOf(i));
            widgetHome.setActionBarTitle(title, drawableRes, trailingDrawable);
            widgetHome.setActionBarSubtitle(subtitle);
            Toolbar toolbar = widgetHome.getToolbar();
            if (toolbar != null) {
                toolbar.setNavigationOnClickListener(new WidgetHomeHeaderManager$configure$$inlined$apply$lambda$1(model, widgetHome, model, binding));
            }
        }
        widgetHome.setActionBarTitleClick(new WidgetHomeHeaderManager$configure$$inlined$apply$lambda$2(model, widgetHome, model, binding));
        WidgetHomeHeaderManager widgetHomeHeaderManager2 = INSTANCE;
        WidgetHomeHeaderManager$getOnSelectedAction$1 onSelectedAction = widgetHomeHeaderManager2.getOnSelectedAction(model, widgetHome, widgetHome.getPanelLayout());
        Resources resources = widgetHome.getResources();
        m.checkNotNullExpressionValue(resources, "widgetHome.resources");
        Toolbar actionBarOptionsMenu = widgetHome.setActionBarOptionsMenu(R$menu.menu_chat_toolbar, onSelectedAction, widgetHomeHeaderManager2.getOnConfigureAction(model, resources));
        Channel channel2 = model.getChannel();
        boolean zN = channel2 != null ? ChannelUtils.n(channel2, model.getDmPresence()) : false;
        ToolbarTitleLayout actionBarTitleLayout = widgetHome.getActionBarTitleLayout();
        if (actionBarTitleLayout != null) {
            Presence dmPresence = model.getDmPresence();
            StatusView statusView = actionBarTitleLayout.binding.c;
            m.checkNotNullExpressionValue(statusView, "binding.toolbarPresence");
            statusView.setVisibility(zN ? 0 : 8);
            actionBarTitleLayout.binding.c.setPresence(dmPresence);
        }
        TextView unreadCountView = widgetHome.getUnreadCountView();
        Integer numValueOf3 = Integer.valueOf(model.getUnreadCount());
        if (!(numValueOf3.intValue() > 0)) {
            numValueOf3 = null;
        }
        ViewExtensions.setTextAndVisibilityBy(unreadCountView, numValueOf3 != null ? String.valueOf(numValueOf3.intValue()) : null);
        Toolbar toolbar2 = widgetHome.getToolbar();
        if (toolbar2 != null) {
            ToolbarUtilsKt.positionUnreadCountView(toolbar2, unreadCountView);
        }
        widgetHomeHeaderManager2.configureThreadBrowserIconBehavior(actionBarOptionsMenu, model, model.getChannel(), widgetHome.getContext());
    }
}
