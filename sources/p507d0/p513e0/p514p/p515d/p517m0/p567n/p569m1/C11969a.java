package p507d0.p513e0.p514p.p515d.p517m0.p567n.p569m1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.m1.a */
/* JADX INFO: compiled from: ErrorSimpleFunctionDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11969a extends C11374g0 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.m1.a$a */
    /* JADX INFO: compiled from: ErrorSimpleFunctionDescriptorImpl.java */
    public class a implements InterfaceC11472x.a<InterfaceC11465t0> {
        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0030  */
        /* JADX WARN: Code duplicated, block: B:31:0x004e  */
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m10021a(int i) {
            String str;
            int i2;
            if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        i2 = 2;
                        break;
                    default:
                        i2 = 3;
                        break;
                }
            } else {
                i2 = 2;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                case 14:
                case 16:
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 30:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                    break;
                case 2:
                    objArr[0] = "modality";
                    break;
                case 4:
                    objArr[0] = "visibility";
                    break;
                case 6:
                    objArr[0] = "kind";
                    break;
                case 9:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 11:
                case 17:
                    objArr[0] = "parameters";
                    break;
                case 13:
                    objArr[0] = "substitution";
                    break;
                case 15:
                    objArr[0] = "userDataKey";
                    break;
                case 19:
                    objArr[0] = "type";
                    break;
                case 29:
                    objArr[0] = "additionalAnnotations";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i == 1) {
                objArr[1] = "setOwner";
            } else if (i == 3) {
                objArr[1] = "setModality";
            } else if (i == 5) {
                objArr[1] = "setVisibility";
            } else if (i == 10) {
                objArr[1] = "setName";
            } else if (i == 12) {
                objArr[1] = "setValueParameters";
            } else if (i == 14) {
                objArr[1] = "setSubstitution";
            } else if (i == 16) {
                objArr[1] = "putUserData";
            } else if (i == 18) {
                objArr[1] = "setTypeParameters";
            } else if (i == 30) {
                objArr[1] = "setAdditionalAnnotations";
            } else if (i == 7) {
                objArr[1] = "setKind";
            } else if (i != 8) {
                switch (i) {
                    case 20:
                        objArr[1] = "setReturnType";
                        break;
                    case 21:
                        objArr[1] = "setExtensionReceiverParameter";
                        break;
                    case 22:
                        objArr[1] = "setDispatchReceiverParameter";
                        break;
                    case 23:
                        objArr[1] = "setOriginal";
                        break;
                    case 24:
                        objArr[1] = "setSignatureChange";
                        break;
                    case 25:
                        objArr[1] = "setPreserveSourceElement";
                        break;
                    case 26:
                        objArr[1] = "setDropOriginalInContainingParts";
                        break;
                    case 27:
                        objArr[1] = "setHiddenToOvercomeSignatureClash";
                        break;
                    case 28:
                        objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                        break;
                }
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                case 14:
                case 16:
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 30:
                    break;
                case 2:
                    objArr[2] = "setModality";
                    break;
                case 4:
                    objArr[2] = "setVisibility";
                    break;
                case 6:
                    objArr[2] = "setKind";
                    break;
                case 9:
                    objArr[2] = "setName";
                    break;
                case 11:
                    objArr[2] = "setValueParameters";
                    break;
                case 13:
                    objArr[2] = "setSubstitution";
                    break;
                case 15:
                    objArr[2] = "putUserData";
                    break;
                case 17:
                    objArr[2] = "setTypeParameters";
                    break;
                case 19:
                    objArr[2] = "setReturnType";
                    break;
                case 29:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setAdditionalAnnotations(InterfaceC11344g interfaceC11344g) {
            if (interfaceC11344g != null) {
                return this;
            }
            m10021a(29);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setCopyOverrides(boolean z2) {
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setDispatchReceiverParameter(InterfaceC11459q0 interfaceC11459q0) {
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setDropOriginalInContainingParts() {
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setExtensionReceiverParameter(InterfaceC11459q0 interfaceC11459q0) {
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setHiddenForResolutionEverywhereBesideSupercalls() {
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setHiddenToOvercomeSignatureClash() {
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setKind(InterfaceC11321b.a aVar) {
            if (aVar != null) {
                return this;
            }
            m10021a(6);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setModality(EnumC11476z enumC11476z) {
            if (enumC11476z != null) {
                return this;
            }
            m10021a(2);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setName(C11716e c11716e) {
            if (c11716e != null) {
                return this;
            }
            m10021a(9);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setOriginal(InterfaceC11321b interfaceC11321b) {
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setOwner(InterfaceC11450m interfaceC11450m) {
            if (interfaceC11450m != null) {
                return this;
            }
            m10021a(0);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setPreserveSourceElement() {
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setReturnType(AbstractC11913c0 abstractC11913c0) {
            if (abstractC11913c0 != null) {
                return this;
            }
            m10021a(19);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setSignatureChange() {
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setSubstitution(AbstractC12018z0 abstractC12018z0) {
            if (abstractC12018z0 != null) {
                return this;
            }
            m10021a(13);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setTypeParameters(List<InterfaceC11477z0> list) {
            if (list != null) {
                return this;
            }
            m10021a(17);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setValueParameters(List<InterfaceC11326c1> list) {
            if (list != null) {
                return this;
            }
            m10021a(11);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11472x.a<InterfaceC11465t0> setVisibility(AbstractC11466u abstractC11466u) {
            if (abstractC11466u != null) {
                return this;
            }
            m10021a(4);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x.a
        public InterfaceC11465t0 build() {
            return C11969a.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11969a(InterfaceC11330e interfaceC11330e, C12005t.d dVar) {
        super(interfaceC11330e, null, InterfaceC11344g.f22735f.getEMPTY(), C11716e.special("<ERROR FUNCTION>"), InterfaceC11321b.a.DECLARATION, InterfaceC11467u0.f23099a);
        if (interfaceC11330e == null) {
            m10020a(0);
            throw null;
        }
        if (dVar != null) {
        } else {
            m10020a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m10020a(int i) {
        String str = (i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "ownerScope";
                break;
            case 2:
                objArr[0] = "newOwner";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "annotations";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
            case 8:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 6) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 6:
            case 7:
                break;
            case 8:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    /* JADX INFO: renamed from: b */
    public AbstractC11391q mo9373b(InterfaceC11450m interfaceC11450m, InterfaceC11472x interfaceC11472x, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11344g interfaceC11344g, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11450m == null) {
            m10020a(2);
            throw null;
        }
        if (aVar == null) {
            m10020a(3);
            throw null;
        }
        if (interfaceC11344g != null) {
            return this;
        }
        m10020a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b
    public InterfaceC11465t0 copy(InterfaceC11450m interfaceC11450m, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, InterfaceC11321b.a aVar, boolean z2) {
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public <V> V getUserData(InterfaceC11318a.a<V> aVar) {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isSuspend() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0
    public InterfaceC11472x.a<? extends InterfaceC11465t0> newCopyBuilder() {
        return new a();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b
    public void setOverriddenDescriptors(Collection<? extends InterfaceC11321b> collection) {
        if (collection != null) {
            return;
        }
        m10020a(8);
        throw null;
    }
}
