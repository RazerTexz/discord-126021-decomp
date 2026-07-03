package p007b.p008a.p018d;

import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action3;

/* JADX INFO: renamed from: b.a.d.a */
/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0852a implements Action3 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Function3 f498j;

    public C0852a(Function3 function3) {
        this.f498j = function3;
    }

    @Override // p658rx.functions.Action3
    public final /* synthetic */ void call(Object obj, Object obj2, Object obj3) {
        C12238m.checkNotNullExpressionValue(this.f498j.invoke(obj, obj2, obj3), "invoke(...)");
    }
}
