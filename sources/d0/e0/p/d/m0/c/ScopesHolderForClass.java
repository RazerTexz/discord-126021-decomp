package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.r0, reason: use source file name */
/* JADX INFO: compiled from: ScopesHolderForClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ScopesHolderForClass<T extends MemberScope3> {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3299b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    public final ClassDescriptor c;
    public final Function1<KotlinTypeRefiner, T> d;
    public final KotlinTypeRefiner e;
    public final storage5 f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.r0$a */
    /* JADX INFO: compiled from: ScopesHolderForClass.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T extends MemberScope3> ScopesHolderForClass<T> create(ClassDescriptor classDescriptor, StorageManager storageManager, KotlinTypeRefiner kotlinTypeRefiner, Function1<? super KotlinTypeRefiner, ? extends T> function1) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefinerForOwnerModule");
            Intrinsics3.checkNotNullParameter(function1, "scopeFactory");
            return new ScopesHolderForClass<>(classDescriptor, storageManager, function1, kotlinTypeRefiner, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.r0$b */
    /* JADX INFO: compiled from: ScopesHolderForClass.kt */
    public static final class b extends Lambda implements Function0<T> {
        public final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
        public final /* synthetic */ ScopesHolderForClass<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ScopesHolderForClass<T> scopesHolderForClass, KotlinTypeRefiner kotlinTypeRefiner) {
            super(0);
            this.this$0 = scopesHolderForClass;
            this.$kotlinTypeRefiner = kotlinTypeRefiner;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return (T) this.this$0.d.invoke(this.$kotlinTypeRefiner);
        }
    }

    public ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1 function1, KotlinTypeRefiner kotlinTypeRefiner, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = classDescriptor;
        this.d = function1;
        this.e = kotlinTypeRefiner;
        this.f = storageManager.createLazyValue(new ScopesHolderForClass2(this));
    }

    public final T getScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.isRefinementNeededForModule(DescriptorUtils2.getModule(this.c))) {
            return (T) storage7.getValue(this.f, this, (KProperty<?>) f3299b[0]);
        }
        TypeConstructor typeConstructor = this.c.getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "classDescriptor.typeConstructor");
        return !kotlinTypeRefiner.isRefinementNeededForTypeConstructor(typeConstructor) ? (T) storage7.getValue(this.f, this, (KProperty<?>) f3299b[0]) : (T) kotlinTypeRefiner.getOrPutScopeForClass(this.c, new b(this, kotlinTypeRefiner));
    }
}
