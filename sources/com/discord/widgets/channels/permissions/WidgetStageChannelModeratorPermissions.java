package com.discord.widgets.channels.permissions;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetStageChannelModeratorPermissionsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStageChannelModeratorPermissions.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", 0)};

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetStageChannelModeratorPermissions() {
        super(R$layout.widget_stage_channel_moderator_permissions);
        WidgetStageChannelModeratorPermissions$viewModel$2 widgetStageChannelModeratorPermissions$viewModel$2 = new WidgetStageChannelModeratorPermissions$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetStageChannelModeratorPermissionsViewModel.class), new WidgetStageChannelModeratorPermissions$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetStageChannelModeratorPermissions$viewModel$2));
        this.channelId = g.lazy(new WidgetStageChannelModeratorPermissions$channelId$2(this));
        this.viewBinding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStageChannelModeratorPermissions$viewBinding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissionsViewModel$ViewState widgetStageChannelModeratorPermissionsViewModel$ViewState) {
        widgetStageChannelModeratorPermissions.configureUI(widgetStageChannelModeratorPermissionsViewModel$ViewState);
    }

    public static final /* synthetic */ void access$confirmRemoveModerator(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions, PermissionOwner permissionOwner) {
        widgetStageChannelModeratorPermissions.confirmRemoveModerator(permissionOwner);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
        return widgetStageChannelModeratorPermissions.getChannelId();
    }

    private final void configureUI(WidgetStageChannelModeratorPermissionsViewModel$ViewState viewState) {
        if (viewState instanceof WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid) {
            AddPermissionOwnerView addPermissionOwnerView = getViewBinding().f2652b;
            m.checkNotNullExpressionValue(addPermissionOwnerView, "viewBinding.addPermissionOwnerButton");
            WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid = (WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid) viewState;
            ViewExtensions.setEnabledAlpha$default(addPermissionOwnerView, widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid.getCanEditModerators(), 0.0f, 2, null);
            getViewBinding().f2652b.setOnClickListener(new WidgetStageChannelModeratorPermissions$configureUI$1(this, viewState));
            getViewBinding().d.setData(widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid.getRoleItems(), new WidgetStageChannelModeratorPermissions$configureUI$2(this));
            getViewBinding().c.setData(widgetStageChannelModeratorPermissionsViewModel$ViewState$Valid.getMemberItems(), new WidgetStageChannelModeratorPermissions$configureUI$3(this));
        }
    }

    private final void confirmRemoveModerator(PermissionOwner permissionOwner) {
        ConfirmRemovePermissionDialog$Companion confirmRemovePermissionDialog$Companion = ConfirmRemovePermissionDialog.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        confirmRemovePermissionDialog$Companion.show(permissionOwner, getChannelId(), parentFragmentManager);
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
        Observable<WidgetStageChannelModeratorPermissionsViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetStageChannelModeratorPermissions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStageChannelModeratorPermissions$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
