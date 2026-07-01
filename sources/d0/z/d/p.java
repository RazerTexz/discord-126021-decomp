package d0.z.d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty0$Setter;
import kotlin.reflect.KProperty$Getter;
import kotlin.reflect.KProperty0$Getter;

/* JADX INFO: compiled from: MutablePropertyReference0.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p extends t implements KMutableProperty0 {
    public p() {
    }

    @Override // d0.z.d.d
    public KCallable computeReflected() {
        return a0.mutableProperty0(this);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return ((KMutableProperty0) getReflected()).getDelegate();
    }

    public /* bridge */ /* synthetic */ KProperty$Getter getGetter() {
        return mo112getGetter();
    }

    public /* bridge */ /* synthetic */ KMutableProperty$Setter getSetter() {
        return mo113getSetter();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    public p(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public KProperty0$Getter mo112getGetter() {
        return ((KMutableProperty0) getReflected()).mo112getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty0
    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    public KMutableProperty0$Setter mo113getSetter() {
        return ((KMutableProperty0) getReflected()).mo113getSetter();
    }

    public p(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
