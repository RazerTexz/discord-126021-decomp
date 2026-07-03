package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.C11339b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.k */
/* JADX INFO: compiled from: DeclarationDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11381k extends C11339b implements InterfaceC11450m {

    /* JADX INFO: renamed from: k */
    public final C11716e f22892k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11381k(InterfaceC11344g interfaceC11344g, C11716e c11716e) {
        super(interfaceC11344g);
        if (interfaceC11344g == null) {
            m9412a(0);
            throw null;
        }
        if (c11716e == null) {
            m9412a(1);
            throw null;
        }
        this.f22892k = c11716e;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9412a(int i) {
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public C11716e getName() {
        C11716e c11716e = this.f22892k;
        if (c11716e != null) {
            return c11716e;
        }
        m9412a(2);
        throw null;
    }

    public InterfaceC11450m getOriginal() {
        return this;
    }

    public String toString() {
        return toString(this);
    }

    public static String toString(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m == null) {
            m9412a(4);
            throw null;
        }
        try {
            String str = AbstractC11746c.f24227c.render(interfaceC11450m) + "[" + interfaceC11450m.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(interfaceC11450m)) + "]";
            if (str != null) {
                return str;
            }
            m9412a(5);
            throw null;
        } catch (Throwable unused) {
            String str2 = interfaceC11450m.getClass().getSimpleName() + " " + interfaceC11450m.getName();
            if (str2 != null) {
                return str2;
            }
            m9412a(6);
            throw null;
        }
    }
}
