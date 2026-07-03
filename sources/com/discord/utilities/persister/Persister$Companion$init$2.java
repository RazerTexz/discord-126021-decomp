package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$Companion$init$2 extends AbstractC12240o implements Function1<Boolean, Unit> {
    public static final Persister$Companion$init$2 INSTANCE = new Persister$Companion$init$2();

    public Persister$Companion$init$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        Persister.INSTANCE.persistAll();
    }
}
