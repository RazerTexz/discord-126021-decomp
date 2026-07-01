package com.discord.widgets.forums;

import com.discord.stores.StoreExperiments;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ForumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumUtils$observeCanCreateForumChannels$1 extends o implements Function0<Boolean> {
    public final /* synthetic */ StoreExperiments $experimentsStore;
    public final /* synthetic */ long $guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumUtils$observeCanCreateForumChannels$1(long j, StoreExperiments storeExperiments) {
        super(0);
        this.$guildId = j;
        this.$experimentsStore = storeExperiments;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return ForumUtils.access$canAccessForumChannels(ForumUtils.INSTANCE, this.$guildId, this.$experimentsStore);
    }
}
