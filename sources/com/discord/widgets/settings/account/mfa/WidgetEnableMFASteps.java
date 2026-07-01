package com.discord.widgets.settings.account.mfa;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.s;
import b.a.a.s$a;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEnableMfaStepsBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.steps.StepsView$b$a;
import com.discord.views.steps.StepsView$d;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFASteps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEnableMFASteps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", 0)};
    public static final WidgetEnableMFASteps$Companion Companion = new WidgetEnableMFASteps$Companion(null);
    public static final int KEY_SCREEN = 2;
    private static final String STATE_TOTP_PASSWORD_KEY = "STATE_TOTP_PASSWORD_KEY";
    private static final String STATE_TOTP_SECRET_KEY = "STATE_TOTP_SECRET_KEY";
    public static final int SUCCESS_SCREEN = 3;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetEnableMFASteps() {
        super(R$layout.widget_enable_mfa_steps);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableMFASteps$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new WidgetEnableMFASteps$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetEnableMFASteps$viewModel$2.INSTANCE));
    }

    public static final /* synthetic */ WidgetEnableMfaStepsBinding access$getBinding$p(WidgetEnableMFASteps widgetEnableMFASteps) {
        return widgetEnableMFASteps.getBinding();
    }

    public static final /* synthetic */ WidgetEnableMFAViewModel access$getViewModel$p(WidgetEnableMFASteps widgetEnableMFASteps) {
        return widgetEnableMFASteps.getViewModel();
    }

    private final WidgetEnableMfaStepsBinding getBinding() {
        return (WidgetEnableMfaStepsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    private final void showPasswordModal() {
        s$a s_a = s.k;
        FragmentManager childFragmentManager = getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        WidgetEnableMFASteps$showPasswordModal$1 widgetEnableMFASteps$showPasswordModal$1 = new WidgetEnableMFASteps$showPasswordModal$1(this);
        Objects.requireNonNull(s_a);
        m.checkNotNullParameter(childFragmentManager, "supportFragmentManager");
        m.checkNotNullParameter(widgetEnableMFASteps$showPasswordModal$1, "onValidPasswordEntered");
        s sVar = new s();
        sVar.onValidPasswordEntered = widgetEnableMFASteps$showPasswordModal$1;
        sVar.show(childFragmentManager, s.class.getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        m.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TOTP_SECRET_KEY, getViewModel().getTotpSecret());
        outState.putString(STATE_TOTP_PASSWORD_KEY, getViewModel().getPassword());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.a(new StepsView$d(this, n.listOf((Object[]) new StepsView$b$a[]{new StepsView$b$a(WidgetEnableMFADownload.class, 0, 2131887437, 0, null, null, null, null, false, false, false, 2042), new StepsView$b$a(WidgetEnableMFAKey.class, 0, 0, 0, null, null, null, null, false, false, false, 2046), new StepsView$b$a(WidgetEnableMFAInput.class, 0, 0, 0, null, null, null, null, false, false, false, 766), new StepsView$b$a(WidgetEnableMFASuccess.class, 0, 0, 0, null, null, null, null, false, false, false, 1022)})), new WidgetEnableMFASteps$onViewBound$1(this), new WidgetEnableMFASteps$onViewBound$2(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetEnableMFASteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetEnableMFASteps$onViewBoundOrOnResume$1(this), 62, (Object) null);
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
