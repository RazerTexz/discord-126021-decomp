package d0.e0.p.d.m0.i;

import java.io.IOException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.j, reason: use source file name */
/* JADX INFO: compiled from: LazyFieldLite.java */
/* JADX INFO: loaded from: classes3.dex */
public class LazyFieldLite {
    public volatile boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile MessageLite f3432b;

    public int getSerializedSize() {
        if (this.a) {
            return this.f3432b.getSerializedSize();
        }
        throw null;
    }

    public MessageLite getValue(MessageLite messageLite) {
        if (this.f3432b == null) {
            synchronized (this) {
                if (this.f3432b == null) {
                    try {
                        this.f3432b = messageLite;
                    } catch (IOException unused) {
                    }
                }
            }
        }
        return this.f3432b;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.f3432b;
        this.f3432b = messageLite;
        this.a = true;
        return messageLite2;
    }
}
