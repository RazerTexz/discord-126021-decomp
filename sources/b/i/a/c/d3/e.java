package b.i.a.c.d3;

import java.util.Comparator;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Comparator {
    public static final /* synthetic */ e j = new e();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        m$c m_c = (m$c) obj;
        m$c m_c2 = (m$c) obj2;
        int iCompare = Integer.compare(m_c2.f916b, m_c.f916b);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompareTo = m_c.c.compareTo(m_c2.c);
        return iCompareTo != 0 ? iCompareTo : m_c.d.compareTo(m_c2.d);
    }
}
