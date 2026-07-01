package com.discord.app;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppBottomSheet$b extends o implements Function0<AppLogger> {
    public final /* synthetic */ AppBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBottomSheet$b(AppBottomSheet appBottomSheet) {
        super(0);
        this.this$0 = appBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public AppLogger invoke() {
        return new AppLogger(this.this$0, null, false, 6);
    }
}
