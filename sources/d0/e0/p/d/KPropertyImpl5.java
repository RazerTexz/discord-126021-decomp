package d0.e0.p.d;

import b.d.b.a.outline;
import d0.e0.p.d.KPropertyImpl;
import d0.e0.p.d.RuntimeTypeMapper;
import d0.e0.p.d.RuntimeTypeMapper2;
import d0.e0.p.d.l0.Caller2;
import d0.e0.p.d.l0.CallerImpl;
import d0.e0.p.d.l0.InlineClassAwareCaller2;
import d0.e0.p.d.l0.InternalUnderlyingValOfInlineClass;
import d0.e0.p.d.l0.ThrowingCaller;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.f.a0.JvmProtoBuf;
import d0.e0.p.d.m0.f.a0.b.JvmProtoBufUtil;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.inlineClassesUtils;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor4;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: d0.e0.p.d.w, reason: use source file name */
/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KPropertyImpl5 {
    /* JADX WARN: Code duplicated, block: B:15:0x0058  */
    public static final Caller2 access$computeCallerForAccessor(KPropertyImpl.a aVar, boolean z2) {
        RuntimeTypeMapper.e setterSignature;
        Method setterMethod;
        Caller2 aVar2;
        JvmProtoBuf.c setter;
        Method unboxMethod;
        if (KDeclarationContainerImpl.l.getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection().matches(aVar.getProperty().getSignature())) {
            return ThrowingCaller.a;
        }
        KPropertyImpl2 kPropertyImpl2 = new KPropertyImpl2(aVar);
        KPropertyImpl4 kPropertyImpl4 = new KPropertyImpl4(aVar, z2, new KPropertyImpl3(aVar), kPropertyImpl2);
        RuntimeTypeMapper2 runtimeTypeMapper2MapPropertySignature = RuntimeTypeMapper3.f3198b.mapPropertySignature(aVar.getProperty().getDescriptor());
        if (runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.c) {
            RuntimeTypeMapper2.c cVar = (RuntimeTypeMapper2.c) runtimeTypeMapper2MapPropertySignature;
            JvmProtoBuf.d signature = cVar.getSignature();
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
                if (inlineClassesUtils.isUnderlyingPropertyOfInlineClass(aVar.getProperty().getDescriptor()) && Intrinsics3.areEqual(aVar.getProperty().getDescriptor().getVisibility(), DescriptorVisibilities.d)) {
                    Class<?> inlineClass = InlineClassAwareCaller2.toInlineClass(aVar.getProperty().getDescriptor().getContainingDeclaration());
                    if (inlineClass == null || (unboxMethod = InlineClassAwareCaller2.getUnboxMethod(inlineClass, aVar.getProperty().getDescriptor())) == null) {
                        StringBuilder sbU = outline.U("Underlying property of inline class ");
                        sbU.append(aVar.getProperty());
                        sbU.append(" should have a field");
                        throw new KotlinReflectionInternalError(sbU.toString());
                    }
                    aVar2 = aVar.isBound() ? new InternalUnderlyingValOfInlineClass.a(unboxMethod, getBoundReceiver(aVar)) : new InternalUnderlyingValOfInlineClass.b(unboxMethod);
                } else {
                    Field javaField = aVar.getProperty().getJavaField();
                    if (javaField == null) {
                        StringBuilder sbU2 = outline.U("No accessors or field is found for property ");
                        sbU2.append(aVar.getProperty());
                        throw new KotlinReflectionInternalError(sbU2.toString());
                    }
                    aVar2 = kPropertyImpl4.invoke2(javaField);
                }
            } else if (!Modifier.isStatic(methodFindMethodBySignature.getModifiers())) {
                aVar2 = aVar.isBound() ? new CallerImpl.h.a(methodFindMethodBySignature, getBoundReceiver(aVar)) : new CallerImpl.h.d(methodFindMethodBySignature);
            } else if (kPropertyImpl2.invoke2()) {
                aVar2 = aVar.isBound() ? new CallerImpl.h.b(methodFindMethodBySignature) : new CallerImpl.h.e(methodFindMethodBySignature);
            } else {
                aVar2 = aVar.isBound() ? new CallerImpl.h.c(methodFindMethodBySignature, getBoundReceiver(aVar)) : new CallerImpl.h.f(methodFindMethodBySignature);
            }
        } else if (runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.a) {
            aVar2 = kPropertyImpl4.invoke2(((RuntimeTypeMapper2.a) runtimeTypeMapper2MapPropertySignature).getField());
        } else {
            if (!(runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.b)) {
                if (!(runtimeTypeMapper2MapPropertySignature instanceof RuntimeTypeMapper2.d)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (z2) {
                    setterSignature = ((RuntimeTypeMapper2.d) runtimeTypeMapper2MapPropertySignature).getGetterSignature();
                } else {
                    setterSignature = ((RuntimeTypeMapper2.d) runtimeTypeMapper2MapPropertySignature).getSetterSignature();
                    if (setterSignature == null) {
                        StringBuilder sbU3 = outline.U("No setter found for property ");
                        sbU3.append(aVar.getProperty());
                        throw new KotlinReflectionInternalError(sbU3.toString());
                    }
                }
                Method methodFindMethodBySignature2 = aVar.getProperty().getContainer().findMethodBySignature(setterSignature.getMethodName(), setterSignature.getMethodDesc());
                if (methodFindMethodBySignature2 != null) {
                    Modifier.isStatic(methodFindMethodBySignature2.getModifiers());
                    return aVar.isBound() ? new CallerImpl.h.a(methodFindMethodBySignature2, getBoundReceiver(aVar)) : new CallerImpl.h.d(methodFindMethodBySignature2);
                }
                StringBuilder sbU4 = outline.U("No accessor found for property ");
                sbU4.append(aVar.getProperty());
                throw new KotlinReflectionInternalError(sbU4.toString());
            }
            if (z2) {
                setterMethod = ((RuntimeTypeMapper2.b) runtimeTypeMapper2MapPropertySignature).getGetterMethod();
            } else {
                RuntimeTypeMapper2.b bVar = (RuntimeTypeMapper2.b) runtimeTypeMapper2MapPropertySignature;
                setterMethod = bVar.getSetterMethod();
                if (setterMethod == null) {
                    StringBuilder sbU5 = outline.U("No source found for setter of Java method property: ");
                    sbU5.append(bVar.getGetterMethod());
                    throw new KotlinReflectionInternalError(sbU5.toString());
                }
            }
            aVar2 = aVar.isBound() ? new CallerImpl.h.a(setterMethod, getBoundReceiver(aVar)) : new CallerImpl.h.d(setterMethod);
        }
        return InlineClassAwareCaller2.createInlineClassAwareCallerIfNeeded$default(aVar2, aVar.getDescriptor(), false, 2, null);
    }

    public static final boolean access$isJvmFieldPropertyInCompanionObject(PropertyDescriptor propertyDescriptor) {
        DeclarationDescriptor containingDeclaration = propertyDescriptor.getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        if (!DescriptorUtils.isCompanionObject(containingDeclaration)) {
            return false;
        }
        DeclarationDescriptor containingDeclaration2 = containingDeclaration.getContainingDeclaration();
        return !(DescriptorUtils.isInterface(containingDeclaration2) || DescriptorUtils.isAnnotationClass(containingDeclaration2)) || ((propertyDescriptor instanceof DeserializedMemberDescriptor4) && JvmProtoBufUtil.isMovedFromInterfaceCompanion(((DeserializedMemberDescriptor4) propertyDescriptor).getProto()));
    }

    public static final Object getBoundReceiver(KPropertyImpl.a<?, ?> aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "$this$boundReceiver");
        return aVar.getProperty().getBoundReceiver();
    }
}
