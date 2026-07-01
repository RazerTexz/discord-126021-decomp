package com.discord.utilities.rx;

import j0.k.b;
import rx.functions.FuncN;

/* JADX INFO: loaded from: classes2.dex */
public class ObservableWithLeadingEdgeThrottle$2 implements b {
    public final /* synthetic */ FuncN val$combineFunction;

    public ObservableWithLeadingEdgeThrottle$2(FuncN funcN) {
        this.val$combineFunction = funcN;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        return this.val$combineFunction.call((Object[]) obj);
    }
}
