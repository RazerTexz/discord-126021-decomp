package com.discord.i18n;

import b.a.k.d;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RenderContext.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RenderContext$a extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ Function1 $onClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RenderContext$a(Function1 function1) {
        super(1);
        this.$onClick = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Hook hook) {
        Hook hook2 = hook;
        m.checkNotNullParameter(hook2, "$receiver");
        d dVar = new d(this);
        Objects.requireNonNull(hook2);
        m.checkNotNullParameter(dVar, "onClick");
        hook2.clickHandler = new Hook$a(null, dVar);
        return Unit.a;
    }
}
