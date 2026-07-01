package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetMemberVerificationSuccessBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(MemberVerificationSuccessDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMemberVerificationSuccessBinding;", 0)};
    public static final MemberVerificationSuccessDialog$Companion Companion = new MemberVerificationSuccessDialog$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public MemberVerificationSuccessDialog() {
        super(R$layout.widget_member_verification_success);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, MemberVerificationSuccessDialog$binding$2.INSTANCE, null, 2, null);
        MemberVerificationSuccessDialog$viewModel$2 memberVerificationSuccessDialog$viewModel$2 = new MemberVerificationSuccessDialog$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(MemberVerificationSuccessViewModel.class), new MemberVerificationSuccessDialog$appViewModels$$inlined$viewModels$1(g0Var), new i0(memberVerificationSuccessDialog$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(MemberVerificationSuccessDialog memberVerificationSuccessDialog, MemberVerificationSuccessViewModel$ViewState memberVerificationSuccessViewModel$ViewState) {
        memberVerificationSuccessDialog.configureUI(memberVerificationSuccessViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(MemberVerificationSuccessDialog memberVerificationSuccessDialog) {
        return memberVerificationSuccessDialog.getArgumentsOrDefault();
    }

    public static final /* synthetic */ MemberVerificationSuccessViewModel access$getViewModel$p(MemberVerificationSuccessDialog memberVerificationSuccessDialog) {
        return memberVerificationSuccessDialog.getViewModel();
    }

    private final void configureLoadedUI(MemberVerificationSuccessViewModel$ViewState$Loaded viewState) {
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.memberVerificationGuildName");
        textView.setText(b.k(this, 2131892669, new Object[]{viewState.getGuildName()}, null, 4));
        getBinding().f2494b.setOnClickListener(new MemberVerificationSuccessDialog$configureLoadedUI$1(this));
    }

    private final void configureUI(MemberVerificationSuccessViewModel$ViewState viewState) {
        if (viewState instanceof MemberVerificationSuccessViewModel$ViewState$Loaded) {
            configureLoadedUI((MemberVerificationSuccessViewModel$ViewState$Loaded) viewState);
        } else {
            if (!(viewState instanceof MemberVerificationSuccessViewModel$ViewState$Acked)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
        }
    }

    private final WidgetMemberVerificationSuccessBinding getBinding() {
        return (WidgetMemberVerificationSuccessBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MemberVerificationSuccessViewModel getViewModel() {
        return (MemberVerificationSuccessViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<MemberVerificationSuccessViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), MemberVerificationSuccessDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new MemberVerificationSuccessDialog$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
