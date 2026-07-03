package p507d0.p513e0.p514p.p515d.p517m0.p543f.p546y;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.AbstractC11702a;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.y.a */
/* JADX INFO: compiled from: BuiltInsBinaryVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11700a extends AbstractC11702a {

    /* JADX INFO: renamed from: f */
    public static final a f23998f = new a(null);

    /* JADX INFO: renamed from: g */
    public static final C11700a f23999g = new C11700a(1, 0, 7);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.y.a$a */
    /* JADX INFO: compiled from: BuiltInsBinaryVersion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11700a readFrom(InputStream inputStream) {
            C12238m.checkNotNullParameter(inputStream, "stream");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            IntRange intRange = new IntRange(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                ((AbstractC12126c0) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] intArray = C12163u.toIntArray(arrayList);
            int[] iArr = new int[intArray.length];
            System.arraycopy(intArray, 0, iArr, 0, intArray.length);
            return new C11700a(iArr);
        }
    }

    static {
        new C11700a(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C11700a(int... iArr) {
        C12238m.checkNotNullParameter(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
    }

    public boolean isCompatible() {
        return m9813a(f23999g);
    }
}
