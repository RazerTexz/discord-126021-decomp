package d0.g0;

import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Sequence<IntRange> {
    public final CharSequence a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3580b;
    public final int c;
    public final Function2<CharSequence, Integer, Pair<Integer, Integer>> d;

    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        d0.z.d.m.checkNotNullParameter(charSequence, "input");
        d0.z.d.m.checkNotNullParameter(function2, "getNextMatch");
        this.a = charSequence;
        this.f3580b = i;
        this.c = i2;
        this.d = function2;
    }

    public static final /* synthetic */ Function2 access$getGetNextMatch$p(d dVar) {
        return dVar.d;
    }

    public static final /* synthetic */ CharSequence access$getInput$p(d dVar) {
        return dVar.a;
    }

    public static final /* synthetic */ int access$getLimit$p(d dVar) {
        return dVar.c;
    }

    public static final /* synthetic */ int access$getStartIndex$p(d dVar) {
        return dVar.f3580b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IntRange> iterator() {
        return new d$a(this);
    }
}
