package p507d0.p513e0.p514p.p515d.p517m0.p548g;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.a */
/* JADX INFO: compiled from: ClassId.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11712a {

    /* JADX INFO: renamed from: a */
    public final C11713b f24076a;

    /* JADX INFO: renamed from: b */
    public final C11713b f24077b;

    /* JADX INFO: renamed from: c */
    public final boolean f24078c;

    public C11712a(C11713b c11713b, C11713b c11713b2, boolean z2) {
        if (c11713b == null) {
            m9816a(1);
            throw null;
        }
        if (c11713b2 == null) {
            m9816a(2);
            throw null;
        }
        this.f24076a = c11713b;
        this.f24077b = c11713b2;
        this.f24078c = z2;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9816a(int i) {
        String str = (i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? 2 : 3];
        switch (i) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = "string";
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i == 7) {
            objArr[1] = "getShortClassName";
        } else if (i == 9) {
            objArr[1] = "asSingleFqName";
        } else if (i == 13 || i == 14) {
            objArr[1] = "asString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 6 && i != 7 && i != 9 && i != 13 && i != 14) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static C11712a fromString(String str) {
        if (str != null) {
            return fromString(str, false);
        }
        m9816a(11);
        throw null;
    }

    public static C11712a topLevel(C11713b c11713b) {
        if (c11713b != null) {
            return new C11712a(c11713b.parent(), c11713b.shortName());
        }
        m9816a(0);
        throw null;
    }

    public C11713b asSingleFqName() {
        if (this.f24076a.isRoot()) {
            C11713b c11713b = this.f24077b;
            if (c11713b != null) {
                return c11713b;
            }
            m9816a(9);
            throw null;
        }
        return new C11713b(this.f24076a.asString() + "." + this.f24077b.asString());
    }

    public String asString() {
        if (this.f24076a.isRoot()) {
            String strAsString = this.f24077b.asString();
            if (strAsString != null) {
                return strAsString;
            }
            m9816a(13);
            throw null;
        }
        String str = this.f24076a.asString().replace('.', MentionUtilsKt.SLASH_CHAR) + AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + this.f24077b.asString();
        if (str != null) {
            return str;
        }
        m9816a(14);
        throw null;
    }

    public C11712a createNestedClassId(C11716e c11716e) {
        if (c11716e != null) {
            return new C11712a(getPackageFqName(), this.f24077b.child(c11716e), this.f24078c);
        }
        m9816a(8);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C11712a.class != obj.getClass()) {
            return false;
        }
        C11712a c11712a = (C11712a) obj;
        return this.f24076a.equals(c11712a.f24076a) && this.f24077b.equals(c11712a.f24077b) && this.f24078c == c11712a.f24078c;
    }

    public C11712a getOuterClassId() {
        C11713b c11713bParent = this.f24077b.parent();
        if (c11713bParent.isRoot()) {
            return null;
        }
        return new C11712a(getPackageFqName(), c11713bParent, this.f24078c);
    }

    public C11713b getPackageFqName() {
        C11713b c11713b = this.f24076a;
        if (c11713b != null) {
            return c11713b;
        }
        m9816a(5);
        throw null;
    }

    public C11713b getRelativeClassName() {
        C11713b c11713b = this.f24077b;
        if (c11713b != null) {
            return c11713b;
        }
        m9816a(6);
        throw null;
    }

    public C11716e getShortClassName() {
        C11716e c11716eShortName = this.f24077b.shortName();
        if (c11716eShortName != null) {
            return c11716eShortName;
        }
        m9816a(7);
        throw null;
    }

    public int hashCode() {
        return Boolean.valueOf(this.f24078c).hashCode() + ((this.f24077b.hashCode() + (this.f24076a.hashCode() * 31)) * 31);
    }

    public boolean isLocal() {
        return this.f24078c;
    }

    public boolean isNestedClass() {
        return !this.f24077b.parent().isRoot();
    }

    public String toString() {
        if (!this.f24076a.isRoot()) {
            return asString();
        }
        StringBuilder sbM833U = C1643a.m833U(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        sbM833U.append(asString());
        return sbM833U.toString();
    }

    public static C11712a fromString(String str, boolean z2) {
        if (str != null) {
            return new C11712a(new C11713b(C12106w.substringBeforeLast(str, MentionUtilsKt.SLASH_CHAR, "").replace(MentionUtilsKt.SLASH_CHAR, '.')), new C11713b(C12106w.substringAfterLast(str, MentionUtilsKt.SLASH_CHAR, str)), z2);
        }
        m9816a(12);
        throw null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11712a(C11713b c11713b, C11716e c11716e) {
        this(c11713b, C11713b.topLevel(c11716e), false);
        if (c11713b == null) {
            m9816a(3);
            throw null;
        }
        if (c11716e != null) {
        } else {
            m9816a(4);
            throw null;
        }
    }
}
