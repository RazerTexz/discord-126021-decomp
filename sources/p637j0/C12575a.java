package p637j0;

import p658rx.exceptions.MissingBackpressureException;

/* JADX INFO: renamed from: j0.a */
/* JADX INFO: compiled from: BackpressureOverflow.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12575a {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f26683a = 0;

    /* JADX INFO: renamed from: j0.a$a */
    /* JADX INFO: compiled from: BackpressureOverflow.java */
    public static final class a implements b {

        /* JADX INFO: renamed from: a */
        public static final a f26684a = new a();

        @Override // p637j0.C12575a.b
        /* JADX INFO: renamed from: a */
        public boolean mo10731a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* JADX INFO: renamed from: j0.a$b */
    /* JADX INFO: compiled from: BackpressureOverflow.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        boolean mo10731a() throws MissingBackpressureException;
    }
}
