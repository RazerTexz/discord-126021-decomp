package p492b0.p493a.p494a;

import android.graphics.Bitmap;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p492b0.p493a.p494a.p495e.C5314a;
import p492b0.p493a.p494a.p495e.C5316c;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b0.a.a.a */
/* JADX INFO: compiled from: Compressor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5310a extends AbstractC12240o implements Function1<C5314a, Unit> {

    /* JADX INFO: renamed from: j */
    public static final C5310a f14501j = new C5310a();

    public C5310a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(C5314a c5314a) {
        C5314a c5314a2 = c5314a;
        C12238m.checkParameterIsNotNull(c5314a2, "$receiver");
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        C12238m.checkParameterIsNotNull(c5314a2, "$this$default");
        C12238m.checkParameterIsNotNull(compressFormat, "format");
        C5316c c5316c = new C5316c(612, 816, compressFormat, 80);
        Objects.requireNonNull(c5314a2);
        C12238m.checkParameterIsNotNull(c5316c, "constraint");
        c5314a2.f14505a.add(c5316c);
        return Unit.f27425a;
    }
}
