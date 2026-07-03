package p007b.p225i.p226a.p288f.p313h.p325l;

import java.io.PrintStream;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.f.h.l.g3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3665g3 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3651f3 f9966a;

    /* JADX INFO: renamed from: b.i.a.f.h.l.g3$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class a extends AbstractC3651f3 {
        @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3651f3
        /* JADX INFO: renamed from: a */
        public final void mo4876a(Throwable th, Throwable th2) {
        }
    }

    static {
        AbstractC3651f3 aVar;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e.printStackTrace(System.err);
            }
            if (num == null || num.intValue() < 19) {
                aVar = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new C3707j3() : new a();
            } else {
                aVar = new C3720k3();
            }
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = a.class.getName();
            StringBuilder sb = new StringBuilder(name.length() + Opcodes.I2L);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            aVar = new a();
        }
        f9966a = aVar;
        if (num == null) {
            return;
        }
        num.intValue();
    }
}
