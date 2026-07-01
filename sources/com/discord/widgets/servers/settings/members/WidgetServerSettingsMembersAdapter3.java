package com.discord.widgets.servers.settings.members;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersAdapter$memberSelectedListener$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsMembersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembersAdapter3 extends Lambda implements Function2<Long, List<? extends Long>, Unit> {
    public static final WidgetServerSettingsMembersAdapter3 INSTANCE = new WidgetServerSettingsMembersAdapter3();

    public WidgetServerSettingsMembersAdapter3() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.a;
    }

    public final void invoke(long j, List<Long> list) {
        Intrinsics3.checkNotNullParameter(list, "<anonymous parameter 1>");
    }
}
