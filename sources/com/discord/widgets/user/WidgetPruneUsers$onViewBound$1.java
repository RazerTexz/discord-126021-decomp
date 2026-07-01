package com.discord.widgets.user;

import android.content.Context;
import b.a.k.b;
import com.discord.R$plurals;
import com.discord.utilities.resources.StringResourceUtilsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetPruneUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsers$onViewBound$1 extends o implements Function2<Context, Integer, CharSequence> {
    public static final WidgetPruneUsers$onViewBound$1 INSTANCE = new WidgetPruneUsers$onViewBound$1();

    public WidgetPruneUsers$onViewBound$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ CharSequence invoke(Context context, Integer num) {
        return invoke(context, num.intValue());
    }

    public final CharSequence invoke(Context context, int i) {
        m.checkNotNullParameter(context, "$this$formatLastSeenDays");
        return b.h(context, 2131892517, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, R$plurals.last_seen_days, i, Integer.valueOf(i))}, null, 4);
    }
}
