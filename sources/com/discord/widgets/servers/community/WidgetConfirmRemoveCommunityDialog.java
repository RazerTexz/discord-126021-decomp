package com.discord.widgets.servers.community;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetConfirmRemoveCommunityDialogBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetConfirmRemoveCommunityDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetConfirmRemoveCommunityDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetConfirmRemoveCommunityDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetConfirmRemoveCommunityDialogBinding;", 0)};

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
            C12238m.checkNotNullParameter(supportFragmentManager, "supportFragmentManager");
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
        super(C5419R.layout.widget_confirm_remove_community_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetConfirmRemoveCommunityDialog$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverviewViewModel.class), new C9347xb86cad10(this), new C0863f0(new WidgetConfirmRemoveCommunityDialog$viewModel$2(this)));
    }

    private final WidgetConfirmRemoveCommunityDialogBinding getBinding() {
        return (WidgetConfirmRemoveCommunityDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsCommunityOverviewViewModel getViewModel() {
        return (WidgetServerSettingsCommunityOverviewViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f16404c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetConfirmRemoveCommunityDialog.this.dismiss();
                WidgetConfirmRemoveCommunityDialog.this.getViewModel().disableCommunity();
            }
        });
        getBinding().f16403b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetConfirmRemoveCommunityDialog.this.dismiss();
            }
        });
    }
}
