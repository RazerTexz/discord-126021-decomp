package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: UrlNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UrlNode$render$style$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ UrlNode$RenderContext $renderContext;
    public final /* synthetic */ String $safeUrl;
    public final /* synthetic */ UrlNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlNode$render$style$2(UrlNode urlNode, UrlNode$RenderContext urlNode$RenderContext, String str) {
        super(1);
        this.this$0 = urlNode;
        this.$renderContext = urlNode$RenderContext;
        this.$safeUrl = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        Function3<Context, String, String, Unit> onClickUrl = this.$renderContext.getOnClickUrl();
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        onClickUrl.invoke(context, this.$safeUrl, UrlNode.access$getMask$p(this.this$0));
    }
}
