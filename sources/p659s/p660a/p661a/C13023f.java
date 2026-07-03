package p659s.p660a.p661a;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: s.a.a.f */
/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13023f implements CoroutineScope {

    /* JADX INFO: renamed from: j */
    public final CoroutineContext f27674j;

    public C13023f(CoroutineContext coroutineContext) {
        this.f27674j = coroutineContext;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f27674j;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CoroutineScope(coroutineContext=");
        sbM833U.append(this.f27674j);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
