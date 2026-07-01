package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup$OnCheckedChangeListener;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.f0;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitsBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.PaddedItemDecorator;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildRoleSubscriptionTierBenefits.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitsBinding;", 0)};
    public static final WidgetGuildRoleSubscriptionTierBenefits$Companion Companion = new WidgetGuildRoleSubscriptionTierBenefits$Companion(null);
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
    private final RadioGroup$OnCheckedChangeListener channelBenefitSettingsCheckedChangeListener;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: hideHeader$delegate, reason: from kotlin metadata */
    private final Lazy hideHeader;
    private final WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 itemClickListener;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildRoleSubscriptionTierBenefits() {
        super(R$layout.widget_guild_role_subscription_tier_benefits);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionTierBenefits$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionTierBenefits$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetGuildRoleSubscriptionTierBenefits$viewModel$2.INSTANCE));
        this.guildId = g.lazy(new WidgetGuildRoleSubscriptionTierBenefits$guildId$2(this));
        this.hideHeader = g.lazy(new WidgetGuildRoleSubscriptionTierBenefits$hideHeader$2(this));
        WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2 widgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2 = new WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2(this);
        g0 g0Var = new g0(this);
        this.benefitsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierBenefitsViewModel.class), new WidgetGuildRoleSubscriptionTierBenefits$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2));
        this.benefitListType = g.lazy(new WidgetGuildRoleSubscriptionTierBenefits$benefitListType$2(this));
        this.benefitLauncher = WidgetGuildRoleSubscriptionTierBenefit.Companion.registerForResult(this, new WidgetGuildRoleSubscriptionTierBenefits$benefitLauncher$1(this));
        this.itemClickListener = new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1(this);
        this.channelBenefitSettingsCheckedChangeListener = new WidgetGuildRoleSubscriptionTierBenefits$channelBenefitSettingsCheckedChangeListener$1(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits, GuildRoleSubscriptionTierBenefitsViewModel$ViewState guildRoleSubscriptionTierBenefitsViewModel$ViewState) {
        widgetGuildRoleSubscriptionTierBenefits.configureUI(guildRoleSubscriptionTierBenefitsViewModel$ViewState);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getBenefitLauncher$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.benefitLauncher;
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierBenefitListType access$getBenefitListType$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getBenefitListType();
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel access$getBenefitsViewModel$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getBenefitsViewModel();
    }

    public static final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefitsBinding access$getBinding$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getGuildId();
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getViewModel();
    }

    private final void configureUI(GuildRoleSubscriptionTierBenefitsViewModel$ViewState viewState) {
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter == null) {
            m.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        guildRoleSubscriptionBenefitAdapter.setItems(viewState.getItems());
        RadioGroup radioGroup = getBinding().f;
        m.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(viewState.getCanChangeChannelSettings() ? 0 : 8);
        if (viewState.getCanAccessAllChannels() == null) {
            return;
        }
        getBinding().f.setOnCheckedChangeListener(null);
        if (viewState.getCanAccessAllChannels().booleanValue()) {
            MaterialRadioButton materialRadioButton = getBinding().f2439b;
            m.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionTierAllChannels");
            materialRadioButton.setChecked(true);
        } else {
            MaterialRadioButton materialRadioButton2 = getBinding().g;
            m.checkNotNullExpressionValue(materialRadioButton2, "binding.guildRoleSubscriptionTierManualChannels");
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
        m.checkNotNullExpressionValue(recyclerView2, "binding.subscriptionTierBenefitsRecycler");
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter == null) {
            m.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        recyclerView.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView2, guildRoleSubscriptionBenefitAdapter, 0, false, 12, null));
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter2 = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        recyclerView.setAdapter(guildRoleSubscriptionBenefitAdapter2);
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter3 = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(guildRoleSubscriptionBenefitAdapter3);
        recyclerView.addItemDecoration(paddedItemDecorator);
        recyclerView.addItemDecoration(stickyHeaderItemDecoration);
    }

    private final void setupUIForChannelBenefits() {
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setText(getString(2131890442));
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setText(getString(2131890441));
        RadioGroup radioGroup = getBinding().f;
        m.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(0);
        getBinding().f.setOnCheckedChangeListener(this.channelBenefitSettingsCheckedChangeListener);
    }

    private final void setupUIForIntangibleBenefits() {
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setText(getString(2131890451));
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setText(getString(2131890450));
        RadioGroup radioGroup = getBinding().f;
        m.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpBenefitsRecycler();
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setVisibility(getHideHeader() ^ true ? 0 : 8);
        View view2 = getBinding().c;
        m.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionTierBenefitsDivider");
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefits.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionTierBenefits$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getBenefitsViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefits.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionTierBenefits$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
