package b.i.c.r;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: HeartBeatInfoStorage.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f1763b;

    public e(Context context) {
        this.f1763b = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    public synchronized boolean a(String str, long j) {
        if (!this.f1763b.contains(str)) {
            this.f1763b.edit().putLong(str, j).apply();
            return true;
        }
        if (j - this.f1763b.getLong(str, -1L) < 86400000) {
            return false;
        }
        this.f1763b.edit().putLong(str, j).apply();
        return true;
    }
}
