package p507d0.p592z.p594d;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import p507d0.p513e0.InterfaceC11233f;
import p507d0.p513e0.InterfaceC11235h;
import p507d0.p592z.C12210b;

/* JADX INFO: renamed from: d0.z.d.d */
/* JADX INFO: compiled from: CallableReference.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12221d implements KCallable, Serializable {
    public static final Object NO_RECEIVER = a.f25280j;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    public final Object receiver;
    private transient KCallable reflected;
    private final String signature;

    /* JADX INFO: renamed from: d0.z.d.d$a */
    /* JADX INFO: compiled from: CallableReference.java */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: j */
        public static final a f25280j = new a();

        private Object readResolve() throws ObjectStreamException {
            return f25280j;
        }
    }

    public AbstractC12221d() {
        this(NO_RECEIVER);
    }

    @Override // kotlin.reflect.KCallable
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // kotlin.reflect.KCallable
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public KCallable compute() {
        KCallable kCallable = this.reflected;
        if (kCallable != null) {
            return kCallable;
        }
        KCallable kCallableComputeReflected = computeReflected();
        this.reflected = kCallableComputeReflected;
        return kCallableComputeReflected;
    }

    public abstract KCallable computeReflected();

    @Override // p507d0.p513e0.InterfaceC11229b
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.name;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? C12216a0.getOrCreateKotlinPackage(cls) : C12216a0.getOrCreateKotlinClass(cls);
    }

    @Override // kotlin.reflect.KCallable
    public List<InterfaceC11233f> getParameters() {
        return getReflected().getParameters();
    }

    public KCallable getReflected() {
        KCallable kCallableCompute = compute();
        if (kCallableCompute != this) {
            return kCallableCompute;
        }
        throw new C12210b();
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // kotlin.reflect.KCallable
    public List<InterfaceC11235h> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public AbstractC12221d(Object obj) {
        this(obj, null, null, null, false);
    }

    public AbstractC12221d(Object obj, Class cls, String str, String str2, boolean z2) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z2;
    }
}
