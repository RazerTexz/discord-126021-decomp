package b.i.a.c.e3;

import androidx.annotation.Nullable;
import b.i.a.c.f3.Util2;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.e3.g, reason: use source file name */
/* JADX INFO: compiled from: BaseDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDataSource implements DataSource3 {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<TransferListener> f941b = new ArrayList<>(1);
    public int c;

    @Nullable
    public DataSpec d;

    public BaseDataSource(boolean z2) {
        this.a = z2;
    }

    @Override // b.i.a.c.e3.DataSource3
    public final void d(TransferListener transferListener) {
        Objects.requireNonNull(transferListener);
        if (this.f941b.contains(transferListener)) {
            return;
        }
        this.f941b.add(transferListener);
        this.c++;
    }

    @Override // b.i.a.c.e3.DataSource3
    public /* synthetic */ Map j() {
        return DataSource2.a(this);
    }

    public final void p(int i) {
        DataSpec dataSpec = this.d;
        int i2 = Util2.a;
        for (int i3 = 0; i3 < this.c; i3++) {
            this.f941b.get(i3).e(this, dataSpec, this.a, i);
        }
    }

    public final void q() {
        DataSpec dataSpec = this.d;
        int i = Util2.a;
        for (int i2 = 0; i2 < this.c; i2++) {
            this.f941b.get(i2).a(this, dataSpec, this.a);
        }
        this.d = null;
    }

    public final void r(DataSpec dataSpec) {
        for (int i = 0; i < this.c; i++) {
            this.f941b.get(i).g(this, dataSpec, this.a);
        }
    }

    public final void s(DataSpec dataSpec) {
        this.d = dataSpec;
        for (int i = 0; i < this.c; i++) {
            this.f941b.get(i).b(this, dataSpec, this.a);
        }
    }
}
