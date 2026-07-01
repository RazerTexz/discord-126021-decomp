package com.discord.widgets.settings;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetSettingsBinding;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChangeLog;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.navigation.SystemSettingNavigators;
import com.discord.utilities.notifications.NotificationUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.debugging.WidgetDebugging;
import com.discord.widgets.media.WidgetQRScanner;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.SettingsViewModel;
import com.discord.widgets.settings.WidgetSettingsAccessibility;
import com.discord.widgets.settings.WidgetSettingsActivityStatus;
import com.discord.widgets.settings.WidgetSettingsAppearance;
import com.discord.widgets.settings.WidgetSettingsAuthorizedApps;
import com.discord.widgets.settings.WidgetSettingsBehavior;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import com.discord.widgets.settings.WidgetSettingsMedia;
import com.discord.widgets.settings.WidgetSettingsPrivacy;
import com.discord.widgets.settings.WidgetSettingsVoice;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.WidgetUserStatusSheet;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings extends AppFragment implements OnTabSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: viewModelUserProfileHeader$delegate, reason: from kotlin metadata */
    private final Lazy viewModelUserProfileHeader;

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettings.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SettingsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetSettings widgetSettings) {
            super(1, widgetSettings, WidgetSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/SettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetSettings) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$showLogoutDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
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
            StoreStream.INSTANCE.getAuthentication().logout();
        }
    }

    public WidgetSettings() {
        super(R.layout.widget_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettings$binding$2.INSTANCE, null, 2, null);
        WidgetSettings$viewModel$2 widgetSettings$viewModel$2 = WidgetSettings$viewModel$2.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SettingsViewModel.class), new WidgetSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettings$viewModel$2));
        WidgetSettings$viewModelUserProfileHeader$2 widgetSettings$viewModelUserProfileHeader$2 = WidgetSettings$viewModelUserProfileHeader$2.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates4 = new AppViewModelDelegates3(this);
        this.viewModelUserProfileHeader = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(UserProfileHeaderViewModel.class), new WidgetSettings$appViewModels$$inlined$viewModels$2(appViewModelDelegates4), new AppViewModelDelegates5(widgetSettings$viewModelUserProfileHeader$2));
    }

    private final void configureLoaded(SettingsViewModel.ViewState.Loaded model) {
        MeUser meUser = model.getMeUser();
        UserUtils userUtils = UserUtils.INSTANCE;
        boolean z2 = userUtils.isStaff(meUser);
        boolean zIsVerified = meUser.isVerified();
        boolean hasSubscription = userUtils.getHasSubscription(meUser);
        WidgetSettingsBinding binding = getBinding();
        View view = binding.n;
        Intrinsics3.checkNotNullExpressionValue(view, "developerOptionsDivider");
        view.setVisibility(z2 ? 0 : 8);
        TextView textView = binding.o;
        Intrinsics3.checkNotNullExpressionValue(textView, "developerOptionsHeader");
        textView.setVisibility(z2 ? 0 : 8);
        TextView textView2 = binding.m;
        Intrinsics3.checkNotNullExpressionValue(textView2, "developerOptions");
        textView2.setVisibility(z2 ? 0 : 8);
        binding.m.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$configureLoaded$1$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsDeveloper.Companion companion = WidgetSettingsDeveloper.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context);
            }
        });
        LinearLayout linearLayout = binding.u;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "nitroSettingsContainer");
        linearLayout.setVisibility(zIsVerified ? 0 : 8);
        TextView textView3 = binding.E;
        Intrinsics3.checkNotNullExpressionValue(textView3, "settingsNitro");
        textView3.setText(getString(hasSubscription ? R.string.billing_manage_subscription : R.string.premium_settings_subscribe_today));
        TextView textView4 = binding.q;
        Intrinsics3.checkNotNullExpressionValue(textView4, "nitroBoosting");
        textView4.setText(getString(hasSubscription ? R.string.premium_guild_perks_modal_manage_your_subscriptions : R.string.premium_settings_premium_guild_subscriptions));
        Presence presence = model.getPresence();
        binding.G.setPresence(presence);
        TextView textView5 = binding.F;
        Intrinsics3.checkNotNullExpressionValue(textView5, "settingsPresenceText");
        textView5.setText(getString(PresenceUtils.INSTANCE.getStatusStringResForPresence(presence)));
        TextView textView6 = binding.C;
        Intrinsics3.checkNotNullExpressionValue(textView6, "roleSubscriptions");
        textView6.setVisibility(model.getShowRoleSubscriptionsButton() ? 0 : 8);
        if (model.getPromoCount() > 0) {
            TextView textView7 = binding.r;
            Intrinsics3.checkNotNullExpressionValue(textView7, "nitroGiftingBadge");
            textView7.setText(String.valueOf(model.getPromoCount()));
            TextView textView8 = binding.r;
            Intrinsics3.checkNotNullExpressionValue(textView8, "nitroGiftingBadge");
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel.Builder().setAllCornerSizes(ShapeAppearanceModel.PILL).build());
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.status_red_500)));
            textView8.setBackground(materialShapeDrawable);
            TextView textView9 = binding.r;
            Intrinsics3.checkNotNullExpressionValue(textView9, "nitroGiftingBadge");
            textView9.setVisibility(0);
        } else {
            TextView textView10 = binding.r;
            Intrinsics3.checkNotNullExpressionValue(textView10, "nitroGiftingBadge");
            textView10.setVisibility(8);
        }
        LinearLayout linearLayout2 = binding.v;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "notificationUpsell");
        linearLayout2.setVisibility((NotificationManagerCompat.from(requireContext()).areNotificationsEnabled() || model.getPushNotificationUpsellDismissed()) ? false : true ? 0 : 8);
    }

    private final void configureToolbar() {
        AppFragment.bindToolbar$default(this, null, 1, null);
        setActionBarTitle(R.string.user_settings);
        setActionBarTitleLayoutMinimumTappableArea();
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_settings, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.settings.WidgetSettings.configureToolbar.1
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case R.id.menu_settings_debugging /* 2131364408 */:
                        WidgetDebugging.Companion companion = WidgetDebugging.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(context, "context");
                        companion.launch(context);
                        break;
                    case R.id.menu_settings_log_out /* 2131364409 */:
                        WidgetSettings widgetSettings = WidgetSettings.this;
                        Intrinsics3.checkNotNullExpressionValue(context, "context");
                        widgetSettings.showLogoutDialog(context);
                        break;
                }
            }
        }, null, 4, null);
    }

    private final void configureUI(SettingsViewModel.ViewState model) {
        Unit unit;
        if (model instanceof SettingsViewModel.ViewState.Uninitialized) {
            unit = Unit.a;
        } else {
            if (!(model instanceof SettingsViewModel.ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            configureLoaded((SettingsViewModel.ViewState.Loaded) model);
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final WidgetSettingsBinding getBinding() {
        return (WidgetSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SettingsViewModel getViewModel() {
        return (SettingsViewModel) this.viewModel.getValue();
    }

    private final UserProfileHeaderViewModel getViewModelUserProfileHeader() {
        return (UserProfileHeaderViewModel) this.viewModelUserProfileHeader.getValue();
    }

    private final void showLogoutDialog(Context context) {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(context).setTitle(R.string.logout).setMessage(R.string.user_settings_confirm_logout).setDialogAttrTheme(R.attr.notice_theme_positive_red).setPositiveButton(R.string.logout, AnonymousClass1.INSTANCE), R.string.cancel, (Function1) null, 2, (Object) null).show(parentFragmentManager);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        configureToolbar();
        setActionBarTitleAccessibilityViewFocused();
        getViewModel().refreshSubscriptions();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetTabsHost)) {
            parentFragment = null;
        }
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) parentFragment;
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.SETTINGS, this);
        }
        final WidgetSettingsBinding binding = getBinding();
        binding.D.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet.Companion.show(this.this$0);
            }
        });
        UserProfileHeaderView userProfileHeaderView = binding.L;
        Badge.Companion companion = Badge.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        userProfileHeaderView.setOnBadgeClick(companion.onBadgeClick(parentFragmentManager, requireContext()));
        binding.L.setOnBannerPress(new WidgetSettings$onViewBound$$inlined$with$lambda$2(this));
        TextView textView = binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "appInfoHeader");
        textView.setText(getString(R.string.app_information) + " - 126.21 - Stable (126021)");
        binding.B.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$3

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetSettings.kt */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetQRScanner.Companion.launch$default(WidgetQRScanner.INSTANCE, WidgetSettings$onViewBound$$inlined$with$lambda$3.this.this$0.requireContext(), false, 2, null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.this$0.requestCameraQRScanner(new AnonymousClass1());
            }
        });
        binding.u.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsPremium.Companion companion2 = WidgetSettingsPremium.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                WidgetSettingsPremium.Companion.launch$default(companion2, context, null, null, 6, null);
            }
        });
        binding.q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsGuildBoost.Companion companion2 = WidgetSettingsGuildBoost.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.C.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsViewModel viewModel = this.this$0.getViewModel();
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                viewModel.openRoleSubscriptionsManagement(context);
            }
        });
        binding.f2607s.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsGifting.Companion companion2 = WidgetSettingsGifting.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                WidgetSettingsGifting.Companion.launch$default(companion2, context, null, 2, null);
            }
        });
        binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAccount.Companion companion2 = WidgetSettingsAccount.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                WidgetSettingsAccount.Companion.launch$default(companion2, context, false, null, 6, null);
            }
        });
        binding.A.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEditUserOrGuildMemberProfile.Companion.launch$default(WidgetEditUserOrGuildMemberProfile.INSTANCE, outline.x(view2, "it", "it.context"), AppTransitionActivity.Transition.TYPE_SLIDE_HORIZONTAL, null, 4, null);
            }
        });
        binding.i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAuthorizedApps.Companion companion2 = WidgetSettingsAuthorizedApps.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f2610z.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsPrivacy.Companion companion2 = WidgetSettingsPrivacy.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsUserConnections.Companion companion2 = WidgetSettingsUserConnections.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAppearance.Companion companion2 = WidgetSettingsAppearance.Companion;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f2606b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAccessibility.Companion companion2 = WidgetSettingsAccessibility.Companion;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsBehavior.Companion companion2 = WidgetSettingsBehavior.Companion;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.p.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsLanguage.Companion companion2 = WidgetSettingsLanguage.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsActivityStatus.Companion companion2 = WidgetSettingsActivityStatus.Companion;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f2609y.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NotificationUtils.INSTANCE.showNotificationPage(this.this$0);
            }
        });
        binding.I.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsMedia.Companion companion2 = WidgetSettingsMedia.Companion;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.M.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsVoice.Companion companion2 = WidgetSettingsVoice.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                WidgetSettingsVoice.Companion.launch$default(companion2, context, null, false, 6, null);
            }
        });
        binding.H.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view2, "it", "it.context"), "https://support.discord.com", false, false, null, 28, null);
            }
        });
        binding.J.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetSettings.kt */
            public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
                public AnonymousClass1() {
                    super(1);
                }

                public static /* synthetic */ void invoke$default(AnonymousClass1 anonymousClass1, boolean z2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        z2 = true;
                    }
                    anonymousClass1.invoke(z2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.a;
                }

                public final void invoke(boolean z2) {
                    WidgetSettings widgetSettings;
                    int i;
                    TextView textView = binding.J;
                    Intrinsics3.checkNotNullExpressionValue(textView, "uploadDebugLogs");
                    textView.setEnabled(z2);
                    TextView textView2 = binding.J;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "uploadDebugLogs");
                    if (z2) {
                        widgetSettings = this;
                        i = R.string.upload_debug_logs;
                    } else {
                        widgetSettings = this;
                        i = R.string.working;
                    }
                    textView2.setText(widgetSettings.getString(i));
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetSettings.kt */
            public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
                public final /* synthetic */ AnonymousClass1 $updateUploadDebugLogsUI$1;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(AnonymousClass1 anonymousClass1) {
                    super(1);
                    this.$updateUploadDebugLogsUI$1 = anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r4) {
                    AppToast.i(this, R.string.upload_debug_log_success, 0, 4);
                    AnonymousClass1.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$3, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetSettings.kt */
            public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
                public final /* synthetic */ AnonymousClass1 $updateUploadDebugLogsUI$1;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(AnonymousClass1 anonymousClass1) {
                    super(1);
                    this.$updateUploadDebugLogsUI$1 = anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                    invoke2(error);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Error error) {
                    Intrinsics3.checkNotNullParameter(error, "it");
                    AnonymousClass1.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$4, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetSettings.kt */
            public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ AnonymousClass1 $updateUploadDebugLogsUI$1;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass4(AnonymousClass1 anonymousClass1) {
                    super(0);
                    this.$updateUploadDebugLogsUI$1 = anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1();
                anonymousClass1.invoke(false);
                Observable observableUi$default = ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.uploadSystemLog(), this, null, 2, null);
                Context context = this.getContext();
                String name = binding.getClass().getName();
                Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
                ObservableExtensionsKt.appSubscribe(observableUi$default, (117 & 1) != 0 ? null : context, name, (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass2(anonymousClass1), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : new AnonymousClass3(anonymousClass1)), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : new AnonymousClass4(anonymousClass1)), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
            }
        });
        binding.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view2, "it", "it.context"), "https://discord.com/acknowledgements", false, false, null, 28, null);
            }
        });
        binding.k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StoreChangeLog changeLog = StoreStream.INSTANCE.getChangeLog();
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                changeLog.openChangeLog(context, true);
            }
        });
        binding.f2608x.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SystemSettingNavigators systemSettingNavigators = SystemSettingNavigators.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                systemSettingNavigators.openSystemNotification(context);
            }
        });
        binding.w.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StoreStream.INSTANCE.getNotificationUpsells().dismissPushNotificationsUpsell();
            }
        });
        for (TextView textView2 : Collections2.listOf((Object[]) new TextView[]{binding.K, binding.t, binding.g, binding.o, binding.f})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView2, "header");
            accessibilityUtils.setViewIsHeading(textView2);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        UserProfileHeaderView.Companion companion = UserProfileHeaderView.INSTANCE;
        UserProfileHeaderView userProfileHeaderView = getBinding().L;
        Intrinsics3.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSettingsProfileHeaderView");
        companion.bind(userProfileHeaderView, this, getViewModelUserProfileHeader().observeViewState());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
