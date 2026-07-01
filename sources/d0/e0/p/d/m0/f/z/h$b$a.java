package d0.e0.p.d.m0.f.z;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$b$a {
    public h$b$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final h$b decode(Integer num, Integer num2) {
        if (num2 != null) {
            return new h$b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
        }
        return num != null ? new h$b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & Opcodes.LAND) : h$b.f3420b;
    }
}
