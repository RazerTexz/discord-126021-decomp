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
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.WidgetUrgentMessageDialog;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.WidgetHomePanelCenterBinding;
import b.a.i.WidgetHomePanelCenterChatBinding;
import b.a.i.WidgetHomePanelCenterContentUnreadBinding;
import b.a.i.WidgetHomePanelLeftBinding;
import b.a.i.WidgetHomePanelRightBinding;
import b.a.o.LocaleProvider;
import b.a.o.PanelsChildGestureRegionObserver;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.surveys.SurveyUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
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
import com.discord.widgets.home.WidgetHomeModel;
import com.discord.widgets.home.WidgetHomeViewModel;
import com.discord.widgets.home.WidgetMainSurveyDialog;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.hubs.WidgetHubEmailViewModel2;
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
import d0.t.CollectionsJVM;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
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
import rx.Observable;
import rx.Subscription;
import rx.functions.Func0;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome extends AppFragment implements OnTabSelectedListener, PanelsChildGestureRegionObserver.a {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHome.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHomeBinding;", 0)};
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

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
                Intrinsics3.checkNotNullParameter(nuxState, "it");
                return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 55, null);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class C02972 extends Lambda implements Function0<Unit> {
            public C02972() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetHome.this.getBinding().c.openStartPanel();
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetHome.kt */
            public static final class AnonymousClass1 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
                    Intrinsics3.checkNotNullParameter(nuxState, "it");
                    return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, true, null, 39, null);
                }
            }

            public AnonymousClass3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.INSTANCE.getNux().updateNux(AnonymousClass1.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class AnonymousClass4 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
            public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

            public AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                invoke2((Function0<Unit>) function0);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function0<Unit> function0) {
                function0.invoke();
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
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
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new C02972());
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Observable observableI = Observable.I(scalarSynchronousObservable.q(1000L, timeUnit), new ScalarSynchronousObservable(AnonymousClass3.INSTANCE).q(WidgetHome.DELAY_DRAWER_OPEN_FINISH, timeUnit));
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n             …, TimeUnit.MILLISECONDS))");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableI, WidgetHome.this, null, 2, null), (Class<?>) WidgetHome.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass4.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureLeftPanel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<OverlappingPanelsLayout.LockState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OverlappingPanelsLayout.LockState lockState) {
            invoke2(lockState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OverlappingPanelsLayout.LockState lockState) {
            Intrinsics3.checkNotNullParameter(lockState, "lockState");
            WidgetHome.this.getBinding().c.setStartPanelUseFullPortraitWidth(lockState == OverlappingPanelsLayout.LockState.OPEN);
            WidgetHome.this.getBinding().c.setStartPanelLockState(lockState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureNavigationDrawerAction$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreNavigation.PanelAction, Unit> {
        public final /* synthetic */ StoreNavigation $this_configureNavigationDrawerAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreNavigation storeNavigation) {
            super(1);
            this.$this_configureNavigationDrawerAction = storeNavigation;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreNavigation.PanelAction panelAction) {
            invoke2(panelAction);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreNavigation.PanelAction panelAction) {
            Intrinsics3.checkNotNullParameter(panelAction, "it");
            this.$this_configureNavigationDrawerAction.setNavigationPanelAction(panelAction, WidgetHome.this.getBinding().c);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$handleViewState$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(WidgetHome widgetHome) {
            super(1, widgetHome, WidgetHome.class, "onNsfwToggle", "onNsfwToggle(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            ((WidgetHome) this.receiver).onNsfwToggle(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$maybeShowHubEmailUpsell$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            AppScreen2.d(fragmentActivity, WidgetHubEmailFlow.class, new WidgetHubEmailViewModel2(null, 0, null, 7, null));
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Context, Locale> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Locale invoke(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return WidgetHome.this.localeManager.getPrimaryLocale(context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<StoreNux.NuxState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreNux.NuxState nuxState) {
            invoke2(nuxState);
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetHomeViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetHome.this.handleViewState(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$11, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass11 extends Lambda implements Function1<MeUser, Unit> {
        public AnonymousClass11() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            WidgetHome.this.showUrgentMessageDialog();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$12, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass12 extends Lambda implements Function1<InteractionModalCreate, Unit> {
        public AnonymousClass12() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InteractionModalCreate interactionModalCreate) {
            invoke2(interactionModalCreate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InteractionModalCreate interactionModalCreate) {
            Intrinsics3.checkNotNullParameter(interactionModalCreate, "it");
            WidgetHome.this.showInteractionModal(interactionModalCreate);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$13, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final /* synthetic */ class AnonymousClass13 extends FunctionReferenceImpl implements Function1<WidgetGlobalStatusIndicatorState.State, Unit> {
        public AnonymousClass13(WidgetHome widgetHome) {
            super(1, widgetHome, WidgetHome.class, "handleGlobalStatusIndicatorState", "handleGlobalStatusIndicatorState(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState.State state) {
            invoke2(state);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorState.State state) {
            Intrinsics3.checkNotNullParameter(state, "p1");
            ((WidgetHome) this.receiver).handleGlobalStatusIndicatorState(state);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetHomeViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetHome.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<WidgetHomeModel, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeModel widgetHomeModel) {
            invoke2(widgetHomeModel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeModel widgetHomeModel) {
            Intrinsics3.checkNotNullParameter(widgetHomeModel, "it");
            WidgetHome.this.configureUI(widgetHomeModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<WidgetHomeModel, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeModel widgetHomeModel) {
            invoke2(widgetHomeModel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeModel widgetHomeModel) {
            WidgetHome widgetHome = WidgetHome.this;
            Intrinsics3.checkNotNullExpressionValue(widgetHomeModel, "it");
            widgetHome.maybeToggleChannel(widgetHomeModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$7, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<SurveyUtils.Survey, Unit> {
        public AnonymousClass7(WidgetHome widgetHome) {
            super(1, widgetHome, WidgetHome.class, "showSurvey", "showSurvey(Lcom/discord/utilities/surveys/SurveyUtils$Survey;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SurveyUtils.Survey survey) {
            invoke2(survey);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SurveyUtils.Survey survey) {
            Intrinsics3.checkNotNullParameter(survey, "p1");
            ((WidgetHome) this.receiver).showSurvey(survey);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$9, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass9 extends Lambda implements Function1<StoreNux.NuxState, Unit> {
        public AnonymousClass9() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreNux.NuxState nuxState) {
            invoke2(nuxState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreNux.NuxState nuxState) {
            WidgetHome.this.configureFirstOpen();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$showSurvey$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public final /* synthetic */ SurveyUtils.Survey $survey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SurveyUtils.Survey survey) {
            super(1);
            this.$survey = survey;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            WidgetMainSurveyDialog.Companion companion = WidgetMainSurveyDialog.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            companion.show(supportFragmentManager, this.$survey.getSurveyId(), this.$survey.getSurveyURL(), this.$survey.getSurveyBody(), this.$survey.getSurveyTitle());
            StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), this.$survey.getNoticeKey(), 0L, 2, null);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$showUrgentMessageDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            WidgetUrgentMessageDialog.Companion aVar = WidgetUrgentMessageDialog.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            Objects.requireNonNull(aVar);
            Intrinsics3.checkNotNullParameter(supportFragmentManager, "fragmentManager");
            new WidgetUrgentMessageDialog().show(supportFragmentManager, "WidgetUrgentMessageDialog");
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHome() {
        super(R.layout.widget_home);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHome2.INSTANCE, null, 2, null);
        WidgetHome4 widgetHome4 = WidgetHome4.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHomeViewModel.class), new WidgetHome$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHome4));
        this.fixedPositionViewIds = SetsJVM.setOf(Integer.valueOf(R.id.unread));
        this.leftPanelManager = new LeftPanelManager(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        this.localeManager = new LocaleManager();
        this.onGuildListAddHintCreate = WidgetHome3.INSTANCE;
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
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R.id.widget_chat_list);
        if (!(fragmentFindFragmentById instanceof WidgetChatList)) {
            fragmentFindFragmentById = null;
        }
        final WidgetChatList widgetChatList = (WidgetChatList) fragmentFindFragmentById;
        if (widgetChatList != null) {
            WidgetHomePanelCenterBinding widgetHomePanelCenterBinding = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding, "binding.panelCenter");
            RoundedRelativeLayout roundedRelativeLayout = widgetHomePanelCenterBinding.a;
            Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelCenter.root");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(roundedRelativeLayout.getMeasuredWidth(), roundedRelativeLayout.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            roundedRelativeLayout.draw(new Canvas(bitmapCreateBitmap));
            getBinding().g.setImageBitmap(bitmapCreateBitmap);
            if (event instanceof WidgetHomeViewModel.Event.AnimatePeekIn) {
                ImageView imageView = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.peekTransitionBitmap");
                right2 = roundedRelativeLayout.getRight();
                view2 = imageView;
                view = roundedRelativeLayout;
                j = 250;
                right = 0.0f;
            } else {
                view = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(view, "binding.peekTransitionBitmap");
                view2 = roundedRelativeLayout;
                j = 200;
                right = roundedRelativeLayout.getRight();
                right2 = 0.0f;
            }
            view.setTranslationX(right2);
            view.animate().setDuration(j).translationX(right).withEndAction(new Runnable() { // from class: com.discord.widgets.home.WidgetHome.animatePeek.1
                @Override // java.lang.Runnable
                public final void run() {
                    ImageView imageView2 = WidgetHome.this.getBinding().g;
                    Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.peekTransitionBitmap");
                    imageView2.setVisibility(8);
                    widgetChatList.enableItemAnimations();
                }
            }).start();
            view2.setTranslationX(right2 - roundedRelativeLayout.getMeasuredWidth());
            view2.animate().setDuration(j).translationX(right - roundedRelativeLayout.getMeasuredWidth()).start();
            widgetChatList.disableItemAnimations();
            ImageView imageView2 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.peekTransitionBitmap");
            imageView2.setVisibility(0);
        }
    }

    private final void configureFirstOpen() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableZ = Observable.j(StoreConnectionOpen.observeConnectionOpen$default(companion.getConnectionOpen(), false, 1, null), companion.getChannels().observeGuildAndPrivateChannels(), new Func2<Boolean, Map<Long, ? extends Channel>, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.configureFirstOpen.1
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Map<Long, ? extends Channel> map) {
                return call2(bool, (Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Boolean bool, Map<Long, Channel> map) {
                Intrinsics3.checkNotNullExpressionValue(bool, "connectionOpen");
                if (bool.booleanValue()) {
                    return Boolean.valueOf(map.isEmpty());
                }
                return null;
            }
        }).z();
        Intrinsics3.checkNotNullExpressionValue(observableZ, "Observable\n        .comb…       }\n        .first()");
        ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    private final void configureLeftPanel() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(this.leftPanelManager.observeLockState()), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    private final void configureNavigationDrawerAction(StoreNavigation storeNavigation) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(storeNavigation.getNavigationPanelAction(), this, null, 2, null), (Class<?>) StoreNavigation.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(storeNavigation));
    }

    private final void configureOverlappingPanels() {
        getBinding().c.registerStartPanelStateListeners(new OverlappingPanelsLayout.PanelStateListener() { // from class: com.discord.widgets.home.WidgetHome.configureOverlappingPanels.1
            @Override // com.discord.panels.OverlappingPanelsLayout.PanelStateListener
            public void onPanelStateChange(PanelState panelState) {
                Intrinsics3.checkNotNullParameter(panelState, "panelState");
                WidgetHome.this.getViewModel().onStartPanelStateChange(panelState);
            }
        });
        getBinding().c.registerEndPanelStateListeners(new OverlappingPanelsLayout.PanelStateListener() { // from class: com.discord.widgets.home.WidgetHome.configureOverlappingPanels.2
            @Override // com.discord.panels.OverlappingPanelsLayout.PanelStateListener
            public void onPanelStateChange(PanelState panelState) {
                Intrinsics3.checkNotNullParameter(panelState, "panelState");
                WidgetHome.this.getViewModel().onEndPanelStateChange(panelState);
            }
        });
    }

    private final void configureUI(WidgetHomeModel widgetHomeModel) {
        getViewModel().setWidgetHomeModel$app_productionGoogleRelease(widgetHomeModel);
        if (isOnHomeTab()) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = WidgetHomeHeaderManager.INSTANCE;
            WidgetHomeBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
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
        int iOrdinal = getBinding().c.getSelectedPanel().ordinal();
        if (iOrdinal == 0) {
            requireActivity().moveTaskToBack(true);
        } else if (iOrdinal == 1) {
            handleCenterPanelBack$app_productionGoogleRelease();
        } else if (iOrdinal == 2) {
            getBinding().c.closePanels();
        }
        return true;
    }

    private final void handleEvent(WidgetHomeViewModel.Event event) {
        if (Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.OpenLeftPanel.INSTANCE)) {
            getBinding().c.openStartPanel();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.ClosePanels.INSTANCE)) {
            getBinding().c.closePanels();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.UnlockLeftPanel.INSTANCE)) {
            getBinding().c.setStartPanelLockState(OverlappingPanelsLayout.LockState.UNLOCKED);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.ShowChannelOnboardingSheet.INSTANCE)) {
            showChannelOnboardingSheet();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.AnimatePeekIn.INSTANCE) || Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.AnimatePeekOut.INSTANCE)) {
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
        getBinding().c.handleStartPanelState(viewState.getLeftPanelState());
        getBinding().c.handleEndPanelState(viewState.getRightPanelState());
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            widgetHomePanelNsfw.configureUI(viewState.getGuildId(), viewState.isChannelNsfw(), viewState.isNsfwUnconsented(), viewState.getNsfwAllowed(), getBinding().d.c.f142b, new AnonymousClass1(this), (64 & 64) != 0 ? null : null);
        }
    }

    private final boolean isOnHomeTab() {
        return this.storeTabsNavigation.getSelectedTab() == NavigationTab.HOME;
    }

    private final void maybeShowHubEmailUpsell() {
        StoreNotices notices = StoreStream.INSTANCE.getNotices();
        String name = WidgetHubEmailFlow.INSTANCE.getNAME();
        Intrinsics3.checkNotNullExpressionValue(name, "WidgetHubEmailFlow.NAME");
        notices.requestToShow(new StoreNotices.Notice(name, null, 0L, 0, true, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, true, RecyclerView.FOREVER_NS, AnonymousClass1.INSTANCE, 6, null));
    }

    private final void maybeToggleChannel(WidgetHomeModel widgetHomeModel) {
        Channel channel = widgetHomeModel.getChannel();
        boolean z2 = channel != null && ChannelUtils.o(channel);
        Channel channel2 = widgetHomeModel.getChannel();
        Long lValueOf = channel2 != null ? Long.valueOf(channel2.getGuildId()) : null;
        boolean z3 = lValueOf != null && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, lValueOf.longValue(), null, 2, null);
        Channel channel3 = widgetHomeModel.getChannel();
        boolean z4 = channel3 != null && ChannelUtils.q(channel3) && z3;
        FragmentContainerView fragmentContainerView = getBinding().d.d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.panelCenter.widgetHomePanelDirectory");
        fragmentContainerView.setVisibility(z2 ? 0 : 8);
        FragmentContainerView fragmentContainerView2 = getBinding().d.f136b;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView2, "binding.panelCenter.widgetForumChannelList");
        fragmentContainerView2.setVisibility(z4 ? 0 : 8);
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R.id.widget_home_panel_directory);
        if (!(fragmentFindFragmentById instanceof WidgetDirectoryChannel)) {
            fragmentFindFragmentById = null;
        }
        WidgetDirectoryChannel widgetDirectoryChannel = (WidgetDirectoryChannel) fragmentFindFragmentById;
        if (widgetDirectoryChannel != null) {
            WidgetDirectoryChannel.bindGestureObservers$default(widgetDirectoryChannel, z2, null, 2, null);
        }
        WidgetHomePanelCenterChatBinding widgetHomePanelCenterChatBinding = getBinding().d.c;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterChatBinding, "binding.panelCenter.widgetHomePanelCenterChat");
        ConstraintLayout constraintLayout = widgetHomePanelCenterChatBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.panelCenter.widgetHomePanelCenterChat.root");
        constraintLayout.setVisibility((z2 || z4) ? false : true ? 0 : 8);
    }

    private final void onNsfwToggle(boolean isHidden) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        Fragment fragmentFindFragmentById = childFragmentManager.findFragmentById(R.id.widget_chat_list);
        if (fragmentFindFragmentById != null) {
            Intrinsics3.checkNotNullExpressionValue(fragmentFindFragmentById, "fragmentManager.findFrag…dget_chat_list) ?: return");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics3.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
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
        WidgetHomePanelCenterBinding widgetHomePanelCenterBinding = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding, "binding.panelCenter");
        widgetHomePanelCenterBinding.a.updateTopLeftRadius(radius);
        WidgetHomePanelCenterBinding widgetHomePanelCenterBinding2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding2, "binding.panelCenter");
        widgetHomePanelCenterBinding2.a.updateTopRightRadius(radius);
        getBinding().f.f169b.updateTopLeftRadius(radius);
        getBinding().f.f169b.updateTopRightRadius(radius);
    }

    private final void setPanelWindowInsetsListeners() {
        FrameLayout frameLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.widgetHomeContainer");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout);
        HomePanelsLayout homePanelsLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(homePanelsLayout, "binding.overlappingPanels");
        ViewExtensions.setForwardingWindowInsetsListener(homePanelsLayout);
        WidgetHomePanelLeftBinding widgetHomePanelLeftBinding = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelLeftBinding, "binding.panelLeft");
        ViewCompat.setOnApplyWindowInsetsListener(widgetHomePanelLeftBinding.a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.home.WidgetHome.setPanelWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                ViewGroup.LayoutParams layoutParams = WidgetHome.this.getBinding().e.c.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsetsCompat.getSystemWindowInsetLeft();
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        WidgetHomePanelCenterBinding widgetHomePanelCenterBinding = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding, "binding.panelCenter");
        ViewCompat.setOnApplyWindowInsetsListener(widgetHomePanelCenterBinding.a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.home.WidgetHome.setPanelWindowInsetsListeners.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.of(0, 0, 0, windowInsetsCompat.getSystemWindowInsetBottom())).build();
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
                ViewCompat.dispatchApplyWindowInsets(WidgetHome.this.getBinding().d.c.d, windowInsetsCompatBuild);
                ViewCompat.dispatchApplyWindowInsets(WidgetHome.this.getBinding().d.c.e, windowInsetsCompatBuild);
                ViewCompat.dispatchApplyWindowInsets(WidgetHome.this.getBinding().d.f136b, windowInsetsCompatBuild);
                WidgetHomePanelNsfw widgetHomePanelNsfw = WidgetHome.this.panelNsfw;
                if (widgetHomePanelNsfw != null) {
                    widgetHomePanelNsfw.dispatchApplyWindowInsets(windowInsetsCompat);
                }
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
        WidgetHomePanelRightBinding widgetHomePanelRightBinding = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelRightBinding, "binding.panelRight");
        ViewCompat.setOnApplyWindowInsetsListener(widgetHomePanelRightBinding.a, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.home.WidgetHome.setPanelWindowInsetsListeners.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                FragmentContainerView fragmentContainerView = WidgetHome.this.getBinding().f.c;
                Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.panelRight.widgetConnectedList");
                fragmentContainerView.setPadding(fragmentContainerView.getPaddingLeft(), fragmentContainerView.getPaddingTop(), fragmentContainerView.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    private final void setupSmoothKeyboardReaction() {
        WidgetHomePanelCenterBinding widgetHomePanelCenterBinding = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding, "binding.panelCenter");
        RoundedRelativeLayout roundedRelativeLayout = widgetHomePanelCenterBinding.a;
        Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelCenter.root");
        Iterator<View> it = androidx.core.view.ViewGroup.iterator(roundedRelativeLayout);
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
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager);
    }

    private final void showGuildEventUpsell(long guildId) {
        WidgetGuildScheduledEventUpsellBottomSheet.Companion companion = WidgetGuildScheduledEventUpsellBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.launch(parentFragmentManager, guildId);
    }

    private final void showGuildRoleSubscriptionUpsell(long guildId) {
        WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.Companion companion = WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, guildId);
    }

    private final void showInteractionModal(InteractionModalCreate modal) {
        Context context = getContext();
        if (context != null) {
            ModalComponent.Companion companion = ModalComponent.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            companion.show(context, new ModalComponent.Options(modal));
        }
    }

    private final void showPlaystationUpsell() {
        WidgetPlaystationIntegrationUpsellBottomSheet.Companion companion = WidgetPlaystationIntegrationUpsellBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager);
    }

    private final void showSurvey(SurveyUtils.Survey survey) {
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(survey.getNoticeKey(), null, 0L, 5, true, null, 0L, false, 0L, new AnonymousClass1(survey), 486, null));
    }

    private final void showUrgentMessageDialog() {
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("URGENT_MESSAGE_DIALOG", null, 0L, 0, false, null, 0L, false, 0L, AnonymousClass1.INSTANCE, Opcodes.IF_ACMPNE, null));
    }

    private final void showWelcomeSheet(long guildId, Long guildScheduledEventId) {
        if (StoreStream.INSTANCE.getGuildWelcomeScreens().hasWelcomeScreenBeenSeen(guildId)) {
            return;
        }
        WidgetGuildWelcomeSheet.Companion companion = WidgetGuildWelcomeSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        HomePanelsLayout homePanelsLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(homePanelsLayout, "binding.overlappingPanels");
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
        WidgetHomePanelCenterContentUnreadBinding widgetHomePanelCenterContentUnreadBinding = getBinding().d.c.c;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterContentUnreadBinding, "binding.panelCenter.widg…omePanelCenterChat.unread");
        TextView textView = widgetHomePanelCenterContentUnreadBinding.a;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.panelCenter.widg…nelCenterChat.unread.root");
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
            if (ChannelUtils.J(channel2.getChannel())) {
                if (selectedVoiceChannel == null || ChannelUtils.B(selectedVoiceChannel) || selectedVoiceChannel.getId() != selectedChannel.getId()) {
                    WidgetCallPreviewFullscreen.Companion.launch$default(WidgetCallPreviewFullscreen.INSTANCE, requireContext(), channel2.getChannel().getId(), null, 4, null);
                    requireAppActivity().overridePendingTransition(R.anim.activity_slide_horizontal_close_in, R.anim.activity_slide_horizontal_close_out);
                    return;
                } else {
                    WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), ((StoreChannelsSelected.ResolvedSelectedChannel.Channel) selectedChannel).getChannel().getId(), false, null, null, 28, null);
                    requireAppActivity().overridePendingTransition(R.anim.activity_slide_horizontal_close_in, R.anim.activity_slide_horizontal_close_out);
                    return;
                }
            }
        }
        getBinding().c.openStartPanel();
    }

    public final void lockCloseRightPanel(boolean lock) {
        getBinding().c.setEndPanelLockState(lock ? OverlappingPanelsLayout.LockState.CLOSE : OverlappingPanelsLayout.LockState.UNLOCKED);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LocaleProvider localeProvider = LocaleProvider.f251b;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        Intrinsics3.checkParameterIsNotNull(anonymousClass1, "provider");
        LocaleProvider.a = anonymousClass1;
    }

    @Override // b.a.o.PanelsChildGestureRegionObserver.a
    public void onGestureRegionsUpdate(List<Rect> gestureRegions) {
        Intrinsics3.checkNotNullParameter(gestureRegions, "gestureRegions");
        getBinding().c.setChildGestureRegions(gestureRegions);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
        Intrinsics3.checkParameterIsNotNull(this, "gestureRegionsListener");
        panelsChildGestureRegionObserverA.l.remove(this);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
        Intrinsics3.checkParameterIsNotNull(this, "gestureRegionsListener");
        onGestureRegionsUpdate(_Collections.toList(panelsChildGestureRegionObserverA.j.values()));
        panelsChildGestureRegionObserverA.l.add(this);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        WidgetHomeModel widgetHomeModel$app_productionGoogleRelease = getViewModel().getWidgetHomeModel();
        if (widgetHomeModel$app_productionGoogleRelease != null) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = WidgetHomeHeaderManager.INSTANCE;
            WidgetHomeBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            widgetHomeHeaderManager.configure(this, widgetHomeModel$app_productionGoogleRelease, binding);
        }
        if (getBinding().c.getSelectedPanel() == OverlappingPanelsLayout.Panel.CENTER) {
            setActionBarTitleAccessibilityViewFocused();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        boolean z2 = TextUtils.getLayoutDirectionFromLocale(new LocaleManager().getPrimaryLocale(requireContext())) == 0;
        RoundedRelativeLayout roundedRelativeLayout = getBinding().f.f169b;
        Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelRight.mainPanelRightRoundedContainer");
        ViewGroup.LayoutParams layoutParams = roundedRelativeLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int iDpToPixels = DimenUtils.dpToPixels(8);
        int i = z2 ? marginLayoutParams.leftMargin : iDpToPixels;
        if (!z2) {
            iDpToPixels = marginLayoutParams.rightMargin;
        }
        marginLayoutParams.setMargins(i, marginLayoutParams.topMargin, iDpToPixels, marginLayoutParams.bottomMargin);
        RoundedRelativeLayout roundedRelativeLayout2 = getBinding().f.f169b;
        Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout2, "binding.panelRight.mainPanelRightRoundedContainer");
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
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        this.panelLoading = new WidgetHomePanelLoading(binding);
        Function1<? super View, Unit> function1 = this.onGuildListAddHintCreate;
        TextView textView = getBinding().e.f155b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.panelLeft.guildListAddHint");
        function1.invoke(textView);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBound.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                return Boolean.valueOf(WidgetHome.this.handleBackPressed());
            }
        }, 0, 2, null);
        WidgetNoticeNuxSamsungLink.INSTANCE.enqueue(requireContext(), ClockFactory.get());
        setPanelWindowInsetsListeners();
        setupSmoothKeyboardReaction();
        Observable<StoreNux.NuxState> observableZ = StoreStream.INSTANCE.getNux().getNuxState().y(new Func1<StoreNux.NuxState, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBound.2
            @Override // j0.k.Func1
            public final Boolean call(StoreNux.NuxState nuxState) {
                FragmentActivity fragmentActivityE = WidgetHome.this.e();
                if (!(fragmentActivityE instanceof AppActivity)) {
                    fragmentActivityE = null;
                }
                AppActivity appActivity = (AppActivity) fragmentActivityE;
                return Boolean.valueOf(appActivity != null && appActivity.h(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class)));
            }
        }).z();
        Intrinsics3.checkNotNullExpressionValue(observableZ, "StoreStream\n        .get…       }\n        .first()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableZ, 0L, false, 1, null), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        WidgetHomeModel.Companion companion = WidgetHomeModel.INSTANCE;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.get(), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
        Observable observableS = ObservableExtensionsKt.ui$default(companion.get(), this, null, 2, null).s(new Func2<WidgetHomeModel, WidgetHomeModel, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBoundOrOnResume.4
            @Override // rx.functions.Func2
            public final Boolean call(WidgetHomeModel widgetHomeModel, WidgetHomeModel widgetHomeModel2) {
                return Boolean.valueOf(widgetHomeModel.getChannelId() == widgetHomeModel2.getChannelId());
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableS, "WidgetHomeModel\n        …lId == model2.channelId }");
        ObservableExtensionsKt.appSubscribe(observableS, (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass5());
        AccessibilityDetectionNavigator.INSTANCE.enqueueNoticeWhenEnabled(this);
        StoreStream.Companion companion2 = StoreStream.INSTANCE;
        configureNavigationDrawerAction(companion2.getNavigation());
        configureOverlappingPanels();
        Observable observableG = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(SurveyUtils.INSTANCE.getSurveyToShow(), 0L, false, 3, null), this, null, 2, null).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableY = observableG.y(new Func1<SurveyUtils.Survey, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBoundOrOnResume.6
            @Override // j0.k.Func1
            public final Boolean call(SurveyUtils.Survey survey) {
                return Boolean.valueOf(!Intrinsics3.areEqual(survey, SurveyUtils.Survey.None.INSTANCE));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "SurveyUtils\n        .get…SurveyUtils.Survey.None }");
        ObservableExtensionsKt.appSubscribe(observableY, (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass7(this));
        Observable<StoreNux.NuxState> observableY2 = companion2.getNux().getNuxState().y(new Func1<StoreNux.NuxState, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBoundOrOnResume.8
            @Override // j0.k.Func1
            public final Boolean call(StoreNux.NuxState nuxState) {
                return Boolean.valueOf(nuxState.getFirstOpen());
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY2, "StoreStream\n        .get… .filter { it.firstOpen }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY2, 0L, false, 1, null), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass9());
        Observable observableY3 = StoreUser.observeMe$default(companion2.getUsers(), false, 1, null).y(new Func1<MeUser, Boolean>() { // from class: com.discord.widgets.home.WidgetHome.onViewBoundOrOnResume.10
            @Override // j0.k.Func1
            public final Boolean call(MeUser meUser) {
                UserUtils userUtils = UserUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(meUser, "it");
                return Boolean.valueOf(userUtils.getHasUnreadUrgentMessages(meUser));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY3, "StoreStream\n        .get…hasUnreadUrgentMessages }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableY3, this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass11());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion2.getInteractions().observeModalCreate(), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass12());
        configureLeftPanel();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(this.globalStatusIndicatorStateObserver.observeState(), this, null, 2, null), (Class<?>) WidgetHome.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass13(this));
    }

    public final void setOnGuildListAddHintCreate(Function1<? super View, Unit> onGuildListAddHintCreate) {
        Intrinsics3.checkNotNullParameter(onGuildListAddHintCreate, "onGuildListAddHintCreate");
        this.onGuildListAddHintCreate = onGuildListAddHintCreate;
    }
}
