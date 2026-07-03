package p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y;

import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.y.c */
/* JADX INFO: compiled from: JvmClassName.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11839c {

    /* JADX INFO: renamed from: a */
    public final String f24463a;

    public C11839c(String str) {
        if (str != null) {
            this.f24463a = str;
        } else {
            m9945a(5);
            throw null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9945a(int i) {
        String str = (i == 3 || i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static C11839c byClassId(C11712a c11712a) {
        if (c11712a == null) {
            m9945a(1);
            throw null;
        }
        C11713b packageFqName = c11712a.getPackageFqName();
        String strReplace = c11712a.getRelativeClassName().asString().replace('.', '$');
        if (packageFqName.isRoot()) {
            return new C11839c(strReplace);
        }
        return new C11839c(packageFqName.asString().replace('.', MentionUtilsKt.SLASH_CHAR) + AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + strReplace);
    }

    public static C11839c byFqNameWithoutInnerClasses(C11713b c11713b) {
        if (c11713b != null) {
            return new C11839c(c11713b.asString().replace('.', MentionUtilsKt.SLASH_CHAR));
        }
        m9945a(2);
        throw null;
    }

    public static C11839c byInternalName(String str) {
        if (str != null) {
            return new C11839c(str);
        }
        m9945a(0);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C11839c.class != obj.getClass()) {
            return false;
        }
        return this.f24463a.equals(((C11839c) obj).f24463a);
    }

    public C11713b getFqNameForTopLevelClassMaybeWithDollars() {
        return new C11713b(this.f24463a.replace(MentionUtilsKt.SLASH_CHAR, '.'));
    }

    public String getInternalName() {
        String str = this.f24463a;
        if (str != null) {
            return str;
        }
        m9945a(8);
        throw null;
    }

    public C11713b getPackageFqName() {
        int iLastIndexOf = this.f24463a.lastIndexOf(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        if (iLastIndexOf != -1) {
            return new C11713b(this.f24463a.substring(0, iLastIndexOf).replace(MentionUtilsKt.SLASH_CHAR, '.'));
        }
        C11713b c11713b = C11713b.f24079a;
        if (c11713b != null) {
            return c11713b;
        }
        m9945a(7);
        throw null;
    }

    public int hashCode() {
        return this.f24463a.hashCode();
    }

    public String toString() {
        return this.f24463a;
    }
}
