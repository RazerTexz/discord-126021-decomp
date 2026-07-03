package com.discord.utilities;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$3 */
/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6655x626dc25c extends AbstractC12240o implements Function1<Long, Boolean> {
    public final /* synthetic */ Set $directShareChannelIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6655x626dc25c(Set set) {
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
