package p007b.p225i.p361c.p397r;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.i.c.r.d */
/* JADX INFO: compiled from: HeartBeatInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC4803d {

    /* JADX INFO: renamed from: b.i.c.r.d$a */
    /* JADX INFO: compiled from: HeartBeatInfo.java */
    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        a(int i) {
            this.code = i;
        }

        /* JADX INFO: renamed from: f */
        public int m6717f() {
            return this.code;
        }
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    a mo6716a(@NonNull String str);
}
