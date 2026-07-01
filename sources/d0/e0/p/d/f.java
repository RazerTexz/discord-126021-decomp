package d0.e0.p.d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;

/* JADX INFO: compiled from: KCallableImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f<R> implements KCallable<R>, z {
    public final c0$a<List<Annotation>> j;
    public final c0$a<ArrayList<d0.e0.f>> k;
    public final c0$a<x> l;
    public final c0$a<List<y>> m;

    public f() {
        c0$a<List<Annotation>> c0_aLazySoft = c0.lazySoft(new f$a(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_aLazySoft, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.j = c0_aLazySoft;
        c0$a<ArrayList<d0.e0.f>> c0_aLazySoft2 = c0.lazySoft(new f$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_aLazySoft2, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.k = c0_aLazySoft2;
        c0$a<x> c0_aLazySoft3 = c0.lazySoft(new f$c(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_aLazySoft3, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.l = c0_aLazySoft3;
        c0$a<List<y>> c0_aLazySoft4 = c0.lazySoft(new f$d(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_aLazySoft4, "ReflectProperties.lazySo…this, descriptor) }\n    }");
        this.m = c0_aLazySoft4;
    }

    public static final Type access$extractContinuationArgument(f fVar) {
        Type[] lowerBounds;
        d0.e0.p.d.m0.c.b descriptor = fVar.getDescriptor();
        if (!(descriptor instanceof d0.e0.p.d.m0.c.x)) {
            descriptor = null;
        }
        d0.e0.p.d.m0.c.x xVar = (d0.e0.p.d.m0.c.x) descriptor;
        if (xVar == null || !xVar.isSuspend()) {
            return null;
        }
        Object objLastOrNull = d0.t.u.lastOrNull((List<? extends Object>) fVar.getCaller().getParameterTypes());
        if (!(objLastOrNull instanceof ParameterizedType)) {
            objLastOrNull = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) objLastOrNull;
        if (!d0.z.d.m.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        d0.z.d.m.checkNotNullExpressionValue(actualTypeArguments, "continuationType.actualTypeArguments");
        Object objSingle = d0.t.k.single(actualTypeArguments);
        if (!(objSingle instanceof WildcardType)) {
            objSingle = null;
        }
        WildcardType wildcardType = (WildcardType) objSingle;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) d0.t.k.first(lowerBounds);
    }

    public final Object a(KType kType) {
        Class javaClass = d0.z.a.getJavaClass(d0.e0.p.a.getJvmErasure(kType));
        if (javaClass.isArray()) {
            Object objNewInstance = Array.newInstance(javaClass.getComponentType(), 0);
            d0.z.d.m.checkNotNullExpressionValue(objNewInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return objNewInstance;
        }
        StringBuilder sbU = b.d.b.a.a.U("Cannot instantiate the default empty array of type ");
        sbU.append(javaClass.getSimpleName());
        sbU.append(", because it is not an array type");
        throw new a0(sbU.toString());
    }

    public final boolean b() {
        return d0.z.d.m.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... objArr) {
        d0.z.d.m.checkNotNullParameter(objArr, "args");
        try {
            return (R) getCaller().call(objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<d0.e0.f, ? extends Object> map) throws IllegalCallableAccessException {
        Object objA;
        d0.z.d.m.checkNotNullParameter(map, "args");
        if (!b()) {
            return callDefaultMethod$kotlin_reflection(map, null);
        }
        List<d0.e0.f> parameters = getParameters();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters, 10));
        for (d0.e0.f fVar : parameters) {
            if (map.containsKey(fVar)) {
                objA = map.get(fVar);
                if (objA == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + fVar + ')');
                }
            } else if (fVar.isOptional()) {
                objA = null;
            } else {
                if (!fVar.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + fVar);
                }
                objA = a(fVar.getType());
            }
            arrayList.add(objA);
        }
        d0.e0.p.d.l0.d<?> defaultCaller = getDefaultCaller();
        if (defaultCaller == null) {
            StringBuilder sbU = b.d.b.a.a.U("This callable does not support a default call: ");
            sbU.append(getDescriptor());
            throw new a0(sbU.toString());
        }
        try {
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return (R) defaultCaller.call(array);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    public final R callDefaultMethod$kotlin_reflection(Map<d0.e0.f, ? extends Object> map, Continuation<?> continuation) throws IllegalCallableAccessException {
        d0.z.d.m.checkNotNullParameter(map, "args");
        List<d0.e0.f> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<d0.e0.f> it = parameters.iterator();
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                if (continuation != null) {
                    arrayList.add(continuation);
                }
                if (!z2) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return call(Arrays.copyOf(array, array.length));
                }
                arrayList2.add(Integer.valueOf(i2));
                d0.e0.p.d.l0.d<?> defaultCaller = getDefaultCaller();
                if (defaultCaller == null) {
                    StringBuilder sbU = b.d.b.a.a.U("This callable does not support a default call: ");
                    sbU.append(getDescriptor());
                    throw new a0(sbU.toString());
                }
                arrayList.addAll(arrayList2);
                arrayList.add(null);
                try {
                    Object[] array2 = arrayList.toArray(new Object[0]);
                    if (array2 != null) {
                        return (R) defaultCaller.call(array2);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                } catch (IllegalAccessException e) {
                    throw new IllegalCallableAccessException(e);
                }
            }
            d0.e0.f next = it.next();
            if (i != 0 && i % 32 == 0) {
                arrayList2.add(Integer.valueOf(i2));
                i2 = 0;
            }
            if (map.containsKey(next)) {
                arrayList.add(map.get(next));
            } else if (next.isOptional()) {
                arrayList.add(j0.isInlineClassType(next.getType()) ? null : j0.defaultPrimitiveValue(d0.e0.p.b.getJavaType(next.getType())));
                i2 = (1 << (i % 32)) | i2;
                z2 = true;
            } else {
                if (!next.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
                }
                arrayList.add(a(next.getType()));
            }
            if (next.getKind() == d0.e0.f$a.VALUE) {
                i++;
            }
        }
    }

    @Override // d0.e0.b
    public List<Annotation> getAnnotations() {
        List<Annotation> listInvoke = this.j.invoke();
        d0.z.d.m.checkNotNullExpressionValue(listInvoke, "_annotations()");
        return listInvoke;
    }

    public abstract d0.e0.p.d.l0.d<?> getCaller();

    public abstract i getContainer();

    public abstract d0.e0.p.d.l0.d<?> getDefaultCaller();

    public abstract d0.e0.p.d.m0.c.b getDescriptor();

    @Override // kotlin.reflect.KCallable
    public List<d0.e0.f> getParameters() {
        ArrayList<d0.e0.f> arrayListInvoke = this.k.invoke();
        d0.z.d.m.checkNotNullExpressionValue(arrayListInvoke, "_parameters()");
        return arrayListInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        x xVarInvoke = this.l.invoke();
        d0.z.d.m.checkNotNullExpressionValue(xVarInvoke, "_returnType()");
        return xVarInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<d0.e0.h> getTypeParameters() {
        List<y> listInvoke = this.m.invoke();
        d0.z.d.m.checkNotNullExpressionValue(listInvoke, "_typeParameters()");
        return listInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        d0.e0.p.d.m0.c.u visibility = getDescriptor().getVisibility();
        d0.z.d.m.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return j0.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getDescriptor().getModality() == d0.e0.p.d.m0.c.z.ABSTRACT;
    }

    public abstract boolean isBound();

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getDescriptor().getModality() == d0.e0.p.d.m0.c.z.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getDescriptor().getModality() == d0.e0.p.d.m0.c.z.OPEN;
    }
}
