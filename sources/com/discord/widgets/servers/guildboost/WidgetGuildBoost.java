package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerBoostStatusBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.guildboost.GuildBoostViewModel;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildBoost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerBoostStatusBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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
    private PerksPagerAdapter pagerAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private boolean wasPagerPageSet;

    /* JADX INFO: compiled from: WidgetGuildBoost.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildBoost.INTENT_EXTRA_GUILD_ID, guildId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            C0870j.m156d(context, WidgetGuildBoost.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildBoost.kt */
    public static final class PerksPagerAdapter extends PagerAdapter {
        private long guildId;
        private int premiumTier;
        private int subscriptionCount;

        public PerksPagerAdapter(long j) {
            this.guildId = j;
        }

        public final void configureViews(ViewPager viewPager) {
            C12238m.checkNotNullParameter(viewPager, "viewPager");
            int childCount = viewPager.getChildCount();
            if (childCount <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = viewPager.getChildAt(i);
                C12238m.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                Object tag = childAt.getTag();
                Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
                ((GuildBoostPerkView) childAt).configure(((Integer) tag).intValue(), this.premiumTier, this.guildId);
                if (i2 >= childCount) {
                    return;
                } else {
                    i = i2;
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object view) {
            C12238m.checkNotNullParameter(container, "container");
            C12238m.checkNotNullParameter(view, "view");
            container.removeView((View) view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 3;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final int getPremiumTier() {
            return this.premiumTier;
        }

        public final int getSubscriptionCount() {
            return this.subscriptionCount;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object any) {
            C12238m.checkNotNullParameter(view, "view");
            C12238m.checkNotNullParameter(any, "any");
            return C12238m.areEqual(view, any);
        }

        public final void setGuildId(long j) {
            this.guildId = j;
        }

        public final void setPremiumTier(int i) {
            this.premiumTier = i;
        }

        public final void setSubscriptionCount(int i) {
            this.subscriptionCount = i;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public View instantiateItem(ViewGroup container, int position) {
            C12238m.checkNotNullParameter(container, "container");
            int i = position + 1;
            Context context = container.getContext();
            C12238m.checkNotNullExpressionValue(context, "container.context");
            GuildBoostPerkView guildBoostPerkView = new GuildBoostPerkView(context, null, 0, 6, null);
            guildBoostPerkView.configure(i, this.premiumTier, this.guildId);
            guildBoostPerkView.setTag(Integer.valueOf(i));
            container.addView(guildBoostPerkView);
            return guildBoostPerkView;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$configureUI$2 */
    /* JADX INFO: compiled from: WidgetGuildBoost.kt */
    public static final class C95072 extends AbstractC12240o implements Function0<Unit> {
        public C95072() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$handleEvent$1 */
    /* JADX INFO: compiled from: WidgetGuildBoost.kt */
    public static final class C95081 extends AbstractC12240o implements Function1<View, Unit> {
        public C95081() {
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
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetGuildBoost.kt */
    public static final class C95113 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public static final C95113 INSTANCE = new C95113();

        /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetGuildBoost.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "view");
                WidgetSettingsGuildBoost.Companion companion = WidgetSettingsGuildBoost.INSTANCE;
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "view.context");
                companion.launch(context);
            }
        }

        public C95113() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("learnMore", AnonymousClass1.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetGuildBoost.kt */
    public static final class C95124 extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetGuildBoost.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "view");
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "view.context");
                WidgetSettingsPremium.Companion.launch$default(companion, context, null, null, 6, null);
            }
        }

        public C95124() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getColor(WidgetGuildBoost.this.requireContext(), C5419R.color.status_green_600));
            renderContext.m8423b("onLearnMore", AnonymousClass1.INSTANCE);
            renderContext.m8422a("protipHook", AnonymousClass2.INSTANCE);
        }

        /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetGuildBoost.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Hook, Unit> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            public AnonymousClass2() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new StyleSpan(1));
                hook.styles.add(new ForegroundColorSpan(-65536));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildBoost.kt */
    public static final /* synthetic */ class C95151 extends C12236k implements Function1<GuildBoostViewModel.ViewState, Unit> {
        public C95151(WidgetGuildBoost widgetGuildBoost) {
            super(1, widgetGuildBoost, WidgetGuildBoost.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildBoost) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetGuildBoost.kt */
    public static final /* synthetic */ class C95162 extends C12236k implements Function1<GuildBoostViewModel.Event, Unit> {
        public C95162(WidgetGuildBoost widgetGuildBoost) {
            super(1, widgetGuildBoost, WidgetGuildBoost.class, "handleEvent", "handleEvent(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetGuildBoost) this.receiver).handleEvent(event);
        }
    }

    public WidgetGuildBoost() {
        super(C5419R.layout.widget_server_boost_status);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildBoost$binding$2.INSTANCE, null, 2, null);
        WidgetGuildBoost$viewModel$2 widgetGuildBoost$viewModel$2 = new WidgetGuildBoost$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildBoostViewModel.class), new WidgetGuildBoost$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGuildBoost$viewModel$2));
        this.choosePlanLauncher = WidgetChoosePlan.INSTANCE.registerForResult(this, new WidgetGuildBoost$choosePlanLauncher$1(this));
        this.guildId = C12083g.lazy(new WidgetGuildBoost$guildId$2(this));
    }

    private final void configureLevelBubbles(int currentSelected) {
        int i = 0;
        while (i <= 3) {
            List<? extends ImageView> list = this.levelBackgrounds;
            if (list == null) {
                C12238m.throwUninitializedPropertyAccessException("levelBackgrounds");
            }
            ImageView imageView = list.get(i);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = DimenUtils.dpToPixels(currentSelected == i ? 32 : 20);
            layoutParams.width = DimenUtils.dpToPixels(currentSelected != i ? 20 : 32);
            imageView.setLayoutParams(layoutParams);
            List<? extends TextView> list2 = this.levelText;
            if (list2 == null) {
                C12238m.throwUninitializedPropertyAccessException("levelText");
            }
            TextView textView = list2.get(i);
            if (textView != null) {
                textView.setTextColor(currentSelected == i ? ColorCompat.getThemedColor(textView, C5419R.attr.primary_000) : ColorCompat.getThemedColor(textView, C5419R.attr.primary_400));
            }
            i++;
        }
    }

    private final void configureProgressBar(long guildId, int premiumTier, int subscriptionCount) {
        int i;
        ProgressBar progressBar = getBinding().f17478l.f1340b;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.progress.boostBarProgressBar");
        progressBar.setProgress(GuildBoostUtils.calculateTotalProgress$default(GuildBoostUtils.INSTANCE, guildId, premiumTier, subscriptionCount, null, null, 24, null));
        ProgressBar progressBar2 = getBinding().f17478l.f1340b;
        C12238m.checkNotNullExpressionValue(progressBar2, "binding.progress.boostBarProgressBar");
        if (premiumTier == 0) {
            i = C5419R.string.premium_guild_header_badge_no_tier;
        } else if (premiumTier == 1) {
            i = C5419R.string.premium_guild_tier_1;
        } else if (premiumTier != 2) {
            i = premiumTier != 3 ? 0 : C5419R.string.premium_guild_tier_3;
        } else {
            i = C5419R.string.premium_guild_tier_2;
        }
        progressBar2.setContentDescription(getString(i));
        ImageView imageView = getBinding().f17478l.f1341c;
        C12238m.checkNotNullExpressionValue(imageView, "binding.progress.boostBarTier0Iv");
        imageView.setEnabled(subscriptionCount > 0);
        ImageView imageView2 = getBinding().f17478l.f1342d;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.progress.boostBarTier1Iv");
        imageView2.setEnabled(premiumTier >= 1);
        ImageView imageView3 = getBinding().f17478l.f1344f;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.progress.boostBarTier2Iv");
        imageView3.setEnabled(premiumTier >= 2);
        ImageView imageView4 = getBinding().f17478l.f1346h;
        C12238m.checkNotNullExpressionValue(imageView4, "binding.progress.boostBarTier3Iv");
        imageView4.setEnabled(premiumTier >= 3);
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(C5419R.string.premium_guild_perks_modal_header);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(GuildBoostViewModel.ViewState viewState) {
        if (viewState instanceof GuildBoostViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f17468b;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.boostStatusFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof GuildBoostViewModel.ViewState.Failure) {
            AppViewFlipper appViewFlipper2 = getBinding().f17468b;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.boostStatusFlipper");
            appViewFlipper2.setDisplayedChild(1);
            getBinding().f17474h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guildboost.WidgetGuildBoost.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildBoost.this.getViewModel().retryClicked();
                }
            });
            return;
        }
        if (viewState instanceof GuildBoostViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper3 = getBinding().f17468b;
            C12238m.checkNotNullExpressionValue(appViewFlipper3, "binding.boostStatusFlipper");
            appViewFlipper3.setDisplayedChild(2);
        }
        GuildBoostViewModel.ViewState.Loaded loaded = (GuildBoostViewModel.ViewState.Loaded) viewState;
        int premiumTier = loaded.getGuild().getPremiumTier();
        int premiumSubscriptionCount = loaded.getGuild().getPremiumSubscriptionCount();
        configureToolbar(loaded.getGuild().getName());
        configureProgressBar(loaded.getGuild().getId(), premiumTier, premiumSubscriptionCount);
        configureViewpager(premiumTier, premiumSubscriptionCount);
        getBinding().f17471e.m8595a(loaded.getMeUser().getPremiumTier(), new C95072());
        getBinding().f17472f.m8597a(loaded.getMeUser().getPremiumTier(), false);
        TextView textView = getBinding().f17470d;
        C12238m.checkNotNullExpressionValue(textView, "binding.boostStatusNumBoosts");
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        textView.setText(StringResourceUtilsKt.getQuantityString(resources, requireContext(), C5419R.plurals.premium_guild_perks_modal_header_subscription_count_subscriptions, premiumSubscriptionCount, Integer.valueOf(premiumSubscriptionCount)));
    }

    private final void configureViewpager(int premiumTier, int subscriptionCount) {
        PerksPagerAdapter perksPagerAdapter = this.pagerAdapter;
        if (perksPagerAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        perksPagerAdapter.setPremiumTier(premiumTier);
        PerksPagerAdapter perksPagerAdapter2 = this.pagerAdapter;
        if (perksPagerAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        perksPagerAdapter2.setSubscriptionCount(subscriptionCount);
        PerksPagerAdapter perksPagerAdapter3 = this.pagerAdapter;
        if (perksPagerAdapter3 == null) {
            C12238m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        SimplePager simplePager = getBinding().f17477k;
        C12238m.checkNotNullExpressionValue(simplePager, "binding.boostStatusViewpager");
        perksPagerAdapter3.configureViews(simplePager);
        if (this.wasPagerPageSet) {
            return;
        }
        getBinding().f17477k.setCurrentItem(Math.max(0, premiumTier - 1), false);
        configureLevelBubbles(Math.max(1, premiumTier));
        this.wasPagerPageSet = true;
    }

    public static final void create(Context context, long j) {
        INSTANCE.create(context, j);
    }

    private final void fetchData() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getGuildBoosts().fetchUserGuildBoostState();
        companion.getSubscriptions().fetchSubscriptions();
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

    private final void handleEvent(GuildBoostViewModel.Event event) {
        if (event instanceof GuildBoostViewModel.Event.LaunchSubscriptionConfirmation) {
            AnalyticsTracker.INSTANCE.openModal(Traits.Location.Section.PREMIUM_GUILD_SUBSCRIPTION_CONFIRMATION, new Traits.Location(Traits.Location.Page.BOOST_MARKETING, Traits.Location.Section.HEADER, Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null));
            GuildBoostViewModel.Event.LaunchSubscriptionConfirmation launchSubscriptionConfirmation = (GuildBoostViewModel.Event.LaunchSubscriptionConfirmation) event;
            WidgetGuildBoostConfirmation.INSTANCE.create(requireContext(), launchSubscriptionConfirmation.getGuildId(), launchSubscriptionConfirmation.getSlotId());
            return;
        }
        if (event instanceof GuildBoostViewModel.Event.LaunchPurchaseSubscription) {
            GuildBoostViewModel.Event.LaunchPurchaseSubscription launchPurchaseSubscription = (GuildBoostViewModel.Event.LaunchPurchaseSubscription) event;
            WidgetChoosePlan.INSTANCE.launch(requireContext(), (34 & 2) != 0 ? null : this.choosePlanLauncher, WidgetChoosePlan.ViewType.BUY_PREMIUM_GUILD, (34 & 8) != 0 ? null : launchPurchaseSubscription.getOldSkuName(), new Traits.Location(Traits.Location.Page.BOOST_MARKETING, launchPurchaseSubscription.getSection(), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), (34 & 32) != 0 ? null : null);
            return;
        }
        if (event instanceof GuildBoostViewModel.Event.ShowDesktopAlertDialog) {
            AnalyticsTracker.INSTANCE.openModal(Traits.Location.Section.ANDROID_CANNOT_MANAGE_SUBSCRIPTION, new Traits.Location(Traits.Location.Page.BOOST_MARKETING, Traits.Location.Section.HEADER, Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null));
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, getString(C5419R.string.premium_guild_subscription_out_of_slots_title), C1107b.m213e(this, C5419R.string.premium_guild_subscription_out_of_slots_purchase_on_desktop, new Object[]{C0862f.f507a.m149a(360055386693L, null)}, (4 & 4) != 0 ? C1107b.a.f1490j : null), getString(C5419R.string.premium_guild_subscription_header_subscribe_tooltip_close), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            return;
        }
        if (event instanceof GuildBoostViewModel.Event.UnacknowledgedPurchase) {
            C0876m.m171i(this, C5419R.string.billing_error_purchase, 0, 4);
            GooglePlayBillingManager.INSTANCE.queryPurchases();
        } else if (event instanceof GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog) {
            WidgetNoticeDialog.Companion companion2 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog showBlockedPlanSwitchAlertDialog = (GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog) event;
            String string = getString(showBlockedPlanSwitchAlertDialog.getHeaderStringRes());
            String string2 = getString(showBlockedPlanSwitchAlertDialog.getBodyStringRes());
            C12238m.checkNotNullExpressionValue(string2, "getString(event.bodyStringRes)");
            WidgetNoticeDialog.Companion.show$default(companion2, parentFragmentManager2, string, string2, getString(C5419R.string.billing_manage_subscription), getString(C5419R.string.cancel), C12134g0.mapOf(C12116o.m10073to(Integer.valueOf(C5419R.id.notice_ok), new C95081())), null, null, null, null, null, null, 0, null, 16320, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.pagerAdapter = new PerksPagerAdapter(getGuildId());
        getBinding().f17477k.setWrapHeight(true);
        SimplePager simplePager = getBinding().f17477k;
        C12238m.checkNotNullExpressionValue(simplePager, "binding.boostStatusViewpager");
        PerksPagerAdapter perksPagerAdapter = this.pagerAdapter;
        if (perksPagerAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        simplePager.setAdapter(perksPagerAdapter);
        getBinding().f17477k.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.discord.widgets.servers.guildboost.WidgetGuildBoost.onViewBound.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                WidgetGuildBoost.this.configureLevelBubbles(position + 1);
            }
        });
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_premium_guild, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.servers.guildboost.WidgetGuildBoost.onViewBound.2
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_premium_guild) {
                    return;
                }
                WidgetSettingsGuildBoost.Companion companion = WidgetSettingsGuildBoost.INSTANCE;
                C12238m.checkNotNullExpressionValue(context, "context");
                companion.launch(context);
            }
        }, null, 4, null);
        LinkifiedTextView linkifiedTextView = getBinding().f17469c;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.boostStatusLearnMore");
        C1107b.m221m(linkifiedTextView, C5419R.string.premium_guild_perks_modal_blurb_mobile_learn_more, new Object[]{"learnMode"}, C95113.INSTANCE);
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_perks_modal_protip_mobile_numFreeGuildSubscriptions, 2, 2);
        LinkifiedTextView linkifiedTextView2 = getBinding().f17473g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.boostStatusProtip");
        C1107b.m221m(linkifiedTextView2, C5419R.string.premium_guild_perks_modal_protip, new Object[]{i18nPluralString}, new C95124());
        ImageView imageView = getBinding().f17478l.f1341c;
        C12238m.checkNotNullExpressionValue(imageView, "binding.progress.boostBarTier0Iv");
        ImageView imageView2 = getBinding().f17478l.f1342d;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.progress.boostBarTier1Iv");
        ImageView imageView3 = getBinding().f17478l.f1344f;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.progress.boostBarTier2Iv");
        ImageView imageView4 = getBinding().f17478l.f1346h;
        C12238m.checkNotNullExpressionValue(imageView4, "binding.progress.boostBarTier3Iv");
        this.levelBackgrounds = C12147n.listOf((Object[]) new ImageView[]{imageView, imageView2, imageView3, imageView4});
        this.levelText = C12147n.listOf((Object[]) new TextView[]{null, getBinding().f17478l.f1343e, getBinding().f17478l.f1345g, getBinding().f17478l.f1347i});
        getBinding().f17475i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guildboost.WidgetGuildBoost.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildBoost.this.getViewModel().subscribeClicked(Traits.Location.Section.HEADER);
            }
        });
        getBinding().f17476j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guildboost.WidgetGuildBoost.onViewBound.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildBoost.this.getViewModel().subscribeClicked(Traits.Location.Section.FOOTER);
            }
        });
        fetchData();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        AppActivity appActivity;
        super.onViewBoundOrOnResume();
        if ((getGuildId() == 0 || getGuildId() == -1) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        Observable<GuildBoostViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetGuildBoost.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95151(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildBoost.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95162(this));
    }
}
