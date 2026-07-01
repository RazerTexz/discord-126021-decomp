package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: DeclarationDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends d0.e0.p.d.m0.c.g1.b implements d0.e0.p.d.m0.c.m {
    public final d0.e0.p.d.m0.g.e k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar) {
        super(gVar);
        if (gVar == null) {
            a(0);
            throw null;
        }
        if (eVar == null) {
            a(1);
            throw null;
        }
        this.k = eVar;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 5 || i == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i != 2 && i != 3) {
            if (i == 4) {
                objArr[2] = "toString";
            } else if (i != 5 && i != 6) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.g.e getName() {
        d0.e0.p.d.m0.g.e eVar = this.k;
        if (eVar != null) {
            return eVar;
        }
        a(2);
        throw null;
    }

    public d0.e0.p.d.m0.c.m getOriginal() {
        return this;
    }

    public String toString() {
        return toString(this);
    }

    public static String toString(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(4);
            throw null;
        }
        try {
            String str = d0.e0.p.d.m0.j.c.c.render(mVar) + "[" + mVar.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(mVar)) + "]";
            if (str != null) {
                return str;
            }
            a(5);
            throw null;
        } catch (Throwable unused) {
            String str2 = mVar.getClass().getSimpleName() + " " + mVar.getName();
            if (str2 != null) {
                return str2;
            }
            a(6);
            throw null;
        }
    }
}
