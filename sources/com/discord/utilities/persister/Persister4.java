package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import com.esotericsoftware.kryo.Kryo;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.persister.Persister$Companion$kryoConfig$1, reason: use source file name */
/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister4 extends Lambda implements Function1<Kryo, Unit> {
    public static final Persister4 INSTANCE = new Persister4();

    public Persister4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Kryo kryo) {
        invoke2(kryo);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Kryo kryo) {
        Intrinsics3.checkNotNullParameter(kryo, "it");
    }
}
