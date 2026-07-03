package p007b.p225i.p361c.p397r;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: renamed from: b.i.c.r.e */
/* JADX INFO: compiled from: HeartBeatInfoStorage.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4804e {

    /* JADX INFO: renamed from: a */
    public static C4804e f12841a;

    /* JADX INFO: renamed from: b */
    public final SharedPreferences f12842b;

    public C4804e(Context context) {
        this.f12842b = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    /* JADX INFO: renamed from: a */
    public synchronized boolean m6718a(String str, long j) {
        if (!this.f12842b.contains(str)) {
            this.f12842b.edit().putLong(str, j).apply();
            return true;
        }
        if (j - this.f12842b.getLong(str, -1L) < 86400000) {
            return false;
        }
        this.f12842b.edit().putLong(str, j).apply();
        return true;
    }
}
