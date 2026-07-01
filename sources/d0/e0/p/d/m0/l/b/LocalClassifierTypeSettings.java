package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.n.KotlinType4;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.t, reason: use source file name */
/* JADX INFO: compiled from: LocalClassifierTypeSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface LocalClassifierTypeSettings {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.t$a */
    /* JADX INFO: compiled from: LocalClassifierTypeSettings.kt */
    public static final class a implements LocalClassifierTypeSettings {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.l.b.LocalClassifierTypeSettings
        public KotlinType4 getReplacementTypeForLocalClassifiers() {
            return null;
        }
    }

    KotlinType4 getReplacementTypeForLocalClassifiers();
}
