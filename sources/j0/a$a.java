package j0;

import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: BackpressureOverflow.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a implements a$b {
    public static final a$a a = new a$a();

    @Override // j0.a$b
    public boolean a() throws MissingBackpressureException {
        throw new MissingBackpressureException("Overflowed buffer");
    }
}
