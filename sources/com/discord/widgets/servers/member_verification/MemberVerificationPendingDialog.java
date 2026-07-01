package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.content.res.ColorStateList;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$attr;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetMemberVerificationPendingDialogBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(MemberVerificationPendingDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMemberVerificationPendingDialogBinding;", 0)};
    public static final MemberVerificationPendingDialog$Companion Companion = new MemberVerificationPendingDialog$Companion(null);
    private static final String INTENT_EXTRA_DIALOG_STATE = "INTENT_EXTRA_DIALOG_STATE";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public MemberVerificationPendingDialog() {
        super(R$layout.widget_member_verification_pending_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, MemberVerificationPendingDialog$binding$2.INSTANCE, null, 2, null);
        MemberVerificationPendingDialog$viewModel$2 memberVerificationPendingDialog$viewModel$2 = new MemberVerificationPendingDialog$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(MemberVerificationPendingViewModel.class), new MemberVerificationPendingDialog$appViewModels$$inlined$viewModels$1(g0Var), new i0(memberVerificationPendingDialog$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(MemberVerificationPendingDialog memberVerificationPendingDialog, MemberVerificationPendingViewModel$ViewState memberVerificationPendingViewModel$ViewState) {
        memberVerificationPendingDialog.configureUI(memberVerificationPendingViewModel$ViewState);
    }

    public static final /* synthetic */ MemberVerificationPendingViewModel access$getViewModel$p(MemberVerificationPendingDialog memberVerificationPendingDialog) {
        return memberVerificationPendingDialog.getViewModel();
    }

    private final void configureLoadedUI(MemberVerificationPendingViewModel$ViewState$Loaded viewState) {
        ImageView imageView = getBinding().f2492b;
        m.checkNotNullExpressionValue(imageView, "binding.memberVerificationPendingImg");
        imageView.setVisibility(viewState.getShowPendingImage() ? 0 : 8);
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.memberVerificationTertiaryBtn");
        textView.setVisibility(viewState.getShowTertiaryButton() ? 0 : 8);
        int iOrdinal = viewState.getDialogState().ordinal();
        int color = (iOrdinal == 2 || iOrdinal == 4) ? ColorCompat.getColor(getContext(), 2131100382) : ColorCompat.getThemedColor(getContext(), R$attr.color_brand_500);
        MaterialButton materialButton = getBinding().c;
        m.checkNotNullExpressionValue(materialButton, "binding.memberVerificationPrimaryBtn");
        materialButton.setBackgroundTintList(ColorStateList.valueOf(color));
        int iOrdinal2 = viewState.getDialogState().ordinal();
        if (iOrdinal2 == 0) {
            getBinding().f2492b.setImageResource(2131231686);
            TextView textView2 = getBinding().g;
            m.checkNotNullExpressionValue(textView2, "binding.pendingDialogTitle");
            textView2.setText(getString(2131892933));
            TextView textView3 = getBinding().f;
            m.checkNotNullExpressionValue(textView3, "binding.pendingDialogDesc");
            textView3.setText(getString(2131892932));
            MaterialButton materialButton2 = getBinding().c;
            m.checkNotNullExpressionValue(materialButton2, "binding.memberVerificationPrimaryBtn");
            materialButton2.setText(getString(2131892931));
            MaterialButton materialButton3 = getBinding().d;
            m.checkNotNullExpressionValue(materialButton3, "binding.memberVerificationSecondaryBtn");
            materialButton3.setText(getString(2131887437));
            getBinding().c.setOnClickListener(new MemberVerificationPendingDialog$configureLoadedUI$11(this));
            getBinding().d.setOnClickListener(new MemberVerificationPendingDialog$configureLoadedUI$12(this));
            return;
        }
        if (iOrdinal2 == 1) {
            getBinding().f2492b.setImageResource(2131231910);
            TextView textView4 = getBinding().g;
            m.checkNotNullExpressionValue(textView4, "binding.pendingDialogTitle");
            textView4.setText(getString(2131892894));
            TextView textView5 = getBinding().f;
            m.checkNotNullExpressionValue(textView5, "binding.pendingDialogDesc");
            textView5.setText(getString(2131892890));
            MaterialButton materialButton4 = getBinding().c;
            m.checkNotNullExpressionValue(materialButton4, "binding.memberVerificationPrimaryBtn");
            materialButton4.setText(getString(2131889794));
            getBinding().c.setOnClickListener(new MemberVerificationPendingDialog$configureLoadedUI$1(this));
            if (viewState.isPreviewEnabled()) {
                MaterialButton materialButton5 = getBinding().d;
                m.checkNotNullExpressionValue(materialButton5, "binding.memberVerificationSecondaryBtn");
                materialButton5.setVisibility(8);
                TextView textView6 = getBinding().e;
                m.checkNotNullExpressionValue(textView6, "binding.memberVerificationTertiaryBtn");
                textView6.setVisibility(8);
                return;
            }
            MaterialButton materialButton6 = getBinding().d;
            m.checkNotNullExpressionValue(materialButton6, "binding.memberVerificationSecondaryBtn");
            materialButton6.setVisibility(0);
            MaterialButton materialButton7 = getBinding().d;
            m.checkNotNullExpressionValue(materialButton7, "binding.memberVerificationSecondaryBtn");
            materialButton7.setText(getString(2131892809));
            getBinding().d.setOnClickListener(new MemberVerificationPendingDialog$configureLoadedUI$2(this));
            TextView textView7 = getBinding().e;
            m.checkNotNullExpressionValue(textView7, "binding.memberVerificationTertiaryBtn");
            textView7.setVisibility(0);
            TextView textView8 = getBinding().e;
            m.checkNotNullExpressionValue(textView8, "binding.memberVerificationTertiaryBtn");
            textView8.setText(getString(2131892536));
            getBinding().e.setOnClickListener(new MemberVerificationPendingDialog$configureLoadedUI$3(this));
            return;
        }
        if (iOrdinal2 == 2) {
            TextView textView9 = getBinding().g;
            m.checkNotNullExpressionValue(textView9, "binding.pendingDialogTitle");
            textView9.setText(getString(2131892884));
            TextView textView10 = getBinding().f;
            m.checkNotNullExpressionValue(textView10, "binding.pendingDialogDesc");
            textView10.setText(getString(2131892886));
            MaterialButton materialButton8 = getBinding().c;
            m.checkNotNullExpressionValue(materialButton8, "binding.memberVerificationPrimaryBtn");
            materialButton8.setText(getString(2131892888));
            MaterialButton materialButton9 = getBinding().d;
            m.checkNotNullExpressionValue(materialButton9, "binding.memberVerificationSecondaryBtn");
            materialButton9.setText(getString(2131892891));
            getBinding().c.setOnClickListener(new MemberVerificationPendingDialog$configureLoadedUI$4(this));
            getBinding().d.setOnClickListener(new MemberVerificationPendingDialog$configureLoadedUI$5(this));
            return;
        }
        if (iOrdinal2 != 3) {
            if (iOrdinal2 != 4) {
                return;
            }
            TextView textView11 = getBinding().g;
            m.checkNotNullExpressionValue(textView11, "binding.pendingDialogTitle");
            textView11.setText(getString(2131892887));
            TextView textView12 = getBinding().f;
            m.checkNotNullExpressionValue(textView12, "binding.pendingDialogDesc");
            textView12.setText(getString(2131892886));
            MaterialButton materialButton10 = getBinding().c;
            m.checkNotNullExpressionValue(materialButton10, "binding.memberVerificationPrimaryBtn");
            materialButton10.setText(getString(2131892892));
            MaterialButton materialButton11 = getBinding().d;
            m.checkNotNullExpressionValue(materialButton11, "binding.memberVerificationSecondaryBtn");
            materialButton11.setText(getString(2131892891));
            getBinding().c.setOnClickListener(new MemberVerificationPendingDialog$configureLoadedUI$9(this, viewState));
            getBinding().d.setOnClickListener(new MemberVerificationPendingDialog$configureLoadedUI$10(this));
            return;
        }
        TextView textView13 = getBinding().g;
        m.checkNotNullExpressionValue(textView13, "binding.pendingDialogTitle");
        textView13.setText(getString(2131892804));
        if (viewState.getRejectionReason() != null) {
            String rejectionReason = viewState.getRejectionReason();
            if (!(rejectionReason == null || rejectionReason.length() == 0)) {
                String str = getString(2131892803) + " " + viewState.getRejectionReason();
                TextView textView14 = getBinding().f;
                m.checkNotNullExpressionValue(textView14, "binding.pendingDialogDesc");
                textView14.setText(str);
            }
        }
        MaterialButton materialButton12 = getBinding().c;
        m.checkNotNullExpressionValue(materialButton12, "binding.memberVerificationPrimaryBtn");
        materialButton12.setText(getString(2131893499));
        MaterialButton materialButton13 = getBinding().d;
        m.checkNotNullExpressionValue(materialButton13, "binding.memberVerificationSecondaryBtn");
        materialButton13.setText(getString(2131892800));
        getBinding().c.setOnClickListener(new MemberVerificationPendingDialog$configureLoadedUI$7(this));
        getBinding().d.setOnClickListener(new MemberVerificationPendingDialog$configureLoadedUI$8(this));
    }

    private final void configureUI(MemberVerificationPendingViewModel$ViewState viewState) {
        if (!(viewState instanceof MemberVerificationPendingViewModel$ViewState$Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        configureLoadedUI((MemberVerificationPendingViewModel$ViewState$Loaded) viewState);
    }

    private final WidgetMemberVerificationPendingDialogBinding getBinding() {
        return (WidgetMemberVerificationPendingDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MemberVerificationPendingViewModel getViewModel() {
        return (MemberVerificationPendingViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, long j, MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState) {
        Companion.show(fragmentManager, j, memberVerificationPendingViewModel$DialogState);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<MemberVerificationPendingViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), MemberVerificationPendingDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new MemberVerificationPendingDialog$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), MemberVerificationPendingDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new MemberVerificationPendingDialog$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
