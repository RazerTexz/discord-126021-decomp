package d0.e0.p.d.m0.f.y;

import d0.t.c0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: BuiltInsBinaryVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a {
    public a$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final a readFrom(InputStream inputStream) {
        m.checkNotNullParameter(inputStream, "stream");
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        IntRange intRange = new IntRange(1, dataInputStream.readInt());
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((c0) it).nextInt();
            arrayList.add(Integer.valueOf(dataInputStream.readInt()));
        }
        int[] intArray = u.toIntArray(arrayList);
        int[] iArr = new int[intArray.length];
        System.arraycopy(intArray, 0, iArr, 0, intArray.length);
        return new a(iArr);
    }
}
