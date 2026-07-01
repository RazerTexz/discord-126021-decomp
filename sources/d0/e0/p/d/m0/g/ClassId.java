package d0.e0.p.d.m0.g;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.g0.Strings4;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.a, reason: use source file name */
/* JADX INFO: compiled from: ClassId.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassId {
    public final FqName a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FqName f3422b;
    public final boolean c;

    public ClassId(FqName fqName, FqName fqName2, boolean z2) {
        if (fqName == null) {
            a(1);
            throw null;
        }
        if (fqName2 == null) {
            a(2);
            throw null;
        }
        this.a = fqName;
        this.f3422b = fqName2;
        this.c = z2;
    }

    public static /* synthetic */ void a(int i) {
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

    public static ClassId fromString(String str) {
        if (str != null) {
            return fromString(str, false);
        }
        a(11);
        throw null;
    }

    public static ClassId topLevel(FqName fqName) {
        if (fqName != null) {
            return new ClassId(fqName.parent(), fqName.shortName());
        }
        a(0);
        throw null;
    }

    public FqName asSingleFqName() {
        if (this.a.isRoot()) {
            FqName fqName = this.f3422b;
            if (fqName != null) {
                return fqName;
            }
            a(9);
            throw null;
        }
        return new FqName(this.a.asString() + "." + this.f3422b.asString());
    }

    public String asString() {
        if (this.a.isRoot()) {
            String strAsString = this.f3422b.asString();
            if (strAsString != null) {
                return strAsString;
            }
            a(13);
            throw null;
        }
        String str = this.a.asString().replace('.', MentionUtils.SLASH_CHAR) + AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + this.f3422b.asString();
        if (str != null) {
            return str;
        }
        a(14);
        throw null;
    }

    public ClassId createNestedClassId(Name name) {
        if (name != null) {
            return new ClassId(getPackageFqName(), this.f3422b.child(name), this.c);
        }
        a(8);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClassId.class != obj.getClass()) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        return this.a.equals(classId.a) && this.f3422b.equals(classId.f3422b) && this.c == classId.c;
    }

    public ClassId getOuterClassId() {
        FqName fqNameParent = this.f3422b.parent();
        if (fqNameParent.isRoot()) {
            return null;
        }
        return new ClassId(getPackageFqName(), fqNameParent, this.c);
    }

    public FqName getPackageFqName() {
        FqName fqName = this.a;
        if (fqName != null) {
            return fqName;
        }
        a(5);
        throw null;
    }

    public FqName getRelativeClassName() {
        FqName fqName = this.f3422b;
        if (fqName != null) {
            return fqName;
        }
        a(6);
        throw null;
    }

    public Name getShortClassName() {
        Name nameShortName = this.f3422b.shortName();
        if (nameShortName != null) {
            return nameShortName;
        }
        a(7);
        throw null;
    }

    public int hashCode() {
        return Boolean.valueOf(this.c).hashCode() + ((this.f3422b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public boolean isLocal() {
        return this.c;
    }

    public boolean isNestedClass() {
        return !this.f3422b.parent().isRoot();
    }

    public String toString() {
        if (!this.a.isRoot()) {
            return asString();
        }
        StringBuilder sbU = outline.U(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        sbU.append(asString());
        return sbU.toString();
    }

    public static ClassId fromString(String str, boolean z2) {
        if (str != null) {
            return new ClassId(new FqName(Strings4.substringBeforeLast(str, MentionUtils.SLASH_CHAR, "").replace(MentionUtils.SLASH_CHAR, '.')), new FqName(Strings4.substringAfterLast(str, MentionUtils.SLASH_CHAR, str)), z2);
        }
        a(12);
        throw null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClassId(FqName fqName, Name name) {
        this(fqName, FqName.topLevel(name), false);
        if (fqName == null) {
            a(3);
            throw null;
        }
        if (name != null) {
        } else {
            a(4);
            throw null;
        }
    }
}
