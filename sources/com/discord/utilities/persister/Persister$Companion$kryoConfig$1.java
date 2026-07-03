package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import com.esotericsoftware.kryo.Kryo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$Companion$kryoConfig$1 extends AbstractC12240o implements Function1<Kryo, Unit> {
    public static final Persister$Companion$kryoConfig$1 INSTANCE = new Persister$Companion$kryoConfig$1();

    public Persister$Companion$kryoConfig$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Kryo kryo) {
        invoke2(kryo);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Kryo kryo) {
        C12238m.checkNotNullParameter(kryo, "it");
    }
}
