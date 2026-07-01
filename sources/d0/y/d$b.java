package d0.y;

import d0.z.d.m;
import java.io.File;
import java.util.ArrayDeque;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b extends d0.t.b<File> {
    public final ArrayDeque<d$c> l;
    public final /* synthetic */ d m;

    public d$b(d dVar) {
        this.m = dVar;
        ArrayDeque<d$c> arrayDeque = new ArrayDeque<>();
        this.l = arrayDeque;
        if (d.access$getStart$p(dVar).isDirectory()) {
            arrayDeque.push(c(d.access$getStart$p(dVar)));
        } else if (d.access$getStart$p(dVar).isFile()) {
            arrayDeque.push(new d$b$b(this, d.access$getStart$p(dVar)));
        } else {
            this.j = 3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.File, java.lang.Object] */
    @Override // d0.t.b
    public void a() {
        T tStep;
        while (true) {
            d$c d_cPeek = this.l.peek();
            if (d_cPeek == null) {
                tStep = 0;
                break;
            }
            tStep = d_cPeek.step();
            if (tStep == 0) {
                this.l.pop();
            } else if (m.areEqual((Object) tStep, d_cPeek.getRoot()) || !tStep.isDirectory() || this.l.size() >= d.access$getMaxDepth$p(this.m)) {
                break;
            } else {
                this.l.push(c(tStep));
            }
        }
        if (tStep == 0) {
            this.j = 3;
        } else {
            this.k = tStep;
            this.j = 1;
        }
    }

    public final d$a c(File file) {
        int iOrdinal = d.access$getDirection$p(this.m).ordinal();
        if (iOrdinal == 0) {
            return new d$b$c(this, file);
        }
        if (iOrdinal == 1) {
            return new d$b$a(this, file);
        }
        throw new NoWhenBranchMatchedException();
    }
}
