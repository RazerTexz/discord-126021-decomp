package com.discord.utilities.textprocessing.node;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.textprocessing.node.TimestampNode;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.textprocessing.node.TimestampNode$render$styles$1, reason: use source file name */
/* JADX INFO: compiled from: TimestampNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimestampNode2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ TimestampNode.RenderContext $renderContext;
    public final /* synthetic */ TimestampNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimestampNode2(TimestampNode timestampNode, TimestampNode.RenderContext renderContext) {
        super(1);
        this.this$0 = timestampNode;
        this.$renderContext = renderContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        this.$renderContext.onTimestampClicked(this.this$0.getFull());
    }
}
