package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p644b.C12694b;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.p2 */
/* JADX INFO: compiled from: OperatorToObservableSortedList.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12661p2<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public List<T> f26985j = new ArrayList(10);

    /* JADX INFO: renamed from: k */
    public boolean f26986k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C12694b f26987l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ Subscriber f26988m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C12657o2 f26989n;

    public C12661p2(C12657o2 c12657o2, C12694b c12694b, Subscriber subscriber) {
        this.f26989n = c12657o2;
        this.f26987l = c12694b;
        this.f26988m = subscriber;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        if (this.f26986k) {
            return;
        }
        this.f26986k = true;
        List<T> list = this.f26985j;
        this.f26985j = null;
        try {
            Collections.sort(list, this.f26989n.f26970j);
            this.f26987l.m10799b(list);
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            onError(th);
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f26988m.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        if (this.f26986k) {
            return;
        }
        this.f26985j.add(t);
    }

    @Override // p658rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
