package com.discord.widgets.servers.guildboost;

import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.discord.i18n.Hook;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost$onViewBound$4$2 extends o implements Function1<Hook, Unit> {
    public static final WidgetGuildBoost$onViewBound$4$2 INSTANCE = new WidgetGuildBoost$onViewBound$4$2();

    public WidgetGuildBoost$onViewBound$4$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        hook.styles.add(new StyleSpan(1));
        hook.styles.add(new ForegroundColorSpan(-65536));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }
}
