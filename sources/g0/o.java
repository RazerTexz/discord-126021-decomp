package g0;

import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends d0.t.c<ByteString> implements RandomAccess {
    public static final o$a k = new o$a(null);
    public final ByteString[] l;
    public final int[] m;

    public o(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.l = byteStringArr;
        this.m = iArr;
    }

    @Override // d0.t.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return super.contains((ByteString) obj);
        }
        return false;
    }

    @Override // d0.t.c, java.util.List
    public Object get(int i) {
        return this.l[i];
    }

    @Override // d0.t.a
    public int getSize() {
        return this.l.length;
    }

    @Override // d0.t.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // d0.t.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.lastIndexOf((ByteString) obj);
        }
        return -1;
    }
}
