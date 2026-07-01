package b0.a.a;

import android.graphics.Bitmap$CompressFormat;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Compressor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends o implements Function1<b0.a.a.e.a, Unit> {
    public static final a j = new a();

    public a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(b0.a.a.e.a aVar) {
        b0.a.a.e.a aVar2 = aVar;
        m.checkParameterIsNotNull(aVar2, "$receiver");
        Bitmap$CompressFormat bitmap$CompressFormat = Bitmap$CompressFormat.JPEG;
        m.checkParameterIsNotNull(aVar2, "$this$default");
        m.checkParameterIsNotNull(bitmap$CompressFormat, "format");
        b0.a.a.e.c cVar = new b0.a.a.e.c(612, 816, bitmap$CompressFormat, 80);
        Objects.requireNonNull(aVar2);
        m.checkParameterIsNotNull(cVar, "constraint");
        aVar2.a.add(cVar);
        return Unit.a;
    }
}
