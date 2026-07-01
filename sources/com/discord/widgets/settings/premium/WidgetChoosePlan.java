package com.discord.widgets.settings.premium;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a.c;
import b.a.a.a.c$a;
import b.a.a.b.f;
import b.a.a.b.f$a;
import b.a.a.b.g;
import b.a.a.b.g$a;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChoosePlanBinding;
import com.discord.stores.StoreGooglePlayPurchases$QueryState$InProgress;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlan extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChoosePlan.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChoosePlanBinding;", 0)};
    public static final WidgetChoosePlan$Companion Companion = new WidgetChoosePlan$Companion(null);
    public static final String RESULT_EXTRA_LOCATION_TRAIT = "result_extra_location_trait";
    public static final String RESULT_EXTRA_OLD_SKU_NAME = "result_extra_current_sku_name";
    public static final String RESULT_VIEW_TYPE = "result_view_type";
    private WidgetChoosePlanAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private LinearLayoutManager planLayoutManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetChoosePlan() {
        super(R$layout.widget_choose_plan);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChoosePlan$binding$2.INSTANCE, null, 2, null);
        WidgetChoosePlan$viewModel$2 widgetChoosePlan$viewModel$2 = new WidgetChoosePlan$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ChoosePlanViewModel.class), new WidgetChoosePlan$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetChoosePlan$viewModel$2));
    }

    public static final /* synthetic */ Unit access$configureUI(WidgetChoosePlan widgetChoosePlan, ChoosePlanViewModel$ViewState choosePlanViewModel$ViewState) {
        return widgetChoosePlan.configureUI(choosePlanViewModel$ViewState);
    }

    public static final /* synthetic */ ChoosePlanViewModel access$getViewModel$p(WidgetChoosePlan widgetChoosePlan) {
        return widgetChoosePlan.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetChoosePlan widgetChoosePlan, ChoosePlanViewModel$Event choosePlanViewModel$Event) {
        widgetChoosePlan.handleEvent(choosePlanViewModel$Event);
    }

    private final Unit configureUI(ChoosePlanViewModel$ViewState viewState) {
        if (viewState instanceof ChoosePlanViewModel$ViewState$Loading) {
            return null;
        }
        if (!(viewState instanceof ChoosePlanViewModel$ViewState$Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        WidgetChoosePlanAdapter widgetChoosePlanAdapter = this.adapter;
        if (widgetChoosePlanAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        ChoosePlanViewModel$ViewState$Loaded choosePlanViewModel$ViewState$Loaded = (ChoosePlanViewModel$ViewState$Loaded) viewState;
        widgetChoosePlanAdapter.setData(choosePlanViewModel$ViewState$Loaded.getItems());
        LinearLayout linearLayout = getBinding().f2349b;
        m.checkNotNullExpressionValue(linearLayout, "binding.choosePlanEmptyContainer");
        linearLayout.setVisibility(choosePlanViewModel$ViewState$Loaded.isEmpty() ? 0 : 8);
        if (m.areEqual(choosePlanViewModel$ViewState$Loaded.getPurchasesQueryState(), StoreGooglePlayPurchases$QueryState$InProgress.INSTANCE)) {
            DimmerView.setDimmed$default(getBinding().e, true, false, 2, null);
            return Unit.a;
        }
        DimmerView.setDimmed$default(getBinding().e, false, false, 2, null);
        return Unit.a;
    }

    private final WidgetChoosePlanBinding getBinding() {
        return (WidgetChoosePlanBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ChoosePlanViewModel getViewModel() {
        return (ChoosePlanViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(ChoosePlanViewModel$Event event) {
        if (event instanceof ChoosePlanViewModel$Event$ErrorSkuPurchase) {
            b.a.d.m.i(this, ((ChoosePlanViewModel$Event$ErrorSkuPurchase) event).getMessage(), 0, 4);
            return;
        }
        if (event instanceof ChoosePlanViewModel$Event$StartSkuPurchase) {
            GooglePlayBillingManager.INSTANCE.launchBillingFlow(requireAppActivity(), ((ChoosePlanViewModel$Event$StartSkuPurchase) event).getBillingParams());
            return;
        }
        if (event instanceof ChoosePlanViewModel$Event$CompleteSkuPurchase) {
            ChoosePlanViewModel$Event$CompleteSkuPurchase choosePlanViewModel$Event$CompleteSkuPurchase = (ChoosePlanViewModel$Event$CompleteSkuPurchase) event;
            GooglePlaySku googlePlaySkuFromSkuName = GooglePlaySku.Companion.fromSkuName(choosePlanViewModel$Event$CompleteSkuPurchase.getSkuName());
            if (googlePlaySkuFromSkuName != null) {
                WidgetChoosePlan$handleEvent$onDismiss$1 widgetChoosePlan$handleEvent$onDismiss$1 = new WidgetChoosePlan$handleEvent$onDismiss$1(this);
                int iOrdinal = googlePlaySkuFromSkuName.getType().ordinal();
                if (iOrdinal == 0) {
                    f$a f_a = f.k;
                    FragmentManager parentFragmentManager = getParentFragmentManager();
                    m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    f_a.a(parentFragmentManager, widgetChoosePlan$handleEvent$onDismiss$1, false);
                    return;
                }
                if (iOrdinal == 1) {
                    f$a f_a2 = f.k;
                    FragmentManager parentFragmentManager2 = getParentFragmentManager();
                    m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                    f_a2.a(parentFragmentManager2, widgetChoosePlan$handleEvent$onDismiss$1, true);
                    return;
                }
                if (iOrdinal != 2 && iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        return;
                    }
                    c$a c_a = c.l;
                    FragmentManager parentFragmentManager3 = getParentFragmentManager();
                    m.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
                    c_a.a(parentFragmentManager3, requireContext(), null, googlePlaySkuFromSkuName.getPremiumSubscriptionCount(), false, widgetChoosePlan$handleEvent$onDismiss$1);
                    return;
                }
                g$a g_a = g.k;
                FragmentManager parentFragmentManager4 = getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager4, "parentFragmentManager");
                String planName = choosePlanViewModel$Event$CompleteSkuPurchase.getPlanName();
                Objects.requireNonNull(g_a);
                m.checkNotNullParameter(parentFragmentManager4, "fragmentManager");
                m.checkNotNullParameter(widgetChoosePlan$handleEvent$onDismiss$1, "onDismiss");
                m.checkNotNullParameter(planName, "planName");
                g gVar = new g();
                gVar.onDismiss = widgetChoosePlan$handleEvent$onDismiss$1;
                Bundle bundle = new Bundle();
                bundle.putString("extra_plan_text", planName);
                gVar.setArguments(bundle);
                gVar.show(parentFragmentManager4, g.class.getSimpleName());
            }
        }
    }

    private final void setUpRecycler() {
        RecyclerView recyclerView = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView, "binding.choosePlanRecycler");
        this.planLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        RecyclerView recyclerView2 = getBinding().d;
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        m.checkNotNullExpressionValue(recyclerView2, "it");
        this.adapter = (WidgetChoosePlanAdapter) mGRecyclerAdapter$Companion.configure(new WidgetChoosePlanAdapter(recyclerView2));
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(RESULT_EXTRA_LOCATION_TRAIT);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.utilities.analytics.Traits.Location");
        Traits$Location traits$Location = (Traits$Location) serializableExtra;
        WidgetChoosePlanAdapter widgetChoosePlanAdapter = this.adapter;
        if (widgetChoosePlanAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChoosePlanAdapter.setOnClickPlan(new WidgetChoosePlan$setUpRecycler$2(this, traits$Location));
        RecyclerView recyclerView3 = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView3, "binding.choosePlanRecycler");
        LinearLayoutManager linearLayoutManager = this.planLayoutManager;
        if (linearLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("planLayoutManager");
        }
        recyclerView3.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView4 = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView4, "binding.choosePlanRecycler");
        WidgetChoosePlanAdapter widgetChoosePlanAdapter2 = this.adapter;
        if (widgetChoosePlanAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView4.setAdapter(widgetChoosePlanAdapter2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpRecycler();
        LinkifiedTextView linkifiedTextView = getBinding().c;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.choosePlanEmptyDescription");
        b.n(linkifiedTextView, 2131894262, new Object[]{b.a.d.f.a.a(360055386693L, null)}, null, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChoosePlan.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChoosePlan$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChoosePlan.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChoosePlan$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
