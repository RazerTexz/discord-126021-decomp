package b.i.c.r;

import android.content.Context;
import androidx.annotation.NonNull;
import b.i.c.l.Lazy2;
import b.i.c.r.HeartBeatInfo;
import b.i.c.t.Provider2;

/* JADX INFO: renamed from: b.i.c.r.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultHeartBeatInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultHeartBeatInfo3 implements HeartBeatInfo {
    public Provider2<HeartBeatInfoStorage> a;

    public DefaultHeartBeatInfo3(final Context context) {
        this.a = new Lazy2(new Provider2(context) { // from class: b.i.c.r.a
            public final Context a;

            {
                this.a = context;
            }

            @Override // b.i.c.t.Provider2
            public Object get() {
                HeartBeatInfoStorage heartBeatInfoStorage;
                Context context2 = this.a;
                synchronized (HeartBeatInfoStorage.class) {
                    if (HeartBeatInfoStorage.a == null) {
                        HeartBeatInfoStorage.a = new HeartBeatInfoStorage(context2);
                    }
                    heartBeatInfoStorage = HeartBeatInfoStorage.a;
                }
                return heartBeatInfoStorage;
            }
        });
    }

    @Override // b.i.c.r.HeartBeatInfo
    @NonNull
    public HeartBeatInfo.a a(@NonNull String str) {
        boolean zA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zA2 = this.a.get().a(str, jCurrentTimeMillis);
        HeartBeatInfoStorage heartBeatInfoStorage = this.a.get();
        synchronized (heartBeatInfoStorage) {
            zA = heartBeatInfoStorage.a("fire-global", jCurrentTimeMillis);
        }
        if (zA2 && zA) {
            return HeartBeatInfo.a.COMBINED;
        }
        if (zA) {
            return HeartBeatInfo.a.GLOBAL;
        }
        return zA2 ? HeartBeatInfo.a.SDK : HeartBeatInfo.a.NONE;
    }
}
