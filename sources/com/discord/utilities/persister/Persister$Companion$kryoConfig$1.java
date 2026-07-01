package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import com.esotericsoftware.kryo.Kryo;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$Companion$kryoConfig$1 extends o implements Function1<Kryo, Unit> {
    public static final Persister$Companion$kryoConfig$1 INSTANCE = new Persister$Companion$kryoConfig$1();

    public Persister$Companion$kryoConfig$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Kryo kryo) {
        invoke2(kryo);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Kryo kryo) {
        m.checkNotNullParameter(kryo, "it");
    }
}
