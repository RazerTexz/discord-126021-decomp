package p007b.p195g.p196a.p198b.p204t;

import com.discord.utilities.rest.SendUtils;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: renamed from: b.g.a.b.t.a */
/* JADX INFO: compiled from: BufferRecycler.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2139a {

    /* JADX INFO: renamed from: a */
    public static final int[] f4591a = {8000, 8000, 2000, 2000};

    /* JADX INFO: renamed from: b */
    public static final int[] f4592b = {SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, 200, 200};

    /* JADX INFO: renamed from: c */
    public final AtomicReferenceArray<byte[]> f4593c = new AtomicReferenceArray<>(4);

    /* JADX INFO: renamed from: d */
    public final AtomicReferenceArray<char[]> f4594d = new AtomicReferenceArray<>(4);

    /* JADX INFO: renamed from: a */
    public char[] m1730a(int i, int i2) {
        int i3 = f4592b[i];
        if (i2 < i3) {
            i2 = i3;
        }
        char[] andSet = this.f4594d.getAndSet(i, null);
        return (andSet == null || andSet.length < i2) ? new char[i2] : andSet;
    }
}
