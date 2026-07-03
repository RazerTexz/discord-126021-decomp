package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p318e.HandlerC3479c;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.k */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3301k<L> {

    /* JADX INFO: renamed from: a */
    public final c f9428a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public volatile L f9429b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public volatile a<L> f9430c;

    /* JADX INFO: renamed from: b.i.a.f.e.h.j.k$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static final class a<L> {

        /* JADX INFO: renamed from: a */
        public final L f9431a;

        /* JADX INFO: renamed from: b */
        public final String f9432b;

        public a(L l, String str) {
            this.f9431a = l;
            this.f9432b = str;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9431a == aVar.f9431a && this.f9432b.equals(aVar.f9432b);
        }

        public final int hashCode() {
            return this.f9432b.hashCode() + (System.identityHashCode(this.f9431a) * 31);
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.h.j.k$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public interface b<L> {
        /* JADX INFO: renamed from: a */
        void mo4107a(L l);

        /* JADX INFO: renamed from: b */
        void mo4108b();
    }

    /* JADX INFO: renamed from: b.i.a.f.e.h.j.k$c */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public final class c extends HandlerC3479c {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            C1460d.m539l(message.what == 1);
            b bVar = (b) message.obj;
            L l = C3301k.this.f9429b;
            if (l == null) {
                bVar.mo4108b();
                return;
            }
            try {
                bVar.mo4107a(l);
            } catch (RuntimeException e) {
                bVar.mo4108b();
                throw e;
            }
        }
    }

    public C3301k(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.f9428a = new c(looper);
        C1460d.m595z(l, "Listener must not be null");
        this.f9429b = l;
        C1460d.m583w(str);
        this.f9430c = new a<>(l, str);
    }

    /* JADX INFO: renamed from: a */
    public final void m4106a(b<? super L> bVar) {
        C1460d.m595z(bVar, "Notifier must not be null");
        this.f9428a.sendMessage(this.f9428a.obtainMessage(1, bVar));
    }
}
