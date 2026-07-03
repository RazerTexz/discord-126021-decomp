package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.NoWhenBranchMatchedException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.AbstractC11252d;
import p507d0.p513e0.p514p.p515d.AbstractC11254e;
import p507d0.p513e0.p514p.p515d.AbstractC12053s;
import p507d0.p513e0.p514p.p515d.p516l0.AbstractC11273e;
import p507d0.p513e0.p514p.p515d.p516l0.AbstractC11277i;
import p507d0.p513e0.p514p.p515d.p516l0.C11276h;
import p507d0.p513e0.p514p.p515d.p516l0.C11278j;
import p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.C11667a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11675h;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11789g;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.C11865j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.w */
/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12057w {
    /* JADX WARN: Code duplicated, block: B:15:0x0058  */
    public static final InterfaceC11272d access$computeCallerForAccessor(AbstractC12053s.a aVar, boolean z2) {
        AbstractC11252d.e setterSignature;
        Method setterMethod;
        InterfaceC11272d aVar2;
        C11667a.c setter;
        Method unboxMethod;
        if (AbstractC11262i.f22380l.getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection().matches(aVar.getProperty().getSignature())) {
            return C11278j.f22446a;
        }
        C12054t c12054t = new C12054t(aVar);
        C12056v c12056v = new C12056v(aVar, z2, new C12055u(aVar), c12054t);
        AbstractC11254e abstractC11254eMapPropertySignature = C11257f0.f22358b.mapPropertySignature(aVar.getProperty().getDescriptor());
        if (abstractC11254eMapPropertySignature instanceof AbstractC11254e.c) {
            AbstractC11254e.c cVar = (AbstractC11254e.c) abstractC11254eMapPropertySignature;
            C11667a.d signature = cVar.getSignature();
            if (z2) {
                if (signature.hasGetter()) {
                    setter = signature.getGetter();
                } else {
                    setter = null;
                }
            } else if (signature.hasSetter()) {
                setter = signature.getSetter();
            } else {
                setter = null;
            }
            Method methodFindMethodBySignature = setter != null ? aVar.getProperty().getContainer().findMethodBySignature(cVar.getNameResolver().getString(setter.getName()), cVar.getNameResolver().getString(setter.getDesc())) : null;
            if (methodFindMethodBySignature == null) {
                if (C11789g.isUnderlyingPropertyOfInlineClass(aVar.getProperty().getDescriptor()) && C12238m.areEqual(aVar.getProperty().getDescriptor().getVisibility(), C11464t.f23086d)) {
                    Class<?> inlineClass = C11276h.toInlineClass(aVar.getProperty().getDescriptor().getContainingDeclaration());
                    if (inlineClass == null || (unboxMethod = C11276h.getUnboxMethod(inlineClass, aVar.getProperty().getDescriptor())) == null) {
                        StringBuilder sbM833U = C1643a.m833U("Underlying property of inline class ");
                        sbM833U.append(aVar.getProperty());
                        sbM833U.append(" should have a field");
                        throw new C11247a0(sbM833U.toString());
                    }
                    aVar2 = aVar.isBound() ? new AbstractC11277i.a(unboxMethod, getBoundReceiver(aVar)) : new AbstractC11277i.b(unboxMethod);
                } else {
                    Field javaField = aVar.getProperty().getJavaField();
                    if (javaField == null) {
                        StringBuilder sbM833U2 = C1643a.m833U("No accessors or field is found for property ");
                        sbM833U2.append(aVar.getProperty());
                        throw new C11247a0(sbM833U2.toString());
                    }
                    aVar2 = c12056v.invoke2(javaField);
                }
            } else if (!Modifier.isStatic(methodFindMethodBySignature.getModifiers())) {
                aVar2 = aVar.isBound() ? new AbstractC11273e.h.a(methodFindMethodBySignature, getBoundReceiver(aVar)) : new AbstractC11273e.h.d(methodFindMethodBySignature);
            } else if (c12054t.invoke2()) {
                aVar2 = aVar.isBound() ? new AbstractC11273e.h.b(methodFindMethodBySignature) : new AbstractC11273e.h.e(methodFindMethodBySignature);
            } else {
                aVar2 = aVar.isBound() ? new AbstractC11273e.h.c(methodFindMethodBySignature, getBoundReceiver(aVar)) : new AbstractC11273e.h.f(methodFindMethodBySignature);
            }
        } else if (abstractC11254eMapPropertySignature instanceof AbstractC11254e.a) {
            aVar2 = c12056v.invoke2(((AbstractC11254e.a) abstractC11254eMapPropertySignature).getField());
        } else {
            if (!(abstractC11254eMapPropertySignature instanceof AbstractC11254e.b)) {
                if (!(abstractC11254eMapPropertySignature instanceof AbstractC11254e.d)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (z2) {
                    setterSignature = ((AbstractC11254e.d) abstractC11254eMapPropertySignature).getGetterSignature();
                } else {
                    setterSignature = ((AbstractC11254e.d) abstractC11254eMapPropertySignature).getSetterSignature();
                    if (setterSignature == null) {
                        StringBuilder sbM833U3 = C1643a.m833U("No setter found for property ");
                        sbM833U3.append(aVar.getProperty());
                        throw new C11247a0(sbM833U3.toString());
                    }
                }
                Method methodFindMethodBySignature2 = aVar.getProperty().getContainer().findMethodBySignature(setterSignature.getMethodName(), setterSignature.getMethodDesc());
                if (methodFindMethodBySignature2 != null) {
                    Modifier.isStatic(methodFindMethodBySignature2.getModifiers());
                    return aVar.isBound() ? new AbstractC11273e.h.a(methodFindMethodBySignature2, getBoundReceiver(aVar)) : new AbstractC11273e.h.d(methodFindMethodBySignature2);
                }
                StringBuilder sbM833U4 = C1643a.m833U("No accessor found for property ");
                sbM833U4.append(aVar.getProperty());
                throw new C11247a0(sbM833U4.toString());
            }
            if (z2) {
                setterMethod = ((AbstractC11254e.b) abstractC11254eMapPropertySignature).getGetterMethod();
            } else {
                AbstractC11254e.b bVar = (AbstractC11254e.b) abstractC11254eMapPropertySignature;
                setterMethod = bVar.getSetterMethod();
                if (setterMethod == null) {
                    StringBuilder sbM833U5 = C1643a.m833U("No source found for setter of Java method property: ");
                    sbM833U5.append(bVar.getGetterMethod());
                    throw new C11247a0(sbM833U5.toString());
                }
            }
            aVar2 = aVar.isBound() ? new AbstractC11273e.h.a(setterMethod, getBoundReceiver(aVar)) : new AbstractC11273e.h.d(setterMethod);
        }
        return C11276h.createInlineClassAwareCallerIfNeeded$default(aVar2, aVar.getDescriptor(), false, 2, null);
    }

    public static final boolean access$isJvmFieldPropertyInCompanionObject(InterfaceC11453n0 interfaceC11453n0) {
        InterfaceC11450m containingDeclaration = interfaceC11453n0.getContainingDeclaration();
        C12238m.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        if (!C11787e.isCompanionObject(containingDeclaration)) {
            return false;
        }
        InterfaceC11450m containingDeclaration2 = containingDeclaration.getContainingDeclaration();
        return !(C11787e.isInterface(containingDeclaration2) || C11787e.isAnnotationClass(containingDeclaration2)) || ((interfaceC11453n0 instanceof C11865j) && C11675h.isMovedFromInterfaceCompanion(((C11865j) interfaceC11453n0).getProto()));
    }

    public static final Object getBoundReceiver(AbstractC12053s.a<?, ?> aVar) {
        C12238m.checkNotNullParameter(aVar, "$this$boundReceiver");
        return aVar.getProperty().getBoundReceiver();
    }
}
