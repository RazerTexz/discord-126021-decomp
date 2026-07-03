package p007b.p109f.p161j.p184s;

import java.lang.reflect.InvocationTargetException;
import p007b.p109f.p160i.C1832c;
import p007b.p109f.p161j.p170e.C1899n;

/* JADX INFO: renamed from: b.f.j.s.e */
/* JADX INFO: compiled from: MultiImageTranscoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2035e implements InterfaceC2033c {

    /* JADX INFO: renamed from: a */
    public final int f4269a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2033c f4270b;

    /* JADX INFO: renamed from: c */
    public final Integer f4271c;

    /* JADX INFO: renamed from: d */
    public final boolean f4272d;

    public C2035e(int i, boolean z2, InterfaceC2033c interfaceC2033c, Integer num, boolean z3) {
        this.f4269a = i;
        this.f4270b = interfaceC2033c;
        this.f4271c = num;
        this.f4272d = z3;
    }

    /* JADX INFO: renamed from: a */
    public final InterfaceC2032b m1535a(C1832c c1832c, boolean z2) {
        int i = this.f4269a;
        boolean z3 = this.f4272d;
        try {
            Class<?> cls = Class.forName("com.facebook.imagepipeline.nativecode.NativeJpegTranscoderFactory");
            Class<?> cls2 = Boolean.TYPE;
            return ((InterfaceC2033c) cls.getConstructor(Integer.TYPE, cls2, cls2).newInstance(Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(z3))).createImageTranscoder(c1832c, z2);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e);
        }
    }

    @Override // p007b.p109f.p161j.p184s.InterfaceC2033c
    public InterfaceC2032b createImageTranscoder(C1832c c1832c, boolean z2) {
        InterfaceC2033c interfaceC2033c = this.f4270b;
        InterfaceC2032b interfaceC2032bM1535a = null;
        InterfaceC2032b interfaceC2032bCreateImageTranscoder = interfaceC2033c == null ? null : interfaceC2033c.createImageTranscoder(c1832c, z2);
        if (interfaceC2032bCreateImageTranscoder == null) {
            Integer num = this.f4271c;
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    interfaceC2032bM1535a = m1535a(c1832c, z2);
                } else {
                    if (iIntValue != 1) {
                        throw new IllegalArgumentException("Invalid ImageTranscoderType");
                    }
                    interfaceC2032bM1535a = new C2036f(z2, this.f4269a);
                }
            }
            interfaceC2032bCreateImageTranscoder = interfaceC2032bM1535a;
        }
        if (interfaceC2032bCreateImageTranscoder == null && C1899n.f3808a) {
            interfaceC2032bCreateImageTranscoder = m1535a(c1832c, z2);
        }
        return interfaceC2032bCreateImageTranscoder == null ? new C2036f(z2, this.f4269a) : interfaceC2032bCreateImageTranscoder;
    }
}
