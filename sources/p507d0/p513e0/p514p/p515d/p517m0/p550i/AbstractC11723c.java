package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import com.adjust.sdk.Constants;
import com.google.android.material.badge.BadgeDrawable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11738r;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.c */
/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11723c implements Iterable<Byte> {

    /* JADX INFO: renamed from: j */
    public static final AbstractC11723c f24100j = new C11733m(new byte[0]);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.c$a */
    /* JADX INFO: compiled from: ByteString.java */
    public interface a extends Iterator<Byte> {
        byte nextByte();
    }

    /* JADX INFO: renamed from: c */
    public static AbstractC11723c m9823c(Iterator<AbstractC11723c> it, int i) {
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        return m9823c(it, i2).concat(m9823c(it, i - i2));
    }

    public static AbstractC11723c copyFrom(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new C11733m(bArr2);
    }

    public static AbstractC11723c copyFromUtf8(String str) {
        try {
            return new C11733m(str.getBytes(Constants.ENCODING));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static b newOutput() {
        return new b(128);
    }

    public AbstractC11723c concat(AbstractC11723c abstractC11723c) {
        int size = size();
        int size2 = abstractC11723c.size();
        if (((long) size) + ((long) size2) >= 2147483647L) {
            throw new IllegalArgumentException(C1643a.m853h(53, "ByteString would be too long: ", size, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, size2));
        }
        int[] iArr = C11738r.f24154k;
        C11738r c11738r = this instanceof C11738r ? (C11738r) this : null;
        if (abstractC11723c.size() == 0) {
            return this;
        }
        if (size() == 0) {
            return abstractC11723c;
        }
        int size3 = abstractC11723c.size() + size();
        if (size3 < 128) {
            return C11738r.m9859l(this, abstractC11723c);
        }
        if (c11738r != null) {
            if (abstractC11723c.size() + c11738r.f24157n.size() < 128) {
                return new C11738r(c11738r.f24156m, C11738r.m9859l(c11738r.f24157n, abstractC11723c));
            }
        }
        if (c11738r != null && c11738r.f24156m.mo9825e() > c11738r.f24157n.mo9825e() && c11738r.f24159p > abstractC11723c.mo9825e()) {
            return new C11738r(c11738r.f24156m, new C11738r(c11738r.f24157n, abstractC11723c));
        }
        if (size3 >= C11738r.f24154k[Math.max(mo9825e(), abstractC11723c.mo9825e()) + 1]) {
            return new C11738r(this, abstractC11723c);
        }
        C11738r.b bVar = new C11738r.b(null);
        bVar.m9860a(this);
        bVar.m9860a(abstractC11723c);
        AbstractC11723c abstractC11723cPop = bVar.f24161a.pop();
        while (!bVar.f24161a.isEmpty()) {
            abstractC11723cPop = new C11738r(bVar.f24161a.pop(), abstractC11723cPop);
        }
        return abstractC11723cPop;
    }

    public void copyTo(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(C1643a.m851g(30, "Source offset < 0: ", i));
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(C1643a.m851g(30, "Target offset < 0: ", i2));
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException(C1643a.m851g(23, "Length < 0: ", i3));
        }
        int i4 = i + i3;
        if (i4 > size()) {
            throw new IndexOutOfBoundsException(C1643a.m851g(34, "Source end offset < 0: ", i4));
        }
        int i5 = i2 + i3;
        if (i5 > bArr.length) {
            throw new IndexOutOfBoundsException(C1643a.m851g(34, "Target end offset < 0: ", i5));
        }
        if (i3 > 0) {
            mo9824d(bArr, i, i2, i3);
        }
    }

    /* JADX INFO: renamed from: d */
    public abstract void mo9824d(byte[] bArr, int i, int i2, int i3);

    /* JADX INFO: renamed from: e */
    public abstract int mo9825e();

    /* JADX INFO: renamed from: g */
    public abstract boolean mo9826g();

    /* JADX INFO: renamed from: h */
    public abstract int mo9827h(int i, int i2, int i3);

    /* JADX INFO: renamed from: i */
    public abstract int mo9828i(int i, int i2, int i3);

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public abstract Iterator<Byte> iterator2();

    /* JADX INFO: renamed from: j */
    public abstract int mo9829j();

    /* JADX INFO: renamed from: k */
    public abstract void mo9830k(OutputStream outputStream, int i, int i2) throws IOException;

    public abstract int size();

    public byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return C11728h.f24142a;
        }
        byte[] bArr = new byte[size];
        mo9824d(bArr, 0, 0, size);
        return bArr;
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract String toString(String str) throws UnsupportedEncodingException;

    public String toStringUtf8() {
        try {
            return toString(Constants.ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.c$b */
    /* JADX INFO: compiled from: ByteString.java */
    public static final class b extends OutputStream {

        /* JADX INFO: renamed from: j */
        public static final byte[] f24101j = new byte[0];

        /* JADX INFO: renamed from: k */
        public final int f24102k;

        /* JADX INFO: renamed from: l */
        public final ArrayList<AbstractC11723c> f24103l;

        /* JADX INFO: renamed from: m */
        public int f24104m;

        /* JADX INFO: renamed from: n */
        public byte[] f24105n;

        /* JADX INFO: renamed from: o */
        public int f24106o;

        public b(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.f24102k = i;
            this.f24103l = new ArrayList<>();
            this.f24105n = new byte[i];
        }

        /* JADX INFO: renamed from: a */
        public final void m9831a(int i) {
            this.f24103l.add(new C11733m(this.f24105n));
            int length = this.f24104m + this.f24105n.length;
            this.f24104m = length;
            this.f24105n = new byte[Math.max(this.f24102k, Math.max(i, length >>> 1))];
            this.f24106o = 0;
        }

        /* JADX INFO: renamed from: b */
        public final void m9832b() {
            int i = this.f24106o;
            byte[] bArr = this.f24105n;
            if (i >= bArr.length) {
                this.f24103l.add(new C11733m(this.f24105n));
                this.f24105n = f24101j;
            } else if (i > 0) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
                this.f24103l.add(new C11733m(bArr2));
            }
            this.f24104m += this.f24106o;
            this.f24106o = 0;
        }

        public synchronized int size() {
            return this.f24104m + this.f24106o;
        }

        public synchronized AbstractC11723c toByteString() {
            m9832b();
            return AbstractC11723c.copyFrom(this.f24103l);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) {
            if (this.f24106o == this.f24105n.length) {
                m9831a(1);
            }
            byte[] bArr = this.f24105n;
            int i2 = this.f24106o;
            this.f24106o = i2 + 1;
            bArr[i2] = (byte) i;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            byte[] bArr2 = this.f24105n;
            int length = bArr2.length;
            int i3 = this.f24106o;
            if (i2 <= length - i3) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.f24106o += i2;
            } else {
                int length2 = bArr2.length - i3;
                System.arraycopy(bArr, i, bArr2, i3, length2);
                int i4 = i2 - length2;
                m9831a(i4);
                System.arraycopy(bArr, i + length2, this.f24105n, 0, i4);
                this.f24106o = i4;
            }
        }
    }

    public static AbstractC11723c copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    public static AbstractC11723c copyFrom(Iterable<AbstractC11723c> iterable) {
        ?? arrayList;
        if (!(iterable instanceof Collection)) {
            arrayList = new ArrayList();
            Iterator<AbstractC11723c> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        } else {
            arrayList = (Collection) iterable;
        }
        if (arrayList.isEmpty()) {
            return f24100j;
        }
        return m9823c(arrayList.iterator(), arrayList.size());
    }
}
