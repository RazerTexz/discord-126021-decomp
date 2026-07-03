package p507d0.p513e0.p514p.p515d.p517m0.p548g;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.e */
/* JADX INFO: compiled from: Name.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11716e implements Comparable<C11716e> {

    /* JADX INFO: renamed from: j */
    public final String f24089j;

    /* JADX INFO: renamed from: k */
    public final boolean f24090k;

    public C11716e(String str, boolean z2) {
        if (str == null) {
            m9820f(0);
            throw null;
        }
        this.f24089j = str;
        this.f24090k = z2;
    }

    /* JADX INFO: renamed from: f */
    public static /* synthetic */ void m9820f(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[1] = "getIdentifier";
        }
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "identifier";
                break;
            case 4:
                objArr[2] = "isValidIdentifier";
                break;
            case 5:
                objArr[2] = "special";
                break;
            case 6:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static C11716e guessByFirstCharacter(String str) {
        if (str != null) {
            return str.startsWith("<") ? special(str) : identifier(str);
        }
        m9820f(6);
        throw null;
    }

    public static C11716e identifier(String str) {
        if (str != null) {
            return new C11716e(str, false);
        }
        m9820f(3);
        throw null;
    }

    public static boolean isValidIdentifier(String str) {
        if (str == null) {
            m9820f(4);
            throw null;
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '.' || cCharAt == '/' || cCharAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static C11716e special(String str) {
        if (str == null) {
            m9820f(5);
            throw null;
        }
        if (str.startsWith("<")) {
            return new C11716e(str, true);
        }
        throw new IllegalArgumentException(C1643a.m883w("special name must start with '<': ", str));
    }

    public String asString() {
        String str = this.f24089j;
        if (str != null) {
            return str;
        }
        m9820f(1);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11716e)) {
            return false;
        }
        C11716e c11716e = (C11716e) obj;
        return this.f24090k == c11716e.f24090k && this.f24089j.equals(c11716e.f24089j);
    }

    public String getIdentifier() {
        if (this.f24090k) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String strAsString = asString();
        if (strAsString != null) {
            return strAsString;
        }
        m9820f(2);
        throw null;
    }

    public int hashCode() {
        return (this.f24089j.hashCode() * 31) + (this.f24090k ? 1 : 0);
    }

    public boolean isSpecial() {
        return this.f24090k;
    }

    public String toString() {
        return this.f24089j;
    }

    @Override // java.lang.Comparable
    public int compareTo(C11716e c11716e) {
        return this.f24089j.compareTo(c11716e.f24089j);
    }
}
