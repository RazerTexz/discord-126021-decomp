package b.i.a.f.h.i;

import java.io.PrintStream;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final g a;

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class a extends g {
        @Override // b.i.a.f.h.i.g
        public final void a(Throwable th, Throwable th2) {
        }
    }

    static {
        g aVar;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e.printStackTrace(System.err);
            }
            if (num == null || num.intValue() < 19) {
                aVar = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new h() : new a();
            } else {
                aVar = new j();
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
        a = aVar;
        if (num == null) {
            return;
        }
        num.intValue();
    }
}
