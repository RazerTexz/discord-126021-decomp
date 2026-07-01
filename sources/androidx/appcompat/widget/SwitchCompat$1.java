package androidx.appcompat.widget;

import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat$1 extends Property<SwitchCompat, Float> {
    public SwitchCompat$1(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(SwitchCompat switchCompat) {
        return get2(switchCompat);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(SwitchCompat switchCompat, Float f) {
        set2(switchCompat, f);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Float get2(SwitchCompat switchCompat) {
        return Float.valueOf(switchCompat.mThumbPosition);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(SwitchCompat switchCompat, Float f) {
        switchCompat.setThumbPosition(f.floatValue());
    }
}
