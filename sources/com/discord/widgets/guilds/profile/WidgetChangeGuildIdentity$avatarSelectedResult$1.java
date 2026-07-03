package com.discord.widgets.guilds.profile;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$avatarSelectedResult$1 extends AbstractC12240o implements Function1<String, Unit> {
    public static final WidgetChangeGuildIdentity$avatarSelectedResult$1 INSTANCE = new WidgetChangeGuildIdentity$avatarSelectedResult$1();

    public WidgetChangeGuildIdentity$avatarSelectedResult$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        C12238m.checkNotNullParameter(str, "it");
    }
}
