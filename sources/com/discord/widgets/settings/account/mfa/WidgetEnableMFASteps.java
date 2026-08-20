package com.discord.widgets.settings.account.mfa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEnableMfaStepsBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.steps.StepsView;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.C0842s;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFASteps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetEnableMFASteps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m156d(context, WidgetEnableMFASteps.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
    public static final class C97961 extends AbstractC12240o implements Function0<Unit> {
        public C97961() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentActivity fragmentActivityM95e = WidgetEnableMFASteps.this.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.onBackPressed();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
    public static final class C97972 extends AbstractC12240o implements Function1<Integer, Unit> {
        public C97972() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetEnableMFASteps.this.getViewModel().updateScreenIndex(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
    public static final class C97981 extends AbstractC12240o implements Function1<WidgetEnableMFAViewModel.ViewState, Unit> {
        public C97981() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetEnableMFAViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetEnableMFAViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            DimmerView.setDimmed$default(WidgetEnableMFASteps.this.getBinding().f16590b, viewState.isLoading(), false, 2, null);
            Integer screenIndex = viewState.getScreenIndex();
            if (screenIndex != null) {
                WidgetEnableMFASteps.this.getBinding().f16591c.m8610b(screenIndex.intValue());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$showPasswordModal$1 */
    /* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
    public static final class C97991 extends AbstractC12240o implements Function1<String, Unit> {
        public C97991() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "newPassword");
            WidgetEnableMFASteps.this.getViewModel().setPassword(str);
            AppFragment.hideKeyboard$default(WidgetEnableMFASteps.this, null, 1, null);
        }
    }

    public WidgetEnableMFASteps() {
        super(C5419R.layout.widget_enable_mfa_steps);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableMFASteps$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new C9794xbf65ddc5(this), new C0863f0(WidgetEnableMFASteps$viewModel$2.INSTANCE));
    }

    private final WidgetEnableMfaStepsBinding getBinding() {
        return (WidgetEnableMfaStepsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    private final void showPasswordModal() {
        C0842s.Companion aVar = C0842s.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        C97991 c97991 = new C97991();
        Objects.requireNonNull(aVar);
        C12238m.checkNotNullParameter(childFragmentManager, "supportFragmentManager");
        C12238m.checkNotNullParameter(c97991, "onValidPasswordEntered");
        C0842s c0842s = new C0842s();
        c0842s.onValidPasswordEntered = c97991;
        c0842s.show(childFragmentManager, C0842s.class.getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        C12238m.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TOTP_SECRET_KEY, getViewModel().getTotpSecret());
        outState.putString(STATE_TOTP_PASSWORD_KEY, getViewModel().getPassword());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f16591c.m8609a(new StepsView.C7125d(this, C12147n.listOf((Object[]) new StepsView.AbstractC7123b.a[]{new StepsView.AbstractC7123b.a(WidgetEnableMFADownload.class, 0, C5419R.string.cancel, 0, null, null, null, null, false, false, false, 2042), new StepsView.AbstractC7123b.a(WidgetEnableMFAKey.class, 0, 0, 0, null, null, null, null, false, false, false, 2046), new StepsView.AbstractC7123b.a(WidgetEnableMFAInput.class, 0, 0, 0, null, null, null, null, false, false, false, 766), new StepsView.AbstractC7123b.a(WidgetEnableMFASuccess.class, 0, 0, 0, null, null, null, null, false, false, false, 1022)})), new C97961(), new C97972());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetEnableMFASteps.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97981());
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
