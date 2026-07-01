package d0.e0.p.d.m0.k.y;

import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.i;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: JvmPrimitiveType.java */
/* JADX INFO: loaded from: classes3.dex */
public enum d {
    BOOLEAN(i.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(i.CHAR, "char", "C", "java.lang.Character"),
    BYTE(i.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(i.SHORT, "short", ExifInterface.LATITUDE_SOUTH, "java.lang.Short"),
    INT(i.INT, "int", "I", "java.lang.Integer"),
    FLOAT(i.FLOAT, "float", "F", "java.lang.Float"),
    LONG(i.LONG, Constants.LONG, "J", "java.lang.Long"),
    DOUBLE(i.DOUBLE, "double", "D", "java.lang.Double");

    public static final Set<d0.e0.p.d.m0.g.b> r = new HashSet();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Map<String, d> f3479s = new HashMap();
    public static final Map<i, d> t = new EnumMap(i.class);
    public static final Map<String, d> u = new HashMap();
    private final String desc;
    private final String name;
    private final i primitiveType;
    private final d0.e0.p.d.m0.g.b wrapperFqName;

    static {
        d[] dVarArrValues = values();
        for (int i = 0; i < 8; i++) {
            d dVar = dVarArrValues[i];
            r.add(dVar.getWrapperFqName());
            f3479s.put(dVar.getJavaKeywordName(), dVar);
            t.put(dVar.getPrimitiveType(), dVar);
            u.put(dVar.getDesc(), dVar);
        }
    }

    d(i iVar, String str, String str2, String str3) {
        if (iVar == null) {
            f(6);
            throw null;
        }
        this.primitiveType = iVar;
        this.name = str;
        this.desc = str2;
        this.wrapperFqName = new d0.e0.p.d.m0.g.b(str3);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0017  */
    /* JADX WARN: Code duplicated, block: B:7:0x000c  */
    public static /* synthetic */ void f(int i) {
        String str;
        int i2;
        if (i != 2 && i != 4) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                case 13:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 2 && i != 4) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                case 13:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 7:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                break;
            case 3:
                objArr[0] = "type";
                break;
            case 5:
            case 8:
                objArr[0] = "desc";
                break;
            case 6:
                objArr[0] = "primitiveType";
                break;
            case 9:
                objArr[0] = "wrapperClassName";
                break;
            default:
                objArr[0] = "className";
                break;
        }
        if (i != 2 && i != 4) {
            switch (i) {
                case 10:
                    objArr[1] = "getPrimitiveType";
                    break;
                case 11:
                    objArr[1] = "getJavaKeywordName";
                    break;
                case 12:
                    objArr[1] = "getDesc";
                    break;
                case 13:
                    objArr[1] = "getWrapperFqName";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                    break;
            }
        } else {
            objArr[1] = "get";
        }
        switch (i) {
            case 1:
            case 3:
                objArr[2] = "get";
                break;
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 5:
                objArr[2] = "getByDesc";
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "isWrapperClassName";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 4) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static d get(String str) {
        if (str == null) {
            f(1);
            throw null;
        }
        d dVar = f3479s.get(str);
        if (dVar != null) {
            return dVar;
        }
        throw new AssertionError(b.d.b.a.a.w("Non-primitive type name passed: ", str));
    }

    public String getDesc() {
        String str = this.desc;
        if (str != null) {
            return str;
        }
        f(12);
        throw null;
    }

    public String getJavaKeywordName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        f(11);
        throw null;
    }

    public i getPrimitiveType() {
        i iVar = this.primitiveType;
        if (iVar != null) {
            return iVar;
        }
        f(10);
        throw null;
    }

    public d0.e0.p.d.m0.g.b getWrapperFqName() {
        d0.e0.p.d.m0.g.b bVar = this.wrapperFqName;
        if (bVar != null) {
            return bVar;
        }
        f(13);
        throw null;
    }

    public static d get(i iVar) {
        if (iVar != null) {
            d dVar = t.get(iVar);
            if (dVar != null) {
                return dVar;
            }
            f(4);
            throw null;
        }
        f(3);
        throw null;
    }
}
