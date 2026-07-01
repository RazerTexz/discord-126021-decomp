package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeElapsed;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$Companion$persistAll$1$1 extends o implements Function1<Persister<?>, Unit> {
    public static final Persister$Companion$persistAll$1$1 INSTANCE = new Persister$Companion$persistAll$1$1();

    public Persister$Companion$persistAll$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Persister<?> persister) {
        invoke2(persister);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Persister<?> persister) {
        if (persister != null) {
            Clock clockAccess$getClock$cp = Persister.access$getClock$cp();
            if (clockAccess$getClock$cp == null) {
                m.throwUninitializedPropertyAccessException("clock");
            }
            TimeElapsed timeElapsed = new TimeElapsed(clockAccess$getClock$cp, 0L, 2, null);
            Persister.access$persist(persister);
            if (timeElapsed.getMilliseconds() > 100) {
                Function3<Integer, String, Exception, Unit> logger = Persister.Companion.getLogger();
                StringBuilder sbU = a.U("Cached ");
                sbU.append(persister.getKey());
                sbU.append(" in ");
                sbU.append(timeElapsed.getSeconds());
                sbU.append(" seconds.");
                logger.invoke(4, sbU.toString(), null);
            }
        }
    }
}
