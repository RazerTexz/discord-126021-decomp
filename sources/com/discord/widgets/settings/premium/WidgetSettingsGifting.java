package com.discord.widgets.settings.premium;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
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
import com.android.billingclient.api.SkuDetails;
import com.discord.C5419R;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsGiftingBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.billing.GooglePlayInAppSkuKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.recycler.SpaceBetweenItemDecoration;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.premium.GiftSelectView;
import com.discord.widgets.settings.premium.ClaimStatus;
import com.discord.widgets.settings.premium.SettingsGiftingViewModel;
import com.discord.widgets.settings.premium.WidgetOutboundPromoTerms;
import com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.textfield.TextInputLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p011a0.C0803a;
import p007b.p008a.p009a.p011a0.C0805c;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.p066m0.ViewOnClickListenerC1360a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12151p;
import p507d0.p580t.C12163u;
import p507d0.p580t.C12168z;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsGifting.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsGiftingBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, Traits.Location location, int i, Object obj) {
            if ((i & 2) != 0) {
                location = null;
            }
            companion.launch(context, location);
        }

        public final void launch(Context context, Traits.Location location) {
            C12238m.checkNotNullParameter(context, "context");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_LOCATION", location);
            C0870j.m156d(context, WidgetSettingsGifting.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$1 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class C99021 extends AbstractC12240o implements Function2<Long, Long, Unit> {
        public C99021() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
            invoke(l.longValue(), l2);
            return Unit.f27425a;
        }

        public final void invoke(long j, Long l) {
            WidgetSettingsGifting.this.getViewModel().handleSkuClicked(j, l);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$2 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class C99032 extends AbstractC12240o implements Function1<String, Unit> {
        public C99032() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "giftCode");
            Context context = WidgetSettingsGifting.this.getContext();
            Object systemService = context != null ? context.getSystemService("clipboard") : null;
            ClipboardManager clipboardManager = (ClipboardManager) (systemService instanceof ClipboardManager ? systemService : null);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", GiftingUtils.INSTANCE.generateGiftUrl(str)));
            }
            WidgetSettingsGifting.this.getViewModel().handleCopyClicked(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$3 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class C99043 extends AbstractC12240o implements Function1<ModelGift, Unit> {
        public static final C99043 INSTANCE = new C99043();

        public C99043() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
            invoke2(modelGift);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGift modelGift) {
            C12238m.checkNotNullParameter(modelGift, "gift");
            StoreStream.INSTANCE.getGifting().revokeGiftCode(modelGift);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$configureUI$4 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class C99054 extends AbstractC12240o implements Function2<Long, Long, Unit> {
        public static final C99054 INSTANCE = new C99054();

        public C99054() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
            invoke(l.longValue(), l2);
            return Unit.f27425a;
        }

        public final void invoke(long j, Long l) {
            StoreStream.INSTANCE.getGifting().generateGiftCode(j, (12 & 2) != 0 ? null : l, (12 & 4) != 0 ? null : null, (12 & 8) != 0 ? null : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$handleEvent$1 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class C99061 extends AbstractC12240o implements Function1<ClaimStatus.Claimed, Unit> {
        public C99061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimStatus.Claimed claimed) {
            invoke2(claimed);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimStatus.Claimed claimed) {
            C12238m.checkNotNullParameter(claimed, "it");
            WidgetSettingsGifting.this.getViewModel().handleClaimedPromo(claimed);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$handleGiftPurchaseEvent$1 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class C99071 extends AbstractC12240o implements Function0<Unit> {
        public C99071() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsGifting.this.requireAppActivity().setResult(-1);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class C99092 extends AbstractC12240o implements Function1<TextView, Unit> {
        public C99092() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            C12238m.checkNotNullParameter(textView, "it");
            TextInputLayout textInputLayout = WidgetSettingsGifting.this.getBinding().f17963k;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
            WidgetSettingsGifting.this.getViewModel().redeemGiftCode(C12103t.replace$default(C12103t.replace$default(ViewExtensions.getTextOrEmpty(textInputLayout), "https://discord.gift/", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), WidgetSettingsGifting.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final /* synthetic */ class C99103 extends C12236k implements Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> {
        public C99103(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handlePromoMoreDetailsClicked", "handlePromoMoreDetailsClicked(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            invoke2(outboundPromoItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            C12238m.checkNotNullParameter(outboundPromoItem, "p1");
            ((SettingsGiftingViewModel) this.receiver).handlePromoMoreDetailsClicked(outboundPromoItem);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final /* synthetic */ class C99114 extends C12236k implements Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> {
        public C99114(SettingsGiftingViewModel settingsGiftingViewModel) {
            super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handlePromoButtonClicked", "handlePromoButtonClicked(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            invoke2(outboundPromoItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            C12238m.checkNotNullParameter(outboundPromoItem, "p1");
            ((SettingsGiftingViewModel) this.receiver).handlePromoButtonClicked(outboundPromoItem);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$7 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class C99127 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public static final C99127 INSTANCE = new C99127();

        /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$7$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
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
                WidgetSettingsPremium.Companion.launch$default(companion, context, 0, null, 4, null);
            }
        }

        public C99127() {
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
            renderContext.m8423b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$8 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class C99138 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public static final C99138 INSTANCE = new C99138();

        /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$8$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
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
                WidgetSettingsPremium.Companion.launch$default(companion, context, 1, null, 4, null);
            }
        }

        public C99138() {
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
            renderContext.m8423b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final /* synthetic */ class C99151 extends C12236k implements Function1<SettingsGiftingViewModel.ViewState, Unit> {
        public C99151(WidgetSettingsGifting widgetSettingsGifting) {
            super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetSettingsGifting) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final /* synthetic */ class C99162 extends C12236k implements Function1<SettingsGiftingViewModel.GiftPurchaseEvent, Unit> {
        public C99162(WidgetSettingsGifting widgetSettingsGifting) {
            super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "handleGiftPurchaseEvent", "handleGiftPurchaseEvent(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.GiftPurchaseEvent giftPurchaseEvent) {
            invoke2(giftPurchaseEvent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.GiftPurchaseEvent giftPurchaseEvent) {
            C12238m.checkNotNullParameter(giftPurchaseEvent, "p1");
            ((WidgetSettingsGifting) this.receiver).handleGiftPurchaseEvent(giftPurchaseEvent);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final /* synthetic */ class C99173 extends C12236k implements Function1<SettingsGiftingViewModel.Event, Unit> {
        public C99173(WidgetSettingsGifting widgetSettingsGifting) {
            super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGiftingViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetSettingsGifting) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBoundOrOnResume$4 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class C99184 extends AbstractC12240o implements Function1<String, Unit> {
        public static final C99184 INSTANCE = new C99184();

        public C99184() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "giftCode");
            C0805c.INSTANCE.m107a(str, "Settings - Gifting", 0L);
        }
    }

    public WidgetSettingsGifting() {
        super(C5419R.layout.widget_settings_gifting);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsGifting$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsGifting$viewModel$2 widgetSettingsGifting$viewModel$2 = WidgetSettingsGifting$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(SettingsGiftingViewModel.class), new WidgetSettingsGifting$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetSettingsGifting$viewModel$2));
    }

    private final void addGiftItems(List<ModelEntitlement> entries, SettingsGiftingViewModel.ViewState.Loaded viewState, List<WidgetSettingsGiftingAdapter.GiftItem> listItems) {
        if (entries.isEmpty()) {
            return;
        }
        ModelEntitlement modelEntitlement = (ModelEntitlement) C12163u.first((List) entries);
        Set<Long> expandedSkuOrPlanIds = viewState.getExpandedSkuOrPlanIds();
        SubscriptionPlan subscriptionPlan = modelEntitlement.getSubscriptionPlan();
        boolean zContains = expandedSkuOrPlanIds.contains(Long.valueOf(subscriptionPlan != null ? subscriptionPlan.getId() : modelEntitlement.getSku().getId()));
        ModelSku sku = modelEntitlement.getSku();
        SubscriptionPlan subscriptionPlan2 = modelEntitlement.getSubscriptionPlan();
        listItems.add(new WidgetSettingsGiftingAdapter.GiftItem(1, null, null, Boolean.valueOf(zContains), sku, Integer.valueOf(entries.size()), subscriptionPlan2 != null ? Long.valueOf(subscriptionPlan2.getId()) : null, null, null, 390, null));
        Iterator itWithIndex = C12151p.withIndex(entries.iterator());
        boolean z2 = false;
        while (itWithIndex.hasNext()) {
            C12168z c12168z = (C12168z) itWithIndex.next();
            int iComponent1 = c12168z.component1();
            ModelEntitlement modelEntitlement2 = (ModelEntitlement) c12168z.component2();
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
            listItems.add(new WidgetSettingsGiftingAdapter.GiftItem(2, modelGift, modelEntitlement2, Boolean.valueOf(zContains), null, null, subscriptionPlan4 != null ? Long.valueOf(subscriptionPlan4.getId()) : null, Boolean.valueOf(iComponent1 == entries.size() - 1), Boolean.valueOf(modelGift != null && C12238m.areEqual(modelGift.getCode(), viewState.getLastCopiedCode())), 48, null));
        }
    }

    private final void configureUI(SettingsGiftingViewModel.ViewState viewState) {
        if (viewState instanceof SettingsGiftingViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f17961i;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsGiftingFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof SettingsGiftingViewModel.ViewState.Failure) {
            AppViewFlipper appViewFlipper2 = getBinding().f17961i;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.settingsGiftingFlipper");
            appViewFlipper2.setDisplayedChild(1);
            return;
        }
        if (viewState instanceof SettingsGiftingViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper3 = getBinding().f17961i;
            C12238m.checkNotNullExpressionValue(appViewFlipper3, "binding.settingsGiftingFlipper");
            appViewFlipper3.setDisplayedChild(2);
        }
        SettingsGiftingViewModel.ViewState.Loaded loaded = (SettingsGiftingViewModel.ViewState.Loaded) viewState;
        boolean z2 = loaded.getResolvingGiftState() instanceof SettingsGiftingViewModel.ResolvingGiftState.Resolving;
        CharSequence charSequenceM213e = loaded.getResolvingGiftState() instanceof SettingsGiftingViewModel.ResolvingGiftState.Error ? C1107b.m213e(this, C5419R.string.application_entitlement_code_redemption_invalid, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null) : null;
        ProgressBar progressBar = getBinding().f17962j;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.settingsGiftingGiftCodeInputProgress");
        progressBar.setVisibility(z2 ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().f17963k;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
        ViewExtensions.setEnabledAlpha$default(textInputLayout, !z2, 0.0f, 2, null);
        TextInputLayout textInputLayout2 = getBinding().f17963k;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.settingsGiftingGiftCodeInputWrap");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.setInputType(z2 ? 0 : 524288);
        }
        TextInputLayout textInputLayout3 = getBinding().f17963k;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.settingsGiftingGiftCodeInputWrap");
        textInputLayout3.setError(charSequenceM213e);
        boolean z3 = !loaded.getOutboundPromos().isEmpty();
        TextView textView = getBinding().f17970r;
        C12238m.checkNotNullExpressionValue(textView, "binding.settingsGiftingYourGiftsHeader");
        textView.setVisibility(z3 ? 0 : 8);
        RecyclerView recyclerView = getBinding().f17971s;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.settingsGiftingYourGiftsRecycler");
        recyclerView.setVisibility(z3 ? 0 : 8);
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("promosAdapter");
        }
        widgetSettingsGiftingOutboundPromosAdapter.submitList(loaded.getOutboundPromos());
        WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter = this.giftingAdapter;
        if (widgetSettingsGiftingAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("giftingAdapter");
        }
        widgetSettingsGiftingAdapter.configure(generateListItems(loaded), new C99021(), new C99032(), C99043.INSTANCE, C99054.INSTANCE);
    }

    private final void enableGiftingButtons() {
        Map<GiftSelectView, GooglePlayInAppSku> map = this.chooseGiftViews;
        if (map == null) {
            C12238m.throwUninitializedPropertyAccessException("chooseGiftViews");
        }
        for (GiftSelectView giftSelectView : map.keySet()) {
            giftSelectView.binding.f16378c.setOnClickListener(new ViewOnClickListenerC1360a(giftSelectView));
        }
    }

    private final List<WidgetSettingsGiftingAdapter.GiftItem> generateListItems(SettingsGiftingViewModel.ViewState.Loaded viewState) {
        ArrayList arrayList = new ArrayList();
        if (viewState.getMyEntitlements().isEmpty()) {
            arrayList.add(new WidgetSettingsGiftingAdapter.GiftItem(0, null, null, null, null, null, null, null, null, 510, null));
        } else {
            for (Map.Entry<Long, List<ModelEntitlement>> entry : viewState.getMyEntitlements().entrySet()) {
                entry.getKey().longValue();
                List<ModelEntitlement> value = entry.getValue();
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
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    addGiftItems((List) entry2.getValue(), viewState, arrayList);
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

    private final void handleEvent(SettingsGiftingViewModel.Event event) {
        Unit unit;
        if (event instanceof SettingsGiftingViewModel.Event.ShowPromoBottomSheet) {
            WidgetOutboundPromoTerms.Companion companion = WidgetOutboundPromoTerms.INSTANCE;
            String content = ((SettingsGiftingViewModel.Event.ShowPromoBottomSheet) event).getContent();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(content, parentFragmentManager);
            unit = Unit.f27425a;
        } else {
            if (!(event instanceof SettingsGiftingViewModel.Event.ShowPromoDialog)) {
                throw new NoWhenBranchMatchedException();
            }
            WidgetClaimOutboundPromo.INSTANCE.showAndRegisterForClaimResult(((SettingsGiftingViewModel.Event.ShowPromoDialog) event).getClaimStatus(), this, new C99061());
            unit = Unit.f27425a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final void handleGiftPurchaseEvent(SettingsGiftingViewModel.GiftPurchaseEvent event) {
        enableGiftingButtons();
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.StartGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f17954b, true, false, 2, null);
            return;
        }
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.NotInProgress) {
            DimmerView.setDimmed$default(getBinding().f17954b, false, false, 2, null);
            return;
        }
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.ErrorGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f17954b, false, false, 2, null);
            C0876m.m171i(this, ((SettingsGiftingViewModel.GiftPurchaseEvent.ErrorGiftPurchase) event).getMessage(), 0, 4);
            return;
        }
        if (event instanceof SettingsGiftingViewModel.GiftPurchaseEvent.CompleteGiftPurchase) {
            DimmerView.setDimmed$default(getBinding().f17954b, false, false, 2, null);
            C0803a.Companion companion = C0803a.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            C99071 c99071 = new C99071();
            SettingsGiftingViewModel.GiftPurchaseEvent.CompleteGiftPurchase completeGiftPurchase = (SettingsGiftingViewModel.GiftPurchaseEvent.CompleteGiftPurchase) event;
            String skuName = completeGiftPurchase.getSkuName();
            String newGiftCode = completeGiftPurchase.getNewGiftCode();
            Objects.requireNonNull(companion);
            C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(c99071, "onDismiss");
            C12238m.checkNotNullParameter(skuName, "skuName");
            C12238m.checkNotNullParameter(newGiftCode, "giftCode");
            C0803a c0803a = new C0803a();
            c0803a.onDismiss = c99071;
            Bundle bundle = new Bundle();
            bundle.putString("ARG_SKU_NAME", skuName);
            bundle.putString("ARG_GIFT_CODE", newGiftCode);
            c0803a.setArguments(bundle);
            c0803a.show(parentFragmentManager, C0803a.class.getSimpleName());
        }
    }

    public static final void launch(Context context, Traits.Location location) {
        INSTANCE.launch(context, location);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.chooseGiftViews = C12136h0.mapOf(C12116o.m10073to(getBinding().f17955c, GooglePlayInAppSkuKt.getPremiumTier1Month()), C12116o.m10073to(getBinding().f17956d, GooglePlayInAppSkuKt.getPremiumTier1Year()), C12116o.m10073to(getBinding().f17957e, GooglePlayInAppSkuKt.getPremiumTier2Month()), C12116o.m10073to(getBinding().f17958f, GooglePlayInAppSkuKt.getPremiumTier2Year()));
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().f17967o.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsGifting.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StoreStream.INSTANCE.getEntitlements().fetchMyGiftEntitlements();
            }
        });
        TextInputLayout textInputLayout = getBinding().f17963k;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C99092(), 1, null);
        getBinding().f17963k.setErrorTextColor(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), C5419R.color.status_red_500)));
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter = new WidgetSettingsGiftingOutboundPromosAdapter(new C99103(getViewModel()), new C99114(getViewModel()));
        RecyclerView recyclerView = getBinding().f17971s;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.settingsGiftingYourGiftsRecycler");
        recyclerView.setAdapter(widgetSettingsGiftingOutboundPromosAdapter);
        this.promosAdapter = widgetSettingsGiftingOutboundPromosAdapter;
        RecyclerView recyclerView2 = getBinding().f17971s;
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter2 = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("promosAdapter");
        }
        recyclerView2.setAdapter(widgetSettingsGiftingOutboundPromosAdapter2);
        Context context = recyclerView2.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        WidgetSettingsGiftingOutboundPromosAdapter widgetSettingsGiftingOutboundPromosAdapter3 = this.promosAdapter;
        if (widgetSettingsGiftingOutboundPromosAdapter3 == null) {
            C12238m.throwUninitializedPropertyAccessException("promosAdapter");
        }
        recyclerView2.addItemDecoration(new SpaceBetweenItemDecoration(context, orientation, widgetSettingsGiftingOutboundPromosAdapter3, DimenUtils.dpToPixels(16), 0, 16, null));
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView3 = getBinding().f17965m;
        C12238m.checkNotNullExpressionValue(recyclerView3, "binding.settingsGiftingGiftsYouPurchasedRecycler");
        this.giftingAdapter = (WidgetSettingsGiftingAdapter) companion.configure(new WidgetSettingsGiftingAdapter(recyclerView3));
        LinkifiedTextView linkifiedTextView = getBinding().f17959g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.premiumTier1GiftLearnMore");
        C1107b.m221m(linkifiedTextView, C5419R.string.premium_classic_payment_gift_blurb_mobile, new Object[0], C99127.INSTANCE);
        LinkifiedTextView linkifiedTextView2 = getBinding().f17960h;
        C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.premiumTier2GiftLearnMore");
        C1107b.m221m(linkifiedTextView2, C5419R.string.premium_payment_gift_blurb_mobile, new Object[0], C99138.INSTANCE);
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra("com.discord.intent.extra.EXTRA_LOCATION");
        if (!(serializableExtra instanceof Traits.Location)) {
            serializableExtra = null;
        }
        WidgetSettingsGifting$onViewBound$chooseGiftCallback$1 widgetSettingsGifting$onViewBound$chooseGiftCallback$1 = new WidgetSettingsGifting$onViewBound$chooseGiftCallback$1(this, (Traits.Location) serializableExtra);
        Map<GiftSelectView, GooglePlayInAppSku> map = this.chooseGiftViews;
        if (map == null) {
            C12238m.throwUninitializedPropertyAccessException("chooseGiftViews");
        }
        for (Map.Entry<GiftSelectView, GooglePlayInAppSku> entry : map.entrySet()) {
            GiftSelectView key = entry.getKey();
            GooglePlayInAppSku value = entry.getValue();
            Objects.requireNonNull(key);
            C12238m.checkNotNullParameter(value, "inAppSku");
            C12238m.checkNotNullParameter(widgetSettingsGifting$onViewBound$chooseGiftCallback$1, "onClickPlan");
            key.onClickPlan = widgetSettingsGifting$onViewBound$chooseGiftCallback$1;
            key.inAppSku = value;
            SkuDetails skuDetails = value.getSkuDetails();
            if (skuDetails != null) {
                TextView textView = key.binding.f16381f;
                C12238m.checkNotNullExpressionValue(textView, "binding.planItemName");
                textView.setText(skuDetails.m7500a());
                TextView textView2 = key.binding.f16382g;
                C12238m.checkNotNullExpressionValue(textView2, "binding.planItemPrice");
                textView2.setText(skuDetails.m7501b());
                TextView textView3 = key.binding.f16379d;
                C12238m.checkNotNullExpressionValue(textView3, "binding.planItemCurrentPlan");
                textView3.setVisibility(8);
                Integer iconForSku = GiftingUtils.INSTANCE.getIconForSku(value);
                if (iconForSku != null) {
                    key.binding.f16380e.setImageResource(iconForSku.intValue());
                }
                TextView textView4 = key.binding.f16382g;
                C12238m.checkNotNullExpressionValue(textView4, "binding.planItemPrice");
                Context context2 = textView4.getContext();
                C12238m.checkNotNullExpressionValue(context2, "binding.planItemPrice.context");
                int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context2, C5419R.attr.ic_navigate_next, 0, 2, (Object) null);
                TextView textView5 = key.binding.f16382g;
                C12238m.checkNotNullExpressionValue(textView5, "binding.planItemPrice");
                DrawableCompat.setCompoundDrawablesCompat$default(textView5, 0, 0, themedDrawableRes$default, 0, 11, (Object) null);
                key.binding.f16378c.setOnClickListener(new ViewOnClickListenerC1360a(key));
            }
        }
        RecyclerView recyclerView4 = getBinding().f17965m;
        C12238m.checkNotNullExpressionValue(recyclerView4, "binding.settingsGiftingGiftsYouPurchasedRecycler");
        recyclerView4.setItemAnimator(null);
        getBinding().f17965m.setHasFixedSize(false);
        for (TextView textView6 : C12147n.listOf((Object[]) new TextView[]{getBinding().f17966n, getBinding().f17964l, getBinding().f17969q, getBinding().f17968p})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView6, "header");
            accessibilityUtils.setViewIsHeading(textView6);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsGiftingViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetSettingsGifting.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C99151(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getViewModel().observeGiftPurchaseEvents(), this, null, 2, null), (Class<?>) WidgetSettingsGifting.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C99162(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetSettingsGifting.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C99173(this));
        getViewModel().setOnGiftCodeResolved(C99184.INSTANCE);
        enableGiftingButtons();
    }
}
