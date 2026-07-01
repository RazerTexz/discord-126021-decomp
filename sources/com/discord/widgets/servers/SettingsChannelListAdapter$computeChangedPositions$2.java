package com.discord.widgets.servers;

import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsChannelListAdapter$computeChangedPositions$2 extends o implements Function1<Long, Long> {
    public static final SettingsChannelListAdapter$computeChangedPositions$2 INSTANCE = new SettingsChannelListAdapter$computeChangedPositions$2();

    public SettingsChannelListAdapter$computeChangedPositions$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Long invoke(long j) {
        if (j > 0) {
            return Long.valueOf(j);
        }
        return null;
    }
}
