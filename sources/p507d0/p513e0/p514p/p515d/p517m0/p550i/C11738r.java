package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.r */
/* JADX INFO: compiled from: RopeByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11738r extends AbstractC11723c {

    /* JADX INFO: renamed from: k */
    public static final int[] f24154k;

    /* JADX INFO: renamed from: l */
    public final int f24155l;

    /* JADX INFO: renamed from: m */
    public final AbstractC11723c f24156m;

    /* JADX INFO: renamed from: n */
    public final AbstractC11723c f24157n;

    /* JADX INFO: renamed from: o */
    public final int f24158o;

    /* JADX INFO: renamed from: p */
    public final int f24159p;

    /* JADX INFO: renamed from: q */
    public int f24160q = 0;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.r$b */
    /* JADX INFO: compiled from: RopeByteString.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public final Stack<AbstractC11723c> f24161a = new Stack<>();

        public b(a aVar) {
        }

        /* JADX INFO: renamed from: a */
        public final void m9860a(AbstractC11723c abstractC11723c) {
            if (!abstractC11723c.mo9826g()) {
                if (!(abstractC11723c instanceof C11738r)) {
                    String strValueOf = String.valueOf(abstractC11723c.getClass());
                    throw new IllegalArgumentException(C1643a.m822J(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
                }
                C11738r c11738r = (C11738r) abstractC11723c;
                m9860a(c11738r.f24156m);
                m9860a(c11738r.f24157n);
                return;
            }
            int size = abstractC11723c.size();
            int[] iArr = C11738r.f24154k;
            int iBinarySearch = Arrays.binarySearch(iArr, size);
            if (iBinarySearch < 0) {
                iBinarySearch = (-(iBinarySearch + 1)) - 1;
            }
            int i = iArr[iBinarySearch + 1];
            if (this.f24161a.isEmpty() || this.f24161a.peek().size() >= i) {
                this.f24161a.push(abstractC11723c);
                return;
            }
            int i2 = iArr[iBinarySearch];
            AbstractC11723c abstractC11723cPop = this.f24161a.pop();
            while (!this.f24161a.isEmpty() && this.f24161a.peek().size() < i2) {
                abstractC11723cPop = new C11738r(this.f24161a.pop(), abstractC11723cPop);
            }
            C11738r c11738r2 = new C11738r(abstractC11723cPop, abstractC11723c);
            while (!this.f24161a.isEmpty()) {
                int size2 = c11738r2.size();
                int[] iArr2 = C11738r.f24154k;
                int iBinarySearch2 = Arrays.binarySearch(iArr2, size2);
                if (iBinarySearch2 < 0) {
                    iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
                }
                if (this.f24161a.peek().size() >= iArr2[iBinarySearch2 + 1]) {
                    break;
                } else {
                    c11738r2 = new C11738r(this.f24161a.pop(), c11738r2);
                }
            }
            this.f24161a.push(c11738r2);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.r$c */
    /* JADX INFO: compiled from: RopeByteString.java */
    public static class c implements Iterator<C11733m> {

        /* JADX INFO: renamed from: j */
        public final Stack<C11738r> f24162j = new Stack<>();

        /* JADX INFO: renamed from: k */
        public C11733m f24163k;

        public c(AbstractC11723c abstractC11723c, a aVar) {
            while (abstractC11723c instanceof C11738r) {
                C11738r c11738r = (C11738r) abstractC11723c;
                this.f24162j.push(c11738r);
                abstractC11723c = c11738r.f24156m;
            }
            this.f24163k = (C11733m) abstractC11723c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24163k != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public C11733m next() {
            C11733m c11733m;
            C11733m c11733m2 = this.f24163k;
            if (c11733m2 == null) {
                throw new NoSuchElementException();
            }
            while (!this.f24162j.isEmpty()) {
                AbstractC11723c abstractC11723c = this.f24162j.pop().f24157n;
                while (abstractC11723c instanceof C11738r) {
                    C11738r c11738r = (C11738r) abstractC11723c;
                    this.f24162j.push(c11738r);
                    abstractC11723c = c11738r.f24156m;
                }
                c11733m = (C11733m) abstractC11723c;
                if (!c11733m.isEmpty()) {
                    this.f24163k = c11733m;
                    return c11733m2;
                }
            }
            c11733m = null;
            this.f24163k = c11733m;
            return c11733m2;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.r$d */
    /* JADX INFO: compiled from: RopeByteString.java */
    public class d implements AbstractC11723c.a {

        /* JADX INFO: renamed from: j */
        public final c f24164j;

        /* JADX INFO: renamed from: k */
        public AbstractC11723c.a f24165k;

        /* JADX INFO: renamed from: l */
        public int f24166l;

        /* JADX WARN: Type inference failed for: r3v3, types: [d0.e0.p.d.m0.i.c$a] */
        public d(C11738r c11738r, a aVar) {
            c cVar = new c(c11738r, null);
            this.f24164j = cVar;
            this.f24165k = cVar.next().iterator2();
            this.f24166l = c11738r.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24166l > 0;
        }

        /* JADX WARN: Type inference failed for: r0v8, types: [d0.e0.p.d.m0.i.c$a] */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c.a
        public byte nextByte() {
            if (!this.f24165k.hasNext()) {
                this.f24165k = this.f24164j.next().iterator2();
            }
            this.f24166l--;
            return this.f24165k.nextByte();
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
        f24154k = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = f24154k;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    public C11738r(AbstractC11723c abstractC11723c, AbstractC11723c abstractC11723c2) {
        this.f24156m = abstractC11723c;
        this.f24157n = abstractC11723c2;
        int size = abstractC11723c.size();
        this.f24158o = size;
        this.f24155l = abstractC11723c2.size() + size;
        this.f24159p = Math.max(abstractC11723c.mo9825e(), abstractC11723c2.mo9825e()) + 1;
    }

    /* JADX INFO: renamed from: l */
    public static C11733m m9859l(AbstractC11723c abstractC11723c, AbstractC11723c abstractC11723c2) {
        int size = abstractC11723c.size();
        int size2 = abstractC11723c2.size();
        byte[] bArr = new byte[size + size2];
        abstractC11723c.copyTo(bArr, 0, 0, size);
        abstractC11723c2.copyTo(bArr, 0, size, size2);
        return new C11733m(bArr);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c
    /* JADX INFO: renamed from: d */
    public void mo9824d(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.f24158o;
        if (i4 <= i5) {
            this.f24156m.mo9824d(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.f24157n.mo9824d(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.f24156m.mo9824d(bArr, i, i2, i6);
            this.f24157n.mo9824d(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c
    /* JADX INFO: renamed from: e */
    public int mo9825e() {
        return this.f24159p;
    }

    public boolean equals(Object obj) {
        int iMo9829j;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC11723c)) {
            return false;
        }
        AbstractC11723c abstractC11723c = (AbstractC11723c) obj;
        if (this.f24155l != abstractC11723c.size()) {
            return false;
        }
        if (this.f24155l == 0) {
            return true;
        }
        if (this.f24160q != 0 && (iMo9829j = abstractC11723c.mo9829j()) != 0 && this.f24160q != iMo9829j) {
            return false;
        }
        c cVar = new c(this, null);
        C11733m next = cVar.next();
        c cVar2 = new c(abstractC11723c, null);
        C11733m next2 = cVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int iMin = Math.min(size, size2);
            if (!(i == 0 ? next.m9857l(next2, i2, iMin) : next2.m9857l(next, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.f24155l;
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c
    /* JADX INFO: renamed from: g */
    public boolean mo9826g() {
        return this.f24155l >= f24154k[this.f24159p];
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c
    /* JADX INFO: renamed from: h */
    public int mo9827h(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f24158o;
        if (i4 <= i5) {
            return this.f24156m.mo9827h(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f24157n.mo9827h(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f24157n.mo9827h(this.f24156m.mo9827h(i, i2, i6), 0, i3 - i6);
    }

    public int hashCode() {
        int iMo9827h = this.f24160q;
        if (iMo9827h == 0) {
            int i = this.f24155l;
            iMo9827h = mo9827h(i, 0, i);
            if (iMo9827h == 0) {
                iMo9827h = 1;
            }
            this.f24160q = iMo9827h;
        }
        return iMo9827h;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c
    /* JADX INFO: renamed from: i */
    public int mo9828i(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f24158o;
        if (i4 <= i5) {
            return this.f24156m.mo9828i(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f24157n.mo9828i(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f24157n.mo9828i(this.f24156m.mo9828i(i, i2, i6), 0, i3 - i6);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c
    public boolean isValidUtf8() {
        int iMo9828i = this.f24156m.mo9828i(0, 0, this.f24158o);
        AbstractC11723c abstractC11723c = this.f24157n;
        return abstractC11723c.mo9828i(iMo9828i, 0, abstractC11723c.size()) == 0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c
    /* JADX INFO: renamed from: j */
    public int mo9829j() {
        return this.f24160q;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c
    /* JADX INFO: renamed from: k */
    public void mo9830k(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.f24158o;
        if (i3 <= i4) {
            this.f24156m.mo9830k(outputStream, i, i2);
        } else {
            if (i >= i4) {
                this.f24157n.mo9830k(outputStream, i - i4, i2);
                return;
            }
            int i5 = i4 - i;
            this.f24156m.mo9830k(outputStream, i, i5);
            this.f24157n.mo9830k(outputStream, 0, i2 - i5);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c
    public int size() {
        return this.f24155l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new d(this, null);
    }
}
