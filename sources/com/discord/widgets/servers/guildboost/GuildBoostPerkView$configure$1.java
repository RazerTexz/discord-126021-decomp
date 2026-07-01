package com.discord.widgets.servers.guildboost;

import androidx.annotation.DrawableRes;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GuildBoostPerkView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostPerkView$configure$1 extends o implements Function2<Integer, Boolean, Integer> {
    public static final GuildBoostPerkView$configure$1 INSTANCE = new GuildBoostPerkView$configure$1();

    public GuildBoostPerkView$configure$1() {
        super(2);
    }

    public final int invoke(@DrawableRes int i, boolean z2) {
        if (z2) {
            return 2131231658;
        }
        return i;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(Integer num, Boolean bool) {
        return Integer.valueOf(invoke(num.intValue(), bool.booleanValue()));
    }
}
