package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final Comparator<Comparable> j = new LinkedTreeMap$a();
    public Comparator<? super K> comparator;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/google/gson/internal/LinkedTreeMap<TK;TV;>.b; */
    private LinkedTreeMap$b entrySet;
    public final LinkedTreeMap$e<K, V> header;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/google/gson/internal/LinkedTreeMap<TK;TV;>.c; */
    private LinkedTreeMap$c keySet;
    public int modCount;
    public LinkedTreeMap$e<K, V> root;
    public int size;

    public LinkedTreeMap() {
        Comparator<Comparable> comparator = j;
        this.size = 0;
        this.modCount = 0;
        this.header = new LinkedTreeMap$e<>();
        this.comparator = comparator;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public LinkedTreeMap$e<K, V> a(K k, boolean z2) {
        int iCompareTo;
        LinkedTreeMap$e<K, V> linkedTreeMap$e;
        Comparator<? super K> comparator = this.comparator;
        LinkedTreeMap$e<K, V> linkedTreeMap$e2 = this.root;
        if (linkedTreeMap$e2 != null) {
            Comparable comparable = comparator == j ? (Comparable) k : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(linkedTreeMap$e2.o) : comparator.compare(k, linkedTreeMap$e2.o);
                if (iCompareTo == 0) {
                    return linkedTreeMap$e2;
                }
                LinkedTreeMap$e<K, V> linkedTreeMap$e3 = iCompareTo < 0 ? linkedTreeMap$e2.k : linkedTreeMap$e2.l;
                if (linkedTreeMap$e3 == null) {
                    break;
                }
                linkedTreeMap$e2 = linkedTreeMap$e3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z2) {
            return null;
        }
        LinkedTreeMap$e<K, V> linkedTreeMap$e4 = this.header;
        if (linkedTreeMap$e2 != null) {
            linkedTreeMap$e = new LinkedTreeMap$e<>(linkedTreeMap$e2, k, linkedTreeMap$e4, linkedTreeMap$e4.n);
            if (iCompareTo < 0) {
                linkedTreeMap$e2.k = linkedTreeMap$e;
            } else {
                linkedTreeMap$e2.l = linkedTreeMap$e;
            }
            d(linkedTreeMap$e2, true);
        } else {
            if (comparator == j && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            linkedTreeMap$e = new LinkedTreeMap$e<>(linkedTreeMap$e2, k, linkedTreeMap$e4, linkedTreeMap$e4.n);
            this.root = linkedTreeMap$e;
        }
        this.size++;
        this.modCount++;
        return linkedTreeMap$e;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0023  */
    public LinkedTreeMap$e<K, V> b(Map$Entry<?, ?> map$Entry) {
        boolean z2;
        LinkedTreeMap$e<K, V> linkedTreeMap$eC = c(map$Entry.getKey());
        if (linkedTreeMap$eC != null) {
            V v = linkedTreeMap$eC.p;
            Object value = map$Entry.getValue();
            z2 = v == value || (v != null && v.equals(value));
        }
        if (z2) {
            return linkedTreeMap$eC;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinkedTreeMap$e<K, V> c(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        LinkedTreeMap$e<K, V> linkedTreeMap$e = this.header;
        linkedTreeMap$e.n = linkedTreeMap$e;
        linkedTreeMap$e.m = linkedTreeMap$e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return c(obj) != null;
    }

    public final void d(LinkedTreeMap$e<K, V> linkedTreeMap$e, boolean z2) {
        while (linkedTreeMap$e != null) {
            LinkedTreeMap$e<K, V> linkedTreeMap$e2 = linkedTreeMap$e.k;
            LinkedTreeMap$e<K, V> linkedTreeMap$e3 = linkedTreeMap$e.l;
            int i = linkedTreeMap$e2 != null ? linkedTreeMap$e2.q : 0;
            int i2 = linkedTreeMap$e3 != null ? linkedTreeMap$e3.q : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                LinkedTreeMap$e<K, V> linkedTreeMap$e4 = linkedTreeMap$e3.k;
                LinkedTreeMap$e<K, V> linkedTreeMap$e5 = linkedTreeMap$e3.l;
                int i4 = (linkedTreeMap$e4 != null ? linkedTreeMap$e4.q : 0) - (linkedTreeMap$e5 != null ? linkedTreeMap$e5.q : 0);
                if (i4 == -1 || (i4 == 0 && !z2)) {
                    g(linkedTreeMap$e);
                } else {
                    h(linkedTreeMap$e3);
                    g(linkedTreeMap$e);
                }
                if (z2) {
                    return;
                }
            } else if (i3 == 2) {
                LinkedTreeMap$e<K, V> linkedTreeMap$e6 = linkedTreeMap$e2.k;
                LinkedTreeMap$e<K, V> linkedTreeMap$e7 = linkedTreeMap$e2.l;
                int i5 = (linkedTreeMap$e6 != null ? linkedTreeMap$e6.q : 0) - (linkedTreeMap$e7 != null ? linkedTreeMap$e7.q : 0);
                if (i5 == 1 || (i5 == 0 && !z2)) {
                    h(linkedTreeMap$e);
                } else {
                    g(linkedTreeMap$e2);
                    h(linkedTreeMap$e);
                }
                if (z2) {
                    return;
                }
            } else if (i3 == 0) {
                linkedTreeMap$e.q = i + 1;
                if (z2) {
                    return;
                }
            } else {
                linkedTreeMap$e.q = Math.max(i, i2) + 1;
                if (!z2) {
                    return;
                }
            }
            linkedTreeMap$e = linkedTreeMap$e.j;
        }
    }

    public void e(LinkedTreeMap$e<K, V> linkedTreeMap$e, boolean z2) {
        LinkedTreeMap$e<K, V> linkedTreeMap$e2;
        LinkedTreeMap$e<K, V> linkedTreeMap$e3;
        int i;
        if (z2) {
            LinkedTreeMap$e<K, V> linkedTreeMap$e4 = linkedTreeMap$e.n;
            linkedTreeMap$e4.m = linkedTreeMap$e.m;
            linkedTreeMap$e.m.n = linkedTreeMap$e4;
        }
        LinkedTreeMap$e<K, V> linkedTreeMap$e5 = linkedTreeMap$e.k;
        LinkedTreeMap$e<K, V> linkedTreeMap$e6 = linkedTreeMap$e.l;
        LinkedTreeMap$e<K, V> linkedTreeMap$e7 = linkedTreeMap$e.j;
        int i2 = 0;
        if (linkedTreeMap$e5 == null || linkedTreeMap$e6 == null) {
            if (linkedTreeMap$e5 != null) {
                f(linkedTreeMap$e, linkedTreeMap$e5);
                linkedTreeMap$e.k = null;
            } else if (linkedTreeMap$e6 != null) {
                f(linkedTreeMap$e, linkedTreeMap$e6);
                linkedTreeMap$e.l = null;
            } else {
                f(linkedTreeMap$e, null);
            }
            d(linkedTreeMap$e7, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (linkedTreeMap$e5.q > linkedTreeMap$e6.q) {
            LinkedTreeMap$e<K, V> linkedTreeMap$e8 = linkedTreeMap$e5.l;
            while (true) {
                LinkedTreeMap$e<K, V> linkedTreeMap$e9 = linkedTreeMap$e8;
                linkedTreeMap$e3 = linkedTreeMap$e5;
                linkedTreeMap$e5 = linkedTreeMap$e9;
                if (linkedTreeMap$e5 == null) {
                    break;
                } else {
                    linkedTreeMap$e8 = linkedTreeMap$e5.l;
                }
            }
        } else {
            LinkedTreeMap$e<K, V> linkedTreeMap$e10 = linkedTreeMap$e6.k;
            while (true) {
                linkedTreeMap$e2 = linkedTreeMap$e6;
                linkedTreeMap$e6 = linkedTreeMap$e10;
                if (linkedTreeMap$e6 == null) {
                    break;
                } else {
                    linkedTreeMap$e10 = linkedTreeMap$e6.k;
                }
            }
            linkedTreeMap$e3 = linkedTreeMap$e2;
        }
        e(linkedTreeMap$e3, false);
        LinkedTreeMap$e<K, V> linkedTreeMap$e11 = linkedTreeMap$e.k;
        if (linkedTreeMap$e11 != null) {
            i = linkedTreeMap$e11.q;
            linkedTreeMap$e3.k = linkedTreeMap$e11;
            linkedTreeMap$e11.j = linkedTreeMap$e3;
            linkedTreeMap$e.k = null;
        } else {
            i = 0;
        }
        LinkedTreeMap$e<K, V> linkedTreeMap$e12 = linkedTreeMap$e.l;
        if (linkedTreeMap$e12 != null) {
            i2 = linkedTreeMap$e12.q;
            linkedTreeMap$e3.l = linkedTreeMap$e12;
            linkedTreeMap$e12.j = linkedTreeMap$e3;
            linkedTreeMap$e.l = null;
        }
        linkedTreeMap$e3.q = Math.max(i, i2) + 1;
        f(linkedTreeMap$e, linkedTreeMap$e3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map$Entry<K, V>> entrySet() {
        LinkedTreeMap$b linkedTreeMap$b = this.entrySet;
        if (linkedTreeMap$b != null) {
            return linkedTreeMap$b;
        }
        LinkedTreeMap$b linkedTreeMap$b2 = new LinkedTreeMap$b(this);
        this.entrySet = linkedTreeMap$b2;
        return linkedTreeMap$b2;
    }

    public final void f(LinkedTreeMap$e<K, V> linkedTreeMap$e, LinkedTreeMap$e<K, V> linkedTreeMap$e2) {
        LinkedTreeMap$e<K, V> linkedTreeMap$e3 = linkedTreeMap$e.j;
        linkedTreeMap$e.j = null;
        if (linkedTreeMap$e2 != null) {
            linkedTreeMap$e2.j = linkedTreeMap$e3;
        }
        if (linkedTreeMap$e3 == null) {
            this.root = linkedTreeMap$e2;
        } else if (linkedTreeMap$e3.k == linkedTreeMap$e) {
            linkedTreeMap$e3.k = linkedTreeMap$e2;
        } else {
            linkedTreeMap$e3.l = linkedTreeMap$e2;
        }
    }

    public final void g(LinkedTreeMap$e<K, V> linkedTreeMap$e) {
        LinkedTreeMap$e<K, V> linkedTreeMap$e2 = linkedTreeMap$e.k;
        LinkedTreeMap$e<K, V> linkedTreeMap$e3 = linkedTreeMap$e.l;
        LinkedTreeMap$e<K, V> linkedTreeMap$e4 = linkedTreeMap$e3.k;
        LinkedTreeMap$e<K, V> linkedTreeMap$e5 = linkedTreeMap$e3.l;
        linkedTreeMap$e.l = linkedTreeMap$e4;
        if (linkedTreeMap$e4 != null) {
            linkedTreeMap$e4.j = linkedTreeMap$e;
        }
        f(linkedTreeMap$e, linkedTreeMap$e3);
        linkedTreeMap$e3.k = linkedTreeMap$e;
        linkedTreeMap$e.j = linkedTreeMap$e3;
        int iMax = Math.max(linkedTreeMap$e2 != null ? linkedTreeMap$e2.q : 0, linkedTreeMap$e4 != null ? linkedTreeMap$e4.q : 0) + 1;
        linkedTreeMap$e.q = iMax;
        linkedTreeMap$e3.q = Math.max(iMax, linkedTreeMap$e5 != null ? linkedTreeMap$e5.q : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        LinkedTreeMap$e<K, V> linkedTreeMap$eC = c(obj);
        if (linkedTreeMap$eC != null) {
            return linkedTreeMap$eC.p;
        }
        return null;
    }

    public final void h(LinkedTreeMap$e<K, V> linkedTreeMap$e) {
        LinkedTreeMap$e<K, V> linkedTreeMap$e2 = linkedTreeMap$e.k;
        LinkedTreeMap$e<K, V> linkedTreeMap$e3 = linkedTreeMap$e.l;
        LinkedTreeMap$e<K, V> linkedTreeMap$e4 = linkedTreeMap$e2.k;
        LinkedTreeMap$e<K, V> linkedTreeMap$e5 = linkedTreeMap$e2.l;
        linkedTreeMap$e.k = linkedTreeMap$e5;
        if (linkedTreeMap$e5 != null) {
            linkedTreeMap$e5.j = linkedTreeMap$e;
        }
        f(linkedTreeMap$e, linkedTreeMap$e2);
        linkedTreeMap$e2.l = linkedTreeMap$e;
        linkedTreeMap$e.j = linkedTreeMap$e2;
        int iMax = Math.max(linkedTreeMap$e3 != null ? linkedTreeMap$e3.q : 0, linkedTreeMap$e5 != null ? linkedTreeMap$e5.q : 0) + 1;
        linkedTreeMap$e.q = iMax;
        linkedTreeMap$e2.q = Math.max(iMax, linkedTreeMap$e4 != null ? linkedTreeMap$e4.q : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap$c linkedTreeMap$c = this.keySet;
        if (linkedTreeMap$c != null) {
            return linkedTreeMap$c;
        }
        LinkedTreeMap$c linkedTreeMap$c2 = new LinkedTreeMap$c(this);
        this.keySet = linkedTreeMap$c2;
        return linkedTreeMap$c2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        LinkedTreeMap$e<K, V> linkedTreeMap$eA = a(k, true);
        V v2 = linkedTreeMap$eA.p;
        linkedTreeMap$eA.p = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        LinkedTreeMap$e<K, V> linkedTreeMap$eC = c(obj);
        if (linkedTreeMap$eC != null) {
            e(linkedTreeMap$eC, true);
        }
        if (linkedTreeMap$eC != null) {
            return linkedTreeMap$eC.p;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }
}
