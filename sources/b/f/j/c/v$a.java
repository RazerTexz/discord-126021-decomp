package b.f.j.c;

import b.f.j.a.c.c$a;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: LruCountingMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class v$a<V> implements b.f.d.h.f<V> {
    public final /* synthetic */ m$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f562b;

    public v$a(v vVar, m$a m_a) {
        this.f562b = vVar;
        this.a = m_a;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x003d  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.f.d.h.f
    public void release(V v) {
        boolean z2;
        Object obj;
        v vVar = this.f562b;
        m$a m_a = this.a;
        Objects.requireNonNull(vVar);
        Objects.requireNonNull(m_a);
        synchronized (vVar) {
            synchronized (vVar) {
                z2 = false;
                b.c.a.a0.d.B(m_a.c > 0);
                m_a.c--;
            }
            CloseableReference.s(vVar.o(m_a));
            if (!z2) {
                m_a = null;
            }
            if (m_a != null && (obj = m_a.e) != null) {
                ((c$a) obj).a(m_a.a, true);
            }
            vVar.m();
            vVar.j();
        }
        synchronized (vVar) {
            if (!m_a.d && m_a.c == 0) {
                vVar.f561b.d(m_a.a, m_a);
                z2 = true;
            }
        }
        CloseableReference.s(vVar.o(m_a));
        if (!z2) {
            m_a = null;
        }
        if (m_a != null) {
            ((c$a) obj).a(m_a.a, true);
        }
        vVar.m();
        vVar.j();
    }
}
