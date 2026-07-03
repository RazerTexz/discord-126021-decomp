package p600f0.p601e0.p605g;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12261a;
import p600f0.C12363g;
import p600f0.C12378v;
import p600f0.p601e0.p612m.AbstractC12349c;

/* JADX INFO: renamed from: f0.e0.g.g */
/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12287g extends AbstractC12240o implements Function0<List<? extends Certificate>> {
    public final /* synthetic */ C12261a $address;
    public final /* synthetic */ C12363g $certificatePinner;
    public final /* synthetic */ C12378v $unverifiedHandshake;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12287g(C12363g c12363g, C12378v c12378v, C12261a c12261a) {
        super(0);
        this.$certificatePinner = c12363g;
        this.$unverifiedHandshake = c12378v;
        this.$address = c12261a;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends Certificate> invoke() {
        AbstractC12349c abstractC12349c = this.$certificatePinner.f25906d;
        if (abstractC12349c == null) {
            C12238m.throwNpe();
        }
        return abstractC12349c.mo10338a(this.$unverifiedHandshake.m10398c(), this.$address.f25353a.f25979g);
    }
}
