package com.discord.widgets.settings.account.mfa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.WidgetEnableTwoFactorPasswordDialog;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEnableMfaStepsBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.steps.StepsView;
import com.discord.widgets.settings.account.mfa.WidgetEnableMFAViewModel;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFASteps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEnableMFASteps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int KEY_SCREEN = 2;
    private static final String STATE_TOTP_PASSWORD_KEY = "STATE_TOTP_PASSWORD_KEY";
    private static final String STATE_TOTP_SECRET_KEY = "STATE_TOTP_SECRET_KEY";
    public static final int SUCCESS_SCREEN = 3;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetEnableMFASteps.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentActivity fragmentActivityE = WidgetEnableMFASteps.this.e();
            if (fragmentActivityE != null) {
                fragmentActivityE.onBackPressed();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetEnableMFASteps.this.getViewModel().updateScreenIndex(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetEnableMFAViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetEnableMFAViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetEnableMFAViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            DimmerView.setDimmed$default(WidgetEnableMFASteps.this.getBinding().f2380b, viewState.isLoading(), false, 2, null);
            Integer screenIndex = viewState.getScreenIndex();
            if (screenIndex != null) {
                WidgetEnableMFASteps.this.getBinding().c.b(screenIndex.intValue());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$showPasswordModal$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "newPassword");
            WidgetEnableMFASteps.this.getViewModel().setPassword(str);
            AppFragment.hideKeyboard$default(WidgetEnableMFASteps.this, null, 1, null);
        }
    }

    public WidgetEnableMFASteps() {
        super(R.layout.widget_enable_mfa_steps);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableMFASteps2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new WidgetEnableMFASteps$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetEnableMFASteps3.INSTANCE));
    }

    private final WidgetEnableMfaStepsBinding getBinding() {
        return (WidgetEnableMfaStepsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    private final void showPasswordModal() {
        WidgetEnableTwoFactorPasswordDialog.Companion aVar = WidgetEnableTwoFactorPasswordDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        Objects.requireNonNull(aVar);
        Intrinsics3.checkNotNullParameter(childFragmentManager, "supportFragmentManager");
        Intrinsics3.checkNotNullParameter(anonymousClass1, "onValidPasswordEntered");
        WidgetEnableTwoFactorPasswordDialog widgetEnableTwoFactorPasswordDialog = new WidgetEnableTwoFactorPasswordDialog();
        widgetEnableTwoFactorPasswordDialog.onValidPasswordEntered = anonymousClass1;
        widgetEnableTwoFactorPasswordDialog.show(childFragmentManager, WidgetEnableTwoFactorPasswordDialog.class.getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics3.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TOTP_SECRET_KEY, getViewModel().getTotpSecret());
        outState.putString(STATE_TOTP_PASSWORD_KEY, getViewModel().getPassword());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.a(new StepsView.d(this, Collections2.listOf((Object[]) new StepsView.b.a[]{new StepsView.b.a(WidgetEnableMFADownload.class, 0, R.string.cancel, 0, null, null, null, null, false, false, false, 2042), new StepsView.b.a(WidgetEnableMFAKey.class, 0, 0, 0, null, null, null, null, false, false, false, 2046), new StepsView.b.a(WidgetEnableMFAInput.class, 0, 0, 0, null, null, null, null, false, false, false, 766), new StepsView.b.a(WidgetEnableMFASuccess.class, 0, 0, 0, null, null, null, null, false, false, false, 1022)})), new AnonymousClass1(), new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetEnableMFASteps.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        String string = savedInstanceState != null ? savedInstanceState.getString(STATE_TOTP_SECRET_KEY) : null;
        String string2 = savedInstanceState != null ? savedInstanceState.getString(STATE_TOTP_PASSWORD_KEY) : null;
        if (string != null) {
            getViewModel().setTotpSecret(string);
        } else {
            getViewModel().setTotpSecret(AuthUtils.INSTANCE.generateNewTotpKey());
        }
        if (string2 != null) {
            getViewModel().setPassword(string2);
        } else {
            showPasswordModal();
        }
    }
}
