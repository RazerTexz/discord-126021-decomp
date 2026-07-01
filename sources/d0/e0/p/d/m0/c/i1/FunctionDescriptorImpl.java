package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.VariableDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.g1.Annotations5;
import d0.e0.p.d.m0.c.i1.ValueParameterDescriptorImpl;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.p.ExtensionReceiver;
import d0.e0.p.d.m0.n.DescriptorSubstitutor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeSubstitution5;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.p.SmartList;
import d0.t._Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.q, reason: use source file name */
/* JADX INFO: compiled from: FunctionDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FunctionDescriptorImpl extends DeclarationDescriptorNonRootImpl implements FunctionDescriptor {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public Collection<? extends FunctionDescriptor> G;
    public volatile Function0<Collection<FunctionDescriptor>> H;
    public final FunctionDescriptor I;
    public final CallableMemberDescriptor.a J;
    public FunctionDescriptor K;
    public Map<CallableDescriptor.a<?>, Object> L;
    public List<TypeParameterDescriptor> n;
    public List<ValueParameterDescriptor> o;
    public KotlinType p;
    public ReceiverParameterDescriptor q;
    public ReceiverParameterDescriptor r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Modality f3271s;
    public DescriptorVisibility2 t;
    public boolean u;
    public boolean v;
    public boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3272x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3273y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3274z;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.q$a */
    /* JADX INFO: compiled from: FunctionDescriptorImpl.java */
    public class a implements Function0<Collection<FunctionDescriptor>> {
        public final /* synthetic */ TypeSubstitutor2 j;

        public a(TypeSubstitutor2 typeSubstitutor2) {
            this.j = typeSubstitutor2;
        }

        @Override // kotlin.jvm.functions.Function0
        public Collection<FunctionDescriptor> invoke() {
            SmartList smartList = new SmartList();
            Iterator<? extends FunctionDescriptor> it = FunctionDescriptorImpl.this.getOverriddenDescriptors().iterator();
            while (it.hasNext()) {
                smartList.add(it.next().substitute(this.j));
            }
            return smartList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.q$b */
    /* JADX INFO: compiled from: FunctionDescriptorImpl.java */
    public static class b implements Function0<List<VariableDescriptor>> {
        public final /* synthetic */ List j;

        public b(List list) {
            this.j = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public List<VariableDescriptor> invoke() {
            return this.j;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.q$c */
    /* JADX INFO: compiled from: FunctionDescriptorImpl.java */
    public class c implements FunctionDescriptor.a<FunctionDescriptor> {
        public TypeSubstitution5 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DeclarationDescriptor f3275b;
        public Modality c;
        public DescriptorVisibility2 d;
        public FunctionDescriptor e;
        public CallableMemberDescriptor.a f;
        public List<ValueParameterDescriptor> g;
        public ReceiverParameterDescriptor h;
        public ReceiverParameterDescriptor i;
        public KotlinType j;
        public Name k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public List<TypeParameterDescriptor> q;
        public Annotations4 r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f3276s;
        public Map<CallableDescriptor.a<?>, Object> t;
        public Boolean u;
        public boolean v;
        public final /* synthetic */ FunctionDescriptorImpl w;

        public c(FunctionDescriptorImpl functionDescriptorImpl, TypeSubstitution5 typeSubstitution5, DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, List<ValueParameterDescriptor> list, ReceiverParameterDescriptor receiverParameterDescriptor, KotlinType kotlinType, Name name) {
            if (typeSubstitution5 == null) {
                a(0);
                throw null;
            }
            if (declarationDescriptor == null) {
                a(1);
                throw null;
            }
            if (modality == null) {
                a(2);
                throw null;
            }
            if (descriptorVisibility2 == null) {
                a(3);
                throw null;
            }
            if (aVar == null) {
                a(4);
                throw null;
            }
            if (list == null) {
                a(5);
                throw null;
            }
            if (kotlinType == null) {
                a(6);
                throw null;
            }
            this.w = functionDescriptorImpl;
            this.e = null;
            this.i = functionDescriptorImpl.r;
            this.l = true;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = functionDescriptorImpl.isHiddenToOvercomeSignatureClash();
            this.q = null;
            this.r = null;
            this.f3276s = functionDescriptorImpl.isHiddenForResolutionEverywhereBesideSupercalls();
            this.t = new LinkedHashMap();
            this.u = null;
            this.v = false;
            this.a = typeSubstitution5;
            this.f3275b = declarationDescriptor;
            this.c = modality;
            this.d = descriptorVisibility2;
            this.f = aVar;
            this.g = list;
            this.h = receiverParameterDescriptor;
            this.j = kotlinType;
            this.k = name;
        }

        public static /* synthetic */ void a(int i) {
            String str;
            int i2;
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i2 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = "owner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 18:
                case 20:
                    objArr[0] = "parameters";
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    throw new IllegalStateException(str2);
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    throw new IllegalArgumentException(str2);
            }
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public FunctionDescriptor build() {
            return this.w.c(this);
        }

        public c setHasSynthesizedParameterNames(boolean z2) {
            this.u = Boolean.valueOf(z2);
            return this;
        }

        public c setJustForTypeSubstitution(boolean z2) {
            this.v = z2;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setTypeParameters(List list) {
            return setTypeParameters((List<TypeParameterDescriptor>) list);
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setValueParameters(List list) {
            return setValueParameters((List<ValueParameterDescriptor>) list);
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setAdditionalAnnotations(Annotations4 annotations4) {
            if (annotations4 != null) {
                this.r = annotations4;
                return this;
            }
            a(32);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setCopyOverrides(boolean z2) {
            this.l = z2;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setDispatchReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.i = receiverParameterDescriptor;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setDropOriginalInContainingParts() {
            this.o = true;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setExtensionReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.h = receiverParameterDescriptor;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setHiddenForResolutionEverywhereBesideSupercalls() {
            this.f3276s = true;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setHiddenToOvercomeSignatureClash() {
            this.p = true;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setKind(CallableMemberDescriptor.a aVar) {
            if (aVar != null) {
                this.f = aVar;
                return this;
            }
            a(13);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setModality(Modality modality) {
            if (modality != null) {
                this.c = modality;
                return this;
            }
            a(9);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setName(Name name) {
            if (name != null) {
                this.k = name;
                return this;
            }
            a(16);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
            this.e = (FunctionDescriptor) callableMemberDescriptor;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setOwner(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor != null) {
                this.f3275b = declarationDescriptor;
                return this;
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setPreserveSourceElement() {
            this.n = true;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setReturnType(KotlinType kotlinType) {
            if (kotlinType != null) {
                this.j = kotlinType;
                return this;
            }
            a(22);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setSignatureChange() {
            this.m = true;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setSubstitution(TypeSubstitution5 typeSubstitution5) {
            if (typeSubstitution5 != null) {
                this.a = typeSubstitution5;
                return this;
            }
            a(34);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setTypeParameters(List<TypeParameterDescriptor> list) {
            if (list != null) {
                this.q = list;
                return this;
            }
            a(20);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setValueParameters(List<ValueParameterDescriptor> list) {
            if (list != null) {
                this.g = list;
                return this;
            }
            a(18);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.FunctionDescriptor.a
        public c setVisibility(DescriptorVisibility2 descriptorVisibility2) {
            if (descriptorVisibility2 != null) {
                this.d = descriptorVisibility2;
                return this;
            }
            a(11);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionDescriptorImpl(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Annotations4 annotations4, Name name, CallableMemberDescriptor.a aVar, SourceElement sourceElement) {
        super(declarationDescriptor, annotations4, name, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations4 == null) {
            a(1);
            throw null;
        }
        if (name == null) {
            a(2);
            throw null;
        }
        if (aVar == null) {
            a(3);
            throw null;
        }
        if (sourceElement == null) {
            a(4);
            throw null;
        }
        this.t = DescriptorVisibilities.i;
        this.u = false;
        this.v = false;
        this.w = false;
        this.f3272x = false;
        this.f3273y = false;
        this.f3274z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = null;
        this.H = null;
        this.K = null;
        this.L = null;
        this.I = functionDescriptor == null ? this : functionDescriptor;
        this.J = aVar;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i2 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = "copy";
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor functionDescriptor, List<ValueParameterDescriptor> list, TypeSubstitutor2 typeSubstitutor2) {
        if (list == null) {
            a(26);
            throw null;
        }
        if (typeSubstitutor2 != null) {
            return getSubstitutedValueParameters(functionDescriptor, list, typeSubstitutor2, false, false, null);
        }
        a(27);
        throw null;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitFunctionDescriptor(this, d);
    }

    public abstract FunctionDescriptorImpl b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement);

    public FunctionDescriptor c(c cVar) {
        ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        KotlinType kotlinTypeSubstitute;
        if (cVar == null) {
            a(23);
            throw null;
        }
        boolean[] zArr = new boolean[1];
        Annotations4 annotations4ComposeAnnotations = cVar.r != null ? Annotations5.composeAnnotations(getAnnotations(), cVar.r) : getAnnotations();
        DeclarationDescriptor declarationDescriptor = cVar.f3275b;
        FunctionDescriptor functionDescriptor = cVar.e;
        CallableMemberDescriptor.a aVar = cVar.f;
        Name name = cVar.k;
        SourceElement source = cVar.n ? (functionDescriptor != null ? functionDescriptor : getOriginal()).getSource() : SourceElement.a;
        if (source == null) {
            a(25);
            throw null;
        }
        FunctionDescriptorImpl functionDescriptorImplB = b(declarationDescriptor, functionDescriptor, aVar, name, annotations4ComposeAnnotations, source);
        List<TypeParameterDescriptor> typeParameters = cVar.q;
        if (typeParameters == null) {
            typeParameters = getTypeParameters();
        }
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor2 typeSubstitutor2SubstituteTypeParameters = DescriptorSubstitutor.substituteTypeParameters(typeParameters, cVar.a, functionDescriptorImplB, arrayList, zArr);
        if (typeSubstitutor2SubstituteTypeParameters == null) {
            return null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = cVar.h;
        if (receiverParameterDescriptor2 != null) {
            KotlinType kotlinTypeSubstitute2 = typeSubstitutor2SubstituteTypeParameters.substitute(receiverParameterDescriptor2.getType(), Variance.IN_VARIANCE);
            if (kotlinTypeSubstitute2 == null) {
                return null;
            }
            ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl2 = new ReceiverParameterDescriptorImpl(functionDescriptorImplB, new ExtensionReceiver(functionDescriptorImplB, kotlinTypeSubstitute2, cVar.h.getValue()), cVar.h.getAnnotations());
            zArr[0] = (kotlinTypeSubstitute2 != cVar.h.getType()) | zArr[0];
            receiverParameterDescriptorImpl = receiverParameterDescriptorImpl2;
        } else {
            receiverParameterDescriptorImpl = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor3 = cVar.i;
        if (receiverParameterDescriptor3 != null) {
            ReceiverParameterDescriptor receiverParameterDescriptorSubstitute = receiverParameterDescriptor3.substitute(typeSubstitutor2SubstituteTypeParameters);
            if (receiverParameterDescriptorSubstitute == null) {
                return null;
            }
            zArr[0] = zArr[0] | (receiverParameterDescriptorSubstitute != cVar.i);
            receiverParameterDescriptor = receiverParameterDescriptorSubstitute;
        } else {
            receiverParameterDescriptor = null;
        }
        List<ValueParameterDescriptor> substitutedValueParameters = getSubstitutedValueParameters(functionDescriptorImplB, cVar.g, typeSubstitutor2SubstituteTypeParameters, cVar.o, cVar.n, zArr);
        if (substitutedValueParameters == null || (kotlinTypeSubstitute = typeSubstitutor2SubstituteTypeParameters.substitute(cVar.j, Variance.OUT_VARIANCE)) == null) {
            return null;
        }
        zArr[0] = zArr[0] | (kotlinTypeSubstitute != cVar.j);
        if (!zArr[0] && cVar.v) {
            return this;
        }
        functionDescriptorImplB.initialize(receiverParameterDescriptorImpl, receiverParameterDescriptor, arrayList, substitutedValueParameters, kotlinTypeSubstitute, cVar.c, cVar.d);
        functionDescriptorImplB.setOperator(this.u);
        functionDescriptorImplB.setInfix(this.v);
        functionDescriptorImplB.setExternal(this.w);
        functionDescriptorImplB.setInline(this.f3272x);
        functionDescriptorImplB.setTailrec(this.f3273y);
        functionDescriptorImplB.setSuspend(this.D);
        functionDescriptorImplB.setExpect(this.f3274z);
        functionDescriptorImplB.setActual(this.A);
        functionDescriptorImplB.setHasStableParameterNames(this.E);
        functionDescriptorImplB.B = cVar.p;
        functionDescriptorImplB.C = cVar.f3276s;
        Boolean bool = cVar.u;
        functionDescriptorImplB.setHasSynthesizedParameterNames(bool != null ? bool.booleanValue() : this.F);
        if (!cVar.t.isEmpty() || this.L != null) {
            Map<CallableDescriptor.a<?>, Object> map = cVar.t;
            Map<CallableDescriptor.a<?>, Object> map2 = this.L;
            if (map2 != null) {
                for (Map.Entry<CallableDescriptor.a<?>, Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                functionDescriptorImplB.L = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                functionDescriptorImplB.L = map;
            }
        }
        if (cVar.m || getInitialSignatureDescriptor() != null) {
            functionDescriptorImplB.K = (getInitialSignatureDescriptor() != null ? getInitialSignatureDescriptor() : this).substitute(typeSubstitutor2SubstituteTypeParameters);
        }
        if (cVar.l && !getOriginal().getOverriddenDescriptors().isEmpty()) {
            if (cVar.a.isEmpty()) {
                Function0<Collection<FunctionDescriptor>> function0 = this.H;
                if (function0 != null) {
                    functionDescriptorImplB.H = function0;
                } else {
                    functionDescriptorImplB.setOverriddenDescriptors(getOverriddenDescriptors());
                }
            } else {
                functionDescriptorImplB.H = new a(typeSubstitutor2SubstituteTypeParameters);
            }
        }
        return functionDescriptorImplB;
    }

    public c d(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            return new c(this, typeSubstitutor2.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getExtensionReceiverParameter(), getReturnType(), null);
        }
        a(22);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.r;
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.q;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.K;
    }

    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor
    public CallableMemberDescriptor.a getKind() {
        CallableMemberDescriptor.a aVar = this.J;
        if (aVar != null) {
            return aVar;
        }
        a(19);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public Modality getModality() {
        Modality modality = this.f3271s;
        if (modality != null) {
            return modality;
        }
        a(13);
        throw null;
    }

    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Function0<Collection<FunctionDescriptor>> function0 = this.H;
        if (function0 != null) {
            this.G = function0.invoke();
            this.H = null;
        }
        Collection<? extends FunctionDescriptor> collectionEmptyList = this.G;
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections.emptyList();
        }
        if (collectionEmptyList != null) {
            return collectionEmptyList;
        }
        a(12);
        throw null;
    }

    public KotlinType getReturnType() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.n;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.a<V> aVar) {
        Map<CallableDescriptor.a<?>, Object> map = this.L;
        if (map == null) {
            return null;
        }
        return (V) map.get(aVar);
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.o;
        if (list != null) {
            return list;
        }
        a(17);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility, d0.e0.p.d.m0.c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = this.t;
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        a(14);
        throw null;
    }

    public boolean hasStableParameterNames() {
        return this.E;
    }

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.F;
    }

    public FunctionDescriptorImpl initialize(ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<ValueParameterDescriptor> list2, KotlinType kotlinType, Modality modality, DescriptorVisibility2 descriptorVisibility2) {
        if (list == null) {
            a(5);
            throw null;
        }
        if (list2 == null) {
            a(6);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            a(7);
            throw null;
        }
        this.n = _Collections.toList(list);
        this.o = _Collections.toList(list2);
        this.p = kotlinType;
        this.f3271s = modality;
        this.t = descriptorVisibility2;
        this.q = receiverParameterDescriptor;
        this.r = receiverParameterDescriptor2;
        for (int i = 0; i < list.size(); i++) {
            TypeParameterDescriptor typeParameterDescriptor = list.get(i);
            if (typeParameterDescriptor.getIndex() != i) {
                throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i);
            }
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            ValueParameterDescriptor valueParameterDescriptor = list2.get(i2);
            if (valueParameterDescriptor.getIndex() != i2 + 0) {
                throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i2);
            }
        }
        return this;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isActual() {
        return this.A;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExpect() {
        return this.f3274z;
    }

    public boolean isExternal() {
        return this.w;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.C;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.B;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isInfix() {
        if (this.v) {
            return true;
        }
        Iterator<? extends FunctionDescriptor> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.f3272x;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isOperator() {
        if (this.u) {
            return true;
        }
        Iterator<? extends FunctionDescriptor> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isSuspend() {
        return this.D;
    }

    public boolean isTailrec() {
        return this.f3273y;
    }

    public FunctionDescriptor.a<? extends FunctionDescriptor> newCopyBuilder() {
        return d(TypeSubstitutor2.a);
    }

    public <V> void putInUserDataMap(CallableDescriptor.a<V> aVar, Object obj) {
        if (this.L == null) {
            this.L = new LinkedHashMap();
        }
        this.L.put(aVar, obj);
    }

    public void setActual(boolean z2) {
        this.A = z2;
    }

    public void setExpect(boolean z2) {
        this.f3274z = z2;
    }

    public void setExternal(boolean z2) {
        this.w = z2;
    }

    public void setHasStableParameterNames(boolean z2) {
        this.E = z2;
    }

    public void setHasSynthesizedParameterNames(boolean z2) {
        this.F = z2;
    }

    public void setInfix(boolean z2) {
        this.v = z2;
    }

    public void setInline(boolean z2) {
        this.f3272x = z2;
    }

    public void setOperator(boolean z2) {
        this.u = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            a(15);
            throw null;
        }
        this.G = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((FunctionDescriptor) it.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
                this.C = true;
                return;
            }
        }
    }

    public void setReturnType(KotlinType kotlinType) {
        if (kotlinType != null) {
            this.p = kotlinType;
        } else {
            a(10);
            throw null;
        }
    }

    public void setSuspend(boolean z2) {
        this.D = z2;
    }

    public void setTailrec(boolean z2) {
        this.f3273y = z2;
    }

    public void setVisibility(DescriptorVisibility2 descriptorVisibility2) {
        if (descriptorVisibility2 != null) {
            this.t = descriptorVisibility2;
        } else {
            a(9);
            throw null;
        }
    }

    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor
    public FunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        FunctionDescriptor functionDescriptorBuild = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(descriptorVisibility2).setKind(aVar).setCopyOverrides(z2).build();
        if (functionDescriptorBuild != null) {
            return functionDescriptorBuild;
        }
        a(24);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor, d0.e0.p.d.m0.c.Substitutable
    public FunctionDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            return typeSubstitutor2.isEmpty() ? this : d(typeSubstitutor2).setOriginal((CallableMemberDescriptor) getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
        }
        a(20);
        throw null;
    }

    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor functionDescriptor, List<ValueParameterDescriptor> list, TypeSubstitutor2 typeSubstitutor2, boolean z2, boolean z3, boolean[] zArr) {
        if (list == null) {
            a(28);
            throw null;
        }
        if (typeSubstitutor2 != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (ValueParameterDescriptor valueParameterDescriptor : list) {
                KotlinType type = valueParameterDescriptor.getType();
                Variance variance = Variance.IN_VARIANCE;
                KotlinType kotlinTypeSubstitute = typeSubstitutor2.substitute(type, variance);
                KotlinType varargElementType = valueParameterDescriptor.getVarargElementType();
                KotlinType kotlinTypeSubstitute2 = varargElementType == null ? null : typeSubstitutor2.substitute(varargElementType, variance);
                if (kotlinTypeSubstitute == null) {
                    return null;
                }
                if ((kotlinTypeSubstitute != valueParameterDescriptor.getType() || varargElementType != kotlinTypeSubstitute2) && zArr != null) {
                    zArr[0] = true;
                }
                arrayList.add(ValueParameterDescriptorImpl.createWithDestructuringDeclarations(functionDescriptor, z2 ? null : valueParameterDescriptor, valueParameterDescriptor.getIndex(), valueParameterDescriptor.getAnnotations(), valueParameterDescriptor.getName(), kotlinTypeSubstitute, valueParameterDescriptor.declaresDefaultValue(), valueParameterDescriptor.isCrossinline(), valueParameterDescriptor.isNoinline(), kotlinTypeSubstitute2, z3 ? valueParameterDescriptor.getSource() : SourceElement.a, valueParameterDescriptor instanceof ValueParameterDescriptorImpl.b ? new b(((ValueParameterDescriptorImpl.b) valueParameterDescriptor).getDestructuringVariables()) : null));
            }
            return arrayList;
        }
        a(29);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = this.I;
        FunctionDescriptor original = functionDescriptor == this ? this : functionDescriptor.getOriginal();
        if (original != null) {
            return original;
        }
        a(18);
        throw null;
    }
}
