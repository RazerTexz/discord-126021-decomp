package com.discord.widgets.channels.list;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelsListBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.hubs.HubUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetFeatureFlag;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowser;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.friends.EmptyFriendsStateView;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;
import com.discord.widgets.hubs.WidgetHubAddServer;
import com.discord.widgets.hubs.events.WidgetHubEventsPage;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.tabs.BottomNavViewObserver;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.VoiceUtils;
import com.discord.widgets.voice.settings.WidgetVoiceChannelSettings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList extends AppFragment {
    public static final String ANALYTICS_SOURCE = "Channels List";
    public static final float BANNER_TEXT_SHADOW_DX = 0.0f;
    public static final float BANNER_TEXT_SHADOW_DY = 4.0f;
    public static final float BANNER_TEXT_SHADOW_RADIUS = 1.0f;
    private final ActivityResultLauncher<Intent> activityResult;
    private WidgetChannelsListAdapter adapter;
    private final MGImages.DistinctChangeDetector bannerChangeDetector;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BottomNavViewObserver bottomNavViewObserver;
    private WidgetChannelListUnreads channelListUnreads;
    private final WidgetGlobalStatusIndicatorState globalStatusIndicatorStateObserver;
    private boolean isCollapsed;
    private Long selectedGuildId;
    private final StoreNavigation storeNavigation;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelsList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListBinding;", 0)};

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$configureBottomNavSpace$1 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C74241 extends AbstractC12240o implements Function1<Integer, Unit> {
        public C74241() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetChannelsList.access$getAdapter$p(WidgetChannelsList.this).handleBottomNavHeight(i);
            ViewStub viewStub = WidgetChannelsList.this.getBinding().f15980m;
            C12238m.checkNotNullExpressionValue(viewStub, "binding.channelsListUnreadsStub");
            ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i);
            ViewStub viewStub2 = WidgetChannelsList.this.getBinding().f15980m;
            C12238m.checkNotNullExpressionValue(viewStub2, "binding.channelsListUnreadsStub");
            viewStub2.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$configureUI$5 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C74265 extends AbstractC12240o implements Function1<Float, Unit> {
        public final /* synthetic */ Guild $guild;
        public final /* synthetic */ boolean $hasBanner;
        public final /* synthetic */ WidgetChannelListModel $list;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C74265(Guild guild, WidgetChannelListModel widgetChannelListModel, boolean z2) {
            super(1);
            this.$guild = guild;
            this.$list = widgetChannelListModel;
            this.$hasBanner = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
            invoke(f.floatValue());
            return Unit.f27425a;
        }

        public final void invoke(float f) {
            SimpleDraweeView simpleDraweeView = WidgetChannelsList.this.getBinding().f15971d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListBanner");
            simpleDraweeView.setAlpha(1.0f - f);
            boolean zM8542a = WidgetChannelsList.this.getBinding().f15969b.m8542a();
            if (WidgetChannelsList.this.isCollapsed != zM8542a) {
                WidgetChannelsList.this.isCollapsed = zM8542a;
                WidgetChannelsList widgetChannelsList = WidgetChannelsList.this;
                widgetChannelsList.configureHeaderIcons(this.$guild, widgetChannelsList.isCollapsed);
                WidgetChannelsList.this.configureHeaderColors(this.$list.getSelectedGuild(), this.$hasBanner);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C74271 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C74271() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel == null) {
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, 0L, null, null, 12, null);
                return;
            }
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, SelectedChannelAnalyticsLocation.CHANNEL_LIST, 2, null);
            if (!ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null) && ChannelUtils.m7693q(channel)) {
                WidgetThreadBrowser.INSTANCE.show(WidgetChannelsList.this.getContext(), channel.getGuildId(), channel.getId(), "Forum");
            }
            StoreNavigation.setNavigationPanelAction$default(WidgetChannelsList.this.storeNavigation, StoreNavigation.PanelAction.UNLOCK_LEFT, null, 2, null);
            StoreNavigation.setNavigationPanelAction$default(WidgetChannelsList.this.storeNavigation, StoreNavigation.PanelAction.CLOSE, null, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$10 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C742810 extends AbstractC12240o implements Function0<Unit> {
        public C742810() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            C0870j.f524g.m160f(WidgetChannelsList.this.requireContext(), WidgetChannelsList.this.activityResult, WidgetHubAddServer.class, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$12 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C743012 extends AbstractC12240o implements Function0<Integer> {
        public C743012() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return WidgetChannelsList.access$getAdapter$p(WidgetChannelsList.this).getPageSize();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$13 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C743113 extends AbstractC12240o implements Function2<List<? extends ChannelListItem>, List<? extends ChannelListItem>, Unit> {
        public C743113() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChannelListItem> list, List<? extends ChannelListItem> list2) {
            invoke2(list, list2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ChannelListItem> list, List<? extends ChannelListItem> list2) {
            C12238m.checkNotNullParameter(list, "<anonymous parameter 0>");
            C12238m.checkNotNullParameter(list2, "newData");
            WidgetChannelListUnreads widgetChannelListUnreads = WidgetChannelsList.this.channelListUnreads;
            if (widgetChannelListUnreads != null) {
                widgetChannelListUnreads.onDatasetChanged(list2);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C74342 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C74342() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            int type = channel.getType();
            if (type != 0 && type != 1) {
                if (type == 2) {
                    WidgetVoiceChannelSettings.INSTANCE.launch(channel.getId(), WidgetChannelsList.this.requireContext());
                    return;
                }
                if (type != 3 && type != 4 && type != 5 && type != 15) {
                    switch (type) {
                        case 10:
                        case 11:
                        case 12:
                            WidgetChannelsListItemThreadActions.Companion companion = WidgetChannelsListItemThreadActions.INSTANCE;
                            FragmentManager parentFragmentManager = WidgetChannelsList.this.getParentFragmentManager();
                            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                            companion.show(parentFragmentManager, channel.getId());
                            break;
                    }
                }
            }
            WidgetChannelsListItemChannelActions.Companion companion2 = WidgetChannelsListItemChannelActions.INSTANCE;
            FragmentManager parentFragmentManager2 = WidgetChannelsList.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            companion2.show(parentFragmentManager2, channel.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C74353 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C74353() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            VoiceUtils.handleCallChannel(channel, WidgetChannelsList.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C74364 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C74364() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Long l = WidgetChannelsList.this.selectedGuildId;
            if (l != null) {
                WidgetGuildRoleSubscriptionEntryPoint.INSTANCE.launch(WidgetChannelsList.this.requireContext(), l.longValue(), "Role Subscription Gated Channel");
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C74375 extends AbstractC12240o implements Function2<Channel, Boolean, Unit> {
        public C74375() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel, Boolean bool) {
            invoke(channel, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(Channel channel, boolean z2) {
            C12238m.checkNotNullParameter(channel, "channel");
            Object systemService = WidgetChannelsList.access$getAdapter$p(WidgetChannelsList.this).getContext().getSystemService("accessibility");
            if (systemService instanceof AccessibilityManager) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                C12238m.checkNotNullExpressionValue(accessibilityEventObtain, "event");
                accessibilityEventObtain.setEventType(16384);
                Object[] objArr = new Object[2];
                objArr[0] = WidgetChannelsList.this.getString(z2 ? C5419R.string.expanded : C5419R.string.collapsed);
                objArr[1] = ChannelUtils.m7679c(channel);
                accessibilityEventObtain.getText().add(C1643a.m828P(objArr, 2, "%s %s", "java.lang.String.format(format, *args)"));
                try {
                    ((AccessibilityManager) systemService).sendAccessibilityEvent(accessibilityEventObtain);
                } catch (IllegalStateException unused) {
                }
            }
            StoreStream.INSTANCE.getStoreChannelCategories().setCollapsedCategory(channel.getGuildId(), channel.getId(), !z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$6 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C74386 extends AbstractC12240o implements Function1<View, Unit> {
        public C74386() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            Long l = WidgetChannelsList.this.selectedGuildId;
            if (l != null) {
                long jLongValue = l.longValue();
                ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getInviteSettings().generateInviteDefaultChannel(jLongValue), WidgetChannelsList.this, null, 2, null).m11108k(C0879o.f566a.m184g(WidgetChannelsList.this.getContext(), new WidgetChannelsList$onViewBound$6$$special$$inlined$let$lambda$1(jLongValue, this, view), null));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$7 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C74397 extends AbstractC12240o implements Function2<User, Channel, Unit> {
        public C74397() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(User user, Channel channel) {
            invoke2(user, channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user, Channel channel) {
            C12238m.checkNotNullParameter(user, "user");
            C12238m.checkNotNullParameter(channel, "channel");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = user.getId();
            Long lValueOf = Long.valueOf(channel.getId());
            FragmentManager parentFragmentManager = WidgetChannelsList.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, parentFragmentManager, Long.valueOf(channel.getGuildId()), Boolean.valueOf(ChannelUtils.m7675J(channel)), null, null, 96, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$8 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C74408 extends AbstractC12240o implements Function1<Guild, Unit> {
        public C74408() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            Object next;
            C12238m.checkNotNullParameter(guild, "guild");
            if (!guild.isHub()) {
                WidgetGuildScheduledEventListBottomSheet.Companion companion = WidgetGuildScheduledEventListBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetChannelsList.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetGuildScheduledEventListBottomSheet.Companion.show$default(companion, parentFragmentManager, guild.getId(), null, 4, null);
                return;
            }
            Iterator<T> it = StoreStream.INSTANCE.getChannels().getChannelsForGuild(guild.getId()).values().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!ChannelUtils.m7691o((Channel) next));
            Channel channel = (Channel) next;
            if (channel != null) {
                WidgetHubEventsPage.Companion companion2 = WidgetHubEventsPage.INSTANCE;
                FragmentManager parentFragmentManager2 = WidgetChannelsList.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                companion2.show(parentFragmentManager2, guild.getId(), channel.getId());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$9 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class C74419 extends AbstractC12240o implements Function0<Unit> {
        public C74419() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Long l = WidgetChannelsList.this.selectedGuildId;
            if (l != null) {
                WidgetGuildRoleSubscriptionEntryPoint.INSTANCE.launch(WidgetChannelsList.this.requireContext(), l.longValue(), "Role Subscriptions Tab");
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final /* synthetic */ class C74421 extends C12236k implements Function1<WidgetChannelListModel, Unit> {
        public C74421(WidgetChannelsList widgetChannelsList) {
            super(1, widgetChannelsList, WidgetChannelsList.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/list/WidgetChannelListModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelListModel widgetChannelListModel) {
            invoke2(widgetChannelListModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelListModel widgetChannelListModel) {
            C12238m.checkNotNullParameter(widgetChannelListModel, "p1");
            ((WidgetChannelsList) this.receiver).configureUI(widgetChannelListModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final /* synthetic */ class C74432 extends C12236k implements Function1<WidgetGlobalStatusIndicatorState.State, Unit> {
        public C74432(WidgetChannelsList widgetChannelsList) {
            super(1, widgetChannelsList, WidgetChannelsList.class, "handleGlobalStatusIndicatorState", "handleGlobalStatusIndicatorState(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState.State state) {
            invoke2(state);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorState.State state) {
            C12238m.checkNotNullParameter(state, "p1");
            ((WidgetChannelsList) this.receiver).handleGlobalStatusIndicatorState(state);
        }
    }

    public WidgetChannelsList() {
        super(C5419R.layout.widget_channels_list);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelsList$binding$2.INSTANCE, null, 2, null);
        this.bottomNavViewObserver = BottomNavViewObserver.INSTANCE.getINSTANCE();
        this.storeNavigation = StoreStream.INSTANCE.getNavigation();
        this.globalStatusIndicatorStateObserver = WidgetGlobalStatusIndicatorState.INSTANCE.get();
        this.activityResult = HubUtilsKt.getAddServerActivityResultHandler(this);
        this.bannerChangeDetector = new MGImages.DistinctChangeDetector();
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsList widgetChannelsList) {
        WidgetChannelsListAdapter widgetChannelsListAdapter = widgetChannelsList.adapter;
        if (widgetChannelsListAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        return widgetChannelsListAdapter;
    }

    private final void ackPremiumGuildHint() {
        StoreStream.INSTANCE.getNux().setPremiumGuildHintGuildId(null);
    }

    private final void configureBottomNavSpace() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(this.bottomNavViewObserver.observeHeight(), this, null, 2, null), (Class<?>) WidgetChannelsList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74241());
    }

    private final void configureHeaderColors(Guild guild, boolean hasBanner) {
        getBinding().f15974g.setTextColor(getTintColor(requireContext(), guild, this.isCollapsed));
        getBinding().f15974g.setShadowLayer(1.0f, 0.0f, 4.0f, (!hasBanner || this.isCollapsed) ? ColorCompat.getThemedColor(this, C5419R.attr.colorBackgroundSecondary) : ColorCompat.getColor(this, C5419R.color.black_alpha_80));
        FrameLayout frameLayout = getBinding().f15972e;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.channelsListBannerForeground");
        frameLayout.setVisibility(hasBanner && !this.isCollapsed ? 0 : 8);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0004  */
    private final void configureHeaderIcons(Guild guild, boolean isCollapsed) {
        int i;
        if (guild == null) {
            i = 0;
        } else if (guild.getFeatures().contains(GuildFeature.VERIFIED)) {
            i = getBinding().f15969b.m8542a() ? C5419R.drawable.ic_verified_badge : C5419R.drawable.ic_verified_badge_banner;
        } else if (guild.getFeatures().contains(GuildFeature.PARTNERED)) {
            i = getBinding().f15969b.m8542a() ? C5419R.drawable.ic_partnered_badge : C5419R.drawable.ic_partnered_badge_banner;
        } else if (guild.getPremiumTier() == 0 && guild.getPremiumSubscriptionCount() > 0) {
            i = getBinding().f15969b.m8542a() ? C5419R.drawable.ic_guild_nitro_progress : C5419R.drawable.ic_guild_nitro_progress_banner;
        } else if (guild.getPremiumTier() == 1) {
            i = getBinding().f15969b.m8542a() ? C5419R.drawable.ic_guild_badge_premium_tier_1 : C5419R.drawable.ic_guild_badge_premium_tier_1_banner;
        } else if (guild.getPremiumTier() == 2) {
            i = getBinding().f15969b.m8542a() ? C5419R.drawable.ic_guild_badge_premium_tier_2 : C5419R.drawable.ic_guild_badge_premium_tier_2_banner;
        } else if (guild.getPremiumTier() == 3) {
            i = getBinding().f15969b.m8542a() ? C5419R.drawable.ic_guild_badge_premium_tier_3 : C5419R.drawable.ic_guild_badge_premium_tier_3_banner;
        } else {
            i = 0;
        }
        TextView textView = getBinding().f15974g;
        Drawable drawable = i == 0 ? null : ContextCompat.getDrawable(requireContext(), i);
        Drawable drawable2 = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.ic_more, 0, 2, (Object) null));
        if (drawable2 != null) {
            ColorCompatKt.setTint(drawable2, getTintColor(requireContext(), guild, isCollapsed), false);
        } else {
            drawable2 = null;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, drawable2, (Drawable) null);
    }

    private final void configureUI(WidgetChannelListModel list) {
        final Guild selectedGuild = list.getSelectedGuild();
        boolean z2 = (selectedGuild != null ? selectedGuild.getBanner() : null) != null;
        EmptyFriendsStateView emptyFriendsStateView = getBinding().f15983p;
        C12238m.checkNotNullExpressionValue(emptyFriendsStateView, "binding.widgetChannelsListEmptyFriendsStateView");
        emptyFriendsStateView.setVisibility(list.getShowEmptyState() ? 0 : 8);
        RecyclerView recyclerView = getBinding().f15970c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.channelsList");
        recyclerView.setVisibility(list.getShowEmptyState() ? 4 : 0);
        if (!C12238m.areEqual(this.selectedGuildId, selectedGuild != null ? Long.valueOf(selectedGuild.getId()) : null)) {
            if (z2) {
                getBinding().f15970c.scrollToPosition(0);
                getBinding().f15969b.setExpanded(true);
                configureHeaderColors(list.getSelectedGuild(), true);
            }
            Long lValueOf = selectedGuild != null ? Long.valueOf(selectedGuild.getId()) : null;
            this.selectedGuildId = lValueOf;
            if (lValueOf != null) {
                long jLongValue = lValueOf.longValue();
                WidgetChannelsListAdapter widgetChannelsListAdapter = this.adapter;
                if (widgetChannelsListAdapter == null) {
                    C12238m.throwUninitializedPropertyAccessException("adapter");
                }
                widgetChannelsListAdapter.setSelectedGuildId(jLongValue);
            }
        }
        WidgetChannelsListAdapter widgetChannelsListAdapter2 = this.adapter;
        if (widgetChannelsListAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter2.setData(list.getItems());
        CollapsingToolbarLayout collapsingToolbarLayout = getBinding().f15981n;
        C12238m.checkNotNullExpressionValue(collapsingToolbarLayout, "binding.collapsingToolbar");
        collapsingToolbarLayout.setVisibility(list.isGuildSelected() ? 0 : 8);
        CollapsingToolbarLayout collapsingToolbarLayout2 = getBinding().f15981n;
        C12238m.checkNotNullExpressionValue(collapsingToolbarLayout2, "binding.collapsingToolbar");
        ViewGroup.LayoutParams layoutParams = collapsingToolbarLayout2.getLayoutParams();
        if (!(layoutParams instanceof AppBarLayout.LayoutParams)) {
            layoutParams = null;
        }
        AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.setScrollFlags((list.isGuildSelected() && z2) ? 5 : 0);
        }
        Toolbar toolbar = getBinding().f15977j;
        C12238m.checkNotNullExpressionValue(toolbar, "binding.channelsListPrivateChannelsHeader");
        toolbar.setVisibility(!list.isGuildSelected() && !list.getShowEmptyState() ? 0 : 8);
        TextView textView = getBinding().f15978k;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelsListSearch");
        textView.setVisibility(list.isGuildSelected() ^ true ? 0 : 8);
        getBinding().f15974g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsList.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelsList.this.ackPremiumGuildHint();
                WidgetGuildProfileSheet.Companion companion = WidgetGuildProfileSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetChannelsList.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                Guild guild = selectedGuild;
                companion.show(parentFragmentManager, true, guild != null ? guild.getId() : 0L, (8 & 8) != 0 ? 0L : 0L, (8 & 16) != 0 ? false : false);
            }
        });
        TextView textView2 = getBinding().f15974g;
        C12238m.checkNotNullExpressionValue(textView2, "binding.channelsListHeader");
        textView2.setText(selectedGuild != null ? selectedGuild.getName() : null);
        configureHeaderIcons(selectedGuild, false);
        SimpleDraweeView simpleDraweeView = getBinding().f15971d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListBanner");
        simpleDraweeView.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = getBinding().f15972e;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.channelsListBannerForeground");
        frameLayout.setVisibility(z2 && !this.isCollapsed ? 0 : 8);
        if (z2) {
            SimpleDraweeView simpleDraweeView2 = getBinding().f15971d;
            ViewGroup.LayoutParams layoutParams3 = simpleDraweeView2.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
            marginLayoutParams.bottomMargin = !list.getStartsWithPaddedElement() ? DimenUtils.dpToPixels(8) : 0;
            simpleDraweeView2.setLayoutParams(marginLayoutParams);
            boolean zCanHaveAnimatedBanner = selectedGuild != null ? selectedGuild.canHaveAnimatedBanner() : false;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "this");
            MGImages.setImage$default(simpleDraweeView2, IconUtils.INSTANCE.getBannerForGuild(selectedGuild, Integer.valueOf(simpleDraweeView2.getResources().getDimensionPixelSize(C5419R.dimen.nav_panel_width)), zCanHaveAnimatedBanner), 0, 0, false, null, this.bannerChangeDetector, 60, null);
        }
        getBinding().f15969b.setOnPercentCollapsedCallback(new C74265(selectedGuild, list, z2));
        ConstraintLayout constraintLayout = getBinding().f15975h;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.channelsListPremiumGuildHint");
        constraintLayout.setVisibility(list.getShowPremiumGuildHint() ? 0 : 8);
    }

    private final WidgetChannelsListBinding getBinding() {
        return (WidgetChannelsListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getTintColor(Context context, Guild guild, boolean isCollapsed) {
        return ((guild != null ? guild.getBanner() : null) == null || isCollapsed) ? ColorCompat.getThemedColor(context, C5419R.attr.colorInteractiveActive) : ColorCompat.getColor(context, C5419R.color.white);
    }

    private final void handleGlobalStatusIndicatorState(WidgetGlobalStatusIndicatorState.State state) {
        if (state.isCustomBackground()) {
            unroundPanelCorners();
        } else {
            roundPanelCorners();
        }
    }

    private final void roundPanelCorners() {
        float fDpToPixels = DimenUtils.dpToPixels(8);
        getBinding().f15982o.updateTopLeftRadius(fDpToPixels);
        getBinding().f15982o.updateTopRightRadius(fDpToPixels);
    }

    private final void unroundPanelCorners() {
        getBinding().f15982o.updateTopLeftRadius(0.0f);
        getBinding().f15982o.updateTopRightRadius(0.0f);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f15983p.updateView(ANALYTICS_SOURCE);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f15970c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.channelsList");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetChannelsListAdapter widgetChannelsListAdapter = (WidgetChannelsListAdapter) companion.configure(new WidgetChannelsListAdapter(recyclerView, parentFragmentManager));
        this.adapter = widgetChannelsListAdapter;
        if (widgetChannelsListAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter.setOnSelectChannel(new C74271());
        WidgetChannelsListAdapter widgetChannelsListAdapter2 = this.adapter;
        if (widgetChannelsListAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter2.setOnSelectChannelOptions(new C74342());
        WidgetChannelsListAdapter widgetChannelsListAdapter3 = this.adapter;
        if (widgetChannelsListAdapter3 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter3.setOnCallChannel(new C74353());
        WidgetChannelsListAdapter widgetChannelsListAdapter4 = this.adapter;
        if (widgetChannelsListAdapter4 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter4.setOnSelectGuildRoleSubscriptionLockedChannel(new C74364());
        WidgetChannelsListAdapter widgetChannelsListAdapter5 = this.adapter;
        if (widgetChannelsListAdapter5 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter5.setOnCollapseCategory(new C74375());
        WidgetChannelsListAdapter widgetChannelsListAdapter6 = this.adapter;
        if (widgetChannelsListAdapter6 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter6.setOnSelectInvite(new C74386());
        WidgetChannelsListAdapter widgetChannelsListAdapter7 = this.adapter;
        if (widgetChannelsListAdapter7 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter7.setOnSelectUserOptions(new C74397());
        WidgetChannelsListAdapter widgetChannelsListAdapter8 = this.adapter;
        if (widgetChannelsListAdapter8 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter8.setOnViewGuildScheduledEvents(new C74408());
        WidgetChannelsListAdapter widgetChannelsListAdapter9 = this.adapter;
        if (widgetChannelsListAdapter9 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter9.setOnViewGuildRoleSubscriptions(new C74419());
        WidgetChannelsListAdapter widgetChannelsListAdapter10 = this.adapter;
        if (widgetChannelsListAdapter10 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter10.setOnAddServer(new C742810());
        getBinding().f15978k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsList.onViewBound.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGlobalSearchDialog.Companion companion2 = WidgetGlobalSearchDialog.INSTANCE;
                FragmentManager parentFragmentManager2 = WidgetChannelsList.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                companion2.show(parentFragmentManager2, "@");
            }
        });
        getBinding().f15970c.setHasFixedSize(false);
        RecyclerView recyclerView2 = getBinding().f15970c;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.channelsList");
        recyclerView2.setItemAnimator(null);
        ViewStub viewStub = getBinding().f15980m;
        C12238m.checkNotNullExpressionValue(viewStub, "binding.channelsListUnreadsStub");
        RecyclerView recyclerView3 = getBinding().f15970c;
        C12238m.checkNotNullExpressionValue(recyclerView3, "binding.channelsList");
        this.channelListUnreads = new WidgetChannelListUnreads(viewStub, recyclerView3, getBinding().f15969b, new C743012(), 0, 0, false, 112, null);
        WidgetChannelsListAdapter widgetChannelsListAdapter11 = this.adapter;
        if (widgetChannelsListAdapter11 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter11.setOnUpdated(new C743113());
        getBinding().f15976i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsList.onViewBound.14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChannelsList.this.ackPremiumGuildHint();
            }
        });
        getBinding().f15979l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsList.onViewBound.15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (!GroupInviteFriendsSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                    WidgetGroupInviteFriends.INSTANCE.launch(WidgetChannelsList.this.requireContext(), WidgetChannelsList.ANALYTICS_SOURCE);
                    return;
                }
                GroupInviteFriendsSheet.Companion companion2 = GroupInviteFriendsSheet.INSTANCE;
                FragmentManager parentFragmentManager2 = WidgetChannelsList.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                GroupInviteFriendsSheet.Companion.show$default(companion2, parentFragmentManager2, 0L, WidgetChannelsList.ANALYTICS_SOURCE, 2, null);
            }
        });
        ViewCompat.setAccessibilityHeading(getBinding().f15974g, true);
        ViewCompat.setAccessibilityHeading(getBinding().f15973f, true);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(WidgetChannelListModel.INSTANCE.get());
        WidgetChannelsListAdapter widgetChannelsListAdapter = this.adapter;
        if (widgetChannelsListAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8519ui(observableComputationLatest, this, widgetChannelsListAdapter), (Class<?>) WidgetChannelsList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74421(this));
        if (getMostRecentIntent().getBooleanExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL", false)) {
            StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, StoreNavigation.PanelAction.OPEN, null, 2, null);
            getMostRecentIntent().removeExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL");
        }
        configureBottomNavSpace();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(this.globalStatusIndicatorStateObserver.observeState(), this, null, 2, null), (Class<?>) WidgetChannelsList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74432(this));
    }
}
