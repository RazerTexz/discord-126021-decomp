package com.discord.widgets.changelog;

import android.content.Context;
import com.discord.utilities.uri.UriHandler;
import d0.t.g0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLogSpecial$onViewBound$1 extends o implements Function3<Context, String, String, Unit> {
    public final /* synthetic */ WidgetChangeLogSpecial this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeLogSpecial$onViewBound$1(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        super(3);
        this.this$0 = widgetChangeLogSpecial;
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
        WidgetChangeLogSpecial.track$default(this.this$0, "change_log_cta_clicked", g0.mapOf(d0.o.to("cta_type", "inline_link")), false, 4, null);
        UriHandler.handle$default(UriHandler.INSTANCE, context, str, false, false, null, 28, null);
    }
}
