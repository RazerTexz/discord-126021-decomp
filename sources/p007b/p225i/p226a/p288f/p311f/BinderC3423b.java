package p007b.p225i.p226a.p288f.p311f;

import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import java.lang.reflect.Field;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;

/* JADX INFO: renamed from: b.i.a.f.f.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class BinderC3423b<T> extends InterfaceC3422a.a {

    /* JADX INFO: renamed from: a */
    public final T f9615a;

    public BinderC3423b(T t) {
        this.f9615a = t;
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: i */
    public static <T> T m4381i(@RecentlyNonNull InterfaceC3422a interfaceC3422a) {
        if (interfaceC3422a instanceof BinderC3423b) {
            return ((BinderC3423b) interfaceC3422a).f9615a;
        }
        IBinder iBinderAsBinder = interfaceC3422a.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException(C1643a.m851g(64, "Unexpected number of IObjectWrapper declared fields: ", declaredFields.length));
        }
        Objects.requireNonNull(field, "null reference");
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }
}
