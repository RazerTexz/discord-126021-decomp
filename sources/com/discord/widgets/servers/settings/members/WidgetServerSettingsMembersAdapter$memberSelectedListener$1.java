package com.discord.widgets.servers.settings.members;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsMembersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembersAdapter$memberSelectedListener$1 extends o implements Function2<Long, List<? extends Long>, Unit> {
    public static final WidgetServerSettingsMembersAdapter$memberSelectedListener$1 INSTANCE = new WidgetServerSettingsMembersAdapter$memberSelectedListener$1();

    public WidgetServerSettingsMembersAdapter$memberSelectedListener$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.a;
    }

    public final void invoke(long j, List<Long> list) {
        m.checkNotNullParameter(list, "<anonymous parameter 1>");
    }
}
