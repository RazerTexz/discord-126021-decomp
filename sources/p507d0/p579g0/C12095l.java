package p507d0.p579g0;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g0.l */
/* JADX INFO: compiled from: Appendable.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12095l {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void appendElement(Appendable appendable, T t, Function1<? super T, ? extends CharSequence> function1) {
        C12238m.checkNotNullParameter(appendable, "$this$appendElement");
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
