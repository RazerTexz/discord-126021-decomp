package b.g.a.b.t;

import com.discord.utilities.rest.SendUtils;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: renamed from: b.g.a.b.t.a, reason: use source file name */
/* JADX INFO: compiled from: BufferRecycler.java */
/* JADX INFO: loaded from: classes3.dex */
public class BufferRecycler {
    public static final int[] a = {8000, 8000, 2000, 2000};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f676b = {SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, 200, 200};
    public final AtomicReferenceArray<byte[]> c = new AtomicReferenceArray<>(4);
    public final AtomicReferenceArray<char[]> d = new AtomicReferenceArray<>(4);

    public char[] a(int i, int i2) {
        int i3 = f676b[i];
        if (i2 < i3) {
            i2 = i3;
        }
        char[] andSet = this.d.getAndSet(i, null);
        return (andSet == null || andSet.length < i2) ? new char[i2] : andSet;
    }
}
