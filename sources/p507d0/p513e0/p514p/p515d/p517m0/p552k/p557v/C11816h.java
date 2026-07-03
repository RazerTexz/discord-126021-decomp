package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.EnumC11289i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.h */
/* JADX INFO: compiled from: ConstantValueFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11816h {

    /* JADX INFO: renamed from: a */
    public static final C11816h f24439a = new C11816h();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.h$a */
    /* JADX INFO: compiled from: ConstantValueFactory.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11325c0, AbstractC11913c0> {
        public final /* synthetic */ AbstractC11913c0 $type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC11913c0 abstractC11913c0) {
            super(1);
            this.$type = abstractC11913c0;
        }

        @Override // kotlin.jvm.functions.Function1
        public final AbstractC11913c0 invoke(InterfaceC11325c0 interfaceC11325c0) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "it");
            return this.$type;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.h$b */
    /* JADX INFO: compiled from: ConstantValueFactory.kt */
    public static final class b extends AbstractC12240o implements Function1<InterfaceC11325c0, AbstractC11913c0> {
        public final /* synthetic */ EnumC11289i $componentType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EnumC11289i enumC11289i) {
            super(1);
            this.$componentType = enumC11289i;
        }

        @Override // kotlin.jvm.functions.Function1
        public final AbstractC11913c0 invoke(InterfaceC11325c0 interfaceC11325c0) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "module");
            AbstractC11934j0 primitiveArrayKotlinType = interfaceC11325c0.getBuiltIns().getPrimitiveArrayKotlinType(this.$componentType);
            C12238m.checkNotNullExpressionValue(primitiveArrayKotlinType, "module.builtIns.getPrimitiveArrayKotlinType(componentType)");
            return primitiveArrayKotlinType;
        }
    }

    /* JADX INFO: renamed from: a */
    public final C11809b m9942a(List<?> list, EnumC11289i enumC11289i) {
        List list2 = C12163u.toList(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            AbstractC11815g<?> abstractC11815gCreateConstantValue = createConstantValue(it.next());
            if (abstractC11815gCreateConstantValue != null) {
                arrayList.add(abstractC11815gCreateConstantValue);
            }
        }
        return new C11809b(arrayList, new b(enumC11289i));
    }

    public final C11809b createArrayValue(List<? extends AbstractC11815g<?>> list, AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(list, "value");
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
        return new C11809b(list, new a(abstractC11913c0));
    }

    public final AbstractC11815g<?> createConstantValue(Object obj) {
        if (obj instanceof Byte) {
            return new C11812d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new C11830v(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new C11821m(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new C11827s(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new C11813e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new C11820l(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new C11817i(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new C11811c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new C11831w((String) obj);
        }
        if (obj instanceof byte[]) {
            return m9942a(C12141k.toList((byte[]) obj), EnumC11289i.BYTE);
        }
        if (obj instanceof short[]) {
            return m9942a(C12141k.toList((short[]) obj), EnumC11289i.SHORT);
        }
        if (obj instanceof int[]) {
            return m9942a(C12141k.toList((int[]) obj), EnumC11289i.INT);
        }
        if (obj instanceof long[]) {
            return m9942a(C12141k.toList((long[]) obj), EnumC11289i.LONG);
        }
        if (obj instanceof char[]) {
            return m9942a(C12141k.toList((char[]) obj), EnumC11289i.CHAR);
        }
        if (obj instanceof float[]) {
            return m9942a(C12141k.toList((float[]) obj), EnumC11289i.FLOAT);
        }
        if (obj instanceof double[]) {
            return m9942a(C12141k.toList((double[]) obj), EnumC11289i.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return m9942a(C12141k.toList((boolean[]) obj), EnumC11289i.BOOLEAN);
        }
        if (obj == null) {
            return new C11828t();
        }
        return null;
    }
}
