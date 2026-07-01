package com.discord.views;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class PileView$b extends o implements Function0<String> {
    public static final PileView$b j = new PileView$b(0);
    public static final PileView$b k = new PileView$b(1);
    public static final PileView$b l = new PileView$b(2);
    public final /* synthetic */ int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PileView$b(int i) {
        super(0);
        this.m = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        int i = this.m;
        if (i == 0 || i == 1 || i == 2) {
            return "";
        }
        throw null;
    }
}
