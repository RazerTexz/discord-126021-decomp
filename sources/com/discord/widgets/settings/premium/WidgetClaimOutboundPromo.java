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
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetClaimOutboundPromoBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel$Builder;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetClaimOutboundPromo.class, "binding", "getBinding()Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", 0)};
    public static final WidgetClaimOutboundPromo$Companion Companion = new WidgetClaimOutboundPromo$Companion(null);

    public WidgetClaimOutboundPromo() {
        super(R$layout.widget_claim_outbound_promo);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetClaimOutboundPromo$binding$2.INSTANCE, null, 2, null);
        WidgetClaimOutboundPromo$viewModel$2 widgetClaimOutboundPromo$viewModel$2 = new WidgetClaimOutboundPromo$viewModel$2(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ClaimOutboundPromoViewModel.class), new WidgetClaimOutboundPromo$appViewModels$$inlined$viewModels$1(new g0(this)), new i0(widgetClaimOutboundPromo$viewModel$2));
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel$Builder().setAllCornerSizes(DimenUtils.dpToPixels(4)).build());
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
        this.codeBoxBackground = materialShapeDrawable;
    }

    public static final /* synthetic */ void access$configureUi(WidgetClaimOutboundPromo widgetClaimOutboundPromo, ClaimOutboundPromoViewModel$ViewState claimOutboundPromoViewModel$ViewState) {
        widgetClaimOutboundPromo.configureUi(claimOutboundPromoViewModel$ViewState);
    }

    public static final /* synthetic */ ClaimStatus access$getClaimStatus$p(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
        return widgetClaimOutboundPromo.getClaimStatus();
    }

    public static final /* synthetic */ ClaimOutboundPromoViewModel access$getViewModel$p(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
        return widgetClaimOutboundPromo.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetClaimOutboundPromo widgetClaimOutboundPromo, ClaimOutboundPromoViewModel$Event claimOutboundPromoViewModel$Event) {
        widgetClaimOutboundPromo.handleEvent(claimOutboundPromoViewModel$Event);
    }

    private final void configureUi(ClaimOutboundPromoViewModel$ViewState viewState) {
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
        if (viewState instanceof ClaimOutboundPromoViewModel$ViewState$ClaimInProgress) {
            AppViewFlipper appViewFlipper = getBinding().g;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.claimPromoFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (!(viewState instanceof ClaimOutboundPromoViewModel$ViewState$Claimed)) {
            if (viewState instanceof ClaimOutboundPromoViewModel$ViewState$ClaimFailed) {
                AppViewFlipper appViewFlipper2 = getBinding().g;
                m.checkNotNullExpressionValue(appViewFlipper2, "binding.claimPromoFlipper");
                appViewFlipper2.setMeasureAllChildren(false);
                AppViewFlipper appViewFlipper3 = getBinding().g;
                m.checkNotNullExpressionValue(appViewFlipper3, "binding.claimPromoFlipper");
                appViewFlipper3.setDisplayedChild(2);
                setCancelable(true);
                return;
            }
            return;
        }
        TextView textView = getBinding().f2350b;
        m.checkNotNullExpressionValue(textView, "binding.claimPromoBody");
        ClaimOutboundPromoViewModel$ViewState$Claimed claimOutboundPromoViewModel$ViewState$Claimed = (ClaimOutboundPromoViewModel$ViewState$Claimed) viewState;
        textView.setText(claimOutboundPromoViewModel$ViewState$Claimed.getClaimedStatus().getBody());
        TextView textView2 = getBinding().c;
        m.checkNotNullExpressionValue(textView2, "binding.claimPromoCode");
        textView2.setText(claimOutboundPromoViewModel$ViewState$Claimed.getClaimedStatus().getCode());
        AppViewFlipper appViewFlipper4 = getBinding().g;
        m.checkNotNullExpressionValue(appViewFlipper4, "binding.claimPromoFlipper");
        appViewFlipper4.setDisplayedChild(1);
        setCancelable(true);
    }

    private final WidgetClaimOutboundPromoBinding getBinding() {
        return (WidgetClaimOutboundPromoBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ClaimStatus getClaimStatus() {
        Parcelable parcelable = getArgumentsOrDefault().getParcelable(ARG_CLAIM_STATUS);
        m.checkNotNull(parcelable);
        return (ClaimStatus) parcelable;
    }

    private final ClaimOutboundPromoViewModel getViewModel() {
        return (ClaimOutboundPromoViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(ClaimOutboundPromoViewModel$Event event) {
        Unit unit;
        if (event instanceof ClaimOutboundPromoViewModel$Event$Claimed) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(KEY_PROMO_CLAIMED, ((ClaimOutboundPromoViewModel$Event$Claimed) event).getClaimedStatus());
            unit = Unit.a;
            FragmentKt.setFragmentResult(this, KEY_PROMO_CLAIMED, bundle);
        } else if (event instanceof ClaimOutboundPromoViewModel$Event$CopyCode) {
            Object systemService = requireContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Promo Code", ((ClaimOutboundPromoViewModel$Event$CopyCode) event).getCode()));
            MaterialButton materialButton = getBinding().e;
            m.checkNotNullExpressionValue(materialButton, "binding.claimPromoCopyButton");
            b.n(materialButton, 2131887923, new Object[0], null, 4);
            setCodeBoxColor(ContextCompat.getColor(requireContext(), 2131100304));
            unit = Unit.a;
        } else if (event instanceof ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl) {
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            UriHandler.handle$default(uriHandler, contextRequireContext, ((ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl) event).getUrl(), false, false, null, 28, null);
            dismiss();
            unit = Unit.a;
        } else {
            if (!(event instanceof ClaimOutboundPromoViewModel$Event$Dismiss)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewCompat.setBackground(getBinding().d, this.codeBoxBackground);
        setCodeBoxColor(ColorCompat.getThemedColor(view, 2130969008));
        getBinding().e.setOnClickListener(new WidgetClaimOutboundPromo$onViewBound$1(this));
        getBinding().i.setOnClickListener(new WidgetClaimOutboundPromo$onViewBound$2(this));
        getBinding().h.setOnClickListener(new WidgetClaimOutboundPromo$onViewBound$3(this));
        getBinding().f.setOnClickListener(new WidgetClaimOutboundPromo$onViewBound$4(this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetClaimOutboundPromo.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetClaimOutboundPromo$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetClaimOutboundPromo.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetClaimOutboundPromo$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
