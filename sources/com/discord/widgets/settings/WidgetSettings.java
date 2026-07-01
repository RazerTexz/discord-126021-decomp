package com.discord.widgets.settings;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsBinding;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog$Builder;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.Badge$Companion;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.discord.widgets.user.profile.UserProfileHeaderView$Companion;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel$Builder;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings extends AppFragment implements OnTabSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: viewModelUserProfileHeader$delegate, reason: from kotlin metadata */
    private final Lazy viewModelUserProfileHeader;

    public WidgetSettings() {
        super(R$layout.widget_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettings$binding$2.INSTANCE, null, 2, null);
        WidgetSettings$viewModel$2 widgetSettings$viewModel$2 = WidgetSettings$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(SettingsViewModel.class), new WidgetSettings$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetSettings$viewModel$2));
        WidgetSettings$viewModelUserProfileHeader$2 widgetSettings$viewModelUserProfileHeader$2 = WidgetSettings$viewModelUserProfileHeader$2.INSTANCE;
        g0 g0Var2 = new g0(this);
        this.viewModelUserProfileHeader = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(UserProfileHeaderViewModel.class), new WidgetSettings$appViewModels$$inlined$viewModels$2(g0Var2), new i0(widgetSettings$viewModelUserProfileHeader$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettings widgetSettings, SettingsViewModel$ViewState settingsViewModel$ViewState) {
        widgetSettings.configureUI(settingsViewModel$ViewState);
    }

    public static final /* synthetic */ SettingsViewModel access$getViewModel$p(WidgetSettings widgetSettings) {
        return widgetSettings.getViewModel();
    }

    public static final /* synthetic */ UserProfileHeaderViewModel access$getViewModelUserProfileHeader$p(WidgetSettings widgetSettings) {
        return widgetSettings.getViewModelUserProfileHeader();
    }

    public static final /* synthetic */ void access$showLogoutDialog(WidgetSettings widgetSettings, Context context) {
        widgetSettings.showLogoutDialog(context);
    }

    private final void configureLoaded(SettingsViewModel$ViewState$Loaded model) {
        MeUser meUser = model.getMeUser();
        UserUtils userUtils = UserUtils.INSTANCE;
        boolean z2 = userUtils.isStaff(meUser);
        boolean zIsVerified = meUser.isVerified();
        boolean hasSubscription = userUtils.getHasSubscription(meUser);
        WidgetSettingsBinding binding = getBinding();
        View view = binding.n;
        m.checkNotNullExpressionValue(view, "developerOptionsDivider");
        view.setVisibility(z2 ? 0 : 8);
        TextView textView = binding.o;
        m.checkNotNullExpressionValue(textView, "developerOptionsHeader");
        textView.setVisibility(z2 ? 0 : 8);
        TextView textView2 = binding.m;
        m.checkNotNullExpressionValue(textView2, "developerOptions");
        textView2.setVisibility(z2 ? 0 : 8);
        binding.m.setOnClickListener(WidgetSettings$configureLoaded$1$1.INSTANCE);
        LinearLayout linearLayout = binding.u;
        m.checkNotNullExpressionValue(linearLayout, "nitroSettingsContainer");
        linearLayout.setVisibility(zIsVerified ? 0 : 8);
        TextView textView3 = binding.E;
        m.checkNotNullExpressionValue(textView3, "settingsNitro");
        textView3.setText(getString(hasSubscription ? 2131887103 : 2131894353));
        TextView textView4 = binding.q;
        m.checkNotNullExpressionValue(textView4, "nitroBoosting");
        textView4.setText(getString(hasSubscription ? 2131894041 : 2131894348));
        Presence presence = model.getPresence();
        binding.G.setPresence(presence);
        TextView textView5 = binding.F;
        m.checkNotNullExpressionValue(textView5, "settingsPresenceText");
        textView5.setText(getString(PresenceUtils.INSTANCE.getStatusStringResForPresence(presence)));
        TextView textView6 = binding.C;
        m.checkNotNullExpressionValue(textView6, "roleSubscriptions");
        textView6.setVisibility(model.getShowRoleSubscriptionsButton() ? 0 : 8);
        if (model.getPromoCount() > 0) {
            TextView textView7 = binding.r;
            m.checkNotNullExpressionValue(textView7, "nitroGiftingBadge");
            textView7.setText(String.valueOf(model.getPromoCount()));
            TextView textView8 = binding.r;
            m.checkNotNullExpressionValue(textView8, "nitroGiftingBadge");
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel$Builder().setAllCornerSizes(ShapeAppearanceModel.PILL).build());
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), 2131100382)));
            textView8.setBackground(materialShapeDrawable);
            TextView textView9 = binding.r;
            m.checkNotNullExpressionValue(textView9, "nitroGiftingBadge");
            textView9.setVisibility(0);
        } else {
            TextView textView10 = binding.r;
            m.checkNotNullExpressionValue(textView10, "nitroGiftingBadge");
            textView10.setVisibility(8);
        }
        LinearLayout linearLayout2 = binding.v;
        m.checkNotNullExpressionValue(linearLayout2, "notificationUpsell");
        linearLayout2.setVisibility((NotificationManagerCompat.from(requireContext()).areNotificationsEnabled() || model.getPushNotificationUpsellDismissed()) ? false : true ? 0 : 8);
    }

    private final void configureToolbar() {
        AppFragment.bindToolbar$default(this, null, 1, null);
        setActionBarTitle(2131896797);
        setActionBarTitleLayoutMinimumTappableArea();
        AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_settings, new WidgetSettings$configureToolbar$1(this), null, 4, null);
    }

    private final void configureUI(SettingsViewModel$ViewState model) {
        Unit unit;
        if (model instanceof SettingsViewModel$ViewState$Uninitialized) {
            unit = Unit.a;
        } else {
            if (!(model instanceof SettingsViewModel$ViewState$Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            configureLoaded((SettingsViewModel$ViewState$Loaded) model);
            unit = Unit.a;
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
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog$Builder.setNegativeButton$default(new WidgetNoticeDialog$Builder(context).setTitle(2131892654).setMessage(2131896867).setDialogAttrTheme(2130969885).setPositiveButton(2131892654, WidgetSettings$showLogoutDialog$1.INSTANCE), 2131887437, (Function1) null, 2, (Object) null).show(parentFragmentManager);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        configureToolbar();
        setActionBarTitleAccessibilityViewFocused();
        getViewModel().refreshSubscriptions();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetTabsHost)) {
            parentFragment = null;
        }
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) parentFragment;
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.SETTINGS, this);
        }
        WidgetSettingsBinding binding = getBinding();
        binding.D.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$1(this));
        UserProfileHeaderView userProfileHeaderView = binding.L;
        Badge$Companion badge$Companion = Badge.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        userProfileHeaderView.setOnBadgeClick(badge$Companion.onBadgeClick(parentFragmentManager, requireContext()));
        binding.L.setOnBannerPress(new WidgetSettings$onViewBound$$inlined$with$lambda$2(this));
        TextView textView = binding.f;
        m.checkNotNullExpressionValue(textView, "appInfoHeader");
        textView.setText(getString(2131886486) + " - 126.21 - Stable (126021)");
        binding.B.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$3(this));
        binding.u.setOnClickListener(WidgetSettings$onViewBound$1$5.INSTANCE);
        binding.q.setOnClickListener(WidgetSettings$onViewBound$1$6.INSTANCE);
        binding.C.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$4(this));
        binding.f2607s.setOnClickListener(WidgetSettings$onViewBound$1$8.INSTANCE);
        binding.c.setOnClickListener(WidgetSettings$onViewBound$1$9.INSTANCE);
        binding.A.setOnClickListener(WidgetSettings$onViewBound$1$10.INSTANCE);
        binding.i.setOnClickListener(WidgetSettings$onViewBound$1$11.INSTANCE);
        binding.f2610z.setOnClickListener(WidgetSettings$onViewBound$1$12.INSTANCE);
        binding.l.setOnClickListener(WidgetSettings$onViewBound$1$13.INSTANCE);
        binding.h.setOnClickListener(WidgetSettings$onViewBound$1$14.INSTANCE);
        binding.f2606b.setOnClickListener(WidgetSettings$onViewBound$1$15.INSTANCE);
        binding.j.setOnClickListener(WidgetSettings$onViewBound$1$16.INSTANCE);
        binding.p.setOnClickListener(WidgetSettings$onViewBound$1$17.INSTANCE);
        binding.e.setOnClickListener(WidgetSettings$onViewBound$1$18.INSTANCE);
        binding.f2609y.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$5(this));
        binding.I.setOnClickListener(WidgetSettings$onViewBound$1$20.INSTANCE);
        binding.M.setOnClickListener(WidgetSettings$onViewBound$1$21.INSTANCE);
        binding.H.setOnClickListener(WidgetSettings$onViewBound$1$22.INSTANCE);
        binding.J.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$6(binding, this));
        binding.d.setOnClickListener(WidgetSettings$onViewBound$1$24.INSTANCE);
        binding.k.setOnClickListener(WidgetSettings$onViewBound$1$25.INSTANCE);
        binding.f2608x.setOnClickListener(WidgetSettings$onViewBound$1$26.INSTANCE);
        binding.w.setOnClickListener(WidgetSettings$onViewBound$1$27.INSTANCE);
        for (TextView textView2 : n.listOf((Object[]) new TextView[]{binding.K, binding.t, binding.g, binding.o, binding.f})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView2, "header");
            accessibilityUtils.setViewIsHeading(textView2);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        UserProfileHeaderView$Companion userProfileHeaderView$Companion = UserProfileHeaderView.Companion;
        UserProfileHeaderView userProfileHeaderView = getBinding().L;
        m.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSettingsProfileHeaderView");
        userProfileHeaderView$Companion.bind(userProfileHeaderView, this, getViewModelUserProfileHeader().observeViewState());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettings$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
