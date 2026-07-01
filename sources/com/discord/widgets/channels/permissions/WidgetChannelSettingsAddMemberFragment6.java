package com.discord.widgets.channels.permissions;

import androidx.fragment.app.Fragment;
import androidx.view.ViewModelStoreOwner;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment6 extends Lambda implements Function0<ViewModelStoreOwner> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragment6(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        super(0);
        this.this$0 = widgetChannelSettingsAddMemberFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStoreOwner invoke() {
        Fragment parentFragment = this.this$0.getParentFragment();
        Objects.requireNonNull(parentFragment, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return parentFragment;
    }
}
