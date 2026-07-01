package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.widget.ViewPager2;
import b.a.d.f0;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.ViewPager2ExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel$ViewState;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout$OnTabSelectedListener;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsGuildRoleSubscriptionEditTier.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;", 0)};
    public static final WidgetServerSettingsGuildRoleSubscriptionEditTier$Companion Companion = new WidgetServerSettingsGuildRoleSubscriptionEditTier$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_GROUP_LISTING_ID = "INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_GROUP_LISTING_ID";
    private static final String INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_TIER_LISTING_ID = "INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_TIER_LISTING_ID";
    private static final int SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTIONS_EDIT_TIER_VIEW_FLIPPER_LOADED_STATE = 1;
    private static final int SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_EDIT_TIER_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int TIER_PAGE_SIZE = 3;
    private ServerSettingsGuildRoleSubscriptionEditTierAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: guildRoleSubscriptionGroupListingId$delegate, reason: from kotlin metadata */
    private final Lazy guildRoleSubscriptionGroupListingId;

    /* JADX INFO: renamed from: guildRoleSubscriptionTierListingId$delegate, reason: from kotlin metadata */
    private final Lazy guildRoleSubscriptionTierListingId;

    /* JADX INFO: renamed from: tierViewModel$delegate, reason: from kotlin metadata */
    private final Lazy tierViewModel;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetServerSettingsGuildRoleSubscriptionEditTier() {
        super(R$layout.widget_server_settings_guild_role_subscription_edit_tier);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsGuildRoleSubscriptionEditTier$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetServerSettingsGuildRoleSubscriptionEditTier$guildId$2(this));
        this.guildRoleSubscriptionGroupListingId = g.lazy(new WidgetServerSettingsGuildRoleSubscriptionEditTier$guildRoleSubscriptionGroupListingId$2(this));
        this.guildRoleSubscriptionTierListingId = g.lazy(new WidgetServerSettingsGuildRoleSubscriptionEditTier$guildRoleSubscriptionTierListingId$2(this));
        WidgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2 widgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2 = new WidgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ServerSettingsGuildRoleSubscriptionEditTierViewModel.class), new WidgetServerSettingsGuildRoleSubscriptionEditTier$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2));
        this.tierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetServerSettingsGuildRoleSubscriptionEditTier$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetServerSettingsGuildRoleSubscriptionEditTier$tierViewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier, ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState) {
        widgetServerSettingsGuildRoleSubscriptionEditTier.configureUI(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState);
    }

    public static final /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierAdapter access$getAdapter$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        ServerSettingsGuildRoleSubscriptionEditTierAdapter serverSettingsGuildRoleSubscriptionEditTierAdapter = widgetServerSettingsGuildRoleSubscriptionEditTier.adapter;
        if (serverSettingsGuildRoleSubscriptionEditTierAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        return serverSettingsGuildRoleSubscriptionEditTierAdapter;
    }

    public static final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTierBinding access$getBinding$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        return widgetServerSettingsGuildRoleSubscriptionEditTier.getBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        return widgetServerSettingsGuildRoleSubscriptionEditTier.getGuildId();
    }

    public static final /* synthetic */ long access$getGuildRoleSubscriptionGroupListingId$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        return widgetServerSettingsGuildRoleSubscriptionEditTier.getGuildRoleSubscriptionGroupListingId();
    }

    public static final /* synthetic */ long access$getGuildRoleSubscriptionTierListingId$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        return widgetServerSettingsGuildRoleSubscriptionEditTier.getGuildRoleSubscriptionTierListingId();
    }

    public static final /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel access$getViewModel$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        return widgetServerSettingsGuildRoleSubscriptionEditTier.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvents(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier, ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event serverSettingsGuildRoleSubscriptionEditTierViewModel$Event) {
        widgetServerSettingsGuildRoleSubscriptionEditTier.handleEvents(serverSettingsGuildRoleSubscriptionEditTierViewModel$Event);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier, ServerSettingsGuildRoleSubscriptionEditTierAdapter serverSettingsGuildRoleSubscriptionEditTierAdapter) {
        widgetServerSettingsGuildRoleSubscriptionEditTier.adapter = serverSettingsGuildRoleSubscriptionEditTierAdapter;
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState viewState) {
        if (m.areEqual(viewState, ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loading.INSTANCE)) {
            AppViewFlipper appViewFlipper = getBinding().h;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…iptionEditTierViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (!(viewState instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded)) {
            if (m.areEqual(viewState, ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Failed.INSTANCE)) {
                b.a.d.m.i(this, 2131888366, 0, 4);
                requireActivity().finish();
                return;
            }
            return;
        }
        FloatingActionButton floatingActionButton = getBinding().g;
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded) viewState;
        floatingActionButton.setVisibility(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.getHasChanges() ? 0 : 8);
        floatingActionButton.setEnabled(!serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.isSubmitting());
        AppViewFlipper appViewFlipper2 = getBinding().h;
        m.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsGu…iptionEditTierViewFlipper");
        appViewFlipper2.setDisplayedChild(1);
        Group group = getBinding().c;
        m.checkNotNullExpressionValue(group, "binding.guildRoleSubscriptionEditTierPublishGroup");
        group.setVisibility(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.isPublished() ^ true ? 0 : 8);
        setActionBarTitle(serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.getTierName());
    }

    private final WidgetServerSettingsGuildRoleSubscriptionEditTierBinding getBinding() {
        return (WidgetServerSettingsGuildRoleSubscriptionEditTierBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getGuildRoleSubscriptionGroupListingId() {
        return ((Number) this.guildRoleSubscriptionGroupListingId.getValue()).longValue();
    }

    private final long getGuildRoleSubscriptionTierListingId() {
        return ((Number) this.guildRoleSubscriptionTierListingId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionTierViewModel getTierViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.tierViewModel.getValue();
    }

    private final ServerSettingsGuildRoleSubscriptionEditTierViewModel getViewModel() {
        return (ServerSettingsGuildRoleSubscriptionEditTierViewModel) this.viewModel.getValue();
    }

    private final void handleError(Error error) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        error.showToasts(requireContext());
    }

    private final void handleEvents(ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event event) {
        if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate) {
            ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate = (ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate) event;
            getTierViewModel().setTier(serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate.getGuildRoleSubscriptionTier());
            getTierViewModel().setFullServerGating(serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate.isFullServerGating());
        } else {
            if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$SubmitSuccess) {
                AppFragment.hideKeyboard$default(this, null, 1, null);
                return;
            }
            if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$SubmitFailure) {
                handleError(((ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$SubmitFailure) event).getError());
                return;
            }
            if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure) {
                handleError(((ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure) event).getError());
            } else if (m.areEqual(event, ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteSuccess.INSTANCE)) {
                AppFragment.hideKeyboard$default(this, null, 1, null);
                requireActivity().finish();
            }
        }
    }

    private final void setupAdapter() {
        ServerSettingsGuildRoleSubscriptionEditTierAdapter serverSettingsGuildRoleSubscriptionEditTierAdapter = new ServerSettingsGuildRoleSubscriptionEditTierAdapter(this, getGuildId());
        this.adapter = serverSettingsGuildRoleSubscriptionEditTierAdapter;
        if (serverSettingsGuildRoleSubscriptionEditTierAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        serverSettingsGuildRoleSubscriptionEditTierAdapter.setPageSize(3);
        ViewPager2 viewPager2 = getBinding().e;
        m.checkNotNullExpressionValue(viewPager2, "binding.guildRoleSubscriptionEditTierViewPager");
        ServerSettingsGuildRoleSubscriptionEditTierAdapter serverSettingsGuildRoleSubscriptionEditTierAdapter2 = this.adapter;
        if (serverSettingsGuildRoleSubscriptionEditTierAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        viewPager2.setAdapter(serverSettingsGuildRoleSubscriptionEditTierAdapter2);
        TabLayout tabLayout = getBinding().d;
        m.checkNotNullExpressionValue(tabLayout, "binding.guildRoleSubscriptionEditTierTabs");
        ViewPager2 viewPager3 = getBinding().e;
        m.checkNotNullExpressionValue(viewPager3, "binding.guildRoleSubscriptionEditTierViewPager");
        ViewPager2ExtensionsKt.setUpWithViewPager2(tabLayout, viewPager3, new WidgetServerSettingsGuildRoleSubscriptionEditTier$setupAdapter$1(this));
        getBinding().d.addOnTabSelectedListener((TabLayout$OnTabSelectedListener) new WidgetServerSettingsGuildRoleSubscriptionEditTier$setupAdapter$2(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarSubtitle(2131891420);
        getBinding().g.setOnClickListener(new WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$1(this));
        getBinding().f2569b.setOnClickListener(new WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$2(this));
        getBinding().f.setOnClickListener(new WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3(this));
        setupAdapter();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptionEditTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$1(this), 62, (Object) null);
        Observable<GuildRoleSubscriptionTierViewModel$ViewState> observableR2 = getTierViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR2, "tierViewModel\n        .o…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR2, this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptionEditTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$2(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptionEditTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$3(this), 62, (Object) null);
    }
}
