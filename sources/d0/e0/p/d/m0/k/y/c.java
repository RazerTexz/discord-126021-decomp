package d0.e0.p.d.m0.k.y;

import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;

/* JADX INFO: compiled from: JvmClassName.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public final String a;

    public c(String str) {
        if (str != null) {
            this.a = str;
        } else {
            a(5);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
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

    public static c byClassId(d0.e0.p.d.m0.g.a aVar) {
        if (aVar == null) {
            a(1);
            throw null;
        }
        d0.e0.p.d.m0.g.b packageFqName = aVar.getPackageFqName();
        String strReplace = aVar.getRelativeClassName().asString().replace('.', '$');
        if (packageFqName.isRoot()) {
            return new c(strReplace);
        }
        return new c(packageFqName.asString().replace('.', MentionUtilsKt.SLASH_CHAR) + AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + strReplace);
    }

    public static c byFqNameWithoutInnerClasses(d0.e0.p.d.m0.g.b bVar) {
        if (bVar != null) {
            return new c(bVar.asString().replace('.', MentionUtilsKt.SLASH_CHAR));
        }
        a(2);
        throw null;
    }

    public static c byInternalName(String str) {
        if (str != null) {
            return new c(str);
        }
        a(0);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((c) obj).a);
    }

    public d0.e0.p.d.m0.g.b getFqNameForTopLevelClassMaybeWithDollars() {
        return new d0.e0.p.d.m0.g.b(this.a.replace(MentionUtilsKt.SLASH_CHAR, '.'));
    }

    public String getInternalName() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        a(8);
        throw null;
    }

    public d0.e0.p.d.m0.g.b getPackageFqName() {
        int iLastIndexOf = this.a.lastIndexOf(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        if (iLastIndexOf != -1) {
            return new d0.e0.p.d.m0.g.b(this.a.substring(0, iLastIndexOf).replace(MentionUtilsKt.SLASH_CHAR, '.'));
        }
        d0.e0.p.d.m0.g.b bVar = d0.e0.p.d.m0.g.b.a;
        if (bVar != null) {
            return bVar;
        }
        a(7);
        throw null;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}
