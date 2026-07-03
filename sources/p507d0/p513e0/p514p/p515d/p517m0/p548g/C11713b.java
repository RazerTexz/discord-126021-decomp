package p507d0.p513e0.p514p.p515d.p517m0.p548g;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.b */
/* JADX INFO: compiled from: FqName.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11713b {

    /* JADX INFO: renamed from: a */
    public static final C11713b f24079a = new C11713b("");

    /* JADX INFO: renamed from: b */
    public final C11714c f24080b;

    /* JADX INFO: renamed from: c */
    public transient C11713b f24081c;

    public C11713b(String str) {
        if (str != null) {
            this.f24080b = new C11714c(str, this);
        } else {
            m9817a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9817a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i2 = 2;
                break;
            case 8:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(str2);
            case 8:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static C11713b topLevel(C11716e c11716e) {
        if (c11716e != null) {
            return new C11713b(C11714c.topLevel(c11716e));
        }
        m9817a(13);
        throw null;
    }

    public String asString() {
        String strAsString = this.f24080b.asString();
        if (strAsString != null) {
            return strAsString;
        }
        m9817a(4);
        throw null;
    }

    public C11713b child(C11716e c11716e) {
        if (c11716e != null) {
            return new C11713b(this.f24080b.child(c11716e), this);
        }
        m9817a(8);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C11713b) && this.f24080b.equals(((C11713b) obj).f24080b);
    }

    public int hashCode() {
        return this.f24080b.hashCode();
    }

    public boolean isRoot() {
        return this.f24080b.isRoot();
    }

    public C11713b parent() {
        C11713b c11713b = this.f24081c;
        if (c11713b != null) {
            if (c11713b != null) {
                return c11713b;
            }
            m9817a(6);
            throw null;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        C11713b c11713b2 = new C11713b(this.f24080b.parent());
        this.f24081c = c11713b2;
        if (c11713b2 != null) {
            return c11713b2;
        }
        m9817a(7);
        throw null;
    }

    public List<C11716e> pathSegments() {
        List<C11716e> listPathSegments = this.f24080b.pathSegments();
        if (listPathSegments != null) {
            return listPathSegments;
        }
        m9817a(11);
        throw null;
    }

    public C11716e shortName() {
        C11716e c11716eShortName = this.f24080b.shortName();
        if (c11716eShortName != null) {
            return c11716eShortName;
        }
        m9817a(9);
        throw null;
    }

    public C11716e shortNameOrSpecial() {
        C11716e c11716eShortNameOrSpecial = this.f24080b.shortNameOrSpecial();
        if (c11716eShortNameOrSpecial != null) {
            return c11716eShortNameOrSpecial;
        }
        m9817a(10);
        throw null;
    }

    public boolean startsWith(C11716e c11716e) {
        if (c11716e != null) {
            return this.f24080b.startsWith(c11716e);
        }
        m9817a(12);
        throw null;
    }

    public String toString() {
        return this.f24080b.toString();
    }

    public C11714c toUnsafe() {
        C11714c c11714c = this.f24080b;
        if (c11714c != null) {
            return c11714c;
        }
        m9817a(5);
        throw null;
    }

    public C11713b(C11714c c11714c) {
        if (c11714c != null) {
            this.f24080b = c11714c;
        } else {
            m9817a(2);
            throw null;
        }
    }

    public C11713b(C11714c c11714c, C11713b c11713b) {
        if (c11714c != null) {
            this.f24080b = c11714c;
            this.f24081c = c11713b;
        } else {
            m9817a(3);
            throw null;
        }
    }
}
