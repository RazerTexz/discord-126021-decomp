package b.i.c.m.d.s.h;

/* JADX INFO: renamed from: b.i.c.m.d.s.h.f, reason: use source file name */
/* JADX INFO: compiled from: SettingsData.java */
/* JADX INFO: loaded from: classes3.dex */
public class SettingsData implements Settings2 {
    public final AppSettingsData a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SessionSettingsData f1750b;
    public final FeaturesSettingsData c;
    public final long d;

    public SettingsData(long j, AppSettingsData appSettingsData, SessionSettingsData sessionSettingsData, FeaturesSettingsData featuresSettingsData, int i, int i2) {
        this.d = j;
        this.a = appSettingsData;
        this.f1750b = sessionSettingsData;
        this.c = featuresSettingsData;
    }

    @Override // b.i.c.m.d.s.h.Settings2
    public FeaturesSettingsData a() {
        return this.c;
    }

    @Override // b.i.c.m.d.s.h.Settings2
    public SessionSettingsData b() {
        return this.f1750b;
    }
}
