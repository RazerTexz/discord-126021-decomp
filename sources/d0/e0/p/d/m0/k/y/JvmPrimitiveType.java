package d0.e0.p.d.m0.k.y;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.g.FqName;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.y.d, reason: use source file name */
/* JADX INFO: compiled from: JvmPrimitiveType.java */
/* JADX INFO: loaded from: classes3.dex */
public enum JvmPrimitiveType {
    BOOLEAN(PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(PrimitiveType.CHAR, "char", "C", "java.lang.Character"),
    BYTE(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(PrimitiveType.SHORT, "short", ExifInterface.LATITUDE_SOUTH, "java.lang.Short"),
    INT(PrimitiveType.INT, "int", "I", "java.lang.Integer"),
    FLOAT(PrimitiveType.FLOAT, "float", "F", "java.lang.Float"),
    LONG(PrimitiveType.LONG, Constants.LONG, "J", "java.lang.Long"),
    DOUBLE(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");

    public static final Set<FqName> r = new HashSet();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Map<String, JvmPrimitiveType> f3479s = new HashMap();
    public static final Map<PrimitiveType, JvmPrimitiveType> t = new EnumMap(PrimitiveType.class);
    public static final Map<String, JvmPrimitiveType> u = new HashMap();
    private final String desc;
    private final String name;
    private final PrimitiveType primitiveType;
    private final FqName wrapperFqName;

    static {
        JvmPrimitiveType[] jvmPrimitiveTypeArrValues = values();
        for (int i = 0; i < 8; i++) {
            JvmPrimitiveType jvmPrimitiveType = jvmPrimitiveTypeArrValues[i];
            r.add(jvmPrimitiveType.getWrapperFqName());
            f3479s.put(jvmPrimitiveType.getJavaKeywordName(), jvmPrimitiveType);
            t.put(jvmPrimitiveType.getPrimitiveType(), jvmPrimitiveType);
            u.put(jvmPrimitiveType.getDesc(), jvmPrimitiveType);
        }
    }

    JvmPrimitiveType(PrimitiveType primitiveType, String str, String str2, String str3) {
        if (primitiveType == null) {
            f(6);
            throw null;
        }
        this.primitiveType = primitiveType;
        this.name = str;
        this.desc = str2;
        this.wrapperFqName = new FqName(str3);
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

    public static JvmPrimitiveType get(String str) {
        if (str == null) {
            f(1);
            throw null;
        }
        JvmPrimitiveType jvmPrimitiveType = f3479s.get(str);
        if (jvmPrimitiveType != null) {
            return jvmPrimitiveType;
        }
        throw new AssertionError(outline.w("Non-primitive type name passed: ", str));
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

    public PrimitiveType getPrimitiveType() {
        PrimitiveType primitiveType = this.primitiveType;
        if (primitiveType != null) {
            return primitiveType;
        }
        f(10);
        throw null;
    }

    public FqName getWrapperFqName() {
        FqName fqName = this.wrapperFqName;
        if (fqName != null) {
            return fqName;
        }
        f(13);
        throw null;
    }

    public static JvmPrimitiveType get(PrimitiveType primitiveType) {
        if (primitiveType != null) {
            JvmPrimitiveType jvmPrimitiveType = t.get(primitiveType);
            if (jvmPrimitiveType != null) {
                return jvmPrimitiveType;
            }
            f(4);
            throw null;
        }
        f(3);
        throw null;
    }
}
