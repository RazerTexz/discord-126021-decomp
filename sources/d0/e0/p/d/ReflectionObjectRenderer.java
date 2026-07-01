package d0.e0.p.d;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.e0, reason: use source file name */
/* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectionObjectRenderer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReflectionObjectRenderer f3197b = new ReflectionObjectRenderer();
    public static final DescriptorRenderer2 a = DescriptorRenderer2.f3439b;

    /* JADX INFO: renamed from: d0.e0.p.d.e0$a */
    /* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
    public static final class a extends Lambda implements Function1<ValueParameterDescriptor, CharSequence> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor) {
            ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.f3197b;
            Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "it");
            KotlinType type = valueParameterDescriptor.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "it.type");
            return reflectionObjectRenderer.renderType(type);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e0$b */
    /* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
    public static final class b extends Lambda implements Function1<ValueParameterDescriptor, CharSequence> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor) {
            ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.f3197b;
            Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "it");
            KotlinType type = valueParameterDescriptor.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "it.type");
            return reflectionObjectRenderer.renderType(type);
        }
    }

    public final void a(StringBuilder sb, ReceiverParameterDescriptor receiverParameterDescriptor) {
        if (receiverParameterDescriptor != null) {
            KotlinType type = receiverParameterDescriptor.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "receiver.type");
            sb.append(renderType(type));
            sb.append(".");
        }
    }

    public final void b(StringBuilder sb, CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor instanceReceiverParameter = util2.getInstanceReceiverParameter(callableDescriptor);
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        a(sb, instanceReceiverParameter);
        boolean z2 = (instanceReceiverParameter == null || extensionReceiverParameter == null) ? false : true;
        if (z2) {
            sb.append("(");
        }
        a(sb, extensionReceiverParameter);
        if (z2) {
            sb.append(")");
        }
    }

    public final String renderFunction(FunctionDescriptor functionDescriptor) throws IOException {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        ReflectionObjectRenderer reflectionObjectRenderer = f3197b;
        reflectionObjectRenderer.b(sb, functionDescriptor);
        DescriptorRenderer2 descriptorRenderer2 = a;
        Name name = functionDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(descriptorRenderer2.renderName(name, true));
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
        _Collections.joinTo(valueParameters, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : a.j);
        sb.append(": ");
        KotlinType returnType = functionDescriptor.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        Intrinsics3.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderLambda(FunctionDescriptor functionDescriptor) throws IOException {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "invoke");
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = f3197b;
        reflectionObjectRenderer.b(sb, functionDescriptor);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "invoke.valueParameters");
        _Collections.joinTo(valueParameters, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : b.j);
        sb.append(" -> ");
        KotlinType returnType = functionDescriptor.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        Intrinsics3.checkNotNullExpressionValue(returnType, "invoke.returnType!!");
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderParameter(KParameterImpl kParameterImpl) throws IOException {
        String strRenderFunction;
        Intrinsics3.checkNotNullParameter(kParameterImpl, "parameter");
        StringBuilder sb = new StringBuilder();
        int iOrdinal = kParameterImpl.getKind().ordinal();
        if (iOrdinal == 0) {
            sb.append("instance parameter");
        } else if (iOrdinal == 1) {
            sb.append("extension receiver parameter");
        } else if (iOrdinal == 2) {
            StringBuilder sbU = outline.U("parameter #");
            sbU.append(kParameterImpl.getIndex());
            sbU.append(' ');
            sbU.append(kParameterImpl.getName());
            sb.append(sbU.toString());
        }
        sb.append(" of ");
        ReflectionObjectRenderer reflectionObjectRenderer = f3197b;
        CallableMemberDescriptor descriptor = kParameterImpl.getCallable().getDescriptor();
        if (descriptor instanceof PropertyDescriptor) {
            strRenderFunction = reflectionObjectRenderer.renderProperty((PropertyDescriptor) descriptor);
        } else {
            if (!(descriptor instanceof FunctionDescriptor)) {
                throw new IllegalStateException(("Illegal callable: " + descriptor).toString());
            }
            strRenderFunction = reflectionObjectRenderer.renderFunction((FunctionDescriptor) descriptor);
        }
        sb.append(strRenderFunction);
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderProperty(PropertyDescriptor propertyDescriptor) {
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(propertyDescriptor.isVar() ? "var " : "val ");
        ReflectionObjectRenderer reflectionObjectRenderer = f3197b;
        reflectionObjectRenderer.b(sb, propertyDescriptor);
        DescriptorRenderer2 descriptorRenderer2 = a;
        Name name = propertyDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(descriptorRenderer2.renderName(name, true));
        sb.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "descriptor.type");
        sb.append(reflectionObjectRenderer.renderType(type));
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        return a.renderType(kotlinType);
    }
}
