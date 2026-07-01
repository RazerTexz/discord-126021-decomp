package d0.e0.p.d;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.q0;
import java.util.List;

/* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f3197b = new e0();
    public static final d0.e0.p.d.m0.j.c a = d0.e0.p.d.m0.j.c.f3439b;

    public final void a(StringBuilder sb, q0 q0Var) {
        if (q0Var != null) {
            d0.e0.p.d.m0.n.c0 type = q0Var.getType();
            d0.z.d.m.checkNotNullExpressionValue(type, "receiver.type");
            sb.append(renderType(type));
            sb.append(".");
        }
    }

    public final void b(StringBuilder sb, d0.e0.p.d.m0.c.a aVar) {
        q0 instanceReceiverParameter = j0.getInstanceReceiverParameter(aVar);
        q0 extensionReceiverParameter = aVar.getExtensionReceiverParameter();
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

    public final String renderFunction(d0.e0.p.d.m0.c.x xVar) {
        d0.z.d.m.checkNotNullParameter(xVar, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        e0 e0Var = f3197b;
        e0Var.b(sb, xVar);
        d0.e0.p.d.m0.j.c cVar = a;
        d0.e0.p.d.m0.g.e name = xVar.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(cVar.renderName(name, true));
        List<c1> valueParameters = xVar.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
        d0.t.u.joinTo$default(valueParameters, sb, ", ", "(", ")", 0, null, e0$a.j, 48, null);
        sb.append(": ");
        d0.e0.p.d.m0.n.c0 returnType = xVar.getReturnType();
        d0.z.d.m.checkNotNull(returnType);
        d0.z.d.m.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        sb.append(e0Var.renderType(returnType));
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderLambda(d0.e0.p.d.m0.c.x xVar) {
        d0.z.d.m.checkNotNullParameter(xVar, "invoke");
        StringBuilder sb = new StringBuilder();
        e0 e0Var = f3197b;
        e0Var.b(sb, xVar);
        List<c1> valueParameters = xVar.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "invoke.valueParameters");
        d0.t.u.joinTo$default(valueParameters, sb, ", ", "(", ")", 0, null, e0$b.j, 48, null);
        sb.append(" -> ");
        d0.e0.p.d.m0.n.c0 returnType = xVar.getReturnType();
        d0.z.d.m.checkNotNull(returnType);
        d0.z.d.m.checkNotNullExpressionValue(returnType, "invoke.returnType!!");
        sb.append(e0Var.renderType(returnType));
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderParameter(o oVar) {
        String strRenderFunction;
        d0.z.d.m.checkNotNullParameter(oVar, "parameter");
        StringBuilder sb = new StringBuilder();
        int iOrdinal = oVar.getKind().ordinal();
        if (iOrdinal == 0) {
            sb.append("instance parameter");
        } else if (iOrdinal == 1) {
            sb.append("extension receiver parameter");
        } else if (iOrdinal == 2) {
            StringBuilder sbU = b.d.b.a.a.U("parameter #");
            sbU.append(oVar.getIndex());
            sbU.append(' ');
            sbU.append(oVar.getName());
            sb.append(sbU.toString());
        }
        sb.append(" of ");
        e0 e0Var = f3197b;
        d0.e0.p.d.m0.c.b descriptor = oVar.getCallable().getDescriptor();
        if (descriptor instanceof n0) {
            strRenderFunction = e0Var.renderProperty((n0) descriptor);
        } else {
            if (!(descriptor instanceof d0.e0.p.d.m0.c.x)) {
                throw new IllegalStateException(("Illegal callable: " + descriptor).toString());
            }
            strRenderFunction = e0Var.renderFunction((d0.e0.p.d.m0.c.x) descriptor);
        }
        sb.append(strRenderFunction);
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderProperty(n0 n0Var) {
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(n0Var.isVar() ? "var " : "val ");
        e0 e0Var = f3197b;
        e0Var.b(sb, n0Var);
        d0.e0.p.d.m0.j.c cVar = a;
        d0.e0.p.d.m0.g.e name = n0Var.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(cVar.renderName(name, true));
        sb.append(": ");
        d0.e0.p.d.m0.n.c0 type = n0Var.getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "descriptor.type");
        sb.append(e0Var.renderType(type));
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderType(d0.e0.p.d.m0.n.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        return a.renderType(c0Var);
    }
}
