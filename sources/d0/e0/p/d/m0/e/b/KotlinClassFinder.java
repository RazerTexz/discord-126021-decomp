package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.l.b.KotlinMetadataFinder;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n, reason: use source file name */
/* JADX INFO: compiled from: KotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n$a */
    /* JADX INFO: compiled from: KotlinClassFinder.kt */
    public static abstract class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KotlinClassFinder.kt */
        public static final class C0390a extends a {
            public final byte[] getContent() {
                return null;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n$a$b */
        /* JADX INFO: compiled from: KotlinClassFinder.kt */
        public static final class b extends a {
            public final KotlinJvmBinaryClass a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr) {
                super(null);
                Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.a = kotlinJvmBinaryClass;
            }

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.a;
            }

            public /* synthetic */ b(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(kotlinJvmBinaryClass, (i & 2) != 0 ? null : bArr);
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar == null) {
                return null;
            }
            return bVar.getKotlinJvmBinaryClass();
        }
    }

    a findKotlinClassOrContent(d0.e0.p.d.m0.e.a.k0.g gVar);

    a findKotlinClassOrContent(ClassId classId);
}
