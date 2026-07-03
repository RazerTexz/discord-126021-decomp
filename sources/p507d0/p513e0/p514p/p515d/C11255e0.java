package p507d0.p513e0.p514p.p515d;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.e0 */
/* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11255e0 {

    /* JADX INFO: renamed from: b */
    public static final C11255e0 f22349b = new C11255e0();

    /* JADX INFO: renamed from: a */
    public static final AbstractC11746c f22348a = AbstractC11746c.f24226b;

    /* JADX INFO: renamed from: d0.e0.p.d.e0$a */
    /* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11326c1, CharSequence> {

        /* JADX INFO: renamed from: j */
        public static final a f22350j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(InterfaceC11326c1 interfaceC11326c1) {
            C11255e0 c11255e0 = C11255e0.f22349b;
            C12238m.checkNotNullExpressionValue(interfaceC11326c1, "it");
            AbstractC11913c0 type = interfaceC11326c1.getType();
            C12238m.checkNotNullExpressionValue(type, "it.type");
            return c11255e0.renderType(type);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.e0$b */
    /* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
    public static final class b extends AbstractC12240o implements Function1<InterfaceC11326c1, CharSequence> {

        /* JADX INFO: renamed from: j */
        public static final b f22351j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(InterfaceC11326c1 interfaceC11326c1) {
            C11255e0 c11255e0 = C11255e0.f22349b;
            C12238m.checkNotNullExpressionValue(interfaceC11326c1, "it");
            AbstractC11913c0 type = interfaceC11326c1.getType();
            C12238m.checkNotNullExpressionValue(type, "it.type");
            return c11255e0.renderType(type);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m9334a(StringBuilder sb, InterfaceC11459q0 interfaceC11459q0) {
        if (interfaceC11459q0 != null) {
            AbstractC11913c0 type = interfaceC11459q0.getType();
            C12238m.checkNotNullExpressionValue(type, "receiver.type");
            sb.append(renderType(type));
            sb.append(".");
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m9335b(StringBuilder sb, InterfaceC11318a interfaceC11318a) {
        InterfaceC11459q0 instanceReceiverParameter = C11265j0.getInstanceReceiverParameter(interfaceC11318a);
        InterfaceC11459q0 extensionReceiverParameter = interfaceC11318a.getExtensionReceiverParameter();
        m9334a(sb, instanceReceiverParameter);
        boolean z2 = (instanceReceiverParameter == null || extensionReceiverParameter == null) ? false : true;
        if (z2) {
            sb.append("(");
        }
        m9334a(sb, extensionReceiverParameter);
        if (z2) {
            sb.append(")");
        }
    }

    public final String renderFunction(InterfaceC11472x interfaceC11472x) throws IOException {
        C12238m.checkNotNullParameter(interfaceC11472x, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        C11255e0 c11255e0 = f22349b;
        c11255e0.m9335b(sb, interfaceC11472x);
        AbstractC11746c abstractC11746c = f22348a;
        C11716e name = interfaceC11472x.getName();
        C12238m.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(abstractC11746c.renderName(name, true));
        List<InterfaceC11326c1> valueParameters = interfaceC11472x.getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
        C12163u.joinTo(valueParameters, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : a.f22350j);
        sb.append(": ");
        AbstractC11913c0 returnType = interfaceC11472x.getReturnType();
        C12238m.checkNotNull(returnType);
        C12238m.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        sb.append(c11255e0.renderType(returnType));
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderLambda(InterfaceC11472x interfaceC11472x) throws IOException {
        C12238m.checkNotNullParameter(interfaceC11472x, "invoke");
        StringBuilder sb = new StringBuilder();
        C11255e0 c11255e0 = f22349b;
        c11255e0.m9335b(sb, interfaceC11472x);
        List<InterfaceC11326c1> valueParameters = interfaceC11472x.getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters, "invoke.valueParameters");
        C12163u.joinTo(valueParameters, sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : b.f22351j);
        sb.append(" -> ");
        AbstractC11913c0 returnType = interfaceC11472x.getReturnType();
        C12238m.checkNotNull(returnType);
        C12238m.checkNotNullExpressionValue(returnType, "invoke.returnType!!");
        sb.append(c11255e0.renderType(returnType));
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderParameter(C12049o c12049o) throws IOException {
        String strRenderFunction;
        C12238m.checkNotNullParameter(c12049o, "parameter");
        StringBuilder sb = new StringBuilder();
        int iOrdinal = c12049o.getKind().ordinal();
        if (iOrdinal == 0) {
            sb.append("instance parameter");
        } else if (iOrdinal == 1) {
            sb.append("extension receiver parameter");
        } else if (iOrdinal == 2) {
            StringBuilder sbM833U = C1643a.m833U("parameter #");
            sbM833U.append(c12049o.getIndex());
            sbM833U.append(' ');
            sbM833U.append(c12049o.getName());
            sb.append(sbM833U.toString());
        }
        sb.append(" of ");
        C11255e0 c11255e0 = f22349b;
        InterfaceC11321b descriptor = c12049o.getCallable().getDescriptor();
        if (descriptor instanceof InterfaceC11453n0) {
            strRenderFunction = c11255e0.renderProperty((InterfaceC11453n0) descriptor);
        } else {
            if (!(descriptor instanceof InterfaceC11472x)) {
                throw new IllegalStateException(("Illegal callable: " + descriptor).toString());
            }
            strRenderFunction = c11255e0.renderFunction((InterfaceC11472x) descriptor);
        }
        sb.append(strRenderFunction);
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderProperty(InterfaceC11453n0 interfaceC11453n0) {
        C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(interfaceC11453n0.isVar() ? "var " : "val ");
        C11255e0 c11255e0 = f22349b;
        c11255e0.m9335b(sb, interfaceC11453n0);
        AbstractC11746c abstractC11746c = f22348a;
        C11716e name = interfaceC11453n0.getName();
        C12238m.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(abstractC11746c.renderName(name, true));
        sb.append(": ");
        AbstractC11913c0 type = interfaceC11453n0.getType();
        C12238m.checkNotNullExpressionValue(type, "descriptor.type");
        sb.append(c11255e0.renderType(type));
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String renderType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
        return f22348a.renderType(abstractC11913c0);
    }
}
