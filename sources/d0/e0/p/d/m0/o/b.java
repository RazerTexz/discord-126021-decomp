package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a {
        public static String invoke(b bVar, FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(bVar, "this");
            Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            if (bVar.check(functionDescriptor)) {
                return null;
            }
            return bVar.getDescription();
        }
    }

    boolean check(FunctionDescriptor functionDescriptor);

    String getDescription();

    String invoke(FunctionDescriptor functionDescriptor);
}
