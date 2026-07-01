package d0.e0.p;

import d0.Function3;
import d0.e0.p.d.EmptyContainerForLocal;
import d0.e0.p.d.KFunctionImpl;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.f.a0.b.JvmMetadataVersion;
import d0.e0.p.d.m0.f.a0.b.JvmNameResolver;
import d0.e0.p.d.m0.f.a0.b.JvmProtoBufUtil;
import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.f.t;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.l.b.MemberDeserializer;
import d0.e0.p.d.util2;
import d0.z.d.FunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.io.IOException;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;

/* JADX INFO: renamed from: d0.e0.p.c, reason: use source file name */
/* JADX INFO: compiled from: reflectLambda.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class reflectLambda {

    /* JADX INFO: renamed from: d0.e0.p.c$a */
    /* JADX INFO: compiled from: reflectLambda.kt */
    public static final /* synthetic */ class a extends FunctionReference implements Function2<MemberDeserializer, i, SimpleFunctionDescriptor> {
        public static final a j = new a();

        public a() {
            super(2);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "loadFunction";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(MemberDeserializer.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function2
        public final SimpleFunctionDescriptor invoke(MemberDeserializer memberDeserializer, i iVar) {
            Intrinsics3.checkNotNullParameter(memberDeserializer, "p1");
            Intrinsics3.checkNotNullParameter(iVar, "p2");
            return memberDeserializer.loadFunction(iVar);
        }
    }

    public static final <R> KFunction<R> reflect(Function3<? extends R> function3) throws IOException {
        Intrinsics3.checkNotNullParameter(function3, "$this$reflect");
        Metadata metadata = (Metadata) function3.getClass().getAnnotation(Metadata.class);
        if (metadata != null) {
            String[] strArrD1 = metadata.d1();
            if (strArrD1.length == 0) {
                strArrD1 = null;
            }
            if (strArrD1 != null) {
                Tuples2<JvmNameResolver, i> functionDataFrom = JvmProtoBufUtil.readFunctionDataFrom(strArrD1, metadata.d2());
                JvmNameResolver jvmNameResolverComponent1 = functionDataFrom.component1();
                i iVarComponent2 = functionDataFrom.component2();
                JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(metadata.mv(), (metadata.xi() & 8) != 0);
                Class<?> cls = function3.getClass();
                t typeTable = iVarComponent2.getTypeTable();
                Intrinsics3.checkNotNullExpressionValue(typeTable, "proto.typeTable");
                SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) util2.deserializeToDescriptor(cls, iVarComponent2, jvmNameResolverComponent1, new TypeTable(typeTable), jvmMetadataVersion, a.j);
                if (simpleFunctionDescriptor != null) {
                    return new KFunctionImpl(EmptyContainerForLocal.m, simpleFunctionDescriptor);
                }
            }
        }
        return null;
    }
}
