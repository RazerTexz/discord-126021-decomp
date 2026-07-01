package d0.e0.p.d.m0.i;

import b.d.b.a.outline;
import d0.e0.p.d.m0.i.ByteString3;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.r, reason: use source file name */
/* JADX INFO: compiled from: RopeByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public class RopeByteString extends ByteString3 {
    public static final int[] k;
    public final int l;
    public final ByteString3 m;
    public final ByteString3 n;
    public final int o;
    public final int p;
    public int q = 0;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.r$b */
    /* JADX INFO: compiled from: RopeByteString.java */
    public static class b {
        public final Stack<ByteString3> a = new Stack<>();

        public b(a aVar) {
        }

        public final void a(ByteString3 byteString3) {
            if (!byteString3.g()) {
                if (!(byteString3 instanceof RopeByteString)) {
                    String strValueOf = String.valueOf(byteString3.getClass());
                    throw new IllegalArgumentException(outline.J(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
                }
                RopeByteString ropeByteString = (RopeByteString) byteString3;
                a(ropeByteString.m);
                a(ropeByteString.n);
                return;
            }
            int size = byteString3.size();
            int[] iArr = RopeByteString.k;
            int iBinarySearch = Arrays.binarySearch(iArr, size);
            if (iBinarySearch < 0) {
                iBinarySearch = (-(iBinarySearch + 1)) - 1;
            }
            int i = iArr[iBinarySearch + 1];
            if (this.a.isEmpty() || this.a.peek().size() >= i) {
                this.a.push(byteString3);
                return;
            }
            int i2 = iArr[iBinarySearch];
            ByteString3 byteString3Pop = this.a.pop();
            while (!this.a.isEmpty() && this.a.peek().size() < i2) {
                byteString3Pop = new RopeByteString(this.a.pop(), byteString3Pop);
            }
            RopeByteString ropeByteString2 = new RopeByteString(byteString3Pop, byteString3);
            while (!this.a.isEmpty()) {
                int size2 = ropeByteString2.size();
                int[] iArr2 = RopeByteString.k;
                int iBinarySearch2 = Arrays.binarySearch(iArr2, size2);
                if (iBinarySearch2 < 0) {
                    iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
                }
                if (this.a.peek().size() >= iArr2[iBinarySearch2 + 1]) {
                    break;
                } else {
                    ropeByteString2 = new RopeByteString(this.a.pop(), ropeByteString2);
                }
            }
            this.a.push(ropeByteString2);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.r$c */
    /* JADX INFO: compiled from: RopeByteString.java */
    public static class c implements Iterator<LiteralByteString> {
        public final Stack<RopeByteString> j = new Stack<>();
        public LiteralByteString k;

        public c(ByteString3 byteString3, a aVar) {
            while (byteString3 instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString3;
                this.j.push(ropeByteString);
                byteString3 = ropeByteString.m;
            }
            this.k = (LiteralByteString) byteString3;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.k != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public LiteralByteString next() {
            LiteralByteString literalByteString;
            LiteralByteString literalByteString2 = this.k;
            if (literalByteString2 == null) {
                throw new NoSuchElementException();
            }
            while (!this.j.isEmpty()) {
                ByteString3 byteString3 = this.j.pop().n;
                while (byteString3 instanceof RopeByteString) {
                    RopeByteString ropeByteString = (RopeByteString) byteString3;
                    this.j.push(ropeByteString);
                    byteString3 = ropeByteString.m;
                }
                literalByteString = (LiteralByteString) byteString3;
                if (!literalByteString.isEmpty()) {
                    this.k = literalByteString;
                    return literalByteString2;
                }
            }
            literalByteString = null;
            this.k = literalByteString;
            return literalByteString2;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.r$d */
    /* JADX INFO: compiled from: RopeByteString.java */
    public class d implements ByteString3.a {
        public final c j;
        public ByteString3.a k;
        public int l;

        /* JADX WARN: Type inference failed for: r3v3, types: [d0.e0.p.d.m0.i.c$a] */
        public d(RopeByteString ropeByteString, a aVar) {
            c cVar = new c(ropeByteString, null);
            this.j = cVar;
            this.k = cVar.next().iterator2();
            this.l = ropeByteString.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.l > 0;
        }

        /* JADX WARN: Type inference failed for: r0v8, types: [d0.e0.p.d.m0.i.c$a] */
        @Override // d0.e0.p.d.m0.i.ByteString3.a
        public byte nextByte() {
            if (!this.k.hasNext()) {
                this.k = this.j.next().iterator2();
            }
            this.l--;
            return this.k.nextByte();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        k = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = k;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    public RopeByteString(ByteString3 byteString3, ByteString3 byteString4) {
        this.m = byteString3;
        this.n = byteString4;
        int size = byteString3.size();
        this.o = size;
        this.l = byteString4.size() + size;
        this.p = Math.max(byteString3.e(), byteString4.e()) + 1;
    }

    public static LiteralByteString l(ByteString3 byteString3, ByteString3 byteString4) {
        int size = byteString3.size();
        int size2 = byteString4.size();
        byte[] bArr = new byte[size + size2];
        byteString3.copyTo(bArr, 0, 0, size);
        byteString4.copyTo(bArr, 0, size, size2);
        return new LiteralByteString(bArr);
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public void d(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.o;
        if (i4 <= i5) {
            this.m.d(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.n.d(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.m.d(bArr, i, i2, i6);
            this.n.d(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public int e() {
        return this.p;
    }

    public boolean equals(Object obj) {
        int iJ;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString3)) {
            return false;
        }
        ByteString3 byteString3 = (ByteString3) obj;
        if (this.l != byteString3.size()) {
            return false;
        }
        if (this.l == 0) {
            return true;
        }
        if (this.q != 0 && (iJ = byteString3.j()) != 0 && this.q != iJ) {
            return false;
        }
        c cVar = new c(this, null);
        LiteralByteString next = cVar.next();
        c cVar2 = new c(byteString3, null);
        LiteralByteString next2 = cVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int iMin = Math.min(size, size2);
            if (!(i == 0 ? next.l(next2, i2, iMin) : next2.l(next, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.l;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                next = cVar.next();
                i = 0;
            } else {
                i += iMin;
            }
            if (iMin == size2) {
                next2 = cVar2.next();
                i2 = 0;
            } else {
                i2 += iMin;
            }
        }
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public boolean g() {
        return this.l >= k[this.p];
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public int h(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.o;
        if (i4 <= i5) {
            return this.m.h(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.n.h(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.n.h(this.m.h(i, i2, i6), 0, i3 - i6);
    }

    public int hashCode() {
        int iH = this.q;
        if (iH == 0) {
            int i = this.l;
            iH = h(i, 0, i);
            if (iH == 0) {
                iH = 1;
            }
            this.q = iH;
        }
        return iH;
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public int i(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.o;
        if (i4 <= i5) {
            return this.m.i(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.n.i(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.n.i(this.m.i(i, i2, i6), 0, i3 - i6);
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public boolean isValidUtf8() {
        int i = this.m.i(0, 0, this.o);
        ByteString3 byteString3 = this.n;
        return byteString3.i(i, 0, byteString3.size()) == 0;
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public int j() {
        return this.q;
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public void k(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.o;
        if (i3 <= i4) {
            this.m.k(outputStream, i, i2);
        } else {
            if (i >= i4) {
                this.n.k(outputStream, i - i4, i2);
                return;
            }
            int i5 = i4 - i;
            this.m.k(outputStream, i, i5);
            this.n.k(outputStream, 0, i2 - i5);
        }
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public int size() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    @Override // d0.e0.p.d.m0.i.ByteString3, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new d(this, null);
    }
}
