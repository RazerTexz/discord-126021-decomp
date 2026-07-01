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
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetClaimOutboundPromoBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.premium.ClaimOutboundPromoViewModel;
import com.discord.widgets.settings.premium.ClaimStatus;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetClaimOutboundPromo.class, "binding", "getBinding()Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void showAndRegisterForClaimResult(ClaimStatus claimStatus, Fragment fragment, Function1<? super ClaimStatus.Claimed, Unit> onPromoClaimed) {
            Intrinsics3.checkNotNullParameter(claimStatus, "claimStatus");
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(onPromoClaimed, "onPromoClaimed");
            if (fragment.getParentFragmentManager().findFragmentByTag("javaClass") != null) {
                return;
            }
            if (claimStatus instanceof ClaimStatus.Unclaimed) {
                Fragment2.setFragmentResultListener(fragment, WidgetClaimOutboundPromo.KEY_PROMO_CLAIMED, new WidgetClaimOutboundPromo2(onPromoClaimed));
            }
            WidgetClaimOutboundPromo widgetClaimOutboundPromo = new WidgetClaimOutboundPromo();
            Bundle bundle = new Bundle();
            bundle.putParcelable(WidgetClaimOutboundPromo.ARG_CLAIM_STATUS, claimStatus);
            widgetClaimOutboundPromo.setArguments(bundle);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetClaimOutboundPromo.show(parentFragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ClaimOutboundPromoViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
            super(1, widgetClaimOutboundPromo, WidgetClaimOutboundPromo.class, "configureUi", "configureUi(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimOutboundPromoViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimOutboundPromoViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetClaimOutboundPromo) this.receiver).configureUi(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ClaimOutboundPromoViewModel.Event, Unit> {
        public AnonymousClass2(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
            super(1, widgetClaimOutboundPromo, WidgetClaimOutboundPromo.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimOutboundPromoViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimOutboundPromoViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetClaimOutboundPromo) this.receiver).handleEvent(event);
        }
    }

    public WidgetClaimOutboundPromo() {
        super(R.layout.widget_claim_outbound_promo);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetClaimOutboundPromo3.INSTANCE, null, 2, null);
        WidgetClaimOutboundPromo4 widgetClaimOutboundPromo4 = new WidgetClaimOutboundPromo4(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ClaimOutboundPromoViewModel.class), new WidgetClaimOutboundPromo$appViewModels$$inlined$viewModels$1(new AppViewModelDelegates3(this)), new AppViewModelDelegates5(widgetClaimOutboundPromo4));
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
            AppViewFlipper appViewFlipper = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.claimPromoFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (!(viewState instanceof ClaimOutboundPromoViewModel.ViewState.Claimed)) {
            if (viewState instanceof ClaimOutboundPromoViewModel.ViewState.ClaimFailed) {
                AppViewFlipper appViewFlipper2 = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.claimPromoFlipper");
                appViewFlipper2.setMeasureAllChildren(false);
                AppViewFlipper appViewFlipper3 = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.claimPromoFlipper");
                appViewFlipper3.setDisplayedChild(2);
                setCancelable(true);
                return;
            }
            return;
        }
        TextView textView = getBinding().f2350b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.claimPromoBody");
        ClaimOutboundPromoViewModel.ViewState.Claimed claimed = (ClaimOutboundPromoViewModel.ViewState.Claimed) viewState;
        textView.setText(claimed.getClaimedStatus().getBody());
        TextView textView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.claimPromoCode");
        textView2.setText(claimed.getClaimedStatus().getCode());
        AppViewFlipper appViewFlipper4 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.claimPromoFlipper");
        appViewFlipper4.setDisplayedChild(1);
        setCancelable(true);
    }

    private final WidgetClaimOutboundPromoBinding getBinding() {
        return (WidgetClaimOutboundPromoBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ClaimStatus getClaimStatus() {
        Parcelable parcelable = getArgumentsOrDefault().getParcelable(ARG_CLAIM_STATUS);
        Intrinsics3.checkNotNull(parcelable);
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
            unit = Unit.a;
            Fragment2.setFragmentResult(this, KEY_PROMO_CLAIMED, bundle);
        } else if (event instanceof ClaimOutboundPromoViewModel.Event.CopyCode) {
            Object systemService = requireContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Promo Code", ((ClaimOutboundPromoViewModel.Event.CopyCode) event).getCode()));
            MaterialButton materialButton = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.claimPromoCopyButton");
            FormatUtils.m(materialButton, R.string.copied, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
            setCodeBoxColor(ContextCompat.getColor(requireContext(), R.color.status_green_600));
            unit = Unit.a;
        } else if (event instanceof ClaimOutboundPromoViewModel.Event.OpenRedemptionUrl) {
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            UriHandler.handle$default(uriHandler, contextRequireContext, ((ClaimOutboundPromoViewModel.Event.OpenRedemptionUrl) event).getUrl(), false, false, null, 28, null);
            dismiss();
            unit = Unit.a;
        } else {
            if (!(event instanceof ClaimOutboundPromoViewModel.Event.Dismiss)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final void setCodeBoxColor(@ColorInt int color) {
        this.codeBoxBackground.setStroke(DimenUtils.dpToPixels(1), color);
        getBinding().d.invalidate();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewCompat.setBackground(getBinding().d, this.codeBoxBackground);
        setCodeBoxColor(ColorCompat.getThemedColor(view, R.attr.colorInteractiveNormal));
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetClaimOutboundPromo.this.getViewModel().copyClicked();
            }
        });
        getBinding().i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetClaimOutboundPromo.this.getViewModel().redeemClicked();
            }
        });
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetClaimOutboundPromo.this.getViewModel().maybeLaterClicked();
            }
        });
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetClaimOutboundPromo.this.getViewModel().failureCloseClicked();
            }
        });
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetClaimOutboundPromo.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetClaimOutboundPromo.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
