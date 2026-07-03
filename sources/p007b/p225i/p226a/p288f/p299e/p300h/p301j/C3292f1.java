package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p313h.p320g.HandlerC3484d;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.f1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3292f1 extends Fragment implements InterfaceC3299j {

    /* JADX INFO: renamed from: j */
    public static final WeakHashMap<FragmentActivity, WeakReference<C3292f1>> f9372j = new WeakHashMap<>();

    /* JADX INFO: renamed from: k */
    public final Map<String, LifecycleCallback> f9373k = Collections.synchronizedMap(new ArrayMap());

    /* JADX INFO: renamed from: l */
    public int f9374l = 0;

    /* JADX INFO: renamed from: m */
    @Nullable
    public Bundle f9375m;

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3299j
    /* JADX INFO: renamed from: a */
    public final void mo4069a(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (this.f9373k.containsKey(str)) {
            throw new IllegalArgumentException(C1643a.m823K(new StringBuilder(str.length() + 59), "LifecycleCallback with tag ", str, " already added to this fragment."));
        }
        this.f9373k.put(str, lifecycleCallback);
        if (this.f9374l > 0) {
            new HandlerC3484d(Looper.getMainLooper()).post(new RunnableC3289e1(this, lifecycleCallback, str));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3299j
    @Nullable
    /* JADX INFO: renamed from: d */
    public final <T extends LifecycleCallback> T mo4070d(String str, Class<T> cls) {
        return cls.cast(this.f9373k.get(str));
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<LifecycleCallback> it = this.f9373k.values().iterator();
        while (it.hasNext()) {
            it.next().m9039a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<LifecycleCallback> it = this.f9373k.values().iterator();
        while (it.hasNext()) {
            it.next().mo4115d(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f9374l = 1;
        this.f9375m = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f9373k.entrySet()) {
            entry.getValue().mo4116e(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f9374l = 5;
        Iterator<LifecycleCallback> it = this.f9373k.values().iterator();
        while (it.hasNext()) {
            it.next().mo4063f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f9374l = 3;
        Iterator<LifecycleCallback> it = this.f9373k.values().iterator();
        while (it.hasNext()) {
            it.next().mo4058g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f9373k.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().mo4117h(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f9374l = 2;
        Iterator<LifecycleCallback> it = this.f9373k.values().iterator();
        while (it.hasNext()) {
            it.next().mo4059i();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f9374l = 4;
        Iterator<LifecycleCallback> it = this.f9373k.values().iterator();
        while (it.hasNext()) {
            it.next().mo4060j();
        }
    }
}
