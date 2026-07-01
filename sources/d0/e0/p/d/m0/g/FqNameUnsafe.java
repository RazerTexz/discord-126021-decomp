package d0.e0.p.d.m0.g;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t._Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.c, reason: use source file name */
/* JADX INFO: compiled from: FqNameUnsafe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FqNameUnsafe {
    public static final Name a = Name.special("<root>");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f3424b = Pattern.compile("\\.");
    public static final Function1<String, Name> c = new a();
    public final String d;
    public transient FqName e;
    public transient FqNameUnsafe f;
    public transient Name g;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.g.c$a */
    /* JADX INFO: compiled from: FqNameUnsafe.java */
    public static class a implements Function1<String, Name> {
        @Override // kotlin.jvm.functions.Function1
        public Name invoke(String str) {
            return Name.guessByFirstCharacter(str);
        }
    }

    public FqNameUnsafe(String str, FqName fqName) {
        if (str == null) {
            a(0);
            throw null;
        }
        this.d = str;
        this.e = fqName;
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
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
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
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i2 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
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
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(str2);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static FqNameUnsafe topLevel(Name name) {
        if (name != null) {
            return new FqNameUnsafe(name.asString(), FqName.a.toUnsafe(), name);
        }
        a(16);
        throw null;
    }

    public String asString() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        a(4);
        throw null;
    }

    public final void b() {
        int iLastIndexOf = this.d.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            this.g = Name.guessByFirstCharacter(this.d.substring(iLastIndexOf + 1));
            this.f = new FqNameUnsafe(this.d.substring(0, iLastIndexOf));
        } else {
            this.g = Name.guessByFirstCharacter(this.d);
            this.f = FqName.a.toUnsafe();
        }
    }

    public FqNameUnsafe child(Name name) {
        String strAsString;
        if (name == null) {
            a(9);
            throw null;
        }
        if (isRoot()) {
            strAsString = name.asString();
        } else {
            strAsString = this.d + "." + name.asString();
        }
        return new FqNameUnsafe(strAsString, this, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqNameUnsafe) && this.d.equals(((FqNameUnsafe) obj).d);
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public boolean isRoot() {
        return this.d.isEmpty();
    }

    public boolean isSafe() {
        return this.e != null || asString().indexOf(60) < 0;
    }

    public FqNameUnsafe parent() {
        FqNameUnsafe fqNameUnsafe = this.f;
        if (fqNameUnsafe != null) {
            if (fqNameUnsafe != null) {
                return fqNameUnsafe;
            }
            a(7);
            throw null;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        b();
        FqNameUnsafe fqNameUnsafe2 = this.f;
        if (fqNameUnsafe2 != null) {
            return fqNameUnsafe2;
        }
        a(8);
        throw null;
    }

    public List<Name> pathSegments() {
        List<Name> listEmptyList = isRoot() ? Collections.emptyList() : _Arrays.map(f3424b.split(this.d), c);
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(14);
        throw null;
    }

    public Name shortName() {
        Name name = this.g;
        if (name != null) {
            if (name != null) {
                return name;
            }
            a(10);
            throw null;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        b();
        Name name2 = this.g;
        if (name2 != null) {
            return name2;
        }
        a(11);
        throw null;
    }

    public Name shortNameOrSpecial() {
        if (isRoot()) {
            Name name = a;
            if (name != null) {
                return name;
            }
            a(12);
            throw null;
        }
        Name nameShortName = shortName();
        if (nameShortName != null) {
            return nameShortName;
        }
        a(13);
        throw null;
    }

    public boolean startsWith(Name name) {
        if (name == null) {
            a(15);
            throw null;
        }
        if (isRoot()) {
            return false;
        }
        int iIndexOf = this.d.indexOf(46);
        String str = this.d;
        String strAsString = name.asString();
        if (iIndexOf == -1) {
            iIndexOf = this.d.length();
        }
        return str.regionMatches(0, strAsString, 0, iIndexOf);
    }

    public FqName toSafe() {
        FqName fqName = this.e;
        if (fqName != null) {
            if (fqName != null) {
                return fqName;
            }
            a(5);
            throw null;
        }
        FqName fqName2 = new FqName(this);
        this.e = fqName2;
        if (fqName2 != null) {
            return fqName2;
        }
        a(6);
        throw null;
    }

    public String toString() {
        String strAsString = isRoot() ? a.asString() : this.d;
        if (strAsString != null) {
            return strAsString;
        }
        a(17);
        throw null;
    }

    public FqNameUnsafe(String str) {
        if (str != null) {
            this.d = str;
        } else {
            a(2);
            throw null;
        }
    }

    public FqNameUnsafe(String str, FqNameUnsafe fqNameUnsafe, Name name) {
        if (str != null) {
            this.d = str;
            this.f = fqNameUnsafe;
            this.g = name;
            return;
        }
        a(3);
        throw null;
    }
}
