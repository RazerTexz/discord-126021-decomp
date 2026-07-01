package j0.l.c;

import rx.functions.Action0;

/* JADX INFO: compiled from: TrampolineScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m$b implements Comparable<m$b> {
    public final Action0 j;
    public final Long k;
    public final int l;

    public m$b(Action0 action0, Long l, int i) {
        this.j = action0;
        this.k = l;
        this.l = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(m$b m_b) {
        m$b m_b2 = m_b;
        int iCompareTo = this.k.compareTo(m_b2.k);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i = this.l;
        int i2 = m_b2.l;
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }
}
