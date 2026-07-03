package p507d0.p513e0.p514p.p515d.p517m0.p576p;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.d */
/* JADX INFO: compiled from: functions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12036d {

    /* JADX INFO: renamed from: a */
    public static final Function1<Object, Boolean> f24973a;

    /* JADX INFO: renamed from: b */
    public static final Function3<Object, Object, Object, Unit> f24974b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.d$a */
    /* JADX INFO: compiled from: functions.kt */
    public static final class a extends AbstractC12240o implements Function1 {

        /* JADX INFO: renamed from: j */
        public static final a f24975j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.d$b */
    /* JADX INFO: compiled from: functions.kt */
    public static final class b extends AbstractC12240o implements Function1<Object, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final b f24976j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2(obj));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Object obj) {
            return true;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.d$c */
    /* JADX INFO: compiled from: functions.kt */
    public static final class c extends AbstractC12240o implements Function1<Object, Unit> {

        /* JADX INFO: renamed from: j */
        public static final c f24977j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.d$d */
    /* JADX INFO: compiled from: functions.kt */
    public static final class d extends AbstractC12240o implements Function2<Object, Object, Unit> {

        /* JADX INFO: renamed from: j */
        public static final d f24978j = new d();

        public d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
            invoke2(obj, obj2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj, Object obj2) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.d$e */
    /* JADX INFO: compiled from: functions.kt */
    public static final class e extends AbstractC12240o implements Function3<Object, Object, Object, Unit> {

        /* JADX INFO: renamed from: j */
        public static final e f24979j = new e();

        public e() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2, Object obj3) {
            invoke2(obj, obj2, obj3);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj, Object obj2, Object obj3) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.d$f */
    /* JADX INFO: compiled from: functions.kt */
    public static final class f extends AbstractC12240o implements Function1<Object, Object> {

        /* JADX INFO: renamed from: j */
        public static final f f24980j = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return obj;
        }
    }

    static {
        f fVar = f.f24980j;
        f24973a = b.f24976j;
        a aVar = a.f24975j;
        c cVar = c.f24977j;
        d dVar = d.f24978j;
        f24974b = e.f24979j;
    }

    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return (Function1<T, Boolean>) f24973a;
    }

    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return f24974b;
    }
}
