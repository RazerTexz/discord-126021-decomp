package p600f0.p601e0.p608j;

import java.io.IOException;
import java.util.List;
import p600f0.p601e0.p604f.AbstractC12277a;

/* JADX INFO: renamed from: f0.e0.j.i */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12315i extends AbstractC12277a {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C12311e f25685e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f25686f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ List f25687g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12315i(String str, boolean z2, String str2, boolean z3, C12311e c12311e, int i, List list) {
        super(str2, z3);
        this.f25685e = c12311e;
        this.f25686f = i;
        this.f25687g = list;
    }

    @Override // p600f0.p601e0.p604f.AbstractC12277a
    /* JADX INFO: renamed from: a */
    public long mo10150a() {
        if (!this.f25685e.f25641w.mo10308a(this.f25686f, this.f25687g)) {
            return -1L;
        }
        try {
            this.f25685e.f25627K.m10304n(this.f25686f, EnumC12307a.CANCEL);
            synchronized (this.f25685e) {
                this.f25685e.f25629M.remove(Integer.valueOf(this.f25686f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
