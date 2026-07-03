package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$Companion$logger$1 extends AbstractC12240o implements Function3<Integer, String, Exception, Unit> {
    public static final Persister$Companion$logger$1 INSTANCE = new Persister$Companion$logger$1();

    public Persister$Companion$logger$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Exception exc) {
        invoke(num.intValue(), str, exc);
        return Unit.f27425a;
    }

    public final void invoke(int i, String str, Exception exc) {
        C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
    }
}
