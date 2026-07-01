package b.a.q.o0;

import com.discord.utilities.collections.Histogram;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: VideoQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public class e$e {
    public Long d;
    public long f;
    public float i;
    public List<e$g> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Histogram f283b = new Histogram(5, 0, 2, null);
    public final Histogram c = new Histogram(25600, 0, 2, null);
    public e$a e = new e$a(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16383);
    public Map<Integer, Float> g = new LinkedHashMap();
    public Map<Integer, Float> h = new LinkedHashMap();
    public Map<Integer, Float> j = new LinkedHashMap();

    public e$e() {
        Iterator<T> it = e.a.iterator();
        while (it.hasNext()) {
            this.g.put(Integer.valueOf(((Number) it.next()).intValue()), Float.valueOf(0.0f));
        }
        Iterator<T> it2 = e.f280b.iterator();
        while (it2.hasNext()) {
            this.h.put(Integer.valueOf(((Number) it2.next()).intValue()), Float.valueOf(0.0f));
        }
        Iterator<T> it3 = e.c.iterator();
        while (it3.hasNext()) {
            this.j.put(Integer.valueOf(((Number) it3.next()).intValue()), Float.valueOf(0.0f));
        }
    }
}
