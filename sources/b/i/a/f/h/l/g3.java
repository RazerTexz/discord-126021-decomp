package b.i.a.f.h.l;

import java.io.PrintStream;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g3 {
    public static final f3 a;

    static {
        f3 g3_a;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e.printStackTrace(System.err);
            }
            if (num == null || num.intValue() < 19) {
                g3_a = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new j3() : new g3$a();
            } else {
                g3_a = new k3();
            }
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = g3$a.class.getName();
            StringBuilder sb = new StringBuilder(name.length() + Opcodes.I2L);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            g3_a = new g3$a();
        }
        a = g3_a;
        if (num == null) {
            return;
        }
        num.intValue();
    }
}
