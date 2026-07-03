package p007b.p109f.p161j.p177l;

import com.discord.api.permission.Permission;

/* JADX INFO: renamed from: b.f.j.l.c */
/* JADX INFO: compiled from: BitmapCounterProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1931c {

    /* JADX INFO: renamed from: a */
    public static final int f3923a;

    /* JADX INFO: renamed from: b */
    public static int f3924b;

    /* JADX INFO: renamed from: c */
    public static volatile C1930b f3925c;

    static {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        f3923a = ((long) iMin) > Permission.MOVE_MEMBERS ? (iMin / 4) * 3 : iMin / 2;
        f3924b = 384;
    }
}
