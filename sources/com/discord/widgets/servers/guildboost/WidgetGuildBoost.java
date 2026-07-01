package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.R$plurals;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerBoostStatusBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.analytics.Traits$Location$ObjType;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.discord.widgets.settings.premium.WidgetChoosePlan$Companion;
import com.discord.widgets.settings.premium.WidgetChoosePlan$ViewType;
import d0.g;
import d0.o;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildBoost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerBoostStatusBinding;", 0)};
    public static final WidgetGuildBoost$Companion Companion = new WidgetGuildBoost$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final int VIEW_INDEX_LOADED = 2;
    private static final int VIEW_INDEX_LOADING = 0;
    private static final int VIEW_INDEX_LOAD_FAILED = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> choosePlanLauncher;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private List<? extends ImageView> levelBackgrounds;
    private List<? extends TextView> levelText;
    private WidgetGuildBoost$PerksPagerAdapter pagerAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private boolean wasPagerPageSet;

    public WidgetGuildBoost() {
        super(R$layout.widget_server_boost_status);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildBoost$binding$2.INSTANCE, null, 2, null);
        WidgetGuildBoost$viewModel$2 widgetGuildBoost$viewModel$2 = new WidgetGuildBoost$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildBoostViewModel.class), new WidgetGuildBoost$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildBoost$viewModel$2));
        this.choosePlanLauncher = WidgetChoosePlan.Companion.registerForResult(this, new WidgetGuildBoost$choosePlanLauncher$1(this));
        this.guildId = g.lazy(new WidgetGuildBoost$guildId$2(this));
    }

    public static final /* synthetic */ void access$configureLevelBubbles(WidgetGuildBoost widgetGuildBoost, int i) {
        widgetGuildBoost.configureLevelBubbles(i);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildBoost widgetGuildBoost, GuildBoostViewModel$ViewState guildBoostViewModel$ViewState) {
        widgetGuildBoost.configureUI(guildBoostViewModel$ViewState);
    }

    public static final /* synthetic */ void access$fetchData(WidgetGuildBoost widgetGuildBoost) {
        widgetGuildBoost.fetchData();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildBoost widgetGuildBoost) {
        return widgetGuildBoost.getGuildId();
    }

    public static final /* synthetic */ GuildBoostViewModel access$getViewModel$p(WidgetGuildBoost widgetGuildBoost) {
        return widgetGuildBoost.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildBoost widgetGuildBoost, GuildBoostViewModel$Event guildBoostViewModel$Event) {
        widgetGuildBoost.handleEvent(guildBoostViewModel$Event);
    }

    private final void configureLevelBubbles(int currentSelected) {
        int i = 0;
        while (i <= 3) {
            List<? extends ImageView> list = this.levelBackgrounds;
            if (list == null) {
                m.throwUninitializedPropertyAccessException("levelBackgrounds");
            }
            ImageView imageView = list.get(i);
            ViewGroup$LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = DimenUtils.dpToPixels(currentSelected == i ? 32 : 20);
            layoutParams.width = DimenUtils.dpToPixels(currentSelected != i ? 20 : 32);
            imageView.setLayoutParams(layoutParams);
            List<? extends TextView> list2 = this.levelText;
            if (list2 == null) {
                m.throwUninitializedPropertyAccessException("levelText");
            }
            TextView textView = list2.get(i);
            if (textView != null) {
                textView.setTextColor(currentSelected == i ? ColorCompat.getThemedColor(textView, 2130969970) : ColorCompat.getThemedColor(textView, 2130969981));
            }
            i++;
        }
    }

    private final void configureProgressBar(long guildId, int premiumTier, int subscriptionCount) {
        int i;
        ProgressBar progressBar = getBinding().l.f222b;
        m.checkNotNullExpressionValue(progressBar, "binding.progress.boostBarProgressBar");
        progressBar.setProgress(GuildBoostUtils.calculateTotalProgress$default(GuildBoostUtils.INSTANCE, guildId, premiumTier, subscriptionCount, null, null, 24, null));
        ProgressBar progressBar2 = getBinding().l.f222b;
        m.checkNotNullExpressionValue(progressBar2, "binding.progress.boostBarProgressBar");
        if (premiumTier == 0) {
            i = 2131894022;
        } else if (premiumTier == 1) {
            i = 2131894200;
        } else if (premiumTier != 2) {
            i = premiumTier != 3 ? 0 : 2131894204;
        } else {
            i = 2131894202;
        }
        progressBar2.setContentDescription(getString(i));
        ImageView imageView = getBinding().l.c;
        m.checkNotNullExpressionValue(imageView, "binding.progress.boostBarTier0Iv");
        imageView.setEnabled(subscriptionCount > 0);
        ImageView imageView2 = getBinding().l.d;
        m.checkNotNullExpressionValue(imageView2, "binding.progress.boostBarTier1Iv");
        imageView2.setEnabled(premiumTier >= 1);
        ImageView imageView3 = getBinding().l.f;
        m.checkNotNullExpressionValue(imageView3, "binding.progress.boostBarTier2Iv");
        imageView3.setEnabled(premiumTier >= 2);
        ImageView imageView4 = getBinding().l.h;
        m.checkNotNullExpressionValue(imageView4, "binding.progress.boostBarTier3Iv");
        imageView4.setEnabled(premiumTier >= 3);
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(2131894037);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(GuildBoostViewModel$ViewState viewState) {
        if (viewState instanceof GuildBoostViewModel$ViewState$Loading) {
            AppViewFlipper appViewFlipper = getBinding().f2535b;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.boostStatusFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof GuildBoostViewModel$ViewState$Failure) {
            AppViewFlipper appViewFlipper2 = getBinding().f2535b;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.boostStatusFlipper");
            appViewFlipper2.setDisplayedChild(1);
            getBinding().h.setOnClickListener(new WidgetGuildBoost$configureUI$1(this));
            return;
        }
        if (viewState instanceof GuildBoostViewModel$ViewState$Loaded) {
            AppViewFlipper appViewFlipper3 = getBinding().f2535b;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.boostStatusFlipper");
            appViewFlipper3.setDisplayedChild(2);
        }
        GuildBoostViewModel$ViewState$Loaded guildBoostViewModel$ViewState$Loaded = (GuildBoostViewModel$ViewState$Loaded) viewState;
        int premiumTier = guildBoostViewModel$ViewState$Loaded.getGuild().getPremiumTier();
        int premiumSubscriptionCount = guildBoostViewModel$ViewState$Loaded.getGuild().getPremiumSubscriptionCount();
        configureToolbar(guildBoostViewModel$ViewState$Loaded.getGuild().getName());
        configureProgressBar(guildBoostViewModel$ViewState$Loaded.getGuild().getId(), premiumTier, premiumSubscriptionCount);
        configureViewpager(premiumTier, premiumSubscriptionCount);
        getBinding().e.a(guildBoostViewModel$ViewState$Loaded.getMeUser().getPremiumTier(), new WidgetGuildBoost$configureUI$2(this));
        getBinding().f.a(guildBoostViewModel$ViewState$Loaded.getMeUser().getPremiumTier(), false);
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.boostStatusNumBoosts");
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        textView.setText(StringResourceUtilsKt.getQuantityString(resources, requireContext(), R$plurals.premium_guild_perks_modal_header_subscription_count_subscriptions, premiumSubscriptionCount, Integer.valueOf(premiumSubscriptionCount)));
    }

    private final void configureViewpager(int premiumTier, int subscriptionCount) {
        WidgetGuildBoost$PerksPagerAdapter widgetGuildBoost$PerksPagerAdapter = this.pagerAdapter;
        if (widgetGuildBoost$PerksPagerAdapter == null) {
            m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        widgetGuildBoost$PerksPagerAdapter.setPremiumTier(premiumTier);
        WidgetGuildBoost$PerksPagerAdapter widgetGuildBoost$PerksPagerAdapter2 = this.pagerAdapter;
        if (widgetGuildBoost$PerksPagerAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        widgetGuildBoost$PerksPagerAdapter2.setSubscriptionCount(subscriptionCount);
        WidgetGuildBoost$PerksPagerAdapter widgetGuildBoost$PerksPagerAdapter3 = this.pagerAdapter;
        if (widgetGuildBoost$PerksPagerAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        SimplePager simplePager = getBinding().k;
        m.checkNotNullExpressionValue(simplePager, "binding.boostStatusViewpager");
        widgetGuildBoost$PerksPagerAdapter3.configureViews(simplePager);
        if (this.wasPagerPageSet) {
            return;
        }
        getBinding().k.setCurrentItem(Math.max(0, premiumTier - 1), false);
        configureLevelBubbles(Math.max(1, premiumTier));
        this.wasPagerPageSet = true;
    }

    public static final void create(Context context, long j) {
        Companion.create(context, j);
    }

    private final void fetchData() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getGuildBoosts().fetchUserGuildBoostState();
        storeStream$Companion.getSubscriptions().fetchSubscriptions();
        GooglePlayBillingManager.INSTANCE.queryPurchases();
    }

    private final WidgetServerBoostStatusBinding getBinding() {
        return (WidgetServerBoostStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildBoostViewModel getViewModel() {
        return (GuildBoostViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GuildBoostViewModel$Event event) {
        if (event instanceof GuildBoostViewModel$Event$LaunchSubscriptionConfirmation) {
            AnalyticsTracker.INSTANCE.openModal(Traits$Location$Section.PREMIUM_GUILD_SUBSCRIPTION_CONFIRMATION, new Traits$Location(Traits$Location$Page.BOOST_MARKETING, Traits$Location$Section.HEADER, Traits$Location$Obj.BUTTON_CTA, Traits$Location$ObjType.BUY, null, 16, null));
            GuildBoostViewModel$Event$LaunchSubscriptionConfirmation guildBoostViewModel$Event$LaunchSubscriptionConfirmation = (GuildBoostViewModel$Event$LaunchSubscriptionConfirmation) event;
            WidgetGuildBoostConfirmation.Companion.create(requireContext(), guildBoostViewModel$Event$LaunchSubscriptionConfirmation.getGuildId(), guildBoostViewModel$Event$LaunchSubscriptionConfirmation.getSlotId());
            return;
        }
        if (event instanceof GuildBoostViewModel$Event$LaunchPurchaseSubscription) {
            GuildBoostViewModel$Event$LaunchPurchaseSubscription guildBoostViewModel$Event$LaunchPurchaseSubscription = (GuildBoostViewModel$Event$LaunchPurchaseSubscription) event;
            WidgetChoosePlan$Companion.launch$default(WidgetChoosePlan.Companion, requireContext(), this.choosePlanLauncher, WidgetChoosePlan$ViewType.BUY_PREMIUM_GUILD, guildBoostViewModel$Event$LaunchPurchaseSubscription.getOldSkuName(), new Traits$Location(Traits$Location$Page.BOOST_MARKETING, guildBoostViewModel$Event$LaunchPurchaseSubscription.getSection(), Traits$Location$Obj.BUTTON_CTA, Traits$Location$ObjType.BUY, null, 16, null), null, 32, null);
            return;
        }
        if (event instanceof GuildBoostViewModel$Event$ShowDesktopAlertDialog) {
            AnalyticsTracker.INSTANCE.openModal(Traits$Location$Section.ANDROID_CANNOT_MANAGE_SUBSCRIPTION, new Traits$Location(Traits$Location$Page.BOOST_MARKETING, Traits$Location$Section.HEADER, Traits$Location$Obj.BUTTON_CTA, Traits$Location$ObjType.BUY, null, 16, null));
            WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, getString(2131894139), b.k(this, 2131894138, new Object[]{f.a.a(360055386693L, null)}, null, 4), getString(2131894111), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            return;
        }
        if (event instanceof GuildBoostViewModel$Event$UnacknowledgedPurchase) {
            b.a.d.m.i(this, 2131887073, 0, 4);
            GooglePlayBillingManager.INSTANCE.queryPurchases();
        } else if (event instanceof GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog) {
            WidgetNoticeDialog$Companion widgetNoticeDialog$Companion2 = WidgetNoticeDialog.Companion;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog guildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog = (GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog) event;
            String string = getString(guildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog.getHeaderStringRes());
            String string2 = getString(guildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog.getBodyStringRes());
            m.checkNotNullExpressionValue(string2, "getString(event.bodyStringRes)");
            WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion2, parentFragmentManager2, string, string2, getString(2131887103), getString(2131887437), d0.t.g0.mapOf(o.to(2131364555, new WidgetGuildBoost$handleEvent$1(this))), null, null, null, null, null, null, 0, null, 16320, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.pagerAdapter = new WidgetGuildBoost$PerksPagerAdapter(getGuildId());
        getBinding().k.setWrapHeight(true);
        SimplePager simplePager = getBinding().k;
        m.checkNotNullExpressionValue(simplePager, "binding.boostStatusViewpager");
        WidgetGuildBoost$PerksPagerAdapter widgetGuildBoost$PerksPagerAdapter = this.pagerAdapter;
        if (widgetGuildBoost$PerksPagerAdapter == null) {
            m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        simplePager.setAdapter(widgetGuildBoost$PerksPagerAdapter);
        getBinding().k.addOnPageChangeListener(new WidgetGuildBoost$onViewBound$1(this));
        AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_premium_guild, WidgetGuildBoost$onViewBound$2.INSTANCE, null, 4, null);
        LinkifiedTextView linkifiedTextView = getBinding().c;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.boostStatusLearnMore");
        b.m(linkifiedTextView, 2131894032, new Object[]{"learnMode"}, WidgetGuildBoost$onViewBound$3.INSTANCE);
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(requireContext(), R$plurals.premium_guild_perks_modal_protip_mobile_numFreeGuildSubscriptions, 2, 2);
        LinkifiedTextView linkifiedTextView2 = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.boostStatusProtip");
        b.m(linkifiedTextView2, 2131894043, new Object[]{i18nPluralString}, new WidgetGuildBoost$onViewBound$4(this));
        ImageView imageView = getBinding().l.c;
        m.checkNotNullExpressionValue(imageView, "binding.progress.boostBarTier0Iv");
        ImageView imageView2 = getBinding().l.d;
        m.checkNotNullExpressionValue(imageView2, "binding.progress.boostBarTier1Iv");
        ImageView imageView3 = getBinding().l.f;
        m.checkNotNullExpressionValue(imageView3, "binding.progress.boostBarTier2Iv");
        ImageView imageView4 = getBinding().l.h;
        m.checkNotNullExpressionValue(imageView4, "binding.progress.boostBarTier3Iv");
        this.levelBackgrounds = n.listOf((Object[]) new ImageView[]{imageView, imageView2, imageView3, imageView4});
        this.levelText = n.listOf((Object[]) new TextView[]{null, getBinding().l.e, getBinding().l.g, getBinding().l.i});
        getBinding().i.setOnClickListener(new WidgetGuildBoost$onViewBound$5(this));
        getBinding().j.setOnClickListener(new WidgetGuildBoost$onViewBound$6(this));
        fetchData();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        AppActivity appActivity;
        super.onViewBoundOrOnResume();
        if ((getGuildId() == 0 || getGuildId() == -1) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        Observable<GuildBoostViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetGuildBoost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildBoost$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildBoost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildBoost$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
