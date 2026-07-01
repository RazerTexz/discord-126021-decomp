package b.c.a;

import androidx.collection.ArraySet;
import b.c.a.b0.MeanCalculator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: b.c.a.s, reason: use source file name */
/* JADX INFO: compiled from: PerformanceTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class PerformanceTracker {
    public boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<a> f375b = new ArraySet();
    public final Map<String, MeanCalculator> c = new HashMap();

    /* JADX INFO: renamed from: b.c.a.s$a */
    /* JADX INFO: compiled from: PerformanceTracker.java */
    public interface a {
        void a(float f);
    }
}
