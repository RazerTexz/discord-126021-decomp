package d0.g0;

import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.g0.l, reason: use source file name */
/* JADX INFO: compiled from: Appendable.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Appendable {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void appendElement(java.lang.Appendable appendable, T t, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics3.checkNotNullParameter(appendable, "$this$appendElement");
        if (function1 != null) {
            appendable.append(function1.invoke(t));
            return;
        }
        if (t != 0 ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
