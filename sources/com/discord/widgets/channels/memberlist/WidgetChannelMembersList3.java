package com.discord.widgets.channels.memberlist;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelMembersList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersList3 extends Lambda implements Function0<WidgetChannelMembersListViewModel> {
    public static final WidgetChannelMembersList3 INSTANCE = new WidgetChannelMembersList3();

    public WidgetChannelMembersList3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelMembersListViewModel invoke() {
        return new WidgetChannelMembersListViewModel(null, null, null, null, 15, null);
    }
}
