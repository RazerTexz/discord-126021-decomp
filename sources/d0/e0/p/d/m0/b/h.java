package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.h1.c$b;
import d0.e0.p.d.m0.c.i1.y;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.o0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.s;
import d0.e0.p.d.m0.c.w;
import d0.e0.p.d.m0.m.f$m;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.y0;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: KotlinBuiltIns.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static final d0.e0.p.d.m0.g.e a = d0.e0.p.d.m0.g.e.special("<built-ins module>");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f3211b;
    public final d0.e0.p.d.m0.m.j<h$e> c;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.c.e> d;
    public final d0.e0.p.d.m0.m.o e;

    public h(d0.e0.p.d.m0.m.o oVar) {
        if (oVar == null) {
            a(0);
            throw null;
        }
        this.e = oVar;
        oVar.createLazyValue(new h$a(this));
        this.c = oVar.createLazyValue(new h$b(this));
        this.d = oVar.createMemoizedFunction(new h$c(this));
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                i2 = 2;
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 71:
                objArr[0] = "module";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 8:
            case 9:
            case 75:
            case 76:
            case 88:
            case 95:
            case 102:
            case 106:
            case 107:
            case Opcodes.D2F /* 144 */:
            case Opcodes.I2B /* 145 */:
            case Opcodes.I2S /* 147 */:
            case 155:
            case 156:
            case 157:
                objArr[0] = "descriptor";
                break;
            case 11:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case Opcodes.I2F /* 134 */:
                objArr[0] = "fqName";
                break;
            case 13:
                objArr[0] = "simpleName";
                break;
            case 15:
            case 16:
            case 52:
            case 87:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 96:
            case 98:
            case 104:
            case 108:
            case 109:
            case 110:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case Opcodes.LUSHR /* 125 */:
            case 126:
            case Opcodes.LAND /* 127 */:
            case 128:
            case Opcodes.LOR /* 129 */:
            case 130:
            case Opcodes.LXOR /* 131 */:
            case Opcodes.IINC /* 132 */:
            case Opcodes.I2L /* 133 */:
            case Opcodes.I2D /* 135 */:
            case Opcodes.L2I /* 136 */:
            case Opcodes.L2F /* 137 */:
            case Opcodes.L2D /* 138 */:
            case Opcodes.F2I /* 139 */:
            case Opcodes.F2L /* 140 */:
            case Opcodes.F2D /* 141 */:
            case Opcodes.D2I /* 142 */:
            case Opcodes.D2L /* 143 */:
            case Opcodes.I2C /* 146 */:
            case Opcodes.LCMP /* 148 */:
            case Opcodes.FCMPL /* 149 */:
            case 150:
            case Opcodes.DCMPL /* 151 */:
            case Opcodes.DCMPG /* 152 */:
            case 153:
            case 154:
            case Opcodes.IF_ICMPEQ /* 159 */:
                objArr[0] = "type";
                break;
            case 45:
                objArr[0] = "classSimpleName";
                break;
            case 66:
                objArr[0] = "arrayType";
                break;
            case 70:
                objArr[0] = "notNullArrayType";
                break;
            case 72:
                objArr[0] = "primitiveType";
                break;
            case 74:
                objArr[0] = "kotlinType";
                break;
            case 77:
            case 81:
                objArr[0] = "projectionType";
                break;
            case 78:
            case 82:
            case 84:
                objArr[0] = "argument";
                break;
            case 79:
                objArr[0] = "annotations";
                break;
            case 100:
                objArr[0] = "typeConstructor";
                break;
            case 111:
                objArr[0] = "classDescriptor";
                break;
            case 158:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 2:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 3:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 4:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 5:
                objArr[1] = "getStorageManager";
                break;
            case 6:
                objArr[1] = "getBuiltInsModule";
                break;
            case 7:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 10:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 12:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 17:
                objArr[1] = "getSuspendFunction";
                break;
            case 18:
                objArr[1] = "getKFunction";
                break;
            case 19:
                objArr[1] = "getKSuspendFunction";
                break;
            case 20:
                objArr[1] = "getKClass";
                break;
            case 21:
                objArr[1] = "getKCallable";
                break;
            case 22:
                objArr[1] = "getKProperty";
                break;
            case 23:
                objArr[1] = "getKProperty0";
                break;
            case 24:
                objArr[1] = "getKProperty1";
                break;
            case 25:
                objArr[1] = "getKProperty2";
                break;
            case 26:
                objArr[1] = "getKMutableProperty0";
                break;
            case 27:
                objArr[1] = "getKMutableProperty1";
                break;
            case 28:
                objArr[1] = "getKMutableProperty2";
                break;
            case 29:
                objArr[1] = "getIterator";
                break;
            case 30:
                objArr[1] = "getIterable";
                break;
            case 31:
                objArr[1] = "getMutableIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterator";
                break;
            case 33:
                objArr[1] = "getCollection";
                break;
            case 34:
                objArr[1] = "getMutableCollection";
                break;
            case 35:
                objArr[1] = "getList";
                break;
            case 36:
                objArr[1] = "getMutableList";
                break;
            case 37:
                objArr[1] = "getSet";
                break;
            case 38:
                objArr[1] = "getMutableSet";
                break;
            case 39:
                objArr[1] = "getMap";
                break;
            case 40:
                objArr[1] = "getMutableMap";
                break;
            case 41:
                objArr[1] = "getMapEntry";
                break;
            case 42:
                objArr[1] = "getMutableMapEntry";
                break;
            case 43:
                objArr[1] = "getListIterator";
                break;
            case 44:
                objArr[1] = "getMutableListIterator";
                break;
            case 46:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 47:
                objArr[1] = "getNothingType";
                break;
            case 48:
                objArr[1] = "getNullableNothingType";
                break;
            case 49:
                objArr[1] = "getAnyType";
                break;
            case 50:
                objArr[1] = "getNullableAnyType";
                break;
            case 51:
                objArr[1] = "getDefaultBound";
                break;
            case 53:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 54:
                objArr[1] = "getNumberType";
                break;
            case 55:
                objArr[1] = "getByteType";
                break;
            case 56:
                objArr[1] = "getShortType";
                break;
            case 57:
                objArr[1] = "getIntType";
                break;
            case 58:
                objArr[1] = "getLongType";
                break;
            case 59:
                objArr[1] = "getFloatType";
                break;
            case 60:
                objArr[1] = "getDoubleType";
                break;
            case 61:
                objArr[1] = "getCharType";
                break;
            case 62:
                objArr[1] = "getBooleanType";
                break;
            case 63:
                objArr[1] = "getUnitType";
                break;
            case 64:
                objArr[1] = "getStringType";
                break;
            case 65:
                objArr[1] = "getIterableType";
                break;
            case 67:
            case 68:
            case 69:
                objArr[1] = "getArrayElementType";
                break;
            case 73:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 80:
            case 83:
                objArr[1] = "getArrayType";
                break;
            case 85:
                objArr[1] = "getEnumType";
                break;
            case 86:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                break;
            case 8:
                objArr[2] = "isBuiltIn";
                break;
            case 9:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 11:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 13:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 15:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 16:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 45:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 52:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 66:
                objArr[2] = "getArrayElementType";
                break;
            case 70:
            case 71:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 72:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 74:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 75:
            case 92:
                objArr[2] = "getPrimitiveType";
                break;
            case 76:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
                objArr[2] = "getArrayType";
                break;
            case 84:
                objArr[2] = "getEnumType";
                break;
            case 87:
                objArr[2] = "isArray";
                break;
            case 88:
            case 89:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 90:
                objArr[2] = "isPrimitiveArray";
                break;
            case 91:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 93:
                objArr[2] = "isPrimitiveType";
                break;
            case 94:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveClass";
                break;
            case 96:
            case 97:
            case 98:
            case 99:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 100:
            case 101:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 102:
            case 103:
                objArr[2] = "classFqNameEquals";
                break;
            case 104:
            case 105:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 106:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 107:
            case 108:
                objArr[2] = "isAny";
                break;
            case 109:
            case 111:
                objArr[2] = "isBoolean";
                break;
            case 110:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 112:
                objArr[2] = "isNumber";
                break;
            case 113:
                objArr[2] = "isChar";
                break;
            case 114:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 115:
                objArr[2] = "isInt";
                break;
            case 116:
                objArr[2] = "isByte";
                break;
            case 117:
                objArr[2] = "isLong";
                break;
            case 118:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 119:
                objArr[2] = "isShort";
                break;
            case 120:
                objArr[2] = "isFloat";
                break;
            case 121:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 122:
                objArr[2] = "isDouble";
                break;
            case 123:
                objArr[2] = "isUByte";
                break;
            case 124:
                objArr[2] = "isUShort";
                break;
            case Opcodes.LUSHR /* 125 */:
                objArr[2] = "isUInt";
                break;
            case 126:
                objArr[2] = "isULong";
                break;
            case Opcodes.LAND /* 127 */:
                objArr[2] = "isUByteArray";
                break;
            case 128:
                objArr[2] = "isUShortArray";
                break;
            case Opcodes.LOR /* 129 */:
                objArr[2] = "isUIntArray";
                break;
            case 130:
                objArr[2] = "isULongArray";
                break;
            case Opcodes.LXOR /* 131 */:
                objArr[2] = "isUnsignedArrayType";
                break;
            case Opcodes.IINC /* 132 */:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case Opcodes.I2L /* 133 */:
            case Opcodes.I2F /* 134 */:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case Opcodes.I2D /* 135 */:
                objArr[2] = "isNothing";
                break;
            case Opcodes.L2I /* 136 */:
                objArr[2] = "isNullableNothing";
                break;
            case Opcodes.L2F /* 137 */:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case Opcodes.L2D /* 138 */:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case Opcodes.F2I /* 139 */:
                objArr[2] = "isNullableAny";
                break;
            case Opcodes.F2L /* 140 */:
                objArr[2] = "isDefaultBound";
                break;
            case Opcodes.F2D /* 141 */:
                objArr[2] = "isUnit";
                break;
            case Opcodes.D2I /* 142 */:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case Opcodes.D2L /* 143 */:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case Opcodes.D2F /* 144 */:
                objArr[2] = "isMemberOfAny";
                break;
            case Opcodes.I2B /* 145 */:
            case Opcodes.I2C /* 146 */:
                objArr[2] = "isEnum";
                break;
            case Opcodes.I2S /* 147 */:
            case Opcodes.LCMP /* 148 */:
                objArr[2] = "isComparable";
                break;
            case Opcodes.FCMPL /* 149 */:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 150:
                objArr[2] = "isListOrNullableList";
                break;
            case Opcodes.DCMPL /* 151 */:
                objArr[2] = "isSetOrNullableSet";
                break;
            case Opcodes.DCMPG /* 152 */:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 153:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 154:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 155:
                objArr[2] = "isKClass";
                break;
            case 156:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 157:
                objArr[2] = "isCloneable";
                break;
            case 158:
                objArr[2] = "isDeprecated";
                break;
            case Opcodes.IF_ICMPEQ /* 159 */:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                throw new IllegalStateException(str2);
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static j0 b(h hVar, String str) {
        Objects.requireNonNull(hVar);
        if (str == null) {
            a(45);
            throw null;
        }
        j0 defaultType = hVar.f(str).getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(46);
        throw null;
    }

    public static boolean c(d0.e0.p.d.m0.c.h hVar, d0.e0.p.d.m0.g.c cVar) {
        if (hVar == null) {
            a(102);
            throw null;
        }
        if (cVar != null) {
            return hVar.getName().equals(cVar.shortName()) && cVar.equals(d0.e0.p.d.m0.k.e.getFqName(hVar));
        }
        a(103);
        throw null;
    }

    public static i getPrimitiveArrayType(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(76);
            throw null;
        }
        if (k$a.n0.contains(mVar.getName())) {
            return k$a.p0.get(d0.e0.p.d.m0.k.e.getFqName(mVar));
        }
        return null;
    }

    public static i getPrimitiveType(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(75);
            throw null;
        }
        if (k$a.m0.contains(mVar.getName())) {
            return k$a.o0.get(d0.e0.p.d.m0.k.e.getFqName(mVar));
        }
        return null;
    }

    public static boolean i(c0 c0Var, d0.e0.p.d.m0.g.c cVar) {
        if (c0Var == null) {
            a(96);
            throw null;
        }
        if (cVar != null) {
            return isTypeConstructorForGivenClass(c0Var.getConstructor(), cVar);
        }
        a(97);
        throw null;
    }

    public static boolean isAny(d0.e0.p.d.m0.c.e eVar) {
        if (eVar != null) {
            return c(eVar, k$a.f3217b);
        }
        a(107);
        throw null;
    }

    public static boolean isAnyOrNullableAny(c0 c0Var) {
        if (c0Var != null) {
            return i(c0Var, k$a.f3217b);
        }
        a(Opcodes.L2D);
        throw null;
    }

    public static boolean isArray(c0 c0Var) {
        if (c0Var != null) {
            return i(c0Var, k$a.h);
        }
        a(87);
        throw null;
    }

    public static boolean isArrayOrPrimitiveArray(d0.e0.p.d.m0.c.e eVar) {
        if (eVar != null) {
            return c(eVar, k$a.h) || getPrimitiveArrayType(eVar) != null;
        }
        a(88);
        throw null;
    }

    public static boolean isBoolean(c0 c0Var) {
        if (c0Var != null) {
            return j(c0Var, k$a.i);
        }
        a(109);
        throw null;
    }

    public static boolean isBuiltIn(d0.e0.p.d.m0.c.m mVar) {
        if (mVar != null) {
            return d0.e0.p.d.m0.k.e.getParentOfType(mVar, b.class, false) != null;
        }
        a(8);
        throw null;
    }

    public static boolean isByte(c0 c0Var) {
        if (c0Var != null) {
            return j(c0Var, k$a.k);
        }
        a(116);
        throw null;
    }

    public static boolean isChar(c0 c0Var) {
        if (c0Var != null) {
            return j(c0Var, k$a.j);
        }
        a(113);
        throw null;
    }

    public static boolean isDefaultBound(c0 c0Var) {
        if (c0Var != null) {
            return isNullableAny(c0Var);
        }
        a(Opcodes.F2L);
        throw null;
    }

    public static boolean isDeprecated(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(158);
            throw null;
        }
        if (mVar.getOriginal().getAnnotations().hasAnnotation(k$a.u)) {
            return true;
        }
        if (!(mVar instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) mVar;
        boolean zIsVar = n0Var.isVar();
        o0 getter = n0Var.getGetter();
        p0 setter = n0Var.getSetter();
        if (getter != null && isDeprecated(getter)) {
            if (!zIsVar) {
                return true;
            }
            if (setter != null && isDeprecated(setter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDouble(c0 c0Var) {
        if (c0Var != null) {
            return isDoubleOrNullableDouble(c0Var) && !c0Var.isMarkedNullable();
        }
        a(122);
        throw null;
    }

    public static boolean isDoubleOrNullableDouble(c0 c0Var) {
        if (c0Var != null) {
            return i(c0Var, k$a.p);
        }
        a(Opcodes.IINC);
        throw null;
    }

    public static boolean isFloat(c0 c0Var) {
        if (c0Var != null) {
            return isFloatOrNullableFloat(c0Var) && !c0Var.isMarkedNullable();
        }
        a(120);
        throw null;
    }

    public static boolean isFloatOrNullableFloat(c0 c0Var) {
        if (c0Var != null) {
            return i(c0Var, k$a.o);
        }
        a(121);
        throw null;
    }

    public static boolean isInt(c0 c0Var) {
        if (c0Var != null) {
            return j(c0Var, k$a.m);
        }
        a(115);
        throw null;
    }

    public static boolean isKClass(d0.e0.p.d.m0.c.e eVar) {
        if (eVar != null) {
            return c(eVar, k$a.X);
        }
        a(155);
        throw null;
    }

    public static boolean isLong(c0 c0Var) {
        if (c0Var != null) {
            return j(c0Var, k$a.n);
        }
        a(117);
        throw null;
    }

    public static boolean isNothing(c0 c0Var) {
        if (c0Var != null) {
            return isNothingOrNullableNothing(c0Var) && !e1.isNullableType(c0Var);
        }
        a(Opcodes.I2D);
        throw null;
    }

    public static boolean isNothingOrNullableNothing(c0 c0Var) {
        if (c0Var != null) {
            return i(c0Var, k$a.c);
        }
        a(Opcodes.L2F);
        throw null;
    }

    public static boolean isNullableAny(c0 c0Var) {
        if (c0Var != null) {
            return isAnyOrNullableAny(c0Var) && c0Var.isMarkedNullable();
        }
        a(Opcodes.F2I);
        throw null;
    }

    public static boolean isPrimitiveArray(c0 c0Var) {
        if (c0Var != null) {
            d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
            return (declarationDescriptor == null || getPrimitiveArrayType(declarationDescriptor) == null) ? false : true;
        }
        a(90);
        throw null;
    }

    public static boolean isPrimitiveClass(d0.e0.p.d.m0.c.e eVar) {
        if (eVar != null) {
            return getPrimitiveType(eVar) != null;
        }
        a(95);
        throw null;
    }

    public static boolean isPrimitiveType(c0 c0Var) {
        if (c0Var != null) {
            return !c0Var.isMarkedNullable() && isPrimitiveTypeOrNullablePrimitiveType(c0Var);
        }
        a(93);
        throw null;
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(c0 c0Var) {
        if (c0Var != null) {
            d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
            return (declarationDescriptor instanceof d0.e0.p.d.m0.c.e) && isPrimitiveClass((d0.e0.p.d.m0.c.e) declarationDescriptor);
        }
        a(94);
        throw null;
    }

    public static boolean isShort(c0 c0Var) {
        if (c0Var != null) {
            return j(c0Var, k$a.l);
        }
        a(119);
        throw null;
    }

    public static boolean isSpecialClassWithNoSupertypes(d0.e0.p.d.m0.c.e eVar) {
        if (eVar != null) {
            return c(eVar, k$a.f3217b) || c(eVar, k$a.c);
        }
        a(106);
        throw null;
    }

    public static boolean isString(c0 c0Var) {
        return c0Var != null && k(c0Var, k$a.g);
    }

    public static boolean isTypeConstructorForGivenClass(u0 u0Var, d0.e0.p.d.m0.g.c cVar) {
        if (u0Var == null) {
            a(100);
            throw null;
        }
        if (cVar != null) {
            d0.e0.p.d.m0.c.h declarationDescriptor = u0Var.getDeclarationDescriptor();
            return (declarationDescriptor instanceof d0.e0.p.d.m0.c.e) && c(declarationDescriptor, cVar);
        }
        a(101);
        throw null;
    }

    public static boolean isUByteArray(c0 c0Var) {
        if (c0Var != null) {
            return j(c0Var, k$a.f3225i0.toUnsafe());
        }
        a(Opcodes.LAND);
        throw null;
    }

    public static boolean isUIntArray(c0 c0Var) {
        if (c0Var != null) {
            return j(c0Var, k$a.k0.toUnsafe());
        }
        a(Opcodes.LOR);
        throw null;
    }

    public static boolean isULongArray(c0 c0Var) {
        if (c0Var != null) {
            return j(c0Var, k$a.l0.toUnsafe());
        }
        a(130);
        throw null;
    }

    public static boolean isUShortArray(c0 c0Var) {
        if (c0Var != null) {
            return j(c0Var, k$a.f3226j0.toUnsafe());
        }
        a(128);
        throw null;
    }

    public static boolean isUnderKotlinPackage(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            a(9);
            throw null;
        }
        while (mVar != null) {
            if (mVar instanceof e0) {
                return ((e0) mVar).getFqName().startsWith(k.k);
            }
            mVar = mVar.getContainingDeclaration();
        }
        return false;
    }

    public static boolean isUnit(c0 c0Var) {
        if (c0Var != null) {
            return k(c0Var, k$a.e);
        }
        a(Opcodes.F2D);
        throw null;
    }

    public static boolean isUnsignedArrayType(c0 c0Var) {
        if (c0Var != null) {
            return isUByteArray(c0Var) || isUShortArray(c0Var) || isUIntArray(c0Var) || isULongArray(c0Var);
        }
        a(Opcodes.LXOR);
        throw null;
    }

    public static boolean j(c0 c0Var, d0.e0.p.d.m0.g.c cVar) {
        if (c0Var == null) {
            a(Opcodes.I2L);
            throw null;
        }
        if (cVar != null) {
            return i(c0Var, cVar) && !c0Var.isMarkedNullable();
        }
        a(Opcodes.I2F);
        throw null;
    }

    public static boolean k(c0 c0Var, d0.e0.p.d.m0.g.c cVar) {
        if (c0Var == null) {
            a(104);
            throw null;
        }
        if (cVar != null) {
            return !c0Var.isMarkedNullable() && i(c0Var, cVar);
        }
        a(105);
        throw null;
    }

    public void d(boolean z2) {
        y yVar = new y(a, this.e, this, null);
        this.f3211b = yVar;
        yVar.initialize(a.a.getInstance().createPackageFragmentProvider(this.e, this.f3211b, g(), h(), e(), z2));
        y yVar2 = this.f3211b;
        yVar2.setDependencies(yVar2);
    }

    public d0.e0.p.d.m0.c.h1.a e() {
        return d0.e0.p.d.m0.c.h1.a$a.a;
    }

    public final d0.e0.p.d.m0.c.e f(String str) {
        if (str == null) {
            a(13);
            throw null;
        }
        d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) ((f$m) this.d).invoke(d0.e0.p.d.m0.g.e.identifier(str));
        if (eVar != null) {
            return eVar;
        }
        a(14);
        throw null;
    }

    public Iterable<d0.e0.p.d.m0.c.h1.b> g() {
        List listSingletonList = Collections.singletonList(new d0.e0.p.d.m0.b.p.a(this.e, this.f3211b));
        if (listSingletonList != null) {
            return listSingletonList;
        }
        a(4);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getAny() {
        return f("Any");
    }

    public j0 getAnyType() {
        j0 defaultType = getAny().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(49);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getArray() {
        return f("Array");
    }

    public c0 getArrayElementType(c0 c0Var) {
        d0.e0.p.d.m0.g.a classId;
        d0.e0.p.d.m0.g.a unsignedClassIdByArrayClassId;
        d0.e0.p.d.m0.c.e eVarFindClassAcrossModuleDependencies;
        j0 defaultType = null;
        if (c0Var == null) {
            a(66);
            throw null;
        }
        if (isArray(c0Var)) {
            if (c0Var.getArguments().size() != 1) {
                throw new IllegalStateException();
            }
            c0 type = c0Var.getArguments().get(0).getType();
            if (type != null) {
                return type;
            }
            a(67);
            throw null;
        }
        c0 c0VarMakeNotNullable = e1.makeNotNullable(c0Var);
        j0 j0Var = this.c.invoke().c.get(c0VarMakeNotNullable);
        if (j0Var != null) {
            return j0Var;
        }
        d0.e0.p.d.m0.c.c0 containingModuleOrNull = d0.e0.p.d.m0.k.e.getContainingModuleOrNull(c0VarMakeNotNullable);
        if (containingModuleOrNull != null) {
            if (c0VarMakeNotNullable == null) {
                a(70);
                throw null;
            }
            d0.e0.p.d.m0.c.h declarationDescriptor = c0VarMakeNotNullable.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor != null) {
                o oVar = o.a;
                if (oVar.isShortNameOfUnsignedArray(declarationDescriptor.getName()) && (classId = d0.e0.p.d.m0.k.x.a.getClassId(declarationDescriptor)) != null && (unsignedClassIdByArrayClassId = oVar.getUnsignedClassIdByArrayClassId(classId)) != null && (eVarFindClassAcrossModuleDependencies = w.findClassAcrossModuleDependencies(containingModuleOrNull, unsignedClassIdByArrayClassId)) != null) {
                    defaultType = eVarFindClassAcrossModuleDependencies.getDefaultType();
                }
            }
            if (defaultType != null) {
                return defaultType;
            }
        }
        throw new IllegalStateException("not array: " + c0Var);
    }

    public j0 getArrayType(j1 j1Var, c0 c0Var, d0.e0.p.d.m0.c.g1.g gVar) {
        if (j1Var == null) {
            a(77);
            throw null;
        }
        if (c0Var == null) {
            a(78);
            throw null;
        }
        if (gVar == null) {
            a(79);
            throw null;
        }
        j0 j0VarSimpleNotNullType = d0.simpleNotNullType(gVar, getArray(), Collections.singletonList(new y0(j1Var, c0Var)));
        if (j0VarSimpleNotNullType != null) {
            return j0VarSimpleNotNullType;
        }
        a(80);
        throw null;
    }

    public j0 getBooleanType() {
        j0 primitiveKotlinType = getPrimitiveKotlinType(i.BOOLEAN);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(62);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getBuiltInClassByFqName(d0.e0.p.d.m0.g.b bVar) {
        if (bVar == null) {
            a(11);
            throw null;
        }
        d0.e0.p.d.m0.c.e eVarResolveClassByFqName = s.resolveClassByFqName(this.f3211b, bVar, d0.e0.p.d.m0.d.b.d.FROM_BUILTINS);
        if (eVarResolveClassByFqName != null) {
            return eVarResolveClassByFqName;
        }
        a(12);
        throw null;
    }

    public y getBuiltInsModule() {
        y yVar = this.f3211b;
        if (yVar != null) {
            return yVar;
        }
        a(6);
        throw null;
    }

    public d0.e0.p.d.m0.k.a0.i getBuiltInsPackageScope() {
        d0.e0.p.d.m0.k.a0.i memberScope = this.f3211b.getPackage(k.l).getMemberScope();
        if (memberScope != null) {
            return memberScope;
        }
        a(10);
        throw null;
    }

    public j0 getByteType() {
        j0 primitiveKotlinType = getPrimitiveKotlinType(i.BYTE);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(55);
        throw null;
    }

    public j0 getCharType() {
        j0 primitiveKotlinType = getPrimitiveKotlinType(i.CHAR);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(61);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getCollection() {
        d0.e0.p.d.m0.c.e builtInClassByFqName = getBuiltInClassByFqName(k$a.J);
        if (builtInClassByFqName != null) {
            return builtInClassByFqName;
        }
        a(33);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getComparable() {
        return f("Comparable");
    }

    public j0 getDefaultBound() {
        j0 nullableAnyType = getNullableAnyType();
        if (nullableAnyType != null) {
            return nullableAnyType;
        }
        a(51);
        throw null;
    }

    public j0 getDoubleType() {
        j0 primitiveKotlinType = getPrimitiveKotlinType(i.DOUBLE);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(60);
        throw null;
    }

    public j0 getFloatType() {
        j0 primitiveKotlinType = getPrimitiveKotlinType(i.FLOAT);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(59);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getFunction(int i) {
        return f(k.getFunctionName(i));
    }

    public j0 getIntType() {
        j0 primitiveKotlinType = getPrimitiveKotlinType(i.INT);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(57);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getKClass() {
        d0.e0.p.d.m0.c.e builtInClassByFqName = getBuiltInClassByFqName(k$a.X.toSafe());
        if (builtInClassByFqName != null) {
            return builtInClassByFqName;
        }
        a(20);
        throw null;
    }

    public j0 getLongType() {
        j0 primitiveKotlinType = getPrimitiveKotlinType(i.LONG);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(58);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getNothing() {
        return f("Nothing");
    }

    public j0 getNothingType() {
        j0 defaultType = getNothing().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(47);
        throw null;
    }

    public j0 getNullableAnyType() {
        j0 j0VarMakeNullableAsSpecified = getAnyType().makeNullableAsSpecified(true);
        if (j0VarMakeNullableAsSpecified != null) {
            return j0VarMakeNullableAsSpecified;
        }
        a(50);
        throw null;
    }

    public j0 getNullableNothingType() {
        j0 j0VarMakeNullableAsSpecified = getNothingType().makeNullableAsSpecified(true);
        if (j0VarMakeNullableAsSpecified != null) {
            return j0VarMakeNullableAsSpecified;
        }
        a(48);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getNumber() {
        return f("Number");
    }

    public j0 getNumberType() {
        j0 defaultType = getNumber().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(54);
        throw null;
    }

    public j0 getPrimitiveArrayKotlinType(i iVar) {
        if (iVar == null) {
            a(72);
            throw null;
        }
        j0 j0Var = this.c.invoke().a.get(iVar);
        if (j0Var != null) {
            return j0Var;
        }
        a(73);
        throw null;
    }

    public j0 getPrimitiveKotlinType(i iVar) {
        if (iVar == null) {
            a(52);
            throw null;
        }
        if (iVar == null) {
            a(15);
            throw null;
        }
        j0 defaultType = f(iVar.getTypeName().asString()).getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(53);
        throw null;
    }

    public j0 getShortType() {
        j0 primitiveKotlinType = getPrimitiveKotlinType(i.SHORT);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(56);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getString() {
        return f("String");
    }

    public j0 getStringType() {
        j0 defaultType = getString().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(64);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getSuspendFunction(int i) {
        d0.e0.p.d.m0.c.e builtInClassByFqName = getBuiltInClassByFqName(k.d.child(d0.e0.p.d.m0.g.e.identifier(k.getSuspendFunctionName(i))));
        if (builtInClassByFqName != null) {
            return builtInClassByFqName;
        }
        a(17);
        throw null;
    }

    public d0.e0.p.d.m0.c.e getUnit() {
        return f("Unit");
    }

    public j0 getUnitType() {
        j0 defaultType = getUnit().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(63);
        throw null;
    }

    public d0.e0.p.d.m0.c.h1.c h() {
        return c$b.a;
    }

    public void setBuiltInsModule(y yVar) {
        if (yVar != null) {
            this.e.compute(new h$d(this, yVar));
        } else {
            a(1);
            throw null;
        }
    }

    public j0 getArrayType(j1 j1Var, c0 c0Var) {
        if (j1Var == null) {
            a(81);
            throw null;
        }
        if (c0Var != null) {
            j0 arrayType = getArrayType(j1Var, c0Var, d0.e0.p.d.m0.c.g1.g.f.getEMPTY());
            if (arrayType != null) {
                return arrayType;
            }
            a(83);
            throw null;
        }
        a(82);
        throw null;
    }
}
