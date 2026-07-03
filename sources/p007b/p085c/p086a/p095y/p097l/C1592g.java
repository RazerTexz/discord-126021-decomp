package p007b.p085c.p086a.p095y.p097l;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p091w.p092b.C1536l;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.l.g */
/* JADX INFO: compiled from: MergePaths.java */
/* JADX INFO: loaded from: classes.dex */
public class C1592g implements InterfaceC1587b {

    /* JADX INFO: renamed from: a */
    public final String f2771a;

    /* JADX INFO: renamed from: b */
    public final a f2772b;

    /* JADX INFO: renamed from: c */
    public final boolean f2773c;

    /* JADX INFO: renamed from: b.c.a.y.l.g$a */
    /* JADX INFO: compiled from: MergePaths.java */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS
    }

    public C1592g(String str, a aVar, boolean z2) {
        this.f2771a = str;
        this.f2772b = aVar;
        this.f2773c = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.InterfaceC1587b
    @Nullable
    /* JADX INFO: renamed from: a */
    public InterfaceC1527c mo775a(C1511j c1511j, AbstractC1603b abstractC1603b) {
        if (c1511j.f2382w) {
            return new C1536l(this);
        }
        C1495c.m640b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("MergePaths{mode=");
        sbM833U.append(this.f2772b);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
