package b.g.a.c.z;

import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.z.c, reason: use source file name */
/* JADX INFO: compiled from: CoercionConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public class CoercionConfig implements Serializable {
    public static final int j;
    private static final long serialVersionUID = 1;
    public final CoercionAction[] _coercionsByShape = new CoercionAction[j];
    public Boolean _acceptBlankAsEmpty = Boolean.FALSE;

    static {
        b.c.a.y.b.com$fasterxml$jackson$databind$cfg$CoercionInputShape$s$values();
        j = 10;
    }
}
