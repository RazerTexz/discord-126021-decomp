package com.discord.overlay;

import android.view.View;
import b.d.b.a.a;
import d0.j;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverlayService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayService$c extends o implements Function1<View, Unit> {
    public final /* synthetic */ OverlayService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayService$c(OverlayService overlayService) {
        super(1);
        this.this$0 = overlayService;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        m.checkNotNullParameter(view, "it");
        if (this.this$0.getOverlayManager().activeBubbles.isEmpty()) {
            throw new j(a.w("An operation is not implemented: ", "handle stop service"));
        }
        return Unit.a;
    }
}
