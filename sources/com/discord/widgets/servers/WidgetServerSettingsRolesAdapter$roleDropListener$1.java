package com.discord.widgets.servers;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter$roleDropListener$1 extends o implements Function1<Map<String, ? extends Integer>, Unit> {
    public static final WidgetServerSettingsRolesAdapter$roleDropListener$1 INSTANCE = new WidgetServerSettingsRolesAdapter$roleDropListener$1();

    public WidgetServerSettingsRolesAdapter$roleDropListener$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Integer> map) {
        invoke2((Map<String, Integer>) map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, Integer> map) {
        m.checkNotNullParameter(map, "it");
    }
}
