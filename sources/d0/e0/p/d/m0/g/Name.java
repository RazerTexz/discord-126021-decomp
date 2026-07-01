package d0.e0.p.d.m0.g;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.e, reason: use source file name */
/* JADX INFO: compiled from: Name.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Name implements Comparable<Name> {
    public final String j;
    public final boolean k;

    public Name(String str, boolean z2) {
        if (str == null) {
            f(0);
            throw null;
        }
        this.j = str;
        this.k = z2;
    }

    public static /* synthetic */ void f(int i) {
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

    public static Name guessByFirstCharacter(String str) {
        if (str != null) {
            return str.startsWith("<") ? special(str) : identifier(str);
        }
        f(6);
        throw null;
    }

    public static Name identifier(String str) {
        if (str != null) {
            return new Name(str, false);
        }
        f(3);
        throw null;
    }

    public static boolean isValidIdentifier(String str) {
        if (str == null) {
            f(4);
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

    public static Name special(String str) {
        if (str == null) {
            f(5);
            throw null;
        }
        if (str.startsWith("<")) {
            return new Name(str, true);
        }
        throw new IllegalArgumentException(outline.w("special name must start with '<': ", str));
    }

    public String asString() {
        String str = this.j;
        if (str != null) {
            return str;
        }
        f(1);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        return this.k == name.k && this.j.equals(name.j);
    }

    public String getIdentifier() {
        if (this.k) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String strAsString = asString();
        if (strAsString != null) {
            return strAsString;
        }
        f(2);
        throw null;
    }

    public int hashCode() {
        return (this.j.hashCode() * 31) + (this.k ? 1 : 0);
    }

    public boolean isSpecial() {
        return this.k;
    }

    public String toString() {
        return this.j;
    }

    @Override // java.lang.Comparable
    public int compareTo(Name name) {
        return this.j.compareTo(name.j);
    }
}
