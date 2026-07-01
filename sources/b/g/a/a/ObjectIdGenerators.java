package b.g.a.a;

/* JADX INFO: renamed from: b.g.a.a.j0, reason: use source file name */
/* JADX INFO: compiled from: ObjectIdGenerators.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ObjectIdGenerators<T> extends ObjectIdGenerator<T> {
    public final Class<?> _scope;

    public ObjectIdGenerators(Class<?> cls) {
        this._scope = cls;
    }

    @Override // b.g.a.a.ObjectIdGenerator
    public boolean a(ObjectIdGenerator<?> objectIdGenerator) {
        return objectIdGenerator.getClass() == getClass() && objectIdGenerator.d() == this._scope;
    }

    @Override // b.g.a.a.ObjectIdGenerator
    public final Class<?> d() {
        return this._scope;
    }
}
