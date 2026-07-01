package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.d1;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.z0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: VariableDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m0 extends l implements d1 {
    public d0.e0.p.d.m0.n.c0 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.n.c0 c0Var, u0 u0Var) {
        super(mVar, gVar, eVar, u0Var);
        if (mVar == null) {
            a(0);
            throw null;
        }
        if (gVar == null) {
            a(1);
            throw null;
        }
        if (eVar == null) {
            a(2);
            throw null;
        }
        if (u0Var == null) {
            a(3);
            throw null;
        }
        this.n = c0Var;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public q0 getDispatchReceiverParameter() {
        return null;
    }

    public q0 getExtensionReceiverParameter() {
        return null;
    }

    public d0.e0.p.d.m0.n.c0 getReturnType() {
        d0.e0.p.d.m0.n.c0 type = getType();
        if (type != null) {
            return type;
        }
        a(9);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.b1
    public d0.e0.p.d.m0.n.c0 getType() {
        d0.e0.p.d.m0.n.c0 c0Var = this.n;
        if (c0Var != null) {
            return c0Var;
        }
        a(4);
        throw null;
    }

    public List<z0> getTypeParameters() {
        List<z0> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public List<c1> getValueParameters() {
        List<c1> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(6);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    public void setOutType(d0.e0.p.d.m0.n.c0 c0Var) {
        this.n = c0Var;
    }
}
