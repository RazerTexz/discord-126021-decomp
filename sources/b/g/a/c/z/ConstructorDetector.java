package b.g.a.c.z;

import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.z.h, reason: use source file name */
/* JADX INFO: compiled from: ConstructorDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ConstructorDetector implements Serializable {
    private static final long serialVersionUID = 1;
    public final boolean _allowJDKTypeCtors;
    public final boolean _requireCtorAnnotation;
    public final a _singleArgMode;

    /* JADX INFO: renamed from: b.g.a.c.z.h$a */
    /* JADX INFO: compiled from: ConstructorDetector.java */
    public enum a {
        DELEGATING,
        PROPERTIES,
        HEURISTIC,
        REQUIRE_MODE
    }
}
