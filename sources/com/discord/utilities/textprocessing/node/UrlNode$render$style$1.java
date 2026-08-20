package com.discord.utilities.textprocessing.node;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UrlNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UrlNode$render$style$1 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ UrlNode.RenderContext $renderContext;
    public final /* synthetic */ String $safeUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlNode$render$style$1(UrlNode.RenderContext renderContext, String str) {
        super(1);
        this.$renderContext = renderContext;
        this.$safeUrl = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        this.$renderContext.getOnLongPressUrl().invoke(this.$safeUrl);
    }
}
