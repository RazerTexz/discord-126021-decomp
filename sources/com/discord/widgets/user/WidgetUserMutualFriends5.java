package com.discord.widgets.user;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMutualFriends$userId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends5 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetUserMutualFriends this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMutualFriends5(WidgetUserMutualFriends widgetUserMutualFriends) {
        super(0);
        this.this$0 = widgetUserMutualFriends;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_USER_ID", 0L);
    }
}
