package rx.exceptions;

import b.d.b.a.a;
import j0.o.o;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class OnErrorThrowable$OnNextValue extends RuntimeException {
    private static final long serialVersionUID = -3454462756050397899L;
    private final Object value;

    /* JADX WARN: Illegal instructions before constructor call */
    public OnErrorThrowable$OnNextValue(Object obj) {
        String strName;
        StringBuilder sbU = a.U("OnError while emitting onNext value: ");
        if (obj == null) {
            strName = "null";
        } else if (OnErrorThrowable$OnNextValue$a.a.contains(obj.getClass())) {
            strName = obj.toString();
        } else if (obj instanceof String) {
            strName = (String) obj;
        } else if (obj instanceof Enum) {
            strName = ((Enum) obj).name();
        } else {
            Objects.requireNonNull(o.a.b());
            strName = obj.getClass().getName() + ".class";
        }
        sbU.append(strName);
        super(sbU.toString());
        if (!(obj instanceof Serializable)) {
            try {
                obj = String.valueOf(obj);
            } catch (Throwable th) {
                obj = th.getMessage();
            }
        }
        this.value = obj;
    }

    public Object a() {
        return this.value;
    }
}
