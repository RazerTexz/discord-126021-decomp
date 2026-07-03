package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11883s;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n */
/* JADX INFO: compiled from: KotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11653n extends InterfaceC11883s {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n$a */
    /* JADX INFO: compiled from: KotlinClassFinder.kt */
    public static abstract class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KotlinClassFinder.kt */
        public static final class C13316a extends a {
            public final byte[] getContent() {
                return null;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n$a$b */
        /* JADX INFO: compiled from: KotlinClassFinder.kt */
        public static final class b extends a {

            /* JADX INFO: renamed from: a */
            public final InterfaceC11655p f23630a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InterfaceC11655p interfaceC11655p, byte[] bArr) {
                super(null);
                C12238m.checkNotNullParameter(interfaceC11655p, "kotlinJvmBinaryClass");
                this.f23630a = interfaceC11655p;
            }

            public final InterfaceC11655p getKotlinJvmBinaryClass() {
                return this.f23630a;
            }

            public /* synthetic */ b(InterfaceC11655p interfaceC11655p, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(interfaceC11655p, (i & 2) != 0 ? null : bArr);
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final InterfaceC11655p toKotlinJvmBinaryClass() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar == null) {
                return null;
            }
            return bVar.getKotlinJvmBinaryClass();
        }
    }

    a findKotlinClassOrContent(InterfaceC11574g interfaceC11574g);

    a findKotlinClassOrContent(C11712a c11712a);
}
