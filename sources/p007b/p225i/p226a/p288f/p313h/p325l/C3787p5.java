package p007b.p225i.p226a.p288f.p313h.p325l;

import java.nio.charset.Charset;

/* JADX INFO: renamed from: b.i.a.f.h.l.p5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3787p5 implements InterfaceC3788p6 {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC3917z5 f10197a = new C3826s5();

    /* JADX INFO: renamed from: b */
    public final InterfaceC3917z5 f10198b;

    public C3787p5() {
        InterfaceC3917z5 interfaceC3917z5;
        InterfaceC3917z5[] interfaceC3917z5Arr = new InterfaceC3917z5[2];
        interfaceC3917z5Arr[0] = C3864v4.f10363a;
        try {
            interfaceC3917z5 = (InterfaceC3917z5) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            interfaceC3917z5 = f10197a;
        }
        interfaceC3917z5Arr[1] = interfaceC3917z5;
        C3813r5 c3813r5 = new C3813r5(interfaceC3917z5Arr);
        Charset charset = C3877w4.f10379a;
        this.f10198b = c3813r5;
    }
}
