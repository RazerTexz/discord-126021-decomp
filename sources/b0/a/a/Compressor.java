package b0.a.a;

import android.graphics.Bitmap;
import b0.a.a.e.Compression;
import b0.a.a.e.DefaultConstraint;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b0.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: Compressor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Compressor extends Lambda implements Function1<Compression, Unit> {
    public static final Compressor j = new Compressor();

    public Compressor() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Compression compression) {
        Compression compression2 = compression;
        Intrinsics3.checkParameterIsNotNull(compression2, "$receiver");
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        Intrinsics3.checkParameterIsNotNull(compression2, "$this$default");
        Intrinsics3.checkParameterIsNotNull(compressFormat, "format");
        DefaultConstraint defaultConstraint = new DefaultConstraint(612, 816, compressFormat, 80);
        Objects.requireNonNull(compression2);
        Intrinsics3.checkParameterIsNotNull(defaultConstraint, "constraint");
        compression2.a.add(defaultConstraint);
        return Unit.a;
    }
}
