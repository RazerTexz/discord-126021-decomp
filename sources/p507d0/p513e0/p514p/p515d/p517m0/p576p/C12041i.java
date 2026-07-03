package p507d0.p513e0.p514p.p515d.p517m0.p576p;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.i */
/* JADX INFO: compiled from: SmartList.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12041i<E> extends AbstractList<E> implements RandomAccess {

    /* JADX INFO: renamed from: j */
    public int f24997j;

    /* JADX INFO: renamed from: k */
    public Object f24998k;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.i$b */
    /* JADX INFO: compiled from: SmartList.java */
    public static class b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: j */
        public static final b f24999j = new b();

        public static <T> b<T> getInstance() {
            return f24999j;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.i$c */
    /* JADX INFO: compiled from: SmartList.java */
    public class c extends d<E> {

        /* JADX INFO: renamed from: k */
        public final int f25000k;

        public c() {
            super(null);
            this.f25000k = ((AbstractList) C12041i.this).modCount;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12041i.d
        /* JADX INFO: renamed from: a */
        public void mo10048a() {
            if (((AbstractList) C12041i.this).modCount == this.f25000k) {
                return;
            }
            StringBuilder sbM833U = C1643a.m833U("ModCount: ");
            sbM833U.append(((AbstractList) C12041i.this).modCount);
            sbM833U.append("; expected: ");
            sbM833U.append(this.f25000k);
            throw new ConcurrentModificationException(sbM833U.toString());
        }

        @Override // java.util.Iterator
        public void remove() {
            mo10048a();
            C12041i.this.clear();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.i$d */
    /* JADX INFO: compiled from: SmartList.java */
    public static abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: j */
        public boolean f25002j;

        public d(a aVar) {
        }

        /* JADX INFO: renamed from: a */
        public abstract void mo10048a();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f25002j;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f25002j) {
                throw new NoSuchElementException();
            }
            this.f25002j = true;
            mo10048a();
            return (T) C12041i.this.f24998k;
        }
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ void m10044c(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i == 2 || i == 3) {
            objArr[1] = "iterator";
        } else if (i == 5 || i == 6 || i == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        int i = this.f24997j;
        if (i == 0) {
            this.f24998k = e;
        } else if (i == 1) {
            this.f24998k = new Object[]{this.f24998k, e};
        } else {
            Object[] objArr = (Object[]) this.f24998k;
            int length = objArr.length;
            if (i >= length) {
                int i2 = ((length * 3) / 2) + 1;
                int i3 = i + 1;
                if (i2 < i3) {
                    i2 = i3;
                }
                Object[] objArr2 = new Object[i2];
                this.f24998k = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f24997j] = e;
        }
        this.f24997j++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f24998k = null;
        this.f24997j = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.f24997j)) {
            return i2 == 1 ? (E) this.f24998k : (E) ((Object[]) this.f24998k)[i];
        }
        StringBuilder sbM834V = C1643a.m834V("Index: ", i, ", Size: ");
        sbM834V.append(this.f24997j);
        throw new IndexOutOfBoundsException(sbM834V.toString());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int i = this.f24997j;
        if (i == 0) {
            b bVar = b.getInstance();
            if (bVar != null) {
                return bVar;
            }
            m10044c(2);
            throw null;
        }
        if (i == 1) {
            return new c();
        }
        Iterator<E> it = super.iterator();
        if (it != null) {
            return it;
        }
        m10044c(3);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        int i2;
        E e;
        if (i < 0 || i >= (i2 = this.f24997j)) {
            StringBuilder sbM834V = C1643a.m834V("Index: ", i, ", Size: ");
            sbM834V.append(this.f24997j);
            throw new IndexOutOfBoundsException(sbM834V.toString());
        }
        if (i2 == 1) {
            e = (E) this.f24998k;
            this.f24998k = null;
        } else {
            Object[] objArr = (Object[]) this.f24998k;
            Object obj = objArr[i];
            if (i2 == 2) {
                this.f24998k = objArr[1 - i];
            } else {
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i3);
                }
                objArr[this.f24997j - 1] = null;
            }
            e = (E) obj;
        }
        this.f24997j--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        int i2;
        if (i < 0 || i >= (i2 = this.f24997j)) {
            StringBuilder sbM834V = C1643a.m834V("Index: ", i, ", Size: ");
            sbM834V.append(this.f24997j);
            throw new IndexOutOfBoundsException(sbM834V.toString());
        }
        if (i2 == 1) {
            E e2 = (E) this.f24998k;
            this.f24998k = e;
            return e2;
        }
        Object[] objArr = (Object[]) this.f24998k;
        E e3 = (E) objArr[i];
        objArr[i] = e;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f24997j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        if (tArr == 0) {
            m10044c(4);
            throw null;
        }
        int length = tArr.length;
        int i = this.f24997j;
        if (i == 1) {
            if (length == 0) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.f24998k;
                return tArr2;
            }
            tArr[0] = this.f24998k;
        } else {
            if (length < i) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.f24998k, i, tArr.getClass());
                if (tArr3 != null) {
                    return tArr3;
                }
                m10044c(6);
                throw null;
            }
            if (i != 0) {
                System.arraycopy(this.f24998k, 0, tArr, 0, i);
            }
        }
        int i2 = this.f24997j;
        if (length > i2) {
            tArr[i2] = 0;
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        int i2;
        if (i >= 0 && i <= (i2 = this.f24997j)) {
            if (i2 == 0) {
                this.f24998k = e;
            } else if (i2 == 1 && i == 0) {
                this.f24998k = new Object[]{e, this.f24998k};
            } else {
                Object[] objArr = new Object[i2 + 1];
                if (i2 == 1) {
                    objArr[0] = this.f24998k;
                } else {
                    Object[] objArr2 = (Object[]) this.f24998k;
                    System.arraycopy(objArr2, 0, objArr, 0, i);
                    System.arraycopy(objArr2, i, objArr, i + 1, this.f24997j - i);
                }
                objArr[i] = e;
                this.f24998k = objArr;
            }
            this.f24997j++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbM834V = C1643a.m834V("Index: ", i, ", Size: ");
        sbM834V.append(this.f24997j);
        throw new IndexOutOfBoundsException(sbM834V.toString());
    }
}
