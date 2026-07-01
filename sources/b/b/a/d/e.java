package b.b.a.d;

import com.lytefast.flexinput.model.Attachment;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return d0.u.a.compareValues(((Attachment) t).getUri(), ((Attachment) t2).getUri());
    }
}
