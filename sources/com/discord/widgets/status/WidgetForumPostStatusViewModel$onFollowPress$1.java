package com.discord.widgets.status;

import android.content.Context;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel$onFollowPress$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ boolean $isFollowedThread;
    public final /* synthetic */ WidgetForumPostStatusViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatusViewModel$onFollowPress$1(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel, Context context, long j, boolean z2) {
        super(0);
        this.this$0 = widgetForumPostStatusViewModel;
        this.$context = context;
        this.$channelId = j;
        this.$isFollowedThread = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetForumPostStatusViewModel.access$toggleFollowPost(this.this$0, this.$context, this.$channelId, this.$isFollowedThread);
    }
}
