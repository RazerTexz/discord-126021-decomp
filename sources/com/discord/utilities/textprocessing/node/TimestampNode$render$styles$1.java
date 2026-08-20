package com.discord.utilities.textprocessing.node;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TimestampNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimestampNode$render$styles$1 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ TimestampNode.RenderContext $renderContext;
    public final /* synthetic */ TimestampNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimestampNode$render$styles$1(TimestampNode timestampNode, TimestampNode.RenderContext renderContext) {
        super(1);
        this.this$0 = timestampNode;
        this.$renderContext = renderContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        this.$renderContext.onTimestampClicked(this.this$0.getFull());
    }
}
