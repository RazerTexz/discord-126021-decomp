package d0.e0.p.d.l0;

import d0.e0.p.d.l0.Caller2;
import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.l0.a, reason: use source file name */
/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationConstructorCaller implements Caller2 {
    public final List<Type> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Class<?>> f3202b;
    public final List<Object> c;
    public final Class<?> d;
    public final List<String> e;
    public final a f;
    public final List<Method> g;

    /* JADX INFO: renamed from: d0.e0.p.d.l0.a$a */
    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    public enum a {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l0.a$b */
    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    public enum b {
        JAVA,
        KOTLIN
    }

    public AnnotationConstructorCaller(Class<?> cls, List<String> list, a aVar, b bVar, List<Method> list2) {
        Intrinsics3.checkNotNullParameter(cls, "jClass");
        Intrinsics3.checkNotNullParameter(list, "parameterNames");
        Intrinsics3.checkNotNullParameter(aVar, "callMode");
        Intrinsics3.checkNotNullParameter(bVar, "origin");
        Intrinsics3.checkNotNullParameter(list2, "methods");
        this.d = cls;
        this.e = list;
        this.f = aVar;
        this.g = list2;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Method) it.next()).getGenericReturnType());
        }
        this.a = arrayList;
        List<Method> list3 = this.g;
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list3, 10));
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            Intrinsics3.checkNotNullExpressionValue(returnType, "it");
            Class<?> wrapperByPrimitive = reflectClassUtil.getWrapperByPrimitive(returnType);
            if (wrapperByPrimitive != null) {
                returnType = wrapperByPrimitive;
            }
            arrayList2.add(returnType);
        }
        this.f3202b = arrayList2;
        List<Method> list4 = this.g;
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(list4, 10));
        Iterator<T> it3 = list4.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Method) it3.next()).getDefaultValue());
        }
        this.c = arrayList3;
        if (this.f == a.POSITIONAL_CALL && bVar == b.JAVA && (!_Collections.minus(this.e, "value").isEmpty())) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // d0.e0.p.d.l0.Caller2
    public Object call(Object[] objArr) {
        Intrinsics3.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            int i3 = i2 + 1;
            Object objAccess$transformKotlinToJvm = (obj == null && this.f == a.CALL_BY_NAME) ? this.c.get(i2) : AnnotationConstructorCaller2.access$transformKotlinToJvm(obj, this.f3202b.get(i2));
            if (objAccess$transformKotlinToJvm == null) {
                AnnotationConstructorCaller2.access$throwIllegalArgumentType(i2, this.e.get(i2), this.f3202b.get(i2));
                throw null;
            }
            arrayList.add(objAccess$transformKotlinToJvm);
            i++;
            i2 = i3;
        }
        return AnnotationConstructorCaller2.createAnnotationInstance(this.d, Maps6.toMap(_Collections.zip(this.e, arrayList)), this.g);
    }

    public void checkArguments(Object[] objArr) {
        Intrinsics3.checkNotNullParameter(objArr, "args");
        Caller2.a.checkArguments(this, objArr);
    }

    public Void getMember() {
        return null;
    }

    @Override // d0.e0.p.d.l0.Caller2
    /* JADX INFO: renamed from: getMember, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Member mo80getMember() {
        return (Member) getMember();
    }

    @Override // d0.e0.p.d.l0.Caller2
    public List<Type> getParameterTypes() {
        return this.a;
    }

    @Override // d0.e0.p.d.l0.Caller2
    public Type getReturnType() {
        return this.d;
    }

    public /* synthetic */ AnnotationConstructorCaller(Class cls, List list, a aVar, b bVar, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 16) != 0) {
            list2 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                list2.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
        }
        this(cls, list, aVar, bVar, list2);
    }
}
