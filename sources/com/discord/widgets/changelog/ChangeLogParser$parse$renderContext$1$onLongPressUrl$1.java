package com.discord.widgets.changelog;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChangeLogParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangeLogParser$parse$renderContext$1$onLongPressUrl$1 extends AbstractC12240o implements Function1<String, Unit> {
    public final /* synthetic */ ChangeLogParser$parse$renderContext$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeLogParser$parse$renderContext$1$onLongPressUrl$1(ChangeLogParser$parse$renderContext$1 changeLogParser$parse$renderContext$1) {
        super(1);
        this.this$0 = changeLogParser$parse$renderContext$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        C12238m.checkNotNullParameter(str, "it");
        C0876m.m165c(this.this$0.$context, str, 0, 4);
    }
}
