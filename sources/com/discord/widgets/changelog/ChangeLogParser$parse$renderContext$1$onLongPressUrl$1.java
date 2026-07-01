package com.discord.widgets.changelog;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChangeLogParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangeLogParser$parse$renderContext$1$onLongPressUrl$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ ChangeLogParser$parse$renderContext$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeLogParser$parse$renderContext$1$onLongPressUrl$1(ChangeLogParser$parse$renderContext$1 changeLogParser$parse$renderContext$1) {
        super(1);
        this.this$0 = changeLogParser$parse$renderContext$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "it");
        b.a.d.m.c(this.this$0.$context, str, 0, 4);
    }
}
