package b.i.c.l;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: b.i.c.l.m, reason: use source file name */
/* JADX INFO: compiled from: CycleDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class CycleDetector2 {
    public final Component4<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<CycleDetector2> f1666b = new HashSet();
    public final Set<CycleDetector2> c = new HashSet();

    public CycleDetector2(Component4<?> component4) {
        this.a = component4;
    }

    public boolean a() {
        return this.c.isEmpty();
    }
}
