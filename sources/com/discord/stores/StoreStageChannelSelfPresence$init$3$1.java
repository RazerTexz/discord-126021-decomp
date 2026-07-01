package com.discord.stores;

import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityType;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannelSelfPresence$init$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Boolean $showCurrentActivity;
    public final /* synthetic */ StoreStageChannelSelfPresence$init$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStageChannelSelfPresence$init$3$1(StoreStageChannelSelfPresence$init$3 storeStageChannelSelfPresence$init$3, Boolean bool) {
        super(0);
        this.this$0 = storeStageChannelSelfPresence$init$3;
        this.$showCurrentActivity = bool;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreUserPresence userPresence = this.this$0.this$0.getUserPresence();
        ActivityType activityType = ActivityType.LISTENING;
        Activity stageChannelActivity = this.this$0.this$0.getStageChannelActivity();
        Boolean bool = this.$showCurrentActivity;
        m.checkNotNullExpressionValue(bool, "showCurrentActivity");
        if (!bool.booleanValue()) {
            stageChannelActivity = null;
        }
        userPresence.updateActivity(activityType, stageChannelActivity, true);
    }
}
