package com.discord.widgets.settings.premium;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetClaimOutboundPromoBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.premium.ClaimOutboundPromoViewModel;
import com.discord.widgets.settings.premium.ClaimStatus;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetClaimOutboundPromo extends AppDialog {
    private static final String ARG_CLAIM_STATUS = "ARG_CLAIM_STATUS";
    private static final int INDEX_FAILURE = 2;
    private static final int INDEX_LOADING = 0;
    private static final int INDEX_SUCCESS = 1;
    private static final String KEY_PROMO_CLAIMED = "KEY_PROMO_CLAIMED";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final MaterialShapeDrawable codeBoxBackground;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetClaimOutboundPromo.class, "binding", "getBinding()Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void showAndRegisterForClaimResult(ClaimStatus claimStatus, Fragment fragment, Function1<? super ClaimStatus.Claimed, Unit> onPromoClaimed) {
            C12238m.checkNotNullParameter(claimStatus, "claimStatus");
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(onPromoClaimed, "onPromoClaimed");
            if (fragment.getParentFragmentManager().findFragmentByTag("javaClass") != null) {
                return;
            }
            if (claimStatus instanceof ClaimStatus.Unclaimed) {
                FragmentKt.setFragmentResultListener(fragment, WidgetClaimOutboundPromo.KEY_PROMO_CLAIMED, new C9894x84762c86(onPromoClaimed));
            }
            WidgetClaimOutboundPromo widgetClaimOutboundPromo = new WidgetClaimOutboundPromo();
            Bundle bundle = new Bundle();
            bundle.putParcelable(WidgetClaimOutboundPromo.ARG_CLAIM_STATUS, claimStatus);
            widgetClaimOutboundPromo.setArguments(bundle);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetClaimOutboundPromo.show(parentFragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
    public static final /* synthetic */ class C98991 extends C12236k implements Function1<ClaimOutboundPromoViewModel.ViewState, Unit> {
        public C98991(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
            super(1, widgetClaimOutboundPromo, WidgetClaimOutboundPromo.class, "configureUi", "configureUi(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimOutboundPromoViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimOutboundPromoViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetClaimOutboundPromo) this.receiver).configureUi(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
    public static final /* synthetic */ class C99002 extends C12236k implements Function1<ClaimOutboundPromoViewModel.Event, Unit> {
        public C99002(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
            super(1, widgetClaimOutboundPromo, WidgetClaimOutboundPromo.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimOutboundPromoViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimOutboundPromoViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetClaimOutboundPromo) this.receiver).handleEvent(event);
        }
    }

    public WidgetClaimOutboundPromo() {
        super(C5419R.layout.widget_claim_outbound_promo);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetClaimOutboundPromo$binding$2.INSTANCE, null, 2, null);
        WidgetClaimOutboundPromo$viewModel$2 widgetClaimOutboundPromo$viewModel$2 = new WidgetClaimOutboundPromo$viewModel$2(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ClaimOutboundPromoViewModel.class), new WidgetClaimOutboundPromo$appViewModels$$inlined$viewModels$1(new C0865g0(this)), new C0869i0(widgetClaimOutboundPromo$viewModel$2));
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel.Builder().setAllCornerSizes(DimenUtils.dpToPixels(4)).build());
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
        this.codeBoxBackground = materialShapeDrawable;
    }

    private final void configureUi(ClaimOutboundPromoViewModel.ViewState viewState) {
        View view = getView();
        if (!(view instanceof ViewGroup)) {
            view = null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup != null) {
            AutoTransition autoTransition = new AutoTransition();
            autoTransition.setOrdering(0);
            autoTransition.setDuration(200L);
            TransitionManager.beginDelayedTransition(viewGroup, autoTransition);
        }
        if (viewState instanceof ClaimOutboundPromoViewModel.ViewState.ClaimInProgress) {
            AppViewFlipper appViewFlipper = getBinding().f16394g;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.claimPromoFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (!(viewState instanceof ClaimOutboundPromoViewModel.ViewState.Claimed)) {
            if (viewState instanceof ClaimOutboundPromoViewModel.ViewState.ClaimFailed) {
                AppViewFlipper appViewFlipper2 = getBinding().f16394g;
                C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.claimPromoFlipper");
                appViewFlipper2.setMeasureAllChildren(false);
                AppViewFlipper appViewFlipper3 = getBinding().f16394g;
                C12238m.checkNotNullExpressionValue(appViewFlipper3, "binding.claimPromoFlipper");
                appViewFlipper3.setDisplayedChild(2);
                setCancelable(true);
                return;
            }
            return;
        }
        TextView textView = getBinding().f16389b;
        C12238m.checkNotNullExpressionValue(textView, "binding.claimPromoBody");
        ClaimOutboundPromoViewModel.ViewState.Claimed claimed = (ClaimOutboundPromoViewModel.ViewState.Claimed) viewState;
        textView.setText(claimed.getClaimedStatus().getBody());
        TextView textView2 = getBinding().f16390c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.claimPromoCode");
        textView2.setText(claimed.getClaimedStatus().getCode());
        AppViewFlipper appViewFlipper4 = getBinding().f16394g;
        C12238m.checkNotNullExpressionValue(appViewFlipper4, "binding.claimPromoFlipper");
        appViewFlipper4.setDisplayedChild(1);
        setCancelable(true);
    }

    private final WidgetClaimOutboundPromoBinding getBinding() {
        return (WidgetClaimOutboundPromoBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ClaimStatus getClaimStatus() {
        Parcelable parcelable = getArgumentsOrDefault().getParcelable(ARG_CLAIM_STATUS);
        C12238m.checkNotNull(parcelable);
        return (ClaimStatus) parcelable;
    }

    private final ClaimOutboundPromoViewModel getViewModel() {
        return (ClaimOutboundPromoViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(ClaimOutboundPromoViewModel.Event event) {
        Unit unit;
        if (event instanceof ClaimOutboundPromoViewModel.Event.Claimed) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(KEY_PROMO_CLAIMED, ((ClaimOutboundPromoViewModel.Event.Claimed) event).getClaimedStatus());
            unit = Unit.f27425a;
            FragmentKt.setFragmentResult(this, KEY_PROMO_CLAIMED, bundle);
        } else if (event instanceof ClaimOutboundPromoViewModel.Event.CopyCode) {
            Object systemService = requireContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Promo Code", ((ClaimOutboundPromoViewModel.Event.CopyCode) event).getCode()));
            MaterialButton materialButton = getBinding().f16392e;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.claimPromoCopyButton");
            C1107b.m221m(materialButton, C5419R.string.copied, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
            setCodeBoxColor(ContextCompat.getColor(requireContext(), C5419R.color.status_green_600));
            unit = Unit.f27425a;
        } else if (event instanceof ClaimOutboundPromoViewModel.Event.OpenRedemptionUrl) {
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            UriHandler.handle$default(uriHandler, contextRequireContext, ((ClaimOutboundPromoViewModel.Event.OpenRedemptionUrl) event).getUrl(), false, false, null, 28, null);
            dismiss();
            unit = Unit.f27425a;
        } else {
            if (!(event instanceof ClaimOutboundPromoViewModel.Event.Dismiss)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            unit = Unit.f27425a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final void setCodeBoxColor(@ColorInt int color) {
        this.codeBoxBackground.setStroke(DimenUtils.dpToPixels(1), color);
        getBinding().f16391d.invalidate();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewCompat.setBackground(getBinding().f16391d, this.codeBoxBackground);
        setCodeBoxColor(ColorCompat.getThemedColor(view, C5419R.attr.colorInteractiveNormal));
        getBinding().f16392e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetClaimOutboundPromo.this.getViewModel().copyClicked();
            }
        });
        getBinding().f16396i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetClaimOutboundPromo.this.getViewModel().redeemClicked();
            }
        });
        getBinding().f16395h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetClaimOutboundPromo.this.getViewModel().maybeLaterClicked();
            }
        });
        getBinding().f16393f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetClaimOutboundPromo.this.getViewModel().failureCloseClicked();
            }
        });
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetClaimOutboundPromo.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98991(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetClaimOutboundPromo.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C99002(this));
    }
}
