package com.discord.panels;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: OverlappingPanelsLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlappingPanelsLayout$d extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $isFling;
    public final /* synthetic */ OverlappingPanelsLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout$d(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2) {
        super(0);
        this.this$0 = overlappingPanelsLayout;
        this.$isFling = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        OverlappingPanelsLayout.access$openEndPanel(this.this$0, this.$isFling);
        return Unit.a;
    }
}
