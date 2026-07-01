package d0.z.d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty$Getter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty0$Getter;

/* JADX INFO: compiled from: PropertyReference0.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v extends z implements KProperty0 {
    public v() {
    }

    @Override // d0.z.d.d
    public KCallable computeReflected() {
        return a0.property0(this);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return ((KProperty0) getReflected()).getDelegate();
    }

    public /* bridge */ /* synthetic */ KProperty$Getter getGetter() {
        return mo112getGetter();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    public v(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter */
    public KProperty0$Getter mo112getGetter() {
        return ((KProperty0) getReflected()).mo112getGetter();
    }

    public v(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
