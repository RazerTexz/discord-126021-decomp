package com.discord.app;

import b.b.a.f.b;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppFragment$b extends o implements Function0<b> {
    public final /* synthetic */ AppFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFragment$b(AppFragment appFragment) {
        super(0);
        this.this$0 = appFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public b invoke() {
        return new b(this.this$0.requireContext(), null, null, 6);
    }
}
