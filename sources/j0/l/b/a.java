package j0.l.b;

import androidx.recyclerview.widget.RecyclerView;
import rx.Producer;

/* JADX INFO: compiled from: ProducerArbiter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Producer {
    public static final Producer j = new a$a();
    public long k;
    public Producer l;
    public boolean m;
    public long n;
    public long o;
    public Producer p;

    public void a() {
        while (true) {
            synchronized (this) {
                long j2 = this.n;
                long j3 = this.o;
                Producer producer = this.p;
                if (j2 == 0 && j3 == 0 && producer == null) {
                    this.m = false;
                    return;
                }
                this.n = 0L;
                this.o = 0L;
                this.p = null;
                long j4 = this.k;
                if (j4 != RecyclerView.FOREVER_NS) {
                    long j5 = j4 + j2;
                    if (j5 < 0 || j5 == RecyclerView.FOREVER_NS) {
                        this.k = RecyclerView.FOREVER_NS;
                        j4 = Long.MAX_VALUE;
                    } else {
                        j4 = j5 - j3;
                        if (j4 < 0) {
                            throw new IllegalStateException("more produced than requested");
                        }
                        this.k = j4;
                    }
                }
                if (producer == null) {
                    Producer producer2 = this.l;
                    if (producer2 != null && j2 != 0) {
                        producer2.j(j2);
                    }
                } else if (producer == j) {
                    this.l = null;
                } else {
                    this.l = producer;
                    producer.j(j4);
                }
            }
        }
    }

    public void b(long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("n > 0 required");
        }
        synchronized (this) {
            if (this.m) {
                this.o += j2;
                return;
            }
            this.m = true;
            try {
                long j3 = this.k;
                if (j3 != RecyclerView.FOREVER_NS) {
                    long j4 = j3 - j2;
                    if (j4 < 0) {
                        throw new IllegalStateException("more items arrived than were requested");
                    }
                    this.k = j4;
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.m = false;
                    throw th;
                }
            }
        }
    }

    public void c(Producer producer) {
        synchronized (this) {
            if (this.m) {
                if (producer == null) {
                    producer = j;
                }
                this.p = producer;
                return;
            }
            this.m = true;
            try {
                this.l = producer;
                if (producer != null) {
                    producer.j(this.k);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.m = false;
                    throw th;
                }
            }
        }
    }

    @Override // rx.Producer
    public void j(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j2 == 0) {
            return;
        }
        synchronized (this) {
            if (this.m) {
                this.n += j2;
                return;
            }
            this.m = true;
            try {
                long j3 = this.k + j2;
                if (j3 < 0) {
                    j3 = RecyclerView.FOREVER_NS;
                }
                this.k = j3;
                Producer producer = this.l;
                if (producer != null) {
                    producer.j(j2);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.m = false;
                    throw th;
                }
            }
        }
    }
}
