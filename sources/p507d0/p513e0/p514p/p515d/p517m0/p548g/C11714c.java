package p507d0.p513e0.p514p.p515d.p517m0.p548g;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12141k;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.c */
/* JADX INFO: compiled from: FqNameUnsafe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11714c {

    /* JADX INFO: renamed from: a */
    public static final C11716e f24082a = C11716e.special("<root>");

    /* JADX INFO: renamed from: b */
    public static final Pattern f24083b = Pattern.compile("\\.");

    /* JADX INFO: renamed from: c */
    public static final Function1<String, C11716e> f24084c = new a();

    /* JADX INFO: renamed from: d */
    public final String f24085d;

    /* JADX INFO: renamed from: e */
    public transient C11713b f24086e;

    /* JADX INFO: renamed from: f */
    public transient C11714c f24087f;

    /* JADX INFO: renamed from: g */
    public transient C11716e f24088g;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.g.c$a */
    /* JADX INFO: compiled from: FqNameUnsafe.java */
    public static class a implements Function1<String, C11716e> {
        @Override // kotlin.jvm.functions.Function1
        public C11716e invoke(String str) {
            return C11716e.guessByFirstCharacter(str);
        }
    }

    public C11714c(String str, C11713b c11713b) {
        if (str == null) {
            m9818a(0);
            throw null;
        }
        this.f24085d = str;
        this.f24086e = c11713b;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9818a(int i) {
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

    public static C11714c topLevel(C11716e c11716e) {
        if (c11716e != null) {
            return new C11714c(c11716e.asString(), C11713b.f24079a.toUnsafe(), c11716e);
        }
        m9818a(16);
        throw null;
    }

    public String asString() {
        String str = this.f24085d;
        if (str != null) {
            return str;
        }
        m9818a(4);
        throw null;
    }

    /* JADX INFO: renamed from: b */
    public final void m9819b() {
        int iLastIndexOf = this.f24085d.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            this.f24088g = C11716e.guessByFirstCharacter(this.f24085d.substring(iLastIndexOf + 1));
            this.f24087f = new C11714c(this.f24085d.substring(0, iLastIndexOf));
        } else {
            this.f24088g = C11716e.guessByFirstCharacter(this.f24085d);
            this.f24087f = C11713b.f24079a.toUnsafe();
        }
    }

    public C11714c child(C11716e c11716e) {
        String strAsString;
        if (c11716e == null) {
            m9818a(9);
            throw null;
        }
        if (isRoot()) {
            strAsString = c11716e.asString();
        } else {
            strAsString = this.f24085d + "." + c11716e.asString();
        }
        return new C11714c(strAsString, this, c11716e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C11714c) && this.f24085d.equals(((C11714c) obj).f24085d);
    }

    public int hashCode() {
        return this.f24085d.hashCode();
    }

    public boolean isRoot() {
        return this.f24085d.isEmpty();
    }

    public boolean isSafe() {
        return this.f24086e != null || asString().indexOf(60) < 0;
    }

    public C11714c parent() {
        C11714c c11714c = this.f24087f;
        if (c11714c != null) {
            if (c11714c != null) {
                return c11714c;
            }
            m9818a(7);
            throw null;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        m9819b();
        C11714c c11714c2 = this.f24087f;
        if (c11714c2 != null) {
            return c11714c2;
        }
        m9818a(8);
        throw null;
    }

    public List<C11716e> pathSegments() {
        List<C11716e> listEmptyList = isRoot() ? Collections.emptyList() : C12141k.map(f24083b.split(this.f24085d), f24084c);
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9818a(14);
        throw null;
    }

    public C11716e shortName() {
        C11716e c11716e = this.f24088g;
        if (c11716e != null) {
            if (c11716e != null) {
                return c11716e;
            }
            m9818a(10);
            throw null;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        m9819b();
        C11716e c11716e2 = this.f24088g;
        if (c11716e2 != null) {
            return c11716e2;
        }
        m9818a(11);
        throw null;
    }

    public C11716e shortNameOrSpecial() {
        if (isRoot()) {
            C11716e c11716e = f24082a;
            if (c11716e != null) {
                return c11716e;
            }
            m9818a(12);
            throw null;
        }
        C11716e c11716eShortName = shortName();
        if (c11716eShortName != null) {
            return c11716eShortName;
        }
        m9818a(13);
        throw null;
    }

    public boolean startsWith(C11716e c11716e) {
        if (c11716e == null) {
            m9818a(15);
            throw null;
        }
        if (isRoot()) {
            return false;
        }
        int iIndexOf = this.f24085d.indexOf(46);
        String str = this.f24085d;
        String strAsString = c11716e.asString();
        if (iIndexOf == -1) {
            iIndexOf = this.f24085d.length();
        }
        return str.regionMatches(0, strAsString, 0, iIndexOf);
    }

    public C11713b toSafe() {
        C11713b c11713b = this.f24086e;
        if (c11713b != null) {
            if (c11713b != null) {
                return c11713b;
            }
            m9818a(5);
            throw null;
        }
        C11713b c11713b2 = new C11713b(this);
        this.f24086e = c11713b2;
        if (c11713b2 != null) {
            return c11713b2;
        }
        m9818a(6);
        throw null;
    }

    public String toString() {
        String strAsString = isRoot() ? f24082a.asString() : this.f24085d;
        if (strAsString != null) {
            return strAsString;
        }
        m9818a(17);
        throw null;
    }

    public C11714c(String str) {
        if (str != null) {
            this.f24085d = str;
        } else {
            m9818a(2);
            throw null;
        }
    }

    public C11714c(String str, C11714c c11714c, C11716e c11716e) {
        if (str != null) {
            this.f24085d = str;
            this.f24087f = c11714c;
            this.f24088g = c11716e;
            return;
        }
        m9818a(3);
        throw null;
    }
}
