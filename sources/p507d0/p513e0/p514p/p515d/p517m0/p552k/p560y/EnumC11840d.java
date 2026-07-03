package p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y;

import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.EnumC11289i;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.y.d */
/* JADX INFO: compiled from: JvmPrimitiveType.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11840d {
    BOOLEAN(EnumC11289i.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(EnumC11289i.CHAR, "char", "C", "java.lang.Character"),
    BYTE(EnumC11289i.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(EnumC11289i.SHORT, "short", ExifInterface.LATITUDE_SOUTH, "java.lang.Short"),
    INT(EnumC11289i.INT, "int", "I", "java.lang.Integer"),
    FLOAT(EnumC11289i.FLOAT, "float", "F", "java.lang.Float"),
    LONG(EnumC11289i.LONG, Constants.LONG, "J", "java.lang.Long"),
    DOUBLE(EnumC11289i.DOUBLE, "double", "D", "java.lang.Double");


    /* JADX INFO: renamed from: r */
    public static final Set<C11713b> f24472r = new HashSet();

    /* JADX INFO: renamed from: s */
    public static final Map<String, EnumC11840d> f24473s = new HashMap();

    /* JADX INFO: renamed from: t */
    public static final Map<EnumC11289i, EnumC11840d> f24474t = new EnumMap(EnumC11289i.class);

    /* JADX INFO: renamed from: u */
    public static final Map<String, EnumC11840d> f24475u = new HashMap();
    private final String desc;
    private final String name;
    private final EnumC11289i primitiveType;
    private final C11713b wrapperFqName;

    static {
        EnumC11840d[] enumC11840dArrValues = values();
        for (int i = 0; i < 8; i++) {
            EnumC11840d enumC11840d = enumC11840dArrValues[i];
            f24472r.add(enumC11840d.getWrapperFqName());
            f24473s.put(enumC11840d.getJavaKeywordName(), enumC11840d);
            f24474t.put(enumC11840d.getPrimitiveType(), enumC11840d);
            f24475u.put(enumC11840d.getDesc(), enumC11840d);
        }
    }

    EnumC11840d(EnumC11289i enumC11289i, String str, String str2, String str3) {
        if (enumC11289i == null) {
            m9946f(6);
            throw null;
        }
        this.primitiveType = enumC11289i;
        this.name = str;
        this.desc = str2;
        this.wrapperFqName = new C11713b(str3);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0017  */
    /* JADX WARN: Code duplicated, block: B:7:0x000c  */
    /* JADX INFO: renamed from: f */
    public static /* synthetic */ void m9946f(int i) {
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

    public static EnumC11840d get(String str) {
        if (str == null) {
            m9946f(1);
            throw null;
        }
        EnumC11840d enumC11840d = f24473s.get(str);
        if (enumC11840d != null) {
            return enumC11840d;
        }
        throw new AssertionError(C1643a.m883w("Non-primitive type name passed: ", str));
    }

    public String getDesc() {
        String str = this.desc;
        if (str != null) {
            return str;
        }
        m9946f(12);
        throw null;
    }

    public String getJavaKeywordName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        m9946f(11);
        throw null;
    }

    public EnumC11289i getPrimitiveType() {
        EnumC11289i enumC11289i = this.primitiveType;
        if (enumC11289i != null) {
            return enumC11289i;
        }
        m9946f(10);
        throw null;
    }

    public C11713b getWrapperFqName() {
        C11713b c11713b = this.wrapperFqName;
        if (c11713b != null) {
            return c11713b;
        }
        m9946f(13);
        throw null;
    }

    public static EnumC11840d get(EnumC11289i enumC11289i) {
        if (enumC11289i != null) {
            EnumC11840d enumC11840d = f24474t.get(enumC11289i);
            if (enumC11840d != null) {
                return enumC11840d;
            }
            m9946f(4);
            throw null;
        }
        m9946f(3);
        throw null;
    }
}
