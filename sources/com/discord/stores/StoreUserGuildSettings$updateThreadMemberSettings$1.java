package com.discord.stores;

import com.discord.api.thread.ThreadMember;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserGuildSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserGuildSettings$updateThreadMemberSettings$1 extends o implements Function1<ThreadMember, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ int $oldFlags;
    public final /* synthetic */ long $parentChannelId;
    public final /* synthetic */ StoreUserGuildSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserGuildSettings$updateThreadMemberSettings$1(StoreUserGuildSettings storeUserGuildSettings, long j, long j2, int i) {
        super(1);
        this.this$0 = storeUserGuildSettings;
        this.$channelId = j;
        this.$parentChannelId = j2;
        this.$oldFlags = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ThreadMember threadMember) {
        invoke2(threadMember);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ThreadMember threadMember) {
        m.checkNotNullParameter(threadMember, "threadMember");
        StoreUserGuildSettings.access$getAnalytics$p(this.this$0).onThreadNotificationSettingsUpdated(this.$channelId, this.$parentChannelId, threadMember.getFlags(), this.$oldFlags);
        StoreUserGuildSettings.access$getEventSubject$p(this.this$0).k.onNext((T) new StoreUserGuildSettings$Event$SettingsUpdated(StoreUserGuildSettings$SettingsUpdateType.THREAD));
    }
}
