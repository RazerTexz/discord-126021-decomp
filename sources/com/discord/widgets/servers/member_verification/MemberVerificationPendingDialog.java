package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetMemberVerificationPendingDialogBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel;
import com.google.android.material.button.MaterialButton;
import d0.t.CollectionsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(MemberVerificationPendingDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMemberVerificationPendingDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_DIALOG_STATE = "INTENT_EXTRA_DIALOG_STATE";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void enqueue$default(Companion companion, long j, MemberVerificationPendingViewModel.DialogState dialogState, int i, Object obj) {
            if ((i & 2) != 0) {
                dialogState = null;
            }
            companion.enqueue(j, dialogState);
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, MemberVerificationPendingViewModel.DialogState dialogState, int i, Object obj) {
            if ((i & 4) != 0) {
                dialogState = null;
            }
            companion.show(fragmentManager, j, dialogState);
        }

        public final void enqueue(long guildId, MemberVerificationPendingViewModel.DialogState dialogState) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            String strT = outline.t("MEMBERVERIFICATION-", guildId);
            notices.requestToShow(new StoreNotices.Notice(strT, null, 0L, 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new MemberVerificationPendingDialog2(guildId, dialogState, notices, strT), 150, null));
        }

        public final void show(FragmentManager supportFragmentManager, long guildId, MemberVerificationPendingViewModel.DialogState dialogState) {
            Intrinsics3.checkNotNullParameter(supportFragmentManager, "supportFragmentManager");
            MemberVerificationPendingDialog memberVerificationPendingDialog = new MemberVerificationPendingDialog();
            Bundle bundle = new Bundle();
            bundle.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            bundle.putSerializable(MemberVerificationPendingDialog.INTENT_EXTRA_DIALOG_STATE, dialogState);
            memberVerificationPendingDialog.setArguments(bundle);
            memberVerificationPendingDialog.show(supportFragmentManager, MemberVerificationPendingDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            MemberVerificationPendingViewModel.DialogState.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            MemberVerificationPendingViewModel.DialogState dialogState = MemberVerificationPendingViewModel.DialogState.CANCEL;
            iArr[dialogState.ordinal()] = 1;
            MemberVerificationPendingViewModel.DialogState dialogState2 = MemberVerificationPendingViewModel.DialogState.LEAVE;
            iArr[dialogState2.ordinal()] = 2;
            MemberVerificationPendingViewModel.DialogState.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[MemberVerificationPendingViewModel.DialogState.PENDING.ordinal()] = 1;
            iArr2[dialogState.ordinal()] = 2;
            iArr2[MemberVerificationPendingViewModel.DialogState.REJECTED.ordinal()] = 3;
            iArr2[dialogState2.ordinal()] = 4;
            iArr2[MemberVerificationPendingViewModel.DialogState.UPGRADE.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<MemberVerificationPendingViewModel.ViewState, Unit> {
        public AnonymousClass1(MemberVerificationPendingDialog memberVerificationPendingDialog) {
            super(1, memberVerificationPendingDialog, MemberVerificationPendingDialog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationPendingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MemberVerificationPendingViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((MemberVerificationPendingDialog) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<MemberVerificationPendingViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationPendingViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MemberVerificationPendingViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (!(event instanceof MemberVerificationPendingViewModel.Event.Success) && (event instanceof MemberVerificationPendingViewModel.Event.Error)) {
                AppToast.i(MemberVerificationPendingDialog.this, R.string.guild_settings_public_update_failed, 0, 4);
            }
        }
    }

    public MemberVerificationPendingDialog() {
        super(R.layout.widget_member_verification_pending_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, MemberVerificationPendingDialog3.INSTANCE, null, 2, null);
        MemberVerificationPendingDialog4 memberVerificationPendingDialog4 = new MemberVerificationPendingDialog4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(MemberVerificationPendingViewModel.class), new MemberVerificationPendingDialog$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(memberVerificationPendingDialog4));
    }

    private final void configureLoadedUI(final MemberVerificationPendingViewModel.ViewState.Loaded viewState) {
        ImageView imageView = getBinding().f2492b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.memberVerificationPendingImg");
        imageView.setVisibility(viewState.getShowPendingImage() ? 0 : 8);
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationTertiaryBtn");
        textView.setVisibility(viewState.getShowTertiaryButton() ? 0 : 8);
        int iOrdinal = viewState.getDialogState().ordinal();
        int color = (iOrdinal == 2 || iOrdinal == 4) ? ColorCompat.getColor(getContext(), R.color.status_red_500) : ColorCompat.getThemedColor(getContext(), R.attr.color_brand_500);
        MaterialButton materialButton = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.memberVerificationPrimaryBtn");
        materialButton.setBackgroundTintList(ColorStateList.valueOf(color));
        int iOrdinal2 = viewState.getDialogState().ordinal();
        if (iOrdinal2 == 0) {
            getBinding().f2492b.setImageResource(R.drawable.ic_community_update);
            TextView textView2 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.pendingDialogTitle");
            textView2.setText(getString(R.string.member_verification_warning_update_modal_title));
            TextView textView3 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.pendingDialogDesc");
            textView3.setText(getString(R.string.member_verification_warning_update_modal_desc));
            MaterialButton materialButton2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.memberVerificationPrimaryBtn");
            materialButton2.setText(getString(R.string.member_verification_warning_update));
            MaterialButton materialButton3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.memberVerificationSecondaryBtn");
            materialButton3.setText(getString(R.string.cancel));
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog.configureLoadedUI.11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Context contextRequireContext = MemberVerificationPendingDialog.this.requireContext();
                    Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    UriHandler.directToPlayStore$default(contextRequireContext, null, null, 6, null);
                }
            });
            getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog.configureLoadedUI.12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberVerificationPendingDialog.this.dismiss();
                }
            });
            return;
        }
        if (iOrdinal2 == 1) {
            getBinding().f2492b.setImageResource(R.drawable.ic_member_verification_pending);
            TextView textView4 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.pendingDialogTitle");
            textView4.setText(getString(R.string.member_verification_pending_application_modal_title));
            TextView textView5 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.pendingDialogDesc");
            textView5.setText(getString(R.string.member_verification_pending_application_modal_desc));
            MaterialButton materialButton4 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.memberVerificationPrimaryBtn");
            materialButton4.setText(getString(R.string.got_it));
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog.configureLoadedUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberVerificationPendingDialog.this.dismiss();
                }
            });
            if (viewState.isPreviewEnabled()) {
                MaterialButton materialButton5 = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(materialButton5, "binding.memberVerificationSecondaryBtn");
                materialButton5.setVisibility(8);
                TextView textView6 = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(textView6, "binding.memberVerificationTertiaryBtn");
                textView6.setVisibility(8);
                return;
            }
            MaterialButton materialButton6 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialButton6, "binding.memberVerificationSecondaryBtn");
            materialButton6.setVisibility(0);
            MaterialButton materialButton7 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialButton7, "binding.memberVerificationSecondaryBtn");
            materialButton7.setText(getString(R.string.member_verification_cancel_application));
            getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog.configureLoadedUI.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberVerificationPendingDialog.this.getViewModel().updateDialogState(MemberVerificationPendingViewModel.DialogState.CANCEL);
                }
            });
            TextView textView7 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.memberVerificationTertiaryBtn");
            textView7.setVisibility(0);
            TextView textView8 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.memberVerificationTertiaryBtn");
            textView8.setText(getString(R.string.leave_server));
            getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog.configureLoadedUI.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberVerificationPendingDialog.this.getViewModel().updateDialogState(MemberVerificationPendingViewModel.DialogState.LEAVE);
                }
            });
            return;
        }
        if (iOrdinal2 == 2) {
            TextView textView9 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView9, "binding.pendingDialogTitle");
            textView9.setText(getString(R.string.member_verification_pending_application_cancel_modal_title));
            TextView textView10 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView10, "binding.pendingDialogDesc");
            textView10.setText(getString(R.string.member_verification_pending_application_leave_server_modal_desc));
            MaterialButton materialButton8 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton8, "binding.memberVerificationPrimaryBtn");
            materialButton8.setText(getString(R.string.member_verification_pending_application_modal_cancel));
            MaterialButton materialButton9 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialButton9, "binding.memberVerificationSecondaryBtn");
            materialButton9.setText(getString(R.string.member_verification_pending_application_modal_dismiss));
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog.configureLoadedUI.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberVerificationPendingDialog.this.getViewModel().resetGuildJoinRequest();
                    MemberVerificationPendingDialog.this.dismiss();
                }
            });
            getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog.configureLoadedUI.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberVerificationPendingDialog.this.dismiss();
                }
            });
            return;
        }
        if (iOrdinal2 != 3) {
            if (iOrdinal2 != 4) {
                return;
            }
            TextView textView11 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView11, "binding.pendingDialogTitle");
            textView11.setText(getString(R.string.member_verification_pending_application_leave_server_modal_title));
            TextView textView12 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView12, "binding.pendingDialogDesc");
            textView12.setText(getString(R.string.member_verification_pending_application_leave_server_modal_desc));
            MaterialButton materialButton10 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton10, "binding.memberVerificationPrimaryBtn");
            materialButton10.setText(getString(R.string.member_verification_pending_application_modal_leave));
            MaterialButton materialButton11 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialButton11, "binding.memberVerificationSecondaryBtn");
            materialButton11.setText(getString(R.string.member_verification_pending_application_modal_dismiss));
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog.configureLoadedUI.9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (viewState.isPreviewEnabled()) {
                        MemberVerificationPendingDialog.this.getViewModel().deleteGuildJoinRequest();
                    } else {
                        MemberVerificationPendingDialog.this.getViewModel().leaveGuild();
                    }
                    MemberVerificationPendingDialog.this.dismiss();
                }
            });
            getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog.configureLoadedUI.10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberVerificationPendingDialog.this.dismiss();
                }
            });
            return;
        }
        TextView textView13 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView13, "binding.pendingDialogTitle");
        textView13.setText(getString(R.string.member_verification_application_rejected_title));
        if (viewState.getRejectionReason() != null) {
            String rejectionReason = viewState.getRejectionReason();
            if (!(rejectionReason == null || rejectionReason.length() == 0)) {
                String str = getString(R.string.member_verification_application_rejected_reason) + " " + viewState.getRejectionReason();
                TextView textView14 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(textView14, "binding.pendingDialogDesc");
                textView14.setText(str);
            }
        }
        MaterialButton materialButton12 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton12, "binding.memberVerificationPrimaryBtn");
        materialButton12.setText(getString(R.string.okay));
        MaterialButton materialButton13 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialButton13, "binding.memberVerificationSecondaryBtn");
        materialButton13.setText(getString(R.string.member_verification_application_reapply));
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog.configureLoadedUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberVerificationPendingDialog.this.dismiss();
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog.configureLoadedUI.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberVerificationPendingDialog.this.getViewModel().resetGuildJoinRequest();
                MemberVerificationPendingDialog.this.dismiss();
            }
        });
    }

    private final void configureUI(MemberVerificationPendingViewModel.ViewState viewState) {
        if (!(viewState instanceof MemberVerificationPendingViewModel.ViewState.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        configureLoadedUI((MemberVerificationPendingViewModel.ViewState.Loaded) viewState);
    }

    private final WidgetMemberVerificationPendingDialogBinding getBinding() {
        return (WidgetMemberVerificationPendingDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MemberVerificationPendingViewModel getViewModel() {
        return (MemberVerificationPendingViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, long j, MemberVerificationPendingViewModel.DialogState dialogState) {
        INSTANCE.show(fragmentManager, j, dialogState);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<MemberVerificationPendingViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) MemberVerificationPendingDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) MemberVerificationPendingDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
