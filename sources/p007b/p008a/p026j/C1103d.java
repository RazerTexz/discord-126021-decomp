package p007b.p008a.p026j;

import android.view.View;
import kotlin.Unit;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.j.d */
/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1103d<T> implements Action1<Unit> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1100a f1474j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ View f1475k;

    public C1103d(C1100a c1100a, View view) {
        this.f1474j = c1100a;
        this.f1475k = view;
    }

    @Override // p658rx.functions.Action1
    public void call(Unit unit) {
        this.f1474j.m208b(this.f1475k.getId());
    }
}
