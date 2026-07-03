package com.discord.widgets.channels.permissions;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.ConfirmRemovePermissionDialogBinding;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialogViewModel;
import com.discord.widgets.channels.permissions.PermissionOwner;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialog extends AppDialog {
    private static final String ARG_PERMISSION_OWNER = "ARG_PERMISSION_OWNER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(ConfirmRemovePermissionDialog.class, "binding", "getBinding()Lcom/discord/databinding/ConfirmRemovePermissionDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(PermissionOwner permissionOwner, long channelId, FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(permissionOwner, "permissionOwner");
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            ConfirmRemovePermissionDialog confirmRemovePermissionDialog = new ConfirmRemovePermissionDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable(ConfirmRemovePermissionDialog.ARG_PERMISSION_OWNER, permissionOwner);
            bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            confirmRemovePermissionDialog.setArguments(bundle);
            confirmRemovePermissionDialog.show(fragmentManager, ConfirmRemovePermissionDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog$onResume$1 */
    /* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
    public static final class C75191 extends AbstractC12240o implements Function1<ConfirmRemovePermissionDialogViewModel.ViewState, Unit> {
        public C75191() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            ConfirmRemovePermissionDialog.this.configureUI(viewState);
        }
    }

    public ConfirmRemovePermissionDialog() {
        super(C5419R.layout.confirm_remove_permission_dialog);
        ConfirmRemovePermissionDialog$viewModel$2 confirmRemovePermissionDialog$viewModel$2 = new ConfirmRemovePermissionDialog$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ConfirmRemovePermissionDialogViewModel.class), new C7518x3593037c(c0865g0), new C0869i0(confirmRemovePermissionDialog$viewModel$2));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, ConfirmRemovePermissionDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
        Unit unit;
        if (viewState instanceof ConfirmRemovePermissionDialogViewModel.ViewState.Default) {
            getBinding().f15024d.setIsLoading(((ConfirmRemovePermissionDialogViewModel.ViewState.Default) viewState).isSubmitting());
            unit = Unit.f27425a;
        } else {
            if (!C12238m.areEqual(viewState, ConfirmRemovePermissionDialogViewModel.ViewState.Complete.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            unit = Unit.f27425a;
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) ConfirmRemovePermissionDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75191());
        PermissionOwner permissionOwnerFromArgs = getPermissionOwnerFromArgs();
        if (permissionOwnerFromArgs instanceof PermissionOwner.Role) {
            username = ((PermissionOwner.Role) permissionOwnerFromArgs).getRole().getName();
        } else {
            if (!(permissionOwnerFromArgs instanceof PermissionOwner.Member)) {
                throw new NoWhenBranchMatchedException();
            }
            PermissionOwner.Member member = (PermissionOwner.Member) permissionOwnerFromArgs;
            String nickname = member.getNickname();
            username = nickname != null ? nickname : member.getUser().getUsername();
        }
        TextView textView = getBinding().f15022b;
        C12238m.checkNotNullExpressionValue(textView, "binding.body");
        C1107b.m221m(textView, C5419R.string.settings_permissions_delete_body, new Object[]{username}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f15024d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog.onResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfirmRemovePermissionDialog.this.getViewModel().submit();
            }
        });
        getBinding().f15023c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog.onResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfirmRemovePermissionDialog.this.dismiss();
            }
        });
    }
}
