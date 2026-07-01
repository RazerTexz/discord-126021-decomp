package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.discord.utilities.persister.Persister$Companion$logger$1, reason: use source file name */
/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister6 extends Lambda implements Function3<Integer, String, Exception, Unit> {
    public static final Persister6 INSTANCE = new Persister6();

    public Persister6() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Exception exc) {
        invoke(num.intValue(), str, exc);
        return Unit.a;
    }

    public final void invoke(int i, String str, Exception exc) {
        Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
    }
}
