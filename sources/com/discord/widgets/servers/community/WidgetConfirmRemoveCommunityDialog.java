package com.discord.widgets.servers.community;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetConfirmRemoveCommunityDialogBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetConfirmRemoveCommunityDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetConfirmRemoveCommunityDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetConfirmRemoveCommunityDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetConfirmRemoveCommunityDialogBinding;", 0)};
    public static final WidgetConfirmRemoveCommunityDialog$Companion Companion = new WidgetConfirmRemoveCommunityDialog$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetConfirmRemoveCommunityDialog() {
        super(R$layout.widget_confirm_remove_community_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetConfirmRemoveCommunityDialog$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverviewViewModel.class), new WidgetConfirmRemoveCommunityDialog$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetConfirmRemoveCommunityDialog$viewModel$2(this)));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetConfirmRemoveCommunityDialog widgetConfirmRemoveCommunityDialog) {
        return widgetConfirmRemoveCommunityDialog.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel access$getViewModel$p(WidgetConfirmRemoveCommunityDialog widgetConfirmRemoveCommunityDialog) {
        return widgetConfirmRemoveCommunityDialog.getViewModel();
    }

    private final WidgetConfirmRemoveCommunityDialogBinding getBinding() {
        return (WidgetConfirmRemoveCommunityDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsCommunityOverviewViewModel getViewModel() {
        return (WidgetServerSettingsCommunityOverviewViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnClickListener(new WidgetConfirmRemoveCommunityDialog$onViewBound$1(this));
        getBinding().f2353b.setOnClickListener(new WidgetConfirmRemoveCommunityDialog$onViewBound$2(this));
    }
}
