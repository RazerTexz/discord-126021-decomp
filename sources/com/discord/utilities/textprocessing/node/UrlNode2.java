package com.discord.utilities.textprocessing.node;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.textprocessing.node.UrlNode;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.textprocessing.node.UrlNode$render$style$1, reason: use source file name */
/* JADX INFO: compiled from: UrlNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UrlNode2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ UrlNode.RenderContext $renderContext;
    public final /* synthetic */ String $safeUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlNode2(UrlNode.RenderContext renderContext, String str) {
        super(1);
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
        this.$renderContext.getOnLongPressUrl().invoke(this.$safeUrl);
    }
}
