package com.discord.widgets.settings.premium;

import android.content.Context;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOutboundPromoTerms$renderContext$1$onClickUrl$1 extends o implements Function3<Context, String, String, Unit> {
    public static final WidgetOutboundPromoTerms$renderContext$1$onClickUrl$1 INSTANCE = new WidgetOutboundPromoTerms$renderContext$1$onClickUrl$1();

    public WidgetOutboundPromoTerms$renderContext$1$onClickUrl$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
        invoke2(context, str, str2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context context, String str, String str2) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(str, "url");
        UriHandler.handle$default(UriHandler.INSTANCE, context, str, false, false, null, 28, null);
    }
}
