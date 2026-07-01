package b.f.g.c;

import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Objects2;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;

/* JADX INFO: Add missing generic type declarations: [IMAGE] */
/* JADX INFO: renamed from: b.f.g.c.b, reason: use source file name */
/* JADX INFO: compiled from: AbstractDraweeControllerBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class AbstractDraweeControllerBuilder2<IMAGE> implements Supplier<DataSource<IMAGE>> {
    public final /* synthetic */ DraweeController a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f500b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ AbstractDraweeControllerBuilder.b e;
    public final /* synthetic */ AbstractDraweeControllerBuilder f;

    public AbstractDraweeControllerBuilder2(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, DraweeController draweeController, String str, Object obj, Object obj2, AbstractDraweeControllerBuilder.b bVar) {
        this.f = abstractDraweeControllerBuilder;
        this.a = draweeController;
        this.f500b = str;
        this.c = obj;
        this.d = obj2;
        this.e = bVar;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return this.f.b(this.a, this.f500b, this.c, this.d, this.e);
    }

    public String toString() {
        Objects2 objects2H2 = AnimatableValueParser.h2(this);
        objects2H2.c("request", this.c.toString());
        return objects2H2.toString();
    }
}
