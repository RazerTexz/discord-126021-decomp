package com.discord.utilities;

import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$3 extends o implements Function1<Long, Boolean> {
    public final /* synthetic */ Set $directShareChannelIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$3(Set set) {
        super(1);
        this.$directShareChannelIds = set;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return Boolean.valueOf(invoke(l.longValue()));
    }

    public final boolean invoke(long j) {
        return !this.$directShareChannelIds.contains(Long.valueOf(j));
    }
}
