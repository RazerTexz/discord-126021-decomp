package d0.e0.p.d.m0.f.y;

import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.y.a, reason: use source file name */
/* JADX INFO: compiled from: BuiltInsBinaryVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsBinaryVersion extends BinaryVersion {
    public static final a f = new a(null);
    public static final BuiltInsBinaryVersion g = new BuiltInsBinaryVersion(1, 0, 7);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.y.a$a */
    /* JADX INFO: compiled from: BuiltInsBinaryVersion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final BuiltInsBinaryVersion readFrom(InputStream inputStream) {
            Intrinsics3.checkNotNullParameter(inputStream, "stream");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            Ranges2 ranges2 = new Ranges2(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2, 10));
            Iterator<Integer> it = ranges2.iterator();
            while (it.hasNext()) {
                ((Iterators4) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] intArray = _Collections.toIntArray(arrayList);
            int[] iArr = new int[intArray.length];
            System.arraycopy(intArray, 0, iArr, 0, intArray.length);
            return new BuiltInsBinaryVersion(iArr);
        }
    }

    static {
        new BuiltInsBinaryVersion(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BuiltInsBinaryVersion(int... iArr) {
        Intrinsics3.checkNotNullParameter(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
    }

    public boolean isCompatible() {
        return a(g);
    }
}
