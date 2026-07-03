package p507d0.p592z.p594d;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.InterfaceC11235h;

/* JADX INFO: renamed from: d0.z.d.f0 */
/* JADX INFO: compiled from: TypeParameterReference.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12226f0 implements InterfaceC11235h {

    /* JADX INFO: renamed from: j */
    public static final a f25289j = new a(null);

    /* JADX INFO: renamed from: d0.z.d.f0$a */
    /* JADX INFO: compiled from: TypeParameterReference.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String toString(InterfaceC11235h interfaceC11235h) {
            C12238m.checkNotNullParameter(interfaceC11235h, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int iOrdinal = interfaceC11235h.getVariance().ordinal();
            if (iOrdinal == 1) {
                sb.append("in ");
            } else if (iOrdinal == 2) {
                sb.append("out ");
            }
            sb.append(interfaceC11235h.getName());
            String string = sb.toString();
            C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }
}
