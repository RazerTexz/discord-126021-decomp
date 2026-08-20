package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetRemoteAuthBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuth extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetRemoteAuth.class, "binding", "getBinding()Lcom/discord/databinding/WidgetRemoteAuthBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_REMOTE_AUTH_FINGERPRINT = "REMOTE_AUTH_FINGERPRINT";
    private static final int VIEW_LOADED = 0;
    private static final int VIEW_LOADING = 2;
    private static final int VIEW_NOT_FOUND = 1;
    private static final int VIEW_SUCCEEDED = 3;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetRemoteAuth.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, String fingerprint) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(fingerprint, "fingerprint");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra(WidgetRemoteAuth.EXTRA_REMOTE_AUTH_FINGERPRINT, fingerprint);
            C0870j.m156d(context, WidgetRemoteAuth.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuth$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetRemoteAuth.kt */
    public static final class C72641 extends AbstractC12240o implements Function1<WidgetRemoteAuthViewModel.ViewState, Unit> {
        public C72641() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetRemoteAuthViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetRemoteAuthViewModel.ViewState viewState) {
            WidgetRemoteAuth widgetRemoteAuth = WidgetRemoteAuth.this;
            C12238m.checkNotNullExpressionValue(viewState, "it");
            widgetRemoteAuth.configureUI(viewState);
        }
    }

    public WidgetRemoteAuth() {
        super(C5419R.layout.widget_remote_auth);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetRemoteAuth$binding$2.INSTANCE, null, 2, null);
        WidgetRemoteAuth$viewModel$2 widgetRemoteAuth$viewModel$2 = new WidgetRemoteAuth$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetRemoteAuthViewModel.class), new WidgetRemoteAuth$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetRemoteAuth$viewModel$2));
    }

    private final void configureUI(WidgetRemoteAuthViewModel.ViewState viewState) {
        if (C12238m.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Loading.INSTANCE)) {
            AppViewFlipper appViewFlipper = getBinding().f17410e;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.remoteAuthViewFlipper");
            appViewFlipper.setDisplayedChild(2);
            return;
        }
        if (C12238m.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Failed.INSTANCE)) {
            AppViewFlipper appViewFlipper2 = getBinding().f17410e;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.remoteAuthViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            getBinding().f17408c.f1327b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetRemoteAuth.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetRemoteAuth.this.requireActivity().finish();
                }
            });
            return;
        }
        if (C12238m.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Succeeded.INSTANCE)) {
            AppViewFlipper appViewFlipper3 = getBinding().f17410e;
            C12238m.checkNotNullExpressionValue(appViewFlipper3, "binding.remoteAuthViewFlipper");
            appViewFlipper3.setDisplayedChild(3);
            getBinding().f17407b.f1387b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetRemoteAuth.configureUI.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetRemoteAuth.this.requireActivity().finish();
                }
            });
            return;
        }
        if (viewState instanceof WidgetRemoteAuthViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper4 = getBinding().f17410e;
            C12238m.checkNotNullExpressionValue(appViewFlipper4, "binding.remoteAuthViewFlipper");
            appViewFlipper4.setDisplayedChild(0);
            WidgetRemoteAuthViewModel.ViewState.Loaded loaded = (WidgetRemoteAuthViewModel.ViewState.Loaded) viewState;
            if (loaded.getLoginAllowed()) {
                MaterialButton materialButton = getBinding().f17409d.f1360c;
                C12238m.checkNotNullExpressionValue(materialButton, "binding.pendingLogin.remoteAuthLoginButton");
                materialButton.setEnabled(true);
                getBinding().f17409d.f1360c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetRemoteAuth.configureUI.3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetRemoteAuth.this.getViewModel().remoteLogin();
                    }
                });
            } else {
                MaterialButton materialButton2 = getBinding().f17409d.f1360c;
                C12238m.checkNotNullExpressionValue(materialButton2, "binding.pendingLogin.remoteAuthLoginButton");
                materialButton2.setEnabled(false);
            }
            getBinding().f17409d.f1359b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetRemoteAuth.configureUI.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetRemoteAuth.this.getViewModel().cancelLogin();
                    WidgetRemoteAuth.this.requireActivity().finish();
                }
            });
            getBinding().f17409d.f1361d.setOnCheckedChangeListener(null);
            SwitchMaterial switchMaterial = getBinding().f17409d.f1361d;
            C12238m.checkNotNullExpressionValue(switchMaterial, "binding.pendingLogin.remoteAuthTemporarySwitch");
            switchMaterial.setChecked(!loaded.isTemporary());
            getBinding().f17409d.f1361d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.auth.WidgetRemoteAuth.configureUI.5
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    WidgetRemoteAuth.this.getViewModel().toggleTemporary(!z2);
                }
            });
        }
    }

    private final WidgetRemoteAuthBinding getBinding() {
        return (WidgetRemoteAuthBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetRemoteAuthViewModel getViewModel() {
        return (WidgetRemoteAuthViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Observable<WidgetRemoteAuthViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetRemoteAuth.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72641());
    }
}
