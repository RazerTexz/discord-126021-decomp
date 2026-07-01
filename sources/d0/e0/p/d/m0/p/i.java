package d0.e0.p.d.m0.p;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: SmartList.java */
/* JADX INFO: loaded from: classes3.dex */
public class i<E> extends AbstractList<E> implements RandomAccess {
    public int j;
    public Object k;

    public static /* synthetic */ void c(int i) {
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

    public static /* synthetic */ int d(i iVar) {
        return ((AbstractList) iVar).modCount;
    }

    public static /* synthetic */ int e(i iVar) {
        return ((AbstractList) iVar).modCount;
    }

    public static /* synthetic */ int g(i iVar) {
        return ((AbstractList) iVar).modCount;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        int i = this.j;
        if (i == 0) {
            this.k = e;
        } else if (i == 1) {
            this.k = new Object[]{this.k, e};
        } else {
            Object[] objArr = (Object[]) this.k;
            int length = objArr.length;
            if (i >= length) {
                int i2 = ((length * 3) / 2) + 1;
                int i3 = i + 1;
                if (i2 < i3) {
                    i2 = i3;
                }
                Object[] objArr2 = new Object[i2];
                this.k = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.j] = e;
        }
        this.j++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.k = null;
        this.j = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.j)) {
            return i2 == 1 ? (E) this.k : (E) ((Object[]) this.k)[i];
        }
        StringBuilder sbV = b.d.b.a.a.V("Index: ", i, ", Size: ");
        sbV.append(this.j);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int i = this.j;
        if (i == 0) {
            i$b i_b = i$b.getInstance();
            if (i_b != null) {
                return i_b;
            }
            c(2);
            throw null;
        }
        if (i == 1) {
            return new i$c(this);
        }
        Iterator<E> it = super.iterator();
        if (it != null) {
            return it;
        }
        c(3);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        int i2;
        E e;
        if (i < 0 || i >= (i2 = this.j)) {
            StringBuilder sbV = b.d.b.a.a.V("Index: ", i, ", Size: ");
            sbV.append(this.j);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        if (i2 == 1) {
            e = (E) this.k;
            this.k = null;
        } else {
            Object[] objArr = (Object[]) this.k;
            Object obj = objArr[i];
            if (i2 == 2) {
                this.k = objArr[1 - i];
            } else {
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i3);
                }
                objArr[this.j - 1] = null;
            }
            e = (E) obj;
        }
        this.j--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        int i2;
        if (i < 0 || i >= (i2 = this.j)) {
            StringBuilder sbV = b.d.b.a.a.V("Index: ", i, ", Size: ");
            sbV.append(this.j);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        if (i2 == 1) {
            E e2 = (E) this.k;
            this.k = e;
            return e2;
        }
        Object[] objArr = (Object[]) this.k;
        E e3 = (E) objArr[i];
        objArr[i] = e;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        if (tArr == 0) {
            c(4);
            throw null;
        }
        int length = tArr.length;
        int i = this.j;
        if (i == 1) {
            if (length == 0) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.k;
                return tArr2;
            }
            tArr[0] = this.k;
        } else {
            if (length < i) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.k, i, tArr.getClass());
                if (tArr3 != null) {
                    return tArr3;
                }
                c(6);
                throw null;
            }
            if (i != 0) {
                System.arraycopy(this.k, 0, tArr, 0, i);
            }
        }
        int i2 = this.j;
        if (length > i2) {
            tArr[i2] = 0;
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        int i2;
        if (i >= 0 && i <= (i2 = this.j)) {
            if (i2 == 0) {
                this.k = e;
            } else if (i2 == 1 && i == 0) {
                this.k = new Object[]{e, this.k};
            } else {
                Object[] objArr = new Object[i2 + 1];
                if (i2 == 1) {
                    objArr[0] = this.k;
                } else {
                    Object[] objArr2 = (Object[]) this.k;
                    System.arraycopy(objArr2, 0, objArr, 0, i);
                    System.arraycopy(objArr2, i, objArr, i + 1, this.j - i);
                }
                objArr[i] = e;
                this.k = objArr;
            }
            this.j++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbV = b.d.b.a.a.V("Index: ", i, ", Size: ");
        sbV.append(this.j);
        throw new IndexOutOfBoundsException(sbV.toString());
    }
}
