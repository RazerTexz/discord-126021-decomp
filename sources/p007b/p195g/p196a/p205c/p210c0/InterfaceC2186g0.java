package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import p007b.p195g.p196a.p197a.InterfaceC2073e;
import p007b.p195g.p196a.p205c.p210c0.InterfaceC2186g0;

/* JADX INFO: renamed from: b.g.a.c.c0.g0 */
/* JADX INFO: compiled from: VisibilityChecker.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2186g0<T extends InterfaceC2186g0<T>> {

    /* JADX INFO: renamed from: b.g.a.c.c0.g0$a */
    /* JADX INFO: compiled from: VisibilityChecker.java */
    public static class a implements InterfaceC2186g0<a>, Serializable {

        /* JADX INFO: renamed from: j */
        public static final a f4709j;
        private static final long serialVersionUID = 1;
        public final InterfaceC2073e.a _creatorMinLevel;
        public final InterfaceC2073e.a _fieldMinLevel;
        public final InterfaceC2073e.a _getterMinLevel;
        public final InterfaceC2073e.a _isGetterMinLevel;
        public final InterfaceC2073e.a _setterMinLevel;

        static {
            InterfaceC2073e.a aVar = InterfaceC2073e.a.PUBLIC_ONLY;
            InterfaceC2073e.a aVar2 = InterfaceC2073e.a.ANY;
            f4709j = new a(aVar, aVar, aVar2, aVar2, aVar);
        }

        public a(InterfaceC2073e.a aVar, InterfaceC2073e.a aVar2, InterfaceC2073e.a aVar3, InterfaceC2073e.a aVar4, InterfaceC2073e.a aVar5) {
            this._getterMinLevel = aVar;
            this._isGetterMinLevel = aVar2;
            this._setterMinLevel = aVar3;
            this._creatorMinLevel = aVar4;
            this._fieldMinLevel = aVar5;
        }

        /* JADX INFO: renamed from: a */
        public final InterfaceC2073e.a m1898a(InterfaceC2073e.a aVar, InterfaceC2073e.a aVar2) {
            return aVar2 == InterfaceC2073e.a.DEFAULT ? aVar : aVar2;
        }

        /* JADX INFO: renamed from: b */
        public a m1899b(InterfaceC2073e.a aVar, InterfaceC2073e.a aVar2, InterfaceC2073e.a aVar3, InterfaceC2073e.a aVar4, InterfaceC2073e.a aVar5) {
            return (aVar == this._getterMinLevel && aVar2 == this._isGetterMinLevel && aVar3 == this._setterMinLevel && aVar4 == this._creatorMinLevel && aVar5 == this._fieldMinLevel) ? this : new a(aVar, aVar2, aVar3, aVar4, aVar5);
        }

        public String toString() {
            return String.format("[Visibility: getter=%s,isGetter=%s,setter=%s,creator=%s,field=%s]", this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
        }
    }
}
