package b.f.j.l;

import com.discord.api.permission.Permission;

/* JADX INFO: renamed from: b.f.j.l.c, reason: use source file name */
/* JADX INFO: compiled from: BitmapCounterProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapCounterProvider {
    public static final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f593b;
    public static volatile BitmapCounter c;

    static {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        a = ((long) iMin) > Permission.MOVE_MEMBERS ? (iMin / 4) * 3 : iMin / 2;
        f593b = 384;
    }
}
