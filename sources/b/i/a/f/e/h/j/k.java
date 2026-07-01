package b.i.a.f.e.h.j;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k<L> {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public volatile L f1366b;

    @Nullable
    public volatile a<L> c;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static final class a<L> {
        public final L a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1367b;

        public a(L l, String str) {
            this.a = l;
            this.f1367b = str;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f1367b.equals(aVar.f1367b);
        }

        public final int hashCode() {
            return this.f1367b.hashCode() + (System.identityHashCode(this.a) * 31);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public interface b<L> {
        void a(L l);

        void b();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public final class c extends b.i.a.f.h.e.c {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            AnimatableValueParser.l(message.what == 1);
            b bVar = (b) message.obj;
            L l = k.this.f1366b;
            if (l == null) {
                bVar.b();
                return;
            }
            try {
                bVar.a(l);
            } catch (RuntimeException e) {
                bVar.b();
                throw e;
            }
        }
    }

    public k(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.a = new c(looper);
        AnimatableValueParser.z(l, "Listener must not be null");
        this.f1366b = l;
        AnimatableValueParser.w(str);
        this.c = new a<>(l, str);
    }

    public final void a(b<? super L> bVar) {
        AnimatableValueParser.z(bVar, "Notifier must not be null");
        this.a.sendMessage(this.a.obtainMessage(1, bVar));
    }
}
