package p637j0.p642l.p647e;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import p637j0.p642l.p643a.C12600a1;
import p637j0.p642l.p643a.C12614e;
import p658rx.Producer;

/* JADX INFO: renamed from: j0.l.e.c */
/* JADX INFO: compiled from: BackpressureDrainManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12713c extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    public final a actual;
    public boolean emitting;
    public Throwable exception;
    public volatile boolean terminated;

    /* JADX INFO: renamed from: j0.l.e.c$a */
    /* JADX INFO: compiled from: BackpressureDrainManager.java */
    public interface a {
    }

    public C12713c(a aVar) {
        this.actual = aVar;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00a7 */
    /* JADX WARN: Code duplicated, block: B:100:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x0057 A[EDGE_INSN: B:108:0x0057->B:32:0x0057 BREAK  A[LOOP:1: B:12:0x0015->B:72:0x00b5], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0043 A[Catch: all -> 0x00bc, TRY_ENTER, TryCatch #5 {all -> 0x00bc, blocks: (B:10:0x0012, B:32:0x0057, B:16:0x001f, B:27:0x0043, B:30:0x0052, B:69:0x00a9), top: B:95:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x00a9 A[Catch: all -> 0x00bc, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x00bc, blocks: (B:10:0x0012, B:32:0x0057, B:16:0x001f, B:27:0x0043, B:30:0x0052, B:69:0x00a9), top: B:95:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x00b5 A[LOOP:1: B:12:0x0015->B:72:0x00b5, LOOP_END] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m10810a() throws Throwable {
        Throwable th;
        Object objPoll;
        AtomicLong atomicLong;
        boolean z2;
        synchronized (this) {
            if (this.emitting) {
                return;
            }
            boolean z3 = true;
            this.emitting = true;
            boolean z4 = this.terminated;
            long j = get();
            try {
                a aVar = this.actual;
                while (true) {
                    int i = 0;
                    while (true) {
                        if (j <= 0 && !z4) {
                            break;
                        }
                        if (!z4) {
                            C12600a1.a aVar2 = (C12600a1.a) aVar;
                            objPoll = aVar2.f26728j.poll();
                            atomicLong = aVar2.f26729k;
                            if (atomicLong != null && objPoll != null) {
                                atomicLong.incrementAndGet();
                            }
                            if (objPoll == null) {
                                break;
                            }
                            if (C12614e.m10744a(((C12600a1.a) aVar).f26730l, objPoll)) {
                                return;
                            }
                            j--;
                            i++;
                        } else if (((C12600a1.a) aVar).f26728j.peek() == null) {
                            try {
                                Throwable th2 = this.exception;
                                C12600a1.a aVar3 = (C12600a1.a) aVar;
                                if (th2 != null) {
                                    aVar3.f26730l.onError(th2);
                                    return;
                                } else {
                                    aVar3.f26730l.onCompleted();
                                    return;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                this = this;
                            }
                        } else {
                            if (j == 0) {
                                break;
                            }
                            C12600a1.a aVar4 = (C12600a1.a) aVar;
                            objPoll = aVar4.f26728j.poll();
                            atomicLong = aVar4.f26729k;
                            if (atomicLong != null) {
                                atomicLong.incrementAndGet();
                            }
                            if (objPoll == null) {
                                break;
                                break;
                            } else {
                                if (C12614e.m10744a(((C12600a1.a) aVar).f26730l, objPoll)) {
                                    return;
                                }
                                j--;
                                i++;
                            }
                        }
                        if (z3) {
                            throw th;
                        }
                        synchronized (this) {
                            this.emitting = false;
                        }
                        throw th;
                    }
                    synchronized (this) {
                        try {
                            z4 = this.terminated;
                            boolean z5 = ((C12600a1.a) aVar).f26728j.peek() != null;
                            try {
                                if (get() != RecyclerView.FOREVER_NS) {
                                    long jAddAndGet = addAndGet(-i);
                                    if ((jAddAndGet != 0 && z5) || (z4 && !z5)) {
                                        j = jAddAndGet;
                                    }
                                    this.emitting = false;
                                    return;
                                }
                                if (!z5 && !z4) {
                                    this.emitting = false;
                                    return;
                                }
                                j = Long.MAX_VALUE;
                            } catch (Throwable th4) {
                                th = th4;
                                z2 = true;
                                while (true) {
                                    break;
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            z2 = false;
                        }
                    }
                    try {
                        break;
                        throw th;
                    } catch (Throwable th6) {
                        boolean z6 = z2;
                        th = th6;
                        z3 = z6;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                this = this;
                z3 = false;
            }
        }
    }

    @Override // p658rx.Producer
    /* JADX INFO: renamed from: j */
    public void mo10704j(long j) throws Throwable {
        boolean z2;
        if (j == 0) {
            return;
        }
        while (true) {
            long j2 = get();
            boolean z3 = true;
            z2 = j2 == 0;
            long j3 = RecyclerView.FOREVER_NS;
            if (j2 == RecyclerView.FOREVER_NS) {
                break;
            }
            if (j == RecyclerView.FOREVER_NS) {
                j3 = j;
            } else {
                if (j2 <= RecyclerView.FOREVER_NS - j) {
                    j3 = j2 + j;
                }
                z3 = z2;
            }
            if (compareAndSet(j2, j3)) {
                z2 = z3;
                break;
            }
        }
        if (z2) {
            m10810a();
        }
    }
}
