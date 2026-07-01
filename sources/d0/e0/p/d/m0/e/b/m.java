package d0.e0.p.d.m0.e.b;

import androidx.exifinterface.media.ExifInterface;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements l<k> {
    public static final m a = new m();

    @Override // d0.e0.p.d.m0.e.b.l
    public /* bridge */ /* synthetic */ k boxType(k kVar) {
        return boxType2(kVar);
    }

    @Override // d0.e0.p.d.m0.e.b.l
    public /* bridge */ /* synthetic */ k createFromString(String str) {
        return createFromString(str);
    }

    @Override // d0.e0.p.d.m0.e.b.l
    /* JADX INFO: renamed from: createObjectType, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ k createObjectType2(String str) {
        return createObjectType(str);
    }

    @Override // d0.e0.p.d.m0.e.b.l
    public /* bridge */ /* synthetic */ k createPrimitiveType(d0.e0.p.d.m0.b.i iVar) {
        return createPrimitiveType(iVar);
    }

    @Override // d0.e0.p.d.m0.e.b.l
    public /* bridge */ /* synthetic */ k getJavaLangClassType() {
        return getJavaLangClassType();
    }

    @Override // d0.e0.p.d.m0.e.b.l
    public /* bridge */ /* synthetic */ String toString(k kVar) {
        return toString2(kVar);
    }

    /* JADX INFO: renamed from: boxType, reason: avoid collision after fix types in other method */
    public k boxType2(k kVar) {
        d0.z.d.m.checkNotNullParameter(kVar, "possiblyPrimitiveType");
        if (!(kVar instanceof k$d)) {
            return kVar;
        }
        k$d k_d = (k$d) kVar;
        if (k_d.getJvmPrimitiveType() == null) {
            return kVar;
        }
        String internalName = d0.e0.p.d.m0.k.y.c.byFqNameWithoutInnerClasses(k_d.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
        d0.z.d.m.checkNotNullExpressionValue(internalName, "byFqNameWithoutInnerClasses(possiblyPrimitiveType.jvmPrimitiveType.wrapperFqName).internalName");
        return createObjectType(internalName);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d0.e0.p.d.m0.e.b.l
    public k createFromString(String str) {
        d0.e0.p.d.m0.k.y.d dVar;
        k k_c;
        d0.z.d.m.checkNotNullParameter(str, "representation");
        str.length();
        char cCharAt = str.charAt(0);
        d0.e0.p.d.m0.k.y.d[] dVarArrValues = d0.e0.p.d.m0.k.y.d.values();
        int i = 0;
        while (true) {
            if (i >= 8) {
                dVar = null;
                break;
            }
            dVar = dVarArrValues[i];
            if (dVar.getDesc().charAt(0) == cCharAt) {
                break;
            }
            i++;
        }
        if (dVar != null) {
            return new k$d(dVar);
        }
        if (cCharAt == 'V') {
            return new k$d(null);
        }
        if (cCharAt == '[') {
            String strSubstring = str.substring(1);
            d0.z.d.m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            k_c = new k$a(createFromString(strSubstring));
        } else {
            if (cCharAt == 'L') {
                d0.g0.w.endsWith$default((CharSequence) str, ';', false, 2, (Object) null);
            }
            String strSubstring2 = str.substring(1, str.length() - 1);
            d0.z.d.m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            k_c = new k$c(strSubstring2);
        }
        return k_c;
    }

    @Override // d0.e0.p.d.m0.e.b.l
    public k createObjectType(String str) {
        d0.z.d.m.checkNotNullParameter(str, "internalName");
        return new k$c(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d0.e0.p.d.m0.e.b.l
    public k createPrimitiveType(d0.e0.p.d.m0.b.i iVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "primitiveType");
        switch (iVar.ordinal()) {
            case 0:
                return k.a.getBOOLEAN$descriptors_jvm();
            case 1:
                return k.a.getCHAR$descriptors_jvm();
            case 2:
                return k.a.getBYTE$descriptors_jvm();
            case 3:
                return k.a.getSHORT$descriptors_jvm();
            case 4:
                return k.a.getINT$descriptors_jvm();
            case 5:
                return k.a.getFLOAT$descriptors_jvm();
            case 6:
                return k.a.getLONG$descriptors_jvm();
            case 7:
                return k.a.getDOUBLE$descriptors_jvm();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d0.e0.p.d.m0.e.b.l
    public k getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }

    /* JADX INFO: renamed from: toString, reason: avoid collision after fix types in other method */
    public String toString2(k kVar) {
        String desc;
        d0.z.d.m.checkNotNullParameter(kVar, "type");
        if (kVar instanceof k$a) {
            return d0.z.d.m.stringPlus("[", toString2(((k$a) kVar).getElementType()));
        }
        if (kVar instanceof k$d) {
            d0.e0.p.d.m0.k.y.d jvmPrimitiveType = ((k$d) kVar).getJvmPrimitiveType();
            return (jvmPrimitiveType == null || (desc = jvmPrimitiveType.getDesc()) == null) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : desc;
        }
        if (!(kVar instanceof k$c)) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sbQ = b.d.b.a.a.Q('L');
        sbQ.append(((k$c) kVar).getInternalName());
        sbQ.append(';');
        return sbQ.toString();
    }
}
