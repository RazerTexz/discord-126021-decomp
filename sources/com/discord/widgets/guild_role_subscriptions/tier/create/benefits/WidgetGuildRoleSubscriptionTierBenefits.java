package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Intent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitsBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.PaddedItemDecorator;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionTierBenefits.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_BENEFITS_HIDE_HEADER = "INTENT_EXTRA_BENEFITS_HIDE_HEADER";
    public static final String INTENT_EXTRA_BENEFIT_LIST_TYPE = "INTENT_EXTRA_BENEFIT_LIST_TYPE";
    private final ActivityResultLauncher<Intent> benefitLauncher;

    /* JADX INFO: renamed from: benefitListType$delegate, reason: from kotlin metadata */
    private final Lazy benefitListType;
    private GuildRoleSubscriptionBenefitAdapter benefitsAdapter;

    /* JADX INFO: renamed from: benefitsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy benefitsViewModel;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final RadioGroup.OnCheckedChangeListener channelBenefitSettingsCheckedChangeListener;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: hideHeader$delegate, reason: from kotlin metadata */
    private final Lazy hideHeader;
    private final WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 itemClickListener;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits newInstance$default(Companion companion, long j, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            return companion.newInstance(j, guildRoleSubscriptionTierBenefitListType, z2);
        }

        public final WidgetGuildRoleSubscriptionTierBenefits newInstance(long guildId, GuildRoleSubscriptionTierBenefitListType benefitListType, boolean hideHeader) {
            Intrinsics3.checkNotNullParameter(benefitListType, "benefitListType");
            WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits = new WidgetGuildRoleSubscriptionTierBenefits();
            widgetGuildRoleSubscriptionTierBenefits.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId)), Tuples.to("INTENT_EXTRA_BENEFITS_HIDE_HEADER", Boolean.valueOf(hideHeader)), Tuples.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, benefitListType)));
            return widgetGuildRoleSubscriptionTierBenefits;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildRoleSubscriptionTierBenefitListType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildRoleSubscriptionTierBenefitListType.CHANNEL.ordinal()] = 1;
            iArr[GuildRoleSubscriptionTierBenefitListType.INTANGIBLE.ordinal()] = 2;
            iArr[GuildRoleSubscriptionTierBenefitListType.ALL.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierBenefits.this.getBenefitsViewModel().updateBenefits(viewState.getGuildRoleSubscriptionTier(), viewState.isFullServerGating());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitsViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierBenefits.this.configureUI(viewState);
        }
    }

    public WidgetGuildRoleSubscriptionTierBenefits() {
        super(R.layout.widget_guild_role_subscription_tier_benefits);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierBenefits$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionTierBenefits$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionTierBenefits$viewModel$2.INSTANCE));
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefits$guildId$2(this));
        this.hideHeader = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefits$hideHeader$2(this));
        WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2 widgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2 = new WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.benefitsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierBenefitsViewModel.class), new WidgetGuildRoleSubscriptionTierBenefits$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2));
        this.benefitListType = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefits$benefitListType$2(this));
        this.benefitLauncher = WidgetGuildRoleSubscriptionTierBenefit.INSTANCE.registerForResult(this, new WidgetGuildRoleSubscriptionTierBenefits$benefitLauncher$1(this));
        this.itemClickListener = new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1(this);
        this.channelBenefitSettingsCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$channelBenefitSettingsCheckedChangeListener$1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                MaterialRadioButton materialRadioButton = this.this$0.getBinding().f2439b;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionTierAllChannels");
                if (i == materialRadioButton.getId()) {
                    this.this$0.getViewModel().setCanAccessAllChannels(true);
                    return;
                }
                MaterialRadioButton materialRadioButton2 = this.this$0.getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.guildRoleSubscriptionTierManualChannels");
                if (i == materialRadioButton2.getId()) {
                    this.this$0.getViewModel().setCanAccessAllChannels(false);
                }
            }
        };
    }

    private final void configureUI(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        guildRoleSubscriptionBenefitAdapter.setItems(viewState.getItems());
        RadioGroup radioGroup = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(viewState.getCanChangeChannelSettings() ? 0 : 8);
        if (viewState.getCanAccessAllChannels() == null) {
            return;
        }
        getBinding().f.setOnCheckedChangeListener(null);
        if (viewState.getCanAccessAllChannels().booleanValue()) {
            MaterialRadioButton materialRadioButton = getBinding().f2439b;
            Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionTierAllChannels");
            materialRadioButton.setChecked(true);
        } else {
            MaterialRadioButton materialRadioButton2 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.guildRoleSubscriptionTierManualChannels");
            materialRadioButton2.setChecked(true);
        }
        getBinding().f.setOnCheckedChangeListener(this.channelBenefitSettingsCheckedChangeListener);
    }

    private final GuildRoleSubscriptionTierBenefitListType getBenefitListType() {
        return (GuildRoleSubscriptionTierBenefitListType) this.benefitListType.getValue();
    }

    private final GuildRoleSubscriptionTierBenefitsViewModel getBenefitsViewModel() {
        return (GuildRoleSubscriptionTierBenefitsViewModel) this.benefitsViewModel.getValue();
    }

    private final WidgetGuildRoleSubscriptionTierBenefitsBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierBenefitsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final boolean getHideHeader() {
        return ((Boolean) this.hideHeader.getValue()).booleanValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final void setUpBenefitsRecycler() {
        this.benefitsAdapter = new GuildRoleSubscriptionBenefitAdapter(this.itemClickListener, this, null, 4, null);
        PaddedItemDecorator paddedItemDecorator = new PaddedItemDecorator(1, 0, DimenUtils.dpToPixels(8), true);
        RecyclerView recyclerView = getBinding().h;
        RecyclerView recyclerView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.subscriptionTierBenefitsRecycler");
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        recyclerView.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView2, guildRoleSubscriptionBenefitAdapter, 0, false, 12, null));
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter2 = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        recyclerView.setAdapter(guildRoleSubscriptionBenefitAdapter2);
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter3 = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(guildRoleSubscriptionBenefitAdapter3);
        recyclerView.addItemDecoration(paddedItemDecorator);
        recyclerView.addItemDecoration(stickyHeaderItemDecoration);
    }

    private final void setupUIForChannelBenefits() {
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setText(getString(R.string.guild_role_subscription_create_tier_channel_benefits_title));
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setText(getString(R.string.guild_role_subscription_create_tier_channel_benefits_description));
        RadioGroup radioGroup = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(0);
        getBinding().f.setOnCheckedChangeListener(this.channelBenefitSettingsCheckedChangeListener);
    }

    private final void setupUIForIntangibleBenefits() {
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setText(getString(R.string.guild_role_subscription_create_tier_intangible_benefits_title));
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setText(getString(R.string.guild_role_subscription_create_tier_intangible_benefits_description));
        RadioGroup radioGroup = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpBenefitsRecycler();
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setVisibility(getHideHeader() ^ true ? 0 : 8);
        View view2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionTierBenefitsDivider");
        view2.setVisibility(getHideHeader() ^ true ? 0 : 8);
        int iOrdinal = getBenefitListType().ordinal();
        if (iOrdinal == 0) {
            setupUIForChannelBenefits();
            return;
        }
        if (iOrdinal == 1) {
            setupUIForIntangibleBenefits();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            setupUIForChannelBenefits();
            setupUIForIntangibleBenefits();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionTierBenefits.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getBenefitsViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionTierBenefits.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
