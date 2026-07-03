package p007b.p008a.p020e;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.e.c */
/* JADX INFO: compiled from: Backgrounded.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0893c implements Action1 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Function1 f596j;

    public C0893c(Function1 function1) {
        this.f596j = function1;
    }

    @Override // p658rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        C12238m.checkNotNullExpressionValue(this.f596j.invoke(obj), "invoke(...)");
    }
}
