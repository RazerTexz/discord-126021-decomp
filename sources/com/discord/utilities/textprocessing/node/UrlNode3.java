package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.textprocessing.node.UrlNode;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.discord.utilities.textprocessing.node.UrlNode$render$style$2, reason: use source file name */
/* JADX INFO: compiled from: UrlNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UrlNode3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ UrlNode.RenderContext $renderContext;
    public final /* synthetic */ String $safeUrl;
    public final /* synthetic */ UrlNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlNode3(UrlNode urlNode, UrlNode.RenderContext renderContext, String str) {
        super(1);
        this.this$0 = urlNode;
        this.$renderContext = renderContext;
        this.$safeUrl = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        Function3<Context, String, String, Unit> onClickUrl = this.$renderContext.getOnClickUrl();
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        onClickUrl.invoke(context, this.$safeUrl, this.this$0.mask);
    }
}
