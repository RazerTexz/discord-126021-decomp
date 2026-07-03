package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.AbstractC12053s;
import p507d0.p513e0.p514p.p515d.p516l0.AbstractC11273e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.v */
/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12056v extends AbstractC12240o implements Function1<Field, AbstractC11273e<? extends Field>> {
    public final /* synthetic */ boolean $isGetter;
    public final /* synthetic */ C12054t $isJvmStaticProperty$1;
    public final /* synthetic */ C12055u $isNotNullProperty$2;
    public final /* synthetic */ AbstractC12053s.a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12056v(AbstractC12053s.a aVar, boolean z2, C12055u c12055u, C12054t c12054t) {
        super(1);
        this.$this_computeCallerForAccessor = aVar;
        this.$isGetter = z2;
        this.$isNotNullProperty$2 = c12055u;
        this.$isJvmStaticProperty$1 = c12054t;
    }

    @Override // kotlin.jvm.functions.Function1
    public final AbstractC11273e<Field> invoke(Field field) {
        C12238m.checkNotNullParameter(field, "field");
        if (C12057w.access$isJvmFieldPropertyInCompanionObject(this.$this_computeCallerForAccessor.getProperty().getDescriptor()) || !Modifier.isStatic(field.getModifiers())) {
            if (this.$isGetter) {
                return this.$this_computeCallerForAccessor.isBound() ? new AbstractC11273e.f.a(field, C12057w.getBoundReceiver(this.$this_computeCallerForAccessor)) : new AbstractC11273e.f.c(field);
            }
            return this.$this_computeCallerForAccessor.isBound() ? new AbstractC11273e.g.a(field, this.$isNotNullProperty$2.invoke2(), C12057w.getBoundReceiver(this.$this_computeCallerForAccessor)) : new AbstractC11273e.g.c(field, this.$isNotNullProperty$2.invoke2());
        }
        if (!this.$isJvmStaticProperty$1.invoke2()) {
            return this.$isGetter ? new AbstractC11273e.f.e(field) : new AbstractC11273e.g.e(field, this.$isNotNullProperty$2.invoke2());
        }
        if (this.$isGetter) {
            return this.$this_computeCallerForAccessor.isBound() ? new AbstractC11273e.f.b(field) : new AbstractC11273e.f.d(field);
        }
        return this.$this_computeCallerForAccessor.isBound() ? new AbstractC11273e.g.b(field, this.$isNotNullProperty$2.invoke2()) : new AbstractC11273e.g.d(field, this.$isNotNullProperty$2.invoke2());
    }
}
