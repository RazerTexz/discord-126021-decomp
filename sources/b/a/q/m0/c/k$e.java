package b.a.q.m0.c;

import java.util.List;
import rx.functions.Action1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$e<T> implements Action1<List<? extends b.a.q.m0.a>> {
    public final /* synthetic */ k j;

    public k$e(k kVar) {
        this.j = kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.functions.Action1
    public void call(List<? extends b.a.q.m0.a> list) {
        List<? extends b.a.q.m0.a> list2 = list;
        k kVar = this.j;
        d0.z.d.m.checkNotNullExpressionValue(list2, "codecs");
        kVar.g = list2;
    }
}
