package b.i.a.c.x2.k0;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: TsPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i0$b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f1258b;
    public final List<i0$a> c;
    public final byte[] d;

    public i0$b(int i, @Nullable String str, @Nullable List<i0$a> list, byte[] bArr) {
        this.a = i;
        this.f1258b = str;
        this.c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.d = bArr;
    }
}
