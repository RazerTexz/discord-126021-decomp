package p507d0.p513e0.p514p.p515d.p516l0;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.l0.a */
/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11269a implements InterfaceC11272d {

    /* JADX INFO: renamed from: a */
    public final List<Type> f22404a;

    /* JADX INFO: renamed from: b */
    public final List<Class<?>> f22405b;

    /* JADX INFO: renamed from: c */
    public final List<Object> f22406c;

    /* JADX INFO: renamed from: d */
    public final Class<?> f22407d;

    /* JADX INFO: renamed from: e */
    public final List<String> f22408e;

    /* JADX INFO: renamed from: f */
    public final a f22409f;

    /* JADX INFO: renamed from: g */
    public final List<Method> f22410g;

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

    public C11269a(Class<?> cls, List<String> list, a aVar, b bVar, List<Method> list2) {
        C12238m.checkNotNullParameter(cls, "jClass");
        C12238m.checkNotNullParameter(list, "parameterNames");
        C12238m.checkNotNullParameter(aVar, "callMode");
        C12238m.checkNotNullParameter(bVar, "origin");
        C12238m.checkNotNullParameter(list2, "methods");
        this.f22407d = cls;
        this.f22408e = list;
        this.f22409f = aVar;
        this.f22410g = list2;
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Method) it.next()).getGenericReturnType());
        }
        this.f22404a = arrayList;
        List<Method> list3 = this.f22410g;
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(list3, 10));
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            C12238m.checkNotNullExpressionValue(returnType, "it");
            Class<?> wrapperByPrimitive = C11423b.getWrapperByPrimitive(returnType);
            if (wrapperByPrimitive != null) {
                returnType = wrapperByPrimitive;
            }
            arrayList2.add(returnType);
        }
        this.f22405b = arrayList2;
        List<Method> list4 = this.f22410g;
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(list4, 10));
        Iterator<T> it3 = list4.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Method) it3.next()).getDefaultValue());
        }
        this.f22406c = arrayList3;
        if (this.f22409f == a.POSITIONAL_CALL && bVar == b.JAVA && (!C12163u.minus(this.f22408e, "value").isEmpty())) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public Object call(Object[] objArr) {
        C12238m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            int i3 = i2 + 1;
            Object objAccess$transformKotlinToJvm = (obj == null && this.f22409f == a.CALL_BY_NAME) ? this.f22406c.get(i2) : C11270b.access$transformKotlinToJvm(obj, this.f22405b.get(i2));
            if (objAccess$transformKotlinToJvm == null) {
                C11270b.access$throwIllegalArgumentType(i2, this.f22408e.get(i2), this.f22405b.get(i2));
                throw null;
            }
            arrayList.add(objAccess$transformKotlinToJvm);
            i++;
            i2 = i3;
        }
        return C11270b.createAnnotationInstance(this.f22407d, C12136h0.toMap(C12163u.zip(this.f22408e, arrayList)), this.f22410g);
    }

    public void checkArguments(Object[] objArr) {
        C12238m.checkNotNullParameter(objArr, "args");
        InterfaceC11272d.a.checkArguments(this, objArr);
    }

    public Void getMember() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    /* JADX INFO: renamed from: getMember, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Member mo11457getMember() {
        return (Member) getMember();
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public List<Type> getParameterTypes() {
        return this.f22404a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public Type getReturnType() {
        return this.f22407d;
    }

    public /* synthetic */ C11269a(Class cls, List list, a aVar, b bVar, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 16) != 0) {
            list2 = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                list2.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
        }
        this(cls, list, aVar, bVar, list2);
    }
}
