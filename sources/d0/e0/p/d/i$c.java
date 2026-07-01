package d0.e0.p.d;

import d0.e0.p.d.m0.c.b$a;

/* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum i$c {
    DECLARED,
    INHERITED;

    public final boolean accept(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "member");
        b$a kind = bVar.getKind();
        d0.z.d.m.checkNotNullExpressionValue(kind, "member.kind");
        return kind.isReal() == (this == DECLARED);
    }
}
