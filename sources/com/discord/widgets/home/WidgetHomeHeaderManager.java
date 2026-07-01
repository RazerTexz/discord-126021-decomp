package com.discord.widgets.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentManager;
import b.a.i.WidgetHomePanelCenterChatBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.toolbar.ToolbarUtils2;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.StatusView;
import com.discord.views.ToolbarTitleLayout;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowser;
import com.discord.widgets.friends.WidgetFriendsAdd;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Action1;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeHeaderManager {
    private static final String ANALYTICS_SOURCE = "Toolbar";
    public static final WidgetHomeHeaderManager INSTANCE = new WidgetHomeHeaderManager();

    /* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
    public static final /* data */ class HeaderData {
        private final Integer drawableRes;
        private final boolean leftButtonIsBack;
        private final CharSequence subtitle;
        private final CharSequence title;
        private final Integer trailingDrawable;

        public HeaderData(CharSequence charSequence, CharSequence charSequence2, @DrawableRes Integer num, boolean z2, @DrawableRes Integer num2) {
            this.title = charSequence;
            this.subtitle = charSequence2;
            this.drawableRes = num;
            this.leftButtonIsBack = z2;
            this.trailingDrawable = num2;
        }

        public static /* synthetic */ HeaderData copy$default(HeaderData headerData, CharSequence charSequence, CharSequence charSequence2, Integer num, boolean z2, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = headerData.title;
            }
            if ((i & 2) != 0) {
                charSequence2 = headerData.subtitle;
            }
            CharSequence charSequence3 = charSequence2;
            if ((i & 4) != 0) {
                num = headerData.drawableRes;
            }
            Integer num3 = num;
            if ((i & 8) != 0) {
                z2 = headerData.leftButtonIsBack;
            }
            boolean z3 = z2;
            if ((i & 16) != 0) {
                num2 = headerData.trailingDrawable;
            }
            return headerData.copy(charSequence, charSequence3, num3, z3, num2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CharSequence getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CharSequence getSubtitle() {
            return this.subtitle;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getDrawableRes() {
            return this.drawableRes;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getLeftButtonIsBack() {
            return this.leftButtonIsBack;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getTrailingDrawable() {
            return this.trailingDrawable;
        }

        public final HeaderData copy(CharSequence title, CharSequence subtitle, @DrawableRes Integer drawableRes, boolean leftButtonIsBack, @DrawableRes Integer trailingDrawable) {
            return new HeaderData(title, subtitle, drawableRes, leftButtonIsBack, trailingDrawable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HeaderData)) {
                return false;
            }
            HeaderData headerData = (HeaderData) other;
            return Intrinsics3.areEqual(this.title, headerData.title) && Intrinsics3.areEqual(this.subtitle, headerData.subtitle) && Intrinsics3.areEqual(this.drawableRes, headerData.drawableRes) && this.leftButtonIsBack == headerData.leftButtonIsBack && Intrinsics3.areEqual(this.trailingDrawable, headerData.trailingDrawable);
        }

        public final Integer getDrawableRes() {
            return this.drawableRes;
        }

        public final boolean getLeftButtonIsBack() {
            return this.leftButtonIsBack;
        }

        public final CharSequence getSubtitle() {
            return this.subtitle;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final Integer getTrailingDrawable() {
            return this.trailingDrawable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9 */
        public int hashCode() {
            CharSequence charSequence = this.title;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.subtitle;
            int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            Integer num = this.drawableRes;
            int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
            boolean z2 = this.leftButtonIsBack;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode3 + r2) * 31;
            Integer num2 = this.trailingDrawable;
            return i + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("HeaderData(title=");
            sbU.append(this.title);
            sbU.append(", subtitle=");
            sbU.append(this.subtitle);
            sbU.append(", drawableRes=");
            sbU.append(this.drawableRes);
            sbU.append(", leftButtonIsBack=");
            sbU.append(this.leftButtonIsBack);
            sbU.append(", trailingDrawable=");
            return outline.F(sbU, this.trailingDrawable, ")");
        }

        public /* synthetic */ HeaderData(CharSequence charSequence, CharSequence charSequence2, Integer num, boolean z2, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? null : charSequence2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : num2);
        }
    }

    private WidgetHomeHeaderManager() {
    }

    private final void configureThreadBrowserIconBehavior(Toolbar toolbar, WidgetHomeModel model, final Channel channel, final Context context) {
        View actionView;
        View actionView2;
        Menu menu;
        if (channel != null) {
            boolean z2 = !ChannelUtils.q(channel);
            int threadCount = model.getThreadCount();
            View viewFindViewById = null;
            MenuItem menuItemFindItem = (toolbar == null || (menu = toolbar.getMenu()) == null) ? null : menu.findItem(R.id.menu_chat_thread_browser);
            TextView textView = (menuItemFindItem == null || (actionView2 = menuItemFindItem.getActionView()) == null) ? null : (TextView) actionView2.findViewById(R.id.thread_browser_count);
            if (textView != null) {
                textView.setText(String.valueOf(Math.min(99, threadCount)));
            }
            if (textView != null) {
                ViewKt.setVisible(textView, threadCount != 0 && z2);
            }
            if (menuItemFindItem != null && (actionView = menuItemFindItem.getActionView()) != null) {
                viewFindViewById = actionView.findViewById(R.id.thread_browser_root);
            }
            if (viewFindViewById != null) {
                ViewKt.setVisible(viewFindViewById, z2);
            }
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.home.WidgetHomeHeaderManager.configureThreadBrowserIconBehavior.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetThreadBrowser.INSTANCE.show(context, channel.getGuildId(), ChannelUtils.H(channel) ? channel.getParentId() : channel.getId(), "Chat List Header");
                    }
                });
            }
        }
    }

    private final HeaderData getHeaderData(WidgetHomeModel widgetHomeModel, Context context) {
        StoreChannelsSelected.ResolvedSelectedChannel selectedChannel = widgetHomeModel.getSelectedChannel();
        if (!(selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel)) {
            return selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft ? new HeaderData(context.getString(R.string.create_thread), ChannelUtils.d(((StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) widgetHomeModel.getSelectedChannel()).getParentChannel(), context, false), null, true, null, 16, null) : new HeaderData(null, null, null, false, null, 30, null);
        }
        Channel channel = widgetHomeModel.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if (numValueOf == null) {
            return new HeaderData(context.getString(R.string.channels_unavailable_title), null, null, false, null, 26, null);
        }
        if (numValueOf.intValue() == 3) {
            return new HeaderData(ChannelUtils.d(widgetHomeModel.getChannel(), context, false), null, Integer.valueOf(R.drawable.ic_group_message_header), false, null, 26, null);
        }
        if (numValueOf.intValue() == 1) {
            return new HeaderData(ChannelUtils.d(widgetHomeModel.getChannel(), context, false), null, Integer.valueOf(R.drawable.ic_direct_message_header), false, null, 26, null);
        }
        if (numValueOf.intValue() == 14) {
            return new HeaderData(ChannelUtils.d(widgetHomeModel.getChannel(), context, false), null, Integer.valueOf(R.drawable.ic_hub_24dp), false, null, 26, null);
        }
        if (widgetHomeModel.getChannel().getId() <= 0) {
            return new HeaderData(null, null, null, false, null, 26, null);
        }
        String strD = ChannelUtils.d(widgetHomeModel.getChannel(), context, false);
        Channel parentChannel = widgetHomeModel.getParentChannel();
        return new HeaderData(strD, parentChannel != null ? ChannelUtils.d(parentChannel, context, false) : null, Integer.valueOf(GuildChannelIconUtils2.guildChannelIcon(widgetHomeModel.getChannel())), ((StoreChannelsSelected.ResolvedSelectedChannel.Channel) widgetHomeModel.getSelectedChannel()).getPeekParent() != null || ChannelUtils.J(widgetHomeModel.getChannel()), null, 16, null);
    }

    private final Action1<Menu> getOnConfigureAction(final WidgetHomeModel widgetHomeModel, final Resources resources) {
        return new Action1<Menu>() { // from class: com.discord.widgets.home.WidgetHomeHeaderManager.getOnConfigureAction.1
            @Override // rx.functions.Action1
            public final void call(Menu menu) {
                boolean z2 = false;
                boolean z3 = widgetHomeModel.getChannel() != null && ChannelUtils.E(widgetHomeModel.getChannel());
                boolean zIsSmallScreen = DeviceUtils.INSTANCE.isSmallScreen(resources);
                boolean z4 = widgetHomeModel.getThreadExperimentEnabled() && widgetHomeModel.getThreadCount() > 0 && !WidgetHomeHeaderManager.INSTANCE.isChannelNSFWGated(widgetHomeModel.isChannelNsfw(), widgetHomeModel.isNsfwUnConsented(), widgetHomeModel.getNsfwAllowed());
                Channel channel = widgetHomeModel.getChannel();
                Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
                if ((numValueOf != null && numValueOf.intValue() == 3) || (numValueOf != null && numValueOf.intValue() == 1)) {
                    MenuItem menuItemFindItem = menu.findItem(R.id.menu_chat_search);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_chat_search)");
                    menuItemFindItem.setVisible(false);
                    MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_chat_side_panel);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "menu.findItem(R.id.menu_chat_side_panel)");
                    menuItemFindItem2.setVisible(true);
                    MenuItem menuItemFindItem3 = menu.findItem(R.id.menu_chat_thread_browser);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem3, "menu.findItem(R.id.menu_chat_thread_browser)");
                    menuItemFindItem3.setVisible(false);
                } else if ((numValueOf != null && numValueOf.intValue() == 5) || ((numValueOf != null && numValueOf.intValue() == 15) || (numValueOf != null && numValueOf.intValue() == 0))) {
                    MenuItem menuItemFindItem4 = menu.findItem(R.id.menu_chat_side_panel);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem4, "menu.findItem(R.id.menu_chat_side_panel)");
                    menuItemFindItem4.setVisible(true);
                    if (zIsSmallScreen) {
                        MenuItem menuItemFindItem5 = menu.findItem(R.id.menu_chat_search);
                        Intrinsics3.checkNotNullExpressionValue(menuItemFindItem5, "menu.findItem(R.id.menu_chat_search)");
                        menuItemFindItem5.setVisible(!widgetHomeModel.getThreadExperimentEnabled());
                        MenuItem menuItemFindItem6 = menu.findItem(R.id.menu_chat_thread_browser);
                        Intrinsics3.checkNotNullExpressionValue(menuItemFindItem6, "menu.findItem(R.id.menu_chat_thread_browser)");
                        menuItemFindItem6.setVisible(z4);
                    } else {
                        MenuItem menuItemFindItem7 = menu.findItem(R.id.menu_chat_search);
                        Intrinsics3.checkNotNullExpressionValue(menuItemFindItem7, "menu.findItem(R.id.menu_chat_search)");
                        menuItemFindItem7.setVisible(true);
                        MenuItem menuItemFindItem8 = menu.findItem(R.id.menu_chat_thread_browser);
                        Intrinsics3.checkNotNullExpressionValue(menuItemFindItem8, "menu.findItem(R.id.menu_chat_thread_browser)");
                        menuItemFindItem8.setVisible(z4);
                    }
                } else if ((numValueOf != null && numValueOf.intValue() == 10) || ((numValueOf != null && numValueOf.intValue() == 12) || (numValueOf != null && numValueOf.intValue() == 11))) {
                    MenuItem menuItemFindItem9 = menu.findItem(R.id.menu_chat_side_panel);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem9, "menu.findItem(R.id.menu_chat_side_panel)");
                    menuItemFindItem9.setVisible(!ChannelUtils.j(widgetHomeModel.getChannel()));
                    MenuItem menuItemFindItem10 = menu.findItem(R.id.menu_chat_search);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem10, "menu.findItem(R.id.menu_chat_search)");
                    menuItemFindItem10.setVisible(!zIsSmallScreen);
                    MenuItem menuItemFindItem11 = menu.findItem(R.id.menu_chat_thread_browser);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem11, "menu.findItem(R.id.menu_chat_thread_browser)");
                    menuItemFindItem11.setVisible(false);
                } else if (numValueOf != null && numValueOf.intValue() == 14) {
                    MenuItem menuItemFindItem12 = menu.findItem(R.id.menu_chat_search);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem12, "menu.findItem(R.id.menu_chat_search)");
                    menuItemFindItem12.setVisible(false);
                    MenuItem menuItemFindItem13 = menu.findItem(R.id.menu_chat_side_panel);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem13, "menu.findItem(R.id.menu_chat_side_panel)");
                    menuItemFindItem13.setVisible(true);
                    MenuItem menuItemFindItem14 = menu.findItem(R.id.menu_chat_thread_browser);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem14, "menu.findItem(R.id.menu_chat_thread_browser)");
                    menuItemFindItem14.setVisible(false);
                }
                boolean z5 = widgetHomeModel.getChannel() != null && ChannelUtils.B(widgetHomeModel.getChannel());
                MenuItem menuItemFindItem15 = menu.findItem(R.id.menu_chat_start_call);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem15, "menu.findItem(R.id.menu_chat_start_call)");
                menuItemFindItem15.setVisible((widgetHomeModel.isCallConnected() || !z5 || z3) ? false : true);
                MenuItem menuItemFindItem16 = menu.findItem(R.id.menu_chat_start_video_call);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem16, "menu.findItem(R.id.menu_chat_start_video_call)");
                menuItemFindItem16.setVisible((widgetHomeModel.isCallConnected() || !z5 || z3) ? false : true);
                MenuItem menuItemFindItem17 = menu.findItem(R.id.menu_chat_stop_call);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem17, "menu.findItem(R.id.menu_chat_stop_call)");
                if (widgetHomeModel.isCallConnected() && !z3) {
                    z2 = true;
                }
                menuItemFindItem17.setVisible(z2);
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.discord.widgets.home.WidgetHomeHeaderManager$getOnSelectedAction$1] */
    private final AnonymousClass1 getOnSelectedAction(final WidgetHomeModel widgetHomeModel, final AppFragment appFragment, final PanelLayout panelLayout) {
        return new Action2<MenuItem, Context>() { // from class: com.discord.widgets.home.WidgetHomeHeaderManager.getOnSelectedAction.1
            private final void launchForSearch(Context context) {
                Channel channel = widgetHomeModel.getChannel();
                if (channel != null && ChannelUtils.B(channel)) {
                    WidgetSearch.INSTANCE.launchForChannel(widgetHomeModel.getChannelId(), context);
                    return;
                }
                Channel channel2 = widgetHomeModel.getChannel();
                if (channel2 == null || !ChannelUtils.v(channel2)) {
                    return;
                }
                WidgetSearch.INSTANCE.launchForGuild(widgetHomeModel.getChannel().getGuildId(), context);
            }

            @Override // rx.functions.Action2
            public void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullParameter(menuItem, "menuItem");
                Intrinsics3.checkNotNullParameter(context, "context");
                AppFragment appFragment2 = appFragment;
                FragmentManager parentFragmentManager = appFragment2.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
                PrivateCallLauncher privateCallLauncher = new PrivateCallLauncher(appFragment2, appFragment2, context, parentFragmentManager);
                switch (menuItem.getItemId()) {
                    case R.id.menu_chat_add_friend /* 2131364371 */:
                        WidgetFriendsAdd.Companion.show$default(WidgetFriendsAdd.INSTANCE, context, null, WidgetHomeHeaderManager.ANALYTICS_SOURCE, 2, null);
                        break;
                    case R.id.menu_chat_search /* 2131364372 */:
                        launchForSearch(context);
                        break;
                    case R.id.menu_chat_side_panel /* 2131364373 */:
                        panelLayout.openEndPanel();
                        break;
                    case R.id.menu_chat_start_call /* 2131364374 */:
                        privateCallLauncher.launchVoiceCall(widgetHomeModel.getChannelId());
                        break;
                    case R.id.menu_chat_start_group /* 2131364375 */:
                        ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(appFragment, widgetHomeModel.getChannel(), WidgetHomeHeaderManager.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
                        break;
                    case R.id.menu_chat_start_video_call /* 2131364376 */:
                        privateCallLauncher.launchVideoCall(widgetHomeModel.getChannelId());
                        break;
                    case R.id.menu_chat_stop_call /* 2131364377 */:
                        StoreStream.INSTANCE.getVoiceChannelSelected().clear();
                        break;
                }
                AppFragment.hideKeyboard$default(appFragment, null, 1, null);
            }
        };
    }

    private final boolean isChannelNSFWGated(boolean isChannelNsfw, boolean isNsfwUnConsented, NsfwAllowance nsfwAllowed) {
        return isChannelNsfw && (isNsfwUnConsented || (nsfwAllowed == NsfwAllowance.DISALLOWED));
    }

    public final void configure(final WidgetHome widgetHome, final WidgetHomeModel model, final WidgetHomeBinding binding) {
        int themedDrawableRes$default;
        int i;
        Intrinsics3.checkNotNullParameter(widgetHome, "widgetHome");
        Intrinsics3.checkNotNullParameter(model, "model");
        Intrinsics3.checkNotNullParameter(binding, "binding");
        widgetHome.lockCloseRightPanel(model.getChannel() == null || !(ChannelUtils.B(model.getChannel()) || ChannelUtils.v(model.getChannel())) || ChannelUtils.j(model.getChannel()));
        Channel channel = model.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 14) {
            widgetHome.bindToolbar(binding.d.d);
        } else if (numValueOf != null && numValueOf.intValue() == 15) {
            widgetHome.bindToolbar(binding.d.f136b);
        } else {
            WidgetHomePanelCenterChatBinding widgetHomePanelCenterChatBinding = binding.d.c;
            Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterChatBinding, "binding.panelCenter.widgetHomePanelCenterChat");
            widgetHome.bindToolbar(widgetHomePanelCenterChatBinding.a);
        }
        widgetHome.setActionBarTitleLayoutExpandedTappableArea();
        Context context = widgetHome.getContext();
        if (context != null) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            HeaderData headerData = widgetHomeHeaderManager.getHeaderData(model, context);
            CharSequence title = headerData.getTitle();
            CharSequence subtitle = headerData.getSubtitle();
            Integer drawableRes = headerData.getDrawableRes();
            boolean leftButtonIsBack = headerData.getLeftButtonIsBack();
            Integer trailingDrawable = headerData.getTrailingDrawable();
            if (leftButtonIsBack) {
                themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_action_bar_back, 0, 2, (Object) null);
            } else {
                if (leftButtonIsBack) {
                    throw new NoWhenBranchMatchedException();
                }
                themedDrawableRes$default = R.drawable.ic_menu_24dp;
            }
            Integer numValueOf2 = Integer.valueOf(themedDrawableRes$default);
            if (leftButtonIsBack) {
                i = R.string.back;
            } else {
                if (leftButtonIsBack) {
                    throw new NoWhenBranchMatchedException();
                }
                i = R.string.toggle_drawer;
            }
            widgetHome.setActionBarDisplayHomeAsUpEnabled(true, numValueOf2, Integer.valueOf(i));
            widgetHome.setActionBarTitle(title, drawableRes, trailingDrawable);
            widgetHome.setActionBarSubtitle(subtitle);
            Toolbar toolbar = widgetHome.getToolbar();
            if (toolbar != null) {
                toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.home.WidgetHomeHeaderManager$configure$$inlined$apply$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        widgetHome.handleCenterPanelBack$app_productionGoogleRelease();
                    }
                });
            }
        }
        widgetHome.setActionBarTitleClick(new View.OnClickListener() { // from class: com.discord.widgets.home.WidgetHomeHeaderManager$configure$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Channel channel2 = model.getChannel();
                Integer numValueOf3 = channel2 != null ? Integer.valueOf(channel2.getType()) : null;
                if ((numValueOf3 != null && numValueOf3.intValue() == 1) || ((numValueOf3 != null && numValueOf3.intValue() == 3) || ((numValueOf3 != null && numValueOf3.intValue() == 5) || ((numValueOf3 != null && numValueOf3.intValue() == 15) || (numValueOf3 != null && numValueOf3.intValue() == 0))))) {
                    widgetHome.getPanelLayout().openEndPanel();
                }
            }
        });
        WidgetHomeHeaderManager widgetHomeHeaderManager2 = INSTANCE;
        AnonymousClass1 onSelectedAction = widgetHomeHeaderManager2.getOnSelectedAction(model, widgetHome, widgetHome.getPanelLayout());
        Resources resources = widgetHome.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "widgetHome.resources");
        Toolbar actionBarOptionsMenu = widgetHome.setActionBarOptionsMenu(R.menu.menu_chat_toolbar, onSelectedAction, widgetHomeHeaderManager2.getOnConfigureAction(model, resources));
        Channel channel2 = model.getChannel();
        boolean zN = channel2 != null ? ChannelUtils.n(channel2, model.getDmPresence()) : false;
        ToolbarTitleLayout actionBarTitleLayout = widgetHome.getActionBarTitleLayout();
        if (actionBarTitleLayout != null) {
            Presence dmPresence = model.getDmPresence();
            StatusView statusView = actionBarTitleLayout.binding.c;
            Intrinsics3.checkNotNullExpressionValue(statusView, "binding.toolbarPresence");
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
            ToolbarUtils2.positionUnreadCountView(toolbar2, unreadCountView);
        }
        widgetHomeHeaderManager2.configureThreadBrowserIconBehavior(actionBarOptionsMenu, model, model.getChannel(), widgetHome.getContext());
    }
}
