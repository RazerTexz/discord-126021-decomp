package d0.y;

import d0.z.d.m;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Sequence<File> {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f3588b;
    public final Function1<File, Boolean> c;
    public final Function1<File, Unit> d;
    public final Function2<File, IOException, Unit> e;
    public final int f;

    public d(File file, e eVar) {
        m.checkNotNullParameter(file, "start");
        m.checkNotNullParameter(eVar, "direction");
        this.a = file;
        this.f3588b = eVar;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = Integer.MAX_VALUE;
    }

    public static final /* synthetic */ e access$getDirection$p(d dVar) {
        return dVar.f3588b;
    }

    public static final /* synthetic */ int access$getMaxDepth$p(d dVar) {
        return dVar.f;
    }

    public static final /* synthetic */ Function1 access$getOnEnter$p(d dVar) {
        return dVar.c;
    }

    public static final /* synthetic */ Function2 access$getOnFail$p(d dVar) {
        return dVar.e;
    }

    public static final /* synthetic */ Function1 access$getOnLeave$p(d dVar) {
        return dVar.d;
    }

    public static final /* synthetic */ File access$getStart$p(d dVar) {
        return dVar.a;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new d$b(this);
    }
}
