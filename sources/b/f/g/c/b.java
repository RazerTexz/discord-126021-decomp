package b.f.g.c;

import b.f.d.d.i;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder$b;
import com.facebook.drawee.interfaces.DraweeController;

/* JADX INFO: Add missing generic type declarations: [IMAGE] */
/* JADX INFO: compiled from: AbstractDraweeControllerBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class b<IMAGE> implements Supplier<DataSource<IMAGE>> {
    public final /* synthetic */ DraweeController a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f500b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ AbstractDraweeControllerBuilder$b e;
    public final /* synthetic */ AbstractDraweeControllerBuilder f;

    public b(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, DraweeController draweeController, String str, Object obj, Object obj2, AbstractDraweeControllerBuilder$b abstractDraweeControllerBuilder$b) {
        this.f = abstractDraweeControllerBuilder;
        this.a = draweeController;
        this.f500b = str;
        this.c = obj;
        this.d = obj2;
        this.e = abstractDraweeControllerBuilder$b;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return this.f.b(this.a, this.f500b, this.c, this.d, this.e);
    }

    public String toString() {
        i iVarH2 = b.c.a.a0.d.h2(this);
        iVarH2.c("request", this.c.toString());
        return iVarH2.toString();
    }
}
