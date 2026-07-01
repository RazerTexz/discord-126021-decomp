package d0.e0.p.d.m0.c.i1;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.SupertypeLoopChecker;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.LazyScopeAdapter;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.a0.TypeIntersectionScope;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.n.AbstractTypeConstructor;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.Variance;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f, reason: use source file name */
/* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractTypeParameterDescriptor extends DeclarationDescriptorNonRootImpl implements TypeParameterDescriptor {
    public final Variance n;
    public final boolean o;
    public final int p;
    public final storage5<TypeConstructor> q;
    public final storage5<KotlinType4> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final StorageManager f3264s;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f$a */
    /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
    public class a implements Function0<TypeConstructor> {
        public final /* synthetic */ StorageManager j;
        public final /* synthetic */ SupertypeLoopChecker k;

        public a(StorageManager storageManager, SupertypeLoopChecker supertypeLoopChecker) {
            this.j = storageManager;
            this.k = supertypeLoopChecker;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public TypeConstructor invoke() {
            return new c(AbstractTypeParameterDescriptor.this, this.j, this.k);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f$b */
    /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
    public class b implements Function0<KotlinType4> {
        public final /* synthetic */ Name j;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f$b$a */
        /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
        public class a implements Function0<MemberScope3> {
            public a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public MemberScope3 invoke() {
                StringBuilder sbU = outline.U("Scope for type parameter ");
                sbU.append(b.this.j.asString());
                return TypeIntersectionScope.create(sbU.toString(), AbstractTypeParameterDescriptor.this.getUpperBounds());
            }
        }

        public b(Name name) {
            this.j = name;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public KotlinType4 invoke() {
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations4.f.getEMPTY(), AbstractTypeParameterDescriptor.this.getTypeConstructor(), Collections.emptyList(), false, new LazyScopeAdapter(new a()));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f$c */
    /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
    public class c extends AbstractTypeConstructor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SupertypeLoopChecker f3265b;
        public final /* synthetic */ AbstractTypeParameterDescriptor c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbstractTypeParameterDescriptor abstractTypeParameterDescriptor, StorageManager storageManager, SupertypeLoopChecker supertypeLoopChecker) {
            super(storageManager);
            if (storageManager == null) {
                g(0);
                throw null;
            }
            this.c = abstractTypeParameterDescriptor;
            this.f3265b = supertypeLoopChecker;
        }

        public static /* synthetic */ void g(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
        public Collection<KotlinType> a() {
            List<KotlinType> listD = this.c.d();
            if (listD != null) {
                return listD;
            }
            g(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
        public KotlinType b() {
            return ErrorUtils.createErrorType("Cyclic upper bounds");
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
        public SupertypeLoopChecker d() {
            SupertypeLoopChecker supertypeLoopChecker = this.f3265b;
            if (supertypeLoopChecker != null) {
                return supertypeLoopChecker;
            }
            g(5);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
        public List<KotlinType> e(List<KotlinType> list) {
            if (list == null) {
                g(7);
                throw null;
            }
            List<KotlinType> listB = this.c.b(list);
            if (listB != null) {
                return listB;
            }
            g(8);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
        public void f(KotlinType kotlinType) {
            if (kotlinType != null) {
                this.c.c(kotlinType);
            } else {
                g(6);
                throw null;
            }
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = DescriptorUtils2.getBuiltIns(this.c);
            if (builtIns != null) {
                return builtIns;
            }
            g(4);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor, d0.e0.p.d.m0.n.TypeConstructor
        public ClassifierDescriptor getDeclarationDescriptor() {
            AbstractTypeParameterDescriptor abstractTypeParameterDescriptor = this.c;
            if (abstractTypeParameterDescriptor != null) {
                return abstractTypeParameterDescriptor;
            }
            g(3);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> listEmptyList = Collections.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            g(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            return this.c.getName().toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeParameterDescriptor(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Name name, Variance variance, boolean z2, int i, SourceElement sourceElement, SupertypeLoopChecker supertypeLoopChecker) {
        super(declarationDescriptor, annotations4, name, sourceElement);
        if (storageManager == null) {
            a(0);
            throw null;
        }
        if (declarationDescriptor == null) {
            a(1);
            throw null;
        }
        if (annotations4 == null) {
            a(2);
            throw null;
        }
        if (name == null) {
            a(3);
            throw null;
        }
        if (variance == null) {
            a(4);
            throw null;
        }
        if (sourceElement == null) {
            a(5);
            throw null;
        }
        if (supertypeLoopChecker == null) {
            a(6);
            throw null;
        }
        this.n = variance;
        this.o = z2;
        this.p = i;
        this.q = storageManager.createLazyValue(new a(storageManager, supertypeLoopChecker));
        this.r = storageManager.createLazyValue(new b(name));
        this.f3264s = storageManager;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitTypeParameterDescriptor(this, d);
    }

    public List<KotlinType> b(List<KotlinType> list) {
        if (list == null) {
            a(12);
            throw null;
        }
        if (list != null) {
            return list;
        }
        a(13);
        throw null;
    }

    public abstract void c(KotlinType kotlinType);

    public abstract List<KotlinType> d();

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
    public KotlinType4 getDefaultType() {
        KotlinType4 kotlinType4Invoke = this.r.invoke();
        if (kotlinType4Invoke != null) {
            return kotlinType4Invoke;
        }
        a(10);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public int getIndex() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public StorageManager getStorageManager() {
        StorageManager storageManager = this.f3264s;
        if (storageManager != null) {
            return storageManager;
        }
        a(14);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor, d0.e0.p.d.m0.c.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructorInvoke = this.q.invoke();
        if (typeConstructorInvoke != null) {
            return typeConstructorInvoke;
        }
        a(9);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public List<KotlinType> getUpperBounds() {
        List<KotlinType> supertypes = ((c) getTypeConstructor()).getSupertypes();
        if (supertypes != null) {
            return supertypes;
        }
        a(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public Variance getVariance() {
        Variance variance = this.n;
        if (variance != null) {
            return variance;
        }
        a(7);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public boolean isReified() {
        return this.o;
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl, d0.e0.p.d.m0.c.DeclarationDescriptor
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) super.getOriginal();
        if (typeParameterDescriptor != null) {
            return typeParameterDescriptor;
        }
        a(11);
        throw null;
    }
}
