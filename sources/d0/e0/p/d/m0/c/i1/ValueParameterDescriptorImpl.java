package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.LazyJVM;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.VariableDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.l0, reason: use source file name */
/* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ValueParameterDescriptorImpl extends VariableDescriptorImpl implements ValueParameterDescriptor {
    public static final a o = new a(null);
    public final int p;
    public final boolean q;
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f3268s;
    public final KotlinType t;
    public final ValueParameterDescriptor u;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.l0$a */
    /* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations4 annotations4, Name name, KotlinType kotlinType, boolean z2, boolean z3, boolean z4, KotlinType kotlinType2, SourceElement sourceElement, Function0<? extends List<? extends VariableDescriptor>> function0) {
            Intrinsics3.checkNotNullParameter(callableDescriptor, "containingDeclaration");
            Intrinsics3.checkNotNullParameter(annotations4, "annotations");
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(kotlinType, "outType");
            Intrinsics3.checkNotNullParameter(sourceElement, "source");
            return function0 == null ? new ValueParameterDescriptorImpl(callableDescriptor, valueParameterDescriptor, i, annotations4, name, kotlinType, z2, z3, z4, kotlinType2, sourceElement) : new b(callableDescriptor, valueParameterDescriptor, i, annotations4, name, kotlinType, z2, z3, z4, kotlinType2, sourceElement, function0);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.l0$b */
    /* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
    public static final class b extends ValueParameterDescriptorImpl {
        public final Lazy v;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.l0$b$a */
        /* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
        public static final class a extends Lambda implements Function0<List<? extends VariableDescriptor>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends VariableDescriptor> invoke() {
                return b.this.getDestructuringVariables();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations4 annotations4, Name name, KotlinType kotlinType, boolean z2, boolean z3, boolean z4, KotlinType kotlinType2, SourceElement sourceElement, Function0<? extends List<? extends VariableDescriptor>> function0) {
            super(callableDescriptor, valueParameterDescriptor, i, annotations4, name, kotlinType, z2, z3, z4, kotlinType2, sourceElement);
            Intrinsics3.checkNotNullParameter(callableDescriptor, "containingDeclaration");
            Intrinsics3.checkNotNullParameter(annotations4, "annotations");
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(kotlinType, "outType");
            Intrinsics3.checkNotNullParameter(sourceElement, "source");
            Intrinsics3.checkNotNullParameter(function0, "destructuringVariables");
            this.v = LazyJVM.lazy(function0);
        }

        @Override // d0.e0.p.d.m0.c.i1.ValueParameterDescriptorImpl, d0.e0.p.d.m0.c.ValueParameterDescriptor
        public ValueParameterDescriptor copy(CallableDescriptor callableDescriptor, Name name, int i) {
            Intrinsics3.checkNotNullParameter(callableDescriptor, "newOwner");
            Intrinsics3.checkNotNullParameter(name, "newName");
            Annotations4 annotations = getAnnotations();
            Intrinsics3.checkNotNullExpressionValue(annotations, "annotations");
            KotlinType type = getType();
            Intrinsics3.checkNotNullExpressionValue(type, "type");
            boolean zDeclaresDefaultValue = declaresDefaultValue();
            boolean zIsCrossinline = isCrossinline();
            boolean zIsNoinline = isNoinline();
            KotlinType varargElementType = getVarargElementType();
            SourceElement sourceElement = SourceElement.a;
            Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            return new b(callableDescriptor, null, i, annotations, name, type, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, varargElementType, sourceElement, new a());
        }

        public final List<VariableDescriptor> getDestructuringVariables() {
            return (List) this.v.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueParameterDescriptorImpl(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations4 annotations4, Name name, KotlinType kotlinType, boolean z2, boolean z3, boolean z4, KotlinType kotlinType2, SourceElement sourceElement) {
        super(callableDescriptor, annotations4, name, kotlinType, sourceElement);
        Intrinsics3.checkNotNullParameter(callableDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(kotlinType, "outType");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        this.p = i;
        this.q = z2;
        this.r = z3;
        this.f3268s = z4;
        this.t = kotlinType2;
        this.u = valueParameterDescriptor == null ? this : valueParameterDescriptor;
    }

    public static final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations4 annotations4, Name name, KotlinType kotlinType, boolean z2, boolean z3, boolean z4, KotlinType kotlinType2, SourceElement sourceElement, Function0<? extends List<? extends VariableDescriptor>> function0) {
        return o.createWithDestructuringDeclarations(callableDescriptor, valueParameterDescriptor, i, annotations4, name, kotlinType, z2, z3, z4, kotlinType2, sourceElement, function0);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics3.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitValueParameterDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.ValueParameterDescriptor
    public ValueParameterDescriptor copy(CallableDescriptor callableDescriptor, Name name, int i) {
        Intrinsics3.checkNotNullParameter(callableDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(name, "newName");
        Annotations4 annotations = getAnnotations();
        Intrinsics3.checkNotNullExpressionValue(annotations, "annotations");
        KotlinType type = getType();
        Intrinsics3.checkNotNullExpressionValue(type, "type");
        boolean zDeclaresDefaultValue = declaresDefaultValue();
        boolean zIsCrossinline = isCrossinline();
        boolean zIsNoinline = isNoinline();
        KotlinType varargElementType = getVarargElementType();
        SourceElement sourceElement = SourceElement.a;
        Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return new ValueParameterDescriptorImpl(callableDescriptor, null, i, annotations, name, type, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, varargElementType, sourceElement);
    }

    @Override // d0.e0.p.d.m0.c.ValueParameterDescriptor
    public boolean declaresDefaultValue() {
        return this.q && ((CallableMemberDescriptor) getContainingDeclaration()).getKind().isReal();
    }

    @Override // d0.e0.p.d.m0.c.VariableDescriptor
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.v.g getCompileTimeInitializer() {
        return (d0.e0.p.d.m0.k.v.g) m85getCompileTimeInitializer();
    }

    /* JADX INFO: renamed from: getCompileTimeInitializer, reason: collision with other method in class */
    public Void m85getCompileTimeInitializer() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.ValueParameterDescriptor
    public int getIndex() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        Collection<? extends CallableDescriptor> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "containingDeclaration.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(overriddenDescriptors, 10));
        Iterator<T> it = overriddenDescriptors.iterator();
        while (it.hasNext()) {
            arrayList.add(((CallableDescriptor) it.next()).getValueParameters().get(getIndex()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.ValueParameterDescriptor
    public KotlinType getVarargElementType() {
        return this.t;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility, d0.e0.p.d.m0.c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.f;
        Intrinsics3.checkNotNullExpressionValue(descriptorVisibility2, "LOCAL");
        return descriptorVisibility2;
    }

    @Override // d0.e0.p.d.m0.c.ValueParameterDescriptor
    public boolean isCrossinline() {
        return this.r;
    }

    @Override // d0.e0.p.d.m0.c.ValueParameterDescriptor
    public boolean isNoinline() {
        return this.f3268s;
    }

    @Override // d0.e0.p.d.m0.c.VariableDescriptor
    public boolean isVar() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public CallableDescriptor getContainingDeclaration() {
        return (CallableDescriptor) super.getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.Substitutable
    public ValueParameterDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        Intrinsics3.checkNotNullParameter(typeSubstitutor2, "substitutor");
        if (typeSubstitutor2.isEmpty()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public ValueParameterDescriptor getOriginal() {
        ValueParameterDescriptor valueParameterDescriptor = this.u;
        return valueParameterDescriptor == this ? this : valueParameterDescriptor.getOriginal();
    }
}
