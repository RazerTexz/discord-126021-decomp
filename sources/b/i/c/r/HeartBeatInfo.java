package b.i.c.r;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.i.c.r.d, reason: use source file name */
/* JADX INFO: compiled from: HeartBeatInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public interface HeartBeatInfo {

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

        public int f() {
            return this.code;
        }
    }

    @NonNull
    a a(@NonNull String str);
}
