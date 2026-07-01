package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.a0.InnerClassesScopeWrapper;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.a0.SubstitutingScope;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeSubstitution5;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractClassDescriptor extends ModuleAwareClassDescriptor {
    public final Name k;
    public final storage5<KotlinType4> l;
    public final storage5<MemberScope3> m;
    public final storage5<ReceiverParameterDescriptor> n;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.a$a */
    /* JADX INFO: compiled from: AbstractClassDescriptor.java */
    public class a implements Function0<KotlinType4> {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractClassDescriptor.java */
        public class C0380a implements Function1<KotlinTypeRefiner, KotlinType4> {
            public C0380a() {
            }

            @Override // kotlin.jvm.functions.Function1
            public KotlinType4 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
                ClassifierDescriptor classifierDescriptorRefineDescriptor = kotlinTypeRefiner.refineDescriptor(AbstractClassDescriptor.this);
                if (classifierDescriptorRefineDescriptor == null) {
                    return AbstractClassDescriptor.this.l.invoke();
                }
                if (classifierDescriptorRefineDescriptor instanceof TypeAliasDescriptor) {
                    return KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) classifierDescriptorRefineDescriptor, TypeUtils.getDefaultTypeProjections(classifierDescriptorRefineDescriptor.getTypeConstructor().getParameters()));
                }
                return classifierDescriptorRefineDescriptor instanceof ModuleAwareClassDescriptor ? TypeUtils.makeUnsubstitutedType(classifierDescriptorRefineDescriptor.getTypeConstructor().refine(kotlinTypeRefiner), ((ModuleAwareClassDescriptor) classifierDescriptorRefineDescriptor).getUnsubstitutedMemberScope(kotlinTypeRefiner), this) : classifierDescriptorRefineDescriptor.getDefaultType();
            }
        }

        public a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public KotlinType4 invoke() {
            AbstractClassDescriptor abstractClassDescriptor = AbstractClassDescriptor.this;
            return TypeUtils.makeUnsubstitutedType(abstractClassDescriptor, abstractClassDescriptor.getUnsubstitutedMemberScope(), new C0380a());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.a$b */
    /* JADX INFO: compiled from: AbstractClassDescriptor.java */
    public class b implements Function0<MemberScope3> {
        public b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public MemberScope3 invoke() {
            return new InnerClassesScopeWrapper(AbstractClassDescriptor.this.getUnsubstitutedMemberScope());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.a$c */
    /* JADX INFO: compiled from: AbstractClassDescriptor.java */
    public class c implements Function0<ReceiverParameterDescriptor> {
        public c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public ReceiverParameterDescriptor invoke() {
            return new LazyClassReceiverParameterDescriptor(AbstractClassDescriptor.this);
        }
    }

    public AbstractClassDescriptor(StorageManager storageManager, Name name) {
        if (storageManager == null) {
            a(0);
            throw null;
        }
        if (name == null) {
            a(1);
            throw null;
        }
        this.k = name;
        this.l = storageManager.createLazyValue(new a());
        this.m = storageManager.createLazyValue(new b());
        this.n = storageManager.createLazyValue(new c());
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i == 8 || i == 11 || i == 13 || i == 15) {
            objArr[1] = "getMemberScope";
        } else if (i == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i == 18) {
            objArr[1] = "substitute";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 4 && i != 5 && i != 8 && i != 11 && i != 13 && i != 15 && i != 16 && i != 18 && i != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.ClassifierDescriptor
    public KotlinType4 getDefaultType() {
        KotlinType4 kotlinType4Invoke = this.l.invoke();
        if (kotlinType4Invoke != null) {
            return kotlinType4Invoke;
        }
        a(19);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.ModuleAwareClassDescriptor
    public MemberScope3 getMemberScope(TypeSubstitution5 typeSubstitution5, KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution5 == null) {
            a(9);
            throw null;
        }
        if (kotlinTypeRefiner == null) {
            a(10);
            throw null;
        }
        if (!typeSubstitution5.isEmpty()) {
            return new SubstitutingScope(getUnsubstitutedMemberScope(kotlinTypeRefiner), TypeSubstitutor2.create(typeSubstitution5));
        }
        MemberScope3 unsubstitutedMemberScope = getUnsubstitutedMemberScope(kotlinTypeRefiner);
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        a(11);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public Name getName() {
        Name name = this.k;
        if (name != null) {
            return name;
        }
        a(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public ClassDescriptor getOriginal() {
        return this;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        ReceiverParameterDescriptor receiverParameterDescriptorInvoke = this.n.invoke();
        if (receiverParameterDescriptorInvoke != null) {
            return receiverParameterDescriptorInvoke;
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScope3 getUnsubstitutedInnerClassesScope() {
        MemberScope3 memberScope3Invoke = this.m.invoke();
        if (memberScope3Invoke != null) {
            return memberScope3Invoke;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope() {
        MemberScope3 unsubstitutedMemberScope = getUnsubstitutedMemberScope(DescriptorUtils2.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        a(16);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            return typeSubstitutor2.isEmpty() ? this : new LazySubstitutingClassDescriptor(this, typeSubstitutor2);
        }
        a(17);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScope3 getMemberScope(TypeSubstitution5 typeSubstitution5) {
        if (typeSubstitution5 != null) {
            MemberScope3 memberScope = getMemberScope(typeSubstitution5, DescriptorUtils2.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
            if (memberScope != null) {
                return memberScope;
            }
            a(15);
            throw null;
        }
        a(14);
        throw null;
    }
}
