package d0.e0.p.d.m0.g;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.b, reason: use source file name */
/* JADX INFO: compiled from: FqName.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FqName {
    public static final FqName a = new FqName("");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FqNameUnsafe f3423b;
    public transient FqName c;

    public FqName(String str) {
        if (str != null) {
            this.f3423b = new FqNameUnsafe(str, this);
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
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

    public static FqName topLevel(Name name) {
        if (name != null) {
            return new FqName(FqNameUnsafe.topLevel(name));
        }
        a(13);
        throw null;
    }

    public String asString() {
        String strAsString = this.f3423b.asString();
        if (strAsString != null) {
            return strAsString;
        }
        a(4);
        throw null;
    }

    public FqName child(Name name) {
        if (name != null) {
            return new FqName(this.f3423b.child(name), this);
        }
        a(8);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqName) && this.f3423b.equals(((FqName) obj).f3423b);
    }

    public int hashCode() {
        return this.f3423b.hashCode();
    }

    public boolean isRoot() {
        return this.f3423b.isRoot();
    }

    public FqName parent() {
        FqName fqName = this.c;
        if (fqName != null) {
            if (fqName != null) {
                return fqName;
            }
            a(6);
            throw null;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        FqName fqName2 = new FqName(this.f3423b.parent());
        this.c = fqName2;
        if (fqName2 != null) {
            return fqName2;
        }
        a(7);
        throw null;
    }

    public List<Name> pathSegments() {
        List<Name> listPathSegments = this.f3423b.pathSegments();
        if (listPathSegments != null) {
            return listPathSegments;
        }
        a(11);
        throw null;
    }

    public Name shortName() {
        Name nameShortName = this.f3423b.shortName();
        if (nameShortName != null) {
            return nameShortName;
        }
        a(9);
        throw null;
    }

    public Name shortNameOrSpecial() {
        Name nameShortNameOrSpecial = this.f3423b.shortNameOrSpecial();
        if (nameShortNameOrSpecial != null) {
            return nameShortNameOrSpecial;
        }
        a(10);
        throw null;
    }

    public boolean startsWith(Name name) {
        if (name != null) {
            return this.f3423b.startsWith(name);
        }
        a(12);
        throw null;
    }

    public String toString() {
        return this.f3423b.toString();
    }

    public FqNameUnsafe toUnsafe() {
        FqNameUnsafe fqNameUnsafe = this.f3423b;
        if (fqNameUnsafe != null) {
            return fqNameUnsafe;
        }
        a(5);
        throw null;
    }

    public FqName(FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe != null) {
            this.f3423b = fqNameUnsafe;
        } else {
            a(2);
            throw null;
        }
    }

    public FqName(FqNameUnsafe fqNameUnsafe, FqName fqName) {
        if (fqNameUnsafe != null) {
            this.f3423b = fqNameUnsafe;
            this.c = fqName;
        } else {
            a(3);
            throw null;
        }
    }
}
