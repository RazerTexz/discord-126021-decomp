package com.discord.widgets.settings.premium;

import android.content.Context;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetOutboundPromoTerms$renderContext$1$onClickUrl$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOutboundPromoTerms4 extends Lambda implements Function3<Context, String, String, Unit> {
    public static final WidgetOutboundPromoTerms4 INSTANCE = new WidgetOutboundPromoTerms4();

    public WidgetOutboundPromoTerms4() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
        invoke2(context, str, str2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context context, String str, String str2) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(str, "url");
        UriHandler.handle$default(UriHandler.INSTANCE, context, str, false, false, null, 28, null);
    }
}
