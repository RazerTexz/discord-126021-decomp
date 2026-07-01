package d0.e0.p.d;

import d0.e0.p.d.l0.e$f$a;
import d0.e0.p.d.l0.e$f$b;
import d0.e0.p.d.l0.e$f$c;
import d0.e0.p.d.l0.e$f$d;
import d0.e0.p.d.l0.e$f$e;
import d0.e0.p.d.l0.e$g$a;
import d0.e0.p.d.l0.e$g$b;
import d0.e0.p.d.l0.e$g$c;
import d0.e0.p.d.l0.e$g$d;
import d0.e0.p.d.l0.e$g$e;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends d0.z.d.o implements Function1<Field, d0.e0.p.d.l0.e<? extends Field>> {
    public final /* synthetic */ boolean $isGetter;
    public final /* synthetic */ t $isJvmStaticProperty$1;
    public final /* synthetic */ u $isNotNullProperty$2;
    public final /* synthetic */ s$a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(s$a s_a, boolean z2, u uVar, t tVar) {
        super(1);
        this.$this_computeCallerForAccessor = s_a;
        this.$isGetter = z2;
        this.$isNotNullProperty$2 = uVar;
        this.$isJvmStaticProperty$1 = tVar;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.l0.e<Field> invoke2(Field field) {
        d0.z.d.m.checkNotNullParameter(field, "field");
        if (w.access$isJvmFieldPropertyInCompanionObject(this.$this_computeCallerForAccessor.getProperty().getDescriptor()) || !Modifier.isStatic(field.getModifiers())) {
            if (this.$isGetter) {
                return this.$this_computeCallerForAccessor.isBound() ? new e$f$a(field, w.getBoundReceiver(this.$this_computeCallerForAccessor)) : new e$f$c(field);
            }
            return this.$this_computeCallerForAccessor.isBound() ? new e$g$a(field, this.$isNotNullProperty$2.invoke2(), w.getBoundReceiver(this.$this_computeCallerForAccessor)) : new e$g$c(field, this.$isNotNullProperty$2.invoke2());
        }
        if (!this.$isJvmStaticProperty$1.invoke2()) {
            return this.$isGetter ? new e$f$e(field) : new e$g$e(field, this.$isNotNullProperty$2.invoke2());
        }
        if (this.$isGetter) {
            return this.$this_computeCallerForAccessor.isBound() ? new e$f$b(field) : new e$f$d(field);
        }
        return this.$this_computeCallerForAccessor.isBound() ? new e$g$b(field, this.$isNotNullProperty$2.invoke2()) : new e$g$d(field, this.$isNotNullProperty$2.invoke2());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.l0.e<? extends Field> invoke(Field field) {
        return invoke2(field);
    }
}
