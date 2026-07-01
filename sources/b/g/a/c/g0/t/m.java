package b.g.a.c.g0.t;

import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: ReadOnlyClassToSerializerMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public final m$a[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f711b;

    public m(Map<b.g.a.c.i0.u, b.g.a.c.n<Object>> map) {
        int size = map.size();
        int i = 8;
        while (i < (size <= 64 ? size + size : size + (size >> 2))) {
            i += i;
        }
        this.f711b = i - 1;
        m$a[] m_aArr = new m$a[i];
        for (Map$Entry<b.g.a.c.i0.u, b.g.a.c.n<Object>> map$Entry : map.entrySet()) {
            b.g.a.c.i0.u key = map$Entry.getKey();
            int i2 = key.a & this.f711b;
            m_aArr[i2] = new m$a(m_aArr[i2], key, map$Entry.getValue());
        }
        this.a = m_aArr;
    }

    public b.g.a.c.n<Object> a(b.g.a.c.j jVar) {
        m$a m_a = this.a[(jVar._hash - 1) & this.f711b];
        if (m_a == null) {
            return null;
        }
        if (!m_a.e && jVar.equals(m_a.d)) {
            return m_a.a;
        }
        do {
            m_a = m_a.f712b;
            if (m_a == null) {
                return null;
            }
        } while (!(!m_a.e && jVar.equals(m_a.d)));
        return m_a.a;
    }

    public b.g.a.c.n<Object> b(Class<?> cls) {
        m$a m_a = this.a[cls.getName().hashCode() & this.f711b];
        if (m_a == null) {
            return null;
        }
        if (m_a.c == cls && !m_a.e) {
            return m_a.a;
        }
        do {
            m_a = m_a.f712b;
            if (m_a == null) {
                return null;
            }
        } while (!(m_a.c == cls && !m_a.e));
        return m_a.a;
    }
}
