package d0.e0.p.d.m0.g;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.k;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FqNameUnsafe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final e a = e.special("<root>");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f3424b = Pattern.compile("\\.");
    public static final Function1<String, e> c = new c$a();
    public final String d;
    public transient b e;
    public transient c f;
    public transient e g;

    public c(String str, b bVar) {
        if (str == null) {
            a(0);
            throw null;
        }
        this.d = str;
        this.e = bVar;
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

    public static c topLevel(e eVar) {
        if (eVar != null) {
            return new c(eVar.asString(), b.a.toUnsafe(), eVar);
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
            this.g = e.guessByFirstCharacter(this.d.substring(iLastIndexOf + 1));
            this.f = new c(this.d.substring(0, iLastIndexOf));
        } else {
            this.g = e.guessByFirstCharacter(this.d);
            this.f = b.a.toUnsafe();
        }
    }

    public c child(e eVar) {
        String strAsString;
        if (eVar == null) {
            a(9);
            throw null;
        }
        if (isRoot()) {
            strAsString = eVar.asString();
        } else {
            strAsString = this.d + "." + eVar.asString();
        }
        return new c(strAsString, this, eVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.d.equals(((c) obj).d);
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

    public c parent() {
        c cVar = this.f;
        if (cVar != null) {
            if (cVar != null) {
                return cVar;
            }
            a(7);
            throw null;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        b();
        c cVar2 = this.f;
        if (cVar2 != null) {
            return cVar2;
        }
        a(8);
        throw null;
    }

    public List<e> pathSegments() {
        List<e> listEmptyList = isRoot() ? Collections.emptyList() : k.map(f3424b.split(this.d), c);
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(14);
        throw null;
    }

    public e shortName() {
        e eVar = this.g;
        if (eVar != null) {
            if (eVar != null) {
                return eVar;
            }
            a(10);
            throw null;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        b();
        e eVar2 = this.g;
        if (eVar2 != null) {
            return eVar2;
        }
        a(11);
        throw null;
    }

    public e shortNameOrSpecial() {
        if (isRoot()) {
            e eVar = a;
            if (eVar != null) {
                return eVar;
            }
            a(12);
            throw null;
        }
        e eVarShortName = shortName();
        if (eVarShortName != null) {
            return eVarShortName;
        }
        a(13);
        throw null;
    }

    public boolean startsWith(e eVar) {
        if (eVar == null) {
            a(15);
            throw null;
        }
        if (isRoot()) {
            return false;
        }
        int iIndexOf = this.d.indexOf(46);
        String str = this.d;
        String strAsString = eVar.asString();
        if (iIndexOf == -1) {
            iIndexOf = this.d.length();
        }
        return str.regionMatches(0, strAsString, 0, iIndexOf);
    }

    public b toSafe() {
        b bVar = this.e;
        if (bVar != null) {
            if (bVar != null) {
                return bVar;
            }
            a(5);
            throw null;
        }
        b bVar2 = new b(this);
        this.e = bVar2;
        if (bVar2 != null) {
            return bVar2;
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

    public c(String str) {
        if (str != null) {
            this.d = str;
        } else {
            a(2);
            throw null;
        }
    }

    public c(String str, c cVar, e eVar) {
        if (str != null) {
            this.d = str;
            this.f = cVar;
            this.g = eVar;
            return;
        }
        a(3);
        throw null;
    }
}
