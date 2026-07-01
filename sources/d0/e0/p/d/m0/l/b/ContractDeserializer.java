package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.z.d.Intrinsics3;
import kotlin.Tuples2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.i, reason: use source file name */
/* JADX INFO: compiled from: ContractDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ContractDeserializer {
    public static final a a = a.a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.i$a */
    /* JADX INFO: compiled from: ContractDeserializer.kt */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ContractDeserializer f3502b = new C0410a();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ContractDeserializer.kt */
        public static final class C0410a implements ContractDeserializer {
            @Override // d0.e0.p.d.m0.l.b.ContractDeserializer
            public Tuples2 deserializeContractFromFunction(d0.e0.p.d.m0.f.i iVar, FunctionDescriptor functionDescriptor, TypeTable typeTable, TypeDeserializer typeDeserializer) {
                Intrinsics3.checkNotNullParameter(iVar, "proto");
                Intrinsics3.checkNotNullParameter(functionDescriptor, "ownerFunction");
                Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
                Intrinsics3.checkNotNullParameter(typeDeserializer, "typeDeserializer");
                return null;
            }
        }

        public final ContractDeserializer getDEFAULT() {
            return f3502b;
        }
    }

    Tuples2<CallableDescriptor.a<?>, Object> deserializeContractFromFunction(d0.e0.p.d.m0.f.i iVar, FunctionDescriptor functionDescriptor, TypeTable typeTable, TypeDeserializer typeDeserializer);
}
