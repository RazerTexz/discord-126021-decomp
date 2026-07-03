package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.ViewPager2ExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsGuildRoleSubscriptionEditTier.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_GROUP_LISTING_ID = "INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_GROUP_LISTING_ID";
    private static final String INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_TIER_LISTING_ID = "INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_TIER_LISTING_ID";

    /* JADX INFO: renamed from: SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTIONS_EDIT_TIER_VIEW_FLIPPER_LOADED_STATE */
    private static final int f19397xde0fc452 = 1;

    /* JADX INFO: renamed from: SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_EDIT_TIER_VIEW_FLIPPER_LOADING_STATE */
    private static final int f19398x15e1b612 = 0;
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

    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId, long guildRoleSubscriptionGroupListingId, long guildRoleSubscriptionTierListingId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetServerSettingsGuildRoleSubscriptionEditTier.INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_GROUP_LISTING_ID, guildRoleSubscriptionGroupListingId);
            intent.putExtra(WidgetServerSettingsGuildRoleSubscriptionEditTier.INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_TIER_LISTING_ID, guildRoleSubscriptionTierListingId);
            C0870j.m156d(context, WidgetServerSettingsGuildRoleSubscriptionEditTier.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    public static final class C94841 extends AbstractC12240o implements Function1<ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState, Unit> {
        public C94841() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier = WidgetServerSettingsGuildRoleSubscriptionEditTier.this;
            C12238m.checkNotNullExpressionValue(viewState, "it");
            widgetServerSettingsGuildRoleSubscriptionEditTier.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    public static final class C94852 extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C94852() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getViewModel().onTierUpdated(viewState.getGuildRoleSubscriptionTier());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    public static final class C94863 extends AbstractC12240o implements Function1<ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event, Unit> {
        public C94863() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "it");
            WidgetServerSettingsGuildRoleSubscriptionEditTier.this.handleEvents(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$setupAdapter$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    public static final class C94871 extends AbstractC12240o implements Function2<TabLayout.Tab, Integer, Unit> {
        public C94871() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
            invoke(tab, num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(TabLayout.Tab tab, int i) {
            C12238m.checkNotNullParameter(tab, "tab");
            tab.setText(WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getAdapter$p(WidgetServerSettingsGuildRoleSubscriptionEditTier.this).getTabStringResId(i));
        }
    }

    public WidgetServerSettingsGuildRoleSubscriptionEditTier() {
        super(C5419R.layout.widget_server_settings_guild_role_subscription_edit_tier);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsGuildRoleSubscriptionEditTier$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetServerSettingsGuildRoleSubscriptionEditTier$guildId$2(this));
        this.guildRoleSubscriptionGroupListingId = C12083g.lazy(new C9479x3c3916d8(this));
        this.guildRoleSubscriptionTierListingId = C12083g.lazy(new C9480x7ea58fc1(this));
        WidgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2 widgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2 = new WidgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ServerSettingsGuildRoleSubscriptionEditTierViewModel.class), new C9478xfb8769a9(c0865g0), new C0869i0(widgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2));
        this.tierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new C9476xc0debc87(this), new C0863f0(C9489xca2f3334.INSTANCE));
    }

    public static final /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierAdapter access$getAdapter$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        ServerSettingsGuildRoleSubscriptionEditTierAdapter serverSettingsGuildRoleSubscriptionEditTierAdapter = widgetServerSettingsGuildRoleSubscriptionEditTier.adapter;
        if (serverSettingsGuildRoleSubscriptionEditTierAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        return serverSettingsGuildRoleSubscriptionEditTierAdapter;
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState viewState) {
        if (C12238m.areEqual(viewState, ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState.Loading.INSTANCE)) {
            AppViewFlipper appViewFlipper = getBinding().f17667h;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…iptionEditTierViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (!(viewState instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState.Loaded)) {
            if (C12238m.areEqual(viewState, ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState.Failed.INSTANCE)) {
                C0876m.m171i(this, C5419R.string.default_failure_to_perform_action_message, 0, 4);
                requireActivity().finish();
                return;
            }
            return;
        }
        FloatingActionButton floatingActionButton = getBinding().f17666g;
        ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState.Loaded loaded = (ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState.Loaded) viewState;
        floatingActionButton.setVisibility(loaded.getHasChanges() ? 0 : 8);
        floatingActionButton.setEnabled(!loaded.isSubmitting());
        AppViewFlipper appViewFlipper2 = getBinding().f17667h;
        C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsGu…iptionEditTierViewFlipper");
        appViewFlipper2.setDisplayedChild(1);
        Group group = getBinding().f17662c;
        C12238m.checkNotNullExpressionValue(group, "binding.guildRoleSubscriptionEditTierPublishGroup");
        group.setVisibility(loaded.isPublished() ^ true ? 0 : 8);
        setActionBarTitle(loaded.getTierName());
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

    private final void handleEvents(ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event event) {
        if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.StoredStateUpdate) {
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.StoredStateUpdate storedStateUpdate = (ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.StoredStateUpdate) event;
            getTierViewModel().setTier(storedStateUpdate.getGuildRoleSubscriptionTier());
            getTierViewModel().setFullServerGating(storedStateUpdate.isFullServerGating());
        } else {
            if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.SubmitSuccess) {
                AppFragment.hideKeyboard$default(this, null, 1, null);
                return;
            }
            if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.SubmitFailure) {
                handleError(((ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.SubmitFailure) event).getError());
                return;
            }
            if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.DeleteFailure) {
                handleError(((ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.DeleteFailure) event).getError());
            } else if (C12238m.areEqual(event, ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.DeleteSuccess.INSTANCE)) {
                AppFragment.hideKeyboard$default(this, null, 1, null);
                requireActivity().finish();
            }
        }
    }

    private final void setupAdapter() {
        ServerSettingsGuildRoleSubscriptionEditTierAdapter serverSettingsGuildRoleSubscriptionEditTierAdapter = new ServerSettingsGuildRoleSubscriptionEditTierAdapter(this, getGuildId());
        this.adapter = serverSettingsGuildRoleSubscriptionEditTierAdapter;
        if (serverSettingsGuildRoleSubscriptionEditTierAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        serverSettingsGuildRoleSubscriptionEditTierAdapter.setPageSize(3);
        ViewPager2 viewPager2 = getBinding().f17664e;
        C12238m.checkNotNullExpressionValue(viewPager2, "binding.guildRoleSubscriptionEditTierViewPager");
        ServerSettingsGuildRoleSubscriptionEditTierAdapter serverSettingsGuildRoleSubscriptionEditTierAdapter2 = this.adapter;
        if (serverSettingsGuildRoleSubscriptionEditTierAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        viewPager2.setAdapter(serverSettingsGuildRoleSubscriptionEditTierAdapter2);
        TabLayout tabLayout = getBinding().f17663d;
        C12238m.checkNotNullExpressionValue(tabLayout, "binding.guildRoleSubscriptionEditTierTabs");
        ViewPager2 viewPager3 = getBinding().f17664e;
        C12238m.checkNotNullExpressionValue(viewPager3, "binding.guildRoleSubscriptionEditTierViewPager");
        ViewPager2ExtensionsKt.setUpWithViewPager2(tabLayout, viewPager3, new C94871());
        getBinding().f17663d.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier.setupAdapter.2
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    int position = tab.getPosition();
                    MaterialButton materialButton = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getBinding().f17665f;
                    C12238m.checkNotNullExpressionValue(materialButton, "binding.serverSettingsGu…ubscriptionEditTierDelete");
                    materialButton.setVisibility(WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getAdapter$p(WidgetServerSettingsGuildRoleSubscriptionEditTier.this).isDetailsTab(position) ? 0 : 8);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarSubtitle(C5419R.string.guild_settings_role_subscription_tier_edit_subtitle);
        getBinding().f17666g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getViewModel().submitChanges();
            }
        });
        getBinding().f17661b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier.onViewBound.2

            /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getViewModel().publishTier();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildRoleSubscriptionConfirmationDialog.Companion companion = GuildRoleSubscriptionConfirmationDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                String string = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(C5419R.string.guild_role_subscription_publish_tier_dialog_title);
                C12238m.checkNotNullExpressionValue(string, "getString(R.string.guild…ublish_tier_dialog_title)");
                String string2 = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(C5419R.string.guild_role_subscription_publish_tier_dialog_description);
                C12238m.checkNotNullExpressionValue(string2, "getString(R.string.guild…_tier_dialog_description)");
                String string3 = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(C5419R.string.guild_role_subscription_publish_tier_cta);
                C12238m.checkNotNullExpressionValue(string3, "getString(R.string.guild…ription_publish_tier_cta)");
                companion.show(parentFragmentManager, string, string2, string3, false, new AnonymousClass1());
            }
        });
        getBinding().f17665f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier.onViewBound.3

            /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getViewModel().deleteTier();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildRoleSubscriptionConfirmationDialog.Companion companion = GuildRoleSubscriptionConfirmationDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                String string = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(C5419R.string.guild_role_subscription_tier_delete_confirmation_title);
                C12238m.checkNotNullExpressionValue(string, "getString(R.string.guild…elete_confirmation_title)");
                String string2 = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(C5419R.string.guild_role_subscription_tier_delete_confirmation_title);
                C12238m.checkNotNullExpressionValue(string2, "getString(R.string.guild…elete_confirmation_title)");
                String string3 = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(C5419R.string.guild_role_subscription_tier_delete_cta);
                C12238m.checkNotNullExpressionValue(string3, "getString(R.string.guild…cription_tier_delete_cta)");
                companion.show(parentFragmentManager, string, string2, string3, true, new AnonymousClass1());
            }
        });
        setupAdapter();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetServerSettingsGuildRoleSubscriptionEditTier.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94841());
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableM11112r2 = getTierViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r2, "tierViewModel\n        .o…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r2, this, null, 2, null), (Class<?>) WidgetServerSettingsGuildRoleSubscriptionEditTier.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94852());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetServerSettingsGuildRoleSubscriptionEditTier.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94863());
    }
}
