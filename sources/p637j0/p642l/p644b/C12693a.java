package p637j0.p642l.p644b;

import androidx.recyclerview.widget.RecyclerView;
import p658rx.Producer;

/* JADX INFO: renamed from: j0.l.b.a */
/* JADX INFO: compiled from: ProducerArbiter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12693a implements Producer {

    /* JADX INFO: renamed from: j */
    public static final Producer f27159j = new a();

    /* JADX INFO: renamed from: k */
    public long f27160k;

    /* JADX INFO: renamed from: l */
    public Producer f27161l;

    /* JADX INFO: renamed from: m */
    public boolean f27162m;

    /* JADX INFO: renamed from: n */
    public long f27163n;

    /* JADX INFO: renamed from: o */
    public long f27164o;

    /* JADX INFO: renamed from: p */
    public Producer f27165p;

    /* JADX INFO: renamed from: j0.l.b.a$a */
    /* JADX INFO: compiled from: ProducerArbiter.java */
    public static class a implements Producer {
        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10795a() {
        while (true) {
            synchronized (this) {
                long j = this.f27163n;
                long j2 = this.f27164o;
                Producer producer = this.f27165p;
                if (j == 0 && j2 == 0 && producer == null) {
                    this.f27162m = false;
                    return;
                }
                this.f27163n = 0L;
                this.f27164o = 0L;
                this.f27165p = null;
                long j3 = this.f27160k;
                if (j3 != RecyclerView.FOREVER_NS) {
                    long j4 = j3 + j;
                    if (j4 < 0 || j4 == RecyclerView.FOREVER_NS) {
                        this.f27160k = RecyclerView.FOREVER_NS;
                        j3 = Long.MAX_VALUE;
                    } else {
                        j3 = j4 - j2;
                        if (j3 < 0) {
                            throw new IllegalStateException("more produced than requested");
                        }
                        this.f27160k = j3;
                    }
                }
                if (producer == null) {
                    Producer producer2 = this.f27161l;
                    if (producer2 != null && j != 0) {
                        producer2.mo10704j(j);
                    }
                } else if (producer == f27159j) {
                    this.f27161l = null;
                } else {
                    this.f27161l = producer;
                    producer.mo10704j(j3);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10796b(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("n > 0 required");
        }
        synchronized (this) {
            if (this.f27162m) {
                this.f27164o += j;
                return;
            }
            this.f27162m = true;
            try {
                long j2 = this.f27160k;
                if (j2 != RecyclerView.FOREVER_NS) {
                    long j3 = j2 - j;
                    if (j3 < 0) {
                        throw new IllegalStateException("more items arrived than were requested");
                    }
                    this.f27160k = j3;
                }
                m10795a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f27162m = false;
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m10797c(Producer producer) {
        synchronized (this) {
            if (this.f27162m) {
                if (producer == null) {
                    producer = f27159j;
                }
                this.f27165p = producer;
                return;
            }
            this.f27162m = true;
            try {
                this.f27161l = producer;
                if (producer != null) {
                    producer.mo10704j(this.f27160k);
                }
                m10795a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f27162m = false;
                    throw th;
                }
            }
        }
    }

    @Override // p658rx.Producer
    /* JADX INFO: renamed from: j */
    public void mo10704j(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j == 0) {
            return;
        }
        synchronized (this) {
            if (this.f27162m) {
                this.f27163n += j;
                return;
            }
            this.f27162m = true;
            try {
                long j2 = this.f27160k + j;
                if (j2 < 0) {
                    j2 = RecyclerView.FOREVER_NS;
                }
                this.f27160k = j2;
                Producer producer = this.f27161l;
                if (producer != null) {
                    producer.mo10704j(j);
                }
                m10795a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f27162m = false;
                    throw th;
                }
            }
        }
    }
}
