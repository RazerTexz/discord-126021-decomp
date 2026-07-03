package com.discord.widgets.servers.community;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsEnableCommunityBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Lazy;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12216a0;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsEnableCommunity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEnableCommunityBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetServerSettingsEnableCommunity() {
        super(C5419R.layout.widget_server_settings_enable_community);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEnableCommunity$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new C9392x6fecf2bb(this), new C0863f0(WidgetServerSettingsEnableCommunity$viewModel$2.INSTANCE));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsEnableCommunity$loggingConfig$1.INSTANCE, 3);
    }

    private final WidgetServerSettingsEnableCommunityBinding getBinding() {
        return (WidgetServerSettingsEnableCommunityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f17659b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunity.onViewBoundOrOnResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsEnableCommunity.this.getViewModel().updateCurrentPage(1);
            }
        });
    }
}
