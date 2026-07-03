package p007b.p195g.p196a.p205c.p218h0;

import p007b.p195g.p196a.p205c.AbstractC2360j;

/* JADX INFO: renamed from: b.g.a.c.h0.f */
/* JADX INFO: compiled from: MapLikeType.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2327f extends AbstractC2333l {
    private static final long serialVersionUID = 1;
    public final AbstractC2360j _keyType;
    public final AbstractC2360j _valueType;

    public C2327f(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr, AbstractC2360j abstractC2360j2, AbstractC2360j abstractC2360j3, Object obj, Object obj2, boolean z2) {
        super(cls, c2334m, abstractC2360j, abstractC2360jArr, abstractC2360j2._hash ^ abstractC2360j3._hash, obj, obj2, z2);
        this._keyType = abstractC2360j2;
        this._valueType = abstractC2360j3;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: C */
    public AbstractC2360j mo2093C(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr) {
        return new C2327f(cls, c2334m, abstractC2360j, abstractC2360jArr, this._keyType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: D */
    public AbstractC2360j mo2094D(AbstractC2360j abstractC2360j) {
        return this._valueType == abstractC2360j ? this : new C2327f(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, abstractC2360j, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: F */
    public AbstractC2360j mo2105F(AbstractC2360j abstractC2360j) {
        AbstractC2360j abstractC2360jMo2105F;
        AbstractC2360j abstractC2360jMo2105F2;
        AbstractC2360j abstractC2360jMo2105F3 = super.mo2105F(abstractC2360j);
        AbstractC2360j abstractC2360jMo2121o = abstractC2360j.mo2121o();
        if ((abstractC2360jMo2105F3 instanceof C2327f) && abstractC2360jMo2121o != null && (abstractC2360jMo2105F2 = this._keyType.mo2105F(abstractC2360jMo2121o)) != this._keyType) {
            abstractC2360jMo2105F3 = ((C2327f) abstractC2360jMo2105F3).mo2117M(abstractC2360jMo2105F2);
        }
        AbstractC2360j abstractC2360jMo2099k = abstractC2360j.mo2099k();
        return (abstractC2360jMo2099k == null || (abstractC2360jMo2105F = this._valueType.mo2105F(abstractC2360jMo2099k)) == this._valueType) ? abstractC2360jMo2105F3 : abstractC2360jMo2105F3.mo2094D(abstractC2360jMo2105F);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.AbstractC2333l
    /* JADX INFO: renamed from: K */
    public String mo2106K() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        if (this._keyType != null) {
            sb.append('<');
            sb.append(this._keyType.mo1729e());
            sb.append(',');
            sb.append(this._valueType.mo1729e());
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public C2327f mo2095E(Object obj) {
        return new C2327f(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.mo2130N(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    /* JADX INFO: renamed from: M */
    public C2327f mo2117M(AbstractC2360j abstractC2360j) {
        return abstractC2360j == this._keyType ? this : new C2327f(this._class, this._bindings, this._superClass, this._superInterfaces, abstractC2360j, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public C2327f mo2129M() {
        return this._asStatic ? this : new C2327f(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.mo2129M(), this._valueHandler, this._typeHandler, true);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public C2327f mo2130N(Object obj) {
        return new C2327f(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, this._valueHandler, obj, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public C2327f mo2131O(Object obj) {
        return new C2327f(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        C2327f c2327f = (C2327f) obj;
        return this._class == c2327f._class && this._keyType.equals(c2327f._keyType) && this._valueType.equals(c2327f._valueType);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: k */
    public AbstractC2360j mo2099k() {
        return this._valueType;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: l */
    public StringBuilder mo2100l(StringBuilder sb) {
        AbstractC2333l.m2139J(this._class, sb, true);
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: m */
    public StringBuilder mo2101m(StringBuilder sb) {
        AbstractC2333l.m2139J(this._class, sb, false);
        sb.append('<');
        this._keyType.mo2101m(sb);
        this._valueType.mo2101m(sb);
        sb.append(">;");
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: o */
    public AbstractC2360j mo2121o() {
        return this._keyType;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: s */
    public boolean mo2103s() {
        return super.mo2103s() || this._valueType.mo2103s() || this._keyType.mo2103s();
    }

    public String toString() {
        return String.format("[map-like type; class %s, %s -> %s]", this._class.getName(), this._keyType, this._valueType);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: v */
    public boolean mo2104v() {
        return true;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: z */
    public boolean mo2122z() {
        return true;
    }
}
