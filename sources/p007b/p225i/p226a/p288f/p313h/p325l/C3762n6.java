package p007b.p225i.p226a.p288f.p313h.p325l;

import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: renamed from: b.i.a.f.h.l.n6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3762n6 {

    /* JADX INFO: renamed from: a */
    public static final C3762n6 f10114a = new C3762n6();

    /* JADX INFO: renamed from: c */
    public final ConcurrentMap<Class<?>, InterfaceC3801q6<?>> f10116c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b */
    public final InterfaceC3788p6 f10115b = new C3787p5();

    /* JADX INFO: renamed from: a */
    public final <T> InterfaceC3801q6<T> m5138a(Class<T> cls) {
        InterfaceC3801q6<T> interfaceC3801q6M4828n;
        C3668g6 c3668g6;
        Class<?> cls2;
        Charset charset = C3877w4.f10379a;
        Objects.requireNonNull(cls, "messageType");
        InterfaceC3801q6<T> interfaceC3801q6 = (InterfaceC3801q6) this.f10116c.get(cls);
        if (interfaceC3801q6 != null) {
            return interfaceC3801q6;
        }
        C3787p5 c3787p5 = (C3787p5) this.f10115b;
        Objects.requireNonNull(c3787p5);
        Class<?> cls3 = C3827s6.f10313a;
        if (!AbstractC3851u4.class.isAssignableFrom(cls) && (cls2 = C3827s6.f10313a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        InterfaceC3584a6 interfaceC3584a6Mo5202b = c3787p5.f10198b.mo5202b(cls);
        if (interfaceC3584a6Mo5202b.mo4558b()) {
            if (AbstractC3851u4.class.isAssignableFrom(cls)) {
                AbstractC3627d7<?, ?> abstractC3627d7 = C3827s6.f10316d;
                AbstractC3708j4<?> abstractC3708j4 = C3721k4.f10052a;
                c3668g6 = new C3668g6(abstractC3627d7, C3721k4.f10052a, interfaceC3584a6Mo5202b.mo4559c());
            } else {
                AbstractC3627d7<?, ?> abstractC3627d8 = C3827s6.f10314b;
                AbstractC3708j4<?> abstractC3708j5 = C3721k4.f10053b;
                if (abstractC3708j5 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                c3668g6 = new C3668g6(abstractC3627d8, abstractC3708j5, interfaceC3584a6Mo5202b.mo4559c());
            }
            interfaceC3801q6M4828n = c3668g6;
        } else {
            if (AbstractC3851u4.class.isAssignableFrom(cls)) {
                if (interfaceC3584a6Mo5202b.mo4557a() == 1) {
                    InterfaceC3696i6 interfaceC3696i6 = C3723k6.f10057b;
                    AbstractC3748m5 abstractC3748m5 = AbstractC3748m5.f10093b;
                    AbstractC3627d7<?, ?> abstractC3627d9 = C3827s6.f10316d;
                    AbstractC3708j4<?> abstractC3708j6 = C3721k4.f10052a;
                    interfaceC3801q6M4828n = C3640e6.m4828n(interfaceC3584a6Mo5202b, interfaceC3696i6, abstractC3748m5, abstractC3627d9, C3721k4.f10052a, C3891x5.f10404b);
                } else {
                    interfaceC3801q6M4828n = C3640e6.m4828n(interfaceC3584a6Mo5202b, C3723k6.f10057b, AbstractC3748m5.f10093b, C3827s6.f10316d, null, C3891x5.f10404b);
                }
            } else {
                if (interfaceC3584a6Mo5202b.mo4557a() == 1) {
                    InterfaceC3696i6 interfaceC3696i7 = C3723k6.f10056a;
                    AbstractC3748m5 abstractC3748m6 = AbstractC3748m5.f10092a;
                    AbstractC3627d7<?, ?> abstractC3627d10 = C3827s6.f10314b;
                    AbstractC3708j4<?> abstractC3708j7 = C3721k4.f10053b;
                    if (abstractC3708j7 == null) {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                    interfaceC3801q6M4828n = C3640e6.m4828n(interfaceC3584a6Mo5202b, interfaceC3696i7, abstractC3748m6, abstractC3627d10, abstractC3708j7, C3891x5.f10403a);
                } else {
                    interfaceC3801q6M4828n = C3640e6.m4828n(interfaceC3584a6Mo5202b, C3723k6.f10056a, AbstractC3748m5.f10092a, C3827s6.f10315c, null, C3891x5.f10403a);
                }
            }
        }
        InterfaceC3801q6<T> interfaceC3801q7 = (InterfaceC3801q6) this.f10116c.putIfAbsent(cls, interfaceC3801q6M4828n);
        return interfaceC3801q7 != null ? interfaceC3801q7 : interfaceC3801q6M4828n;
    }

    /* JADX INFO: renamed from: b */
    public final <T> InterfaceC3801q6<T> m5139b(T t) {
        return m5138a(t.getClass());
    }
}
