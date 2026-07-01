package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetStageChannelModeratorPermissionsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet;
import com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStageChannelModeratorPermissions.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", 0)};

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<PermissionOwner, Unit> {
        public AnonymousClass2(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "confirmRemoveModerator", "confirmRemoveModerator(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
            invoke2(permissionOwner);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PermissionOwner permissionOwner) {
            Intrinsics3.checkNotNullParameter(permissionOwner, "p1");
            ((WidgetStageChannelModeratorPermissions) this.receiver).confirmRemoveModerator(permissionOwner);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<PermissionOwner, Unit> {
        public AnonymousClass3(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "confirmRemoveModerator", "confirmRemoveModerator(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
            invoke2(permissionOwner);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PermissionOwner permissionOwner) {
            Intrinsics3.checkNotNullParameter(permissionOwner, "p1");
            ((WidgetStageChannelModeratorPermissions) this.receiver).confirmRemoveModerator(permissionOwner);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetStageChannelModeratorPermissionsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetStageChannelModeratorPermissions) this.receiver).configureUI(viewState);
        }
    }

    public WidgetStageChannelModeratorPermissions() {
        super(R.layout.widget_stage_channel_moderator_permissions);
        WidgetStageChannelModeratorPermissions4 widgetStageChannelModeratorPermissions4 = new WidgetStageChannelModeratorPermissions4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetStageChannelModeratorPermissionsViewModel.class), new WidgetStageChannelModeratorPermissions$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetStageChannelModeratorPermissions4));
        this.channelId = LazyJVM.lazy(new WidgetStageChannelModeratorPermissions2(this));
        this.viewBinding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageChannelModeratorPermissions3.INSTANCE, null, 2, null);
    }

    private final void configureUI(final WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
        if (viewState instanceof WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) {
            AddPermissionOwnerView addPermissionOwnerView = getViewBinding().f2652b;
            Intrinsics3.checkNotNullExpressionValue(addPermissionOwnerView, "viewBinding.addPermissionOwnerButton");
            WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid valid = (WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) viewState;
            ViewExtensions.setEnabledAlpha$default(addPermissionOwnerView, valid.getCanEditModerators(), 0.0f, 2, null);
            getViewBinding().f2652b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    boolean canEditModerators = ((WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) viewState).getCanEditModerators();
                    if (!canEditModerators) {
                        if (canEditModerators) {
                            return;
                        }
                        Toast.makeText(WidgetStageChannelModeratorPermissions.this.getContext(), R.string.channel_permissions_cannot_edit_moderators, 0).show();
                    } else {
                        WidgetChannelSettingsAddMemberSheet.Companion companion = WidgetChannelSettingsAddMemberSheet.INSTANCE;
                        FragmentManager parentFragmentManager = WidgetStageChannelModeratorPermissions.this.getParentFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        companion.show(parentFragmentManager, WidgetStageChannelModeratorPermissions.this.getChannelId());
                    }
                }
            });
            getViewBinding().d.setData(valid.getRoleItems(), new AnonymousClass2(this));
            getViewBinding().c.setData(valid.getMemberItems(), new AnonymousClass3(this));
        }
    }

    private final void confirmRemoveModerator(PermissionOwner permissionOwner) {
        ConfirmRemovePermissionDialog.Companion companion = ConfirmRemovePermissionDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(permissionOwner, getChannelId(), parentFragmentManager);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetStageChannelModeratorPermissionsBinding getViewBinding() {
        return (WidgetStageChannelModeratorPermissionsBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetStageChannelModeratorPermissionsViewModel getViewModel() {
        return (WidgetStageChannelModeratorPermissionsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetStageChannelModeratorPermissionsViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetStageChannelModeratorPermissions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
