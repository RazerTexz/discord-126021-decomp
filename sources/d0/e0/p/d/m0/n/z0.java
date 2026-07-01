package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z0 {
    public static final z0 a;

    static {
        new z0$b(null);
        a = new z0$a();
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    public final c1 buildSubstitutor() {
        c1 c1VarCreate = c1.create(this);
        d0.z.d.m.checkNotNullExpressionValue(c1VarCreate, "create(this)");
        return c1VarCreate;
    }

    public d0.e0.p.d.m0.c.g1.g filterAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        return gVar;
    }

    public abstract w0 get(c0 c0Var);

    public boolean isEmpty() {
        return false;
    }

    public c0 prepareTopLevelType(c0 c0Var, j1 j1Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "topLevelType");
        d0.z.d.m.checkNotNullParameter(j1Var, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        return c0Var;
    }
}
