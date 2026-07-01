package com.discord.widgets.servers.community;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetConfirmRemoveCommunityDialogBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetConfirmRemoveCommunityDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetConfirmRemoveCommunityDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetConfirmRemoveCommunityDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetConfirmRemoveCommunityDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetConfirmRemoveCommunityDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager supportFragmentManager, long guildId) {
            Intrinsics3.checkNotNullParameter(supportFragmentManager, "supportFragmentManager");
            WidgetConfirmRemoveCommunityDialog widgetConfirmRemoveCommunityDialog = new WidgetConfirmRemoveCommunityDialog();
            Bundle bundle = new Bundle();
            bundle.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            widgetConfirmRemoveCommunityDialog.setArguments(bundle);
            widgetConfirmRemoveCommunityDialog.show(supportFragmentManager, WidgetConfirmRemoveCommunityDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetConfirmRemoveCommunityDialog() {
        super(R.layout.widget_confirm_remove_community_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetConfirmRemoveCommunityDialog2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverviewViewModel.class), new WidgetConfirmRemoveCommunityDialog$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetConfirmRemoveCommunityDialog3(this)));
    }

    private final WidgetConfirmRemoveCommunityDialogBinding getBinding() {
        return (WidgetConfirmRemoveCommunityDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsCommunityOverviewViewModel getViewModel() {
        return (WidgetServerSettingsCommunityOverviewViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetConfirmRemoveCommunityDialog.this.dismiss();
                WidgetConfirmRemoveCommunityDialog.this.getViewModel().disableCommunity();
            }
        });
        getBinding().f2353b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetConfirmRemoveCommunityDialog.this.dismiss();
            }
        });
    }
}
