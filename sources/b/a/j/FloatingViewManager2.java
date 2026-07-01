package b.a.j;

import android.view.View;
import kotlin.Unit;
import rx.functions.Action1;

/* JADX INFO: renamed from: b.a.j.d, reason: use source file name */
/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FloatingViewManager2<T> implements Action1<Unit> {
    public final /* synthetic */ FloatingViewManager j;
    public final /* synthetic */ View k;

    public FloatingViewManager2(FloatingViewManager floatingViewManager, View view) {
        this.j = floatingViewManager;
        this.k = view;
    }

    @Override // rx.functions.Action1
    public void call(Unit unit) {
        this.j.b(this.k.getId());
    }
}
