package com.discord.widgets.user;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.user.WidgetPruneUsers$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetPruneUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsers6 extends Lambda implements Function0<WidgetPruneUsersViewModel> {
    public final /* synthetic */ WidgetPruneUsers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsers6(WidgetPruneUsers widgetPruneUsers) {
        super(0);
        this.this$0 = widgetPruneUsers;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetPruneUsersViewModel invoke() {
        return new WidgetPruneUsersViewModel(this.this$0.getArgumentsOrDefault().getLong("ARG_GUILD_ID", -1L), null, null, null, null, null, 62, null);
    }
}
