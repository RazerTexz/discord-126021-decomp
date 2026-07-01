package b.i.c.m.d;

import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: renamed from: b.i.c.m.d.c, reason: use source file name */
/* JADX INFO: compiled from: MissingNativeComponent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MissingNativeComponent implements CrashlyticsNativeComponent {
    public static final NativeSessionFileProvider a = new b(null);

    /* JADX INFO: renamed from: b.i.c.m.d.c$b */
    /* JADX INFO: compiled from: MissingNativeComponent.java */
    public static final class b implements NativeSessionFileProvider {
        public b(a aVar) {
        }

        @Override // b.i.c.m.d.NativeSessionFileProvider
        public File a() {
            return null;
        }

        @Override // b.i.c.m.d.NativeSessionFileProvider
        public File b() {
            return null;
        }

        @Override // b.i.c.m.d.NativeSessionFileProvider
        public File c() {
            return null;
        }

        @Override // b.i.c.m.d.NativeSessionFileProvider
        public File d() {
            return null;
        }

        @Override // b.i.c.m.d.NativeSessionFileProvider
        public File e() {
            return null;
        }

        @Override // b.i.c.m.d.NativeSessionFileProvider
        public File f() {
            return null;
        }
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public boolean a(@NonNull String str) {
        return true;
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    @NonNull
    public NativeSessionFileProvider b(@NonNull String str) {
        return a;
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public void c(@NonNull String str, int i, @NonNull String str2, int i2, long j, long j2, boolean z2, int i3, @NonNull String str3, @NonNull String str4) {
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public void d(@NonNull String str, @NonNull String str2, long j) {
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public boolean e(@NonNull String str) {
        return false;
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public void f(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i, @NonNull String str6) {
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public void g(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2) {
    }

    @Override // b.i.c.m.d.CrashlyticsNativeComponent
    public boolean h(@NonNull String str) {
        return true;
    }
}
