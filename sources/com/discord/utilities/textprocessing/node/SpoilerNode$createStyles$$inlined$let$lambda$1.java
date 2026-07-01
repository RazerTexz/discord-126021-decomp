package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SpoilerNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpoilerNode$createStyles$$inlined$let$lambda$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function1 $handler;
    public final /* synthetic */ SpoilerNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpoilerNode$createStyles$$inlined$let$lambda$1(Function1 function1, SpoilerNode spoilerNode, Context context) {
        super(1);
        this.$handler = function1;
        this.this$0 = spoilerNode;
        this.$context$inlined = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        this.$handler.invoke(this.this$0);
    }
}
