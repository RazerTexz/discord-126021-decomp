package com.discord.widgets.servers.settings.members;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsMembersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembersAdapter$memberSelectedListener$1 extends AbstractC12240o implements Function2<Long, List<? extends Long>, Unit> {
    public static final WidgetServerSettingsMembersAdapter$memberSelectedListener$1 INSTANCE = new WidgetServerSettingsMembersAdapter$memberSelectedListener$1();

    public WidgetServerSettingsMembersAdapter$memberSelectedListener$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.f27425a;
    }

    public final void invoke(long j, List<Long> list) {
        C12238m.checkNotNullParameter(list, "<anonymous parameter 1>");
    }
}
