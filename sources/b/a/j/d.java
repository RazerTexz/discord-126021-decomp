package b.a.j;

import android.view.View;
import kotlin.Unit;
import rx.functions.Action1;

/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d<T> implements Action1<Unit> {
    public final /* synthetic */ a j;
    public final /* synthetic */ View k;

    public d(a aVar, View view) {
        this.j = aVar;
        this.k = view;
    }

    @Override // rx.functions.Action1
    public void call(Unit unit) {
        this.j.b(this.k.getId());
    }
}
