package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeElapsed;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$Companion$persistAll$1$1 extends AbstractC12240o implements Function1<Persister<?>, Unit> {
    public static final Persister$Companion$persistAll$1$1 INSTANCE = new Persister$Companion$persistAll$1$1();

    public Persister$Companion$persistAll$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Persister<?> persister) {
        invoke2(persister);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Persister<?> persister) {
        if (persister != null) {
            Clock clock = Persister.clock;
            if (clock == null) {
                C12238m.throwUninitializedPropertyAccessException("clock");
            }
            TimeElapsed timeElapsed = new TimeElapsed(clock, 0L, 2, null);
            persister.persist();
            if (timeElapsed.getMilliseconds() > 100) {
                Function3<Integer, String, Exception, Unit> logger = Persister.INSTANCE.getLogger();
                StringBuilder sbM833U = C1643a.m833U("Cached ");
                sbM833U.append(persister.getKey());
                sbM833U.append(" in ");
                sbM833U.append(timeElapsed.getSeconds());
                sbM833U.append(" seconds.");
                logger.invoke(4, sbM833U.toString(), null);
            }
        }
    }
}
