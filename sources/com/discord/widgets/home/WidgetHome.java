package com.discord.widgets.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.panels.OverlappingPanelsLayout;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreConnectionOpen;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUser;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.surveys.SurveyUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.accessibility.AccessibilityDetectionNavigator;
import com.discord.widgets.botuikit.ModalComponent;
import com.discord.widgets.channels.WidgetChannelOnboarding;
import com.discord.widgets.chat.input.SmoothKeyboardReactionHelper;
import com.discord.widgets.chat.list.WidgetChatList;
import com.discord.widgets.directories.WidgetDirectoryChannel;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet;
import com.discord.widgets.hubs.HubEmailArgs;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.notice.WidgetNoticeNuxSamsungLink;
import com.discord.widgets.playstation.WidgetPlaystationIntegrationUpsellBottomSheet;
import com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.google.android.material.appbar.AppBarLayout;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p009a.C0843t;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p025i.C0980i5;
import p007b.p008a.p025i.C0987j5;
import p007b.p008a.p025i.C0994k5;
import p007b.p008a.p025i.C1001l5;
import p007b.p008a.p025i.C1015n5;
import p007b.p008a.p039o.C1174a;
import p007b.p008a.p039o.ViewOnLayoutChangeListenerC1175b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func0;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome extends AppFragment implements OnTabSelectedListener, ViewOnLayoutChangeListenerC1175b.a {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetHome.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHomeBinding;", 0)};
    private static final long DELAY_DRAWER_OPEN_FINISH = 2000;
    private static final long DELAY_DRAWER_OPEN_START = 1000;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Set<Integer> fixedPositionViewIds;
    private final WidgetGlobalStatusIndicatorState globalStatusIndicatorStateObserver;
    private final LeftPanelManager leftPanelManager;
    private final LocaleManager localeManager;
    private Function1<? super View, Unit> onGuildListAddHintCreate;
    private WidgetHomePanelLoading panelLoading;
    private WidgetHomePanelNsfw panelNsfw;
    private final StoreTabsNavigation storeTabsNavigation;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            OverlappingPanelsLayout.Panel.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[OverlappingPanelsLayout.Panel.END.ordinal()] = 1;
            iArr[OverlappingPanelsLayout.Panel.CENTER.ordinal()] = 2;
            iArr[OverlappingPanelsLayout.Panel.START.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89412 extends AbstractC12240o implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
                C12238m.checkNotNullParameter(nuxState, "it");
                return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 55, null);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetHome.this.getBinding().f17126c.openStartPanel();
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class AnonymousClass3 extends AbstractC12240o implements Function0<Unit> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetHome.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
                    C12238m.checkNotNullParameter(nuxState, "it");
                    return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, true, null, 39, null);
                }
            }

            public AnonymousClass3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.INSTANCE.getNux().updateNux(AnonymousClass1.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class AnonymousClass4 extends AbstractC12240o implements Function1<Function0<? extends Unit>, Unit> {
            public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

            public AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                invoke2((Function0<Unit>) function0);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function0<Unit> function0) {
                function0.invoke();
            }
        }

        public C89412() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (bool == null) {
                return;
            }
            if (!bool.booleanValue()) {
                StoreStream.INSTANCE.getNux().updateNux(AnonymousClass1.INSTANCE);
                return;
            }
            C12721k c12721k = new C12721k(new AnonymousClass2());
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Observable observableM11064I = Observable.m11064I(c12721k.m11111q(1000L, timeUnit), new C12721k(AnonymousClass3.INSTANCE).m11111q(WidgetHome.DELAY_DRAWER_OPEN_FINISH, timeUnit));
            C12238m.checkNotNullExpressionValue(observableM11064I, "Observable\n             …, TimeUnit.MILLISECONDS))");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11064I, WidgetHome.this, null, 2, null), (Class<?>) WidgetHome.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), AnonymousClass4.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureLeftPanel$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89421 extends AbstractC12240o implements Function1<OverlappingPanelsLayout.LockState, Unit> {
        public C89421() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OverlappingPanelsLayout.LockState lockState) {
            invoke2(lockState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OverlappingPanelsLayout.LockState lockState) {
            C12238m.checkNotNullParameter(lockState, "lockState");
            WidgetHome.this.getBinding().f17126c.setStartPanelUseFullPortraitWidth(lockState == OverlappingPanelsLayout.LockState.OPEN);
            WidgetHome.this.getBinding().f17126c.setStartPanelLockState(lockState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureNavigationDrawerAction$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89431 extends AbstractC12240o implements Function1<StoreNavigation.PanelAction, Unit> {
        public final /* synthetic */ StoreNavigation $this_configureNavigationDrawerAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C89431(StoreNavigation storeNavigation) {
            super(1);
            this.$this_configureNavigationDrawerAction = storeNavigation;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreNavigation.PanelAction panelAction) {
            invoke2(panelAction);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreNavigation.PanelAction panelAction) {
            C12238m.checkNotNullParameter(panelAction, "it");
            this.$this_configureNavigationDrawerAction.setNavigationPanelAction(panelAction, WidgetHome.this.getBinding().f17126c);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$handleViewState$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final /* synthetic */ class C89461 extends C12236k implements Function1<Boolean, Unit> {
        public C89461(WidgetHome widgetHome) {
            super(1, widgetHome, WidgetHome.class, "onNsfwToggle", "onNsfwToggle(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            ((WidgetHome) this.receiver).onNsfwToggle(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$maybeShowHubEmailUpsell$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89471 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
        public static final C89471 INSTANCE = new C89471();

        public C89471() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            C12238m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            C0870j.m156d(fragmentActivity, WidgetHubEmailFlow.class, new HubEmailArgs(null, 0, null, 7, null));
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onCreate$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89481 extends AbstractC12240o implements Function1<Context, Locale> {
        public C89481() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Locale invoke(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            return WidgetHome.this.localeManager.getPrimaryLocale(context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89513 extends AbstractC12240o implements Function1<StoreNux.NuxState, Unit> {
        public C89513() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreNux.NuxState nuxState) {
            invoke2(nuxState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreNux.NuxState nuxState) {
            boolean z2;
            boolean z3 = false;
            if (!nuxState.getFirstOpen()) {
                Collection<Guild> collectionValues = StoreStream.INSTANCE.getGuilds().getGuilds().values();
                if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                    Iterator<T> it = collectionValues.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = true;
                            break;
                        } else if (!(!((Guild) it.next()).isHub())) {
                            z2 = false;
                            break;
                        }
                    }
                } else {
                    z2 = true;
                    break;
                }
                if (z2 && GrowthTeamFeatures.INSTANCE.isHubEmailConnectionEnabled()) {
                    z3 = true;
                }
            }
            if (z3) {
                WidgetHome.this.maybeShowHubEmailUpsell();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89521 extends AbstractC12240o implements Function1<WidgetHomeViewModel.ViewState, Unit> {
        public C89521() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetHome.this.handleViewState(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$11 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C895411 extends AbstractC12240o implements Function1<MeUser, Unit> {
        public C895411() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            WidgetHome.this.showUrgentMessageDialog();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$12 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C895512 extends AbstractC12240o implements Function1<InteractionModalCreate, Unit> {
        public C895512() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InteractionModalCreate interactionModalCreate) {
            invoke2(interactionModalCreate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InteractionModalCreate interactionModalCreate) {
            C12238m.checkNotNullParameter(interactionModalCreate, "it");
            WidgetHome.this.showInteractionModal(interactionModalCreate);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$13 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final /* synthetic */ class C895613 extends C12236k implements Function1<WidgetGlobalStatusIndicatorState.State, Unit> {
        public C895613(WidgetHome widgetHome) {
            super(1, widgetHome, WidgetHome.class, "handleGlobalStatusIndicatorState", "handleGlobalStatusIndicatorState(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState.State state) {
            invoke2(state);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorState.State state) {
            C12238m.checkNotNullParameter(state, "p1");
            ((WidgetHome) this.receiver).handleGlobalStatusIndicatorState(state);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89572 extends AbstractC12240o implements Function1<WidgetHomeViewModel.Event, Unit> {
        public C89572() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetHome.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89583 extends AbstractC12240o implements Function1<WidgetHomeModel, Unit> {
        public C89583() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeModel widgetHomeModel) {
            invoke2(widgetHomeModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeModel widgetHomeModel) {
            C12238m.checkNotNullParameter(widgetHomeModel, "it");
            WidgetHome.this.configureUI(widgetHomeModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$5 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89605 extends AbstractC12240o implements Function1<WidgetHomeModel, Unit> {
        public C89605() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeModel widgetHomeModel) {
            invoke2(widgetHomeModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeModel widgetHomeModel) {
            WidgetHome widgetHome = WidgetHome.this;
            C12238m.checkNotNullExpressionValue(widgetHomeModel, "it");
            widgetHome.maybeToggleChannel(widgetHomeModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$7 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final /* synthetic */ class C89627 extends C12236k implements Function1<SurveyUtils.Survey, Unit> {
        public C89627(WidgetHome widgetHome) {
            super(1, widgetHome, WidgetHome.class, "showSurvey", "showSurvey(Lcom/discord/utilities/surveys/SurveyUtils$Survey;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SurveyUtils.Survey survey) {
            invoke2(survey);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SurveyUtils.Survey survey) {
            C12238m.checkNotNullParameter(survey, "p1");
            ((WidgetHome) this.receiver).showSurvey(survey);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$9 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89649 extends AbstractC12240o implements Function1<StoreNux.NuxState, Unit> {
        public C89649() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreNux.NuxState nuxState) {
            invoke2(nuxState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreNux.NuxState nuxState) {
            WidgetHome.this.configureFirstOpen();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$showSurvey$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89681 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
        public final /* synthetic */ SurveyUtils.Survey $survey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C89681(SurveyUtils.Survey survey) {
            super(1);
            this.$survey = survey;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            C12238m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            WidgetMainSurveyDialog.Companion companion = WidgetMainSurveyDialog.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            C12238m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            companion.show(supportFragmentManager, this.$survey.getSurveyId(), this.$survey.getSurveyURL(), this.$survey.getSurveyBody(), this.$survey.getSurveyTitle());
            StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), this.$survey.getNoticeKey(), 0L, 2, null);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$showUrgentMessageDialog$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89691 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
        public static final C89691 INSTANCE = new C89691();

        public C89691() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            C12238m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            C0843t.Companion aVar = C0843t.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            C12238m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            Objects.requireNonNull(aVar);
            C12238m.checkNotNullParameter(supportFragmentManager, "fragmentManager");
            new C0843t().show(supportFragmentManager, "WidgetUrgentMessageDialog");
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHome() {
        super(C5419R.layout.widget_home);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHome$binding$2.INSTANCE, null, 2, null);
        WidgetHome$viewModel$2 widgetHome$viewModel$2 = WidgetHome$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetHomeViewModel.class), new WidgetHome$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetHome$viewModel$2));
        this.fixedPositionViewIds = C12146m0.setOf(Integer.valueOf(C5419R.id.unread));
        this.leftPanelManager = new LeftPanelManager(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        this.localeManager = new LocaleManager();
        this.onGuildListAddHintCreate = WidgetHome$onGuildListAddHintCreate$1.INSTANCE;
        this.storeTabsNavigation = StoreStream.INSTANCE.getTabsNavigation();
        this.globalStatusIndicatorStateObserver = WidgetGlobalStatusIndicatorState.INSTANCE.get();
    }

    private final void animatePeek(WidgetHomeViewModel.Event event) {
        View view;
        View view2;
        long j;
        float right;
        float right2;
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            return;
        }
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(C5419R.id.widget_chat_list);
        if (!(fragmentFindFragmentById instanceof WidgetChatList)) {
            fragmentFindFragmentById = null;
        }
        final WidgetChatList widgetChatList = (WidgetChatList) fragmentFindFragmentById;
        if (widgetChatList != null) {
            C0980i5 c0980i5 = getBinding().f17127d;
            C12238m.checkNotNullExpressionValue(c0980i5, "binding.panelCenter");
            RoundedRelativeLayout roundedRelativeLayout = c0980i5.f960a;
            C12238m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelCenter.root");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(roundedRelativeLayout.getMeasuredWidth(), roundedRelativeLayout.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            roundedRelativeLayout.draw(new Canvas(bitmapCreateBitmap));
            getBinding().f17130g.setImageBitmap(bitmapCreateBitmap);
            if (event instanceof WidgetHomeViewModel.Event.AnimatePeekIn) {
                ImageView imageView = getBinding().f17130g;
                C12238m.checkNotNullExpressionValue(imageView, "binding.peekTransitionBitmap");
                right2 = roundedRelativeLayout.getRight();
                view2 = imageView;
                view = roundedRelativeLayout;
                j = 250;
                right = 0.0f;
            } else {
                view = getBinding().f17130g;
                C12238m.checkNotNullExpressionValue(view, "binding.peekTransitionBitmap");
                view2 = roundedRelativeLayout;
                j = 200;
                right = roundedRelativeLayout.getRight();
                right2 = 0.0f;
            }
            view.setTranslationX(right2);
            view.animate().setDuration(j).translationX(right).withEndAction(new Runnable() { // from class: com.discord.widgets.home.WidgetHome.animatePeek.1
                @Override // java.lang.Runnable
                public final void run() {
                    ImageView imageView2 = WidgetHome.this.getBinding().f17130g;
                    C12238m.checkNotNullExpressionValue(imageView2, "binding.peekTransitionBitmap");
                    imageView2.setVisibility(8);
                    widgetChatList.enableItemAnimations();
                }
            }).start();
            view2.setTranslationX(right2 - roundedRelativeLayout.getMeasuredWidth());
            view2.animate().setDuration(j).translationX(right - roundedRelativeLayout.getMeasuredWidth()).start();
            widgetChatList.disableItemAnimations();
            ImageView imageView2 = getBinding().f17130g;
            C12238m.checkNotNullExpressionValue(imageView2, "binding.peekTransitionBitmap");
            imageView2.setVisibility(0);
        }
    }

    private final void configureFirstOpen() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11119z = Observable.m11076j(StoreConnectionOpen.observeConnectionOpen$default(companion.getConnectionOpen(), false, 1, null), companion.getChannels().observeGuildAndPrivateChannels(), new Func2<Boolean, Map<Long, ? extends Channel>, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.configureFirstOpen.1
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Map<Long, ? extends Channel> map) {
                return call2(bool, (Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Boolean bool, Map<Long, Channel> map) {
                C12238m.checkNotNullExpressionValue(bool, "connectionOpen");
                if (bool.booleanValue()) {
                    return Boolean.valueOf(map.isEmpty());
                }
                return null;
            }
        }).m11119z();
        C12238m.checkNotNullExpressionValue(observableM11119z, "Observable\n        .comb…       }\n        .first()");
        ObservableExtensionsKt.appSubscribe(observableM11119z, (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89412());
    }

    private final void configureLeftPanel() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(this.leftPanelManager.observeLockState()), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89421());
    }

    private final void configureNavigationDrawerAction(StoreNavigation storeNavigation) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(storeNavigation.getNavigationPanelAction(), this, null, 2, null), (Class<?>) StoreNavigation.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89431(storeNavigation));
    }

    private final void configureOverlappingPanels() {
        getBinding().f17126c.registerStartPanelStateListeners(new OverlappingPanelsLayout.PanelStateListener() { // from class: com.discord.widgets.home.WidgetHome.configureOverlappingPanels.1
            @Override // com.discord.panels.OverlappingPanelsLayout.PanelStateListener
            public void onPanelStateChange(PanelState panelState) {
                C12238m.checkNotNullParameter(panelState, "panelState");
                WidgetHome.this.getViewModel().onStartPanelStateChange(panelState);
            }
        });
        getBinding().f17126c.registerEndPanelStateListeners(new OverlappingPanelsLayout.PanelStateListener() { // from class: com.discord.widgets.home.WidgetHome.configureOverlappingPanels.2
            @Override // com.discord.panels.OverlappingPanelsLayout.PanelStateListener
            public void onPanelStateChange(PanelState panelState) {
                C12238m.checkNotNullParameter(panelState, "panelState");
                WidgetHome.this.getViewModel().onEndPanelStateChange(panelState);
            }
        });
    }

    private final void configureUI(WidgetHomeModel widgetHomeModel) {
        getViewModel().setWidgetHomeModel$app_productionGoogleRelease(widgetHomeModel);
        if (isOnHomeTab()) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = WidgetHomeHeaderManager.INSTANCE;
            WidgetHomeBinding binding = getBinding();
            C12238m.checkNotNullExpressionValue(binding, "binding");
            widgetHomeHeaderManager.configure(this, widgetHomeModel, binding);
        }
    }

    private final void enqueueEventDetails(long guildScheduledEventId) {
        WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.enqueue(guildScheduledEventId);
    }

    private final WidgetHomeBinding getBinding() {
        return (WidgetHomeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetHomeViewModel getViewModel() {
        return (WidgetHomeViewModel) this.viewModel.getValue();
    }

    private final boolean handleBackPressed() {
        int iOrdinal = getBinding().f17126c.getSelectedPanel().ordinal();
        if (iOrdinal == 0) {
            requireActivity().moveTaskToBack(true);
        } else if (iOrdinal == 1) {
            handleCenterPanelBack$app_productionGoogleRelease();
        } else if (iOrdinal == 2) {
            getBinding().f17126c.closePanels();
        }
        return true;
    }

    private final void handleEvent(WidgetHomeViewModel.Event event) {
        if (C12238m.areEqual(event, WidgetHomeViewModel.Event.OpenLeftPanel.INSTANCE)) {
            getBinding().f17126c.openStartPanel();
            return;
        }
        if (C12238m.areEqual(event, WidgetHomeViewModel.Event.ClosePanels.INSTANCE)) {
            getBinding().f17126c.closePanels();
            return;
        }
        if (C12238m.areEqual(event, WidgetHomeViewModel.Event.UnlockLeftPanel.INSTANCE)) {
            getBinding().f17126c.setStartPanelLockState(OverlappingPanelsLayout.LockState.UNLOCKED);
            return;
        }
        if (C12238m.areEqual(event, WidgetHomeViewModel.Event.ShowChannelOnboardingSheet.INSTANCE)) {
            showChannelOnboardingSheet();
            return;
        }
        if (C12238m.areEqual(event, WidgetHomeViewModel.Event.AnimatePeekIn.INSTANCE) || C12238m.areEqual(event, WidgetHomeViewModel.Event.AnimatePeekOut.INSTANCE)) {
            animatePeek(event);
            return;
        }
        if (event instanceof WidgetHomeViewModel.Event.ShowGuildWelcomeSheet) {
            showWelcomeSheet$default(this, ((WidgetHomeViewModel.Event.ShowGuildWelcomeSheet) event).getGuildId(), null, 2, null);
            return;
        }
        if (event instanceof WidgetHomeViewModel.Event.ShowGuildEventUpsell) {
            showGuildEventUpsell(((WidgetHomeViewModel.Event.ShowGuildEventUpsell) event).getGuildId());
        } else if (event instanceof WidgetHomeViewModel.Event.ShowPlaystationUpsell) {
            showPlaystationUpsell();
        } else {
            if (!(event instanceof WidgetHomeViewModel.Event.ShowGuildRoleSubscriptionUpsell)) {
                throw new NoWhenBranchMatchedException();
            }
            showGuildRoleSubscriptionUpsell(((WidgetHomeViewModel.Event.ShowGuildRoleSubscriptionUpsell) event).getGuildId());
        }
    }

    private final void handleGlobalStatusIndicatorState(WidgetGlobalStatusIndicatorState.State state) {
        if (state.isCustomBackground()) {
            unroundPanelCorners();
        } else {
            roundPanelCorners();
        }
    }

    private final void handleHomeConfig(HomeConfig homeConfig) {
        if ((homeConfig != null ? homeConfig.getGuildWelcomeSheetId() : null) != null && homeConfig.getGuildScheduledEventId() != null) {
            showWelcomeSheet(homeConfig.getGuildWelcomeSheetId().longValue(), homeConfig.getGuildScheduledEventId());
            return;
        }
        if ((homeConfig != null ? homeConfig.getGuildWelcomeSheetId() : null) != null) {
            showWelcomeSheet$default(this, homeConfig.getGuildWelcomeSheetId().longValue(), null, 2, null);
            return;
        }
        if ((homeConfig != null ? homeConfig.getGuildScheduledEventId() : null) != null) {
            enqueueEventDetails(homeConfig.getGuildScheduledEventId().longValue());
        }
    }

    private final void handleViewState(WidgetHomeViewModel.ViewState viewState) {
        getBinding().f17126c.handleStartPanelState(viewState.getLeftPanelState());
        getBinding().f17126c.handleEndPanelState(viewState.getRightPanelState());
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            widgetHomePanelNsfw.configureUI(viewState.getGuildId(), viewState.isChannelNsfw(), viewState.isNsfwUnconsented(), viewState.getNsfwAllowed(), getBinding().f17127d.f962c.f983b, new C89461(this), (64 & 64) != 0 ? null : null);
        }
    }

    private final boolean isOnHomeTab() {
        return this.storeTabsNavigation.getSelectedTab() == NavigationTab.HOME;
    }

    private final void maybeShowHubEmailUpsell() {
        StoreNotices notices = StoreStream.INSTANCE.getNotices();
        String name = WidgetHubEmailFlow.INSTANCE.getNAME();
        C12238m.checkNotNullExpressionValue(name, "WidgetHubEmailFlow.NAME");
        notices.requestToShow(new StoreNotices.Notice(name, null, 0L, 0, true, C12145m.listOf(C12216a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, true, RecyclerView.FOREVER_NS, C89471.INSTANCE, 6, null));
    }

    private final void maybeToggleChannel(WidgetHomeModel widgetHomeModel) {
        Channel channel = widgetHomeModel.getChannel();
        boolean z2 = channel != null && ChannelUtils.m7691o(channel);
        Channel channel2 = widgetHomeModel.getChannel();
        Long lValueOf = channel2 != null ? Long.valueOf(channel2.getGuildId()) : null;
        boolean z3 = lValueOf != null && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, lValueOf.longValue(), null, 2, null);
        Channel channel3 = widgetHomeModel.getChannel();
        boolean z4 = channel3 != null && ChannelUtils.m7693q(channel3) && z3;
        FragmentContainerView fragmentContainerView = getBinding().f17127d.f963d;
        C12238m.checkNotNullExpressionValue(fragmentContainerView, "binding.panelCenter.widgetHomePanelDirectory");
        fragmentContainerView.setVisibility(z2 ? 0 : 8);
        FragmentContainerView fragmentContainerView2 = getBinding().f17127d.f961b;
        C12238m.checkNotNullExpressionValue(fragmentContainerView2, "binding.panelCenter.widgetForumChannelList");
        fragmentContainerView2.setVisibility(z4 ? 0 : 8);
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(C5419R.id.widget_home_panel_directory);
        if (!(fragmentFindFragmentById instanceof WidgetDirectoryChannel)) {
            fragmentFindFragmentById = null;
        }
        WidgetDirectoryChannel widgetDirectoryChannel = (WidgetDirectoryChannel) fragmentFindFragmentById;
        if (widgetDirectoryChannel != null) {
            WidgetDirectoryChannel.bindGestureObservers$default(widgetDirectoryChannel, z2, null, 2, null);
        }
        C0987j5 c0987j5 = getBinding().f17127d.f962c;
        C12238m.checkNotNullExpressionValue(c0987j5, "binding.panelCenter.widgetHomePanelCenterChat");
        ConstraintLayout constraintLayout = c0987j5.f982a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.panelCenter.widgetHomePanelCenterChat.root");
        constraintLayout.setVisibility((z2 || z4) ? false : true ? 0 : 8);
    }

    private final void onNsfwToggle(boolean isHidden) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        Fragment fragmentFindFragmentById = childFragmentManager.findFragmentById(C5419R.id.widget_chat_list);
        if (fragmentFindFragmentById != null) {
            C12238m.checkNotNullExpressionValue(fragmentFindFragmentById, "fragmentManager.findFrag…dget_chat_list) ?: return");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            C12238m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
            if (isHidden) {
                fragmentTransactionBeginTransaction.hide(fragmentFindFragmentById);
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentById);
            }
            fragmentTransactionBeginTransaction.commit();
        }
    }

    private final void roundPanelCorners() {
        setPanelCorners(DimenUtils.dpToPixels(8));
    }

    private final void setPanelCorners(float radius) {
        C0980i5 c0980i5 = getBinding().f17127d;
        C12238m.checkNotNullExpressionValue(c0980i5, "binding.panelCenter");
        c0980i5.f960a.updateTopLeftRadius(radius);
        C0980i5 c0980i6 = getBinding().f17127d;
        C12238m.checkNotNullExpressionValue(c0980i6, "binding.panelCenter");
        c0980i6.f960a.updateTopRightRadius(radius);
        getBinding().f17129f.f1090b.updateTopLeftRadius(radius);
        getBinding().f17129f.f1090b.updateTopRightRadius(radius);
    }

    private final void setPanelWindowInsetsListeners() {
        FrameLayout frameLayout = getBinding().f17131h;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.widgetHomeContainer");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout);
        HomePanelsLayout homePanelsLayout = getBinding().f17126c;
        C12238m.checkNotNullExpressionValue(homePanelsLayout, "binding.overlappingPanels");
        ViewExtensions.setForwardingWindowInsetsListener(homePanelsLayout);
        C1001l5 c1001l5 = getBinding().f17128e;
        C12238m.checkNotNullExpressionValue(c1001l5, "binding.panelLeft");
        ViewCompat.setOnApplyWindowInsetsListener(c1001l5.f1035a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.home.WidgetHome.setPanelWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
                C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                ViewGroup.LayoutParams layoutParams = WidgetHome.this.getBinding().f17128e.f1037c.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsetsCompat.getSystemWindowInsetLeft();
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        C0980i5 c0980i5 = getBinding().f17127d;
        C12238m.checkNotNullExpressionValue(c0980i5, "binding.panelCenter");
        ViewCompat.setOnApplyWindowInsetsListener(c0980i5.f960a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.home.WidgetHome.setPanelWindowInsetsListeners.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
                C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.m82of(0, 0, 0, windowInsetsCompat.getSystemWindowInsetBottom())).build();
                C12238m.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
                ViewCompat.dispatchApplyWindowInsets(WidgetHome.this.getBinding().f17127d.f962c.f985d, windowInsetsCompatBuild);
                ViewCompat.dispatchApplyWindowInsets(WidgetHome.this.getBinding().f17127d.f962c.f986e, windowInsetsCompatBuild);
                ViewCompat.dispatchApplyWindowInsets(WidgetHome.this.getBinding().f17127d.f961b, windowInsetsCompatBuild);
                WidgetHomePanelNsfw widgetHomePanelNsfw = WidgetHome.this.panelNsfw;
                if (widgetHomePanelNsfw != null) {
                    widgetHomePanelNsfw.dispatchApplyWindowInsets(windowInsetsCompat);
                }
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        C1015n5 c1015n5 = getBinding().f17129f;
        C12238m.checkNotNullExpressionValue(c1015n5, "binding.panelRight");
        ViewCompat.setOnApplyWindowInsetsListener(c1015n5.f1089a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.home.WidgetHome.setPanelWindowInsetsListeners.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
                C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                FragmentContainerView fragmentContainerView = WidgetHome.this.getBinding().f17129f.f1091c;
                C12238m.checkNotNullExpressionValue(fragmentContainerView, "binding.panelRight.widgetConnectedList");
                fragmentContainerView.setPadding(fragmentContainerView.getPaddingLeft(), fragmentContainerView.getPaddingTop(), fragmentContainerView.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    private final void setupSmoothKeyboardReaction() {
        C0980i5 c0980i5 = getBinding().f17127d;
        C12238m.checkNotNullExpressionValue(c0980i5, "binding.panelCenter");
        RoundedRelativeLayout roundedRelativeLayout = c0980i5.f960a;
        C12238m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelCenter.root");
        Iterator<View> it = ViewGroupKt.iterator(roundedRelativeLayout);
        while (it.hasNext()) {
            View next = it.next();
            if (!(next instanceof AppBarLayout) && !this.fixedPositionViewIds.contains(Integer.valueOf(next.getId()))) {
                SmoothKeyboardReactionHelper.INSTANCE.install(next);
            }
        }
    }

    private final void showChannelOnboardingSheet() {
        WidgetChannelOnboarding.Companion companion = WidgetChannelOnboarding.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager);
    }

    private final void showGuildEventUpsell(long guildId) {
        WidgetGuildScheduledEventUpsellBottomSheet.Companion companion = WidgetGuildScheduledEventUpsellBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.launch(parentFragmentManager, guildId);
    }

    private final void showGuildRoleSubscriptionUpsell(long guildId) {
        WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.Companion companion = WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, guildId);
    }

    private final void showInteractionModal(InteractionModalCreate modal) {
        Context context = getContext();
        if (context != null) {
            ModalComponent.Companion companion = ModalComponent.INSTANCE;
            C12238m.checkNotNullExpressionValue(context, "context");
            companion.show(context, new ModalComponent.Options(modal));
        }
    }

    private final void showPlaystationUpsell() {
        WidgetPlaystationIntegrationUpsellBottomSheet.Companion companion = WidgetPlaystationIntegrationUpsellBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager);
    }

    private final void showSurvey(SurveyUtils.Survey survey) {
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(survey.getNoticeKey(), null, 0L, 5, true, null, 0L, false, 0L, new C89681(survey), 486, null));
    }

    private final void showUrgentMessageDialog() {
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("URGENT_MESSAGE_DIALOG", null, 0L, 0, false, null, 0L, false, 0L, C89691.INSTANCE, Opcodes.IF_ACMPNE, null));
    }

    private final void showWelcomeSheet(long guildId, Long guildScheduledEventId) {
        if (StoreStream.INSTANCE.getGuildWelcomeScreens().hasWelcomeScreenBeenSeen(guildId)) {
            return;
        }
        WidgetGuildWelcomeSheet.Companion companion = WidgetGuildWelcomeSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, guildId, guildScheduledEventId);
    }

    public static /* synthetic */ void showWelcomeSheet$default(WidgetHome widgetHome, long j, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        widgetHome.showWelcomeSheet(j, l);
    }

    private final void unroundPanelCorners() {
        setPanelCorners(0.0f);
    }

    public final PanelLayout getPanelLayout() {
        HomePanelsLayout homePanelsLayout = getBinding().f17126c;
        C12238m.checkNotNullExpressionValue(homePanelsLayout, "binding.overlappingPanels");
        return homePanelsLayout;
    }

    public final Toolbar getToolbar() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.toolbar;
        }
        return null;
    }

    public final TextView getUnreadCountView() {
        C0994k5 c0994k5 = getBinding().f17127d.f962c.f984c;
        C12238m.checkNotNullExpressionValue(c0994k5, "binding.panelCenter.widg…omePanelCenterChat.unread");
        TextView textView = c0994k5.f1007a;
        C12238m.checkNotNullExpressionValue(textView, "binding.panelCenter.widg…nelCenterChat.unread.root");
        return textView;
    }

    public final void handleCenterPanelBack$app_productionGoogleRelease() {
        WidgetHomeModel widgetHomeModel$app_productionGoogleRelease = getViewModel().getWidgetHomeModel();
        StoreChannelsSelected.ResolvedSelectedChannel selectedChannel = widgetHomeModel$app_productionGoogleRelease != null ? widgetHomeModel$app_productionGoogleRelease.getSelectedChannel() : null;
        WidgetHomeModel widgetHomeModel$app_productionGoogleRelease2 = getViewModel().getWidgetHomeModel();
        Channel selectedVoiceChannel = widgetHomeModel$app_productionGoogleRelease2 != null ? widgetHomeModel$app_productionGoogleRelease2.getSelectedVoiceChannel() : null;
        if (selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) {
            ChannelSelector.INSTANCE.getInstance().dismissCreateThread();
            return;
        }
        boolean z2 = selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel;
        if (z2) {
            StoreChannelsSelected.ResolvedSelectedChannel.Channel channel = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) selectedChannel;
            if (channel.getPeekParent() != null) {
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel.getChannel().getGuildId(), channel.getPeekParent().longValue(), null, null, 12, null);
                return;
            }
        }
        if (z2) {
            StoreChannelsSelected.ResolvedSelectedChannel.Channel channel2 = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) selectedChannel;
            if (ChannelUtils.m7675J(channel2.getChannel())) {
                if (selectedVoiceChannel == null || ChannelUtils.m7667B(selectedVoiceChannel) || selectedVoiceChannel.getId() != selectedChannel.getId()) {
                    WidgetCallPreviewFullscreen.Companion.launch$default(WidgetCallPreviewFullscreen.INSTANCE, requireContext(), channel2.getChannel().getId(), null, 4, null);
                    requireAppActivity().overridePendingTransition(C5419R.anim.activity_slide_horizontal_close_in, C5419R.anim.activity_slide_horizontal_close_out);
                    return;
                } else {
                    WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), ((StoreChannelsSelected.ResolvedSelectedChannel.Channel) selectedChannel).getChannel().getId(), false, null, null, 28, null);
                    requireAppActivity().overridePendingTransition(C5419R.anim.activity_slide_horizontal_close_in, C5419R.anim.activity_slide_horizontal_close_out);
                    return;
                }
            }
        }
        getBinding().f17126c.openStartPanel();
    }

    public final void lockCloseRightPanel(boolean lock) {
        getBinding().f17126c.setEndPanelLockState(lock ? OverlappingPanelsLayout.LockState.CLOSE : OverlappingPanelsLayout.LockState.UNLOCKED);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C1174a c1174a = C1174a.f1571b;
        C89481 c89481 = new C89481();
        C12238m.checkParameterIsNotNull(c89481, "provider");
        C1174a.f1570a = c89481;
    }

    @Override // p007b.p008a.p039o.ViewOnLayoutChangeListenerC1175b.a
    public void onGestureRegionsUpdate(List<Rect> gestureRegions) {
        C12238m.checkNotNullParameter(gestureRegions, "gestureRegions");
        getBinding().f17126c.setChildGestureRegions(gestureRegions);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ViewOnLayoutChangeListenerC1175b viewOnLayoutChangeListenerC1175bM232a = ViewOnLayoutChangeListenerC1175b.b.m232a();
        C12238m.checkParameterIsNotNull(this, "gestureRegionsListener");
        viewOnLayoutChangeListenerC1175bM232a.f1575l.remove(this);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ViewOnLayoutChangeListenerC1175b viewOnLayoutChangeListenerC1175bM232a = ViewOnLayoutChangeListenerC1175b.b.m232a();
        C12238m.checkParameterIsNotNull(this, "gestureRegionsListener");
        onGestureRegionsUpdate(C12163u.toList(viewOnLayoutChangeListenerC1175bM232a.f1573j.values()));
        viewOnLayoutChangeListenerC1175bM232a.f1575l.add(this);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        WidgetHomeModel widgetHomeModel$app_productionGoogleRelease = getViewModel().getWidgetHomeModel();
        if (widgetHomeModel$app_productionGoogleRelease != null) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = WidgetHomeHeaderManager.INSTANCE;
            WidgetHomeBinding binding = getBinding();
            C12238m.checkNotNullExpressionValue(binding, "binding");
            widgetHomeHeaderManager.configure(this, widgetHomeModel$app_productionGoogleRelease, binding);
        }
        if (getBinding().f17126c.getSelectedPanel() == OverlappingPanelsLayout.Panel.CENTER) {
            setActionBarTitleAccessibilityViewFocused();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        boolean z2 = TextUtils.getLayoutDirectionFromLocale(new LocaleManager().getPrimaryLocale(requireContext())) == 0;
        RoundedRelativeLayout roundedRelativeLayout = getBinding().f17129f.f1090b;
        C12238m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelRight.mainPanelRightRoundedContainer");
        ViewGroup.LayoutParams layoutParams = roundedRelativeLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int iDpToPixels = DimenUtils.dpToPixels(8);
        int i = z2 ? marginLayoutParams.leftMargin : iDpToPixels;
        if (!z2) {
            iDpToPixels = marginLayoutParams.rightMargin;
        }
        marginLayoutParams.setMargins(i, marginLayoutParams.topMargin, iDpToPixels, marginLayoutParams.bottomMargin);
        RoundedRelativeLayout roundedRelativeLayout2 = getBinding().f17129f.f1090b;
        C12238m.checkNotNullExpressionValue(roundedRelativeLayout2, "binding.panelRight.mainPanelRightRoundedContainer");
        roundedRelativeLayout2.setLayoutParams(marginLayoutParams);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetTabsHost)) {
            parentFragment = null;
        }
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) parentFragment;
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.HOME, this);
        }
        this.panelNsfw = new WidgetHomePanelNsfw(this);
        WidgetHomeBinding binding = getBinding();
        C12238m.checkNotNullExpressionValue(binding, "binding");
        this.panelLoading = new WidgetHomePanelLoading(binding);
        Function1<? super View, Unit> function1 = this.onGuildListAddHintCreate;
        TextView textView = getBinding().f17128e.f1036b;
        C12238m.checkNotNullExpressionValue(textView, "binding.panelLeft.guildListAddHint");
        function1.invoke(textView);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBound.1
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                return Boolean.valueOf(WidgetHome.this.handleBackPressed());
            }
        }, 0, 2, null);
        WidgetNoticeNuxSamsungLink.INSTANCE.enqueue(requireContext(), ClockFactory.get());
        setPanelWindowInsetsListeners();
        setupSmoothKeyboardReaction();
        Observable<StoreNux.NuxState> observableM11119z = StoreStream.INSTANCE.getNux().getNuxState().m11118y(new InterfaceC12589b<StoreNux.NuxState, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBound.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(StoreNux.NuxState nuxState) {
                FragmentActivity fragmentActivityM95e = WidgetHome.this.m95e();
                if (!(fragmentActivityM95e instanceof AppActivity)) {
                    fragmentActivityM95e = null;
                }
                AppActivity appActivity = (AppActivity) fragmentActivityM95e;
                return Boolean.valueOf(appActivity != null && appActivity.m8348h(C12216a0.getOrCreateKotlinClass(WidgetTabsHost.class)));
            }
        }).m11119z();
        C12238m.checkNotNullExpressionValue(observableM11119z, "StoreStream\n        .get…       }\n        .first()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11119z, 0L, false, 1, null), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89513());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG");
        if (!(serializableExtra instanceof HomeConfig)) {
            serializableExtra = null;
        }
        handleHomeConfig((HomeConfig) serializableExtra);
        WidgetHomePanelLoading widgetHomePanelLoading = this.panelLoading;
        if (widgetHomePanelLoading != null) {
            widgetHomePanelLoading.configure(this);
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89521());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89572());
        WidgetHomeModel.Companion companion = WidgetHomeModel.INSTANCE;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.get(), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89583());
        Observable observableM11113s = ObservableExtensionsKt.ui$default(companion.get(), this, null, 2, null).m11113s(new Func2<WidgetHomeModel, WidgetHomeModel, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBoundOrOnResume.4
            @Override // p658rx.functions.Func2
            public final Boolean call(WidgetHomeModel widgetHomeModel, WidgetHomeModel widgetHomeModel2) {
                return Boolean.valueOf(widgetHomeModel.getChannelId() == widgetHomeModel2.getChannelId());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11113s, "WidgetHomeModel\n        …lId == model2.channelId }");
        ObservableExtensionsKt.appSubscribe(observableM11113s, (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89605());
        AccessibilityDetectionNavigator.INSTANCE.enqueueNoticeWhenEnabled(this);
        StoreStream.Companion companion2 = StoreStream.INSTANCE;
        configureNavigationDrawerAction(companion2.getNavigation());
        configureOverlappingPanels();
        Observable observableM11083G = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(SurveyUtils.INSTANCE.getSurveyToShow(), 0L, false, 3, null), this, null, 2, null).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11118y = observableM11083G.m11118y(new InterfaceC12589b<SurveyUtils.Survey, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBoundOrOnResume.6
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(SurveyUtils.Survey survey) {
                return Boolean.valueOf(!C12238m.areEqual(survey, SurveyUtils.Survey.None.INSTANCE));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y, "SurveyUtils\n        .get…SurveyUtils.Survey.None }");
        ObservableExtensionsKt.appSubscribe(observableM11118y, (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89627(this));
        Observable<StoreNux.NuxState> observableM11118y2 = companion2.getNux().getNuxState().m11118y(new InterfaceC12589b<StoreNux.NuxState, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBoundOrOnResume.8
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(StoreNux.NuxState nuxState) {
                return Boolean.valueOf(nuxState.getFirstOpen());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y2, "StoreStream\n        .get… .filter { it.firstOpen }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y2, 0L, false, 1, null), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89649());
        Observable observableM11118y3 = StoreUser.observeMe$default(companion2.getUsers(), false, 1, null).m11118y(new InterfaceC12589b<MeUser, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBoundOrOnResume.10
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(MeUser meUser) {
                UserUtils userUtils = UserUtils.INSTANCE;
                C12238m.checkNotNullExpressionValue(meUser, "it");
                return Boolean.valueOf(userUtils.getHasUnreadUrgentMessages(meUser));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y3, "StoreStream\n        .get…hasUnreadUrgentMessages }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11118y3, this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C895411());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion2.getInteractions().observeModalCreate(), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C895512());
        configureLeftPanel();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(this.globalStatusIndicatorStateObserver.observeState(), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C895613(this));
    }

    public final void setOnGuildListAddHintCreate(Function1<? super View, Unit> onGuildListAddHintCreate) {
        C12238m.checkNotNullParameter(onGuildListAddHintCreate, "onGuildListAddHintCreate");
        this.onGuildListAddHintCreate = onGuildListAddHintCreate;
    }
}
