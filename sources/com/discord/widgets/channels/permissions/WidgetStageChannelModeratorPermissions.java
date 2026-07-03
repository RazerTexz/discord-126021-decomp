package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetStageChannelModeratorPermissionsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet;
import com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetStageChannelModeratorPermissions.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", 0)};

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$2 */
    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
    public static final /* synthetic */ class C75622 extends C12236k implements Function1<PermissionOwner, Unit> {
        public C75622(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "confirmRemoveModerator", "confirmRemoveModerator(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
            invoke2(permissionOwner);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PermissionOwner permissionOwner) {
            C12238m.checkNotNullParameter(permissionOwner, "p1");
            ((WidgetStageChannelModeratorPermissions) this.receiver).confirmRemoveModerator(permissionOwner);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$3 */
    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
    public static final /* synthetic */ class C75633 extends C12236k implements Function1<PermissionOwner, Unit> {
        public C75633(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "confirmRemoveModerator", "confirmRemoveModerator(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
            invoke2(permissionOwner);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PermissionOwner permissionOwner) {
            C12238m.checkNotNullParameter(permissionOwner, "p1");
            ((WidgetStageChannelModeratorPermissions) this.receiver).confirmRemoveModerator(permissionOwner);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
    public static final /* synthetic */ class C75641 extends C12236k implements Function1<WidgetStageChannelModeratorPermissionsViewModel.ViewState, Unit> {
        public C75641(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetStageChannelModeratorPermissions) this.receiver).configureUI(viewState);
        }
    }

    public WidgetStageChannelModeratorPermissions() {
        super(C5419R.layout.widget_stage_channel_moderator_permissions);
        WidgetStageChannelModeratorPermissions$viewModel$2 widgetStageChannelModeratorPermissions$viewModel$2 = new WidgetStageChannelModeratorPermissions$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetStageChannelModeratorPermissionsViewModel.class), new C7560xfc95c629(c0865g0), new C0869i0(widgetStageChannelModeratorPermissions$viewModel$2));
        this.channelId = C12083g.lazy(new WidgetStageChannelModeratorPermissions$channelId$2(this));
        this.viewBinding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStageChannelModeratorPermissions$viewBinding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI(final WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
        if (viewState instanceof WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) {
            AddPermissionOwnerView addPermissionOwnerView = getViewBinding().f18152b;
            C12238m.checkNotNullExpressionValue(addPermissionOwnerView, "viewBinding.addPermissionOwnerButton");
            WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid valid = (WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) viewState;
            ViewExtensions.setEnabledAlpha$default(addPermissionOwnerView, valid.getCanEditModerators(), 0.0f, 2, null);
            getViewBinding().f18152b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    boolean canEditModerators = ((WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) viewState).getCanEditModerators();
                    if (!canEditModerators) {
                        if (canEditModerators) {
                            return;
                        }
                        Toast.makeText(WidgetStageChannelModeratorPermissions.this.getContext(), C5419R.string.channel_permissions_cannot_edit_moderators, 0).show();
                    } else {
                        WidgetChannelSettingsAddMemberSheet.Companion companion = WidgetChannelSettingsAddMemberSheet.INSTANCE;
                        FragmentManager parentFragmentManager = WidgetStageChannelModeratorPermissions.this.getParentFragmentManager();
                        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        companion.show(parentFragmentManager, WidgetStageChannelModeratorPermissions.this.getChannelId());
                    }
                }
            });
            getViewBinding().f18154d.setData(valid.getRoleItems(), new C75622(this));
            getViewBinding().f18153c.setData(valid.getMemberItems(), new C75633(this));
        }
    }

    private final void confirmRemoveModerator(PermissionOwner permissionOwner) {
        ConfirmRemovePermissionDialog.Companion companion = ConfirmRemovePermissionDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        Observable<WidgetStageChannelModeratorPermissionsViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetStageChannelModeratorPermissions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75641(this));
    }
}
