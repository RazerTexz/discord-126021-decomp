package p007b.p109f.p132g.p139c;

import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1686i;

/* JADX INFO: Add missing generic type declarations: [IMAGE] */
/* JADX INFO: renamed from: b.f.g.c.b */
/* JADX INFO: compiled from: AbstractDraweeControllerBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class C1754b<IMAGE> implements Supplier<DataSource<IMAGE>> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ DraweeController f3292a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f3293b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3294c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f3295d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ AbstractDraweeControllerBuilder.EnumC10643b f3296e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ AbstractDraweeControllerBuilder f3297f;

    public C1754b(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, DraweeController draweeController, String str, Object obj, Object obj2, AbstractDraweeControllerBuilder.EnumC10643b enumC10643b) {
        this.f3297f = abstractDraweeControllerBuilder;
        this.f3292a = draweeController;
        this.f3293b = str;
        this.f3294c = obj;
        this.f3295d = obj2;
        this.f3296e = enumC10643b;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return this.f3297f.mo1056b(this.f3292a, this.f3293b, this.f3294c, this.f3295d, this.f3296e);
    }

    public String toString() {
        C1686i c1686iM526h2 = C1460d.m526h2(this);
        c1686iM526h2.m971c("request", this.f3294c.toString());
        return c1686iM526h2.toString();
    }
}
