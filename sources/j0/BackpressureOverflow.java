package j0;

import rx.exceptions.MissingBackpressureException;

/* JADX INFO: renamed from: j0.a, reason: use source file name */
/* JADX INFO: compiled from: BackpressureOverflow.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BackpressureOverflow {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: j0.a$a */
    /* JADX INFO: compiled from: BackpressureOverflow.java */
    public static final class a implements b {
        public static final a a = new a();

        @Override // j0.BackpressureOverflow.b
        public boolean a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* JADX INFO: renamed from: j0.a$b */
    /* JADX INFO: compiled from: BackpressureOverflow.java */
    public interface b {
        boolean a() throws MissingBackpressureException;
    }
}
