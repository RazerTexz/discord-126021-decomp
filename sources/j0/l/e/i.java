package j0.l.e;

import j0.l.e.o.n;
import java.io.PrintStream;
import java.util.Queue;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: RxRingBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements Subscription {
    public static final int j;
    public Queue<Object> k;
    public volatile Object l;

    static {
        int i = h.f3795b ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                StringBuilder sbY = b.d.b.a.a.Y("Failed to set 'rx.buffer.size' with value ", property, " => ");
                sbY.append(e.getMessage());
                printStream.println(sbY.toString());
            }
        }
        j = i;
    }

    public i(boolean z2, int i) {
        this.k = z2 ? new j0.l.e.o.h<>(i) : new n<>(i);
    }

    public void a(Object obj) throws MissingBackpressureException {
        boolean z2;
        boolean z3;
        synchronized (this) {
            Queue<Object> queue = this.k;
            z2 = true;
            z3 = false;
            if (queue != null) {
                if (obj == null) {
                    obj = j0.l.a.e.f3771b;
                }
                z3 = !queue.offer(obj);
                z2 = false;
            }
        }
        if (z2) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z3) {
            throw new MissingBackpressureException();
        }
    }

    public Object b() {
        synchronized (this) {
            Queue<Object> queue = this.k;
            if (queue == null) {
                return null;
            }
            Object objPeek = queue.peek();
            Object obj = this.l;
            if (objPeek == null && obj != null && queue.peek() == null) {
                objPeek = obj;
            }
            return objPeek;
        }
    }

    public Object c() {
        synchronized (this) {
            Queue<Object> queue = this.k;
            if (queue == null) {
                return null;
            }
            Object objPoll = queue.poll();
            Object obj = this.l;
            if (objPoll == null && obj != null && queue.peek() == null) {
                this.l = null;
                objPoll = obj;
            }
            return objPoll;
        }
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.k == null;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        synchronized (this) {
        }
    }

    public i() {
        this.k = new j0.l.e.n.c(j);
    }
}
