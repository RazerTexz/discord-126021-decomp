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
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetSettingsBinding;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChangeLog;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.navigation.SystemSettingNavigators;
import com.discord.utilities.notifications.NotificationUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.debugging.WidgetDebugging;
import com.discord.widgets.media.WidgetQRScanner;
import com.discord.widgets.notice.WidgetNoticeDialog;
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
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings extends AppFragment implements OnTabSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: viewModelUserProfileHeader$delegate, reason: from kotlin metadata */
    private final Lazy viewModelUserProfileHeader;

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettings.kt */
    public static final /* synthetic */ class C96161 extends C12236k implements Function1<SettingsViewModel.ViewState, Unit> {
        public C96161(WidgetSettings widgetSettings) {
            super(1, widgetSettings, WidgetSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/SettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetSettings) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$showLogoutDialog$1 */
    /* JADX INFO: compiled from: WidgetSettings.kt */
    public static final class C96171 extends AbstractC12240o implements Function1<View, Unit> {
        public static final C96171 INSTANCE = new C96171();

        public C96171() {
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
            StoreStream.INSTANCE.getAuthentication().logout();
        }
    }

    public WidgetSettings() {
        super(C5419R.layout.widget_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettings$binding$2.INSTANCE, null, 2, null);
        WidgetSettings$viewModel$2 widgetSettings$viewModel$2 = WidgetSettings$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(SettingsViewModel.class), new WidgetSettings$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetSettings$viewModel$2));
        WidgetSettings$viewModelUserProfileHeader$2 widgetSettings$viewModelUserProfileHeader$2 = WidgetSettings$viewModelUserProfileHeader$2.INSTANCE;
        C0865g0 c0865g1 = new C0865g0(this);
        this.viewModelUserProfileHeader = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(UserProfileHeaderViewModel.class), new WidgetSettings$appViewModels$$inlined$viewModels$2(c0865g1), new C0869i0(widgetSettings$viewModelUserProfileHeader$2));
    }

    private final void configureLoaded(SettingsViewModel.ViewState.Loaded model) {
        MeUser meUser = model.getMeUser();
        UserUtils userUtils = UserUtils.INSTANCE;
        boolean z2 = userUtils.isStaff(meUser);
        boolean zIsVerified = meUser.isVerified();
        boolean hasSubscription = userUtils.getHasSubscription(meUser);
        WidgetSettingsBinding binding = getBinding();
        View view = binding.f17904n;
        C12238m.checkNotNullExpressionValue(view, "developerOptionsDivider");
        view.setVisibility(z2 ? 0 : 8);
        TextView textView = binding.f17905o;
        C12238m.checkNotNullExpressionValue(textView, "developerOptionsHeader");
        textView.setVisibility(z2 ? 0 : 8);
        TextView textView2 = binding.f17903m;
        C12238m.checkNotNullExpressionValue(textView2, "developerOptions");
        textView2.setVisibility(z2 ? 0 : 8);
        binding.f17903m.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$configureLoaded$1$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsDeveloper.Companion companion = WidgetSettingsDeveloper.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context);
            }
        });
        LinearLayout linearLayout = binding.f17911u;
        C12238m.checkNotNullExpressionValue(linearLayout, "nitroSettingsContainer");
        linearLayout.setVisibility(zIsVerified ? 0 : 8);
        TextView textView3 = binding.f17882E;
        C12238m.checkNotNullExpressionValue(textView3, "settingsNitro");
        textView3.setText(getString(hasSubscription ? C5419R.string.billing_manage_subscription : C5419R.string.premium_settings_subscribe_today));
        TextView textView4 = binding.f17907q;
        C12238m.checkNotNullExpressionValue(textView4, "nitroBoosting");
        textView4.setText(getString(hasSubscription ? C5419R.string.premium_guild_perks_modal_manage_your_subscriptions : C5419R.string.premium_settings_premium_guild_subscriptions));
        Presence presence = model.getPresence();
        binding.f17884G.setPresence(presence);
        TextView textView5 = binding.f17883F;
        C12238m.checkNotNullExpressionValue(textView5, "settingsPresenceText");
        textView5.setText(getString(PresenceUtils.INSTANCE.getStatusStringResForPresence(presence)));
        TextView textView6 = binding.f17880C;
        C12238m.checkNotNullExpressionValue(textView6, "roleSubscriptions");
        textView6.setVisibility(model.getShowRoleSubscriptionsButton() ? 0 : 8);
        if (model.getPromoCount() > 0) {
            TextView textView7 = binding.f17908r;
            C12238m.checkNotNullExpressionValue(textView7, "nitroGiftingBadge");
            textView7.setText(String.valueOf(model.getPromoCount()));
            TextView textView8 = binding.f17908r;
            C12238m.checkNotNullExpressionValue(textView8, "nitroGiftingBadge");
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel.Builder().setAllCornerSizes(ShapeAppearanceModel.PILL).build());
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), C5419R.color.status_red_500)));
            textView8.setBackground(materialShapeDrawable);
            TextView textView9 = binding.f17908r;
            C12238m.checkNotNullExpressionValue(textView9, "nitroGiftingBadge");
            textView9.setVisibility(0);
        } else {
            TextView textView10 = binding.f17908r;
            C12238m.checkNotNullExpressionValue(textView10, "nitroGiftingBadge");
            textView10.setVisibility(8);
        }
        LinearLayout linearLayout2 = binding.f17912v;
        C12238m.checkNotNullExpressionValue(linearLayout2, "notificationUpsell");
        linearLayout2.setVisibility((NotificationManagerCompat.from(requireContext()).areNotificationsEnabled() || model.getPushNotificationUpsellDismissed()) ? false : true ? 0 : 8);
    }

    private final void configureToolbar() {
        AppFragment.bindToolbar$default(this, null, 1, null);
        setActionBarTitle(C5419R.string.user_settings);
        setActionBarTitleLayoutMinimumTappableArea();
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_settings, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.settings.WidgetSettings.configureToolbar.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case C5419R.id.menu_settings_debugging /* 2131364408 */:
                        WidgetDebugging.Companion companion = WidgetDebugging.INSTANCE;
                        C12238m.checkNotNullExpressionValue(context, "context");
                        companion.launch(context);
                        break;
                    case C5419R.id.menu_settings_log_out /* 2131364409 */:
                        WidgetSettings widgetSettings = WidgetSettings.this;
                        C12238m.checkNotNullExpressionValue(context, "context");
                        widgetSettings.showLogoutDialog(context);
                        break;
                }
            }
        }, null, 4, null);
    }

    private final void configureUI(SettingsViewModel.ViewState model) {
        Unit unit;
        if (model instanceof SettingsViewModel.ViewState.Uninitialized) {
            unit = Unit.f27425a;
        } else {
            if (!(model instanceof SettingsViewModel.ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            configureLoaded((SettingsViewModel.ViewState.Loaded) model);
            unit = Unit.f27425a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
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
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(context).setTitle(C5419R.string.logout).setMessage(C5419R.string.user_settings_confirm_logout).setDialogAttrTheme(C5419R.attr.notice_theme_positive_red).setPositiveButton(C5419R.string.logout, C96171.INSTANCE), C5419R.string.cancel, (Function1) null, 2, (Object) null).show(parentFragmentManager);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        configureToolbar();
        setActionBarTitleAccessibilityViewFocused();
        getViewModel().refreshSubscriptions();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
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
        binding.f17881D.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet.Companion.show(this.this$0);
            }
        });
        UserProfileHeaderView userProfileHeaderView = binding.f17889L;
        Badge.Companion companion = Badge.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        userProfileHeaderView.setOnBadgeClick(companion.onBadgeClick(parentFragmentManager, requireContext()));
        binding.f17889L.setOnBannerPress(new WidgetSettings$onViewBound$$inlined$with$lambda$2(this));
        TextView textView = binding.f17896f;
        C12238m.checkNotNullExpressionValue(textView, "appInfoHeader");
        textView.setText(getString(C5419R.string.app_information) + " - 126.21 - Stable (126021)");
        binding.f17879B.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$3

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$3$1 */
            /* JADX INFO: compiled from: WidgetSettings.kt */
            public static final class C96111 extends AbstractC12240o implements Function0<Unit> {
                public C96111() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetQRScanner.Companion.launch$default(WidgetQRScanner.INSTANCE, WidgetSettings$onViewBound$$inlined$with$lambda$3.this.this$0.requireContext(), false, 2, null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.this$0.requestCameraQRScanner(new C96111());
            }
        });
        binding.f17911u.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsPremium.Companion companion2 = WidgetSettingsPremium.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                WidgetSettingsPremium.Companion.launch$default(companion2, context, null, null, 6, null);
            }
        });
        binding.f17907q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsGuildBoost.Companion companion2 = WidgetSettingsGuildBoost.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f17880C.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsViewModel viewModel = this.this$0.getViewModel();
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                viewModel.openRoleSubscriptionsManagement(context);
            }
        });
        binding.f17909s.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsGifting.Companion companion2 = WidgetSettingsGifting.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                WidgetSettingsGifting.Companion.launch$default(companion2, context, null, 2, null);
            }
        });
        binding.f17893c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAccount.Companion companion2 = WidgetSettingsAccount.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                WidgetSettingsAccount.Companion.launch$default(companion2, context, false, null, 6, null);
            }
        });
        binding.f17878A.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEditUserOrGuildMemberProfile.Companion.launch$default(WidgetEditUserOrGuildMemberProfile.INSTANCE, C1643a.m885x(view2, "it", "it.context"), AppTransitionActivity.Transition.TYPE_SLIDE_HORIZONTAL, null, 4, null);
            }
        });
        binding.f17899i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAuthorizedApps.Companion companion2 = WidgetSettingsAuthorizedApps.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f17916z.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsPrivacy.Companion companion2 = WidgetSettingsPrivacy.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f17902l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsUserConnections.Companion companion2 = WidgetSettingsUserConnections.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f17898h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAppearance.Companion companion2 = WidgetSettingsAppearance.Companion;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f17892b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAccessibility.Companion companion2 = WidgetSettingsAccessibility.Companion;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f17900j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsBehavior.Companion companion2 = WidgetSettingsBehavior.Companion;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f17906p.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsLanguage.Companion companion2 = WidgetSettingsLanguage.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f17895e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsActivityStatus.Companion companion2 = WidgetSettingsActivityStatus.Companion;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f17915y.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NotificationUtils.INSTANCE.showNotificationPage(this.this$0);
            }
        });
        binding.f17886I.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsMedia.Companion companion2 = WidgetSettingsMedia.Companion;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion2.launch(context);
            }
        });
        binding.f17890M.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsVoice.Companion companion2 = WidgetSettingsVoice.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                WidgetSettingsVoice.Companion.launch$default(companion2, context, null, false, 6, null);
            }
        });
        binding.f17885H.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, C1643a.m885x(view2, "it", "it.context"), "https://support.discord.com", false, false, null, 28, null);
            }
        });
        binding.f17887J.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$1 */
            /* JADX INFO: compiled from: WidgetSettings.kt */
            public static final class C96121 extends AbstractC12240o implements Function1<Boolean, Unit> {
                public C96121() {
                    super(1);
                }

                public static /* synthetic */ void invoke$default(C96121 c96121, boolean z2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        z2 = true;
                    }
                    c96121.invoke(z2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f27425a;
                }

                public final void invoke(boolean z2) {
                    WidgetSettings widgetSettings;
                    int i;
                    TextView textView = binding.f17887J;
                    C12238m.checkNotNullExpressionValue(textView, "uploadDebugLogs");
                    textView.setEnabled(z2);
                    TextView textView2 = binding.f17887J;
                    C12238m.checkNotNullExpressionValue(textView2, "uploadDebugLogs");
                    if (z2) {
                        widgetSettings = this;
                        i = C5419R.string.upload_debug_logs;
                    } else {
                        widgetSettings = this;
                        i = C5419R.string.working;
                    }
                    textView2.setText(widgetSettings.getString(i));
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$2 */
            /* JADX INFO: compiled from: WidgetSettings.kt */
            public static final class C96132 extends AbstractC12240o implements Function1<Void, Unit> {
                public final /* synthetic */ C96121 $updateUploadDebugLogsUI$1;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C96132(C96121 c96121) {
                    super(1);
                    this.$updateUploadDebugLogsUI$1 = c96121;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r4) {
                    C0876m.m171i(this, C5419R.string.upload_debug_log_success, 0, 4);
                    C96121.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$3 */
            /* JADX INFO: compiled from: WidgetSettings.kt */
            public static final class C96143 extends AbstractC12240o implements Function1<Error, Unit> {
                public final /* synthetic */ C96121 $updateUploadDebugLogsUI$1;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C96143(C96121 c96121) {
                    super(1);
                    this.$updateUploadDebugLogsUI$1 = c96121;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                    invoke2(error);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Error error) {
                    C12238m.checkNotNullParameter(error, "it");
                    C96121.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$4 */
            /* JADX INFO: compiled from: WidgetSettings.kt */
            public static final class C96154 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ C96121 $updateUploadDebugLogsUI$1;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C96154(C96121 c96121) {
                    super(0);
                    this.$updateUploadDebugLogsUI$1 = c96121;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C96121.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C96121 c96121 = new C96121();
                c96121.invoke(false);
                Observable observableUi$default = ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.uploadSystemLog(), this, null, 2, null);
                Context context = this.getContext();
                String name = binding.getClass().getName();
                C12238m.checkNotNullExpressionValue(name, "javaClass.name");
                ObservableExtensionsKt.appSubscribe(observableUi$default, (117 & 1) != 0 ? null : context, name, (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C96132(c96121), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : new C96143(c96121)), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : new C96154(c96121)), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
            }
        });
        binding.f17894d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, C1643a.m885x(view2, "it", "it.context"), "https://discord.com/acknowledgements", false, false, null, 28, null);
            }
        });
        binding.f17901k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StoreChangeLog changeLog = StoreStream.INSTANCE.getChangeLog();
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                changeLog.openChangeLog(context, true);
            }
        });
        binding.f17914x.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SystemSettingNavigators systemSettingNavigators = SystemSettingNavigators.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                systemSettingNavigators.openSystemNotification(context);
            }
        });
        binding.f17913w.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettings$onViewBound$1$27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StoreStream.INSTANCE.getNotificationUpsells().dismissPushNotificationsUpsell();
            }
        });
        for (TextView textView2 : C12147n.listOf((Object[]) new TextView[]{binding.f17888K, binding.f17910t, binding.f17897g, binding.f17905o, binding.f17896f})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView2, "header");
            accessibilityUtils.setViewIsHeading(textView2);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        UserProfileHeaderView.Companion companion = UserProfileHeaderView.INSTANCE;
        UserProfileHeaderView userProfileHeaderView = getBinding().f17889L;
        C12238m.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSettingsProfileHeaderView");
        companion.bind(userProfileHeaderView, this, getViewModelUserProfileHeader().observeViewState());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96161(this));
    }
}
