package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.ConfirmRemovePermissionDialogBinding;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialog extends AppDialog {
    private static final String ARG_PERMISSION_OWNER = "ARG_PERMISSION_OWNER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(ConfirmRemovePermissionDialog.class, "binding", "getBinding()Lcom/discord/databinding/ConfirmRemovePermissionDialogBinding;", 0)};
    public static final ConfirmRemovePermissionDialog$Companion Companion = new ConfirmRemovePermissionDialog$Companion(null);

    public ConfirmRemovePermissionDialog() {
        super(R$layout.confirm_remove_permission_dialog);
        ConfirmRemovePermissionDialog$viewModel$2 confirmRemovePermissionDialog$viewModel$2 = new ConfirmRemovePermissionDialog$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ConfirmRemovePermissionDialogViewModel.class), new ConfirmRemovePermissionDialog$appViewModels$$inlined$viewModels$1(g0Var), new i0(confirmRemovePermissionDialog$viewModel$2));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, ConfirmRemovePermissionDialog$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(ConfirmRemovePermissionDialog confirmRemovePermissionDialog, ConfirmRemovePermissionDialogViewModel$ViewState confirmRemovePermissionDialogViewModel$ViewState) {
        confirmRemovePermissionDialog.configureUI(confirmRemovePermissionDialogViewModel$ViewState);
    }

    public static final /* synthetic */ long access$getChannelIdFromArgs(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        return confirmRemovePermissionDialog.getChannelIdFromArgs();
    }

    public static final /* synthetic */ PermissionOwner access$getPermissionOwnerFromArgs(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        return confirmRemovePermissionDialog.getPermissionOwnerFromArgs();
    }

    public static final /* synthetic */ ConfirmRemovePermissionDialogViewModel access$getViewModel$p(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        return confirmRemovePermissionDialog.getViewModel();
    }

    private final void configureUI(ConfirmRemovePermissionDialogViewModel$ViewState viewState) {
        Unit unit;
        if (viewState instanceof ConfirmRemovePermissionDialogViewModel$ViewState$Default) {
            getBinding().d.setIsLoading(((ConfirmRemovePermissionDialogViewModel$ViewState$Default) viewState).isSubmitting());
            unit = Unit.a;
        } else {
            if (!m.areEqual(viewState, ConfirmRemovePermissionDialogViewModel$ViewState$Complete.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final ConfirmRemovePermissionDialogBinding getBinding() {
        return (ConfirmRemovePermissionDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelIdFromArgs() {
        return requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }

    private final PermissionOwner getPermissionOwnerFromArgs() {
        Serializable serializable = requireArguments().getSerializable(ARG_PERMISSION_OWNER);
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.channels.permissions.PermissionOwner");
        return (PermissionOwner) serializable;
    }

    private final ConfirmRemovePermissionDialogViewModel getViewModel() {
        return (ConfirmRemovePermissionDialogViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        String username;
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), ConfirmRemovePermissionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ConfirmRemovePermissionDialog$onResume$1(this), 62, (Object) null);
        PermissionOwner permissionOwnerFromArgs = getPermissionOwnerFromArgs();
        if (permissionOwnerFromArgs instanceof PermissionOwner$Role) {
            username = ((PermissionOwner$Role) permissionOwnerFromArgs).getRole().getName();
        } else {
            if (!(permissionOwnerFromArgs instanceof PermissionOwner$Member)) {
                throw new NoWhenBranchMatchedException();
            }
            PermissionOwner$Member permissionOwner$Member = (PermissionOwner$Member) permissionOwnerFromArgs;
            String nickname = permissionOwner$Member.getNickname();
            username = nickname != null ? nickname : permissionOwner$Member.getUser().getUsername();
        }
        TextView textView = getBinding().f2091b;
        m.checkNotNullExpressionValue(textView, "binding.body");
        b.n(textView, 2131895631, new Object[]{username}, null, 4);
        getBinding().d.setOnClickListener(new ConfirmRemovePermissionDialog$onResume$2(this));
        getBinding().c.setOnClickListener(new ConfirmRemovePermissionDialog$onResume$3(this));
    }
}
