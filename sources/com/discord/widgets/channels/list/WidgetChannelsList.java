package com.discord.widgets.channels.list;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewStub;
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
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelsListBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.hubs.HubUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$DistinctChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.friends.EmptyFriendsStateView;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState$State;
import com.discord.widgets.tabs.BottomNavViewObserver;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout$LayoutParams;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList extends AppFragment {
    public static final String ANALYTICS_SOURCE = "Channels List";
    public static final float BANNER_TEXT_SHADOW_DX = 0.0f;
    public static final float BANNER_TEXT_SHADOW_DY = 4.0f;
    public static final float BANNER_TEXT_SHADOW_RADIUS = 1.0f;
    private final ActivityResultLauncher<Intent> activityResult;
    private WidgetChannelsListAdapter adapter;
    private final MGImages$DistinctChangeDetector bannerChangeDetector;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BottomNavViewObserver bottomNavViewObserver;
    private WidgetChannelListUnreads channelListUnreads;
    private final WidgetGlobalStatusIndicatorState globalStatusIndicatorStateObserver;
    private boolean isCollapsed;
    private Long selectedGuildId;
    private final StoreNavigation storeNavigation;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelsList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListBinding;", 0)};
    public static final WidgetChannelsList$Companion Companion = new WidgetChannelsList$Companion(null);

    public WidgetChannelsList() {
        super(R$layout.widget_channels_list);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelsList$binding$2.INSTANCE, null, 2, null);
        this.bottomNavViewObserver = BottomNavViewObserver.Companion.getINSTANCE();
        this.storeNavigation = StoreStream.Companion.getNavigation();
        this.globalStatusIndicatorStateObserver = WidgetGlobalStatusIndicatorState.Provider.get();
        this.activityResult = HubUtilsKt.getAddServerActivityResultHandler(this);
        this.bannerChangeDetector = new MGImages$DistinctChangeDetector();
    }

    public static final /* synthetic */ void access$ackPremiumGuildHint(WidgetChannelsList widgetChannelsList) {
        widgetChannelsList.ackPremiumGuildHint();
    }

    public static final /* synthetic */ void access$configureHeaderColors(WidgetChannelsList widgetChannelsList, Guild guild, boolean z2) {
        widgetChannelsList.configureHeaderColors(guild, z2);
    }

    public static final /* synthetic */ void access$configureHeaderIcons(WidgetChannelsList widgetChannelsList, Guild guild, boolean z2) {
        widgetChannelsList.configureHeaderIcons(guild, z2);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelsList widgetChannelsList, WidgetChannelListModel widgetChannelListModel) {
        widgetChannelsList.configureUI(widgetChannelListModel);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getActivityResult$p(WidgetChannelsList widgetChannelsList) {
        return widgetChannelsList.activityResult;
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsList widgetChannelsList) {
        WidgetChannelsListAdapter widgetChannelsListAdapter = widgetChannelsList.adapter;
        if (widgetChannelsListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        return widgetChannelsListAdapter;
    }

    public static final /* synthetic */ WidgetChannelsListBinding access$getBinding$p(WidgetChannelsList widgetChannelsList) {
        return widgetChannelsList.getBinding();
    }

    public static final /* synthetic */ WidgetChannelListUnreads access$getChannelListUnreads$p(WidgetChannelsList widgetChannelsList) {
        return widgetChannelsList.channelListUnreads;
    }

    public static final /* synthetic */ Long access$getSelectedGuildId$p(WidgetChannelsList widgetChannelsList) {
        return widgetChannelsList.selectedGuildId;
    }

    public static final /* synthetic */ StoreNavigation access$getStoreNavigation$p(WidgetChannelsList widgetChannelsList) {
        return widgetChannelsList.storeNavigation;
    }

    public static final /* synthetic */ void access$handleGlobalStatusIndicatorState(WidgetChannelsList widgetChannelsList, WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State) {
        widgetChannelsList.handleGlobalStatusIndicatorState(widgetGlobalStatusIndicatorState$State);
    }

    public static final /* synthetic */ boolean access$isCollapsed$p(WidgetChannelsList widgetChannelsList) {
        return widgetChannelsList.isCollapsed;
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetChannelsList widgetChannelsList, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        widgetChannelsList.adapter = widgetChannelsListAdapter;
    }

    public static final /* synthetic */ void access$setChannelListUnreads$p(WidgetChannelsList widgetChannelsList, WidgetChannelListUnreads widgetChannelListUnreads) {
        widgetChannelsList.channelListUnreads = widgetChannelListUnreads;
    }

    public static final /* synthetic */ void access$setCollapsed$p(WidgetChannelsList widgetChannelsList, boolean z2) {
        widgetChannelsList.isCollapsed = z2;
    }

    public static final /* synthetic */ void access$setSelectedGuildId$p(WidgetChannelsList widgetChannelsList, Long l) {
        widgetChannelsList.selectedGuildId = l;
    }

    private final void ackPremiumGuildHint() {
        StoreStream.Companion.getNux().setPremiumGuildHintGuildId(null);
    }

    private final void configureBottomNavSpace() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(this.bottomNavViewObserver.observeHeight(), this, null, 2, null), WidgetChannelsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelsList$configureBottomNavSpace$1(this), 62, (Object) null);
    }

    private final void configureHeaderColors(Guild guild, boolean hasBanner) {
        getBinding().g.setTextColor(getTintColor(requireContext(), guild, this.isCollapsed));
        getBinding().g.setShadowLayer(1.0f, 0.0f, 4.0f, (!hasBanner || this.isCollapsed) ? ColorCompat.getThemedColor(this, 2130968912) : ColorCompat.getColor(this, 2131099723));
        FrameLayout frameLayout = getBinding().e;
        m.checkNotNullExpressionValue(frameLayout, "binding.channelsListBannerForeground");
        frameLayout.setVisibility(hasBanner && !this.isCollapsed ? 0 : 8);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0004  */
    private final void configureHeaderIcons(Guild guild, boolean isCollapsed) {
        int i;
        if (guild == null) {
            i = 0;
        } else if (guild.getFeatures().contains(GuildFeature.VERIFIED)) {
            i = getBinding().f2282b.a() ? 2131232241 : 2131232242;
        } else if (guild.getFeatures().contains(GuildFeature.PARTNERED)) {
            i = getBinding().f2282b.a() ? 2131231995 : 2131231996;
        } else if (guild.getPremiumTier() == 0 && guild.getPremiumSubscriptionCount() > 0) {
            i = getBinding().f2282b.a() ? 2131231840 : 2131231841;
        } else if (guild.getPremiumTier() == 1) {
            i = getBinding().f2282b.a() ? 2131231828 : 2131231829;
        } else if (guild.getPremiumTier() == 2) {
            i = getBinding().f2282b.a() ? 2131231830 : 2131231831;
        } else if (guild.getPremiumTier() == 3) {
            i = getBinding().f2282b.a() ? 2131231832 : 2131231833;
        } else {
            i = 0;
        }
        TextView textView = getBinding().g;
        Drawable drawable = i == 0 ? null : ContextCompat.getDrawable(requireContext(), i);
        Drawable drawable2 = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), 2130969515, 0, 2, (Object) null));
        if (drawable2 != null) {
            ColorCompatKt.setTint(drawable2, getTintColor(requireContext(), guild, isCollapsed), false);
        } else {
            drawable2 = null;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, drawable2, (Drawable) null);
    }

    private final void configureUI(WidgetChannelListModel list) {
        Guild selectedGuild = list.getSelectedGuild();
        boolean z2 = (selectedGuild != null ? selectedGuild.getBanner() : null) != null;
        EmptyFriendsStateView emptyFriendsStateView = getBinding().p;
        m.checkNotNullExpressionValue(emptyFriendsStateView, "binding.widgetChannelsListEmptyFriendsStateView");
        emptyFriendsStateView.setVisibility(list.getShowEmptyState() ? 0 : 8);
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.channelsList");
        recyclerView.setVisibility(list.getShowEmptyState() ? 4 : 0);
        if (!m.areEqual(this.selectedGuildId, selectedGuild != null ? Long.valueOf(selectedGuild.getId()) : null)) {
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
                    m.throwUninitializedPropertyAccessException("adapter");
                }
                widgetChannelsListAdapter.setSelectedGuildId(jLongValue);
            }
        }
        WidgetChannelsListAdapter widgetChannelsListAdapter2 = this.adapter;
        if (widgetChannelsListAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter2.setData(list.getItems());
        CollapsingToolbarLayout collapsingToolbarLayout = getBinding().n;
        m.checkNotNullExpressionValue(collapsingToolbarLayout, "binding.collapsingToolbar");
        collapsingToolbarLayout.setVisibility(list.isGuildSelected() ? 0 : 8);
        CollapsingToolbarLayout collapsingToolbarLayout2 = getBinding().n;
        m.checkNotNullExpressionValue(collapsingToolbarLayout2, "binding.collapsingToolbar");
        ViewGroup$LayoutParams layoutParams = collapsingToolbarLayout2.getLayoutParams();
        if (!(layoutParams instanceof AppBarLayout$LayoutParams)) {
            layoutParams = null;
        }
        AppBarLayout$LayoutParams appBarLayout$LayoutParams = (AppBarLayout$LayoutParams) layoutParams;
        if (appBarLayout$LayoutParams != null) {
            appBarLayout$LayoutParams.setScrollFlags((list.isGuildSelected() && z2) ? 5 : 0);
        }
        Toolbar toolbar = getBinding().j;
        m.checkNotNullExpressionValue(toolbar, "binding.channelsListPrivateChannelsHeader");
        toolbar.setVisibility(!list.isGuildSelected() && !list.getShowEmptyState() ? 0 : 8);
        TextView textView = getBinding().k;
        m.checkNotNullExpressionValue(textView, "binding.channelsListSearch");
        textView.setVisibility(list.isGuildSelected() ^ true ? 0 : 8);
        getBinding().g.setOnClickListener(new WidgetChannelsList$configureUI$3(this, selectedGuild));
        TextView textView2 = getBinding().g;
        m.checkNotNullExpressionValue(textView2, "binding.channelsListHeader");
        textView2.setText(selectedGuild != null ? selectedGuild.getName() : null);
        configureHeaderIcons(selectedGuild, false);
        SimpleDraweeView simpleDraweeView = getBinding().d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListBanner");
        simpleDraweeView.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = getBinding().e;
        m.checkNotNullExpressionValue(frameLayout, "binding.channelsListBannerForeground");
        frameLayout.setVisibility(z2 && !this.isCollapsed ? 0 : 8);
        if (z2) {
            SimpleDraweeView simpleDraweeView2 = getBinding().d;
            ViewGroup$LayoutParams layoutParams2 = simpleDraweeView2.getLayoutParams();
            Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams2;
            viewGroup$MarginLayoutParams.bottomMargin = !list.getStartsWithPaddedElement() ? DimenUtils.dpToPixels(8) : 0;
            simpleDraweeView2.setLayoutParams(viewGroup$MarginLayoutParams);
            boolean zCanHaveAnimatedBanner = selectedGuild != null ? selectedGuild.canHaveAnimatedBanner() : false;
            m.checkNotNullExpressionValue(simpleDraweeView2, "this");
            MGImages.setImage$default(simpleDraweeView2, IconUtils.INSTANCE.getBannerForGuild(selectedGuild, Integer.valueOf(simpleDraweeView2.getResources().getDimensionPixelSize(2131165700)), zCanHaveAnimatedBanner), 0, 0, false, null, this.bannerChangeDetector, 60, null);
        }
        getBinding().f2282b.setOnPercentCollapsedCallback(new WidgetChannelsList$configureUI$5(this, selectedGuild, list, z2));
        ConstraintLayout constraintLayout = getBinding().h;
        m.checkNotNullExpressionValue(constraintLayout, "binding.channelsListPremiumGuildHint");
        constraintLayout.setVisibility(list.getShowPremiumGuildHint() ? 0 : 8);
    }

    private final WidgetChannelsListBinding getBinding() {
        return (WidgetChannelsListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getTintColor(Context context, Guild guild, boolean isCollapsed) {
        return ((guild != null ? guild.getBanner() : null) == null || isCollapsed) ? ColorCompat.getThemedColor(context, 2130969005) : ColorCompat.getColor(context, 2131100487);
    }

    private final void handleGlobalStatusIndicatorState(WidgetGlobalStatusIndicatorState$State state) {
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().p.updateView(ANALYTICS_SOURCE);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.channelsList");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetChannelsListAdapter widgetChannelsListAdapter = (WidgetChannelsListAdapter) mGRecyclerAdapter$Companion.configure(new WidgetChannelsListAdapter(recyclerView, parentFragmentManager));
        this.adapter = widgetChannelsListAdapter;
        if (widgetChannelsListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter.setOnSelectChannel(new WidgetChannelsList$onViewBound$1(this));
        WidgetChannelsListAdapter widgetChannelsListAdapter2 = this.adapter;
        if (widgetChannelsListAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter2.setOnSelectChannelOptions(new WidgetChannelsList$onViewBound$2(this));
        WidgetChannelsListAdapter widgetChannelsListAdapter3 = this.adapter;
        if (widgetChannelsListAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter3.setOnCallChannel(new WidgetChannelsList$onViewBound$3(this));
        WidgetChannelsListAdapter widgetChannelsListAdapter4 = this.adapter;
        if (widgetChannelsListAdapter4 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter4.setOnSelectGuildRoleSubscriptionLockedChannel(new WidgetChannelsList$onViewBound$4(this));
        WidgetChannelsListAdapter widgetChannelsListAdapter5 = this.adapter;
        if (widgetChannelsListAdapter5 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter5.setOnCollapseCategory(new WidgetChannelsList$onViewBound$5(this));
        WidgetChannelsListAdapter widgetChannelsListAdapter6 = this.adapter;
        if (widgetChannelsListAdapter6 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter6.setOnSelectInvite(new WidgetChannelsList$onViewBound$6(this));
        WidgetChannelsListAdapter widgetChannelsListAdapter7 = this.adapter;
        if (widgetChannelsListAdapter7 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter7.setOnSelectUserOptions(new WidgetChannelsList$onViewBound$7(this));
        WidgetChannelsListAdapter widgetChannelsListAdapter8 = this.adapter;
        if (widgetChannelsListAdapter8 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter8.setOnViewGuildScheduledEvents(new WidgetChannelsList$onViewBound$8(this));
        WidgetChannelsListAdapter widgetChannelsListAdapter9 = this.adapter;
        if (widgetChannelsListAdapter9 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter9.setOnViewGuildRoleSubscriptions(new WidgetChannelsList$onViewBound$9(this));
        WidgetChannelsListAdapter widgetChannelsListAdapter10 = this.adapter;
        if (widgetChannelsListAdapter10 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter10.setOnAddServer(new WidgetChannelsList$onViewBound$10(this));
        getBinding().k.setOnClickListener(new WidgetChannelsList$onViewBound$11(this));
        getBinding().c.setHasFixedSize(false);
        RecyclerView recyclerView2 = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView2, "binding.channelsList");
        recyclerView2.setItemAnimator(null);
        ViewStub viewStub = getBinding().m;
        m.checkNotNullExpressionValue(viewStub, "binding.channelsListUnreadsStub");
        RecyclerView recyclerView3 = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView3, "binding.channelsList");
        this.channelListUnreads = new WidgetChannelListUnreads(viewStub, recyclerView3, getBinding().f2282b, new WidgetChannelsList$onViewBound$12(this), 0, 0, false, 112, null);
        WidgetChannelsListAdapter widgetChannelsListAdapter11 = this.adapter;
        if (widgetChannelsListAdapter11 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChannelsListAdapter11.setOnUpdated(new WidgetChannelsList$onViewBound$13(this));
        getBinding().i.setOnClickListener(new WidgetChannelsList$onViewBound$14(this));
        getBinding().l.setOnClickListener(new WidgetChannelsList$onViewBound$15(this));
        ViewCompat.setAccessibilityHeading(getBinding().g, true);
        ViewCompat.setAccessibilityHeading(getBinding().f, true);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(WidgetChannelListModel.Companion.get());
        WidgetChannelsListAdapter widgetChannelsListAdapter = this.adapter;
        if (widgetChannelsListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableComputationLatest, this, widgetChannelsListAdapter), WidgetChannelsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelsList$onViewBoundOrOnResume$1(this), 62, (Object) null);
        if (getMostRecentIntent().getBooleanExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL", false)) {
            StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, StoreNavigation$PanelAction.OPEN, null, 2, null);
            getMostRecentIntent().removeExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL");
        }
        configureBottomNavSpace();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(this.globalStatusIndicatorStateObserver.observeState(), this, null, 2, null), WidgetChannelsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelsList$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
