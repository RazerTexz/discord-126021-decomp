package b.o.a.x;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements c {
    @Override // b.o.a.x.c
    @NonNull
    public List<b> a(@NonNull List<b> list) {
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }
}
