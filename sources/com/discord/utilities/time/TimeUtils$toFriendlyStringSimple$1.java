package com.discord.utilities.time;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TimeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimeUtils$toFriendlyStringSimple$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ String $argName;
    public final /* synthetic */ String $elapsedTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeUtils$toFriendlyStringSimple$1(String str, String str2) {
        super(1);
        this.$elapsedTime = str;
        this.$argName = str2;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        Map<String, String> map = renderContext.args;
        String str = this.$argName;
        String str2 = this.$elapsedTime;
        m.checkNotNullExpressionValue(str2, "elapsedTime");
        map.put(str, str2);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
