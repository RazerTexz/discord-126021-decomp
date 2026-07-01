package com.discord.widgets.channels.permissions;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.ConfirmRemovePermissionDialogBinding;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialogViewModel;
import com.discord.widgets.channels.permissions.PermissionOwner;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialog extends AppDialog {
    private static final String ARG_PERMISSION_OWNER = "ARG_PERMISSION_OWNER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(ConfirmRemovePermissionDialog.class, "binding", "getBinding()Lcom/discord/databinding/ConfirmRemovePermissionDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(PermissionOwner permissionOwner, long channelId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
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

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ConfirmRemovePermissionDialogViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            ConfirmRemovePermissionDialog.this.configureUI(viewState);
        }
    }

    public ConfirmRemovePermissionDialog() {
        super(R.layout.confirm_remove_permission_dialog);
        ConfirmRemovePermissionDialog3 confirmRemovePermissionDialog3 = new ConfirmRemovePermissionDialog3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ConfirmRemovePermissionDialogViewModel.class), new ConfirmRemovePermissionDialog$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(confirmRemovePermissionDialog3));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, ConfirmRemovePermissionDialog2.INSTANCE, null, 2, null);
    }

    private final void configureUI(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
        Unit unit;
        if (viewState instanceof ConfirmRemovePermissionDialogViewModel.ViewState.Default) {
            getBinding().d.setIsLoading(((ConfirmRemovePermissionDialogViewModel.ViewState.Default) viewState).isSubmitting());
            unit = Unit.a;
        } else {
            if (!Intrinsics3.areEqual(viewState, ConfirmRemovePermissionDialogViewModel.ViewState.Complete.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) ConfirmRemovePermissionDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
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
        TextView textView = getBinding().f2091b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.body");
        FormatUtils.m(textView, R.string.settings_permissions_delete_body, new Object[]{username}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog.onResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfirmRemovePermissionDialog.this.getViewModel().submit();
            }
        });
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog.onResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfirmRemovePermissionDialog.this.dismiss();
            }
        });
    }
}
