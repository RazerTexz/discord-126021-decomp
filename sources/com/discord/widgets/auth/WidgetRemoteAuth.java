package com.discord.widgets.auth;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetRemoteAuthBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuth extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetRemoteAuth.class, "binding", "getBinding()Lcom/discord/databinding/WidgetRemoteAuthBinding;", 0)};
    public static final WidgetRemoteAuth$Companion Companion = new WidgetRemoteAuth$Companion(null);
    private static final String EXTRA_REMOTE_AUTH_FINGERPRINT = "REMOTE_AUTH_FINGERPRINT";
    private static final int VIEW_LOADED = 0;
    private static final int VIEW_LOADING = 2;
    private static final int VIEW_NOT_FOUND = 1;
    private static final int VIEW_SUCCEEDED = 3;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetRemoteAuth() {
        super(R$layout.widget_remote_auth);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetRemoteAuth$binding$2.INSTANCE, null, 2, null);
        WidgetRemoteAuth$viewModel$2 widgetRemoteAuth$viewModel$2 = new WidgetRemoteAuth$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetRemoteAuthViewModel.class), new WidgetRemoteAuth$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetRemoteAuth$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetRemoteAuth widgetRemoteAuth, WidgetRemoteAuthViewModel$ViewState widgetRemoteAuthViewModel$ViewState) {
        widgetRemoteAuth.configureUI(widgetRemoteAuthViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetRemoteAuthViewModel access$getViewModel$p(WidgetRemoteAuth widgetRemoteAuth) {
        return widgetRemoteAuth.getViewModel();
    }

    private final void configureUI(WidgetRemoteAuthViewModel$ViewState viewState) {
        if (m.areEqual(viewState, WidgetRemoteAuthViewModel$ViewState$Loading.INSTANCE)) {
            AppViewFlipper appViewFlipper = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.remoteAuthViewFlipper");
            appViewFlipper.setDisplayedChild(2);
            return;
        }
        if (m.areEqual(viewState, WidgetRemoteAuthViewModel$ViewState$Failed.INSTANCE)) {
            AppViewFlipper appViewFlipper2 = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.remoteAuthViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            getBinding().c.f219b.setOnClickListener(new WidgetRemoteAuth$configureUI$1(this));
            return;
        }
        if (m.areEqual(viewState, WidgetRemoteAuthViewModel$ViewState$Succeeded.INSTANCE)) {
            AppViewFlipper appViewFlipper3 = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.remoteAuthViewFlipper");
            appViewFlipper3.setDisplayedChild(3);
            getBinding().f2519b.f231b.setOnClickListener(new WidgetRemoteAuth$configureUI$2(this));
            return;
        }
        if (viewState instanceof WidgetRemoteAuthViewModel$ViewState$Loaded) {
            AppViewFlipper appViewFlipper4 = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper4, "binding.remoteAuthViewFlipper");
            appViewFlipper4.setDisplayedChild(0);
            WidgetRemoteAuthViewModel$ViewState$Loaded widgetRemoteAuthViewModel$ViewState$Loaded = (WidgetRemoteAuthViewModel$ViewState$Loaded) viewState;
            if (widgetRemoteAuthViewModel$ViewState$Loaded.getLoginAllowed()) {
                MaterialButton materialButton = getBinding().d.c;
                m.checkNotNullExpressionValue(materialButton, "binding.pendingLogin.remoteAuthLoginButton");
                materialButton.setEnabled(true);
                getBinding().d.c.setOnClickListener(new WidgetRemoteAuth$configureUI$3(this));
            } else {
                MaterialButton materialButton2 = getBinding().d.c;
                m.checkNotNullExpressionValue(materialButton2, "binding.pendingLogin.remoteAuthLoginButton");
                materialButton2.setEnabled(false);
            }
            getBinding().d.f225b.setOnClickListener(new WidgetRemoteAuth$configureUI$4(this));
            getBinding().d.d.setOnCheckedChangeListener(null);
            SwitchMaterial switchMaterial = getBinding().d.d;
            m.checkNotNullExpressionValue(switchMaterial, "binding.pendingLogin.remoteAuthTemporarySwitch");
            switchMaterial.setChecked(!widgetRemoteAuthViewModel$ViewState$Loaded.isTemporary());
            getBinding().d.d.setOnCheckedChangeListener(new WidgetRemoteAuth$configureUI$5(this));
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Observable<WidgetRemoteAuthViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetRemoteAuth.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetRemoteAuth$onViewBound$1(this), 60, (Object) null);
    }
}
