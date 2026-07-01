package rx.subjects;

import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes3.dex */
public class SerializedSubject$a<R> implements Observable$a<R> {
    public final /* synthetic */ Subject j;

    public SerializedSubject$a(Subject subject) {
        this.j = subject;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        this.j.i0((Subscriber) obj);
    }
}
