package com.discord.widgets.settings.premium;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import b.a.a.a0.a$a;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.android.billingclient.api.SkuDetails;
import com.discord.R$layout;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsGiftingBinding;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.billing.GooglePlayInAppSkuKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.recycler.SpaceBetweenItemDecoration;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.premium.GiftSelectView;
import com.google.android.material.textfield.TextInputLayout;
import d0.o;
import d0.t.h0;
import d0.t.n;
import d0.t.p;
import d0.t.u;
import d0.t.z;
import d0.z.d.a0;
import d0.z.d.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsGifting.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsGiftingBinding;", 0)};
    public static final WidgetSettingsGifting$Companion Companion = new WidgetSettingsGifting$Companion(null);
    public static final int VIEW_INDEX_FAILURE = 1;
    public static final int VIEW_INDEX_LOADED = 2;
    public static final int VIEW_INDEX_LOADING = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Map<GiftSelectView, GooglePlayInAppSku> chooseGiftViews;
    private WidgetSettingsGiftingAdapter giftingAdapter;
    private WidgetSettingsGiftingOutboundPromosAdapter promosAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetSettingsGifting() {
        super(R$layout.widget_settings_gifting);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsGifting$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsGifting$viewModel$2 widgetSettingsGifting$viewModel$2 = WidgetSettingsGifting$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(SettingsGiftingViewModel.class), new WidgetSettingsGifting$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetSettingsGifting$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsGifting widgetSettingsGifting, SettingsGiftingViewModel$ViewState settingsGiftingViewModel$ViewState) {
        widgetSettingsGifting.configureUI(settingsGiftingViewModel$ViewState);
    }

    public static final /* synthetic */ void access$enableGiftingButtons(WidgetSettingsGifting widgetSettingsGifting) {
        widgetSettingsGifting.enableGiftingButtons();
    }

    public static final /* synthetic */ WidgetSettingsGiftingBinding access$getBinding$p(WidgetSettingsGifting widgetSettingsGifting) {
        return widgetSettingsGifting.getBinding();
    }

    public static final /* synthetic */ SettingsGiftingViewModel access$getViewModel$p(WidgetSettingsGifting widgetSettingsGifting) {
        return widgetSettingsGifting.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetSettingsGifting widgetSettingsGifting, SettingsGiftingViewModel$Event settingsGiftingViewModel$Event) {
        widgetSettingsGifting.handleEvent(settingsGiftingViewModel$Event);
    }

    public static final /* synthetic */ void access$handleGiftPurchaseEvent(WidgetSettingsGifting widgetSettingsGifting, SettingsGiftingViewModel$GiftPurchaseEvent settingsGiftingViewModel$GiftPurchaseEvent) {
        widgetSettingsGifting.handleGiftPurchaseEvent(settingsGiftingViewModel$GiftPurchaseEvent);
    }

    private final void addGiftItems(List<ModelEntitlement> entries, SettingsGiftingViewModel$ViewState$Loaded viewState, List<WidgetSettingsGiftingAdapter$GiftItem> listItems) {
        if (entries.isEmpty()) {
            return;
        }
        ModelEntitlement modelEntitlement = (ModelEntitlement) u.first((List) entries);
        Set<Long> expandedSkuOrPlanIds = viewState.getExpandedSkuOrPlanIds();
        SubscriptionPlan subscriptionPlan = modelEntitlement.getSubscriptionPlan();
        boolean zContains = expandedSkuOrPlanIds.contains(Long.valueOf(subscriptionPlan != null ? subscriptionPlan.getId() : modelEntitlement.getSku().getId()));
        ModelSku sku = modelEntitlement.getSku();
        SubscriptionPlan subscriptionPlan2 = modelEntitlement.getSubscriptionPlan();
        listItems.add(new WidgetSettingsGiftingAdapter$GiftItem(1, null, null, Boolean.valueOf(zContains), sku, Integer.valueOf(entries.size()), subscriptionPlan2 != null ? Long.valueOf(subscriptionPlan2.getId()) : null, null, null, 390, null));
        Iterator itWithIndex = p.withIndex(entries.iterator());
        boolean z2 = false;
        while (itWithIndex.hasNext()) {
            z zVar = (z) itWithIndex.next();
            int iComponent1 = zVar.component1();
            ModelEntitlement modelEntitlement2 = (ModelEntitlement) zVar.component2();
            Map<Long, List<ModelGift>> myPurchasedGifts = viewState.getMyPurchasedGifts();
            SubscriptionPlan subscriptionPlan3 = modelEntitlement2.getSubscriptionPlan();
            List<ModelGift> list = myPurchasedGifts.get(Long.valueOf(subscriptionPlan3 != null ? subscriptionPlan3.getId() : modelEntitlement2.getSkuId()));
            ModelGift modelGift = (iComponent1 < (list != null ? list.size() : -1) && list != null) ? list.get(iComponent1) : null;
            if (modelGift == null) {
                if (!z2) {
                    z2 = true;
                }
            }
            SubscriptionPlan subscriptionPlan4 = modelEntitlement2.getSubscriptionPlan();
            listItems.add(new WidgetSettingsGiftingAdapter$GiftItem(2, modelGift, modelEntitlement2, Boolean.valueOf(zContains), null, null, subscriptionPlan4 != null ? Long.valueOf(subscriptionPlan4.getId()) : null, Boolean.valueOf(iComponent1 == entries.size() - 1), Boolean.valueOf(modelGift != null && m.areEqual(modelGift.getCode(), viewState.getLastCopiedCode())), 48, null));
        }
    }

    private final void configureUI(SettingsGiftingViewModel$ViewState viewState) {
        if (viewState instanceof SettingsGiftingViewModel$ViewState$Loading) {
            AppViewFlipper appViewFlipper = getBinding().i;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsGiftingFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof SettingsGiftingViewModel$ViewState$Failure) {
            AppViewFlipper appViewFlipper2 = getBinding().i;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.settingsGiftingFlipper");
            appViewFlipper2.setDisplayedChild(1);
            return;
        }
        if (viewState instanceof SettingsGiftingViewModel$ViewState$Loaded) {
            AppViewFlipper appViewFlipper3 = getBinding().i;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.settingsGiftingFlipper");
            appViewFlipper3.setDisplayedChild(2);
        }
        SettingsGiftingViewModel$ViewState$Loaded settingsGiftingViewModel$ViewState$Loaded = (SettingsGiftingViewModel$ViewState$Loaded) viewState;
        boolean z2 = settingsGiftingViewModel$ViewState$Loaded.getResolvingGiftState() instanceof SettingsGiftingViewModel$ResolvingGiftState$Resolving;
        CharSequence charSequenceK = settingsGiftingViewModel$ViewState$Loaded.getResolvingGiftState() instanceof SettingsGiftingViewModel$ResolvingGiftState$Error ? b.k(this, 2131886536, new Object[0], null, 4) : null;
        ProgressBar progressBar = getBinding().j;
        m.checkNotNullExpressionValue(progressBar, "binding.settingsGiftingGiftCodeInputProgress");
        progressBar.setVisibility(z2 ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().k;
        m.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
        ViewExtensions.setEnabledAlpha$default(textInputLayout, !z2, 0.0f, 2, null);
        TextInputLayout textInputLayout2 = getBinding().k;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.settingsGiftingGiftCodeInputWrap");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.setInputType(z2 ? 0 : 524288);
        }
        TextInputLayout textInputLayout3 = getBinding().k;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.settingsGiftingGiftCodeInputWrap");
        textInputLayout3.setError(charSequenceK);
        boolean z3 = !settingsGiftingViewModel$ViewState$Loaded.getOutboundPromos().isEmpty();
        TextView textView = getBinding().r;
        m.checkNotNullExpressionValue(textView, "binding.settingsGiftingYourGiftsHeader");
        textView.setVisibility(z3 ? 0 : 8);
        RecyclerView recyclerView = getBinding().f2621s;
        m.checkNotNullExpressionValue(recyclerView, "binding.settingsGiftingYourGiftsRecycler");
        recyclerView.setVisibility(z3 ? 0 : 8);
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter == null) {
            m.throwUninitializedPropertyAccessException("promosAdapter");
        }
        widgetSettingsGiftingOutboundPromosAdapter.submitList(settingsGiftingViewModel$ViewState$Loaded.getOutboundPromos());
        WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter = this.giftingAdapter;
        if (widgetSettingsGiftingAdapter == null) {
            m.throwUninitializedPropertyAccessException("giftingAdapter");
        }
        widgetSettingsGiftingAdapter.configure(generateListItems(settingsGiftingViewModel$ViewState$Loaded), new WidgetSettingsGifting$configureUI$1(this), new WidgetSettingsGifting$configureUI$2(this), WidgetSettingsGifting$configureUI$3.INSTANCE, WidgetSettingsGifting$configureUI$4.INSTANCE);
    }

    private final void enableGiftingButtons() {
        Map<GiftSelectView, GooglePlayInAppSku> map = this.chooseGiftViews;
        if (map == null) {
            m.throwUninitializedPropertyAccessException("chooseGiftViews");
        }
        for (GiftSelectView giftSelectView : map.keySet()) {
            giftSelectView.binding.c.setOnClickListener(new b.a.y.m0.a(giftSelectView));
        }
    }

    private final List<WidgetSettingsGiftingAdapter$GiftItem> generateListItems(SettingsGiftingViewModel$ViewState$Loaded viewState) {
        ArrayList arrayList = new ArrayList();
        if (viewState.getMyEntitlements().isEmpty()) {
            arrayList.add(new WidgetSettingsGiftingAdapter$GiftItem(0, null, null, null, null, null, null, null, null, 510, null));
        } else {
            for (Map$Entry<Long, List<ModelEntitlement>> map$Entry : viewState.getMyEntitlements().entrySet()) {
                map$Entry.getKey().longValue();
                List<ModelEntitlement> value = map$Entry.getValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : value) {
                    SubscriptionPlan subscriptionPlan = ((ModelEntitlement) obj).getSubscriptionPlan();
                    Long lValueOf = subscriptionPlan != null ? Long.valueOf(subscriptionPlan.getId()) : null;
                    Object arrayList2 = linkedHashMap.get(lValueOf);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        linkedHashMap.put(lValueOf, arrayList2);
                    }
                    ((List) arrayList2).add(obj);
                }
                for (Map$Entry map$Entry2 : linkedHashMap.entrySet()) {
                    addGiftItems((List) map$Entry2.getValue(), viewState, arrayList);
                }
            }
        }
        return arrayList;
    }

    private final WidgetSettingsGiftingBinding getBinding() {
        return (WidgetSettingsGiftingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SettingsGiftingViewModel getViewModel() {
        return (SettingsGiftingViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(SettingsGiftingViewModel$Event event) {
        Unit unit;
        if (event instanceof SettingsGiftingViewModel$Event$ShowPromoBottomSheet) {
            WidgetOutboundPromoTerms$Companion widgetOutboundPromoTerms$Companion = WidgetOutboundPromoTerms.Companion;
            String content = ((SettingsGiftingViewModel$Event$ShowPromoBottomSheet) event).getContent();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetOutboundPromoTerms$Companion.show(content, parentFragmentManager);
            unit = Unit.a;
        } else {
            if (!(event instanceof SettingsGiftingViewModel$Event$ShowPromoDialog)) {
                throw new NoWhenBranchMatchedException();
            }
            WidgetClaimOutboundPromo.Companion.showAndRegisterForClaimResult(((SettingsGiftingViewModel$Event$ShowPromoDialog) event).getClaimStatus(), this, new WidgetSettingsGifting$handleEvent$1(this));
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final void handleGiftPurchaseEvent(SettingsGiftingViewModel$GiftPurchaseEvent event) {
        enableGiftingButtons();
        if (event instanceof SettingsGiftingViewModel$GiftPurchaseEvent$StartGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f2620b, true, false, 2, null);
            return;
        }
        if (event instanceof SettingsGiftingViewModel$GiftPurchaseEvent$NotInProgress) {
            DimmerView.setDimmed$default(getBinding().f2620b, false, false, 2, null);
            return;
        }
        if (event instanceof SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f2620b, false, false, 2, null);
            b.a.d.m.i(this, ((SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase) event).getMessage(), 0, 4);
            return;
        }
        if (event instanceof SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f2620b, false, false, 2, null);
            a$a a_a = b.a.a.a0.a.k;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetSettingsGifting$handleGiftPurchaseEvent$1 widgetSettingsGifting$handleGiftPurchaseEvent$1 = new WidgetSettingsGifting$handleGiftPurchaseEvent$1(this);
            SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase settingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase = (SettingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase) event;
            String skuName = settingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase.getSkuName();
            String newGiftCode = settingsGiftingViewModel$GiftPurchaseEvent$CompleteGiftPurchase.getNewGiftCode();
            Objects.requireNonNull(a_a);
            m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            m.checkNotNullParameter(widgetSettingsGifting$handleGiftPurchaseEvent$1, "onDismiss");
            m.checkNotNullParameter(skuName, "skuName");
            m.checkNotNullParameter(newGiftCode, "giftCode");
            b.a.a.a0.a aVar = new b.a.a.a0.a();
            aVar.onDismiss = widgetSettingsGifting$handleGiftPurchaseEvent$1;
            Bundle bundle = new Bundle();
            bundle.putString("ARG_SKU_NAME", skuName);
            bundle.putString("ARG_GIFT_CODE", newGiftCode);
            aVar.setArguments(bundle);
            aVar.show(parentFragmentManager, b.a.a.a0.a.class.getSimpleName());
        }
    }

    public static final void launch(Context context, Traits$Location traits$Location) {
        Companion.launch(context, traits$Location);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.chooseGiftViews = h0.mapOf(o.to(getBinding().c, GooglePlayInAppSkuKt.getPremiumTier1Month()), o.to(getBinding().d, GooglePlayInAppSkuKt.getPremiumTier1Year()), o.to(getBinding().e, GooglePlayInAppSkuKt.getPremiumTier2Month()), o.to(getBinding().f, GooglePlayInAppSkuKt.getPremiumTier2Year()));
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().o.setOnClickListener(WidgetSettingsGifting$onViewBound$1.INSTANCE);
        TextInputLayout textInputLayout = getBinding().k;
        m.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new WidgetSettingsGifting$onViewBound$2(this), 1, null);
        getBinding().k.setErrorTextColor(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), 2131100382)));
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter = new WidgetSettingsGiftingOutboundPromosAdapter(new WidgetSettingsGifting$onViewBound$3(getViewModel()), new WidgetSettingsGifting$onViewBound$4(getViewModel()));
        RecyclerView recyclerView = getBinding().f2621s;
        m.checkNotNullExpressionValue(recyclerView, "binding.settingsGiftingYourGiftsRecycler");
        recyclerView.setAdapter(widgetSettingsGiftingOutboundPromosAdapter);
        this.promosAdapter = widgetSettingsGiftingOutboundPromosAdapter;
        RecyclerView recyclerView2 = getBinding().f2621s;
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter2 = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("promosAdapter");
        }
        recyclerView2.setAdapter(widgetSettingsGiftingOutboundPromosAdapter2);
        Context context = recyclerView2.getContext();
        m.checkNotNullExpressionValue(context, "context");
        RecyclerView$LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter3 = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("promosAdapter");
        }
        recyclerView2.addItemDecoration(new SpaceBetweenItemDecoration(context, orientation, widgetSettingsGiftingOutboundPromosAdapter3, DimenUtils.dpToPixels(16), 0, 16, null));
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView3 = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView3, "binding.settingsGiftingGiftsYouPurchasedRecycler");
        this.giftingAdapter = (WidgetSettingsGiftingAdapter) mGRecyclerAdapter$Companion.configure(new WidgetSettingsGiftingAdapter(recyclerView3));
        LinkifiedTextView linkifiedTextView = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.premiumTier1GiftLearnMore");
        b.m(linkifiedTextView, 2131893981, new Object[0], WidgetSettingsGifting$onViewBound$7.INSTANCE);
        LinkifiedTextView linkifiedTextView2 = getBinding().h;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.premiumTier2GiftLearnMore");
        b.m(linkifiedTextView2, 2131894271, new Object[0], WidgetSettingsGifting$onViewBound$8.INSTANCE);
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra("com.discord.intent.extra.EXTRA_LOCATION");
        if (!(serializableExtra instanceof Traits$Location)) {
            serializableExtra = null;
        }
        WidgetSettingsGifting$onViewBound$chooseGiftCallback$1 widgetSettingsGifting$onViewBound$chooseGiftCallback$1 = new WidgetSettingsGifting$onViewBound$chooseGiftCallback$1(this, (Traits$Location) serializableExtra);
        Map<GiftSelectView, GooglePlayInAppSku> map = this.chooseGiftViews;
        if (map == null) {
            m.throwUninitializedPropertyAccessException("chooseGiftViews");
        }
        for (Map$Entry<GiftSelectView, GooglePlayInAppSku> map$Entry : map.entrySet()) {
            GiftSelectView key = map$Entry.getKey();
            GooglePlayInAppSku value = map$Entry.getValue();
            Objects.requireNonNull(key);
            m.checkNotNullParameter(value, "inAppSku");
            m.checkNotNullParameter(widgetSettingsGifting$onViewBound$chooseGiftCallback$1, "onClickPlan");
            key.onClickPlan = widgetSettingsGifting$onViewBound$chooseGiftCallback$1;
            key.inAppSku = value;
            SkuDetails skuDetails = value.getSkuDetails();
            if (skuDetails != null) {
                TextView textView = key.binding.f;
                m.checkNotNullExpressionValue(textView, "binding.planItemName");
                textView.setText(skuDetails.a());
                TextView textView2 = key.binding.g;
                m.checkNotNullExpressionValue(textView2, "binding.planItemPrice");
                textView2.setText(skuDetails.b());
                TextView textView3 = key.binding.d;
                m.checkNotNullExpressionValue(textView3, "binding.planItemCurrentPlan");
                textView3.setVisibility(8);
                Integer iconForSku = GiftingUtils.INSTANCE.getIconForSku(value);
                if (iconForSku != null) {
                    key.binding.e.setImageResource(iconForSku.intValue());
                }
                TextView textView4 = key.binding.g;
                m.checkNotNullExpressionValue(textView4, "binding.planItemPrice");
                Context context2 = textView4.getContext();
                m.checkNotNullExpressionValue(context2, "binding.planItemPrice.context");
                int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context2, 2130969516, 0, 2, (Object) null);
                TextView textView5 = key.binding.g;
                m.checkNotNullExpressionValue(textView5, "binding.planItemPrice");
                DrawableCompat.setCompoundDrawablesCompat$default(textView5, 0, 0, themedDrawableRes$default, 0, 11, (Object) null);
                key.binding.c.setOnClickListener(new b.a.y.m0.a(key));
            }
        }
        RecyclerView recyclerView4 = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView4, "binding.settingsGiftingGiftsYouPurchasedRecycler");
        recyclerView4.setItemAnimator(null);
        getBinding().m.setHasFixedSize(false);
        for (TextView textView6 : n.listOf((Object[]) new TextView[]{getBinding().n, getBinding().l, getBinding().q, getBinding().p})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView6, "header");
            accessibilityUtils.setViewIsHeading(textView6);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsGiftingViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetSettingsGifting.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsGifting$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeGiftPurchaseEvents(), this, null, 2, null), WidgetSettingsGifting.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsGifting$onViewBoundOrOnResume$2(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetSettingsGifting.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsGifting$onViewBoundOrOnResume$3(this), 62, (Object) null);
        getViewModel().setOnGiftCodeResolved(WidgetSettingsGifting$onViewBoundOrOnResume$4.INSTANCE);
        enableGiftingButtons();
    }
}
