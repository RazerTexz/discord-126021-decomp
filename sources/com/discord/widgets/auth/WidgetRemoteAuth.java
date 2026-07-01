package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetRemoteAuthBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetRemoteAuthViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuth extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetRemoteAuth.class, "binding", "getBinding()Lcom/discord/databinding/WidgetRemoteAuthBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(fingerprint, "fingerprint");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra(WidgetRemoteAuth.EXTRA_REMOTE_AUTH_FINGERPRINT, fingerprint);
            AppScreen2.d(context, WidgetRemoteAuth.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuth$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetRemoteAuth.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetRemoteAuthViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetRemoteAuthViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetRemoteAuthViewModel.ViewState viewState) {
            WidgetRemoteAuth widgetRemoteAuth = WidgetRemoteAuth.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            widgetRemoteAuth.configureUI(viewState);
        }
    }

    public WidgetRemoteAuth() {
        super(R.layout.widget_remote_auth);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetRemoteAuth2.INSTANCE, null, 2, null);
        WidgetRemoteAuth3 widgetRemoteAuth3 = new WidgetRemoteAuth3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetRemoteAuthViewModel.class), new WidgetRemoteAuth$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetRemoteAuth3));
    }

    private final void configureUI(WidgetRemoteAuthViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Loading.INSTANCE)) {
            AppViewFlipper appViewFlipper = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.remoteAuthViewFlipper");
            appViewFlipper.setDisplayedChild(2);
            return;
        }
        if (Intrinsics3.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Failed.INSTANCE)) {
            AppViewFlipper appViewFlipper2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.remoteAuthViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            getBinding().c.f219b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetRemoteAuth.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetRemoteAuth.this.requireActivity().finish();
                }
            });
            return;
        }
        if (Intrinsics3.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Succeeded.INSTANCE)) {
            AppViewFlipper appViewFlipper3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.remoteAuthViewFlipper");
            appViewFlipper3.setDisplayedChild(3);
            getBinding().f2519b.f231b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetRemoteAuth.configureUI.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetRemoteAuth.this.requireActivity().finish();
                }
            });
            return;
        }
        if (viewState instanceof WidgetRemoteAuthViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.remoteAuthViewFlipper");
            appViewFlipper4.setDisplayedChild(0);
            WidgetRemoteAuthViewModel.ViewState.Loaded loaded = (WidgetRemoteAuthViewModel.ViewState.Loaded) viewState;
            if (loaded.getLoginAllowed()) {
                MaterialButton materialButton = getBinding().d.c;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.pendingLogin.remoteAuthLoginButton");
                materialButton.setEnabled(true);
                getBinding().d.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetRemoteAuth.configureUI.3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetRemoteAuth.this.getViewModel().remoteLogin();
                    }
                });
            } else {
                MaterialButton materialButton2 = getBinding().d.c;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.pendingLogin.remoteAuthLoginButton");
                materialButton2.setEnabled(false);
            }
            getBinding().d.f225b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetRemoteAuth.configureUI.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetRemoteAuth.this.getViewModel().cancelLogin();
                    WidgetRemoteAuth.this.requireActivity().finish();
                }
            });
            getBinding().d.d.setOnCheckedChangeListener(null);
            SwitchMaterial switchMaterial = getBinding().d.d;
            Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.pendingLogin.remoteAuthTemporarySwitch");
            switchMaterial.setChecked(!loaded.isTemporary());
            getBinding().d.d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.auth.WidgetRemoteAuth.configureUI.5
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Observable<WidgetRemoteAuthViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetRemoteAuth.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
