package com.discord.widgets.user;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetKickUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetKickUser$onViewBoundOrOnResume$2 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ String $userName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetKickUser$onViewBoundOrOnResume$2(String str) {
        super(1);
        this.$userName = str;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        Map<String, String> map = renderContext.args;
        String str = this.$userName;
        m.checkNotNullExpressionValue(str, "userName");
        map.put("user", str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
