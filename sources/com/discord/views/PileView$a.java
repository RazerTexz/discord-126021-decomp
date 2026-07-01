package com.discord.views;

import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class PileView$a extends o implements Function1<Integer, String> {
    public static final PileView$a j = new PileView$a(0);
    public static final PileView$a k = new PileView$a(1);
    public static final PileView$a l = new PileView$a(2);
    public final /* synthetic */ int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PileView$a(int i) {
        super(1);
        this.m = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(Integer num) {
        int i = this.m;
        if (i == 0) {
            num.intValue();
            return "asset://asset/images/default_avatar_0.jpg";
        }
        if (i == 1) {
            num.intValue();
            return "asset://asset/images/default_avatar_1.jpg";
        }
        if (i != 2) {
            throw null;
        }
        num.intValue();
        return "asset://asset/images/default_avatar_2.jpg";
    }
}
