package d0.e0.p.d.m0.c;

import java.util.Map;

/* JADX INFO: compiled from: Visibilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e1 {
    public static final e1 a = new e1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<f1, Integer> f3246b;

    static {
        Map mapCreateMapBuilder = d0.t.g0.createMapBuilder();
        mapCreateMapBuilder.put(e1$f.c, 0);
        mapCreateMapBuilder.put(e1$e.c, 0);
        mapCreateMapBuilder.put(e1$b.c, 1);
        mapCreateMapBuilder.put(e1$g.c, 1);
        mapCreateMapBuilder.put(e1$h.c, 2);
        f3246b = d0.t.g0.build(mapCreateMapBuilder);
    }

    public final Integer compareLocal$compiler_common(f1 f1Var, f1 f1Var2) {
        d0.z.d.m.checkNotNullParameter(f1Var, "first");
        d0.z.d.m.checkNotNullParameter(f1Var2, "second");
        if (f1Var == f1Var2) {
            return 0;
        }
        Map<f1, Integer> map = f3246b;
        Integer num = map.get(f1Var);
        Integer num2 = map.get(f1Var2);
        if (num == null || num2 == null || d0.z.d.m.areEqual(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean isPrivate(f1 f1Var) {
        d0.z.d.m.checkNotNullParameter(f1Var, "visibility");
        return f1Var == e1$e.c || f1Var == e1$f.c;
    }
}
