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
import b.a.d.AppScreen2;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelsListBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.hubs.HubUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetFeatureFlag;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
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
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelsList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListBinding;", 0)};

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$configureBottomNavSpace$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetChannelsList.access$getAdapter$p(WidgetChannelsList.this).handleBottomNavHeight(i);
            ViewStub viewStub = WidgetChannelsList.this.getBinding().m;
            Intrinsics3.checkNotNullExpressionValue(viewStub, "binding.channelsListUnreadsStub");
            ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i);
            ViewStub viewStub2 = WidgetChannelsList.this.getBinding().m;
            Intrinsics3.checkNotNullExpressionValue(viewStub2, "binding.channelsListUnreadsStub");
            viewStub2.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$configureUI$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Float, Unit> {
        public final /* synthetic */ Guild $guild;
        public final /* synthetic */ boolean $hasBanner;
        public final /* synthetic */ WidgetChannelListModel $list;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Guild guild, WidgetChannelListModel widgetChannelListModel, boolean z2) {
            super(1);
            this.$guild = guild;
            this.$list = widgetChannelListModel;
            this.$hasBanner = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
            invoke(f.floatValue());
            return Unit.a;
        }

        public final void invoke(float f) {
            SimpleDraweeView simpleDraweeView = WidgetChannelsList.this.getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListBanner");
            simpleDraweeView.setAlpha(1.0f - f);
            boolean zA = WidgetChannelsList.this.getBinding().f2282b.a();
            if (WidgetChannelsList.this.isCollapsed != zA) {
                WidgetChannelsList.this.isCollapsed = zA;
                WidgetChannelsList widgetChannelsList = WidgetChannelsList.this;
                widgetChannelsList.configureHeaderIcons(this.$guild, widgetChannelsList.isCollapsed);
                WidgetChannelsList.this.configureHeaderColors(this.$list.getSelectedGuild(), this.$hasBanner);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel == null) {
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, 0L, null, null, 12, null);
                return;
            }
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, StoreChannelsSelected3.CHANNEL_LIST, 2, null);
            if (!ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null) && ChannelUtils.q(channel)) {
                WidgetThreadBrowser.INSTANCE.show(WidgetChannelsList.this.getContext(), channel.getGuildId(), channel.getId(), "Forum");
            }
            StoreNavigation.setNavigationPanelAction$default(WidgetChannelsList.this.storeNavigation, StoreNavigation.PanelAction.UNLOCK_LEFT, null, 2, null);
            StoreNavigation.setNavigationPanelAction$default(WidgetChannelsList.this.storeNavigation, StoreNavigation.PanelAction.CLOSE, null, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$10, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass10 extends Lambda implements Function0<Unit> {
        public AnonymousClass10() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppScreen2.g.f(WidgetChannelsList.this.requireContext(), WidgetChannelsList.this.activityResult, WidgetHubAddServer.class, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$12, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass12 extends Lambda implements Function0<Integer> {
        public AnonymousClass12() {
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

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$13, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass13 extends Lambda implements Function2<List<? extends ChannelListItem>, List<? extends ChannelListItem>, Unit> {
        public AnonymousClass13() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChannelListItem> list, List<? extends ChannelListItem> list2) {
            invoke2(list, list2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ChannelListItem> list, List<? extends ChannelListItem> list2) {
            Intrinsics3.checkNotNullParameter(list, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(list2, "newData");
            WidgetChannelListUnreads widgetChannelListUnreads = WidgetChannelsList.this.channelListUnreads;
            if (widgetChannelListUnreads != null) {
                widgetChannelListUnreads.onDatasetChanged(list2);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
                            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                            companion.show(parentFragmentManager, channel.getId());
                            break;
                    }
                }
            }
            WidgetChannelsListItemChannelActions.Companion companion2 = WidgetChannelsListItemChannelActions.INSTANCE;
            FragmentManager parentFragmentManager2 = WidgetChannelsList.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            companion2.show(parentFragmentManager2, channel.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            VoiceUtils.handleCallChannel(channel, WidgetChannelsList.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Long l = WidgetChannelsList.this.selectedGuildId;
            if (l != null) {
                WidgetGuildRoleSubscriptionEntryPoint.INSTANCE.launch(WidgetChannelsList.this.requireContext(), l.longValue(), "Role Subscription Gated Channel");
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass5 extends Lambda implements Function2<Channel, Boolean, Unit> {
        public AnonymousClass5() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel, Boolean bool) {
            invoke(channel, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(Channel channel, boolean z2) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Object systemService = WidgetChannelsList.access$getAdapter$p(WidgetChannelsList.this).getContext().getSystemService("accessibility");
            if (systemService instanceof AccessibilityManager) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                Intrinsics3.checkNotNullExpressionValue(accessibilityEventObtain, "event");
                accessibilityEventObtain.setEventType(16384);
                Object[] objArr = new Object[2];
                objArr[0] = WidgetChannelsList.this.getString(z2 ? R.string.expanded : R.string.collapsed);
                objArr[1] = ChannelUtils.c(channel);
                accessibilityEventObtain.getText().add(outline.P(objArr, 2, "%s %s", "java.lang.String.format(format, *args)"));
                try {
                    ((AccessibilityManager) systemService).sendAccessibilityEvent(accessibilityEventObtain);
                } catch (IllegalStateException unused) {
                }
            }
            StoreStream.INSTANCE.getStoreChannelCategories().setCollapsedCategory(channel.getGuildId(), channel.getId(), !z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass6 extends Lambda implements Function1<View, Unit> {
        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            Long l = WidgetChannelsList.this.selectedGuildId;
            if (l != null) {
                long jLongValue = l.longValue();
                ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getInviteSettings().generateInviteDefaultChannel(jLongValue), WidgetChannelsList.this, null, 2, null).k(o.a.g(WidgetChannelsList.this.getContext(), new WidgetChannelsList3(jLongValue, this, view), null));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$7, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass7 extends Lambda implements Function2<User, Channel, Unit> {
        public AnonymousClass7() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(User user, Channel channel) {
            invoke2(user, channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user, Channel channel) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = user.getId();
            Long lValueOf = Long.valueOf(channel.getId());
            FragmentManager parentFragmentManager = WidgetChannelsList.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, parentFragmentManager, Long.valueOf(channel.getGuildId()), Boolean.valueOf(ChannelUtils.J(channel)), null, null, 96, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$8, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass8 extends Lambda implements Function1<Guild, Unit> {
        public AnonymousClass8() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            Object next;
            Intrinsics3.checkNotNullParameter(guild, "guild");
            if (!guild.isHub()) {
                WidgetGuildScheduledEventListBottomSheet.Companion companion = WidgetGuildScheduledEventListBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetChannelsList.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
            } while (!ChannelUtils.o((Channel) next));
            Channel channel = (Channel) next;
            if (channel != null) {
                WidgetHubEventsPage.Companion companion2 = WidgetHubEventsPage.INSTANCE;
                FragmentManager parentFragmentManager2 = WidgetChannelsList.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                companion2.show(parentFragmentManager2, guild.getId(), channel.getId());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$9, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final class AnonymousClass9 extends Lambda implements Function0<Unit> {
        public AnonymousClass9() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Long l = WidgetChannelsList.this.selectedGuildId;
            if (l != null) {
                WidgetGuildRoleSubscriptionEntryPoint.INSTANCE.launch(WidgetChannelsList.this.requireContext(), l.longValue(), "Role Subscriptions Tab");
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetChannelListModel, Unit> {
        public AnonymousClass1(WidgetChannelsList widgetChannelsList) {
            super(1, widgetChannelsList, WidgetChannelsList.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/list/WidgetChannelListModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelListModel widgetChannelListModel) {
            invoke2(widgetChannelListModel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelListModel widgetChannelListModel) {
            Intrinsics3.checkNotNullParameter(widgetChannelListModel, "p1");
            ((WidgetChannelsList) this.receiver).configureUI(widgetChannelListModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsList.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetGlobalStatusIndicatorState.State, Unit> {
        public AnonymousClass2(WidgetChannelsList widgetChannelsList) {
            super(1, widgetChannelsList, WidgetChannelsList.class, "handleGlobalStatusIndicatorState", "handleGlobalStatusIndicatorState(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState.State state) {
            invoke2(state);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorState.State state) {
            Intrinsics3.checkNotNullParameter(state, "p1");
            ((WidgetChannelsList) this.receiver).handleGlobalStatusIndicatorState(state);
        }
    }

    public WidgetChannelsList() {
        super(R.layout.widget_channels_list);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelsList2.INSTANCE, null, 2, null);
        this.bottomNavViewObserver = BottomNavViewObserver.INSTANCE.getINSTANCE();
        this.storeNavigation = StoreStream.INSTANCE.getNavigation();
        this.globalStatusIndicatorStateObserver = WidgetGlobalStatusIndicatorState.INSTANCE.get();
        this.activityResult = HubUtils.getAddServerActivityResultHandler(this);
        this.bannerChangeDetector = new MGImages.DistinctChangeDetector();
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsList widgetChannelsList) {
        WidgetChannelsListAdapter widgetChannelsListAdapter = widgetChannelsList.adapter;
        if (widgetChannelsListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        return widgetChannelsListAdapter;
    }

    private final void ackPremiumGuildHint() {
        StoreStream.INSTANCE.getNux().setPremiumGuildHintGuildId(null);
    }

    private final void configureBottomNavSpace() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(this.bottomNavViewObserver.observeHeight(), this, null, 2, null), (Class<?>) WidgetChannelsList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    private final void configureHeaderColors(Guild guild, boolean hasBanner) {
        getBinding().g.setTextColor(getTintColor(requireContext(), guild, this.isCollapsed));
        getBinding().g.setShadowLayer(1.0f, 0.0f, 4.0f, (!hasBanner || this.isCollapsed) ? ColorCompat.getThemedColor(this, R.attr.colorBackgroundSecondary) : ColorCompat.getColor(this, R.color.black_alpha_80));
        FrameLayout frameLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.channelsListBannerForeground");
        frameLayout.setVisibility(hasBanner && !this.isCollapsed ? 0 : 8);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0004  */
    private final void configureHeaderIcons(Guild guild, boolean isCollapsed) {
        int i;
        if (guild == null) {
            i = 0;
        } else if (guild.getFeatures().contains(GuildFeature.VERIFIED)) {
            i = getBinding().f2282b.a() ? R.drawable.ic_verified_badge : R.drawable.ic_verified_badge_banner;
        } else if (guild.getFeatures().contains(GuildFeature.PARTNERED)) {
            i = getBinding().f2282b.a() ? R.drawable.ic_partnered_badge : R.drawable.ic_partnered_badge_banner;
        } else if (guild.getPremiumTier() == 0 && guild.getPremiumSubscriptionCount() > 0) {
            i = getBinding().f2282b.a() ? R.drawable.ic_guild_nitro_progress : R.drawable.ic_guild_nitro_progress_banner;
        } else if (guild.getPremiumTier() == 1) {
            i = getBinding().f2282b.a() ? R.drawable.ic_guild_badge_premium_tier_1 : R.drawable.ic_guild_badge_premium_tier_1_banner;
        } else if (guild.getPremiumTier() == 2) {
            i = getBinding().f2282b.a() ? R.drawable.ic_guild_badge_premium_tier_2 : R.drawable.ic_guild_badge_premium_tier_2_banner;
        } else if (guild.getPremiumTier() == 3) {
            i = getBinding().f2282b.a() ? R.drawable.ic_guild_badge_premium_tier_3 : R.drawable.ic_guild_badge_premium_tier_3_banner;
        } else {
            i = 0;
        }
        TextView textView = getBinding().g;
        Drawable drawable = i == 0 ? null : ContextCompat.getDrawable(requireContext(), i);
        Drawable drawable2 = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.ic_more, 0, 2, (Object) null));
        if (drawable2 != null) {
            ColorCompat2.setTint(drawable2, getTintColor(requireContext(), guild, isCollapsed), false);
        } else {
            drawable2 = null;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, drawable2, (Drawable) null);
    }

    private final void configureUI(WidgetChannelListModel list) {
        final Guild selectedGuild = list.getSelectedGuild();
        boolean z2 = (selectedGuild != null ? selectedGuild.getBanner() : null) != null;
        EmptyFriendsStateView emptyFriendsStateView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(emptyFriendsStateView, "binding.widgetChannelsListEmptyFriendsStateView");
        emptyFriendsStateView.setVisibility(list.getShowEmptyState() ? 0 : 8);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.channelsList");
        recyclerView.setVisibility(list.getShowEmptyState() ? 4 : 0);
        if (!Intrinsics3.areEqual(this.selectedGuildId, selectedGuild != null ? Long.valueOf(selectedGuild.getId()) : null)) {
            if (z2) {
                getBinding().c.scrollToPosition(0);
                getBinding().f2282b.setExpanded(true);
                configureHeaderColors(list.getSelectedGuild(), true);
            }
            Long lValueOf = selectedGuild != null ? Long.valueOf(selectedGuild.getId()) : null;
            this.selectedGuildId = lValueOf;
            if (lValueOf != null) {
                long jLongValue = lValueOf.longValue();
                WidgetChannelsListAdapter widgetChannelsListAdapter = this.adapter;
                if (widgetChannelsListAdapter == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("adapter");
                }
                widgetChannelsListAdapter.setSelectedGuildId(jLongValue);
            }
        }
        WidgetChannelsListAdapter widgetChannelsListAdapter2 = this.adapter;
        if (widgetChannelsListAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter2.setData(list.getItems());
        CollapsingToolbarLayout collapsingToolbarLayout = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(collapsingToolbarLayout, "binding.collapsingToolbar");
        collapsingToolbarLayout.setVisibility(list.isGuildSelected() ? 0 : 8);
        CollapsingToolbarLayout collapsingToolbarLayout2 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(collapsingToolbarLayout2, "binding.collapsingToolbar");
        ViewGroup.LayoutParams layoutParams = collapsingToolbarLayout2.getLayoutParams();
        if (!(layoutParams instanceof AppBarLayout.LayoutParams)) {
            layoutParams = null;
        }
        AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.setScrollFlags((list.isGuildSelected() && z2) ? 5 : 0);
        }
        Toolbar toolbar = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(toolbar, "binding.channelsListPrivateChannelsHeader");
        toolbar.setVisibility(!list.isGuildSelected() && !list.getShowEmptyState() ? 0 : 8);
        TextView textView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelsListSearch");
        textView.setVisibility(list.isGuildSelected() ^ true ? 0 : 8);
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsList.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelsList.this.ackPremiumGuildHint();
                WidgetGuildProfileSheet.Companion companion = WidgetGuildProfileSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetChannelsList.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                Guild guild = selectedGuild;
                companion.show(parentFragmentManager, true, guild != null ? guild.getId() : 0L, (8 & 8) != 0 ? 0L : 0L, (8 & 16) != 0 ? false : false);
            }
        });
        TextView textView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelsListHeader");
        textView2.setText(selectedGuild != null ? selectedGuild.getName() : null);
        configureHeaderIcons(selectedGuild, false);
        SimpleDraweeView simpleDraweeView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListBanner");
        simpleDraweeView.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.channelsListBannerForeground");
        frameLayout.setVisibility(z2 && !this.isCollapsed ? 0 : 8);
        if (z2) {
            SimpleDraweeView simpleDraweeView2 = getBinding().d;
            ViewGroup.LayoutParams layoutParams3 = simpleDraweeView2.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
            marginLayoutParams.bottomMargin = !list.getStartsWithPaddedElement() ? DimenUtils.dpToPixels(8) : 0;
            simpleDraweeView2.setLayoutParams(marginLayoutParams);
            boolean zCanHaveAnimatedBanner = selectedGuild != null ? selectedGuild.canHaveAnimatedBanner() : false;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "this");
            MGImages.setImage$default(simpleDraweeView2, IconUtils.INSTANCE.getBannerForGuild(selectedGuild, Integer.valueOf(simpleDraweeView2.getResources().getDimensionPixelSize(R.dimen.nav_panel_width)), zCanHaveAnimatedBanner), 0, 0, false, null, this.bannerChangeDetector, 60, null);
        }
        getBinding().f2282b.setOnPercentCollapsedCallback(new AnonymousClass5(selectedGuild, list, z2));
        ConstraintLayout constraintLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.channelsListPremiumGuildHint");
        constraintLayout.setVisibility(list.getShowPremiumGuildHint() ? 0 : 8);
    }

    private final WidgetChannelsListBinding getBinding() {
        return (WidgetChannelsListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getTintColor(Context context, Guild guild, boolean isCollapsed) {
        return ((guild != null ? guild.getBanner() : null) == null || isCollapsed) ? ColorCompat.getThemedColor(context, R.attr.colorInteractiveActive) : ColorCompat.getColor(context, R.color.white);
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
        getBinding().o.updateTopLeftRadius(fDpToPixels);
        getBinding().o.updateTopRightRadius(fDpToPixels);
    }

    private final void unroundPanelCorners() {
        getBinding().o.updateTopLeftRadius(0.0f);
        getBinding().o.updateTopRightRadius(0.0f);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().p.updateView(ANALYTICS_SOURCE);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.channelsList");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetChannelsListAdapter widgetChannelsListAdapter = (WidgetChannelsListAdapter) companion.configure(new WidgetChannelsListAdapter(recyclerView, parentFragmentManager));
        this.adapter = widgetChannelsListAdapter;
        if (widgetChannelsListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter.setOnSelectChannel(new AnonymousClass1());
        WidgetChannelsListAdapter widgetChannelsListAdapter2 = this.adapter;
        if (widgetChannelsListAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter2.setOnSelectChannelOptions(new AnonymousClass2());
        WidgetChannelsListAdapter widgetChannelsListAdapter3 = this.adapter;
        if (widgetChannelsListAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter3.setOnCallChannel(new AnonymousClass3());
        WidgetChannelsListAdapter widgetChannelsListAdapter4 = this.adapter;
        if (widgetChannelsListAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter4.setOnSelectGuildRoleSubscriptionLockedChannel(new AnonymousClass4());
        WidgetChannelsListAdapter widgetChannelsListAdapter5 = this.adapter;
        if (widgetChannelsListAdapter5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter5.setOnCollapseCategory(new AnonymousClass5());
        WidgetChannelsListAdapter widgetChannelsListAdapter6 = this.adapter;
        if (widgetChannelsListAdapter6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter6.setOnSelectInvite(new AnonymousClass6());
        WidgetChannelsListAdapter widgetChannelsListAdapter7 = this.adapter;
        if (widgetChannelsListAdapter7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter7.setOnSelectUserOptions(new AnonymousClass7());
        WidgetChannelsListAdapter widgetChannelsListAdapter8 = this.adapter;
        if (widgetChannelsListAdapter8 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter8.setOnViewGuildScheduledEvents(new AnonymousClass8());
        WidgetChannelsListAdapter widgetChannelsListAdapter9 = this.adapter;
        if (widgetChannelsListAdapter9 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter9.setOnViewGuildRoleSubscriptions(new AnonymousClass9());
        WidgetChannelsListAdapter widgetChannelsListAdapter10 = this.adapter;
        if (widgetChannelsListAdapter10 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter10.setOnAddServer(new AnonymousClass10());
        getBinding().k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsList.onViewBound.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGlobalSearchDialog.Companion companion2 = WidgetGlobalSearchDialog.INSTANCE;
                FragmentManager parentFragmentManager2 = WidgetChannelsList.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                companion2.show(parentFragmentManager2, "@");
            }
        });
        getBinding().c.setHasFixedSize(false);
        RecyclerView recyclerView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.channelsList");
        recyclerView2.setItemAnimator(null);
        ViewStub viewStub = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(viewStub, "binding.channelsListUnreadsStub");
        RecyclerView recyclerView3 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.channelsList");
        this.channelListUnreads = new WidgetChannelListUnreads(viewStub, recyclerView3, getBinding().f2282b, new AnonymousClass12(), 0, 0, false, 112, null);
        WidgetChannelsListAdapter widgetChannelsListAdapter11 = this.adapter;
        if (widgetChannelsListAdapter11 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter11.setOnUpdated(new AnonymousClass13());
        getBinding().i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsList.onViewBound.14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChannelsList.this.ackPremiumGuildHint();
            }
        });
        getBinding().l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetChannelsList.onViewBound.15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (!GroupInviteFriendsSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                    WidgetGroupInviteFriends.INSTANCE.launch(WidgetChannelsList.this.requireContext(), WidgetChannelsList.ANALYTICS_SOURCE);
                    return;
                }
                GroupInviteFriendsSheet.Companion companion2 = GroupInviteFriendsSheet.INSTANCE;
                FragmentManager parentFragmentManager2 = WidgetChannelsList.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                GroupInviteFriendsSheet.Companion.show$default(companion2, parentFragmentManager2, 0L, WidgetChannelsList.ANALYTICS_SOURCE, 2, null);
            }
        });
        ViewCompat.setAccessibilityHeading(getBinding().g, true);
        ViewCompat.setAccessibilityHeading(getBinding().f, true);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(WidgetChannelListModel.INSTANCE.get());
        WidgetChannelsListAdapter widgetChannelsListAdapter = this.adapter;
        if (widgetChannelsListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observableComputationLatest, this, widgetChannelsListAdapter), (Class<?>) WidgetChannelsList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        if (getMostRecentIntent().getBooleanExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL", false)) {
            StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, StoreNavigation.PanelAction.OPEN, null, 2, null);
            getMostRecentIntent().removeExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL");
        }
        configureBottomNavSpace();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(this.globalStatusIndicatorStateObserver.observeState(), this, null, 2, null), (Class<?>) WidgetChannelsList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
