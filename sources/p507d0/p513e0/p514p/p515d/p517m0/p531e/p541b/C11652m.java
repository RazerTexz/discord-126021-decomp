package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import androidx.exifinterface.media.ExifInterface;
import kotlin.NoWhenBranchMatchedException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.EnumC11289i;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.AbstractC11650k;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.C11839c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.EnumC11840d;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.m */
/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11652m implements InterfaceC11651l<AbstractC11650k> {

    /* JADX INFO: renamed from: a */
    public static final C11652m f23629a = new C11652m();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11651l
    public AbstractC11650k boxType(AbstractC11650k abstractC11650k) {
        C12238m.checkNotNullParameter(abstractC11650k, "possiblyPrimitiveType");
        if (!(abstractC11650k instanceof AbstractC11650k.d)) {
            return abstractC11650k;
        }
        AbstractC11650k.d dVar = (AbstractC11650k.d) abstractC11650k;
        if (dVar.getJvmPrimitiveType() == null) {
            return abstractC11650k;
        }
        String internalName = C11839c.byFqNameWithoutInnerClasses(dVar.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
        C12238m.checkNotNullExpressionValue(internalName, "byFqNameWithoutInnerClasses(possiblyPrimitiveType.jvmPrimitiveType.wrapperFqName).internalName");
        return createObjectType2(internalName);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11651l
    public AbstractC11650k createFromString(String str) {
        EnumC11840d enumC11840d;
        AbstractC11650k cVar;
        C12238m.checkNotNullParameter(str, "representation");
        str.length();
        char cCharAt = str.charAt(0);
        EnumC11840d[] enumC11840dArrValues = EnumC11840d.values();
        int i = 0;
        while (true) {
            if (i >= 8) {
                enumC11840d = null;
                break;
            }
            enumC11840d = enumC11840dArrValues[i];
            if (enumC11840d.getDesc().charAt(0) == cCharAt) {
                break;
            }
            i++;
        }
        if (enumC11840d != null) {
            return new AbstractC11650k.d(enumC11840d);
        }
        if (cCharAt == 'V') {
            return new AbstractC11650k.d(null);
        }
        if (cCharAt == '[') {
            String strSubstring = str.substring(1);
            C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            cVar = new AbstractC11650k.a(createFromString(strSubstring));
        } else {
            if (cCharAt == 'L') {
                C12106w.endsWith$default((CharSequence) str, ';', false, 2, (Object) null);
            }
            String strSubstring2 = str.substring(1, str.length() - 1);
            C12238m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            cVar = new AbstractC11650k.c(strSubstring2);
        }
        return cVar;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11651l
    /* JADX INFO: renamed from: createObjectType, reason: merged with bridge method [inline-methods] */
    public AbstractC11650k createObjectType2(String str) {
        C12238m.checkNotNullParameter(str, "internalName");
        return new AbstractC11650k.c(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11651l
    public AbstractC11650k createPrimitiveType(EnumC11289i enumC11289i) {
        C12238m.checkNotNullParameter(enumC11289i, "primitiveType");
        switch (enumC11289i) {
            case BOOLEAN:
                return AbstractC11650k.f23617a.getBOOLEAN$descriptors_jvm();
            case CHAR:
                return AbstractC11650k.f23617a.getCHAR$descriptors_jvm();
            case BYTE:
                return AbstractC11650k.f23617a.getBYTE$descriptors_jvm();
            case SHORT:
                return AbstractC11650k.f23617a.getSHORT$descriptors_jvm();
            case INT:
                return AbstractC11650k.f23617a.getINT$descriptors_jvm();
            case FLOAT:
                return AbstractC11650k.f23617a.getFLOAT$descriptors_jvm();
            case LONG:
                return AbstractC11650k.f23617a.getLONG$descriptors_jvm();
            case DOUBLE:
                return AbstractC11650k.f23617a.getDOUBLE$descriptors_jvm();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11651l
    public AbstractC11650k getJavaLangClassType() {
        return createObjectType2("java/lang/Class");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11651l
    public String toString(AbstractC11650k abstractC11650k) {
        String desc;
        C12238m.checkNotNullParameter(abstractC11650k, "type");
        if (abstractC11650k instanceof AbstractC11650k.a) {
            return C12238m.stringPlus("[", toString(((AbstractC11650k.a) abstractC11650k).getElementType()));
        }
        if (abstractC11650k instanceof AbstractC11650k.d) {
            EnumC11840d jvmPrimitiveType = ((AbstractC11650k.d) abstractC11650k).getJvmPrimitiveType();
            return (jvmPrimitiveType == null || (desc = jvmPrimitiveType.getDesc()) == null) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : desc;
        }
        if (!(abstractC11650k instanceof AbstractC11650k.c)) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sbM829Q = C1643a.m829Q('L');
        sbM829Q.append(((AbstractC11650k.c) abstractC11650k).getInternalName());
        sbM829Q.append(';');
        return sbM829Q.toString();
    }
}
