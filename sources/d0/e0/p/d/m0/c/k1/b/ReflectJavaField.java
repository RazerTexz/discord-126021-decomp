package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.c.k1.b.ReflectJavaType;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.p, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaField.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaField extends ReflectJavaMember2 implements d0.e0.p.d.m0.e.a.k0.n {
    public final Field a;

    public ReflectJavaField(Field field) {
        Intrinsics3.checkNotNullParameter(field, "member");
        this.a = field;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.n
    public boolean getHasConstantNotNullInitializer() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaMember2
    public Field getMember() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.n
    public boolean isEnumEntry() {
        return getMember().isEnumConstant();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.n
    public ReflectJavaType getType() {
        ReflectJavaType.a aVar = ReflectJavaType.a;
        Type genericType = getMember().getGenericType();
        Intrinsics3.checkNotNullExpressionValue(genericType, "member.genericType");
        return aVar.create(genericType);
    }
}
