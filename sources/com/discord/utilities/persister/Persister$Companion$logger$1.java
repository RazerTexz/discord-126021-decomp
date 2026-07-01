package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$Companion$logger$1 extends o implements Function3<Integer, String, Exception, Unit> {
    public static final Persister$Companion$logger$1 INSTANCE = new Persister$Companion$logger$1();

    public Persister$Companion$logger$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Exception exc) {
        invoke(num.intValue(), str, exc);
        return Unit.a;
    }

    public final void invoke(int i, String str, Exception exc) {
        m.checkNotNullParameter(str, "<anonymous parameter 1>");
    }
}
